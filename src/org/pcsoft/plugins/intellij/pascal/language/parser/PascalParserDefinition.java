package org.pcsoft.plugins.intellij.pascal.language.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.pcsoft.plugins.intellij.pascal.language.PascalLanguage;
import org.pcsoft.plugins.intellij.pascal.language.parser.lexer.PascalLexerAdapter;
import org.pcsoft.plugins.intellij.pascal.language.parser.psi.element.PascalFile;

/**
 * Created by Christoph on 02.10.2016.
 */
public class PascalParserDefinition implements ParserDefinition {
    private static final IFileElementType FILE = new IFileElementType(Language.findInstance(PascalLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new PascalLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new PascalParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return PascalCustomTypes.WHITE_SPACE_SET;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return PascalCustomTypes.COMMENT_SET;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return PascalGenTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new PascalFile(fileViewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }
}
