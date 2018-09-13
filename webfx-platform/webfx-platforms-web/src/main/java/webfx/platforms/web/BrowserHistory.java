package webfx.platforms.web;

import webfx.platforms.core.services.browsinghistory.spi.BrowsingHistoryEvent;
import webfx.platforms.core.services.browsinghistory.spi.impl.MemoryBrowsingHistory;
import webfx.platforms.core.services.browsinghistory.spi.impl.BrowsingHistoryLocationImpl;
import webfx.platforms.core.services.json.JsonObject;
import webfx.platforms.core.services.log.Logger;
import webfx.platforms.core.services.uischeduler.UiScheduler;
import webfx.platforms.core.services.windowlocation.WindowLocation;
import webfx.platforms.core.services.windowlocation.spi.PathStateLocation;
import webfx.platforms.core.util.Objects;
import webfx.platforms.core.util.Strings;

/**
 * @author Bruno Salmon
 */
public class BrowserHistory extends MemoryBrowsingHistory {

    private final WindowHistory windowHistory;
    private final boolean supportsStates;
    private final boolean showHash;

    public BrowserHistory() {
        this(WindowHistory.get());
    }

    public BrowserHistory(WindowHistory windowHistory) {
        this.windowHistory = windowHistory;
        supportsStates = windowHistory.supportsStates();
        showHash = true; // !supportsState;
        //windowHistory.onBeforeUnload(event -> checkBeforeUnload(getCurrentLocation()));
        if (supportsStates)
            windowHistory.onPopState(this::onPopState);
        // Can't access the platform API at this stage since it is currently initializing, so the remaining
        // initialization will be done later in checkInitialized()
    }

    private void checkInitialized() {
        if (getMountPoint() == null) {
            String mountPath = WindowLocation.getPathname();
            if (mountPath.endsWith("/index.html"))
                mountPath = mountPath.substring(0, mountPath.lastIndexOf('/') + 1);
            setMountPoint(mountPath);
            onPopState(supportsStates ? windowHistory.state() : null);
            if (!supportsStates)
                UiScheduler.schedulePeriodic(500, () -> {
                    if (!Objects.areEquals(WindowLocation.getFragment(), getCurrentLocation().getFragment()))
                        onPopState(null);
                });
        }
    }

    @Override
    protected String fullToMountPath(String fullPath) {
        checkInitialized();
        String subPath = super.fullToMountPath(fullPath);
        subPath = Strings.removePrefix(subPath, "index.html");
        subPath = Strings.removePrefix(subPath, "#");
        return subPath;
    }

    @Override
    protected String mountToFullPath(String mountPath) {
        checkInitialized();
        if (showHash && !mountPath.startsWith("#"))
            mountPath = "#" + mountPath;
        return super.mountToFullPath(mountPath);
    }

    @Override
    public BrowsingHistoryLocationImpl getCurrentLocation() {
        checkInitialized();
        return super.getCurrentLocation();
    }

    private void onPopState(JsonObject state) {
        //Logger.log("Entering onPopState");
        // Transforming the current window location into a history location descriptor
        String path = fullToMountPath(WindowLocation.getPath());
        Logger.log("Pop state with path = " + path);
        PathStateLocation pathStateLocation = createPathStateLocation(path, state);
        BrowsingHistoryLocationImpl location;
        int p = locationStack.indexOf(pathStateLocation);
        //Logger.log("Index in stack: " + p);
        if (p != -1) {
            location = locationStack.get(p);
            location.setEvent(BrowsingHistoryEvent.POPPED);
            backOffset = p;
        } else
            super.doAcceptedPush(location = createHistoryLocation(pathStateLocation, BrowsingHistoryEvent.POPPED));
        // For any reason there is a performance issue with Chrome if we fire the location change now, so we defer it
        Runnable runnable = () -> fireLocationChanged(location);
        UiScheduler.scheduleDeferred(runnable);
        //Logger.log("Exiting onPopState");
    }

    @Override
    protected void doAcceptedPush(BrowsingHistoryLocationImpl historyLocation) {
        String path = historyLocation.getPath();
        if (supportsStates)
            windowHistory.pushState(historyLocation.getState(), null, path);
        else
            WindowLocation.assignHref(path);
        super.doAcceptedPush(historyLocation);
    }

    @Override
    protected void doAcceptedReplace(BrowsingHistoryLocationImpl historyLocation) {
        String path = historyLocation.getPath();
        if (supportsStates)
            windowHistory.replaceState(historyLocation.getState(), null, path);
        else
            WindowLocation.replaceHref(path);
        super.doAcceptedReplace(historyLocation);
    }

    @Override
    public void go(int offset) {
        windowHistory.go(offset);
        // super.go(offset); // Commented as this causes extra routing. TODO: find another way to synchronize the memory history
    }
}
