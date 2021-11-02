/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.RandomAccessFile
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.exceptions.NoReadPermissionsException
 *  org.jaudiotagger.audio.real.RealTag
 *  org.jaudiotagger.tag.aiff.AiffTag
 *  org.jaudiotagger.tag.asf.AsfTag
 *  org.jaudiotagger.tag.flac.FlacTag
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.AbstractTag
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 *  org.jaudiotagger.tag.mp4.Mp4Tag
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 *  org.jaudiotagger.tag.wav.WavTag
 */
package org.jaudiotagger.audio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.SupportedFileFormat;
import org.jaudiotagger.audio.dsf.Dsf;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.NoReadPermissionsException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.real.RealTag;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.aiff.AiffTag;
import org.jaudiotagger.tag.asf.AsfTag;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.reference.ID3V2Version;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;
import org.jaudiotagger.tag.wav.WavTag;

public class AudioFile {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio");
    protected AudioHeader audioHeader;
    protected String extension;
    protected File file;
    protected Tag tag;

    public AudioFile() {
    }

    public AudioFile(File file, AudioHeader audioHeader, Tag tag) {
        this.file = file;
        this.audioHeader = audioHeader;
        this.tag = tag;
    }

    public AudioFile(String string2, AudioHeader audioHeader, Tag tag) {
        this.file = new File(string2);
        this.audioHeader = audioHeader;
        this.tag = tag;
    }

    public static String getBaseFilename(File file) {
        int n2 = file.getName().toLowerCase().lastIndexOf(".");
        if (n2 > 0) {
            return file.getName().substring(0, n2);
        }
        return file.getName();
    }

    public void checkFileExists(File file) throws FileNotFoundException {
        Logger logger = AudioFile.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading file:path");
        stringBuilder.append(file.getPath());
        stringBuilder.append(":abs:");
        stringBuilder.append(file.getAbsolutePath());
        logger.config(stringBuilder.toString());
        if (file.exists()) {
            return;
        }
        Logger logger2 = AudioFile.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unable to find:");
        stringBuilder2.append(file.getPath());
        logger2.severe(stringBuilder2.toString());
        ErrorMessage errorMessage = ErrorMessage.UNABLE_TO_FIND_FILE;
        Object[] arrobject = new Object[]{file.getPath()};
        throw new FileNotFoundException(errorMessage.getMsg(arrobject));
    }

    protected RandomAccessFile checkFilePermissions(File file, boolean bl) throws ReadOnlyFileException, FileNotFoundException, CannotReadException {
        this.checkFileExists(file);
        if (bl) {
            if (file.canRead()) {
                return new RandomAccessFile(file, "r");
            }
            Logger logger = AudioFile.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to read file:");
            stringBuilder.append(file.getPath());
            logger.severe(stringBuilder.toString());
            ErrorMessage errorMessage = ErrorMessage.GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE;
            Object[] arrobject = new Object[]{file.getPath()};
            throw new NoReadPermissionsException(errorMessage.getMsg(arrobject));
        }
        if (TagOptionSingleton.getInstance().isCheckIsWritable() && !file.canWrite()) {
            ErrorMessage errorMessage = ErrorMessage.NO_PERMISSIONS_TO_WRITE_TO_FILE;
            Object[] arrobject = new Object[]{file.getPath()};
            throw new ReadOnlyFileException(errorMessage.getMsg(arrobject));
        }
        return new RandomAccessFile(file, "rw");
    }

