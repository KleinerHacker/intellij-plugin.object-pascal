package org.pcsoft.plugins.intellij.pascal.language.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.PascalTokenType;

/**
 * Created by Christoph on 30.09.2016.
 */
public interface PascalCustomTypes {
    IElementType COMMENT = new PascalTokenType("COMMENT");

    IElementType BRACES_CORNER_OPEN = new PascalTokenType("BRACES_CORNER_OPEN");
    IElementType BRACES_CORNER_CLOSE = new PascalTokenType("BRACES_CORNER_CLOSE");
    IElementType BRACES_CURLY_OPEN = new PascalTokenType("BRACES_CURLY_OPEN");
    IElementType BRACES_CURLY_CLOSE = new PascalTokenType("BRACES_CURLY_CLOSE");
    IElementType BRACES_ROUND_OPEN = new PascalTokenType("BRACES_ROUND_OPEN");
    IElementType BRACES_ROUND_CLOSE = new PascalTokenType("BRACES_ROUND_CLOSE");

    IElementType QUOTE = new PascalTokenType("QUOTE");
    IElementType SPLITTER = new PascalTokenType("SPLITTER");
    IElementType OPERATOR = new PascalTokenType("OPERATOR");

    TokenSet WHITE_SPACE_SET = TokenSet.create(com.intellij.psi.TokenType.WHITE_SPACE);
    TokenSet COMMENT_SET = TokenSet.create(COMMENT);
}
