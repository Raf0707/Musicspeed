/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.EnumMap
 *  java.util.Iterator
 *  java.util.List
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v1Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1FieldKey;
import org.jaudiotagger.tag.id3.ID3v1Iterator;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v1TagField;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.reference.GenreTypes;

public class ID3v1Tag
extends AbstractID3v1Tag
implements Tag {
    protected static final int BYTE_TO_UNSIGNED = 255;
    protected static final int FIELD_COMMENT_LENGTH = 30;
    protected static final int FIELD_COMMENT_POS = 97;
    protected static final int GENRE_UNDEFINED = 255;
    private static final byte MAJOR_VERSION = 0;
    private static final byte RELEASE = 1;
    private static final byte REVISION = 0;
    protected static final String TYPE_COMMENT = "comment";
    static EnumMap<FieldKey, ID3v1FieldKey> tagFieldToID3v1Field;
    protected String album = "";
    protected String artist = "";
    protected String comment = "";
    protected byte genre = (byte)-1;
    protected String title = "";
    protected String year = "";

    static {
        EnumMap enumMap;
        tagFieldToID3v1Field = enumMap = new EnumMap(FieldKey.class);
        enumMap.put((Enum)FieldKey.ARTIST, (Object)ID3v1FieldKey.ARTIST);
        tagFieldToID3v1Field.put((Enum)FieldKey.ALBUM, (Object)ID3v1FieldKey.ALBUM);
        tagFieldToID3v1Field.put((Enum)FieldKey.TITLE, (Object)ID3v1FieldKey.TITLE);
        tagFieldToID3v1Field.put((Enum)FieldKey.TRACK, (Object)ID3v1FieldKey.TRACK);
        tagFieldToID3v1Field.put((Enum)FieldKey.YEAR, (Object)ID3v1FieldKey.YEAR);
        tagFieldToID3v1Field.put((Enum)FieldKey.GENRE, (Object)ID3v1FieldKey.GENRE);
        tagFieldToID3v1Field.put((Enum)FieldKey.COMMENT, (Object)ID3v1FieldKey.COMMENT);
    }

    public ID3v1Tag() {
    }

    public ID3v1Tag(RandomAccessFile randomAccessFile) throws TagNotFoundException, IOException {
        this(randomAccessFile, "");
    }

    public ID3v1Tag(RandomAccessFile randomAccessFile, String string2) throws TagNotFoundException, IOException {
        this.setLoggingFilename(string2);
        FileChannel fileChannel = randomAccessFile.getChannel();
        fileChannel.position(randomAccessFile.length() - 128L);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)128);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        this.read(byteBuffer);
    }

    public ID3v1Tag(AbstractTag abstractTag) {
        if (abstractTag != null) {
            if (!(abstractTag instanceof ID3v1Tag)) {
                ID3v11Tag iD3v11Tag = abstractTag instanceof ID3v11Tag ? (ID3v11Tag)abstractTag : new ID3v11Tag(abstractTag);
                this.album = iD3v11Tag.album;
                this.artist = iD3v11Tag.artist;
                this.comment = iD3v11Tag.comment;
                this.title = iD3v11Tag.title;
                this.year = iD3v11Tag.year;
                this.genre = iD3v11Tag.genre;
                return;
            }
            throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
        }
    }

    public ID3v1Tag(ID3v1Tag iD3v1Tag) {
        super(iD3v1Tag);
        this.album = iD3v1Tag.album;
        this.artist = iD3v1Tag.artist;
        this.comment = iD3v1Tag.comment;
        this.title = iD3v1Tag.title;
        this.year = iD3v1Tag.year;
        this.genre = iD3v1Tag.genre;
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(fieldKey, arrstring);
    }

    @Override
    public void addField(TagField tagField) {
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) {
        String string2 = arrstring[0];
        if (fieldKey != null) {
            ID3v1FieldKey iD3v1FieldKey = (ID3v1FieldKey)((Object)tagFieldToID3v1Field.get((Object)fieldKey));
            if (iD3v1FieldKey != null) {
                return new ID3v1TagField(iD3v1FieldKey.name(), string2);
            }
            ErrorMessage errorMessage = ErrorMessage.INVALID_FIELD_FOR_ID3V1TAG;
            Object[] arrobject = new Object[]{fieldKey.name()};
            throw new KeyNotFoundException(errorMessage.getMsg(arrobject));
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("tag", this.getIdentifier());
        MP3File.getStructureFormatter().addElement("title", this.title);
        MP3File.getStructureFormatter().addElement("artist", this.artist);
        MP3File.getStructureFormatter().addElement("album", this.album);
        MP3File.getStructureFormatter().addElement("year", this.year);
        MP3File.getStructureFormatter().addElement(TYPE_COMMENT, this.comment);
        MP3File.getStructureFormatter().addElement("genre", this.genre);
        MP3File.getStructureFormatter().closeHeadingElement("tag");
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    @Override
    public void deleteField(String string2) {
        FieldKey fieldKey = FieldKey.valueOf(string2);
        if (fieldKey != null) {
            this.deleteField(fieldKey);
        }
    }

    @Override
    public void deleteField(FieldKey fieldKey) {
        switch (1.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
            default: {
                return;
            }
            case 6: {
                this.setComment("");
                return;
            }
            case 5: {
                this.setYear("");
                return;
            }
            case 4: {
                this.setGenre("");
                return;
            }
            case 3: {
                this.setTitle("");
                return;
            }
            case 2: {
                this.setAlbum("");
                return;
            }
            case 1: 
        }
        this.setArtist("");
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v1Tag)) {
            return false;
        }
        ID3v1Tag iD3v1Tag = (ID3v1Tag)object;
        if (!this.album.equals((Object)iD3v1Tag.album)) {
            return false;
        }
        if (!this.artist.equals((Object)iD3v1Tag.artist)) {
            return false;
        }
        if (!this.comment.equals((Object)iD3v1Tag.comment)) {
            return false;
        }
        if (this.genre != iD3v1Tag.genre) {
            return false;
        }
        if (!this.title.equals((Object)iD3v1Tag.title)) {
            return false;
        }
        boolean bl = this.year.equals((Object)iD3v1Tag.year);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTag.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public List<TagField> getAlbum() {
        if (this.getFirstAlbum().length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.ALBUM.name(), this.getFirstAlbum()));
        }
        return new ArrayList();
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)this.getFirst(fieldKey.name()));
        return arrayList;
    }

    public List<TagField> getArtist() {
        if (this.getFirstArtist().length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.ARTIST.name(), this.getFirstArtist()));
        }
        return new ArrayList();
    }

    @Override
    public List<Artwork> getArtworkList() {
        return Collections.emptyList();
    }

    public List<TagField> getComment() {
        if (this.getFirstComment().length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.COMMENT.name(), this.getFirstComment()));
        }
        return new ArrayList();
    }

    public Charset getEncoding() {
        return StandardCharsets.ISO_8859_1;
    }

    @Override
    public int getFieldCount() {
        return 6;
    }

    @Override
    public int getFieldCountIncludingSubValues() {
        return this.getFieldCount();
    }

    @Override
    public Iterator<TagField> getFields() {
        throw new UnsupportedOperationException("TODO:Not done yet");
    }

    @Override
    public List<TagField> getFields(String string2) {
        if (FieldKey.ARTIST.name().equals((Object)string2)) {
            return this.getArtist();
        }
        if (FieldKey.ALBUM.name().equals((Object)string2)) {
            return this.getAlbum();
        }
        if (FieldKey.TITLE.name().equals((Object)string2)) {
            return this.getTitle();
        }
        if (FieldKey.GENRE.name().equals((Object)string2)) {
            return this.getGenre();
        }
        if (FieldKey.YEAR.name().equals((Object)string2)) {
            return this.getYear();
        }
        if (FieldKey.COMMENT.name().equals((Object)string2)) {
            return this.getComment();
        }
        return new ArrayList();
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) {
        switch (1.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
            default: {
                return new ArrayList();
            }
            case 6: {
                return this.getComment();
            }
            case 5: {
                return this.getYear();
            }
            case 4: {
                return this.getGenre();
            }
            case 3: {
                return this.getTitle();
            }
            case 2: {
                return this.getAlbum();
            }
            case 1: 
        }
        return this.getArtist();
    }

    @Override
    public String getFirst(String string2) {
        FieldKey fieldKey = FieldKey.valueOf(string2);
        if (fieldKey != null) {
            return this.getFirst(fieldKey);
        }
        return "";
    }

    @Override
    public String getFirst(FieldKey fieldKey) {
        switch (1.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
            default: {
                return "";
            }
            case 6: {
                return this.getFirstComment();
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

    public String getFirstAlbum() {
        return this.album;
    }

    public String getFirstArtist() {
        return this.artist;
    }

    @Override
    public Artwork getFirstArtwork() {
        return null;
    }

    public String getFirstComment() {
        return this.comment;
    }

    @Override
    public TagField getFirstField(String string2) {
        Object object = FieldKey.ARTIST.name().equals((Object)string2) ? this.getArtist() : (FieldKey.ALBUM.name().equals((Object)string2) ? this.getAlbum() : (FieldKey.TITLE.name().equals((Object)string2) ? this.getTitle() : (FieldKey.GENRE.name().equals((Object)string2) ? this.getGenre() : (FieldKey.YEAR.name().equals((Object)string2) ? this.getYear() : (FieldKey.COMMENT.name().equals((Object)string2) ? this.getComment() : null)))));
        if (object != null && object.size() > 0) {
            return (TagField)object.get(0);
        }
        return null;
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) {
        List<TagField> list = this.getFields(fieldKey);
        if (list.size() != 0) {
            return (TagField)list.get(0);
        }
        return null;
    }

    public String getFirstGenre() {
        Integer n2 = 255 & this.genre;
        String string2 = GenreTypes.getInstanceOf().getValueForId(n2);
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public String getFirstTitle() {
        return this.title;
    }

    public String getFirstTrack() {
        throw new UnsupportedOperationException("ID3v10 cannot store track numbers");
    }

    public String getFirstYear() {
        return this.year;
    }

    public List<TagField> getGenre() {
        FieldKey fieldKey = FieldKey.GENRE;
        if (this.getFirst(fieldKey).length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.GENRE.name(), this.getFirst(fieldKey)));
        }
        return new ArrayList();
    }

    @Override
    public byte getMajorVersion() {
        return 0;
    }

    @Override
    public byte getRelease() {
        return 1;
    }

    @Override
    public byte getRevision() {
        return 0;
    }

    public String getSubValue(FieldKey fieldKey, int n2, int n3) {
        return this.getValue(fieldKey, n2);
    }

    public List<TagField> getTitle() {
        FieldKey fieldKey = FieldKey.TITLE;
        if (this.getFirst(fieldKey).length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.TITLE.name(), this.getFirst(fieldKey)));
        }
        return new ArrayList();
    }

    public List<TagField> getTrack() {
        throw new UnsupportedOperationException("ID3v10 cannot store track numbers");
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) {
        return this.getFirst(fieldKey);
    }

    public List<TagField> getYear() {
        FieldKey fieldKey = FieldKey.YEAR;
        if (this.getFirst(fieldKey).length() > 0) {
            return this.returnFieldToList(new ID3v1TagField(ID3v1FieldKey.YEAR.name(), this.getFirst(fieldKey)));
        }
        return new ArrayList();
    }

    @Override
    public boolean hasCommonFields() {
        return true;
    }

    @Override
    public boolean hasField(String string2) {
        try {
            boolean bl = this.hasField(FieldKey.valueOf(string2.toUpperCase()));
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.getFirst(fieldKey).length() > 0;
    }

    @Override
    public boolean isEmpty() {
        return this.getFirst(FieldKey.TITLE).length() <= 0 && this.getFirstArtist().length() <= 0 && this.getFirstAlbum().length() <= 0 && this.getFirst(FieldKey.GENRE).length() <= 0 && this.getFirst(FieldKey.YEAR).length() <= 0 && this.getFirstComment().length() <= 0;
    }

    @Override
    public Iterator iterator() {
        return new ID3v1Iterator(this);
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws TagNotFoundException {
        if (this.seek(byteBuffer)) {
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            Logger logger = AbstractID3v1Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Reading v1 tag");
            logger.finer(stringBuilder.toString());
            byte[] arrby = new byte[128];
            byteBuffer.position(0);
            byteBuffer.get(arrby, 0, 128);
            Charset charset = StandardCharsets.ISO_8859_1;
            this.title = string6 = new String(arrby, 3, 30, charset).trim();
            Matcher matcher = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string6);
            if (matcher.find()) {
                this.title = this.title.substring(0, matcher.start());
            }
            this.artist = string3 = new String(arrby, 33, 30, charset).trim();
            Matcher matcher2 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string3);
            if (matcher2.find()) {
                this.artist = this.artist.substring(0, matcher2.start());
            }
            this.album = string5 = new String(arrby, 63, 30, charset).trim();
            Matcher matcher3 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string5);
            Logger logger2 = AbstractID3v1Tag.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":Orig Album is:");
            stringBuilder2.append(this.comment);
            stringBuilder2.append(":");
            logger2.finest(stringBuilder2.toString());
            if (matcher3.find()) {
                this.album = this.album.substring(0, matcher3.start());
                Logger logger3 = AbstractID3v1Tag.logger;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(this.getLoggingFilename());
                stringBuilder3.append(":Album is:");
                stringBuilder3.append(this.album);
                stringBuilder3.append(":");
                logger3.finest(stringBuilder3.toString());
            }
            this.year = string4 = new String(arrby, 93, 4, charset).trim();
            Matcher matcher4 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string4);
            if (matcher4.find()) {
                this.year = this.year.substring(0, matcher4.start());
            }
            this.comment = string2 = new String(arrby, 97, 30, charset).trim();
            Matcher matcher5 = AbstractID3v1Tag.endofStringPattern.matcher((CharSequence)string2);
            Logger logger4 = AbstractID3v1Tag.logger;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(this.getLoggingFilename());
            stringBuilder4.append(":Orig Comment is:");
            stringBuilder4.append(this.comment);
            stringBuilder4.append(":");
            logger4.finest(stringBuilder4.toString());
            if (matcher5.find()) {
                this.comment = this.comment.substring(0, matcher5.start());
                Logger logger5 = AbstractID3v1Tag.logger;
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(this.getLoggingFilename());
                stringBuilder5.append(":Comment is:");
                stringBuilder5.append(this.comment);
                stringBuilder5.append(":");
                logger5.finest(stringBuilder5.toString());
            }
            this.genre = arrby[127];
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":ID3v1 tag not found");
        throw new TagNotFoundException(stringBuilder.toString());
    }

    protected List<TagField> returnFieldToList(ID3v1TagField iD3v1TagField) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)iD3v1TagField);
        return arrayList;
    }

    @Override
    public boolean seek(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[3];
        byteBuffer.get(arrby, 0, 3);
        return Arrays.equals((byte[])arrby, (byte[])AbstractID3v1Tag.TAG_ID);
    }

    public void setAlbum(String string2) {
        if (string2 != null) {
            this.album = ID3Tags.truncate(string2, 30);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public void setArtist(String string2) {
        if (string2 != null) {
            this.artist = ID3Tags.truncate(string2, 30);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public void setComment(String string2) {
        if (string2 != null) {
            this.comment = ID3Tags.truncate(string2, 30);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public boolean setEncoding(Charset charset) {
        return true;
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void setField(TagField tagField) {
        FieldKey fieldKey = FieldKey.valueOf(tagField.getId());
        switch (1.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
            default: {
                return;
            }
            case 6: {
                this.setComment(tagField.toString());
                return;
            }
            case 5: {
                this.setYear(tagField.toString());
                return;
            }
            case 4: {
                this.setGenre(tagField.toString());
                return;
            }
            case 3: {
                this.setTitle(tagField.toString());
                return;
            }
            case 2: {
                this.setAlbum(tagField.toString());
                return;
            }
            case 1: 
        }
        this.setArtist(tagField.toString());
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        throw new UnsupportedOperationException(ErrorMessage.GENERIC_NOT_SUPPORTED.getMsg());
    }

    public void setGenre(String string2) {
        if (string2 != null) {
            Integer n2 = GenreTypes.getInstanceOf().getIdForValue(string2);
            if (n2 != null) {
                this.genre = n2.byteValue();
                return;
            }
            this.genre = (byte)-1;
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public void setTitle(String string2) {
        if (string2 != null) {
            this.title = ID3Tags.truncate(string2, 30);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public void setYear(String string2) {
        this.year = ID3Tags.truncate(string2, 4);
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        AbstractID3v1Tag.logger.config("Saving ID3v1 tag to file");
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
            String string6 = ID3Tags.truncate(this.comment, 30);
            while (n3 < string6.length()) {
                arrby[n3 + 97] = (byte)string6.charAt(n3);
                ++n3;
            }
        }
        if (TagOptionSingleton.getInstance().isId3v1SaveGenre()) {
            arrby[127] = this.genre;
        }
        randomAccessFile.write(arrby);
        AbstractID3v1Tag.logger.config("Saved ID3v1 tag to file");
    }
}

