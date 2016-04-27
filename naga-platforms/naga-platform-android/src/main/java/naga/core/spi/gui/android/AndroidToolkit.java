package naga.core.spi.gui.android;

import android.app.Activity;
import android.view.View;
import naga.core.spi.gui.GuiNode;
import naga.core.spi.gui.GuiNodeFactory;
import naga.core.spi.gui.GuiToolkit;
import naga.core.spi.gui.android.nodes.*;
import naga.core.spi.gui.nodes.*;

/**
 * @author Bruno Salmon
 */
public class AndroidToolkit extends GuiToolkit {

    public static Activity currentActivity;

    public static void register() {
        GuiToolkit.register(new AndroidToolkit());
    }

    private AndroidToolkit() {
        super(AndroidGuiScheduler.SINGLETON, () -> new AndroidWindow(currentActivity));
        registerNodeFactory(BorderPane.class, AndroidBorderPane::new);
        registerNodeFactory(CheckBox.class, AndroidCheckBox::new);
        registerNodeFactory(ToggleSwitch.class, AndroidCheckBox::new);
        registerNodeFactory(SearchBox.class, AndroidSearchBox::new);
        registerNodeFactory(Table.class, new GuiNodeFactory() {
            @Override
            public GuiNode createNode() {
                return new AndroidTable();
            }
        });
    }

    private int idSeq = 10000;

    @Override
    public <T extends GuiNode> T createNode(Class<T> nodeInterface) {
        T node = super.createNode(nodeInterface);
        if (node != null) {
            View view = (View) node.unwrapToToolkitNode();
            view.setId(idSeq++);
        }
        return node;
    }
}
