package mongooses.core.operations.backend.route;

import mongooses.core.activities.backend.letters.LettersRouting;
import webfx.framework.operation.HasOperationCode;
import webfx.framework.operations.route.RoutePushRequest;
import webfx.platforms.core.services.browsinghistory.spi.BrowsingHistory;

/**
 * @author Bruno Salmon
 */
public final class RouteToLettersRequest extends RoutePushRequest implements HasOperationCode {

    private final static String OPERATION_CODE = "RouteToLetters";

    public RouteToLettersRequest(Object eventId, BrowsingHistory history) {
        super(LettersRouting.getEventLettersPath(eventId), history);
    }

    @Override
    public Object getOperationCode() {
        return OPERATION_CODE;
    }
}
