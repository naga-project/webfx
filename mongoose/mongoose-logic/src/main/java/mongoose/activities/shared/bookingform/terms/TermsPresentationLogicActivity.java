package mongoose.activities.shared.bookingform.terms;

import mongoose.activities.shared.bookingform.shared.BookingProcessPresentationLogicActivity;

/**
 * @author Bruno Salmon
 */
public class TermsPresentationLogicActivity extends BookingProcessPresentationLogicActivity<TermsPresentationModel> {

    public TermsPresentationLogicActivity() {
        super(TermsPresentationModel::new, null);
    }

    @Override
    protected void startLogic(TermsPresentationModel pm) {
        super.startLogic(pm);
        // Loading the domain model and setting up the reactive filter
        createReactiveExpressionFilter("{class: 'Letter', where: 'type.terms', limit: '1'}")
                .combine(pm.eventIdProperty(), e -> "{where: 'event=" + e + "'}")
                .combine(getI18n().languageProperty(), lang -> "{columns: '[`html(" + lang + ")`]'}")
                .displayResultSetInto(pm.termsLetterDisplayResultSetProperty())
                .start();
    }
}