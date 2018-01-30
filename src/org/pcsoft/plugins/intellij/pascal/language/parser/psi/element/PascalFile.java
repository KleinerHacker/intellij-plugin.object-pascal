package org.pcsoft.plugins.intellij.pascal.language.parser.psi.element;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pcsoft.plugins.intellij.pascal.language.PascalFileType;
import org.pcsoft.plugins.intellij.pascal.language.PascalLanguage;

import javax.swing.*;

/**
 * Created by Christoph on 30.09.2016.
 */
public class PascalFile extends PsiFileBase {
    public PascalFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PascalLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PascalFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Object Pascal File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    @NotNull
    @Override
    public String getName() {
        //if (super.getName().equalsIgnoreCase(getPascalDeclarationName()))
            return super.getName();

        //return super.getName() + " (" + getPascalDeclarationName() + ")";
    }

    @Nullable
    public String getPascalDeclarationName() {
        final PascalProgramDeclaration programDeclaration = PsiTreeUtil.findChildOfType(this, PascalProgramDeclaration.class);
        final PascalUnitDeclaration unitDeclaration = PsiTreeUtil.findChildOfType(this, PascalUnitDeclaration.class);

        if (programDeclaration != null)
            return programDeclaration.getName();
        else if (unitDeclaration != null)
            return unitDeclaration.getName();

        return null;
    }
}
