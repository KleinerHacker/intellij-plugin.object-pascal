package org.pcsoft.plugins.intellij.pascal.language.parser.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.pcsoft.plugins.intellij.pascal.language.PascalLanguage;

/**
 * Created by Christoph on 30.09.2016.
 */
public class PascalTokenType extends IElementType {
    public PascalTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PascalLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "PascalTokenType." + super.toString();
    }
}
