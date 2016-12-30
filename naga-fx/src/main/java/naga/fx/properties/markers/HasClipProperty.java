package naga.fx.properties.markers;

import javafx.beans.property.Property;
import naga.fx.scene.Node;

/**
 * @author Bruno Salmon
 */
public interface HasClipProperty {

    Property<Node> clipProperty();
    default void setClip(Node node) { clipProperty().setValue(node); }
    default Node getClip() { return clipProperty().getValue(); }
}