package webfx.fxkit.javafxgraphics.mapper.spi.impl.peer.markers;

import javafx.beans.property.DoubleProperty;

/**
 * @author Bruno Salmon
 */
public interface HasAngleProperty {

    DoubleProperty angleProperty();
    default void setAngle(Number angle) { angleProperty().setValue(angle); }
    default Double getAngle() { return angleProperty().getValue(); }

}