package naga.core.spi.gui.javafx.nodes;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import naga.core.spi.gui.GuiNode;
import naga.core.spi.gui.nodes.Window;

/**
 * @author Bruno Salmon
 */
public class FxWindow implements Window<Parent> {

    protected Stage stage;

    public FxWindow(Stage stage) {
        setStage(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        if (stage != null) {
            if (nodeProperty.getValue() != null)
                setWindowContent(nodeProperty.getValue().unwrapToToolkitNode());
            nodeProperty.addListener((observable, oldValue, newValue) -> setWindowContent(newValue.unwrapToToolkitNode()));
            titleProperty().addListener((observable, oldValue, newValue) -> stage.setTitle(newValue));
        }
    }

    private void setWindowContent(Parent rootComponent) {
        stage.setScene(createScene(rootComponent, 800, 600));
        stage.show();
    }

    protected Scene createScene(Parent rootComponent, double width, double height) {
        return new Scene(rootComponent, 800, 600);
    }

    private final Property<GuiNode<Parent>> nodeProperty = new SimpleObjectProperty<>();
    @Override
    public Property<GuiNode<Parent>> nodeProperty() {
        return nodeProperty;
    }

    private final Property<String> titleProperty = new SimpleObjectProperty<>();
    @Override
    public Property<String> titleProperty() {
        return titleProperty;
    }

}
