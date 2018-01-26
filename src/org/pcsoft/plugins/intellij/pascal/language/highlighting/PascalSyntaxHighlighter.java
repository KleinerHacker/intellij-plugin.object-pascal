package org.pcsoft.plugins.intellij.pascal.language.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.pcsoft.plugins.intellij.pascal.language.parser.PascalCustomTypes;
import org.pcsoft.plugins.intellij.pascal.language.parser.PascalGenTypes;
import org.pcsoft.plugins.intellij.pascal.language.parser.lexer.PascalLexerAdapter;

/**
 * Created by Christoph on 02.10.2016.
 */
public class PascalSyntaxHighlighter extends SyntaxHighlighterBase {

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PascalLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {
        if (iElementType.equals(PascalCustomTypes.OPERATOR)) {
            return new TextAttributesKey[]{PascalHighlighting.OPERATOR};
        } else if (iElementType.equals(PascalCustomTypes.SPLITTER)) {
            return new TextAttributesKey[]{PascalHighlighting.SPLITTER};
        } else if (iElementType.equals(PascalCustomTypes.BRACES_CORNER_CLOSE) || iElementType.equals(PascalCustomTypes.BRACES_CORNER_OPEN) ||
                iElementType.equals(PascalCustomTypes.BRACES_CURLY_CLOSE) || iElementType.equals(PascalCustomTypes.BRACES_CURLY_OPEN)) {
            return new TextAttributesKey[]{PascalHighlighting.BRACES};
        } else if (iElementType.equals(PascalCustomTypes.COMMENT)) {
            return new TextAttributesKey[]{PascalHighlighting.COMMENT};
        } else if (iElementType.equals(PascalCustomTypes.QUOTE) | iElementType.equals(PascalGenTypes.STRING)) {
            return new TextAttributesKey[]{PascalHighlighting.STRING};
        } else if (iElementType.equals(PascalGenTypes.INTEGER) | iElementType.equals(PascalGenTypes.DECIMAL)) {
            return new TextAttributesKey[] {PascalHighlighting.NUMBER};
        } else if (iElementType.equals(PascalGenTypes.KEYWORD)) {
            return new TextAttributesKey[] {PascalHighlighting.KEYWORD};
        }

        return new TextAttributesKey[]{};
    }
}
