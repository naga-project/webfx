package mongoose.logic;

import mongoose.logic.cart.CartLogic;
import mongoose.logic.organizations.OrganizationsLogic;
import naga.core.ngui.routing.UiRouter;
import naga.core.spi.bus.client.WebSocketBusOptions;
import naga.core.spi.platform.Platform;

/**
 * @author Bruno Salmon
 */
public class MongooseLogic {

    public static void runFrontendApplication() {
        setUpRouter().defaultPath("/cart/a58faba5-5b0b-4573-b547-361e10c788dc").start();
    }

    public static void runBackendApplication() {
        setUpRouter().defaultPath("/organizations").start();
    }

    public static void setUpWebSocketConnection() { // Client side setting up
    }

    private static UiRouter setUpRouter() {
        return UiRouter.get()
                .route("/organizations", OrganizationsLogic.organizationsUiRouterHandler)
                .route("/cart/:cartUuid", CartLogic.cartUiRouterHandler);
    }

}
