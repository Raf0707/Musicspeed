/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;

public class Mp4TagByteField
extends Mp4TagTextField {
    public static String FALSE_VALUE = "0";
    public static String TRUE_VALUE = "1";
    private byte[] bytedata;
    private int realDataLength;

    public Mp4TagByteField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    public Mp4TagByteField(Mp4FieldKey mp4FieldKey, String string2) throws FieldDataInvalidException {
        this(mp4FieldKey, string2, 1);
    }

    public Mp4TagByteField(Mp4FieldKey mp4FieldKey, String string2, int n2) throws FieldDataInvalidException {
        super(mp4FieldKey.getFieldName(), string2);
        this.realDataLength = n2;
        try {
            Long.parseLong((String)string2);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value of:");
            stringBuilder.append(string2);
            stringBuilder.append(" is invalid for field:");
            stringBuilder.append((Object)mp4FieldKey);
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
    }

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        int n2;
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        Mp4DataBox mp4DataBox = new Mp4DataBox(mp4BoxHeader, byteBuffer);
        this.dataSize = n2 = mp4BoxHeader.getDataLength();
        this.realDataLength = n2 - 8;
        this.bytedata = mp4DataBox.getByteData();
        this.content = mp4DataBox.getContent();
    }

    @Override
    protected byte[] getDataBytes() throws UnsupportedEncodingException {
        byte[] arrby = this.bytedata;
        if (arrby != null) {
            return arrby;
        }
        int n2 = this.realDataLength;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 4) {
                    return Utils.getSizeBEInt32(new Integer(this.content));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.id);
                stringBuilder.append(":");
                stringBuilder.append(this.realDataLength);
                stringBuilder.append(":Dont know how to write byte fields of this length");
                throw new RuntimeException(stringBuilder.toString());
            }
            return Utils.getSizeBEInt16(new Short(this.content));
        }
        Short s2 = new Short(this.content);
        byte[] arrby2 = new byte[]{s2.byteValue()};
        return arrby2;
    }

    @Override
    public Mp4FieldType getFieldType() {
        return Mp4FieldType.INTEGER;
    }
}

