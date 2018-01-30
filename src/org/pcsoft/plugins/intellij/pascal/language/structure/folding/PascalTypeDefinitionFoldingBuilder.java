package org.pcsoft.plugins.intellij.pascal.language.structure.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalClassType;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalObjectType;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalRecordType;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalTypeDeclaration;

import java.util.ArrayList;
import java.util.List;

public class PascalTypeDefinitionFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        final List<FoldingDescriptor> list = new ArrayList<>();

        final PascalRecordType recordType = PsiTreeUtil.findChildOfType(psiElement, PascalRecordType.class);
        if (recordType != null) {
            list.add(new FoldingDescriptor(recordType, new TextRange(recordType.getTextRange().getStartOffset()+6, recordType.getTextRange().getEndOffset())));
        }

        final PascalObjectType objectType = PsiTreeUtil.findChildOfType(psiElement, PascalObjectType.class);
        if (objectType != null) {
            list.add(new FoldingDescriptor(objectType, new TextRange(objectType.getTextRange().getStartOffset()+6, objectType.getTextRange().getEndOffset())));
        }

        final PascalClassType classType = PsiTreeUtil.findChildOfType(psiElement, PascalClassType.class);
        if (classType != null) {
            list.add(new FoldingDescriptor(classType, new TextRange(classType.getTextRange().getStartOffset()+5, classType.getTextRange().getEndOffset())));
        }

        return list.toArray(new FoldingDescriptor[list.size()]);
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
        return false;
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode astNode) {
        return "...";
    }
}
