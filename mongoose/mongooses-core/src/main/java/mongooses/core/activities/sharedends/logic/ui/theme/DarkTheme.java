package mongooses.core.activities.sharedends.logic.ui.theme;

import javafx.scene.paint.Color;
import webfx.framework.ui.util.background.BackgroundUtil;
import webfx.framework.ui.util.border.BorderUtil;

/**
 * @author Bruno Salmon
 */
public class DarkTheme implements ThemeProvider {

    @Override
    public void apply() {
        Theme.setMainBackground(BackgroundUtil.newWebColorBackground("#101214"));
        Theme.setMainTextFill(Color.WHITE);
        Theme.setDialogBackground(BackgroundUtil.newBackground(Color.grayRgb(42),10));
        Theme.setDialogBorder(BorderUtil.newBorder(Color.rgb(237, 162, 57),10));
        Theme.setDialogTextFill(Color.WHITE);
    }
}
