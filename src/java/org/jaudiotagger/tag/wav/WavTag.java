/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 *  org.jaudiotagger.tag.wav.WavInfoTag
 */
package org.jaudiotagger.tag.wav;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.generic.GenericTag;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.Id3SupportingTag;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.reference.ID3V2Version;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavTag
implements Tag,
Id3SupportingTag {
    private static final String NULL = "\u0000";
    private static final Logger logger = Logger.getLogger((String)WavTag.class.getName());
    private List<ChunkSummary> chunkSummaryList = new ArrayList();
    private AbstractID3v2Tag id3Tag;
    private WavInfoTag infoTag;
    private boolean isExistingId3Tag = false;
    private boolean isExistingInfoTag = false;
    private boolean isIncorrectlyAlignedTag = false;
    private WavOptions wavOptions;

    public WavTag(WavOptions wavOptions) {
        this.wavOptions = wavOptions;
    }

    private String addNullTerminatorIfNone(String string2) {
        if (string2.endsWith(NULL)) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(NULL);
        return stringBuilder.toString();
    }

    public static AbstractID3v2Tag createDefaultID3Tag() {
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V24) {
            return new ID3v24Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V23) {
            return new ID3v23Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V22) {
            return new ID3v22Tag();
        }
        return new ID3v23Tag();
    }

    private String stripNullTerminator(String string2) {
        if (string2.endsWith(NULL)) {
            string2 = string2.substring(0, -1 + string2.length());
        }
        return string2;
    }

    public void addChunkSummary(ChunkSummary chunkSummary) {
        this.chunkSummaryList.add((Object)chunkSummary);
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.addField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void addField(TagField tagField) throws FieldDataInvalidException {
        this.getActiveTag().addField(tagField);
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        this.addField(this.createField(artwork));
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        FieldKey fieldKey = FieldKey.IS_COMPILATION;
        String[] arrstring = new String[]{String.valueOf((boolean)bl)};
        return this.createField(fieldKey, arrstring);
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        return this.getActiveTag().createField(fieldKey, arrstring);
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        return this.getActiveTag().createField(artwork);
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.getActiveTag().deleteArtworkField();
    }

    @Override
    public void deleteField(String string2) throws KeyNotFoundException {
        this.getActiveTag().deleteField(string2);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        this.getActiveTag().deleteField(fieldKey);
    }

    public boolean equals(Object object) {
        return this.getActiveTag().equals(object);
    }

    public Tag getActiveTag() {
        switch (1.$SwitchMap$org$jaudiotagger$audio$wav$WavOptions[this.wavOptions.ordinal()]) {
            default: {
                return this.id3Tag;
            }
            case 7: 
            case 8: {
                if (!this.isExistingInfoTag() && this.isExistingId3Tag()) {
                    return this.id3Tag;
                }
                return this.infoTag;
            }
            case 5: 
            case 6: {
                if (!this.isExistingId3Tag() && this.isExistingInfoTag()) {
                    return this.infoTag;
                }
                return this.id3Tag;
            }
            case 3: 
            case 4: {
                return this.infoTag;
            }
            case 1: 
            case 2: 
        }
        return this.id3Tag;
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getActiveTag().getAll(fieldKey);
    }

    @Override
    public List<Artwork> getArtworkList() {
        return this.getActiveTag().getArtworkList();
    }

    public List<ChunkSummary> getChunkSummaryList() {
        return this.chunkSummaryList;
    }

    public long getEndLocationInFileOfId3Chunk() {
        if (!this.isExistingId3Tag()) {
            return 0L;
        }
        return this.id3Tag.getEndLocationInFile();
    }

    @Override
    public int getFieldCount() {
        return this.getActiveTag().getFieldCount();
    }

    @Override
    public int getFieldCountIncludingSubValues() {
        return this.getFieldCount();
    }

    @Override
    public Iterator<TagField> getFields() {
        return this.getActiveTag().getFields();
    }

    @Override
    public List<TagField> getFields(String string2) {
        return this.getActiveTag().getFields(string2);
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getActiveTag().getFields(fieldKey);
    }

    @Override
    public String getFirst(String string2) {
        return this.getActiveTag().getFirst(string2);
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public Artwork getFirstArtwork() {
        return this.getActiveTag().getFirstArtwork();
    }

    @Override
    public TagField getFirstField(String string2) {
        return this.getActiveTag().getFirstField(string2);
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            return this.getActiveTag().getFirstField(fieldKey);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public AbstractID3v2Tag getID3Tag() {
        return this.id3Tag;
    }

    public WavInfoTag getInfoTag() {
        return this.infoTag;
    }

    public long getSizeOfID3TagIncludingChunkHeader() {
        if (!this.isExistingId3Tag()) {
            return 0L;
        }
        return 8L + this.getSizeOfID3TagOnly();
    }

    public long getSizeOfID3TagOnly() {
        if (!this.isExistingId3Tag()) {
            return 0L;
        }
        return this.id3Tag.getEndLocationInFile() - this.id3Tag.getStartLocationInFile();
    }

    public long getStartLocationInFileOfId3Chunk() {
        if (!this.isExistingId3Tag()) {
            return 0L;
        }
        return this.id3Tag.getStartLocationInFile() - 8L;
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        return this.getActiveTag().getValue(fieldKey, n2);
    }

    @Override
    public boolean hasCommonFields() {
        return this.getActiveTag().hasCommonFields();
    }

    @Override
    public boolean hasField(String string2) {
        return this.getActiveTag().hasField(string2);
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.getActiveTag().hasField(fieldKey);
    }

    @Override
    public boolean isEmpty() {
        return this.getActiveTag() == null || this.getActiveTag().isEmpty();
        {
        }
    }

    public boolean isExistingId3Tag() {
        return this.isExistingId3Tag;
    }

    public boolean isExistingInfoTag() {
        return this.isExistingInfoTag;
    }

    public boolean isID3Tag() {
        return this.id3Tag != null;
    }

    public boolean isIncorrectlyAlignedTag() {
        return this.isIncorrectlyAlignedTag;
    }

    public boolean isInfoTag() {
        return this.infoTag != null;
    }

    @Override
    public boolean setEncoding(Charset charset) throws FieldDataInvalidException {
        return this.getActiveTag().setEncoding(charset);
    }

    public void setExistingId3Tag(boolean bl) {
        this.isExistingId3Tag = bl;
    }

    public void setExistingInfoTag(boolean bl) {
        this.isExistingInfoTag = bl;
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void setField(TagField tagField) throws FieldDataInvalidException {
        this.getActiveTag().setField(tagField);
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.setField(this.createField(artwork));
    }

    @Override
    public void setID3Tag(AbstractID3v2Tag abstractID3v2Tag) {
        this.id3Tag = abstractID3v2Tag;
    }

    public void setIncorrectlyAlignedTag(boolean bl) {
        this.isIncorrectlyAlignedTag = bl;
    }

    public void setInfoTag(WavInfoTag wavInfoTag) {
        this.infoTag = wavInfoTag;
    }

    public void syncTagBeforeWrite() {
        if (this.getActiveTag() instanceof WavInfoTag) {
            this.syncToId3FromInfoOverwrite();
            return;
        }
        this.syncToInfoFromId3Overwrite();
    }

    public void syncTagsAfterRead() {
        if (this.getActiveTag() instanceof WavInfoTag) {
            this.syncToInfoFromId3IfEmpty();
            return;
        }
        this.syncToId3FromInfoIfEmpty();
    }

    public void syncToId3FromInfoIfEmpty() {
        try {
            for (FieldKey fieldKey : GenericTag.getSupportedKeys()) {
                String string2;
                if (!this.id3Tag.getFirst(fieldKey).isEmpty() || (string2 = this.infoTag.getFirst(fieldKey)).isEmpty()) continue;
                AbstractID3v2Tag abstractID3v2Tag = this.id3Tag;
                String[] arrstring = new String[]{this.stripNullTerminator(string2)};
                abstractID3v2Tag.setField(fieldKey, arrstring);
            }
        }
        catch (FieldDataInvalidException fieldDataInvalidException) {
            logger.log(Level.INFO, "Couldn't sync to ID3 because the data to sync was invalid", (Throwable)fieldDataInvalidException);
        }
    }

    public void syncToId3FromInfoOverwrite() {
        try {
            for (FieldKey fieldKey : GenericTag.getSupportedKeys()) {
                if (!this.infoTag.getFirst(fieldKey).isEmpty()) {
                    AbstractID3v2Tag abstractID3v2Tag = this.id3Tag;
                    String[] arrstring = new String[]{this.stripNullTerminator(this.infoTag.getFirst(fieldKey))};
                    abstractID3v2Tag.setField(fieldKey, arrstring);
                    continue;
                }
                this.id3Tag.deleteField(fieldKey);
            }
        }
        catch (FieldDataInvalidException fieldDataInvalidException) {
            logger.log(Level.INFO, "Couldn't sync to ID3 because the data to sync was invalid", (Throwable)fieldDataInvalidException);
        }
    }

    public void syncToInfoFromId3IfEmpty() {
        try {
            for (FieldKey fieldKey : GenericTag.getSupportedKeys()) {
                if (!this.infoTag.getFirst(fieldKey).isEmpty() || this.id3Tag.getFirst(fieldKey).isEmpty()) continue;
                WavInfoTag wavInfoTag = this.infoTag;
                String[] arrstring = new String[]{this.addNullTerminatorIfNone(this.id3Tag.getFirst(fieldKey))};
                wavInfoTag.setField(fieldKey, arrstring);
            }
        }
        catch (FieldDataInvalidException fieldDataInvalidException) {
            logger.log(Level.INFO, "Couldn't sync to INFO because the data to sync was invalid", (Throwable)fieldDataInvalidException);
        }
    }

    public void syncToInfoFromId3Overwrite() {
        try {
            for (FieldKey fieldKey : GenericTag.getSupportedKeys()) {
                if (!this.id3Tag.getFirst(fieldKey).isEmpty()) {
                    WavInfoTag wavInfoTag = this.infoTag;
                    String[] arrstring = new String[]{this.addNullTerminatorIfNone(this.id3Tag.getFirst(fieldKey))};
                    wavInfoTag.setField(fieldKey, arrstring);
                    continue;
                }
                this.infoTag.deleteField(fieldKey);
            }
        }
        catch (FieldDataInvalidException fieldDataInvalidException) {
            logger.log(Level.INFO, "Couldn't sync to INFO because the data to sync was invalid", (Throwable)fieldDataInvalidException);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChunkSummary chunkSummary : this.chunkSummaryList) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(chunkSummary.toString());
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.id3Tag != null) {
            stringBuilder.append("Wav ID3 Tag:\n");
            if (this.isExistingId3Tag()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("\tstartLocation:");
                stringBuilder3.append(Hex.asDecAndHex(this.getStartLocationInFileOfId3Chunk()));
                stringBuilder3.append("\n");
                stringBuilder.append(stringBuilder3.toString());
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("\tendLocation:");
                stringBuilder4.append(Hex.asDecAndHex(this.getEndLocationInFileOfId3Chunk()));
                stringBuilder4.append("\n");
                stringBuilder.append(stringBuilder4.toString());
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(this.id3Tag.toString());
            stringBuilder5.append("\n");
            stringBuilder.append(stringBuilder5.toString());
        }
        if (this.infoTag != null) {
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(this.infoTag.toString());
            stringBuilder6.append("\n");
            stringBuilder.append(stringBuilder6.toString());
        }
        return stringBuilder.toString();
    }
}

