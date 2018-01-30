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
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalUsesDeclaration;

import java.util.ArrayList;
import java.util.List;

public class PascalUsesFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        final List<FoldingDescriptor> list = new ArrayList<>();

        final PascalUsesDeclaration usesDeclaration = PsiTreeUtil.findChildOfType(psiElement, PascalUsesDeclaration.class);
        if (usesDeclaration != null) {
            list.add(new FoldingDescriptor(usesDeclaration, new TextRange(usesDeclaration.getTextRange().getStartOffset()+4, usesDeclaration.getTextRange().getEndOffset())));
        }

        return list.toArray(new FoldingDescriptor[list.size()]);
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
        return true;
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode astNode) {
        return "...";
    }
}
