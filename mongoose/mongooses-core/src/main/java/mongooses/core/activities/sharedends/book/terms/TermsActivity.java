package mongooses.core.activities.sharedends.book.terms;

import webfx.framework.activity.impl.combinations.domainpresentation.impl.DomainPresentationActivityImpl;

/**
 * @author Bruno Salmon
 */
final class TermsActivity extends DomainPresentationActivityImpl<TermsPresentationModel> {

    TermsActivity() {
        super(TermsPresentationViewActivity::new, TermsPresentationLogicActivity::new);
    }
}
