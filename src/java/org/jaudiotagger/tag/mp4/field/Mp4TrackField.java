/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.List
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField;

public class Mp4TrackField
extends Mp4TagTextNumberField {
    private static final int NONE_END_VALUE_INDEX = 3;
    private static final int NONE_VALUE_INDEX = 0;
    private static final int TRACK_NO_INDEX = 1;
    private static final int TRACK_TOTAL_INDEX = 2;

    public Mp4TrackField(int n2) {
        ArrayList arrayList;
        super(Mp4FieldKey.TRACK.getFieldName(), String.valueOf((int)n2));
        this.numbers = arrayList = new ArrayList();
        arrayList.add((Object)new Short("0"));
        this.numbers.add((Object)((short)n2));
        this.numbers.add((Object)new Short("0"));
        this.numbers.add((Object)new Short("0"));
    }

    public Mp4TrackField(int n2, int n3) {
        ArrayList arrayList;
        super(Mp4FieldKey.TRACK.getFieldName(), String.valueOf((int)n2));
        this.numbers = arrayList = new ArrayList();
        arrayList.add((Object)new Short("0"));
        this.numbers.add((Object)((short)n2));
        this.numbers.add((Object)((short)n3));
        this.numbers.add((Object)new Short("0"));
    }

    public Mp4TrackField(String string2) throws FieldDataInvalidException {
        ArrayList arrayList;
        super(Mp4FieldKey.TRACK.getFieldName(), string2);
        this.numbers = arrayList = new ArrayList();
        arrayList.add((Object)new Short("0"));
        String[] arrstring = string2.split("/");
        int n2 = arrstring.length;
        if (n2 != 1) {
            if (n2 == 2) {
                try {
                    this.numbers.add((Object)Short.parseShort((String)arrstring[0]));
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Value of:");
                    stringBuilder.append(arrstring[0]);
                    stringBuilder.append(" is invalid for field:");
                    stringBuilder.append(this.id);
                    throw new FieldDataInvalidException(stringBuilder.toString());
                }
                try {
                    this.numbers.add((Object)Short.parseShort((String)arrstring[1]));
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Value of:");
                    stringBuilder.append(arrstring[1]);
                    stringBuilder.append(" is invalid for field:");
                    stringBuilder.append(this.id);
                    throw new FieldDataInvalidException(stringBuilder.toString());
                }
                this.numbers.add((Object)new Short("0"));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value is invalid for field:");
            stringBuilder.append(this.id);
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
        try {
            this.numbers.add((Object)Short.parseShort((String)arrstring[0]));
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value of:");
            stringBuilder.append(arrstring[0]);
            stringBuilder.append(" is invalid for field:");
            stringBuilder.append(this.id);
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
        this.numbers.add((Object)new Short("0"));
        this.numbers.add((Object)new Short("0"));
    }

    public Mp4TrackField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        Mp4DataBox mp4DataBox = new Mp4DataBox(mp4BoxHeader, byteBuffer);
        this.dataSize = mp4BoxHeader.getDataLength();
        this.numbers = mp4DataBox.getNumbers();
        StringBuffer stringBuffer = new StringBuffer();
        List<Short> list = this.numbers;
        if (list != null) {
            if (list.size() > 1 && (Short)this.numbers.get(1) > 0) {
                stringBuffer.append(this.numbers.get(1));
            }
            if (this.numbers.size() > 2 && (Short)this.numbers.get(2) > 0) {
                stringBuffer.append("/");
                stringBuffer.append(this.numbers.get(2));
            }
        }
        this.content = stringBuffer.toString();
    }

    public Short getTrackNo() {
        return (Short)this.numbers.get(1);
    }

    public Short getTrackTotal() {
        if (this.numbers.size() <= 2) {
            return (short)0;
        }
        return (Short)this.numbers.get(2);
    }

    public void setTrackNo(int n2) {
        this.numbers.set(1, (Object)((short)n2));
    }

    public void setTrackTotal(int n2) {
        this.numbers.set(2, (Object)((short)n2));
    }
}

