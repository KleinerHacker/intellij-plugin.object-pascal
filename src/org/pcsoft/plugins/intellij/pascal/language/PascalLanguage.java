package org.pcsoft.plugins.intellij.pascal.language;

import com.intellij.lang.Language;

/**
 * Created by Christoph on 30.09.2016.
 */
public class PascalLanguage extends Language {
    public static final PascalLanguage INSTANCE = new PascalLanguage();

    public PascalLanguage() {
        super("Object Pascal");
    }

    @Override
    public boolean isCaseSensitive() {
        return false;
    }
}
