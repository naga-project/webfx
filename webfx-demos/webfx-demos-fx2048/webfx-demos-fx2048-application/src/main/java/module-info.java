// Generated by WebFx

module webfx.demos.fx2048.application {

    // Direct dependencies modules
    requires java.base;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires webfx.extras.webtext.controls;
    requires webfx.platform.client.storage;
    requires webfx.platform.shared.resource;
    requires webfx.platform.shared.util;

    // Exported packages
    exports io.fxgame.game2048;
    exports io.fxgame.game2048.emul;

    // Resources packages
    opens io.fxgame.game2048;

    // Provided services
    provides javafx.application.Application with io.fxgame.game2048.Game2048;

}