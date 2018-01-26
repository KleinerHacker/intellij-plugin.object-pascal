package org.pcsoft.plugins.intellij.pascal.language.common;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pcsoft.plugins.intellij.pascal.language.parser.PascalCustomTypes;

public class PascalBraceMatcher implements PairedBraceMatcher {
    @NotNull
    @Override
    public BracePair[] getPairs() {
        return new BracePair[] {
            new BracePair(PascalCustomTypes.BRACES_CORNER_OPEN, PascalCustomTypes.BRACES_CORNER_CLOSE, false),
            new BracePair(PascalCustomTypes.BRACES_ROUND_OPEN, PascalCustomTypes.BRACES_ROUND_CLOSE, false)
        };
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int i) {
        return 0;
    }
}
