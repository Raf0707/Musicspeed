/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM
 *  org.jaudiotagger.tag.id3.framebody.FrameBodySYLT
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyAUT
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAL
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAR
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyETT
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyIMG
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyIND
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyINF
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyLYR
 *  org.jaudiotagger.tag.lyrics3.FieldFrameBodyUnsupported
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodySYLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyAUT;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAL;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAR;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyETT;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyIMG;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyIND;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyINF;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyLYR;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyUnsupported;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Fields;

public class Lyrics3v2Field
extends AbstractTagFrame {
    public Lyrics3v2Field() {
    }

    public Lyrics3v2Field(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public Lyrics3v2Field(AbstractID3v2Frame abstractID3v2Frame) throws TagException {
        block15 : {
            block12 : {
                String string2;
                block14 : {
                    block13 : {
                        block11 : {
                            string2 = abstractID3v2Frame.getIdentifier();
                            if (string2.startsWith("USLT")) {
                                FieldFrameBodyLYR fieldFrameBodyLYR = new FieldFrameBodyLYR("");
                                this.frameBody = fieldFrameBodyLYR;
                                fieldFrameBodyLYR.addLyric((FrameBodyUSLT)abstractID3v2Frame.getBody());
                                return;
                            }
                            if (string2.startsWith("SYLT")) {
                                FieldFrameBodyLYR fieldFrameBodyLYR = new FieldFrameBodyLYR("");
                                this.frameBody = fieldFrameBodyLYR;
                                fieldFrameBodyLYR.addLyric((FrameBodySYLT)abstractID3v2Frame.getBody());
                                return;
                            }
                            if (string2.startsWith("COMM")) {
                                this.frameBody = new FieldFrameBodyINF(((FrameBodyCOMM)abstractID3v2Frame.getBody()).getText());
                                return;
                            }
                            if (!string2.equals((Object)"TCOM")) break block11;
                            AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                            this.frameBody = new FieldFrameBodyAUT("");
                            if (abstractFrameBodyTextInfo != null && abstractFrameBodyTextInfo.getText().length() > 0) {
                                this.frameBody = new FieldFrameBodyAUT(abstractFrameBodyTextInfo.getText());
                                return;
                            }
                            break block12;
                        }
                        if (!string2.equals((Object)"TALB")) break block13;
                        AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                        if (abstractFrameBodyTextInfo != null && abstractFrameBodyTextInfo.getText().length() > 0) {
                            this.frameBody = new FieldFrameBodyEAL(abstractFrameBodyTextInfo.getText());
                            return;
                        }
                        break block12;
                    }
                    if (!string2.equals((Object)"TPE1")) break block14;
                    AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                    if (abstractFrameBodyTextInfo != null && abstractFrameBodyTextInfo.getText().length() > 0) {
                        this.frameBody = new FieldFrameBodyEAR(abstractFrameBodyTextInfo.getText());
                        return;
                    }
                    break block12;
                }
                if (!string2.equals((Object)"TIT2")) break block15;
                AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                if (abstractFrameBodyTextInfo != null && abstractFrameBodyTextInfo.getText().length() > 0) {
                    this.frameBody = new FieldFrameBodyETT(abstractFrameBodyTextInfo.getText());
                }
            }
            return;
        }
        throw new TagException("Cannot createField Lyrics3v2 field from given ID3v2 frame");
    }

    public Lyrics3v2Field(AbstractLyrics3v2FieldFrameBody abstractLyrics3v2FieldFrameBody) {
        this.frameBody = abstractLyrics3v2FieldFrameBody;
    }

    public Lyrics3v2Field(Lyrics3v2Field lyrics3v2Field) {
        super(lyrics3v2Field);
    }

    private AbstractLyrics3v2FieldFrameBody readBody(String string2, ByteBuffer byteBuffer) throws InvalidTagException {
        if (string2.equals((Object)"AUT")) {
            return new FieldFrameBodyAUT(byteBuffer);
        }
        if (string2.equals((Object)"EAL")) {
            return new FieldFrameBodyEAL(byteBuffer);
        }
        if (string2.equals((Object)"EAR")) {
            return new FieldFrameBodyEAR(byteBuffer);
        }
        if (string2.equals((Object)"ETT")) {
            return new FieldFrameBodyETT(byteBuffer);
        }
        if (string2.equals((Object)"IMG")) {
            return new FieldFrameBodyIMG(byteBuffer);
        }
        if (string2.equals((Object)"IND")) {
            return new FieldFrameBodyIND(byteBuffer);
        }
        if (string2.equals((Object)"INF")) {
            return new FieldFrameBodyINF(byteBuffer);
        }
        if (string2.equals((Object)"LYR")) {
            return new FieldFrameBodyLYR(byteBuffer);
        }
        return new FieldFrameBodyUnsupported(byteBuffer);
    }

    @Override
    public String getIdentifier() {
        AbstractTagFrameBody abstractTagFrameBody = this.frameBody;
        if (abstractTagFrameBody == null) {
            return "";
        }
        return abstractTagFrameBody.getIdentifier();
    }

    @Override
    public int getSize() {
        return 5 + this.frameBody.getSize() + this.getIdentifier().length();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        byte[] arrby = new byte[6];
        while (byteBuffer.get() == 0) {
        }
        byteBuffer.position(-1 + byteBuffer.position());
        byteBuffer.get(arrby, 0, 3);
        String string2 = new String(arrby, 0, 3);
        if (Lyrics3v2Fields.isLyrics3v2FieldIdentifier(string2)) {
            this.frameBody = this.readBody(string2, byteBuffer);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" is not a valid ID3v2.4 frame");
        throw new InvalidTagException(stringBuilder.toString());
    }

    @Override
    public String toString() {
        AbstractTagFrameBody abstractTagFrameBody = this.frameBody;
        if (abstractTagFrameBody == null) {
            return "";
        }
        return abstractTagFrameBody.toString();
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        if (this.frameBody.getSize() > 0 || TagOptionSingleton.getInstance().isLyrics3SaveEmptyField()) {
            byte[] arrby = new byte[3];
            String string2 = this.getIdentifier();
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                arrby[i2] = (byte)string2.charAt(i2);
            }
            randomAccessFile.write(arrby, 0, string2.length());
        }
    }
}

