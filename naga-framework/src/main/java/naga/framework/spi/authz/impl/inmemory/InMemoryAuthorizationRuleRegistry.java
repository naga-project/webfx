package naga.framework.spi.authz.impl.inmemory;

import naga.framework.spi.authz.impl.inmemory.parser.InMemoryAuthorizationRuleParser;
import naga.framework.spi.authz.impl.inmemory.parser.InMemoryAuthorizationRuleParserRegistry;
import naga.framework.spi.authz.impl.inmemory.parser.AuthorizationRequestParser;
import naga.framework.spi.authz.impl.inmemory.parser.AuthorizationRequestParserRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class InMemoryAuthorizationRuleRegistry implements InMemoryAuthorizationRule {

    private final Map<Class, Collection<InMemoryAuthorizationRule>> registeredInMemoryAuthorizationRules = new HashMap<>();
    private InMemoryAuthorizationRuleParser inMemoryAuthorizationRuleParser;
    private AuthorizationRequestParser authorizationRequestParser;

    public void setAuthorizationRuleParser(InMemoryAuthorizationRuleParser ruleParser) {
        this.inMemoryAuthorizationRuleParser = ruleParser;
    }

    public void addAuthorizationRuleParser(InMemoryAuthorizationRuleParser ruleParser) {
        if (inMemoryAuthorizationRuleParser == null)
            setAuthorizationRuleParser(ruleParser);
        else {
            InMemoryAuthorizationRuleParserRegistry registry;
            if (inMemoryAuthorizationRuleParser instanceof InMemoryAuthorizationRuleParserRegistry)
                registry = (InMemoryAuthorizationRuleParserRegistry) inMemoryAuthorizationRuleParser;
            else {
                registry = new InMemoryAuthorizationRuleParserRegistry();
                registry.registerParser(inMemoryAuthorizationRuleParser);
            }
            registry.registerParser(ruleParser);
        }
    }

    public void setAuthorizationRequestParser(AuthorizationRequestParser requestParser) {
        this.authorizationRequestParser = requestParser;
    }

    public void addAuthorizationRequestParser(AuthorizationRequestParser requestParser) {
        if (authorizationRequestParser == null)
            setAuthorizationRequestParser(requestParser);
        else {
            AuthorizationRequestParserRegistry registry;
            if (authorizationRequestParser instanceof InMemoryAuthorizationRuleParserRegistry)
                registry = (AuthorizationRequestParserRegistry) authorizationRequestParser;
            else {
                registry = new AuthorizationRequestParserRegistry();
                registry.registerParser(authorizationRequestParser);
            }
            registry.registerParser(requestParser);
        }
    }

    public <A> void registerAuthorizationRule(Class<A> operationRequestClass, InMemoryAuthorizationRule<A> authorizationRule) {
        Collection<InMemoryAuthorizationRule> inMemoryAuthorizationRules = registeredInMemoryAuthorizationRules.get(operationRequestClass);
        if (inMemoryAuthorizationRules == null)
            registeredInMemoryAuthorizationRules.put(operationRequestClass, inMemoryAuthorizationRules = new ArrayList<>());
        inMemoryAuthorizationRules.add(authorizationRule);
    }

    public <A> void registerAuthorizationRule(InMemoryAuthorizationRule authorizationRule) {
        if (authorizationRule != null)
            registerAuthorizationRule(authorizationRule.operationRequestClass(), authorizationRule);
    }

    public void registerAuthorizationRule(String authorization) {
        registerAuthorizationRule(inMemoryAuthorizationRuleParser.parseAuthorization(authorization));
    }

    @Override
    public Class operationRequestClass() {
        return Object.class;
    }

    public boolean doesRulesAuthorize(Object operationAuthorizationRequest) {
        return computeRuleResult(operationAuthorizationRequest) == AuthorizationRuleResult.GRANTED;
    }

    @Override
    public AuthorizationRuleResult computeRuleResult(Object authorizationRequest) {
        Object parsedAuthorizationRequest = authorizationRequest instanceof String && authorizationRequestParser != null ? authorizationRequestParser.parseAuthorizationRequest((String) authorizationRequest) : authorizationRequest;
        AuthorizationRuleResult result = AuthorizationRuleResult.OUT_OF_RULE_CONTEXT;
        Collection<InMemoryAuthorizationRule> rules = registeredInMemoryAuthorizationRules.get(parsedAuthorizationRequest.getClass());
        if (rules != null)
            for (InMemoryAuthorizationRule rule : rules)
                switch (rule.computeRuleResult(parsedAuthorizationRequest)) {
                    case DENIED:  result = AuthorizationRuleResult.DENIED; break; // Breaking as it's a final decision
                    case GRANTED: result = AuthorizationRuleResult.GRANTED; // Not breaking, as we need to check there is not another denying rule (which is priority)
                    case OUT_OF_RULE_CONTEXT: // just ignoring it and looping to the next
                }
        return result;
    }
}