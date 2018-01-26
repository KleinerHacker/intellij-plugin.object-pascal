package org.pcsoft.plugins.intellij.pascal.language.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public class PascalHighlighting {
    public static final TextAttributesKey OPERATOR = TextAttributesKey.createTextAttributesKey("PASCAL_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey SPLITTER = TextAttributesKey.createTextAttributesKey("PASCAL_SPLITTER", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("PASCAL_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("PASCAL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("PASCAL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("PASCAL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey CONST = TextAttributesKey.createTextAttributesKey("PASCAL_CONST", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("PASCAL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey LABEL = TextAttributesKey.createTextAttributesKey("PASCAL_LABEL", DefaultLanguageHighlighterColors.LABEL);
}
