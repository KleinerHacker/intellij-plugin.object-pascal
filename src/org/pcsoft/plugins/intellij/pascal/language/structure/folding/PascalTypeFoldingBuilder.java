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
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalTypeDeclaration;

import java.util.ArrayList;
import java.util.List;

public class PascalTypeFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        final List<FoldingDescriptor> list = new ArrayList<>();

        final PascalTypeDeclaration typeDeclaration = PsiTreeUtil.findChildOfType(psiElement, PascalTypeDeclaration.class);
        if (typeDeclaration != null) {
            list.add(new FoldingDescriptor(typeDeclaration, new TextRange(typeDeclaration.getTextRange().getStartOffset()+4, typeDeclaration.getTextRange().getEndOffset())));
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
