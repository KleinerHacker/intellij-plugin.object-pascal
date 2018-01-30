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
                "program MyProgram;\n" +
                "\n" +
                "uses MyUnit;\n" +
                "\n" +
                "const\n" +
                "    myConst = 'my''string';\n" +
                "    myValueConst : real = 12.0;\n" +
                "    //myArrayConst : array [1..100] of integer; //TODO\n" +
                "\n" +
                "type\n" +
                "    tMyEnum = (Jan, Feb, Mar);\n" +
                "    tMyRange = 10..20;\n" +
                "    tMyArray = array[tMyRange,1..10] of real;\n" +
                "    tMyRecord = record\n" +
                "        val1 : real;\n" +
                "        val2, val3 : tMyEnum;\n" +
                "    end;\n" +
                "    tMyObject = object\n" +
                "        val1 : integer;\n" +
                "        function GetVal1 : integer;\n" +
                "        procedure SetVal1(val1 : integer);\n" +
                "    end;\n" +
                "    tMyClass = class\n" +
                "        private\n" +
                "            val1 : string[100];\n" +
                "        public\n" +
                "            function GetVal1 : integer;\n" +
                "            procedure SetVal1(val1 : integer);\n" +
                "        published\n" +
                "            property Value1 : integer read GetVal1 write SetVal1;\n" +
                "    end;\n" +
                "\n" +
                "var\n" +
                "    instance : tMyClass;\n" +
                "\n" +
                "function tMyClass.GetVal1 : integer;\n" +
                "begin\n" +
                "    result := self.val1;\n" +
                "end;\n" +
                "\n" +
                "procedure tMyClass.SetVal1(val1 : integer);\n" +
                "var\n" +
                "    a : real;\n" +
                "begin\n" +
                "    self.val1 := val1;\n" +
                "end;\n" +
                "\n" +
                "begin\n" +
                "    instance := tMyClass.Create;\n" +
                "    instance.Value1 := 10;\n" +
                "    tMyClass(instance).Value1 := 9;\n" +
                "    tAny(tMyClass(instance).Value1).val := 9;\n" +
                "\n" +
                "    for index := tMinValue to 10 do\n" +
                "    begin\n" +
                "        if indexer < (8-instance.Value1) then\n" +
                "        begin\n" +
                "            with instance do\n" +
                "            begin\n" +
                "                Value1 := indexer;\n" +
                "            end;\n" +
                "        end;\n" +
                "    end;\n" +
                "end.";
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
