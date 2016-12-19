package naga.toolkit.fx.spi.viewer.base;

import naga.toolkit.fx.scene.control.Control;
import naga.toolkit.fx.spi.viewer.ControlViewer;

/**
 * @author Bruno Salmon
 */
public abstract class ControlViewerBase
        <N extends Control, NV extends ControlViewerBase<N, NV, NM>, NM extends ControlViewerMixin<N, NV, NM>>

        extends RegionViewerBase<N, NV, NM>
        implements ControlViewer<N> {

}