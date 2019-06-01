// Generated by WebFx

module mongoose.backend.activities.operations {

    // Direct dependencies modules
    requires javafx.graphics;
    requires mongoose.client.activity;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.controls;
    requires webfx.framework.client.domain;
    requires webfx.framework.client.uifilter;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.shared.entity;
    requires webfx.framework.shared.operation;
    requires webfx.framework.shared.router;
    requires webfx.fxkit.launcher;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.backend.activities.operations;
    exports mongoose.backend.activities.operations.routing;
    exports mongoose.backend.operations.operations;

    // Provided services
    provides webfx.framework.client.operations.route.RouteRequestEmitter with mongoose.backend.activities.operations.RouteToOperationsRequestEmitter;
    provides webfx.framework.client.ui.uirouter.UiRoute with mongoose.backend.activities.operations.OperationsUiRoute;

}