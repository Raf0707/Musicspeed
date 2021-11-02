/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.TCONString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.id3.valuepair.ID3V2ExtendedGenreTypes;
import org.jaudiotagger.tag.reference.GenreTypes;

public class FrameBodyTCON
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyTCON() {
    }

    public FrameBodyTCON(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTCON(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTCON(FrameBodyTCON frameBodyTCON) {
        super(frameBodyTCON);
    }

    private static String bracketWrap(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private static String checkBracketed(String string2) {
        String string3 = string2.replace((CharSequence)"(", (CharSequence)"").replace((CharSequence)")", (CharSequence)"");
        try {
            int n2 = Integer.parseInt((String)string3);
            if (n2 <= GenreTypes.getMaxGenreId()) {
                string3 = GenreTypes.getInstanceOf().getValueForId(n2);
            }
            return string3;
        }
        catch (NumberFormatException numberFormatException) {
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes = ID3V2ExtendedGenreTypes.RX;
            if (string3.equalsIgnoreCase(iD3V2ExtendedGenreTypes.name())) {
                return iD3V2ExtendedGenreTypes.getDescription();
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes2 = ID3V2ExtendedGenreTypes.CR;
            if (string3.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.name())) {
                string3 = iD3V2ExtendedGenreTypes2.getDescription();
            }
            return string3;
        }
    }

    public static String convertGenericToID3v22Genre(String string2) {
        return FrameBodyTCON.convertGenericToID3v23Genre(string2);
    }

    public static String convertGenericToID3v23Genre(String string2) {
        try {
            int n2 = Integer.parseInt((String)string2);
            if (n2 <= GenreTypes.getMaxGenreId()) {
                string2 = FrameBodyTCON.bracketWrap(String.valueOf((int)n2));
            }
            return string2;
        }
        catch (NumberFormatException numberFormatException) {
            Integer n3 = GenreTypes.getInstanceOf().getIdForName(string2);
            if (n3 != null && n3 <= GenreTypes.getMaxStandardGenreId()) {
                return FrameBodyTCON.bracketWrap(String.valueOf((Object)n3));
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes = ID3V2ExtendedGenreTypes.RX;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes.getDescription())) {
                return FrameBodyTCON.bracketWrap(iD3V2ExtendedGenreTypes.name());
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes2 = ID3V2ExtendedGenreTypes.CR;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.getDescription())) {
                return FrameBodyTCON.bracketWrap(iD3V2ExtendedGenreTypes2.name());
            }
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes.name())) {
                return FrameBodyTCON.bracketWrap(iD3V2ExtendedGenreTypes.name());
            }
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.name())) {
                string2 = FrameBodyTCON.bracketWrap(iD3V2ExtendedGenreTypes2.name());
            }
            return string2;
        }
    }

    public static String convertGenericToID3v24Genre(String string2) {
        try {
            int n2 = Integer.parseInt((String)string2);
            if (n2 <= GenreTypes.getMaxGenreId()) {
                string2 = String.valueOf((int)n2);
            }
            return string2;
        }
        catch (NumberFormatException numberFormatException) {
            Integer n3 = GenreTypes.getInstanceOf().getIdForName(string2);
            if (n3 != null && n3 <= GenreTypes.getMaxStandardGenreId()) {
                return String.valueOf((Object)n3);
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes = ID3V2ExtendedGenreTypes.RX;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes.getDescription())) {
                return iD3V2ExtendedGenreTypes.name();
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes2 = ID3V2ExtendedGenreTypes.CR;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.getDescription())) {
                return iD3V2ExtendedGenreTypes2.name();
            }
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes.name())) {
                return iD3V2ExtendedGenreTypes.name();
            }
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.name())) {
                string2 = iD3V2ExtendedGenreTypes2.name();
            }
            return string2;
        }
    }

    public static String convertID3v22GenreToGeneric(String string2) {
        return FrameBodyTCON.convertID3v23GenreToGeneric(string2);
    }

    public static String convertID3v23GenreToGeneric(String string2) {
        if (string2.contains((CharSequence)")") && string2.lastIndexOf(41) < -1 + string2.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FrameBodyTCON.checkBracketed(string2.substring(0, string2.lastIndexOf(41))));
            stringBuilder.append(' ');
            stringBuilder.append(string2.substring(1 + string2.lastIndexOf(41)));
            return stringBuilder.toString();
        }
        return FrameBodyTCON.checkBracketed(string2);
    }

    public static String convertID3v24GenreToGeneric(String string2) {
        try {
            int n2 = Integer.parseInt((String)string2);
            if (n2 <= GenreTypes.getMaxGenreId()) {
                string2 = GenreTypes.getInstanceOf().getValueForId(n2);
            }
            return string2;
        }
        catch (NumberFormatException numberFormatException) {
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes = ID3V2ExtendedGenreTypes.RX;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes.name())) {
                return iD3V2ExtendedGenreTypes.getDescription();
            }
            ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes2 = ID3V2ExtendedGenreTypes.CR;
            if (string2.equalsIgnoreCase(iD3V2ExtendedGenreTypes2.name())) {
                string2 = iD3V2ExtendedGenreTypes2.getDescription();
            }
            return string2;
        }
    }

    @Override
    public String getIdentifier() {
        return "TCON";
    }

    public void setV23Format() {
        ((TCONString)this.getObject("Text")).setNullSeperateMultipleValues(false);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new TCONString("Text", this));
    }
}

