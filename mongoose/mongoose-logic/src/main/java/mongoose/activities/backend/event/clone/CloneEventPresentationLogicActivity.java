package mongoose.activities.backend.event.clone;

import mongoose.activities.shared.generic.EventDependentPresentationLogicActivity;
import mongoose.entities.Event;
import naga.fx.properties.Properties;

import java.time.LocalDate;

/**
 * @author Bruno Salmon
 */
public class CloneEventPresentationLogicActivity extends EventDependentPresentationLogicActivity<CloneEventPresentationModel> {

    public CloneEventPresentationLogicActivity() {
        super(CloneEventPresentationModel::new);
    }

    @Override
    protected void startLogic(CloneEventPresentationModel pm) {
        // Load and display fees groups now but also on event change
        Properties.runNowAndOnPropertiesChange(property -> {
            pm.setName(null);
            pm.setDate(null);
            onEventOptions().setHandler(ar -> {
                if (ar.succeeded()) {
                    Event event = getEvent();
                    pm.setName(event.getName());
                    pm.setDate(event.getStartDate());
                }
            });
        }, pm.eventIdProperty());

        pm.setOnSubmit(event -> {
            LocalDate startDate = pm.getDate();
            getHistory().push("/event/1/bookings");
/*
            Platform.getUpdateService().executeUpdate(new UpdateArgument("select copy_event(?,?,?)", new Object[]{getEventId(), pm.getName(), startDate}, true, getDataSourceModel().getId())).setHandler(ar -> {
                if (ar.succeeded())
                    getHistory().push("/event/" + ar.result().getGeneratedKeys()[0] + "/bookings");
            });
*/
        });
    }
}