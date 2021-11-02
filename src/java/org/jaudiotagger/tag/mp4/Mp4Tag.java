/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.EnumMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.jaudiotagger.tag.mp4.field.Mp4DiscNoField
 *  org.jaudiotagger.tag.mp4.field.Mp4GenreField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagByteField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagCoverField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField
 *  org.jaudiotagger.tag.mp4.field.Mp4TrackField
 */
package org.jaudiotagger.tag.mp4;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.Mp4TagFieldSubType;
import org.jaudiotagger.tag.mp4.field.Mp4DiscNoField;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;
import org.jaudiotagger.tag.mp4.field.Mp4GenreField;
import org.jaudiotagger.tag.mp4.field.Mp4TagByteField;
import org.jaudiotagger.tag.mp4.field.Mp4TagCoverField;
import org.jaudiotagger.tag.mp4.field.Mp4TagReverseDnsField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField;
import org.jaudiotagger.tag.mp4.field.Mp4TrackField;

public class Mp4Tag
extends AbstractTag {
    private static final EnumMap<FieldKey, Mp4FieldKey> tagFieldToMp4Field;

    static {
        EnumMap enumMap;
        tagFieldToMp4Field = enumMap = new EnumMap(FieldKey.class);
        enumMap.put((Enum)FieldKey.ACOUSTID_FINGERPRINT, (Object)Mp4FieldKey.ACOUSTID_FINGERPRINT);
        enumMap.put((Enum)FieldKey.ACOUSTID_ID, (Object)Mp4FieldKey.ACOUSTID_ID);
        enumMap.put((Enum)FieldKey.ALBUM, (Object)Mp4FieldKey.ALBUM);
        enumMap.put((Enum)FieldKey.ALBUM_ARTIST, (Object)Mp4FieldKey.ALBUM_ARTIST);
        enumMap.put((Enum)FieldKey.ALBUM_ARTIST_SORT, (Object)Mp4FieldKey.ALBUM_ARTIST_SORT);
        enumMap.put((Enum)FieldKey.ALBUM_ARTISTS, (Object)Mp4FieldKey.ALBUM_ARTISTS);
        enumMap.put((Enum)FieldKey.ALBUM_ARTISTS_SORT, (Object)Mp4FieldKey.ALBUM_ARTISTS_SORT);
        enumMap.put((Enum)FieldKey.ALBUM_SORT, (Object)Mp4FieldKey.ALBUM_SORT);
        enumMap.put((Enum)FieldKey.AMAZON_ID, (Object)Mp4FieldKey.ASIN);
        enumMap.put((Enum)FieldKey.ARRANGER, (Object)Mp4FieldKey.ARRANGER);
        enumMap.put((Enum)FieldKey.ARRANGER_SORT, (Object)Mp4FieldKey.ARRANGER_SORT);
        enumMap.put((Enum)FieldKey.ARTIST, (Object)Mp4FieldKey.ARTIST);
        enumMap.put((Enum)FieldKey.ARTISTS, (Object)Mp4FieldKey.ARTISTS);
        enumMap.put((Enum)FieldKey.ARTIST_SORT, (Object)Mp4FieldKey.ARTIST_SORT);
        enumMap.put((Enum)FieldKey.ARTISTS_SORT, (Object)Mp4FieldKey.ARTISTS_SORT);
        enumMap.put((Enum)FieldKey.BARCODE, (Object)Mp4FieldKey.BARCODE);
        enumMap.put((Enum)FieldKey.BPM, (Object)Mp4FieldKey.BPM);
        enumMap.put((Enum)FieldKey.CATALOG_NO, (Object)Mp4FieldKey.CATALOGNO);
        enumMap.put((Enum)FieldKey.CHOIR, (Object)Mp4FieldKey.CHOIR);
        enumMap.put((Enum)FieldKey.CHOIR_SORT, (Object)Mp4FieldKey.CHOIR_SORT);
        enumMap.put((Enum)FieldKey.CLASSICAL_CATALOG, (Object)Mp4FieldKey.CLASSICAL_CATALOG);
        enumMap.put((Enum)FieldKey.CLASSICAL_NICKNAME, (Object)Mp4FieldKey.CLASSICAL_NICKNAME);
        enumMap.put((Enum)FieldKey.COMMENT, (Object)Mp4FieldKey.COMMENT);
        enumMap.put((Enum)FieldKey.COMPOSER, (Object)Mp4FieldKey.COMPOSER);
        enumMap.put((Enum)FieldKey.COMPOSER_SORT, (Object)Mp4FieldKey.COMPOSER_SORT);
        EnumMap<FieldKey, Mp4FieldKey> enumMap2 = tagFieldToMp4Field;
        enumMap2.put((Enum)FieldKey.CONDUCTOR, (Object)Mp4FieldKey.CONDUCTOR);
        enumMap2.put((Enum)FieldKey.COUNTRY, (Object)Mp4FieldKey.COUNTRY);
        enumMap2.put((Enum)FieldKey.CONDUCTOR_SORT, (Object)Mp4FieldKey.CONDUCTOR_SORT);
        enumMap2.put((Enum)FieldKey.COPYRIGHT, (Object)Mp4FieldKey.COPYRIGHT);
        enumMap2.put((Enum)FieldKey.COVER_ART, (Object)Mp4FieldKey.ARTWORK);
        enumMap2.put((Enum)FieldKey.CUSTOM1, (Object)Mp4FieldKey.MM_CUSTOM_1);
        enumMap2.put((Enum)FieldKey.CUSTOM2, (Object)Mp4FieldKey.MM_CUSTOM_2);
        enumMap2.put((Enum)FieldKey.CUSTOM3, (Object)Mp4FieldKey.MM_CUSTOM_3);
        enumMap2.put((Enum)FieldKey.CUSTOM4, (Object)Mp4FieldKey.MM_CUSTOM_4);
        enumMap2.put((Enum)FieldKey.CUSTOM5, (Object)Mp4FieldKey.MM_CUSTOM_5);
        FieldKey fieldKey = FieldKey.DISC_NO;
        Mp4FieldKey mp4FieldKey = Mp4FieldKey.DISCNUMBER;
        enumMap2.put((Enum)fieldKey, (Object)mp4FieldKey);
        enumMap2.put((Enum)FieldKey.DISC_SUBTITLE, (Object)Mp4FieldKey.DISC_SUBTITLE);
        enumMap2.put((Enum)FieldKey.DISC_TOTAL, (Object)mp4FieldKey);
        enumMap2.put((Enum)FieldKey.DJMIXER, (Object)Mp4FieldKey.DJMIXER);
        enumMap2.put((Enum)FieldKey.MOOD_ELECTRONIC, (Object)Mp4FieldKey.MOOD_ELECTRONIC);
        enumMap2.put((Enum)FieldKey.ENCODER, (Object)Mp4FieldKey.ENCODER);
        enumMap2.put((Enum)FieldKey.ENGINEER, (Object)Mp4FieldKey.ENGINEER);
        enumMap2.put((Enum)FieldKey.ENSEMBLE, (Object)Mp4FieldKey.ENSEMBLE);
        enumMap2.put((Enum)FieldKey.ENSEMBLE_SORT, (Object)Mp4FieldKey.ENSEMBLE_SORT);
        enumMap2.put((Enum)FieldKey.FBPM, (Object)Mp4FieldKey.FBPM);
        enumMap2.put((Enum)FieldKey.GENRE, (Object)Mp4FieldKey.GENRE);
        enumMap2.put((Enum)FieldKey.GROUP, (Object)Mp4FieldKey.GROUP);
        enumMap2.put((Enum)FieldKey.GROUPING, (Object)Mp4FieldKey.GROUPING);
        enumMap2.put((Enum)FieldKey.INSTRUMENT, (Object)Mp4FieldKey.INSTRUMENT);
        enumMap2.put((Enum)FieldKey.INVOLVED_PERSON, (Object)Mp4FieldKey.INVOLVED_PEOPLE);
        enumMap2.put((Enum)FieldKey.ISRC, (Object)Mp4FieldKey.ISRC);
        EnumMap<FieldKey, Mp4FieldKey> enumMap3 = tagFieldToMp4Field;
        enumMap3.put((Enum)FieldKey.IS_COMPILATION, (Object)Mp4FieldKey.COMPILATION);
        enumMap3.put((Enum)FieldKey.IS_CLASSICAL, (Object)Mp4FieldKey.IS_CLASSICAL);
        enumMap3.put((Enum)FieldKey.IS_SOUNDTRACK, (Object)Mp4FieldKey.IS_SOUNDTRACK);
        enumMap3.put((Enum)FieldKey.KEY, (Object)Mp4FieldKey.KEY);
        enumMap3.put((Enum)FieldKey.LANGUAGE, (Object)Mp4FieldKey.LANGUAGE);
        enumMap3.put((Enum)FieldKey.LYRICIST, (Object)Mp4FieldKey.LYRICIST);
        enumMap3.put((Enum)FieldKey.LYRICS, (Object)Mp4FieldKey.LYRICS);
        enumMap3.put((Enum)FieldKey.MEDIA, (Object)Mp4FieldKey.MEDIA);
        enumMap3.put((Enum)FieldKey.MIXER, (Object)Mp4FieldKey.MIXER);
        enumMap3.put((Enum)FieldKey.MOOD, (Object)Mp4FieldKey.MOOD);
        enumMap3.put((Enum)FieldKey.MOOD_ACOUSTIC, (Object)Mp4FieldKey.MOOD_ACOUSTIC);
        enumMap3.put((Enum)FieldKey.MOOD_AGGRESSIVE, (Object)Mp4FieldKey.MOOD_AGGRESSIVE);
        enumMap3.put((Enum)FieldKey.MOOD_AROUSAL, (Object)Mp4FieldKey.MOOD_AROUSAL);
        enumMap3.put((Enum)FieldKey.MOOD_DANCEABILITY, (Object)Mp4FieldKey.MOOD_DANCEABILITY);
        enumMap3.put((Enum)FieldKey.MOOD_HAPPY, (Object)Mp4FieldKey.MOOD_HAPPY);
        enumMap3.put((Enum)FieldKey.MOOD_INSTRUMENTAL, (Object)Mp4FieldKey.MOOD_INSTRUMENTAL);
        enumMap3.put((Enum)FieldKey.MOOD_PARTY, (Object)Mp4FieldKey.MOOD_PARTY);
        enumMap3.put((Enum)FieldKey.MOOD_RELAXED, (Object)Mp4FieldKey.MOOD_RELAXED);
        enumMap3.put((Enum)FieldKey.MOOD_SAD, (Object)Mp4FieldKey.MOOD_SAD);
        enumMap3.put((Enum)FieldKey.MOOD_VALENCE, (Object)Mp4FieldKey.MOOD_VALENCE);
        enumMap3.put((Enum)FieldKey.MOVEMENT, (Object)Mp4FieldKey.MOVEMENT);
        enumMap3.put((Enum)FieldKey.MOVEMENT_NO, (Object)Mp4FieldKey.MOVEMENT_NO);
        enumMap3.put((Enum)FieldKey.MOVEMENT_TOTAL, (Object)Mp4FieldKey.MOVEMENT_TOTAL);
        enumMap3.put((Enum)FieldKey.MUSICBRAINZ_WORK, (Object)Mp4FieldKey.MUSICBRAINZ_WORK);
        enumMap3.put((Enum)FieldKey.MUSICBRAINZ_ARTISTID, (Object)Mp4FieldKey.MUSICBRAINZ_ARTISTID);
        EnumMap<FieldKey, Mp4FieldKey> enumMap4 = tagFieldToMp4Field;
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_DISC_ID, (Object)Mp4FieldKey.MUSICBRAINZ_DISCID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_ORIGINAL_RELEASE_ID, (Object)Mp4FieldKey.MUSICBRAINZ_ORIGINALALBUMID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASEARTISTID, (Object)Mp4FieldKey.MUSICBRAINZ_ALBUMARTISTID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASEID, (Object)Mp4FieldKey.MUSICBRAINZ_ALBUMID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_COUNTRY, (Object)Mp4FieldKey.RELEASECOUNTRY);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_GROUP_ID, (Object)Mp4FieldKey.MUSICBRAINZ_RELEASE_GROUPID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_STATUS, (Object)Mp4FieldKey.MUSICBRAINZ_ALBUM_STATUS);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TRACK_ID, (Object)Mp4FieldKey.MUSICBRAINZ_RELEASE_TRACKID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_ALBUM_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_TRACK_ID, (Object)Mp4FieldKey.MUSICBRAINZ_TRACKID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORKID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_COMPOSITION);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4);
        enumMap4.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE);
        EnumMap<FieldKey, Mp4FieldKey> enumMap5 = tagFieldToMp4Field;
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6);
        enumMap5.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE, (Object)Mp4FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE);
        enumMap5.put((Enum)FieldKey.MUSICIP_ID, (Object)Mp4FieldKey.MUSICIP_PUID);
        enumMap5.put((Enum)FieldKey.OCCASION, (Object)Mp4FieldKey.MM_OCCASION);
        enumMap5.put((Enum)FieldKey.OPUS, (Object)Mp4FieldKey.OPUS);
        enumMap5.put((Enum)FieldKey.ORCHESTRA, (Object)Mp4FieldKey.ORCHESTRA);
        enumMap5.put((Enum)FieldKey.ORCHESTRA_SORT, (Object)Mp4FieldKey.ORCHESTRA_SORT);
        enumMap5.put((Enum)FieldKey.ORIGINAL_ALBUM, (Object)Mp4FieldKey.MM_ORIGINAL_ALBUM_TITLE);
        enumMap5.put((Enum)FieldKey.ORIGINAL_ARTIST, (Object)Mp4FieldKey.MM_ORIGINAL_ARTIST);
        enumMap5.put((Enum)FieldKey.ORIGINAL_LYRICIST, (Object)Mp4FieldKey.MM_ORIGINAL_LYRICIST);
        enumMap5.put((Enum)FieldKey.ORIGINAL_YEAR, (Object)Mp4FieldKey.MM_ORIGINAL_YEAR);
        enumMap5.put((Enum)FieldKey.PART, (Object)Mp4FieldKey.PART);
        enumMap5.put((Enum)FieldKey.PART_NUMBER, (Object)Mp4FieldKey.PART_NUMBER);
        enumMap5.put((Enum)FieldKey.PART_TYPE, (Object)Mp4FieldKey.PART_TYPE);
        enumMap5.put((Enum)FieldKey.PERFORMER, (Object)Mp4FieldKey.PERFORMER);
        enumMap5.put((Enum)FieldKey.PERFORMER_NAME, (Object)Mp4FieldKey.PERFORMER_NAME);
        enumMap5.put((Enum)FieldKey.PERFORMER_NAME_SORT, (Object)Mp4FieldKey.PERFORMER_NAME_SORT);
        enumMap5.put((Enum)FieldKey.PERIOD, (Object)Mp4FieldKey.PERIOD);
        enumMap5.put((Enum)FieldKey.PRODUCER, (Object)Mp4FieldKey.PRODUCER);
        enumMap5.put((Enum)FieldKey.QUALITY, (Object)Mp4FieldKey.MM_QUALITY);
        enumMap5.put((Enum)FieldKey.RANKING, (Object)Mp4FieldKey.RANKING);
        EnumMap<FieldKey, Mp4FieldKey> enumMap6 = tagFieldToMp4Field;
        enumMap6.put((Enum)FieldKey.RATING, (Object)Mp4FieldKey.SCORE);
        enumMap6.put((Enum)FieldKey.RECORD_LABEL, (Object)Mp4FieldKey.LABEL);
        enumMap6.put((Enum)FieldKey.REMIXER, (Object)Mp4FieldKey.REMIXER);
        enumMap6.put((Enum)FieldKey.SCRIPT, (Object)Mp4FieldKey.SCRIPT);
        enumMap6.put((Enum)FieldKey.SINGLE_DISC_TRACK_NO, (Object)Mp4FieldKey.SINGLE_DISC_TRACK_NO);
        enumMap6.put((Enum)FieldKey.SUBTITLE, (Object)Mp4FieldKey.SUBTITLE);
        enumMap6.put((Enum)FieldKey.TAGS, (Object)Mp4FieldKey.TAGS);
        enumMap6.put((Enum)FieldKey.TEMPO, (Object)Mp4FieldKey.TEMPO);
        enumMap6.put((Enum)FieldKey.TIMBRE, (Object)Mp4FieldKey.TIMBRE);
        enumMap6.put((Enum)FieldKey.TITLE, (Object)Mp4FieldKey.TITLE);
        enumMap6.put((Enum)FieldKey.TITLE_MOVEMENT, (Object)Mp4FieldKey.TITLE_MOVEMENT);
        enumMap6.put((Enum)FieldKey.TITLE_SORT, (Object)Mp4FieldKey.TITLE_SORT);
        enumMap6.put((Enum)FieldKey.TONALITY, (Object)Mp4FieldKey.TONALITY);
        FieldKey fieldKey2 = FieldKey.TRACK;
        Mp4FieldKey mp4FieldKey2 = Mp4FieldKey.TRACK;
        enumMap6.put((Enum)fieldKey2, (Object)mp4FieldKey2);
        enumMap6.put((Enum)FieldKey.TRACK_TOTAL, (Object)mp4FieldKey2);
        enumMap6.put((Enum)FieldKey.URL_DISCOGS_ARTIST_SITE, (Object)Mp4FieldKey.URL_DISCOGS_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_DISCOGS_RELEASE_SITE, (Object)Mp4FieldKey.URL_DISCOGS_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.URL_LYRICS_SITE, (Object)Mp4FieldKey.URL_LYRICS_SITE);
        enumMap6.put((Enum)FieldKey.URL_OFFICIAL_ARTIST_SITE, (Object)Mp4FieldKey.URL_OFFICIAL_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_OFFICIAL_RELEASE_SITE, (Object)Mp4FieldKey.URL_OFFICIAL_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.URL_WIKIPEDIA_ARTIST_SITE, (Object)Mp4FieldKey.URL_WIKIPEDIA_ARTIST_SITE);
        enumMap6.put((Enum)FieldKey.URL_WIKIPEDIA_RELEASE_SITE, (Object)Mp4FieldKey.URL_WIKIPEDIA_RELEASE_SITE);
        enumMap6.put((Enum)FieldKey.WORK, (Object)Mp4FieldKey.WORK);
        enumMap6.put((Enum)FieldKey.YEAR, (Object)Mp4FieldKey.DAY);
        enumMap6.put((Enum)FieldKey.WORK_TYPE, (Object)Mp4FieldKey.WORK_TYPE);
    }

    private TagField createGenreField(String string2) {
        if (string2 != null) {
            if (TagOptionSingleton.getInstance().isWriteMp4GenresAsText()) {
                return new Mp4TagTextField(Mp4FieldKey.GENRE_CUSTOM.getFieldName(), string2);
            }
            if (Mp4GenreField.isValidGenre((String)string2)) {
                return new Mp4GenreField(string2);
            }
            return new Mp4TagTextField(Mp4FieldKey.GENRE_CUSTOM.getFieldName(), string2);
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != FieldKey.TRACK && fieldKey != FieldKey.TRACK_TOTAL && fieldKey != FieldKey.DISC_NO && fieldKey != FieldKey.DISC_TOTAL) {
            this.addField(this.createField(fieldKey, arrstring));
            return;
        }
        this.setField(fieldKey, arrstring);
    }

    public TagField createArtworkField(byte[] arrby) {
        return new Mp4TagCoverField(arrby);
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        if (bl) {
            String string2 = Mp4TagByteField.TRUE_VALUE;
            Mp4FieldKey mp4FieldKey = Mp4FieldKey.COMPILATION;
            return new Mp4TagByteField(mp4FieldKey, string2, mp4FieldKey.getFieldLength());
        }
        String string3 = Mp4TagByteField.FALSE_VALUE;
        Mp4FieldKey mp4FieldKey = Mp4FieldKey.COMPILATION;
        return new Mp4TagByteField(mp4FieldKey, string3, mp4FieldKey.getFieldLength());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (arrstring == null) {
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        if (fieldKey == null) {
            throw new KeyNotFoundException();
        }
        String string2 = arrstring[0];
        FieldKey fieldKey2 = FieldKey.TRACK;
        if (fieldKey != fieldKey2 && fieldKey != FieldKey.TRACK_TOTAL && fieldKey != FieldKey.DISC_NO && fieldKey != FieldKey.DISC_TOTAL) {
            if (fieldKey != FieldKey.GENRE) return this.createField((Mp4FieldKey)((Object)((Object)tagFieldToMp4Field.get((Object)fieldKey))), string2);
            if (TagOptionSingleton.getInstance().isWriteMp4GenresAsText()) {
                return new Mp4TagTextField(Mp4FieldKey.GENRE_CUSTOM.getFieldName(), string2);
            }
            if (!Mp4GenreField.isValidGenre((String)string2)) return new Mp4TagTextField(Mp4FieldKey.GENRE_CUSTOM.getFieldName(), string2);
            return new Mp4GenreField(string2);
        }
        try {
            int n2 = Integer.parseInt((String)string2);
            if (fieldKey == fieldKey2) {
                return new Mp4TrackField(n2);
            }
            if (fieldKey == FieldKey.TRACK_TOTAL) {
                return new Mp4TrackField(0, n2);
            }
            if (fieldKey == FieldKey.DISC_NO) {
                return new Mp4DiscNoField(n2);
            }
            if (fieldKey != FieldKey.DISC_TOTAL) return this.createField((Mp4FieldKey)((Object)((Object)tagFieldToMp4Field.get((Object)fieldKey))), string2);
            return new Mp4DiscNoField(0, n2);
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value ");
            stringBuilder.append(string2);
            stringBuilder.append(" is not a number as required");
            throw new FieldDataInvalidException(stringBuilder.toString(), numberFormatException);
        }
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        return new Mp4TagCoverField(artwork.getBinaryData());
    }

    public TagField createField(Mp4FieldKey mp4FieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (string2 != null) {
            if (mp4FieldKey != null) {
                if (mp4FieldKey == Mp4FieldKey.COMPILATION) {
                    if (!string2.equalsIgnoreCase("true") && !string2.equals((Object)"1")) {
                        return this.createCompilationField(false);
                    }
                    return this.createCompilationField(true);
                }
                if (mp4FieldKey == Mp4FieldKey.GENRE) {
                    if (Mp4GenreField.isValidGenre((String)string2)) {
                        return new Mp4GenreField(string2);
                    }
                    throw new IllegalArgumentException(ErrorMessage.NOT_STANDARD_MP$_GENRE.getMsg());
                }
                Mp4FieldKey mp4FieldKey2 = Mp4FieldKey.GENRE_CUSTOM;
                if (mp4FieldKey == mp4FieldKey2) {
                    return new Mp4TagTextField(mp4FieldKey2.getFieldName(), string2);
                }
                if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.DISC_NO) {
                    return new Mp4DiscNoField(string2);
                }
                if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.TRACK_NO) {
                    return new Mp4TrackField(string2);
                }
                if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.BYTE) {
                    return new Mp4TagByteField(mp4FieldKey, string2, mp4FieldKey.getFieldLength());
                }
                if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.NUMBER) {
                    return new Mp4TagTextNumberField(mp4FieldKey.getFieldName(), string2);
                }
                if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.REVERSE_DNS) {
                    return new Mp4TagReverseDnsField(mp4FieldKey, string2);
                }
                if (mp4FieldKey.getSubClassFieldType() != Mp4TagFieldSubType.ARTWORK) {
                    if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.TEXT) {
                        return new Mp4TagTextField(mp4FieldKey.getFieldName(), string2);
                    }
                    if (mp4FieldKey.getSubClassFieldType() == Mp4TagFieldSubType.UNKNOWN) {
                        ErrorMessage errorMessage = ErrorMessage.DO_NOT_KNOW_HOW_TO_CREATE_THIS_ATOM_TYPE;
                        Object[] arrobject = new Object[]{mp4FieldKey.getFieldName()};
                        throw new UnsupportedOperationException(errorMessage.getMsg(arrobject));
                    }
                    ErrorMessage errorMessage = ErrorMessage.DO_NOT_KNOW_HOW_TO_CREATE_THIS_ATOM_TYPE;
                    Object[] arrobject = new Object[]{mp4FieldKey.getFieldName()};
                    throw new UnsupportedOperationException(errorMessage.getMsg(arrobject));
                }
                throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
            }
            throw new KeyNotFoundException();
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            String string2 = ((Mp4FieldKey)((Object)tagFieldToMp4Field.get((Object)fieldKey))).getFieldName();
            if (fieldKey == FieldKey.KEY) {
                this.deleteField(Mp4FieldKey.KEY_OLD);
                this.deleteField(string2);
                return;
            }
            FieldKey fieldKey2 = FieldKey.TRACK;
            if (fieldKey == fieldKey2) {
                FieldKey fieldKey3 = FieldKey.TRACK_TOTAL;
                if (this.getFirst(fieldKey3).length() == 0) {
                    super.deleteField(string2);
                    return;
                }
                ((Mp4TrackField)this.getFirstField(fieldKey3)).setTrackNo(0);
                return;
            }
            if (fieldKey == FieldKey.TRACK_TOTAL) {
                if (this.getFirst(fieldKey2).length() == 0) {
                    super.deleteField(string2);
                    return;
                }
                ((Mp4TrackField)this.getFirstField(fieldKey2)).setTrackTotal(0);
                return;
            }
            FieldKey fieldKey4 = FieldKey.DISC_NO;
            if (fieldKey == fieldKey4) {
                FieldKey fieldKey5 = FieldKey.DISC_TOTAL;
                if (this.getFirst(fieldKey5).length() == 0) {
                    super.deleteField(string2);
                    return;
                }
                ((Mp4DiscNoField)this.getFirstField(fieldKey5)).setDiscNo(0);
                return;
            }
            if (fieldKey == FieldKey.DISC_TOTAL) {
                if (this.getFirst(fieldKey4).length() == 0) {
                    super.deleteField(string2);
                    return;
                }
                ((Mp4DiscNoField)this.getFirstField(fieldKey4)).setDiscTotal(0);
                return;
            }
            if (fieldKey == FieldKey.GENRE) {
                super.deleteField(Mp4FieldKey.GENRE.getFieldName());
                super.deleteField(Mp4FieldKey.GENRE_CUSTOM.getFieldName());
                return;
            }
            super.deleteField(string2);
            return;
        }
        throw new KeyNotFoundException();
    }

    public void deleteField(Mp4FieldKey mp4FieldKey) throws KeyNotFoundException {
        if (mp4FieldKey != null) {
            super.deleteField(mp4FieldKey.getFieldName());
            return;
        }
        throw new KeyNotFoundException();
    }

    public List<TagField> get(Mp4FieldKey mp4FieldKey) throws KeyNotFoundException {
        if (mp4FieldKey != null) {
            return super.getFields(mp4FieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (TagField tagField : this.getFields(fieldKey)) {
            if (fieldKey == FieldKey.TRACK) {
                arrayList.add((Object)((Mp4TrackField)tagField).getTrackNo().toString());
                continue;
            }
            if (fieldKey == FieldKey.TRACK_TOTAL) {
                arrayList.add((Object)((Mp4TrackField)tagField).getTrackTotal().toString());
                continue;
            }
            if (fieldKey == FieldKey.DISC_NO) {
                arrayList.add((Object)((Mp4DiscNoField)tagField).getDiscNo().toString());
                continue;
            }
            if (fieldKey == FieldKey.DISC_TOTAL) {
                arrayList.add((Object)((Mp4DiscNoField)tagField).getDiscTotal().toString());
                continue;
            }
            arrayList.add((Object)tagField.toString());
        }
        return arrayList;
    }

    @Override
    public List<Artwork> getArtworkList() {
        List<TagField> list = this.get(Mp4FieldKey.ARTWORK);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Mp4TagCoverField mp4TagCoverField = (Mp4TagCoverField)((TagField)iterator.next());
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setBinaryData(mp4TagCoverField.getData());
            artwork.setMimeType(Mp4TagCoverField.getMimeTypeForImageType((Mp4FieldType)mp4TagCoverField.getFieldType()));
            arrayList.add((Object)artwork);
        }
        return arrayList;
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            List<TagField> list = this.getFields(((Mp4FieldKey)((Object)tagFieldToMp4Field.get((Object)fieldKey))).getFieldName());
            ArrayList arrayList = new ArrayList();
            if (fieldKey == FieldKey.KEY) {
                if (list.size() == 0) {
                    list = this.getFields(Mp4FieldKey.KEY_OLD.getFieldName());
                }
                return list;
            }
            if (fieldKey == FieldKey.GENRE) {
                if (list.size() == 0) {
                    list = this.getFields(Mp4FieldKey.GENRE_CUSTOM.getFieldName());
                }
                return list;
            }
            if (fieldKey == FieldKey.TRACK) {
                for (TagField tagField : list) {
                    if (((Mp4TrackField)tagField).getTrackNo() <= 0) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            if (fieldKey == FieldKey.TRACK_TOTAL) {
                for (TagField tagField : list) {
                    if (((Mp4TrackField)tagField).getTrackTotal() <= 0) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            if (fieldKey == FieldKey.DISC_NO) {
                for (TagField tagField : list) {
                    if (((Mp4DiscNoField)tagField).getDiscNo() <= 0) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            if (fieldKey == FieldKey.DISC_TOTAL) {
                for (TagField tagField : list) {
                    if (((Mp4DiscNoField)tagField).getDiscTotal() <= 0) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            return list;
        }
        throw new KeyNotFoundException();
    }

    public String getFirst(Mp4FieldKey mp4FieldKey) throws KeyNotFoundException {
        if (mp4FieldKey != null) {
            return super.getFirst(mp4FieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public Mp4TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        List<TagField> list = this.getFields(fieldKey);
        if (list.size() == 0) {
            return null;
        }
        return (Mp4TagField)list.get(0);
    }

    public Mp4TagField getFirstField(Mp4FieldKey mp4FieldKey) throws KeyNotFoundException {
        if (mp4FieldKey != null) {
            return (Mp4TagField)super.getFirstField(mp4FieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        List<TagField> list = this.getFields(fieldKey);
        if (list.size() > n2) {
            TagField tagField = (TagField)list.get(n2);
            if (fieldKey == FieldKey.TRACK) {
                return ((Mp4TrackField)tagField).getTrackNo().toString();
            }
            if (fieldKey == FieldKey.DISC_NO) {
                return ((Mp4DiscNoField)tagField).getDiscNo().toString();
            }
            if (fieldKey == FieldKey.TRACK_TOTAL) {
                return ((Mp4TrackField)tagField).getTrackTotal().toString();
            }
            if (fieldKey == FieldKey.DISC_TOTAL) {
                return ((Mp4DiscNoField)tagField).getDiscTotal().toString();
            }
            return tagField.toString();
        }
        return "";
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.getFields(fieldKey).size() != 0;
    }

    public boolean hasField(Mp4FieldKey mp4FieldKey) {
        return this.getFields(mp4FieldKey.getFieldName()).size() != 0;
    }

    @Override
    protected boolean isAllowedEncoding(Charset charset) {
        return StandardCharsets.UTF_8.equals((Object)charset);
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        TagField tagField = this.createField(fieldKey, arrstring);
        if (fieldKey == FieldKey.GENRE) {
            Mp4FieldKey mp4FieldKey;
            String string2 = tagField.getId();
            if (string2.equals((Object)(mp4FieldKey = Mp4FieldKey.GENRE).getFieldName())) {
                this.deleteField(Mp4FieldKey.GENRE_CUSTOM);
            } else if (tagField.getId().equals((Object)Mp4FieldKey.GENRE_CUSTOM.getFieldName())) {
                this.deleteField(mp4FieldKey);
            }
        }
        this.setField(tagField);
    }

    @Override
    public void setField(TagField tagField) {
        if (tagField == null) {
            return;
        }
        if (tagField.getId().equals((Object)Mp4FieldKey.TRACK.getFieldName())) {
            List list = (List)this.fields.get((Object)tagField.getId());
            if (list != null && list.size() != 0) {
                Mp4TrackField mp4TrackField = (Mp4TrackField)list.get(0);
                Mp4TrackField mp4TrackField2 = (Mp4TrackField)tagField;
                Short s2 = mp4TrackField.getTrackNo();
                Short s3 = mp4TrackField.getTrackTotal();
                if (mp4TrackField2.getTrackNo() > 0) {
                    s2 = mp4TrackField2.getTrackNo();
                }
                if (mp4TrackField2.getTrackTotal() > 0) {
                    s3 = mp4TrackField2.getTrackTotal();
                }
                super.setField((TagField)new Mp4TrackField((int)s2.shortValue(), (int)s3.shortValue()));
                return;
            }
            super.setField(tagField);
            return;
        }
        if (tagField.getId().equals((Object)Mp4FieldKey.DISCNUMBER.getFieldName())) {
            List list = (List)this.fields.get((Object)tagField.getId());
            if (list != null && list.size() != 0) {
                Mp4DiscNoField mp4DiscNoField = (Mp4DiscNoField)list.get(0);
                Mp4DiscNoField mp4DiscNoField2 = (Mp4DiscNoField)tagField;
                Short s4 = mp4DiscNoField.getDiscNo();
                Short s5 = mp4DiscNoField.getDiscTotal();
                if (mp4DiscNoField2.getDiscNo() > 0) {
                    s4 = mp4DiscNoField2.getDiscNo();
                }
                if (mp4DiscNoField2.getDiscTotal() > 0) {
                    s5 = mp4DiscNoField2.getDiscTotal();
                }
                super.setField((TagField)new Mp4DiscNoField((int)s4.shortValue(), (int)s5.shortValue()));
                return;
            }
            super.setField(tagField);
            return;
        }
        super.setField(tagField);
    }

    public void setField(Mp4FieldKey mp4FieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(mp4FieldKey, string2));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mpeg4 ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}

