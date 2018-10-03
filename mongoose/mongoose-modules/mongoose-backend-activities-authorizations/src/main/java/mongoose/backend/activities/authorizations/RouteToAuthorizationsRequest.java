package mongoose.backend.activities.authorizations;


import webfx.framework.client.activity.impl.elementals.uiroute.UiRouteActivityContext;
import webfx.framework.shared.operation.HasOperationCode;
import webfx.framework.client.operations.route.RoutePushRequest;
import webfx.framework.client.operations.route.RouteRequestEmitter;
import webfx.framework.shared.router.auth.authz.RouteRequest;
import webfx.platform.client.services.windowhistory.spi.BrowsingHistory;

/**
 * @author Bruno Salmon
 */
public final class RouteToAuthorizationsRequest extends RoutePushRequest implements HasOperationCode {

    private final static String OPERATION_CODE = "RouteToAuthorizations";

    public RouteToAuthorizationsRequest(BrowsingHistory history) {
        super(AuthorizationsRouting.getPath(), history);
    }

    @Override
    public Object getOperationCode() {
        return OPERATION_CODE;
    }

    public static final class ProvidedEmitter implements RouteRequestEmitter {
        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToAuthorizationsRequest(context.getHistory());
        }
    }

}
