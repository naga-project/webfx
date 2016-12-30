package naga.fx.spi.javafx.fx.viewer;

import javafx.scene.Node;
import naga.fx.geometry.BoundingBox;
import naga.fx.geometry.Bounds;
import naga.fx.scene.LayoutMeasurable;

/**
 * @author Bruno Salmon
 */
public interface FxLayoutMeasurable extends LayoutMeasurable {

    Node getFxNode();

    default Bounds getLayoutBounds() {
        javafx.geometry.Bounds b = getFxNode().getLayoutBounds();
        return new BoundingBox(b.getMinX(), b.getMinY(), b.getMinZ(), b.getWidth(), b.getHeight(), b.getDepth());
    }

    default double minWidth(double height) {
        return getFxNode().minWidth(height);
    }

    default double maxWidth(double height) {
        return getFxNode().maxWidth(height);
    }

    default double minHeight(double width) {
        return getFxNode().minHeight(width);
    }

    default double maxHeight(double width) {
        return getFxNode().maxHeight(width);
    }

    default double prefWidth(double height) {
        return getFxNode().prefWidth(height);
    }

    default double prefHeight(double width) {
        return getFxNode().prefHeight(width);
    }

}