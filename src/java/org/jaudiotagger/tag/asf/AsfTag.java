/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.EnumMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.jaudiotagger.tag.asf.AsfTagCoverField
 */
package org.jaudiotagger.tag.asf;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTag;
import org.jaudiotagger.tag.asf.AsfTagCoverField;
import org.jaudiotagger.tag.asf.AsfTagField;
import org.jaudiotagger.tag.asf.AsfTagTextField;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.reference.PictureTypes;

public final class AsfTag
extends AbstractTag {
    public static final Set<AsfFieldKey> COMMON_FIELDS;
    private static final EnumMap<FieldKey, AsfFieldKey> tagFieldToAsfField;
    private final boolean copyFields;

    static {
        HashSet hashSet;
        EnumMap enumMap;
        tagFieldToAsfField = enumMap = new EnumMap(FieldKey.class);
        enumMap.put((Enum)FieldKey.ACOUSTID_FINGERPRINT, (Object)AsfFieldKey.ACOUSTID_FINGERPRINT);
        enumMap.put((Enum)FieldKey.ACOUSTID_ID, (Object)AsfFieldKey.ACOUSTID_ID);
        enumMap.put((Enum)FieldKey.ALBUM, (Object)AsfFieldKey.ALBUM);
        enumMap.put((Enum)FieldKey.ALBUM_ARTIST, (Object)AsfFieldKey.ALBUM_ARTIST);
        enumMap.put((Enum)FieldKey.ALBUM_ARTIST_SORT, (Object)AsfFieldKey.ALBUM_ARTIST_SORT);
        enumMap.put((Enum)FieldKey.ALBUM_ARTISTS, (Object)AsfFieldKey.ALBUM_ARTISTS);
        enumMap.put((Enum)FieldKey.ALBUM_ARTISTS_SORT, (Object)AsfFieldKey.ALBUM_ARTISTS_SORT);
        enumMap.put((Enum)FieldKey.ALBUM_SORT, (Object)AsfFieldKey.ALBUM_SORT);
        enumMap.put((Enum)FieldKey.AMAZON_ID, (Object)AsfFieldKey.AMAZON_ID);
        enumMap.put((Enum)FieldKey.ARRANGER, (Object)AsfFieldKey.ARRANGER);
        enumMap.put((Enum)FieldKey.ARRANGER_SORT, (Object)AsfFieldKey.ARRANGER_SORT);
        enumMap.put((Enum)FieldKey.ARTIST, (Object)AsfFieldKey.AUTHOR);
        enumMap.put((Enum)FieldKey.ARTISTS, (Object)AsfFieldKey.ARTISTS);
        enumMap.put((Enum)FieldKey.ARTISTS_SORT, (Object)AsfFieldKey.ARTISTS_SORT);
        enumMap.put((Enum)FieldKey.ARTIST_SORT, (Object)AsfFieldKey.ARTIST_SORT);
        enumMap.put((Enum)FieldKey.BARCODE, (Object)AsfFieldKey.BARCODE);
        enumMap.put((Enum)FieldKey.BPM, (Object)AsfFieldKey.BPM);
        enumMap.put((Enum)FieldKey.CATALOG_NO, (Object)AsfFieldKey.CATALOG_NO);
        enumMap.put((Enum)FieldKey.CHOIR, (Object)AsfFieldKey.CHOIR);
        enumMap.put((Enum)FieldKey.CHOIR_SORT, (Object)AsfFieldKey.CHOIR_SORT);
        enumMap.put((Enum)FieldKey.CLASSICAL_CATALOG, (Object)AsfFieldKey.CLASSICAL_CATALOG);
        enumMap.put((Enum)FieldKey.CLASSICAL_NICKNAME, (Object)AsfFieldKey.CLASSICAL_NICKNAME);
        enumMap.put((Enum)FieldKey.COMMENT, (Object)AsfFieldKey.DESCRIPTION);
        enumMap.put((Enum)FieldKey.COMPOSER, (Object)AsfFieldKey.COMPOSER);
        enumMap.put((Enum)FieldKey.COMPOSER_SORT, (Object)AsfFieldKey.COMPOSER_SORT);
        EnumMap<FieldKey, AsfFieldKey> enumMap2 = tagFieldToAsfField;
        enumMap2.put((Enum)FieldKey.CONDUCTOR, (Object)AsfFieldKey.CONDUCTOR);
        enumMap2.put((Enum)FieldKey.CONDUCTOR_SORT, (Object)AsfFieldKey.CONDUCTOR_SORT);
        enumMap2.put((Enum)FieldKey.COPYRIGHT, (Object)AsfFieldKey.COPYRIGHT);
        enumMap2.put((Enum)FieldKey.COUNTRY, (Object)AsfFieldKey.COUNTRY);
        enumMap2.put((Enum)FieldKey.COVER_ART, (Object)AsfFieldKey.COVER_ART);
        enumMap2.put((Enum)FieldKey.CUSTOM1, (Object)AsfFieldKey.CUSTOM1);
        enumMap2.put((Enum)FieldKey.CUSTOM2, (Object)AsfFieldKey.CUSTOM2);
        enumMap2.put((Enum)FieldKey.CUSTOM3, (Object)AsfFieldKey.CUSTOM3);
        enumMap2.put((Enum)FieldKey.CUSTOM4, (Object)AsfFieldKey.CUSTOM4);
        enumMap2.put((Enum)FieldKey.CUSTOM5, (Object)AsfFieldKey.CUSTOM5);
        enumMap2.put((Enum)FieldKey.DISC_NO, (Object)AsfFieldKey.DISC_NO);
        enumMap2.put((Enum)FieldKey.DISC_SUBTITLE, (Object)AsfFieldKey.DISC_SUBTITLE);
        enumMap2.put((Enum)FieldKey.DISC_TOTAL, (Object)AsfFieldKey.DISC_TOTAL);
        enumMap2.put((Enum)FieldKey.DJMIXER, (Object)AsfFieldKey.DJMIXER);
        enumMap2.put((Enum)FieldKey.MOOD_ELECTRONIC, (Object)AsfFieldKey.MOOD_ELECTRONIC);
        enumMap2.put((Enum)FieldKey.ENCODER, (Object)AsfFieldKey.ENCODER);
        enumMap2.put((Enum)FieldKey.ENGINEER, (Object)AsfFieldKey.ENGINEER);
        enumMap2.put((Enum)FieldKey.ENSEMBLE, (Object)AsfFieldKey.ENSEMBLE);
        enumMap2.put((Enum)FieldKey.ENSEMBLE_SORT, (Object)AsfFieldKey.ENSEMBLE_SORT);
        enumMap2.put((Enum)FieldKey.FBPM, (Object)AsfFieldKey.FBPM);
        enumMap2.put((Enum)FieldKey.GENRE, (Object)AsfFieldKey.GENRE);
        enumMap2.put((Enum)FieldKey.GROUP, (Object)AsfFieldKey.GROUP);
        enumMap2.put((Enum)FieldKey.GROUPING, (Object)AsfFieldKey.GROUPING);
        enumMap2.put((Enum)FieldKey.INSTRUMENT, (Object)AsfFieldKey.INSTRUMENT);
        enumMap2.put((Enum)FieldKey.INVOLVED_PERSON, (Object)AsfFieldKey.INVOLVED_PERSON);
        EnumMap<FieldKey, AsfFieldKey> enumMap3 = tagFieldToAsfField;
        enumMap3.put((Enum)FieldKey.ISRC, (Object)AsfFieldKey.ISRC);
        enumMap3.put((Enum)FieldKey.IS_CLASSICAL, (Object)AsfFieldKey.IS_CLASSICAL);
        enumMap3.put((Enum)FieldKey.IS_COMPILATION, (Object)AsfFieldKey.IS_COMPILATION);
        enumMap3.put((Enum)FieldKey.IS_SOUNDTRACK, (Object)AsfFieldKey.IS_SOUNDTRACK);
        enumMap3.put((Enum)FieldKey.KEY, (Object)AsfFieldKey.INITIAL_KEY);
        enumMap3.put((Enum)FieldKey.LANGUAGE, (Object)AsfFieldKey.LANGUAGE);
        enumMap3.put((Enum)FieldKey.LYRICIST, (Object)AsfFieldKey.LYRICIST);
        enumMap3.put((Enum)FieldKey.LYRICS, (Object)AsfFieldKey.LYRICS);
        enumMap3.put((Enum)FieldKey.MEDIA, (Object)AsfFieldKey.MEDIA);
        enumMap3.put((Enum)FieldKey.MIXER, (Object)AsfFieldKey.MIXER);
        enumMap3.put((Enum)FieldKey.MOOD, (Object)AsfFieldKey.MOOD);
        enumMap3.put((Enum)FieldKey.MOOD_ACOUSTIC, (Object)AsfFieldKey.MOOD_ACOUSTIC);
        enumMap3.put((Enum)FieldKey.MOOD_AGGRESSIVE, (Object)AsfFieldKey.MOOD_AGGRESSIVE);
        enumMap3.put((Enum)FieldKey.MOOD_AROUSAL, (Object)AsfFieldKey.MOOD_AROUSAL);
        enumMap3.put((Enum)FieldKey.MOOD_DANCEABILITY, (Object)AsfFieldKey.MOOD_DANCEABILITY);
        enumMap3.put((Enum)FieldKey.MOOD_HAPPY, (Object)AsfFieldKey.MOOD_HAPPY);
        enumMap3.put((Enum)FieldKey.MOOD_INSTRUMENTAL, (Object)AsfFieldKey.MOOD_INSTRUMENTAL);
        enumMap3.put((Enum)FieldKey.MOOD_PARTY, (Object)AsfFieldKey.MOOD_PARTY);
        enumMap3.put((Enum)FieldKey.MOOD_RELAXED, (Object)AsfFieldKey.MOOD_RELAXED);
        enumMap3.put((Enum)FieldKey.MOOD_SAD, (Object)AsfFieldKey.MOOD_SAD);
        enumMap3.put((Enum)FieldKey.MOOD_VALENCE, (Object)AsfFieldKey.MOOD_VALENCE);
        enumMap3.put((Enum)FieldKey.MOVEMENT, (Object)AsfFieldKey.MOVEMENT);
        enumMap3.put((Enum)FieldKey.MOVEMENT_NO, (Object)AsfFieldKey.MOVEMENT_NO);
        enumMap3.put((Enum)FieldKey.MOVEMENT_TOTAL, (Object)AsfFieldKey.MOVEMENT_TOTAL);
        enumMap3.put((Enum)FieldKey.MUSICBRAINZ_ARTISTID, (Object)AsfFieldKey.MUSICBRAINZ_ARTISTID);
        EnumMap<FieldKey, AsfFieldKey> enumMap4 = tagFieldToAsfField;
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_DISC_ID, (Object)AsfFieldKey.MUSICBRAINZ_DISC_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_ORIGINAL_RELEASE_ID, (Object)AsfFieldKey.MUSICBRAINZ_ORIGINAL_RELEASEID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASEARTISTID, (Object)AsfFieldKey.MUSICBRAINZ_RELEASEARTISTID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASEID, (Object)AsfFieldKey.MUSICBRAINZ_RELEASEID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_COUNTRY, (Object)AsfFieldKey.MUSICBRAINZ_RELEASE_COUNTRY);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_GROUP_ID, (Object)AsfFieldKey.MUSICBRAINZ_RELEASEGROUPID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_STATUS, (Object)AsfFieldKey.MUSICBRAINZ_RELEASE_STATUS);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TRACK_ID, (Object)AsfFieldKey.MUSICBRAINZ_RELEASETRACKID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_RELEASE_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_TRACK_ID, (Object)AsfFieldKey.MUSICBRAINZ_TRACK_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK, (Object)AsfFieldKey.MUSICBRAINZ_WORK);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORKID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION, (Object)AsfFieldKey.MUSICBRAINZ_WORK_COMPOSITION);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID);
        EnumMap<FieldKey, AsfFieldKey> enumMap5 = tagFieldToAsfField;
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE, (Object)AsfFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE);
        enumMap5.put((Enum)FieldKey.MUSICIP_ID, (Object)AsfFieldKey.MUSICIP_ID);
        enumMap5.put((Enum)FieldKey.OCCASION, (Object)AsfFieldKey.OCCASION);
        enumMap5.put((Enum)FieldKey.OPUS, (Object)AsfFieldKey.OPUS);
        enumMap5.put((Enum)FieldKey.ORCHESTRA, (Object)AsfFieldKey.ORCHESTRA);
        enumMap5.put((Enum)FieldKey.ORCHESTRA_SORT, (Object)AsfFieldKey.ORCHESTRA_SORT);
        enumMap5.put((Enum)FieldKey.ORIGINAL_ALBUM, (Object)AsfFieldKey.ORIGINAL_ALBUM);
        enumMap5.put((Enum)FieldKey.ORIGINAL_ARTIST, (Object)AsfFieldKey.ORIGINAL_ARTIST);
        enumMap5.put((Enum)FieldKey.ORIGINAL_LYRICIST, (Object)AsfFieldKey.ORIGINAL_LYRICIST);
        enumMap5.put((Enum)FieldKey.ORIGINAL_YEAR, (Object)AsfFieldKey.ORIGINAL_YEAR);
        enumMap5.put((Enum)FieldKey.PART, (Object)AsfFieldKey.PART);
        enumMap5.put((Enum)FieldKey.PART_NUMBER, (Object)AsfFieldKey.PART_NUMBER);
        enumMap5.put((Enum)FieldKey.PART_TYPE, (Object)AsfFieldKey.PART_TYPE);
        enumMap5.put((Enum)FieldKey.PERFORMER, (Object)AsfFieldKey.PERFORMER);
        enumMap5.put((Enum)FieldKey.PERFORMER_NAME, (Object)AsfFieldKey.PERFORMER_NAME);
        enumMap5.put((Enum)FieldKey.PERFORMER_NAME_SORT, (Object)AsfFieldKey.PERFORMER_NAME_SORT);
        enumMap5.put((Enum)FieldKey.PERIOD, (Object)AsfFieldKey.PERIOD);
        enumMap5.put((Enum)FieldKey.PRODUCER, (Object)AsfFieldKey.PRODUCER);
        enumMap5.put((Enum)FieldKey.QUALITY, (Object)AsfFieldKey.QUALITY);
        EnumMap<FieldKey, AsfFieldKey> enumMap6 = tagFieldToAsfField;
        enumMap6.put((Enum)FieldKey.RANKING, (Object)AsfFieldKey.RANKING);
        enumMap6.put((Enum)FieldKey.RATING, (Object)AsfFieldKey.USER_RATING);
        enumMap6.put((Enum)FieldKey.RECORD_LABEL, (Object)AsfFieldKey.RECORD_LABEL);
        enumMap6.put((Enum)FieldKey.REMIXER, (Object)AsfFieldKey.REMIXER);
        enumMap6.put((Enum)FieldKey.SCRIPT, (Object)AsfFieldKey.SCRIPT);
        enumMap6.put((Enum)FieldKey.SINGLE_DISC_TRACK_NO, (Object)AsfFieldKey.SINGLE_DISC_TRACK_NO);
        enumMap6.put((Enum)FieldKey.SUBTITLE, (Object)AsfFieldKey.SUBTITLE);
        enumMap6.put((Enum)FieldKey.TAGS, (Object)AsfFieldKey.TAGS);
        enumMap6.put((Enum)FieldKey.TEMPO, (Object)AsfFieldKey.TEMPO);
        enumMap6.put((Enum)FieldKey.TIMBRE, (Object)AsfFieldKey.TIMBRE);
        FieldKey fieldKey = FieldKey.TITLE;
        AsfFieldKey asfFieldKey = AsfFieldKey.TITLE;
        enumMap6.put((Enum)fieldKey, (Object)asfFieldKey);
        enumMap6.put((Enum)FieldKey.TITLE_MOVEMENT, (Object)AsfFieldKey.TITLE_MOVEMENT);
        enumMap6.put((Enum)FieldKey.TITLE_SORT, (Object)AsfFieldKey.TITLE_SORT);
        enumMap6.put((Enum)FieldKey.TONALITY, (Object)AsfFieldKey.TONALITY);
        FieldKey fieldKey2 = FieldKey.TRACK;
        AsfFieldKey asfFieldKey2 = AsfFieldKey.TRACK;
        enumMap6.put((Enum)fieldKey2, (Object)asfFieldKey2);
        enumMap6.put((Enum)FieldKey.TRACK_TOTAL, (Object)AsfFieldKey.TRACK_TOTAL);
        enumMap6.put((Enum)FieldKey.URL_DISCOGS_ARTIST_SITE, (Object)AsfFieldKey.URL_DISCOGS_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_DISCOGS_RELEASE_SITE, (Object)AsfFieldKey.URL_DISCOGS_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.URL_LYRICS_SITE, (Object)AsfFieldKey.URL_LYRICS_SITE);
        enumMap6.put((Enum)FieldKey.URL_OFFICIAL_ARTIST_SITE, (Object)AsfFieldKey.URL_OFFICIAL_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_OFFICIAL_RELEASE_SITE, (Object)AsfFieldKey.URL_OFFICIAL_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.URL_WIKIPEDIA_ARTIST_SITE, (Object)AsfFieldKey.URL_WIKIPEDIA_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_WIKIPEDIA_RELEASE_SITE, (Object)AsfFieldKey.URL_WIKIPEDIA_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.WORK, (Object)AsfFieldKey.WORK);
        enumMap6.put((Enum)FieldKey.WORK_TYPE, (Object)AsfFieldKey.WORK_TYPE);
        EnumMap<FieldKey, AsfFieldKey> enumMap7 = tagFieldToAsfField;
        FieldKey fieldKey3 = FieldKey.YEAR;
        AsfFieldKey asfFieldKey3 = AsfFieldKey.YEAR;
        enumMap7.put((Enum)fieldKey3, (Object)asfFieldKey3);
        COMMON_FIELDS = hashSet = new HashSet();
        hashSet.add((Object)AsfFieldKey.ALBUM);
        hashSet.add((Object)AsfFieldKey.AUTHOR);
        hashSet.add((Object)AsfFieldKey.DESCRIPTION);
        hashSet.add((Object)AsfFieldKey.GENRE);
        hashSet.add((Object)asfFieldKey);
        hashSet.add((Object)asfFieldKey2);
        hashSet.add((Object)asfFieldKey3);
    }

    public AsfTag() {
        this(false);
    }

    public AsfTag(Tag tag, boolean bl) throws UnsupportedEncodingException {
        this(bl);
        this.copyFrom(tag);
    }

    public AsfTag(boolean bl) {
        this.copyFields = bl;
    }

    /*
     * Exception decompiling
     */
    private TagField copyFrom(TagField var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : ALOAD : trying to set 1 previously set to 0
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

    private void copyFrom(Tag tag) {
        Iterator<TagField> iterator = tag.getFields();
        while (iterator.hasNext()) {
            TagField tagField = this.copyFrom((TagField)iterator.next());
            if (tagField == null) continue;
            super.addField(tagField);
        }
    }

    private boolean isValidField(TagField tagField) {
        if (tagField == null) {
            return false;
        }
        if (!(tagField instanceof AsfTagField)) {
            return false;
        }
        return true ^ tagField.isEmpty();
    }

    public void addCopyright(String string2) {
        this.addField(this.createCopyrightField(string2));
    }

    @Override
    public void addField(TagField tagField) {
        if (this.isValidField(tagField)) {
            if (AsfFieldKey.isMultiValued(tagField.getId())) {
                super.addField(this.copyFrom(tagField));
                return;
            }
            super.setField(this.copyFrom(tagField));
        }
    }

    public void addRating(String string2) {
        this.addField(this.createRatingField(string2));
    }

    public AsfTagCoverField createArtworkField(byte[] arrby) {
        return new AsfTagCoverField(arrby, PictureTypes.DEFAULT_ID.intValue(), null, null);
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        FieldKey fieldKey = FieldKey.IS_COMPILATION;
        String[] arrstring = new String[]{String.valueOf((boolean)bl)};
        return this.createField(fieldKey, arrstring);
    }

    public AsfTagTextField createCopyrightField(String string2) {
        return new AsfTagTextField(AsfFieldKey.COPYRIGHT, string2);
    }

    public AsfTagCoverField createField(Artwork artwork) {
        return new AsfTagCoverField(artwork.getBinaryData(), artwork.getPictureType(), artwork.getDescription(), artwork.getMimeType());
    }

    @Override
    public /* varargs */ AsfTagTextField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (arrstring != null && arrstring[0] != null) {
            if (fieldKey != null) {
                AsfFieldKey asfFieldKey = (AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey));
                if (asfFieldKey != null) {
                    return this.createField(asfFieldKey, arrstring[0]);
                }
                throw new KeyNotFoundException(fieldKey.toString());
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public AsfTagTextField createField(AsfFieldKey asfFieldKey, String string2) {
        if (string2 != null) {
            if (asfFieldKey != null) {
                int n2 = 1.$SwitchMap$org$jaudiotagger$tag$asf$AsfFieldKey[asfFieldKey.ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        return new AsfTagTextField(asfFieldKey.getFieldName(), string2);
                    }
                    throw new UnsupportedOperationException("Banner Image cannot be created using this method");
                }
                throw new UnsupportedOperationException("Cover Art cannot be created using this method");
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public AsfTagTextField createRatingField(String string2) {
        return new AsfTagTextField(AsfFieldKey.RATING, string2);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            super.deleteField(((AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey))).getFieldName());
            return;
        }
        throw new KeyNotFoundException();
    }

    public void deleteField(AsfFieldKey asfFieldKey) {
        super.deleteField(asfFieldKey.getFieldName());
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        AsfFieldKey asfFieldKey = (AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey));
        if (asfFieldKey != null) {
            return super.getAll(asfFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public List<Artwork> getArtworkList() {
        List<TagField> list = this.getFields(FieldKey.COVER_ART);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AsfTagCoverField asfTagCoverField = (AsfTagCoverField)((TagField)iterator.next());
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setBinaryData(asfTagCoverField.getRawImageData());
            artwork.setMimeType(asfTagCoverField.getMimeType());
            artwork.setDescription(asfTagCoverField.getDescription());
            artwork.setPictureType(asfTagCoverField.getPictureType());
            arrayList.add((Object)artwork);
        }
        return arrayList;
    }

    public Iterator<AsfTagField> getAsfFields() {
        if (this.isCopyingFields()) {
            return new Iterator<AsfTagField>(this.getFields()){
                static final /* synthetic */ boolean $assertionsDisabled;
                private final Iterator<TagField> fieldIterator;
                {
                    this.fieldIterator = iterator;
                }

                public boolean hasNext() {
                    return this.fieldIterator.hasNext();
                }

                public AsfTagField next() {
                    return (AsfTagField)this.fieldIterator.next();
                }

                public void remove() {
                    this.fieldIterator.remove();
                }
            };
        }
        throw new IllegalStateException("Since the field conversion is not enabled, this method cannot be executed");
    }

    public List<TagField> getCopyright() {
        return this.getFields(AsfFieldKey.COPYRIGHT.getFieldName());
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            return super.getFields(((AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey))).getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    public String getFirst(AsfFieldKey asfFieldKey) throws KeyNotFoundException {
        if (asfFieldKey != null) {
            return super.getFirst(asfFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    public String getFirstCopyright() {
        return this.getFirst(AsfFieldKey.COPYRIGHT.getFieldName());
    }

    @Override
    public AsfTagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            return (AsfTagField)super.getFirstField(((AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey))).getFieldName());
        }
        throw new KeyNotFoundException();
    }

    public String getFirstRating() {
        return this.getFirst(AsfFieldKey.RATING.getFieldName());
    }

    public List<TagField> getRating() {
        return this.getFields(AsfFieldKey.RATING.getFieldName());
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey != null) {
            return super.getItem(((AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey))).getFieldName(), n2);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.getFields(((AsfFieldKey)((Object)tagFieldToAsfField.get((Object)fieldKey))).getFieldName()).size() != 0;
    }

    public boolean hasField(AsfFieldKey asfFieldKey) {
        return this.getFields(asfFieldKey.getFieldName()).size() != 0;
    }

    @Override
    protected boolean isAllowedEncoding(Charset charset) {
        return AsfHeader.ASF_CHARSET.name().equals((Object)charset);
    }

    public boolean isCopyingFields() {
        return this.copyFields;
    }

    public void setCopyright(String string2) {
        this.setField(this.createCopyrightField(string2));
    }

    @Override
    public void setField(TagField tagField) {
        if (this.isValidField(tagField)) {
            super.setField(this.copyFrom(tagField));
        }
    }

    public void setRating(String string2) {
        this.setField(this.createRatingField(string2));
    }

}

