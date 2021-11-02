/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.EnumSet
 *  java.util.List
 */
package org.jaudiotagger.tag.wav;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.audio.generic.GenericTag;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;

public class WavInfoTag
extends GenericTag {
    private Long endLocationInFile = null;
    private Long startLocationInFile = null;
    private List<TagTextField> unrecognisedFields = new ArrayList();

    static {
        FieldKey fieldKey = FieldKey.ALBUM;
        Enum[] arrenum = new FieldKey[]{FieldKey.ARTIST, FieldKey.ALBUM_ARTIST, FieldKey.TITLE, FieldKey.TRACK, FieldKey.GENRE, FieldKey.COMMENT, FieldKey.YEAR, FieldKey.RECORD_LABEL, FieldKey.ISRC, FieldKey.COMPOSER, FieldKey.LYRICIST, FieldKey.ENCODER, FieldKey.CONDUCTOR, FieldKey.RATING};
        GenericTag.supportedKeys = EnumSet.of((Enum)fieldKey, (Enum[])arrenum);
    }

    public void addUnRecognizedField(String string2, String string3) {
        this.unrecognisedFields.add((Object)new GenericTag.GenericTagTextField(this, string2, string3));
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        FieldKey fieldKey = FieldKey.IS_COMPILATION;
        String[] arrstring = new String[]{String.valueOf((boolean)bl)};
        return this.createField(fieldKey, arrstring);
    }

    public Long getEndLocationInFile() {
        return this.endLocationInFile;
    }

    public long getSizeOfTag() {
        Long l2 = this.endLocationInFile;
        if (l2 != null && this.startLocationInFile != null) {
            return l2 - this.startLocationInFile - 8L;
        }
        return 0L;
    }

    public Long getStartLocationInFile() {
        return this.startLocationInFile;
    }

    public List<TagTextField> getUnrecognisedFields() {
        return this.unrecognisedFields;
    }

    public void setEndLocationInFile(long l2) {
        this.endLocationInFile = l2;
    }

    public void setStartLocationInFile(long l2) {
        this.startLocationInFile = l2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Wav Info Tag:\n");
        if (this.getStartLocationInFile() != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\tstartLocation:");
            stringBuilder2.append(Hex.asDecAndHex(this.getStartLocationInFile()));
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.getEndLocationInFile() != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("\tendLocation:");
            stringBuilder3.append(Hex.asDecAndHex(this.getEndLocationInFile()));
            stringBuilder3.append("\n");
            stringBuilder.append(stringBuilder3.toString());
        }
        stringBuilder.append(AbstractTag.super.toString());
        if (this.unrecognisedFields.size() > 0) {
            stringBuilder.append("\nUnrecognized Tags:\n");
            for (TagTextField tagTextField : this.unrecognisedFields) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("\t");
                stringBuilder4.append(tagTextField.getId());
                stringBuilder4.append(":");
                stringBuilder4.append(tagTextField.getContent());
                stringBuilder4.append("\n");
                stringBuilder.append(stringBuilder4.toString());
            }
        }
        return stringBuilder.toString();
    }
}

