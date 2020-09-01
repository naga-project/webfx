// Generated by WebFx

module webfx.framework.shared.orm.dql.query.interceptor {

    // Direct dependencies modules
    requires webfx.framework.shared.orm.datasourcemodelservice;
    requires webfx.framework.shared.orm.domainmodel;
    requires webfx.platform.shared.appcontainer;
    requires webfx.platform.shared.datasource;
    requires webfx.platform.shared.query;
    requires webfx.platform.shared.util;

    // Exported packages
    exports webfx.framework.shared.interceptors.dqlquery;

    // Provided services
    provides webfx.platform.shared.services.appcontainer.spi.ApplicationModuleInitializer with webfx.framework.shared.interceptors.dqlquery.DqlQueryInterceptorModuleInitializer;

}