package mongoose.backend.activities.bookings;

import mongoose.client.activities.generic.routing.MongooseRoutingUtil;
import webfx.framework.client.activity.impl.combinations.domainpresentation.impl.DomainPresentationActivityContextFinal;
import webfx.framework.shared.router.util.PathBuilder;
import webfx.framework.client.ui.uirouter.UiRoute;
import webfx.framework.client.ui.uirouter.impl.UiRouteImpl;

import java.time.LocalDate;

/**
 * @author Bruno Salmon
 */
public final class BookingsRouting {

    // Would be better but pb retrieving named groups doesn't work with JavaScript RegExp (can't retrieve groups): private final static String ANY_PATH = "/bookings(/organization/:organizationId|/event/:eventId|/day/:day|/arrivals|/departures|/minday/:minDay|/maxday/:maxDay|/filter/:filter|/groupby|:groupBy|/orderby/:orderBy/columns/:columns|export/:activityStateId)*";
    private final static String ANY_PATH = "/bookings(/organization/:organizationId)?(/event/:eventId)?(/day/:day)?(/arrivals)?(/departures)?(/minday/:minDay)?(/maxday/:maxDay)?(/filter/:filter)?(/groupby/:groupBy)?(/orderby/:orderBy)?(/columns/:columns)?(/export/:activityStateId)?";
    private final static String EVENT_PATH = "/bookings/event/:eventId";

    public static String getEventBookingsPath(Object eventId) {
        return MongooseRoutingUtil.interpolateEventIdInPath(eventId, EVENT_PATH);
    }

    static LocalDate parseDayParam(String parameterValue) {
        if (parameterValue == null)
            return null;
        switch (parameterValue) {
            case "yesterday" : return LocalDate.now().minusDays(1);
            case "today":      return LocalDate.now();
            case "tomorrow" :  return LocalDate.now().plusDays(1);
            default:           return LocalDate.parse(parameterValue); // Expecting an iso date (yyyy-MM-dd)
        }
    }

    public static UiRoute<?> uiRoute() {
        return UiRoute.createRegex(PathBuilder.toRegexPath(ANY_PATH)
                ,true
                , BookingsActivity::new
                , DomainPresentationActivityContextFinal::new
        );
    }

    public static final class ProvidedUiRoute extends UiRouteImpl {
        public ProvidedUiRoute() {
            super(uiRoute());
        }
    }

}
