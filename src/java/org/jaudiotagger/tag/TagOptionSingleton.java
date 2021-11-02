/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Set
 *  org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL
 *  org.jaudiotagger.tag.lyrics3.Lyrics3v2Fields
 *  org.jaudiotagger.tag.reference.GenreTypes
 *  org.jaudiotagger.tag.reference.Languages
 */
package org.jaudiotagger.tag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.audio.wav.WavSaveOrder;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Fields;
import org.jaudiotagger.tag.options.PadNumberOption;
import org.jaudiotagger.tag.reference.GenreTypes;
import org.jaudiotagger.tag.reference.ID3V2Version;
import org.jaudiotagger.tag.reference.Languages;
import org.jaudiotagger.tag.vorbiscomment.VorbisAlbumArtistReadOptions;
import org.jaudiotagger.tag.vorbiscomment.VorbisAlbumArtistSaveOptions;

public class TagOptionSingleton {
    private static String DEFAULT;
    private static String defaultOptions;
    private static HashMap<String, TagOptionSingleton> tagOptionTable;
    private boolean checkIsWritable = false;
    private boolean filenameTagSave = false;
    private boolean id3v1Save = true;
    private boolean id3v1SaveAlbum = true;
    private boolean id3v1SaveArtist = true;
    private boolean id3v1SaveComment = true;
    private boolean id3v1SaveGenre = true;
    private boolean id3v1SaveTitle = true;
    private boolean id3v1SaveTrack = true;
    private boolean id3v1SaveYear = true;
    private byte id3v23DefaultTextEncoding = 0;
    private byte id3v24DefaultTextEncoding = 0;
    private byte id3v24UnicodeTextEncoding = 1;
    private boolean id3v2PaddingCopyTag = true;
    private boolean id3v2PaddingWillShorten = false;
    private boolean id3v2Save = true;
    private ID3V2Version id3v2Version = ID3V2Version.ID3_V23;
    private boolean isAPICDescriptionITunesCompatible = false;
    private boolean isEncodeUTF16BomAsLittleEndian = true;
    private boolean isWriteMp3GenresAsText = false;
    private boolean isWriteMp4GenresAsText = false;
    private boolean isWriteWavForTwonky = false;
    private HashMap<Class<? extends ID3v24FrameBody>, LinkedList<String>> keywordMap = new HashMap();
    private String language = "eng";
    private boolean lyrics3KeepEmptyFieldIfRead = false;
    private boolean lyrics3Save = true;
    private boolean lyrics3SaveEmptyField = false;
    private HashMap<String, Boolean> lyrics3SaveFieldMap = new HashMap();
    private int numberMP3SyncFrame = 3;
    private boolean originalSavedAfterAdjustingID3v2Padding = true;
    private PadNumberOption padNumberTotalLength = PadNumberOption.PAD_ONE_ZERO;
    private boolean padNumbers = false;
    private HashMap<String, String> parenthesisMap = new HashMap();
    private int playerCompatability = -1;
    private boolean preserveFileIdentity = true;
    private boolean removeTrailingTerminatorOnWrite = true;
    private HashMap<String, String> replaceWordMap = new HashMap();
    private boolean resetTextEncodingForExistingFrames = false;
    private byte timeStampFormat = (byte)2;
    private boolean truncateTextWithoutErrors = false;
    private boolean unsyncTags = false;
    private VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions = VorbisAlbumArtistReadOptions.READ_ALBUMARTIST_THEN_JRIVER;
    private VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions = VorbisAlbumArtistSaveOptions.WRITE_ALBUMARTIST;
    private WavOptions wavOptions = WavOptions.READ_ID3_ONLY;
    private WavSaveOptions wavSaveOptions = WavSaveOptions.SAVE_BOTH;
    private WavSaveOrder wavSaveOrder = WavSaveOrder.INFO_THEN_ID3;
    private long writeChunkSize = 0x400000L;

    static {
        tagOptionTable = new HashMap();
        DEFAULT = "default";
        defaultOptions = "default";
    }

    private TagOptionSingleton() {
        this.setToDefault();
    }

    public static TagOptionSingleton getInstance() {
        return TagOptionSingleton.getInstance(defaultOptions);
    }

    public static TagOptionSingleton getInstance(String string2) {
        TagOptionSingleton tagOptionSingleton = (TagOptionSingleton)tagOptionTable.get((Object)string2);
        if (tagOptionSingleton == null) {
            tagOptionSingleton = new TagOptionSingleton();
            tagOptionTable.put((Object)string2, (Object)tagOptionSingleton);
        }
        return tagOptionSingleton;
    }

