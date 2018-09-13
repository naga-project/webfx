package webfx.framework.operations.route;

import webfx.platforms.core.services.browsinghistory.spi.BrowsingHistory;
import webfx.platforms.core.services.json.JsonObject;
import webfx.platforms.core.util.async.Future;

/**
 * @author Bruno Salmon
 */
final class RoutePushExecutor {

    static Future<Void> executePushRouteRequest(RoutePushRequest rq) {
        return execute(rq.getRoutePath(), rq.getHistory(), rq.getState());
    }

    private static Future<Void> execute(String routePath, BrowsingHistory history, JsonObject state) {
        if (routePath != null)
            history.push(routePath, state);
        return Future.succeededFuture();
    }
}
