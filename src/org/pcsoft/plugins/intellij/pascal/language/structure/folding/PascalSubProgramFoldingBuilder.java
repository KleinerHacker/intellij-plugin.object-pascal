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
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalSubProgramDefinition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PascalSubProgramFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        final List<FoldingDescriptor> list = new ArrayList<>();

        final Collection<PascalSubProgramDefinition> subProgramDefinitionList = PsiTreeUtil.findChildrenOfType(psiElement, PascalSubProgramDefinition.class);
        for (final PascalSubProgramDefinition subProgramDefinition : subProgramDefinitionList) {
            final int startOffset;
            if (subProgramDefinition.getText().toLowerCase().contains("begin")) {
                startOffset = subProgramDefinition.getTextRange().getStartOffset() + getRelativeBeginOffset(subProgramDefinition.getText());
            } else {
                continue;
            }
            list.add(new FoldingDescriptor(subProgramDefinition, new TextRange(startOffset, subProgramDefinition.getTextRange().getEndOffset())));

            if (subProgramDefinition.getVariableDeclaration() != null) {
                list.add(new FoldingDescriptor(subProgramDefinition.getVariableDeclaration(), new TextRange(
                        subProgramDefinition.getVariableDeclaration().getTextRange().getStartOffset() + 3,
                        subProgramDefinition.getVariableDeclaration().getTextRange().getEndOffset()
                )));
            }
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

    private static int getRelativeBeginOffset(final String text) {
        final int beginIndex = text.indexOf("begin");
        final int varIndex = text.lastIndexOf("var", beginIndex);
        if (varIndex < 0)
            return text.lastIndexOf(';', beginIndex) + 1;

        return text.lastIndexOf(';', varIndex) + 1;
    }
}
