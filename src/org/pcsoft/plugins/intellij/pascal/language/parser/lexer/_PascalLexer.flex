package org.pcsoft.plugins.intellij.pascal.language.parser.lexer;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static org.pcsoft.plugins.intellij.pascal.language.parser.PascalGenTypes.*;
import static org.pcsoft.plugins.intellij.pascal.language.parser.PascalCustomTypes.*;

%%

%{
  public _PascalLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _PascalLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%ignorecase

EOL=\r | \n | \r\n
WHITE_SPACE=" " | {EOL}
NAME=[A-Za-z_]{1}[A-Za-z0-9_]*
INTEGER=[0-9]+
DECIMAL=[0-9]*\.[0-9]+
STRING=([^\']|(\'\'))+
COMMENT_LINE="//"[^\r|\n|\r\n]*{EOL}?
COMMENT_BLOCK1=\{[^\}]*\}?
COMMENT_BLOCK2="(*"[^"*)"]*"*)"?
KEYWORD_PASCAL="program"|"begin"|"end"|"const"|"unit"|"uses"|"and"|"array"|"asm"|"break"|"case"|"constructor"|"continue"|"destructor"|"div"|"do"|"downto"|"else"|
    "file"|"for"|"function"|"goto"|"if"|"implementation"|"in"|"inherited"|"inline"|"interface"|"label"|"mod"|"not"|"object"|"of"|"on"|"operator"|"or"|
    "packed"|"procedure"|"program"|"record"|"reintroduce"|"repeat"|"self"|"set"|"shl"|"shr"|"string"|"then"|"to"|"type"|"until"|"uses"|"var"|"while"|"with"|"xor"
KEYWORD_DELPHI="as"|"class"|"except"|"exports"|"finalization"|"finally"|"initialization"|"is"|"library"|"property"|"raise"|"threadvar"|"try"|"private"|"public"|
    "published"|"read"|"write"|"default"|"stored"|"override"|"overload"
KEYWORD_FREE="dispose"|"exit"|"false"|"new"|"true"
KEYWORD_TYPE="byte"|"shortint"|"smallint"|"word"|"integer"|"cardinal"|"longint"|"longword"|"int64"|"qword"|"real"|"single"|"double"|"extended"|"comp"|"currency"|
    "boolean"|"bytebool"|"wordbool"|"longbool"|"char"
KEYWORD_VALUE="true"|"false"|"nil"

%state YYSTRING

%%
<YYINITIAL> {
  "::="|":"|"="|"^"|"+"|"-"|"*"|"/"|"^"                     { return OPERATOR; }
  ".."|"."|";"                                              { return SPLITTER; }

  {KEYWORD_PASCAL}|{KEYWORD_DELPHI}|{KEYWORD_FREE}|
  {KEYWORD_TYPE}|{KEYWORD_VALUE}                            { return KEYWORD; }
  {DECIMAL}                                                 { return DECIMAL; }
  {INTEGER}                                                 { return INTEGER; }
  {NAME}                                                    { return NAME; }
  <YYSTRING> {
    "'"                                                     { yybegin(yystate() == YYSTRING ? YYINITIAL : YYSTRING); return QUOTE; }
  }

  "["                                                       { return BRACES_CORNER_OPEN; }
  "]"                                                       { return BRACES_CORNER_CLOSE; }
  "("                                                       { return BRACES_ROUND_OPEN; }
  ")"                                                       { return BRACES_ROUND_CLOSE; }

  {COMMENT_LINE}|{COMMENT_BLOCK1}|{COMMENT_BLOCK2}          { return COMMENT; }
  {WHITE_SPACE}                                             { return com.intellij.psi.TokenType.WHITE_SPACE; }
}
<YYSTRING> {
  {STRING}                                                  { return STRING; }
}

[^]                                                         { return com.intellij.psi.TokenType.BAD_CHARACTER; }
