package mongoose.client.services.authn;

import mongoose.shared.domainmodel.loader.DomainModelSnapshotLoader;
import webfx.framework.shared.expression.sqlcompiler.sql.SqlCompiled;
import webfx.framework.shared.orm.domainmodel.DataSourceModel;
import webfx.framework.shared.orm.domainmodel.HasDataSourceModel;
import webfx.framework.shared.services.authn.spi.AuthenticationServiceProvider;
import webfx.framework.shared.services.authn.UsernamePasswordCredentials;
import webfx.platform.shared.services.query.QueryArgument;
import webfx.platform.shared.services.query.QueryService;
import webfx.platform.shared.util.async.Future;

/**
 * @author Bruno Salmon
 */
public final class MongooseAuthenticationServiceProvider implements AuthenticationServiceProvider, HasDataSourceModel {

    private final DataSourceModel dataSourceModel;

    public MongooseAuthenticationServiceProvider() {
        this(DomainModelSnapshotLoader.getDataSourceModel());
    }

    public MongooseAuthenticationServiceProvider(DataSourceModel dataSourceModel) {
        this.dataSourceModel = dataSourceModel;
    }

    @Override
    public DataSourceModel getDataSourceModel() {
        return dataSourceModel;
    }

    @Override
    public Future<MongooseUserPrincipal> authenticate(Object userCredentials) {
        if (!(userCredentials instanceof UsernamePasswordCredentials))
            return Future.failedFuture(new IllegalArgumentException("MongooseAuthenticationServiceProvider requires a UsernamePasswordCredentials argument"));
        UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) userCredentials;
        Object[] parameters = {1, usernamePasswordCredentials.getUsername(), usernamePasswordCredentials.getPassword()};
        SqlCompiled sqlCompiled = getDomainModel().compileSelect("select id,frontendAccount.id from Person where frontendAccount.(corporation=? and username=? and password=?) order by id limit 1", parameters);
        return QueryService.executeQuery(new QueryArgument(sqlCompiled.getSql(), parameters, getDataSourceId()))
                .compose(result -> result.getRowCount() != 1 ? Future.failedFuture("Wrong user or password")
                      : Future.succeededFuture(new MongooseUserPrincipal(result.getValue(0, 0), result.getValue(0, 1)))
                );
    }
}
