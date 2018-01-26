package org.pcsoft.plugins.intellij.pascal.language.common;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import org.pcsoft.plugins.intellij.pascal.language.parser.PascalCustomTypes;

public class PascalQuoteHandler extends SimpleTokenSetQuoteHandler {
    public PascalQuoteHandler() {
        super(PascalCustomTypes.QUOTE);
    }
}
