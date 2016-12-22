package naga.toolkit.fx.properties.markers;

import javafx.beans.property.Property;
import naga.toolkit.fx.scene.shape.StrokeLineCap;

/**
 * @author Bruno Salmon
 */
public interface HasStrokeLineCapProperty {

    Property<StrokeLineCap> strokeLineCapProperty();
    default void setStrokeLineCap(StrokeLineCap strokeLineCap) {
        strokeLineCapProperty().setValue(strokeLineCap);
    }
    default StrokeLineCap getStrokeLineCap() {
        return strokeLineCapProperty().getValue();
    }
}