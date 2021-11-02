/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.EnumSet
 *  java.util.List
 *  java.util.Map
 */
package org.jaudiotagger.audio.generic;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.images.Artwork;

public abstract class GenericTag
extends AbstractTag {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    protected static EnumSet<FieldKey> supportedKeys;

    static {
        FieldKey fieldKey = FieldKey.ALBUM;
        Enum[] arrenum = new FieldKey[]{FieldKey.ARTIST, FieldKey.TITLE, FieldKey.TRACK, FieldKey.GENRE, FieldKey.COMMENT, FieldKey.YEAR};
        supportedKeys = EnumSet.of((Enum)fieldKey, (Enum[])arrenum);
    }

    public static EnumSet<FieldKey> getSupportedKeys() {
        return supportedKeys;
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (supportedKeys.contains((Object)fieldKey)) {
            if (arrstring != null && arrstring[0] != null) {
                return new GenericTagTextField(fieldKey.name(), arrstring[0]);
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new UnsupportedOperationException(ErrorMessage.OPERATION_NOT_SUPPORTED_FOR_FIELD.getMsg(new Object[]{fieldKey}));
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        if (supportedKeys.contains((Object)fieldKey)) {
            this.deleteField(fieldKey.name());
            return;
        }
        throw new UnsupportedOperationException(ErrorMessage.OPERATION_NOT_SUPPORTED_FOR_FIELD.getMsg(new Object[]{fieldKey}));
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        return super.getAll(fieldKey.name());
    }

    @Override
    public List<Artwork> getArtworkList() {
        return Collections.emptyList();
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        List list = (List)this.fields.get((Object)fieldKey.name());
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (supportedKeys.contains((Object)fieldKey)) {
            return this.getFirstField(fieldKey.name());
        }
        throw new UnsupportedOperationException(ErrorMessage.OPERATION_NOT_SUPPORTED_FOR_FIELD.getMsg(new Object[]{fieldKey}));
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (supportedKeys.contains((Object)fieldKey)) {
            return this.getItem(fieldKey.name(), n2);
        }
        throw new UnsupportedOperationException(ErrorMessage.OPERATION_NOT_SUPPORTED_FOR_FIELD.getMsg(new Object[]{fieldKey}));
    }

    @Override
    protected boolean isAllowedEncoding(Charset charset) {
        return true;
    }

    protected class GenericTagTextField
    implements TagTextField {
        private String content;
        private final String id;

        public GenericTagTextField(String string2, String string3) {
            this.id = string2;
            this.content = string3;
        }

        @Override
        public void copyContent(TagField tagField) {
            if (tagField instanceof TagTextField) {
                this.content = ((TagTextField)tagField).getContent();
            }
        }

        @Override
        public String getContent() {
            return this.content;
        }

        @Override
        public Charset getEncoding() {
            return StandardCharsets.ISO_8859_1;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public byte[] getRawContent() {
            String string2 = this.content;
            if (string2 == null) {
                return EMPTY_BYTE_ARRAY;
            }
            return string2.getBytes(this.getEncoding());
        }

        @Override
        public void isBinary(boolean bl) {
        }

        @Override
        public boolean isBinary() {
            return false;
        }

        @Override
        public boolean isCommon() {
            return true;
        }

        @Override
        public boolean isEmpty() {
            return "".equals((Object)this.content);
        }

        @Override
        public void setContent(String string2) {
            this.content = string2;
        }

        @Override
        public void setEncoding(Charset charset) {
        }

        @Override
        public String toString() {
            return this.getContent();
        }
    }

}

