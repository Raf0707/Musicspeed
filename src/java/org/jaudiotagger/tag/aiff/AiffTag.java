/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 */
package org.jaudiotagger.tag.aiff;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.Id3SupportingTag;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.reference.ID3V2Version;

public class AiffTag
implements Tag,
Id3SupportingTag {
    private List<ChunkSummary> chunkSummaryList = new ArrayList();
    private AbstractID3v2Tag id3Tag;
    private boolean isExistingId3Tag = false;
    private boolean isIncorrectlyAlignedTag = false;

    public AiffTag() {
    }

    public AiffTag(AbstractID3v2Tag abstractID3v2Tag) {
        this.id3Tag = abstractID3v2Tag;
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

    public void addChunkSummary(ChunkSummary chunkSummary) {
        this.chunkSummaryList.add((Object)chunkSummary);
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.addField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void addField(TagField tagField) throws FieldDataInvalidException {
        this.id3Tag.addField(tagField);
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        this.id3Tag.addField(artwork);
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        FieldKey fieldKey = FieldKey.IS_COMPILATION;
        String[] arrstring = new String[]{String.valueOf((boolean)bl)};
        return this.createField(fieldKey, arrstring);
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        return this.id3Tag.createField(fieldKey, arrstring);
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        return this.id3Tag.createField(artwork);
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.id3Tag.deleteArtworkField();
    }

    @Override
    public void deleteField(String string2) throws KeyNotFoundException {
        this.id3Tag.deleteField(string2);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        this.id3Tag.deleteField(fieldKey);
    }

    public boolean equals(Object object) {
        return this.id3Tag.equals(object);
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        return this.id3Tag.getAll(fieldKey);
    }

    @Override
    public List<Artwork> getArtworkList() {
        return this.id3Tag.getArtworkList();
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
        return this.id3Tag.getFieldCount();
    }

    @Override
    public int getFieldCountIncludingSubValues() {
        return this.getFieldCount();
    }

    @Override
    public Iterator<TagField> getFields() {
        return this.id3Tag.getFields();
    }

    @Override
    public List<TagField> getFields(String string2) {
        return this.id3Tag.getFields(string2);
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        return this.id3Tag.getFields(fieldKey);
    }

    @Override
    public String getFirst(String string2) {
        return this.id3Tag.getFirst(string2);
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public Artwork getFirstArtwork() {
        return this.id3Tag.getFirstArtwork();
    }

    @Override
    public TagField getFirstField(String string2) {
        return this.id3Tag.getFirstField(string2);
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            return this.id3Tag.getFirstField(fieldKey);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public AbstractID3v2Tag getID3Tag() {
        return this.id3Tag;
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
        return this.id3Tag.getValue(fieldKey, n2);
    }

    @Override
    public boolean hasCommonFields() {
        return this.id3Tag.hasCommonFields();
    }

    @Override
    public boolean hasField(String string2) {
        return this.id3Tag.hasField(string2);
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.id3Tag.hasField(fieldKey);
    }

    @Override
    public boolean isEmpty() {
        AbstractID3v2Tag abstractID3v2Tag = this.id3Tag;
        return abstractID3v2Tag == null || abstractID3v2Tag.isEmpty();
        {
        }
    }

    public boolean isExistingId3Tag() {
        return this.isExistingId3Tag;
    }

    public boolean isIncorrectlyAlignedTag() {
        return this.isIncorrectlyAlignedTag;
    }

    @Override
    public boolean setEncoding(Charset charset) throws FieldDataInvalidException {
        return this.id3Tag.setEncoding(charset);
    }

    public void setExistingId3Tag(boolean bl) {
        this.isExistingId3Tag = bl;
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void setField(TagField tagField) throws FieldDataInvalidException {
        this.id3Tag.setField(tagField);
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.id3Tag.setField(artwork);
    }

    @Override
    public void setID3Tag(AbstractID3v2Tag abstractID3v2Tag) {
        this.id3Tag = abstractID3v2Tag;
    }

    public void setIncorrectlyAlignedTag(boolean bl) {
        this.isIncorrectlyAlignedTag = bl;
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
            stringBuilder.append("Aiff ID3 Tag:\n");
            if (this.isExistingId3Tag()) {
                if (this.isIncorrectlyAlignedTag) {
                    stringBuilder.append("\tincorrectly starts as odd byte\n");
                }
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
            return stringBuilder.toString();
        }
        return "tag:empty";
    }
}

