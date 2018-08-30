package mongoose.activities.backend.loadtester;

import naga.framework.activity.base.combinations.domainpresentation.impl.DomainPresentationActivityContextFinal;
import naga.framework.ui.uirouter.UiRoute;

/**
 * @author Bruno Salmon
 */
public final class LoadTesterRouting {

    private final static String PATH = "/load-tester";

    public static UiRoute<?> uiRoute() {
        return UiRoute.create(PATH
                , false
                , LoadTesterActivity::new
                , DomainPresentationActivityContextFinal::new
        );
    }

    public static String getPath() {
        return PATH;
    }
}