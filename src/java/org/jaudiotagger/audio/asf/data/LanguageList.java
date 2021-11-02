/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.logging.ErrorMessage;

public class LanguageList
extends Chunk {
    private final List<String> languages = new ArrayList();

    public LanguageList() {
        super(GUID.GUID_LANGUAGE_LIST, 0L, BigInteger.ZERO);
    }

    public LanguageList(long l2, BigInteger bigInteger) {
        super(GUID.GUID_LANGUAGE_LIST, l2, bigInteger);
    }

    public void addLanguage(String string2) {
        if (string2.length() < 127) {
            if (!this.languages.contains((Object)string2)) {
                this.languages.add((Object)string2);
            }
            return;
        }
        ErrorMessage errorMessage = ErrorMessage.WMA_LENGTH_OF_LANGUAGE_IS_TOO_LARGE;
        Object[] arrobject = new Object[]{2 + 2 * string2.length()};
        throw new IllegalArgumentException(errorMessage.getMsg(arrobject));
    }

    public String getLanguage(int n2) {
        return (String)this.languages.get(n2);
    }

    public int getLanguageCount() {
        return this.languages.size();
    }

    public List<String> getLanguages() {
        return new ArrayList(this.languages);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        for (int i2 = 0; i2 < this.getLanguageCount(); ++i2) {
            stringBuilder.append(string2);
            stringBuilder.append("  |-> ");
            stringBuilder.append(i2);
            stringBuilder.append(" : ");
            stringBuilder.append(this.getLanguage(i2));
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public void removeLanguage(int n2) {
        this.languages.remove(n2);
    }
}

