package webfx.fxkit.extra.cell.collator;

import javafx.collections.ListChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Transform;
import webfx.fxkit.extra.cell.renderer.ArrayRenderer;
import webfx.fxkit.extra.cell.renderer.ValueRenderer;
import webfx.fxkit.extra.control.DataGrid;
import webfx.fxkit.extra.displaydata.DisplayColumn;
import webfx.fxkit.extra.displaydata.DisplayResult;
import webfx.fxkit.extra.displaydata.DisplaySelection;
import webfx.fxkit.extra.displaydata.SelectionMode;
import webfx.fxkit.extra.mapper.spi.peer.impl.DataGridPeerBase;
import webfx.fxkit.extra.mapper.spi.peer.impl.DataGridPeerMixin;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class GridCollator extends DataGrid {

    final NodeCollator columnCollator;
    final NodeCollator rowCollator;
    final BorderPane container;

    public GridCollator(String columnCollator, String rowCollator) {
        this(NodeCollatorRegistry.getCollator(columnCollator), NodeCollatorRegistry.getCollator(rowCollator));
    }

    public GridCollator(NodeCollator columnCollator, NodeCollator rowCollator) {
        this.columnCollator = columnCollator;
        this.rowCollator = rowCollator;
        container = new BorderPane();
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMaxHeight(USE_PREF_SIZE);
        //setMaxHeight(Double.MAX_VALUE);
        //container.setMaxWidth(Double.MAX_VALUE);
        //container.setMaxHeight(Double.MAX_VALUE);
        getChildren().setAll(container);
    }

/*
    @Override
    public NodePeer getNodePeer() {
        NodePeer nodePeer = super.getNodePeer();
        if (nodePeer == null) {
            Scene scene = getScene();
            container.setScene(scene);
            NodePeer containerPeer = container.getOrCreateAndBindNodePeer();
            setNodePeer(nodePeer = containerPeer);
            gridCollatorPeer = new GridCollatorPeer();
            gridCollatorPeer.bind(this, new SceneRequester() {

                @Override
                public void requestNodePeerPropertyUpdate(Node node, ObservableValue changedProperty) {
                    gridCollatorPeer.updateProperty(changedProperty);
                }

                @Override
                public void requestNodePeerListUpdate(Node node, ObservableList changedList) {
                    gridCollatorPeer.updateList(changedList);
                }
            });
        }
        return nodePeer;
    }
*/

    @Override
    protected void layoutChildren() {
        layoutInArea(container, getLayoutX(), getLayoutY(), getWidth(), getHeight(), 0, HPos.LEFT, VPos.TOP);
        container.layout();
    }

    //private GridCollatorPeer gridCollatorPeer;

    public static final class GridCollatorPeer
            <N extends GridCollator, NB extends DataGridPeerBase<N, N, NB, NM>, NM extends DataGridPeerMixin<N, N, NB, NM>>

            extends DataGridPeerBase<N, N, NB, NM>
            implements DataGridPeerMixin<N, N, NB, NM> {

        private ValueRenderer[] renderers;
        private int[] rsColumnIndexes;

        {
            setMixin((NM) this);
        }

        @Override
        public void requestFocus() {
        }

        @Override
        public void updateSelectionMode(SelectionMode mode) {
        }

        @Override
        public void updateDisplaySelection(DisplaySelection selection) {
        }

        @Override
        public void updateHeaderVisible(boolean headerVisible) {
        }

        @Override
        public void updateFullHeight(boolean fullHeight) {
        }

        @Override
        public void updateBackground(Background background) {
        }

        @Override
        public void updateBorder(Border border) {
        }

        @Override
        public void updatePadding(Insets padding) {
        }

        @Override
        public void updateCursor(Cursor cursor) {
        }

        @Override
        public void updateResult(DisplayResult rs) {
            if (rs == null)
                return;
            int columnCount = rs.getColumnCount();
            renderers = new ValueRenderer[columnCount];
            rsColumnIndexes = new int[columnCount];
            fillGrid(rs);
            int rowCount = rs.getRowCount();
            Node[] rowNodes = new Node[rowCount];
            Object[] columnValues = new Object[getGridColumnCount()];
            N gridCollator = getNode();
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                for (int gridColumnIndex = 0; gridColumnIndex < getGridColumnCount(); gridColumnIndex++)
                    columnValues[gridColumnIndex] = rs.getValue(rowIndex, rsColumnIndexes[gridColumnIndex]);
                rowNodes[rowIndex] = ArrayRenderer.renderValue(columnValues, renderers, gridCollator.columnCollator);
            }
            Node finalNode = gridCollator.rowCollator.collateNodes(rowNodes);
            gridCollator.container.setCenter(finalNode);
            //ObservableLists.setAllNonNulls(gridCollator.getChildren(), finalNode);
        }

        @Override
        public void setUpGridColumn(int gridColumnIndex, int rsColumnIndex, DisplayColumn displayColumn) {
            renderers[gridColumnIndex] = displayColumn.getValueRenderer();
            rsColumnIndexes[gridColumnIndex] = rsColumnIndex;
        }

        @Override
        public void setCellContent(GridCollator cell, Node content, DisplayColumn displayColumn) {
            // not called
        }

        @Override
        public void updateWidth(Number width) {
            //getNode().container.setPrefWidth(width);
        }

        @Override
        public void updateHeight(Number height) {
            //getNode().container.setPrefHeight(height);
        }

        @Override
        public NB getNodePeerBase() {
            return (NB) this;
        }

        @Override
        public void updateMouseTransparent(Boolean mouseTransparent) {
            getNode().container.setMouseTransparent(mouseTransparent);
        }

        @Override
        public void updateVisible(Boolean visible) {
            getNode().container.setVisible(visible);
        }

        @Override
        public void updateOpacity(Double opacity) {
            getNode().container.setOpacity(opacity);
        }

        @Override
        public void updateDisabled(Boolean disabled) {
        }

        @Override
        public void updateClip(Node clip) {
            getNode().container.setClip(clip);
        }

        @Override
        public void updateBlendMode(BlendMode blendMode) {
            getNode().container.setBlendMode(blendMode);
        }

        @Override
        public void updateEffect(Effect effect) {
            getNode().container.setEffect(effect);
        }

        @Override
        public void updateLayoutX(Number layoutX) {
            //getNode().container.setLayoutX(layoutX);
        }

        @Override
        public void updateLayoutY(Number layoutY) {
            //getNode().container.setLayoutY(layoutY);
        }

        @Override
        public void updateTransforms(List<Transform> transforms, ListChangeListener.Change<Transform> change) {
            getNode().container.getTransforms().setAll(transforms);
        }

        @Override
        public void updateStyleClass(List<String> styleClass, ListChangeListener.Change<String> change) {
            getNode().container.getStyleClass().setAll(styleClass);
        }

        @Override
        public void updateLocalToParentTransforms(List<Transform> localToParentTransforms) {
        }
    }
}