    public static String getInstanceKey() {
        return defaultOptions;
    }

    public void addKeyword(Class<? extends ID3v24FrameBody> class_, String string2) throws TagException {
        if (AbstractID3v2FrameBody.class.isAssignableFrom(class_)) {
            if (string2 != null && string2.length() > 0) {
                LinkedList linkedList;
                if (!this.keywordMap.containsKey(class_)) {
                    linkedList = new LinkedList();
                    this.keywordMap.put(class_, (Object)linkedList);
                } else {
                    linkedList = (LinkedList)this.keywordMap.get(class_);
                }
                linkedList.add((Object)string2);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid class type. Must be AbstractId3v2FrameBody ");
        stringBuilder.append(class_);
        throw new TagException(stringBuilder.toString());
    }

    public void addParenthesis(String string2, String string3) {
        this.parenthesisMap.put((Object)string2, (Object)string3);
    }

    public void addReplaceWord(String string2, String string3) {
        this.replaceWordMap.put((Object)string2, (Object)string3);
    }

    public ID3V2Version getID3V2Version() {
        return this.id3v2Version;
    }

    public byte getId3v23DefaultTextEncoding() {
        return this.id3v23DefaultTextEncoding;
    }

    public byte getId3v24DefaultTextEncoding() {
        return this.id3v24DefaultTextEncoding;
    }

    public byte getId3v24UnicodeTextEncoding() {
        return this.id3v24UnicodeTextEncoding;
    }

    public Iterator<Class<? extends ID3v24FrameBody>> getKeywordIterator() {
        return this.keywordMap.keySet().iterator();
    }

    public Iterator<String> getKeywordListIterator(Class<? extends ID3v24FrameBody> class_) {
        return ((LinkedList)this.keywordMap.get(class_)).iterator();
    }

    public String getLanguage() {
        return this.language;
    }

    public boolean getLyrics3SaveField(String string2) {
        return (Boolean)this.lyrics3SaveFieldMap.get((Object)string2);
    }

    public HashMap<String, Boolean> getLyrics3SaveFieldMap() {
        return this.lyrics3SaveFieldMap;
    }

    public String getNewReplaceWord(String string2) {
        return (String)this.replaceWordMap.get((Object)string2);
    }

    public int getNumberMP3SyncFrame() {
        return this.numberMP3SyncFrame;
    }

    public Iterator<String> getOldReplaceWordIterator() {
        return this.replaceWordMap.keySet().iterator();
    }

    public Iterator<String> getOpenParenthesisIterator() {
        return this.parenthesisMap.keySet().iterator();
    }

    public PadNumberOption getPadNumberTotalLength() {
        return this.padNumberTotalLength;
    }

    public int getPlayerCompatability() {
        return this.playerCompatability;
    }

    public byte getTimeStampFormat() {
        return this.timeStampFormat;
    }

    public VorbisAlbumArtistReadOptions getVorbisAlbumArtisReadOptions() {
        return this.vorbisAlbumArtistReadOptions;
    }

    public VorbisAlbumArtistSaveOptions getVorbisAlbumArtistSaveOptions() {
        return this.vorbisAlbumArtistSaveOptions;
    }

    public WavOptions getWavOptions() {
        return this.wavOptions;
    }

    public WavSaveOptions getWavSaveOptions() {
        return this.wavSaveOptions;
    }

    public WavSaveOrder getWavSaveOrder() {
        return this.wavSaveOrder;
    }

    public long getWriteChunkSize() {
        return this.writeChunkSize;
    }

    public boolean isAPICDescriptionITunesCompatible() {
        return this.isAPICDescriptionITunesCompatible;
    }

    public boolean isCheckIsWritable() {
        return this.checkIsWritable;
    }

    public boolean isEncodeUTF16BomAsLittleEndian() {
        return this.isEncodeUTF16BomAsLittleEndian;
    }

    public boolean isFilenameTagSave() {
        return this.filenameTagSave;
    }

    public boolean isId3v1Save() {
        return this.id3v1Save;
    }

    public boolean isId3v1SaveAlbum() {
        return this.id3v1SaveAlbum;
    }

    public boolean isId3v1SaveArtist() {
        return this.id3v1SaveArtist;
    }

    public boolean isId3v1SaveComment() {
        return this.id3v1SaveComment;
    }

    public boolean isId3v1SaveGenre() {
        return this.id3v1SaveGenre;
    }

    public boolean isId3v1SaveTitle() {
        return this.id3v1SaveTitle;
    }

    public boolean isId3v1SaveTrack() {
        return this.id3v1SaveTrack;
    }

    public boolean isId3v1SaveYear() {
        return this.id3v1SaveYear;
    }

    public boolean isId3v2PaddingCopyTag() {
        return this.id3v2PaddingCopyTag;
    }

    public boolean isId3v2PaddingWillShorten() {
        return this.id3v2PaddingWillShorten;
    }

    public boolean isId3v2Save() {
        return this.id3v2Save;
    }

    public boolean isLyrics3KeepEmptyFieldIfRead() {
        return this.lyrics3KeepEmptyFieldIfRead;
    }

    public boolean isLyrics3Save() {
        return this.lyrics3Save;
    }

    public boolean isLyrics3SaveEmptyField() {
        return this.lyrics3SaveEmptyField;
    }

    public boolean isOpenParenthesis(String string2) {
        return this.parenthesisMap.containsKey((Object)string2);
    }

    public boolean isOriginalSavedAfterAdjustingID3v2Padding() {
        return this.originalSavedAfterAdjustingID3v2Padding;
    }

    public boolean isPadNumbers() {
        return this.padNumbers;
    }

    public boolean isPreserveFileIdentity() {
        return this.preserveFileIdentity;
    }

    public boolean isRemoveTrailingTerminatorOnWrite() {
        return this.removeTrailingTerminatorOnWrite;
    }

    public boolean isResetTextEncodingForExistingFrames() {
        return this.resetTextEncodingForExistingFrames;
    }

    public boolean isTruncateTextWithoutErrors() {
        return this.truncateTextWithoutErrors;
    }

    public boolean isUnsyncTags() {
        return this.unsyncTags;
    }

    public boolean isWriteMp3GenresAsText() {
        return this.isWriteMp3GenresAsText;
    }

    public boolean isWriteMp4GenresAsText() {
        return this.isWriteMp4GenresAsText;
    }

    public boolean isWriteWavForTwonky() {
        return this.isWriteWavForTwonky;
    }

    public void setAPICDescriptionITunesCompatible(boolean bl) {
        this.isAPICDescriptionITunesCompatible = bl;
    }

    public void setCheckIsWritable(boolean bl) {
        this.checkIsWritable = bl;
    }

    public void setEncodeUTF16BomAsLittleEndian(boolean bl) {
        this.isEncodeUTF16BomAsLittleEndian = bl;
    }

    public void setFilenameTagSave(boolean bl) {
        this.filenameTagSave = bl;
    }

    public void setID3V2Version(ID3V2Version iD3V2Version) {
        this.id3v2Version = iD3V2Version;
    }

    public void setId3v1Save(boolean bl) {
        this.id3v1Save = bl;
    }

    public void setId3v1SaveAlbum(boolean bl) {
        this.id3v1SaveAlbum = bl;
    }

    public void setId3v1SaveArtist(boolean bl) {
        this.id3v1SaveArtist = bl;
    }

    public void setId3v1SaveComment(boolean bl) {
        this.id3v1SaveComment = bl;
    }

    public void setId3v1SaveGenre(boolean bl) {
        this.id3v1SaveGenre = bl;
    }

    public void setId3v1SaveTitle(boolean bl) {
        this.id3v1SaveTitle = bl;
    }

    public void setId3v1SaveTrack(boolean bl) {
        this.id3v1SaveTrack = bl;
    }

    public void setId3v1SaveYear(boolean bl) {
        this.id3v1SaveYear = bl;
    }

    public void setId3v23DefaultTextEncoding(byte by) {
        if (by == 0 || by == 1) {
            this.id3v23DefaultTextEncoding = by;
        }
    }

    public void setId3v24DefaultTextEncoding(byte by) {
        if (by == 0 || by == 1 || by == 2 || by == 3) {
            this.id3v24DefaultTextEncoding = by;
        }
    }

    public void setId3v24UnicodeTextEncoding(byte by) {
        if (by == 1 || by == 2 || by == 3) {
            this.id3v24UnicodeTextEncoding = by;
        }
    }

    public void setId3v2PaddingCopyTag(boolean bl) {
        this.id3v2PaddingCopyTag = bl;
    }

    public void setId3v2PaddingWillShorten(boolean bl) {
        this.id3v2PaddingWillShorten = bl;
    }

    public void setId3v2Save(boolean bl) {
        this.id3v2Save = bl;
    }

    public void setInstanceKey(String string2) {
        defaultOptions = string2;
    }

    public void setLanguage(String string2) {
        if (Languages.getInstanceOf().getIdToValueMap().containsKey((Object)string2)) {
            this.language = string2;
        }
    }

    public void setLyrics3KeepEmptyFieldIfRead(boolean bl) {
        this.lyrics3KeepEmptyFieldIfRead = bl;
    }

    public void setLyrics3Save(boolean bl) {
        this.lyrics3Save = bl;
    }

    public void setLyrics3SaveEmptyField(boolean bl) {
        this.lyrics3SaveEmptyField = bl;
    }

    public void setLyrics3SaveField(String string2, boolean bl) {
        this.lyrics3SaveFieldMap.put((Object)string2, (Object)bl);
    }

    public void setNumberMP3SyncFrame(int n2) {
        this.numberMP3SyncFrame = n2;
    }

    public void setOriginalSavedAfterAdjustingID3v2Padding(boolean bl) {
        this.originalSavedAfterAdjustingID3v2Padding = bl;
    }

    public void setPadNumberTotalLength(PadNumberOption padNumberOption) {
        this.padNumberTotalLength = padNumberOption;
    }

    public void setPadNumbers(boolean bl) {
        this.padNumbers = bl;
    }

    public void setPlayerCompatability(int n2) {
        this.playerCompatability = n2;
    }

    public void setPreserveFileIdentity(boolean bl) {
        this.preserveFileIdentity = bl;
    }

    public void setRemoveTrailingTerminatorOnWrite(boolean bl) {
        this.removeTrailingTerminatorOnWrite = bl;
    }

    public void setResetTextEncodingForExistingFrames(boolean bl) {
        this.resetTextEncodingForExistingFrames = bl;
    }

    public void setTimeStampFormat(byte by) {
        if (by == 1 || by == 2) {
            this.timeStampFormat = by;
        }
    }

    public void setToDefault() {
        this.isWriteWavForTwonky = false;
        this.wavOptions = WavOptions.READ_ID3_UNLESS_ONLY_INFO;
        this.wavSaveOptions = WavSaveOptions.SAVE_BOTH;
        this.keywordMap = new HashMap();
        this.filenameTagSave = false;
        this.id3v1Save = true;
        this.id3v1SaveAlbum = true;
        this.id3v1SaveArtist = true;
        this.id3v1SaveComment = true;
        this.id3v1SaveGenre = true;
        this.id3v1SaveTitle = true;
        this.id3v1SaveTrack = true;
        this.id3v1SaveYear = true;
        this.id3v2PaddingCopyTag = true;
        this.id3v2PaddingWillShorten = false;
        this.id3v2Save = true;
        this.language = "eng";
        this.lyrics3KeepEmptyFieldIfRead = false;
        this.lyrics3Save = true;
        this.lyrics3SaveEmptyField = false;
        this.lyrics3SaveFieldMap = new HashMap();
        this.numberMP3SyncFrame = 3;
        this.parenthesisMap = new HashMap();
        this.replaceWordMap = new HashMap();
        this.timeStampFormat = (byte)2;
        this.unsyncTags = false;
        this.removeTrailingTerminatorOnWrite = true;
        this.id3v23DefaultTextEncoding = 0;
        this.id3v24DefaultTextEncoding = 0;
        this.id3v24UnicodeTextEncoding = 1;
        this.resetTextEncodingForExistingFrames = false;
        this.truncateTextWithoutErrors = false;
        this.padNumbers = false;
        this.isAPICDescriptionITunesCompatible = false;
        this.isEncodeUTF16BomAsLittleEndian = true;
        this.writeChunkSize = 5000000L;
        this.isWriteMp4GenresAsText = false;
        this.padNumberTotalLength = PadNumberOption.PAD_ONE_ZERO;
        this.id3v2Version = ID3V2Version.ID3_V23;
        this.checkIsWritable = false;
        this.preserveFileIdentity = false;
        for (String string2 : Lyrics3v2Fields.getInstanceOf().getIdToValueMap().keySet()) {
            this.lyrics3SaveFieldMap.put((Object)string2, (Object)Boolean.TRUE);
        }
        try {
            this.addKeyword(FrameBodyCOMM.class, "ultimix");
            this.addKeyword(FrameBodyCOMM.class, "dance");
            this.addKeyword(FrameBodyCOMM.class, "mix");
            this.addKeyword(FrameBodyCOMM.class, "remix");
            this.addKeyword(FrameBodyCOMM.class, "rmx");
            this.addKeyword(FrameBodyCOMM.class, "live");
            this.addKeyword(FrameBodyCOMM.class, "cover");
            this.addKeyword(FrameBodyCOMM.class, "soundtrack");
            this.addKeyword(FrameBodyCOMM.class, "version");
            this.addKeyword(FrameBodyCOMM.class, "acoustic");
            this.addKeyword(FrameBodyCOMM.class, "original");
            this.addKeyword(FrameBodyCOMM.class, "cd");
            this.addKeyword(FrameBodyCOMM.class, "extended");
            this.addKeyword(FrameBodyCOMM.class, "vocal");
            this.addKeyword(FrameBodyCOMM.class, "unplugged");
            this.addKeyword(FrameBodyCOMM.class, "acapella");
            this.addKeyword(FrameBodyCOMM.class, "edit");
            this.addKeyword(FrameBodyCOMM.class, "radio");
            this.addKeyword(FrameBodyCOMM.class, "original");
            this.addKeyword(FrameBodyCOMM.class, "album");
            this.addKeyword(FrameBodyCOMM.class, "studio");
            this.addKeyword(FrameBodyCOMM.class, "instrumental");
            this.addKeyword(FrameBodyCOMM.class, "unedited");
            this.addKeyword(FrameBodyCOMM.class, "karoke");
            this.addKeyword(FrameBodyCOMM.class, "quality");
            this.addKeyword(FrameBodyCOMM.class, "uncensored");
            this.addKeyword(FrameBodyCOMM.class, "clean");
            this.addKeyword(FrameBodyCOMM.class, "dirty");
            this.addKeyword(FrameBodyTIPL.class, "f.");
            this.addKeyword(FrameBodyTIPL.class, "feat");
            this.addKeyword(FrameBodyTIPL.class, "feat.");
            this.addKeyword(FrameBodyTIPL.class, "featuring");
            this.addKeyword(FrameBodyTIPL.class, "ftng");
            this.addKeyword(FrameBodyTIPL.class, "ftng.");
            this.addKeyword(FrameBodyTIPL.class, "ft.");
            this.addKeyword(FrameBodyTIPL.class, "ft");
            Iterator iterator = GenreTypes.getInstanceOf().getValueToIdMap().keySet().iterator();
            while (iterator.hasNext()) {
                this.addKeyword(FrameBodyCOMM.class, (String)iterator.next());
            }
        }
        catch (TagException tagException) {
            throw new RuntimeException((Throwable)tagException);
        }
        this.addReplaceWord("v.", "vs.");
        this.addReplaceWord("vs.", "vs.");
        this.addReplaceWord("versus", "vs.");
        this.addReplaceWord("f.", "feat.");
        this.addReplaceWord("feat", "feat.");
        this.addReplaceWord("featuring", "feat.");
        this.addReplaceWord("ftng.", "feat.");
        this.addReplaceWord("ftng", "feat.");
        this.addReplaceWord("ft.", "feat.");
        this.addReplaceWord("ft", "feat.");
        this.getKeywordListIterator(FrameBodyTIPL.class);
        this.addParenthesis("(", ")");
        this.addParenthesis("[", "]");
        this.addParenthesis("{", "}");
        this.addParenthesis("<", ">");
    }

    public void setTruncateTextWithoutErrors(boolean bl) {
        this.truncateTextWithoutErrors = bl;
    }

    public void setUnsyncTags(boolean bl) {
        this.unsyncTags = bl;
    }

    public void setVorbisAlbumArtistReadOptions(VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions) {
        this.vorbisAlbumArtistReadOptions = vorbisAlbumArtistReadOptions;
    }

    public void setVorbisAlbumArtistSaveOptions(VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions) {
        this.vorbisAlbumArtistSaveOptions = vorbisAlbumArtistSaveOptions;
    }

    public void setWavOptions(WavOptions wavOptions) {
        this.wavOptions = wavOptions;
    }

    public void setWavSaveOptions(WavSaveOptions wavSaveOptions) {
        this.wavSaveOptions = wavSaveOptions;
    }

    public void setWavSaveOrder(WavSaveOrder wavSaveOrder) {
        this.wavSaveOrder = wavSaveOrder;
    }

    public void setWriteChunkSize(long l2) {
        this.writeChunkSize = l2;
    }

    public void setWriteMp3GenresAsText(boolean bl) {
        this.isWriteMp3GenresAsText = bl;
    }

    public void setWriteMp4GenresAsText(boolean bl) {
        this.isWriteMp4GenresAsText = bl;
    }

    public void setWriteWavForTwonky(boolean bl) {
        this.isWriteWavForTwonky = bl;
    }
}

