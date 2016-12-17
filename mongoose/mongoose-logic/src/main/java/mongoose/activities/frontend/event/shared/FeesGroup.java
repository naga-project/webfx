package mongoose.activities.frontend.event.shared;

import mongoose.activities.shared.highlevelcomponents.HighLevelComponents;
import mongoose.activities.shared.logic.preselection.OptionsPreselection;
import mongoose.entities.Event;
import mongoose.entities.Label;
import mongoose.services.EventService;
import mongoose.util.Labels;
import naga.commons.type.PrimType;
import naga.commons.util.Numbers;
import naga.commons.util.Objects;
import naga.commons.util.async.Handler;
import naga.commons.util.tuples.Pair;
import naga.framework.ui.i18n.I18n;
import naga.toolkit.display.*;
import naga.toolkit.fx.ext.cell.collator.NodeCollatorRegistry;
import naga.toolkit.fx.ext.cell.renderer.TextRenderer;
import naga.toolkit.fx.geometry.Pos;
import naga.toolkit.fx.scene.control.Button;
import naga.toolkit.fx.scene.image.ImageView;
import naga.toolkit.fx.scene.layout.HBox;

/**
 * @author Bruno Salmon
 */
public class FeesGroup {
    private final Event event;
    private final Object id;
    private final Label label;
    private final Label feesBottomLabel;
    private final Label feesPopupLabel;
    private final boolean forceSoldout;
    private final OptionsPreselection[] optionsPreselections;

    FeesGroup(Event event, Object id, Label label, Label feesBottomLabel, Label feesPopupLabel, boolean forceSoldout, OptionsPreselection[] optionsPreselections) {
        this.event = event;
        this.id = id;
        this.label = label;
        this.feesBottomLabel = feesBottomLabel;
        this.feesPopupLabel = feesPopupLabel;
        this.forceSoldout = forceSoldout;
        this.optionsPreselections = optionsPreselections;
    }

    public Object getId() {
        return id;
    }

    public Label getLabel() {
        return label;
    }

    public Label getFeesBottomLabel() {
        return feesBottomLabel;
    }

    public Label getFeesPopupLabel() {
        return feesPopupLabel;
    }

    public boolean isForceSoldout() {
        return forceSoldout;
    }

    public OptionsPreselection[] getOptionsPreselections() {
        return optionsPreselections;
    }

    public String getDisplayName(I18n i18n) {
        return Labels.instantTranslateLabel(label, i18n, "Fees");
    }

    public String getDisplayName(Object language) {
        return Labels.instantTranslateLabel(label, language);
    }

    public DisplayResultSet generateDisplayResultSet(I18n i18n, EventService eventService, Handler<OptionsPreselection> bookHandler) {
        boolean showBadges = Objects.areEquals(eventService.getEvent().getOrganizationId().getPrimaryKey(), 2); // For now only showing badges on KMCF courses
        int optionsCount = optionsPreselections.length;
        boolean singleOption = optionsCount == 1;
        DisplayResultSetBuilder rsb = DisplayResultSetBuilder.create(optionsCount, new DisplayColumn[]{
                DisplayColumn.create(i18n.instantTranslate(singleOption ? "Course" : "Accommodation"), PrimType.STRING),
                DisplayColumn.create(i18n.instantTranslate("Fee"), PrimType.INTEGER, DisplayStyle.CENTER_STYLE),
                DisplayColumnBuilder.create(i18n.instantTranslate("Availability")).setStyle(DisplayStyle.CENTER_STYLE)
                        .setFxValueRenderer(p -> {
                            Pair<Object, OptionsPreselection> pair = (Pair<Object, OptionsPreselection>) p;
                            if (pair == null || !eventService.areEventAvailabilitiesLoaded())
                                return ImageView.create("images/16/spinner.gif");
                            Object availability = pair.get1();
                            OptionsPreselection optionsPreselection = pair.get2();
                            // Availability is null when there is no online room at all. In this case...
                            if (availability == null && optionsPreselection.hasAccommodationExcludingSharing()) // ... if it's an accommodation option (but not just sharing)
                                availability = 0; // we show it as soldout - otherwise (if it's a sharing option or no accommodation) we show it as available
                            boolean soldout = availability != null && Numbers.doubleValue(availability) <= 0 || // Showing soldout if the availability is zero
                                    optionsPreselection.isForceSoldout() || // or if the option has been forced as soldout in the backend
                                    isForceSoldout(); // or if the whole FeesGroup has been forced as soldout
                            if (soldout)
                                return i18n.instantTranslateText(HighLevelComponents.createSoldoutButton(), "Soldout");
                            Button button = i18n.instantTranslateText(HighLevelComponents.createBookButton(), "Book");
                            button.setOnMouseClicked(e -> bookHandler.handle(optionsPreselection));
                            if (availability == null || !showBadges)
                                return button;
                            HBox hBox = (HBox) NodeCollatorRegistry.hBoxCollator().collateNodes(HighLevelComponents.createBadge(TextRenderer.SINGLETON.renderCellValue(availability)), button);
                            hBox.setAlignment(Pos.CENTER);
                            return hBox;
                        }).build()});
        int rowIndex = 0;
        for (OptionsPreselection optionsPreselection : optionsPreselections) {
            rsb.setValue(rowIndex,   0, singleOption ? /* Showing course name instead of 'NoAccommodation' when single line */ Labels.instantTranslateLabel(Objects.coalesce(label, Labels.bestLabelOrName(event)), i18n) : /* Otherwise showing accommodation type */ optionsPreselection.getDisplayName(i18n));
            rsb.setValue(rowIndex,   1, optionsPreselection.getDisplayPrice());
            rsb.setValue(rowIndex++, 2, new Pair<>(optionsPreselection.getDisplayAvailability(eventService), optionsPreselection));
        }
        return rsb.build();
    }

    public String getFeesBottomText(I18n i18n) {
        Label feesBottomLabel = Objects.coalesce(getFeesBottomLabel(), event.getFeesBottomLabel());
        return Labels.instantTranslateLabel(feesBottomLabel, i18n, "FeesExplanation");
    }

    @Override
    public String toString() {
        return getDisplayName("en");
    }
}
