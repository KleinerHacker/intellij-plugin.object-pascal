package org.pcsoft.plugins.intellij.pascal.language.parser.psi;

import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pcsoft.plugins.intellij.pascal.language.parser.PascalGenTypes;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.*;
import org.pcsoft.plugins.intellij.pascal.language.type.SubProgramType;

/**
 * Created by Christoph on 30.09.2016.
 */
public interface PascalPsiUtils {

    //<editor-fold desc="Top Level Declarations">

    @Nullable
    static String getName(final PascalProgramDeclaration programDeclaration) {
        if (programDeclaration.getNode().getChildren(TokenSet.create(PascalGenTypes.NAME)).length <= 0)
            return null;

        return programDeclaration.getNode().getChildren(TokenSet.create(PascalGenTypes.NAME))[0].getText();
    }

    @Nullable
    static String getName(final PascalUnitDeclaration unitDeclaration) {
        if (unitDeclaration.getNode().getChildren(TokenSet.create(PascalGenTypes.NAME)).length <= 0)
            return null;

        return unitDeclaration.getNode().getChildren(TokenSet.create(PascalGenTypes.NAME))[0].getText();
    }

    //</editor-fold>

    //<editor-fold desc="Uses">

    @NotNull
    static String getName(final PascalUsesValue usesValue) {
        return usesValue.getText();
    }
    
    //</editor-fold>

    //<editor-fold desc="Constant">

    @NotNull
    static String getName(final PascalConstantName constantName) {
        return constantName.getText();
    }

    @NotNull
    static String getName(final PascalConstantDefinition constantDefinition) {
        return constantDefinition.getConstantName().getName();
    }

    //</editor-fold>

    //<editor-fold desc="Variable">

    @NotNull
    static String getName(final PascalVariableName variableName) {
        return variableName.getText();
    }
    
    //</editor-fold>

    //<editor-fold desc="Sub Program">

    @Nullable
    static SubProgramType getType(final PascalSubProgramType subProgramType) {
        try {
            return SubProgramType.valueOf(subProgramType.getText());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @NotNull
    static String getName(final PascalSubProgramName subProgramName) {
        return subProgramName.getText();
    }

    @Nullable
    static SubProgramType getType(final PascalSubProgramDefinition subProgramDefinition) {
        return subProgramDefinition.getSubProgramType().getType();
    }

    @NotNull
    static String getName(final PascalSubProgramDefinition subProgramDefinition) {
        return subProgramDefinition.getSubProgramName().getName();
    }

    static boolean isOverload(final PascalSubProgramDefinition subProgramDefinition) {
        return !subProgramDefinition.getSubProgramFlagOverloadList().isEmpty();
    }

    static boolean isOverride(final PascalSubProgramDefinition subProgramDefinition) {
        return !subProgramDefinition.getSubProgramFlagOverrideList().isEmpty();
    }

    static boolean isVirtual(final PascalSubProgramDefinition subProgramDefinition) {
        return !subProgramDefinition.getSubProgramFlagVirtualList().isEmpty();
    }

    static boolean isDynamic(final PascalSubProgramDefinition subProgramDefinition) {
        return !subProgramDefinition.getSubProgramFlagDynamicList().isEmpty();
    }

    //<editor-fold desc="Parameters">

    static boolean isConstant(final PascalSubProgramParameter subProgramParameter) {
        if (subProgramParameter.getNode().getFirstChildNode() == null)
            return false;

        return subProgramParameter.getNode().getFirstChildNode().getText().equalsIgnoreCase("const");
    }

    @NotNull
    static String getName(final PascalSubProgramParameterName subProgramParameterName) {
        return subProgramParameterName.getText();
    }
    
    //</editor-fold>

    //</editor-fold>

}
