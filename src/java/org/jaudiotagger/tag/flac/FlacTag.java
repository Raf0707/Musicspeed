/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package org.jaudiotagger.tag.flac;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.reference.PictureTypes;
import org.jaudiotagger.tag.vorbiscomment.VorbisAlbumArtistSaveOptions;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class FlacTag
implements Tag {
    private List<MetadataBlockDataPicture> images = new ArrayList();
    private VorbisCommentTag tag = null;

    public FlacTag() {
        this(VorbisCommentTag.createNewTag(), (List<MetadataBlockDataPicture>)new ArrayList());
    }

    public FlacTag(VorbisCommentTag vorbisCommentTag, List<MetadataBlockDataPicture> list) {
        this.tag = vorbisCommentTag;
        this.images = list;
    }

    public void addField(String string2, String string3) throws KeyNotFoundException, FieldDataInvalidException {
        this.addField(this.createField(string2, string3));
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (arrstring != null && arrstring[0] != null) {
            String string2 = arrstring[0];
            if (fieldKey == FieldKey.ALBUM_ARTIST) {
                int n2 = 1.$SwitchMap$org$jaudiotagger$tag$vorbiscomment$VorbisAlbumArtistSaveOptions[TagOptionSingleton.getInstance().getVorbisAlbumArtistSaveOptions().ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    return;
                                }
                                this.addField(this.createField(fieldKey, string2));
                                this.addField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                                return;
                            }
                            this.addField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                            this.deleteField(VorbisCommentFieldKey.ALBUMARTIST.getFieldName());
                            return;
                        }
                        this.addField(this.createField(fieldKey, string2));
                        this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName());
                        return;
                    }
                } else {
                    this.addField(this.createField(fieldKey, string2));
                }
                this.addField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                return;
            }
            this.addField(this.createField(fieldKey, string2));
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void addField(TagField tagField) throws FieldDataInvalidException {
        if (tagField instanceof MetadataBlockDataPicture) {
            this.images.add((Object)((MetadataBlockDataPicture)tagField));
            return;
        }
        this.tag.addField(tagField);
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        this.addField(this.createField(artwork));
    }

    public TagField createArtworkField(byte[] arrby, int n2, String string2, String string3, int n3, int n4, int n5, int n6) throws FieldDataInvalidException {
        if (arrby != null) {
            MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(arrby, n2, string2, string3, n3, n4, n5, n6);
            return metadataBlockDataPicture;
        }
        throw new FieldDataInvalidException("ImageData cannot be null");
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        return this.tag.createCompilationField(bl);
    }

    public TagField createField(String string2, String string3) {
        if (!string2.equals((Object)VorbisCommentFieldKey.COVERART.getFieldName())) {
            return this.tag.createField(string2, string3);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (!fieldKey.equals((Object)FieldKey.COVER_ART)) {
            return this.tag.createField(fieldKey, arrstring);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        if (artwork.isLinked()) {
            MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(artwork.getImageUrl().getBytes(StandardCharsets.ISO_8859_1), artwork.getPictureType(), "-->", "", 0, 0, 0, 0);
            return metadataBlockDataPicture;
        }
        if (artwork.setImageFromData()) {
            MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(artwork.getBinaryData(), artwork.getPictureType(), artwork.getMimeType(), artwork.getDescription(), artwork.getWidth(), artwork.getHeight(), 0, 0);
            return metadataBlockDataPicture;
        }
        throw new FieldDataInvalidException("Unable to createField buffered image from the image");
    }

    public TagField createField(VorbisCommentFieldKey vorbisCommentFieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (!vorbisCommentFieldKey.equals((Object)VorbisCommentFieldKey.COVERART)) {
            return this.tag.createField(vorbisCommentFieldKey, string2);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    public TagField createLinkedArtworkField(String string2) {
        MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(string2.getBytes(StandardCharsets.ISO_8859_1), PictureTypes.DEFAULT_ID, "-->", "", 0, 0, 0, 0);
        return metadataBlockDataPicture;
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.deleteField(FieldKey.COVER_ART);
    }

    @Override
    public void deleteField(String string2) throws KeyNotFoundException {
        if (string2.equals((Object)FieldKey.COVER_ART.name())) {
            this.images.clear();
            return;
        }
        this.tag.deleteField(string2);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey.equals((Object)FieldKey.COVER_ART)) {
            this.images.clear();
            return;
        }
        this.tag.deleteField(fieldKey);
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != FieldKey.COVER_ART) {
            return this.tag.getAll(fieldKey);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    @Override
    public List<Artwork> getArtworkList() {
        ArrayList arrayList = new ArrayList(this.images.size());
        Iterator iterator = this.images.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)ArtworkFactory.createArtworkFromMetadataBlockDataPicture((MetadataBlockDataPicture)iterator.next()));
        }
        return arrayList;
    }

    @Override
    public int getFieldCount() {
        return this.tag.getFieldCount() + this.images.size();
    }

    @Override
    public int getFieldCountIncludingSubValues() {
        return this.getFieldCount();
    }

    @Override
    public Iterator<TagField> getFields() {
        return this.tag.getFields();
    }

    @Override
    public List<TagField> getFields(String string2) {
        if (string2.equals((Object)FieldKey.COVER_ART.name())) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.images.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((MetadataBlockDataPicture)iterator.next()));
            }
            return arrayList;
        }
        return this.tag.getFields(string2);
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey.equals((Object)FieldKey.COVER_ART)) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.images.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((MetadataBlockDataPicture)iterator.next()));
            }
            return arrayList;
        }
        return this.tag.getFields(fieldKey);
    }

    @Override
    public String getFirst(String string2) {
        if (!string2.equals((Object)FieldKey.COVER_ART.name())) {
            return this.tag.getFirst(string2);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public Artwork getFirstArtwork() {
        List<Artwork> list = this.getArtworkList();
        if (list.size() > 0) {
            return (Artwork)list.get(0);
        }
        return null;
    }

    @Override
    public TagField getFirstField(String string2) {
        if (string2.equals((Object)FieldKey.COVER_ART.name())) {
            if (this.images.size() > 0) {
                return (TagField)this.images.get(0);
            }
            return null;
        }
        return this.tag.getFirstField(string2);
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            FieldKey fieldKey2 = FieldKey.COVER_ART;
            if (fieldKey == fieldKey2) {
                return this.getFirstField(fieldKey2.name());
            }
            return this.tag.getFirstField(fieldKey);
        }
        throw new KeyNotFoundException();
    }

    public List<MetadataBlockDataPicture> getImages() {
        return this.images;
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (!fieldKey.equals((Object)FieldKey.COVER_ART)) {
            return this.tag.getValue(fieldKey, n2);
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_RETRIEVED_WITH_THIS_METHOD.getMsg());
    }

    public VorbisCommentTag getVorbisCommentTag() {
        return this.tag;
    }

    @Override
    public boolean hasCommonFields() {
        return this.tag.hasCommonFields();
    }

    @Override
    public boolean hasField(String string2) {
        if (string2.equals((Object)FieldKey.COVER_ART.name())) {
            return this.images.size() > 0;
        }
        return this.tag.hasField(string2);
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        if (fieldKey == FieldKey.COVER_ART) {
            return this.images.size() > 0;
        }
        return this.tag.hasField(fieldKey);
    }

    public boolean hasField(VorbisCommentFieldKey vorbisCommentFieldKey) {
        return this.tag.hasField(vorbisCommentFieldKey);
    }

    @Override
    public boolean isEmpty() {
        VorbisCommentTag vorbisCommentTag = this.tag;
        return (vorbisCommentTag == null || vorbisCommentTag.isEmpty()) && this.images.size() == 0;
    }

    @Override
    public boolean setEncoding(Charset charset) throws FieldDataInvalidException {
        return this.tag.setEncoding(charset);
    }

    public void setField(String string2, String string3) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(string2, string3));
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (arrstring != null && arrstring[0] != null) {
            String string2 = arrstring[0];
            if (fieldKey == FieldKey.ALBUM_ARTIST) {
                int n2 = 1.$SwitchMap$org$jaudiotagger$tag$vorbiscomment$VorbisAlbumArtistSaveOptions[TagOptionSingleton.getInstance().getVorbisAlbumArtistSaveOptions().ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    return;
                                }
                                this.setField(this.createField(fieldKey, string2));
                                this.setField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                                return;
                            }
                            this.setField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                            this.deleteField(VorbisCommentFieldKey.ALBUMARTIST.getFieldName());
                            return;
                        }
                        this.setField(this.createField(fieldKey, string2));
                        this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName());
                        return;
                    }
                    this.setField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                    return;
                }
                this.setField(this.createField(fieldKey, string2));
                return;
            }
            this.setField(this.createField(fieldKey, string2));
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void setField(TagField tagField) throws FieldDataInvalidException {
        if (tagField instanceof MetadataBlockDataPicture) {
            if (this.images.size() == 0) {
                this.images.add(0, (Object)((MetadataBlockDataPicture)tagField));
                return;
            }
            this.images.set(0, (Object)((MetadataBlockDataPicture)tagField));
            return;
        }
        this.tag.setField(tagField);
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.setField(this.createField(artwork));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FLAC ");
        stringBuilder.append((Object)this.getVorbisCommentTag());
        return stringBuilder.toString();
    }
}