    public void commit() throws CannotWriteException {
        AudioFileIO.write(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public AbstractID3v2Tag convertID3Tag(AbstractID3v2Tag abstractID3v2Tag, ID3V2Version iD3V2Version) {
        if (abstractID3v2Tag instanceof ID3v24Tag) {
            int n2 = 1.$SwitchMap$org$jaudiotagger$tag$reference$ID3V2Version[iD3V2Version.ordinal()];
            if (n2 == 1) return new ID3v22Tag((AbstractTag)((ID3v24Tag)abstractID3v2Tag));
            if (n2 != 2) return null;
            return new ID3v23Tag((AbstractTag)((ID3v24Tag)abstractID3v2Tag));
        }
        if (abstractID3v2Tag instanceof ID3v23Tag) {
            int n3 = 1.$SwitchMap$org$jaudiotagger$tag$reference$ID3V2Version[iD3V2Version.ordinal()];
            if (n3 == 1) return new ID3v22Tag((AbstractTag)((ID3v23Tag)abstractID3v2Tag));
            if (n3 != 3) return null;
            return new ID3v24Tag((AbstractTag)((ID3v23Tag)abstractID3v2Tag));
        }
        if (!(abstractID3v2Tag instanceof ID3v22Tag)) return null;
        int n4 = 1.$SwitchMap$org$jaudiotagger$tag$reference$ID3V2Version[iD3V2Version.ordinal()];
        if (n4 == 2) return new ID3v23Tag((AbstractTag)((ID3v22Tag)abstractID3v2Tag));
        if (n4 != 3) return null;
        return new ID3v24Tag((AbstractTag)((ID3v22Tag)abstractID3v2Tag));
    }

    public Tag createDefaultTag() {
        String string2 = this.getExt();
        if (string2 == null) {
            String string3 = this.file.getName();
            string2 = string3.substring(1 + string3.lastIndexOf(46));
            this.setExt(string2);
        }
        if (SupportedFileFormat.FLAC.getFilesuffix().equals((Object)string2)) {
            return new FlacTag(VorbisCommentTag.createNewTag(), (List)new ArrayList());
        }
        if (SupportedFileFormat.OGG.getFilesuffix().equals((Object)string2)) {
            return VorbisCommentTag.createNewTag();
        }
        if (SupportedFileFormat.MP4.getFilesuffix().equals((Object)string2)) {
            return new Mp4Tag();
        }
        if (SupportedFileFormat.M4A.getFilesuffix().equals((Object)string2)) {
            return new Mp4Tag();
        }
        if (SupportedFileFormat.M4P.getFilesuffix().equals((Object)string2)) {
            return new Mp4Tag();
        }
        if (SupportedFileFormat.WMA.getFilesuffix().equals((Object)string2)) {
            return new AsfTag();
        }
        if (SupportedFileFormat.WAV.getFilesuffix().equals((Object)string2)) {
            return new WavTag(TagOptionSingleton.getInstance().getWavOptions());
        }
        if (SupportedFileFormat.RA.getFilesuffix().equals((Object)string2)) {
            return new RealTag();
        }
        if (SupportedFileFormat.RM.getFilesuffix().equals((Object)string2)) {
            return new RealTag();
        }
        if (SupportedFileFormat.AIF.getFilesuffix().equals((Object)string2)) {
            return new AiffTag();
        }
        if (SupportedFileFormat.AIFC.getFilesuffix().equals((Object)string2)) {
            return new AiffTag();
        }
        if (SupportedFileFormat.AIFF.getFilesuffix().equals((Object)string2)) {
            return new AiffTag();
        }
        if (SupportedFileFormat.DSF.getFilesuffix().equals((Object)string2)) {
            return Dsf.createDefaultTag();
        }
        throw new RuntimeException("Unable to create default tag for this file format");
    }

    public void delete() throws CannotReadException, CannotWriteException {
        AudioFileIO.delete(this);
    }

    public String displayStructureAsPlainText() {
        return "";
    }

    public String displayStructureAsXML() {
        return "";
    }

    public AudioHeader getAudioHeader() {
        return this.audioHeader;
    }

    public String getExt() {
        return this.extension;
    }

    public File getFile() {
        return this.file;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Tag getTagAndConvertOrCreateAndSetDefault() {
        Tag tag = this.getTagOrCreateDefault();
        if (tag instanceof AbstractID3v2Tag) {
            AbstractID3v2Tag abstractID3v2Tag = this.convertID3Tag((AbstractID3v2Tag)tag, TagOptionSingleton.getInstance().getID3V2Version());
            if (abstractID3v2Tag != null) {
                this.setTag((Tag)abstractID3v2Tag);
            } else {
                this.setTag(tag);
            }
        } else {
            this.setTag(tag);
        }
        return this.getTag();
    }

    public Tag getTagOrCreateAndSetDefault() {
        Tag tag = this.getTagOrCreateDefault();
        this.setTag(tag);
        return tag;
    }

    public Tag getTagOrCreateDefault() {
        Tag tag = this.getTag();
        if (tag == null) {
            tag = this.createDefaultTag();
        }
        return tag;
    }

    public void setExt(String string2) {
        this.extension = string2;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioFile ");
        stringBuilder.append(this.getFile().getAbsolutePath());
        stringBuilder.append("  --------\n");
        stringBuilder.append(this.audioHeader.toString());
        stringBuilder.append("\n");
        Tag tag = this.tag;
        String string2 = tag == null ? "" : tag.toString();
        stringBuilder.append(string2);
        stringBuilder.append("\n-------------------");
        return stringBuilder.toString();
    }

}

