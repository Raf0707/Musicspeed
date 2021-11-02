/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.id3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.id3.ID3v1FieldKey;

public class ID3v1TagField
implements TagTextField {
    private boolean common;
    private String content;
    private String id;

    public ID3v1TagField(String string2, String string3) {
        this.id = string2.toUpperCase();
        this.content = string3;
        this.checkCommon();
    }

    public ID3v1TagField(byte[] arrby) throws UnsupportedEncodingException {
        String string2 = new String(arrby, StandardCharsets.ISO_8859_1);
        int n2 = string2.indexOf(61);
        if (n2 == -1) {
            this.id = "ERRONEOUS";
            this.content = string2;
        } else {
            this.id = string2.substring(0, n2).toUpperCase();
            this.content = string2.length() > n2 ? string2.substring(n2 + 1) : "";
        }
        this.checkCommon();
    }

    private void checkCommon() {
        boolean bl = this.id.equals((Object)ID3v1FieldKey.TITLE.name()) || this.id.equals((Object)ID3v1FieldKey.ALBUM.name()) || this.id.equals((Object)ID3v1FieldKey.ARTIST.name()) || this.id.equals((Object)ID3v1FieldKey.GENRE.name()) || this.id.equals((Object)ID3v1FieldKey.YEAR.name()) || this.id.equals((Object)ID3v1FieldKey.COMMENT.name()) || this.id.equals((Object)ID3v1FieldKey.TRACK.name());
        this.common = bl;
    }

    protected void copy(byte[] arrby, byte[] arrby2, int n2) {
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)n2, (int)arrby.length);
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
    public byte[] getRawContent() throws UnsupportedEncodingException {
        byte[] arrby = new byte[4];
        String string2 = this.id;
        Charset charset = StandardCharsets.ISO_8859_1;
        byte[] arrby2 = string2.getBytes(charset);
        byte[] arrby3 = this.content.getBytes(charset);
        byte[] arrby4 = new byte[1 + (4 + arrby2.length) + arrby3.length];
        int n2 = 1 + arrby2.length + arrby3.length;
        arrby[3] = (byte)((-16777216 & n2) >> 24);
        arrby[2] = (byte)((16711680 & n2) >> 16);
        arrby[1] = (byte)((65280 & n2) >> 8);
        arrby[0] = (byte)(n2 & 255);
        this.copy(arrby, arrby4, 0);
        this.copy(arrby2, arrby4, 4);
        int n3 = 4 + arrby2.length;
        arrby4[n3] = 61;
        this.copy(arrby3, arrby4, n3 + 1);
        return arrby4;
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
        return this.common;
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

