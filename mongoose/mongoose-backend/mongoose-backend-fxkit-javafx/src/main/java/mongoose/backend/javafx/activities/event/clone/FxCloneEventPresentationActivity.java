package mongoose.backend.javafx.activities.event.clone;

import mongooses.core.activities.backend.cloneevent.CloneEventPresentationLogicActivity;
import mongooses.core.activities.backend.cloneevent.CloneEventPresentationModel;
import webfx.framework.activity.impl.combinations.domainpresentation.impl.DomainPresentationActivityImpl;

/**
 * @author Bruno Salmon
 */
final class FxCloneEventPresentationActivity extends DomainPresentationActivityImpl<CloneEventPresentationModel> {

    FxCloneEventPresentationActivity() {
        super(FxCloneEventPresentationViewActivity::new, CloneEventPresentationLogicActivity::new);
    }
}
