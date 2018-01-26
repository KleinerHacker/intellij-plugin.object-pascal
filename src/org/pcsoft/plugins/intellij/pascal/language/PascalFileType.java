package org.pcsoft.plugins.intellij.pascal.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Christoph on 30.09.2016.
 */
public class PascalFileType extends LanguageFileType {
    public static final PascalFileType INSTANCE = new PascalFileType();

    public PascalFileType() {
        super(PascalLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Object Pascal Code";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Object Pascal File";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pas";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
