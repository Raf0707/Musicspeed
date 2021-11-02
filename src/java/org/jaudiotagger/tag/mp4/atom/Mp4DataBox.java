/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.ListIterator
 */
package org.jaudiotagger.tag.mp4.atom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public class Mp4DataBox
extends AbstractMp4Box {
    public static final int DATA_HEADER_LENGTH = 16;
    public static final String IDENTIFIER = "data";
    public static final int NULL_LENGTH = 4;
    public static final int NUMBER_LENGTH = 2;
    public static final int PRE_DATA_LENGTH = 8;
    public static final int TYPE_LENGTH = 3;
    public static final int TYPE_POS = 1;
    public static final int TYPE_POS_INCLUDING_HEADER = 9;
    public static final int VERSION_LENGTH = 1;
    private byte[] bytedata;
    private String content;
    private List<Short> numbers;
    private int type;

    public Mp4DataBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        if (mp4BoxHeader.getId().equals((Object)IDENTIFIER)) {
            int n2;
            int n3;
            ByteBuffer byteBuffer2;
            this.dataBuffer = byteBuffer2 = byteBuffer.slice();
            this.type = n3 = Utils.getIntBE(byteBuffer2, 1, 3);
            if (n3 == Mp4FieldType.TEXT.getFileClassId()) {
                this.content = Utils.getString(this.dataBuffer, 8, mp4BoxHeader.getDataLength() - 8, mp4BoxHeader.getEncoding());
                return;
            }
            int n4 = this.type;
            int n5 = Mp4FieldType.IMPLICIT.getFileClassId();
            if (n4 == n5) {
                this.numbers = new ArrayList();
                for (n2 = 0; n2 < (mp4BoxHeader.getDataLength() - 8) / 2; ++n2) {
                    ByteBuffer byteBuffer3 = this.dataBuffer;
                    int n6 = 8 + n2 * 2;
                    short s2 = Utils.getShortBE(byteBuffer3, n6, n6 + 1);
                    this.numbers.add((Object)s2);
                }
                StringBuffer stringBuffer = new StringBuffer();
                ListIterator listIterator = this.numbers.listIterator();
                while (listIterator.hasNext()) {
                    stringBuffer.append(listIterator.next());
                    if (!listIterator.hasNext()) continue;
                    stringBuffer.append("/");
                }
                this.content = stringBuffer.toString();
                return;
            }
            if (this.type == Mp4FieldType.INTEGER.getFileClassId()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Utils.getIntBE(this.dataBuffer, 8, mp4BoxHeader.getDataLength() - 1));
                stringBuilder.append("");
                this.content = stringBuilder.toString();
                this.bytedata = new byte[mp4BoxHeader.getDataLength() - 8];
                int n7 = byteBuffer.position();
                byteBuffer.position(n7 + 8);
                byteBuffer.get(this.bytedata);
                byteBuffer.position(n7);
                this.numbers = new ArrayList();
                while (n2 < (mp4BoxHeader.getDataLength() - 8) / 2) {
                    ByteBuffer byteBuffer4 = this.dataBuffer;
                    int n8 = 8 + n2 * 2;
                    short s3 = Utils.getShortBE(byteBuffer4, n8, n8 + 1);
                    this.numbers.add((Object)s3);
                    ++n2;
                }
            } else if (this.type == Mp4FieldType.COVERART_JPEG.getFileClassId()) {
                this.content = Utils.getString(this.dataBuffer, 8, mp4BoxHeader.getDataLength() - 8, mp4BoxHeader.getEncoding());
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to process data box because identifier is:");
        stringBuilder.append(mp4BoxHeader.getId());
        throw new RuntimeException(stringBuilder.toString());
    }

    public byte[] getByteData() {
        return this.bytedata;
    }

    public String getContent() {
        return this.content;
    }

    public List<Short> getNumbers() {
        return this.numbers;
    }

    public int getType() {
        return this.type;
    }
}

