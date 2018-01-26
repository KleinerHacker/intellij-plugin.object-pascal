package org.pcsoft.plugins.intellij.pascal.language.parser.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by Christoph on 02.10.2016.
 */
public class PascalLexerAdapter extends FlexAdapter {
    public PascalLexerAdapter() {
        super(new _PascalLexer((Reader) null));
    }
}
