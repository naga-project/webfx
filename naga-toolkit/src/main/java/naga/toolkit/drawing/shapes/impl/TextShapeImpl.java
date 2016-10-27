package naga.toolkit.drawing.shapes.impl;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import naga.toolkit.drawing.shapes.Font;
import naga.toolkit.drawing.shapes.TextShape;
import naga.toolkit.drawing.shapes.VPos;

/**
 * @author Bruno Salmon
 */
public class TextShapeImpl extends ShapeImpl implements TextShape {

    private final Property<Double> xProperty = new SimpleObjectProperty<>(0d);
    @Override
    public Property<Double> xProperty() {
        return xProperty;
    }

    private final Property<VPos> textOriginProperty = new SimpleObjectProperty<>(VPos.BASELINE);
    @Override
    public Property<VPos> textOriginProperty() {
        return textOriginProperty;
    }

    private final Property<Double> yProperty = new SimpleObjectProperty<>(0d);
    @Override
    public Property<Double> yProperty() {
        return yProperty;
    }

    private final Property<String> textProperty = new SimpleObjectProperty<>();
    @Override
    public Property<String> textProperty() {
        return textProperty;
    }

    private final Property<Font> fontProperty = new SimpleObjectProperty<>();
    @Override
    public Property<Font> fontProperty() {
        return fontProperty;
    }
}