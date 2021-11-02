/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.List
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;

public class Mp4TagTextNumberField
extends Mp4TagTextField {
    public static final int NUMBER_LENGTH = 2;
    protected List<Short> numbers;

    public Mp4TagTextNumberField(String string2, String string3) {
        super(string2, string3);
    }

    public Mp4TagTextNumberField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        Mp4DataBox mp4DataBox = new Mp4DataBox(mp4BoxHeader, byteBuffer);
        this.dataSize = mp4BoxHeader.getDataLength();
        this.content = mp4DataBox.getContent();
        this.numbers = mp4DataBox.getNumbers();
    }

    @Override
    public void copyContent(TagField tagField) {
        if (tagField instanceof Mp4TagTextNumberField) {
            Mp4TagTextNumberField mp4TagTextNumberField = (Mp4TagTextNumberField)tagField;
            this.content = mp4TagTextNumberField.getContent();
            this.numbers = mp4TagTextNumberField.getNumbers();
        }
    }

    @Override
    protected byte[] getDataBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (Short s2 : this.numbers) {
            try {
                byteArrayOutputStream.write(Utils.getSizeBEInt16(s2));
            }
            catch (IOException iOException) {
                throw new RuntimeException((Throwable)iOException);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public Mp4FieldType getFieldType() {
        return Mp4FieldType.IMPLICIT;
    }

    public List<Short> getNumbers() {
        return this.numbers;
    }
}

