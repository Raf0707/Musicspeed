/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.jaudiotagger.tag.id3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v1Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1FieldKey;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v1TagField;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTALB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT2;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE1;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRCK;
import org.jaudiotagger.tag.reference.GenreTypes;

public class ID3v11Tag
extends ID3v1Tag {
    protected static final int FIELD_COMMENT_LENGTH = 28;
    protected static final int FIELD_COMMENT_POS = 97;
    protected static final int FIELD_TRACK_INDICATOR_LENGTH = 1;
    protected static final int FIELD_TRACK_INDICATOR_POS = 125;
    protected static final int FIELD_TRACK_LENGTH = 1;
    protected static final int FIELD_TRACK_POS = 126;
    private static final byte MAJOR_VERSION = 1;
    private static final byte RELEASE = 1;
    private static final byte REVISION = 0;
    protected static final int TRACK_MAX_VALUE = 255;
    protected static final int TRACK_MIN_VALUE = 1;
    protected static final int TRACK_UNDEFINED = 0;
    protected static final String TYPE_TRACK = "track";
    protected byte track = 0;

    public ID3v11Tag() {
    }

    public ID3v11Tag(RandomAccessFile randomAccessFile) throws TagNotFoundException, IOException {
        this(randomAccessFile, "");
    }

    public ID3v11Tag(RandomAccessFile randomAccessFile, String string2) throws TagNotFoundException, IOException {
        this.setLoggingFilename(string2);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)128);
        FileChannel fileChannel = randomAccessFile.getChannel();
        fileChannel.position(randomAccessFile.length() - 128L);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        this.read(byteBuffer);
    }

    public ID3v11Tag(AbstractTag abstractTag) {
        if (abstractTag != null) {
            if (abstractTag instanceof ID3v1Tag) {
                if (!(abstractTag instanceof ID3v11Tag)) {
                    ID3v1Tag iD3v1Tag = (ID3v1Tag)abstractTag;
                    this.title = iD3v1Tag.title;
                    this.artist = iD3v1Tag.artist;
                    this.album = iD3v1Tag.album;
                    this.comment = iD3v1Tag.comment;
                    this.year = iD3v1Tag.year;
                    this.genre = iD3v1Tag.genre;
                    return;
                }
                throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
            }
            ID3v24Tag iD3v24Tag = !(abstractTag instanceof ID3v24Tag) ? new ID3v24Tag(abstractTag) : (ID3v24Tag)abstractTag;
            if (iD3v24Tag.hasFrame("TIT2")) {
                this.title = ID3Tags.truncate(((FrameBodyTIT2)((ID3v24Frame)iD3v24Tag.getFrame("TIT2")).getBody()).getText(), 30);
            }
            if (iD3v24Tag.hasFrame("TPE1")) {
                this.artist = ID3Tags.truncate(((FrameBodyTPE1)((ID3v24Frame)iD3v24Tag.getFrame("TPE1")).getBody()).getText(), 30);
            }
            if (iD3v24Tag.hasFrame("TALB")) {
                this.album = ID3Tags.truncate(((FrameBodyTALB)((ID3v24Frame)iD3v24Tag.getFrame("TALB")).getBody()).getText(), 30);
            }
            if (iD3v24Tag.hasFrame("TDRC")) {
                this.year = ID3Tags.truncate(((FrameBodyTDRC)((ID3v24Frame)iD3v24Tag.getFrame("TDRC")).getBody()).getText(), 4);
            }
            if (iD3v24Tag.hasFrame("COMM")) {
                Iterator iterator = iD3v24Tag.getFrameOfType("COMM");
                String string2 = "";
                while (iterator.hasNext()) {
                    ID3v24Frame iD3v24Frame = (ID3v24Frame)iterator.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(((FrameBodyCOMM)iD3v24Frame.getBody()).getText());
                    stringBuilder.append(" ");
                    string2 = stringBuilder.toString();
                }
                this.comment = ID3Tags.truncate(string2, 28);
            }
            if (iD3v24Tag.hasFrame("TCON")) {
                String string3 = ((FrameBodyTCON)((ID3v24Frame)iD3v24Tag.getFrame("TCON")).getBody()).getText();
                try {
                    this.genre = (byte)ID3Tags.findNumber(string3);
                }
                catch (TagException tagException) {
                    Integer n2 = GenreTypes.getInstanceOf().getIdForValue(string3);
                    if (n2 != null) {
                        this.genre = n2.byteValue();
                    }
                    Logger logger = AbstractID3v1Tag.logger;
                    Level level = Level.WARNING;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(":Unable to convert TCON frame to format suitable for v11 tag");
                    logger.log(level, stringBuilder.toString(), (Throwable)tagException);
                    this.genre = (byte)-1;
                }
            }
            if (iD3v24Tag.hasFrame("TRCK")) {
                this.track = (byte)((FrameBodyTRCK)((ID3v24Frame)iD3v24Tag.getFrame("TRCK")).getBody()).getTrackNo().intValue();
            }
        }
    }

    public ID3v11Tag(ID3v11Tag iD3v11Tag) {
        super(iD3v11Tag);
        this.track = iD3v11Tag.track;
    }

    public void addTrack(String string2) {
        this.setTrack(string2);
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("tag", this.getIdentifier());
        MP3File.getStructureFormatter().addElement("title", this.title);
        MP3File.getStructureFormatter().addElement("artist", this.artist);
        MP3File.getStructureFormatter().addElement("album", this.album);
        MP3File.getStructureFormatter().addElement("year", this.year);
        MP3File.getStructureFormatter().addElement("comment", this.comment);
        MP3File.getStructureFormatter().addElement(TYPE_TRACK, this.track);
        MP3File.getStructureFormatter().addElement("genre", this.genre);
        MP3File.getStructureFormatter().closeHeadingElement("tag");
    }

    @Override
    public void deleteField(FieldKey fieldKey) {
        if (fieldKey == FieldKey.TRACK) {
            this.track = 0;
            return;
        }
        super.deleteField(fieldKey);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v11Tag)) {
            return false;
        }
        ID3v11Tag iD3v11Tag = (ID3v11Tag)object;
        byte by = this.track;
        byte by2 = iD3v11Tag.track;
        boolean bl = false;
        if (by == by2) {
            boolean bl2 = super.equals(object);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public int getFieldCount() {
        return 7;
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) {
        if (fieldKey == FieldKey.TRACK) {
            return this.getTrack();
        }
        return super.getFields(fieldKey);
    }

    @Override
    public String getFirst(FieldKey fieldKey) {
        switch (1.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
            default: {
                return "";
            }
            case 7: {
                return this.getFirstComment();
            }
            case 6: {
                return this.getFirstTrack();
            }
            case 5: {
                return this.getFirstYear();
            }
            case 4: {
                return this.getFirstGenre();
            }
            case 3: {
                return this.getFirstTitle();
            }
            case 2: {
                return this.getFirstAlbum();
            }
            case 1: 
        }
        return this.getFirstArtist();
    }

    @Override
    public String getFirstComment() {
        return this.comment;
    }

    @Override
    public TagField getFirstField(String string2) {
        if (FieldKey.TRACK.name().equals((Object)string2)) {
            List<TagField> list = this.getTrack();
            if (list != null && list.size() > 0) {
                return (TagField)list.get(0);
            }
            return null;
        }
        return super.getFirstField(string2);
    }

    @Override
    public String getFirstTrack() {
        return String.valueOf((int)(255 & this.track));
    }

    @Override
    public byte getMajorVersion() {
        return 1;
    }

    @Override
    public byte getRelease() {
        return 1;
    }

    @Override
    public byte getRevision() {
        return 0;
    }

    @Override
    public List<TagField> getTrack() {
        FieldKey fieldKey = FieldKey.TRACK;
        if (this.getFirst(fieldKey).length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.TRACK.name(), this.getFirst(fieldKey)));
        }
        return new ArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.track <= 0 && super.isEmpty();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws TagNotFoundException {
        if (this.seek(byteBuffer)) {
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            AbstractID3v1Tag.logger.finer("Reading v1.1 tag");
            byte[] arrby = new byte[128];
            byteBuffer.position(0);
            byteBuffer.get(arrby, 0, 128);
            Charset charset = StandardCharsets.ISO_8859_1;
            this.title = string5 = new String(arrby, 3, 30, charset).trim();
            Matcher matcher = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string5);
            if (matcher.find()) {
                this.title = this.title.substring(0, matcher.start());
            }
            this.artist = string4 = new String(arrby, 33, 30, charset).trim();
            Matcher matcher2 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string4);
            if (matcher2.find()) {
                this.artist = this.artist.substring(0, matcher2.start());
            }
            this.album = string2 = new String(arrby, 63, 30, charset).trim();
            Matcher matcher3 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string2);
            if (matcher3.find()) {
                this.album = this.album.substring(0, matcher3.start());
            }
            this.year = string6 = new String(arrby, 93, 4, charset).trim();
            Matcher matcher4 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string6);
            if (matcher4.find()) {
                this.year = this.year.substring(0, matcher4.start());
            }
            this.comment = string3 = new String(arrby, 97, 28, charset).trim();
            Matcher matcher5 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string3);
            if (matcher5.find()) {
                this.comment = this.comment.substring(0, matcher5.start());
            }
            this.track = arrby[126];
            this.genre = arrby[127];
            return;
        }
        throw new TagNotFoundException("ID3v1 tag not found");
    }

    @Override
    public boolean seek(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[3];
        byteBuffer.get(arrby, 0, 3);
        if (!Arrays.equals((byte[])arrby, (byte[])AbstractID3v1Tag.TAG_ID)) {
            return false;
        }
        byteBuffer.position(125);
        if (byteBuffer.get() != 0) {
            return false;
        }
        byte by = byteBuffer.get();
        boolean bl = false;
        if (by != 0) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void setComment(String string2) {
        if (string2 != null) {
            this.comment = ID3Tags.truncate(string2, 28);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void setField(TagField tagField) {
        if (FieldKey.valueOf(tagField.getId()) == FieldKey.TRACK) {
            this.setTrack(tagField.toString());
            return;
        }
        super.setField(tagField);
    }

    /*
     * Exception decompiling
     */
    public void setTrack(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl7 : ILOAD_2 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        AbstractID3v1Tag.logger.config("Saving ID3v11 tag to file");
        byte[] arrby = new byte[128];
        this.delete(randomAccessFile);
        randomAccessFile.seek(randomAccessFile.length());
        byte[] arrby2 = AbstractID3v1Tag.TAG_ID;
        int n2 = arrby2.length;
        int n3 = 0;
        System.arraycopy((Object)arrby2, (int)0, (Object)arrby, (int)0, (int)n2);
        if (TagOptionSingleton.getInstance().isId3v1SaveTitle()) {
            String string2 = ID3Tags.truncate(this.title, 30);
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                arrby[i2 + 3] = (byte)string2.charAt(i2);
            }
        }
        if (TagOptionSingleton.getInstance().isId3v1SaveArtist()) {
            String string3 = ID3Tags.truncate(this.artist, 30);
            for (int i3 = 0; i3 < string3.length(); ++i3) {
                arrby[i3 + 33] = (byte)string3.charAt(i3);
            }
        }
        if (TagOptionSingleton.getInstance().isId3v1SaveAlbum()) {
            String string4 = ID3Tags.truncate(this.album, 30);
            for (int i4 = 0; i4 < string4.length(); ++i4) {
                arrby[i4 + 63] = (byte)string4.charAt(i4);
            }
        }
        if (TagOptionSingleton.getInstance().isId3v1SaveYear()) {
            String string5 = ID3Tags.truncate(this.year, 4);
            for (int i5 = 0; i5 < string5.length(); ++i5) {
                arrby[i5 + 93] = (byte)string5.charAt(i5);
            }
        }
        if (TagOptionSingleton.getInstance().isId3v1SaveComment()) {
            String string6 = ID3Tags.truncate(this.comment, 28);
            while (n3 < string6.length()) {
                arrby[n3 + 97] = (byte)string6.charAt(n3);
                ++n3;
            }
        }
        arrby[126] = this.track;
        if (TagOptionSingleton.getInstance().isId3v1SaveGenre()) {
            arrby[127] = this.genre;
        }
        randomAccessFile.write(arrby);
        AbstractID3v1Tag.logger.config("Saved ID3v11 tag to file");
    }
}

