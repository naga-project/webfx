package naga.core.util.function;

/**
 * @author Bruno Salmon
 */

public interface ThrowableFunction<A, R> {

    R apply(A arg) throws Throwable;

}
