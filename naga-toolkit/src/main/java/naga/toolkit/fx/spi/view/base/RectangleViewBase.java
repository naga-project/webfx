package naga.toolkit.fx.spi.view.base;

import javafx.beans.property.Property;
import naga.toolkit.fx.scene.shape.Rectangle;
import naga.toolkit.fx.spi.DrawingRequester;
import naga.toolkit.fx.spi.view.RectangleView;

/**
 * @author Bruno Salmon
 */
public class RectangleViewBase
        extends ShapeViewBase<Rectangle, RectangleViewBase, RectangleViewMixin>
        implements RectangleView {

    @Override
    public void bind(Rectangle r, DrawingRequester drawingRequester) {
        super.bind(r, drawingRequester);
        requestUpdateOnPropertiesChange(drawingRequester,
                r.xProperty(),
                r.yProperty(),
                r.widthProperty(),
                r.heightProperty(),
                r.arcWidthProperty(),
                r.arcHeightProperty());
    }

    @Override
    public boolean updateProperty(Property changedProperty) {
        Rectangle r = node;
        return super.updateProperty(changedProperty)
                || updateProperty(r.xProperty(), changedProperty, mixin::updateX)
                || updateProperty(r.yProperty(), changedProperty, mixin::updateY)
                || updateProperty(r.widthProperty(), changedProperty, mixin::updateWidth)
                || updateProperty(r.heightProperty(), changedProperty, mixin::updateHeight)
                || updateProperty(r.arcWidthProperty(), changedProperty, mixin::updateArcWidth)
                || updateProperty(r.arcHeightProperty(), changedProperty, mixin::updateArcHeight);
    }
}