// Generated by WebFx

module mongoose.backend.activities.letters {

    // Direct dependencies modules
    requires javafx.graphics;
    requires mongoose.backend.activities.letter;
    requires mongoose.client.activity;
    requires mongoose.client.util;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.domain;
    requires webfx.framework.client.uifilter;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.shared.entity;
    requires webfx.framework.shared.operation;
    requires webfx.framework.shared.router;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.backend.activities.letters;
    exports mongoose.backend.activities.letters.routing;
    exports mongoose.backend.operations.letters;

    // Provided services
    provides webfx.framework.client.operations.route.RouteRequestEmitter with mongoose.backend.activities.letters.RouteToLettersRequestEmitter;
    provides webfx.framework.client.ui.uirouter.UiRoute with mongoose.backend.activities.letters.LettersUiRoute;

}