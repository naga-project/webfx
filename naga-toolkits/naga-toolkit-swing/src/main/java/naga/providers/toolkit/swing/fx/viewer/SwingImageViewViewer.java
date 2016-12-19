package naga.providers.toolkit.swing.fx.viewer;

import naga.commons.scheduler.UiScheduler;
import naga.providers.toolkit.swing.util.JGradientLabel;
import naga.providers.toolkit.swing.util.SwingImageStore;
import naga.toolkit.fx.geometry.BoundingBox;
import naga.toolkit.fx.geometry.Bounds;
import naga.toolkit.fx.scene.LayoutMeasurable;
import naga.toolkit.fx.scene.image.ImageView;
import naga.toolkit.fx.spi.viewer.base.ImageViewViewerBase;
import naga.toolkit.fx.spi.viewer.base.ImageViewViewerMixin;
import naga.toolkit.spi.Toolkit;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bruno Salmon
 */
public class SwingImageViewViewer
        extends SwingNodeViewer<ImageView, ImageViewViewerBase, ImageViewViewerMixin>
        implements ImageViewViewerMixin, SwingEmbedComponentViewer<ImageView>, LayoutMeasurable {

    private final JGradientLabel swingImage = new JGradientLabel();

    public SwingImageViewViewer() {
        super(new ImageViewViewerBase());
        swingImage.setBackground(null); // transparent background
    }

    @Override
    public void updateImageUrl(String imageUrl) {
        updateIcon();
    }

    @Override
    public void updateFitWidth(Double fitWidth) {
        updateIcon();
    }

    @Override
    public void updateFitHeight(Double fitHeight) {
        updateIcon();
    }

    private void updateIcon() {
        // As we are probably in the animation frame we make this call non blocking by either setting the icon
        // immediately if it is already loaded and present in cache, or deferring the icon load in the background
        String url = getNode().getImageUrl();
        int fitWidth = getNode().getFitWidth().intValue();
        int fitHeight = getNode().getFitHeight().intValue();
        Icon cachedIcon = SwingImageStore.getIconFromCache(url, fitWidth, fitHeight);
        if (cachedIcon != null || url == null)
            swingImage.setIcon(cachedIcon); // Setting the image immediately
        else { // Deferring the image load in the background because it can take more than 16ms (breaking 60 FPS)
            UiScheduler uiScheduler = Toolkit.get().scheduler();
            uiScheduler.runInBackground(() -> {
                // Loading the image
                Icon icon = SwingImageStore.getIcon(url, fitWidth, fitHeight);
                // Now that we have the image, we update the JavaFx node (in the UI thread)
                uiScheduler.runInUiThread(() -> swingImage.setIcon(icon));
                // In case the icon is in a table cell, the above call didn't update the UI so we request a UI refresh
                uiScheduler.requestNextPulse();
            });
        }
    }

    @Override
    public JGradientLabel getSwingComponent() {
        return swingImage;
    }

    @Override
    public Bounds getLayoutBounds() {
        return new BoundingBox(0, 0, 0, prefWidth(-1), prefHeight(-1), 0);
    }

    @Override
    public double minWidth(double height) {
        return prefWidth(height);
    }

    @Override
    public double maxWidth(double height) {
        return prefWidth(height);
    }

    @Override
    public double minHeight(double width) {
        return prefHeight(width);
    }

    @Override
    public double maxHeight(double width) {
        return prefHeight(width);
    }

    @Override
    public double prefWidth(double height) {
        Icon icon = swingImage.getIcon();
        return icon == null ? getNode().getFitWidth() : icon.getIconWidth();
    }

    @Override
    public double prefHeight(double width) {
        Icon icon = swingImage.getIcon();
        return icon == null ? getNode().getFitHeight() : icon.getIconHeight();
    }

    @Override
    public void paint(Graphics2D g) {
        Icon icon = swingImage.getIcon();
        if (icon != null) {
            ImageView node = getNode();
            swingImage.setBounds(node.getX().intValue(), node.getY().intValue(), icon.getIconWidth(), icon.getIconHeight());
            swingImage.paint(g);
        }
    }
}