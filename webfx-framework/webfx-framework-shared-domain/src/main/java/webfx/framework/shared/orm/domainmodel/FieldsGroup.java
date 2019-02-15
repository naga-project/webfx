package webfx.framework.shared.orm.domainmodel;

import webfx.framework.shared.expression.Expression;
import webfx.framework.shared.expression.sqlcompiler.ExpressionSqlCompiler;
import webfx.framework.shared.expression.terms.Symbol;
import webfx.fxkit.extra.type.Type;

/**
 * @author Bruno Salmon
 */
public final class FieldsGroup extends Symbol {

    private final DomainClass domainClass;
    private String fieldsDefinition;

    static {
        ExpressionSqlCompiler.declareSymbolSubclasses(FieldsGroup.class);
    }

    public FieldsGroup(DomainClass domainClass, String name, String fieldsDefinition) {
        super(name, null, null);
        this.domainClass = domainClass;
        this.fieldsDefinition = fieldsDefinition;
    }

    @Override
    public Type getType() {
        return getExpression().getType();
    }

    @Override
    public Expression getExpression() {
        if (expression == null) {
            expression = domainClass.parseExpression(fieldsDefinition);
            fieldsDefinition = null;
        }
        return expression;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        return sb.append('<').append(name).append('>');
    }
}