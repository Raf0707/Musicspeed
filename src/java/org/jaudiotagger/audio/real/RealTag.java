/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.audio.real;

import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.audio.generic.GenericTag;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;

public class RealTag
extends GenericTag {
    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        FieldKey fieldKey = FieldKey.IS_COMPILATION;
        String[] arrstring = new String[]{String.valueOf((boolean)bl)};
        return this.createField(fieldKey, arrstring);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("REAL ");
        stringBuilder.append(AbstractTag.super.toString());
        return stringBuilder.toString();
    }
}

