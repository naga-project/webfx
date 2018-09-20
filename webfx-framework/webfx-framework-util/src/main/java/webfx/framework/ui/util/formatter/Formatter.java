package webfx.framework.ui.util.formatter;

import webfx.fxkits.extra.type.Type;

/**
 * @author Bruno Salmon
 */
public interface Formatter {

    Type getOutputType();

    Object format(Object value);
}