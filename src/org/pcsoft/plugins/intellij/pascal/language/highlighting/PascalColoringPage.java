package org.pcsoft.plugins.intellij.pascal.language.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PascalColoringPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("String", PascalHighlighting.STRING),
            new AttributesDescriptor("Operator", PascalHighlighting.OPERATOR),
            new AttributesDescriptor("Splitter", PascalHighlighting.SPLITTER),
            new AttributesDescriptor("Comment", PascalHighlighting.COMMENT),
            new AttributesDescriptor("Keyword", PascalHighlighting.KEYWORD),
            new AttributesDescriptor("Braces", PascalHighlighting.BRACES),
            new AttributesDescriptor("Label", PascalHighlighting.LABEL),
            new AttributesDescriptor("Constant", PascalHighlighting.CONST),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new PascalSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// Example Pascal Code\n" +
                "PROGRAM MyProgram;\n\n" +
                "USES MyLibrary;\n\n" +
                "CONST MY_VALUE_1 = 'Word'; MY_VALUE_2 : REAL = 0.2;\n\n" +
                "VAR myVar : Real = 1.3\n\n" +
                "BEGIN\n" +
                "END";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        final Map<String, TextAttributesKey> map = new HashMap<>();
        map.put("KEY", PascalHighlighting.KEYWORD);
        map.put("LABEL", PascalHighlighting.LABEL);
        map.put("CONST", PascalHighlighting.CONST);
        map.put("STRING", PascalHighlighting.STRING);

        return map;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Object Pascal";
    }
}
