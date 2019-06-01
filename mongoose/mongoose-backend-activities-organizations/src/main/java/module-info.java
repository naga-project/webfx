// Generated by WebFx

module mongoose.backend.activities.organizations {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires mongoose.backend.activities.events;
    requires mongoose.client.activity;
    requires mongoose.shared.entities;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.domain;
    requires webfx.framework.client.i18n;
    requires webfx.framework.client.uifilter;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.shared.operation;
    requires webfx.framework.shared.router;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.backend.activities.organizations;
    exports mongoose.backend.activities.organizations.routing;
    exports mongoose.backend.operations.organizations;

    // Provided services
    provides webfx.framework.client.operations.route.RouteRequestEmitter with mongoose.backend.activities.organizations.RouteToOrganizationsRequestEmitter;
    provides webfx.framework.client.ui.uirouter.UiRoute with mongoose.backend.activities.organizations.OrganizationsUiRoute;

}