/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag;

public final class FieldKey
extends Enum<FieldKey> {
    private static final /* synthetic */ FieldKey[] $VALUES;
    public static final /* enum */ FieldKey ACOUSTID_FINGERPRINT = new FieldKey();
    public static final /* enum */ FieldKey ACOUSTID_ID = new FieldKey();
    public static final /* enum */ FieldKey ALBUM = new FieldKey();
    public static final /* enum */ FieldKey ALBUM_ARTIST = new FieldKey();
    public static final /* enum */ FieldKey ALBUM_ARTISTS;
    public static final /* enum */ FieldKey ALBUM_ARTISTS_SORT;
    public static final /* enum */ FieldKey ALBUM_ARTIST_SORT;
    public static final /* enum */ FieldKey ALBUM_SORT;
    public static final /* enum */ FieldKey AMAZON_ID;
    public static final /* enum */ FieldKey ARRANGER;
    public static final /* enum */ FieldKey ARRANGER_SORT;
    public static final /* enum */ FieldKey ARTIST;
    public static final /* enum */ FieldKey ARTISTS;
    public static final /* enum */ FieldKey ARTISTS_SORT;
    public static final /* enum */ FieldKey ARTIST_SORT;
    public static final /* enum */ FieldKey BARCODE;
    public static final /* enum */ FieldKey BPM;
    public static final /* enum */ FieldKey CATALOG_NO;
    public static final /* enum */ FieldKey CHOIR;
    public static final /* enum */ FieldKey CHOIR_SORT;
    public static final /* enum */ FieldKey CLASSICAL_CATALOG;
    public static final /* enum */ FieldKey CLASSICAL_NICKNAME;
    public static final /* enum */ FieldKey COMMENT;
    public static final /* enum */ FieldKey COMPOSER;
    public static final /* enum */ FieldKey COMPOSER_SORT;
    public static final /* enum */ FieldKey CONDUCTOR;
    public static final /* enum */ FieldKey CONDUCTOR_SORT;
    public static final /* enum */ FieldKey COPYRIGHT;
    public static final /* enum */ FieldKey COUNTRY;
    public static final /* enum */ FieldKey COVER_ART;
    public static final /* enum */ FieldKey CUSTOM1;
    public static final /* enum */ FieldKey CUSTOM2;
    public static final /* enum */ FieldKey CUSTOM3;
    public static final /* enum */ FieldKey CUSTOM4;
    public static final /* enum */ FieldKey CUSTOM5;
    public static final /* enum */ FieldKey DISC_NO;
    public static final /* enum */ FieldKey DISC_SUBTITLE;
    public static final /* enum */ FieldKey DISC_TOTAL;
    public static final /* enum */ FieldKey DJMIXER;
    public static final /* enum */ FieldKey ENCODER;
    public static final /* enum */ FieldKey ENGINEER;
    public static final /* enum */ FieldKey ENSEMBLE;
    public static final /* enum */ FieldKey ENSEMBLE_SORT;
    public static final /* enum */ FieldKey FBPM;
    public static final /* enum */ FieldKey GENRE;
    public static final /* enum */ FieldKey GROUP;
    public static final /* enum */ FieldKey GROUPING;
    public static final /* enum */ FieldKey INSTRUMENT;
    public static final /* enum */ FieldKey INVOLVED_PERSON;
    public static final /* enum */ FieldKey ISRC;
    public static final /* enum */ FieldKey IS_CLASSICAL;
    public static final /* enum */ FieldKey IS_COMPILATION;
    public static final /* enum */ FieldKey IS_SOUNDTRACK;
    public static final /* enum */ FieldKey ITUNES_GROUPING;
    public static final /* enum */ FieldKey KEY;
    public static final /* enum */ FieldKey LANGUAGE;
    public static final /* enum */ FieldKey LYRICIST;
    public static final /* enum */ FieldKey LYRICS;
    public static final /* enum */ FieldKey MEDIA;
    public static final /* enum */ FieldKey MIXER;
    public static final /* enum */ FieldKey MOOD;
    public static final /* enum */ FieldKey MOOD_ACOUSTIC;
    public static final /* enum */ FieldKey MOOD_AGGRESSIVE;
    public static final /* enum */ FieldKey MOOD_AROUSAL;
    public static final /* enum */ FieldKey MOOD_DANCEABILITY;
    public static final /* enum */ FieldKey MOOD_ELECTRONIC;
    public static final /* enum */ FieldKey MOOD_HAPPY;
    public static final /* enum */ FieldKey MOOD_INSTRUMENTAL;
    public static final /* enum */ FieldKey MOOD_PARTY;
    public static final /* enum */ FieldKey MOOD_RELAXED;
    public static final /* enum */ FieldKey MOOD_SAD;
    public static final /* enum */ FieldKey MOOD_VALENCE;
    public static final /* enum */ FieldKey MOVEMENT;
    public static final /* enum */ FieldKey MOVEMENT_NO;
    public static final /* enum */ FieldKey MOVEMENT_TOTAL;
    public static final /* enum */ FieldKey MUSICBRAINZ_ARTISTID;
    public static final /* enum */ FieldKey MUSICBRAINZ_DISC_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_ORIGINAL_RELEASE_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASEARTISTID;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASEID;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASE_COUNTRY;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASE_GROUP_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASE_STATUS;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASE_TRACK_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_RELEASE_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_TRACK_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_COMPOSITION;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_COMPOSITION_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL1;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL1_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL1_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL2;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL2_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL2_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL3;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL3_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL3_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL4;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL4_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL4_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL5;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL5_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL5_TYPE;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL6;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL6_ID;
    public static final /* enum */ FieldKey MUSICBRAINZ_WORK_PART_LEVEL6_TYPE;
    public static final /* enum */ FieldKey MUSICIP_ID;
    public static final /* enum */ FieldKey OCCASION;
    public static final /* enum */ FieldKey OPUS;
    public static final /* enum */ FieldKey ORCHESTRA;
    public static final /* enum */ FieldKey ORCHESTRA_SORT;
    public static final /* enum */ FieldKey ORIGINAL_ALBUM;
    public static final /* enum */ FieldKey ORIGINAL_ARTIST;
    public static final /* enum */ FieldKey ORIGINAL_LYRICIST;
    public static final /* enum */ FieldKey ORIGINAL_YEAR;
    public static final /* enum */ FieldKey PART;
    public static final /* enum */ FieldKey PART_NUMBER;
    public static final /* enum */ FieldKey PART_TYPE;
    public static final /* enum */ FieldKey PERFORMER;
    public static final /* enum */ FieldKey PERFORMER_NAME;
    public static final /* enum */ FieldKey PERFORMER_NAME_SORT;
    public static final /* enum */ FieldKey PERIOD;
    public static final /* enum */ FieldKey PRODUCER;
    public static final /* enum */ FieldKey QUALITY;
    public static final /* enum */ FieldKey RANKING;
    public static final /* enum */ FieldKey RATING;
    public static final /* enum */ FieldKey RECORD_LABEL;
    public static final /* enum */ FieldKey REMIXER;
    public static final /* enum */ FieldKey SCRIPT;
    public static final /* enum */ FieldKey SINGLE_DISC_TRACK_NO;
    public static final /* enum */ FieldKey SUBTITLE;
    public static final /* enum */ FieldKey TAGS;
    public static final /* enum */ FieldKey TEMPO;
    public static final /* enum */ FieldKey TIMBRE;
    public static final /* enum */ FieldKey TITLE;
    public static final /* enum */ FieldKey TITLE_MOVEMENT;
    public static final /* enum */ FieldKey TITLE_SORT;
    public static final /* enum */ FieldKey TONALITY;
    public static final /* enum */ FieldKey TRACK;
    public static final /* enum */ FieldKey TRACK_TOTAL;
    public static final /* enum */ FieldKey URL_DISCOGS_ARTIST_SITE;
    public static final /* enum */ FieldKey URL_DISCOGS_RELEASE_SITE;
    public static final /* enum */ FieldKey URL_LYRICS_SITE;
    public static final /* enum */ FieldKey URL_OFFICIAL_ARTIST_SITE;
    public static final /* enum */ FieldKey URL_OFFICIAL_RELEASE_SITE;
    public static final /* enum */ FieldKey URL_WIKIPEDIA_ARTIST_SITE;
    public static final /* enum */ FieldKey URL_WIKIPEDIA_RELEASE_SITE;
    public static final /* enum */ FieldKey WORK;
    public static final /* enum */ FieldKey WORK_TYPE;
    public static final /* enum */ FieldKey YEAR;

    static {
        ALBUM_ARTIST_SORT = new FieldKey();
        ALBUM_ARTISTS = new FieldKey();
        ALBUM_ARTISTS_SORT = new FieldKey();
        ALBUM_SORT = new FieldKey();
        AMAZON_ID = new FieldKey();
        ARRANGER = new FieldKey();
        ARRANGER_SORT = new FieldKey();
        ARTIST = new FieldKey();
        ARTISTS = new FieldKey();
        ARTISTS_SORT = new FieldKey();
        ARTIST_SORT = new FieldKey();
        BARCODE = new FieldKey();
        BPM = new FieldKey();
        CATALOG_NO = new FieldKey();
        CLASSICAL_CATALOG = new FieldKey();
        CLASSICAL_NICKNAME = new FieldKey();
        CHOIR = new FieldKey();
        CHOIR_SORT = new FieldKey();
        COMMENT = new FieldKey();
        COMPOSER = new FieldKey();
        COMPOSER_SORT = new FieldKey();
        CONDUCTOR = new FieldKey();
        CONDUCTOR_SORT = new FieldKey();
        COPYRIGHT = new FieldKey();
        COUNTRY = new FieldKey();
        COVER_ART = new FieldKey();
        CUSTOM1 = new FieldKey();
        CUSTOM2 = new FieldKey();
        CUSTOM3 = new FieldKey();
        CUSTOM4 = new FieldKey();
        CUSTOM5 = new FieldKey();
        DISC_NO = new FieldKey();
        DISC_SUBTITLE = new FieldKey();
        DISC_TOTAL = new FieldKey();
        DJMIXER = new FieldKey();
        ENCODER = new FieldKey();
        ENGINEER = new FieldKey();
        ENSEMBLE = new FieldKey();
        ENSEMBLE_SORT = new FieldKey();
        FBPM = new FieldKey();
        GENRE = new FieldKey();
        GROUP = new FieldKey();
        GROUPING = new FieldKey();
        INSTRUMENT = new FieldKey();
        INVOLVED_PERSON = new FieldKey();
        ISRC = new FieldKey();
        IS_CLASSICAL = new FieldKey();
        IS_SOUNDTRACK = new FieldKey();
        IS_COMPILATION = new FieldKey();
        ITUNES_GROUPING = new FieldKey();
        KEY = new FieldKey();
        LANGUAGE = new FieldKey();
        LYRICIST = new FieldKey();
        LYRICS = new FieldKey();
        MEDIA = new FieldKey();
        MIXER = new FieldKey();
        MOOD = new FieldKey();
        MOOD_ACOUSTIC = new FieldKey();
        MOOD_AGGRESSIVE = new FieldKey();
        MOOD_AROUSAL = new FieldKey();
        MOOD_DANCEABILITY = new FieldKey();
        MOOD_ELECTRONIC = new FieldKey();
        MOOD_HAPPY = new FieldKey();
        MOOD_INSTRUMENTAL = new FieldKey();
        MOOD_PARTY = new FieldKey();
        MOOD_RELAXED = new FieldKey();
        MOOD_SAD = new FieldKey();
        MOOD_VALENCE = new FieldKey();
        MOVEMENT = new FieldKey();
        MOVEMENT_NO = new FieldKey();
        MOVEMENT_TOTAL = new FieldKey();
        MUSICBRAINZ_ARTISTID = new FieldKey();
        MUSICBRAINZ_DISC_ID = new FieldKey();
        MUSICBRAINZ_ORIGINAL_RELEASE_ID = new FieldKey();
        MUSICBRAINZ_RELEASEARTISTID = new FieldKey();
        MUSICBRAINZ_RELEASEID = new FieldKey();
        MUSICBRAINZ_RELEASE_COUNTRY = new FieldKey();
        MUSICBRAINZ_RELEASE_GROUP_ID = new FieldKey();
        MUSICBRAINZ_RELEASE_STATUS = new FieldKey();
        MUSICBRAINZ_RELEASE_TRACK_ID = new FieldKey();
        MUSICBRAINZ_RELEASE_TYPE = new FieldKey();
        MUSICBRAINZ_TRACK_ID = new FieldKey();
        MUSICBRAINZ_WORK = new FieldKey();
        MUSICBRAINZ_WORK_ID = new FieldKey();
        MUSICBRAINZ_WORK_COMPOSITION = new FieldKey();
        MUSICBRAINZ_WORK_COMPOSITION_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL1 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL1_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL1_TYPE = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL2 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL2_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL2_TYPE = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL3 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL3_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL3_TYPE = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL4 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL4_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL4_TYPE = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL5 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL5_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL5_TYPE = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL6 = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL6_ID = new FieldKey();
        MUSICBRAINZ_WORK_PART_LEVEL6_TYPE = new FieldKey();
        MUSICIP_ID = new FieldKey();
        OCCASION = new FieldKey();
        OPUS = new FieldKey();
        ORCHESTRA = new FieldKey();
        ORCHESTRA_SORT = new FieldKey();
        ORIGINAL_ALBUM = new FieldKey();
        ORIGINAL_ARTIST = new FieldKey();
        ORIGINAL_LYRICIST = new FieldKey();
        ORIGINAL_YEAR = new FieldKey();
        PART = new FieldKey();
        PART_NUMBER = new FieldKey();
        PART_TYPE = new FieldKey();
        PERFORMER = new FieldKey();
        PERFORMER_NAME = new FieldKey();
        PERFORMER_NAME_SORT = new FieldKey();
        PERIOD = new FieldKey();
        PRODUCER = new FieldKey();
        QUALITY = new FieldKey();
        RANKING = new FieldKey();
        RATING = new FieldKey();
        RECORD_LABEL = new FieldKey();
        REMIXER = new FieldKey();
        SCRIPT = new FieldKey();
        SINGLE_DISC_TRACK_NO = new FieldKey();
        SUBTITLE = new FieldKey();
        TAGS = new FieldKey();
        TEMPO = new FieldKey();
        TIMBRE = new FieldKey();
        TITLE = new FieldKey();
        TITLE_SORT = new FieldKey();
        TITLE_MOVEMENT = new FieldKey();
        TONALITY = new FieldKey();
        TRACK = new FieldKey();
        TRACK_TOTAL = new FieldKey();
        URL_DISCOGS_ARTIST_SITE = new FieldKey();
        URL_DISCOGS_RELEASE_SITE = new FieldKey();
        URL_LYRICS_SITE = new FieldKey();
        URL_OFFICIAL_ARTIST_SITE = new FieldKey();
        URL_OFFICIAL_RELEASE_SITE = new FieldKey();
        URL_WIKIPEDIA_ARTIST_SITE = new FieldKey();
        URL_WIKIPEDIA_RELEASE_SITE = new FieldKey();
        WORK = new FieldKey();
        WORK_TYPE = new FieldKey();
        YEAR = new FieldKey();
        FieldKey[] arrfieldKey = new FieldKey[]{ACOUSTID_FINGERPRINT, ACOUSTID_ID, ALBUM, ALBUM_ARTIST, ALBUM_ARTIST_SORT, ALBUM_ARTISTS, ALBUM_ARTISTS_SORT, ALBUM_SORT, AMAZON_ID, ARRANGER, ARRANGER_SORT, ARTIST, ARTISTS, ARTISTS_SORT, ARTIST_SORT, BARCODE, BPM, CATALOG_NO, CLASSICAL_CATALOG, CLASSICAL_NICKNAME, CHOIR, CHOIR_SORT, COMMENT, COMPOSER, COMPOSER_SORT, CONDUCTOR, CONDUCTOR_SORT, COPYRIGHT, COUNTRY, COVER_ART, CUSTOM1, CUSTOM2, CUSTOM3, CUSTOM4, CUSTOM5, DISC_NO, DISC_SUBTITLE, DISC_TOTAL, DJMIXER, ENCODER, ENGINEER, ENSEMBLE, ENSEMBLE_SORT, FBPM, GENRE, GROUP, GROUPING, INSTRUMENT, INVOLVED_PERSON, ISRC, IS_CLASSICAL, IS_SOUNDTRACK, IS_COMPILATION, ITUNES_GROUPING, KEY, LANGUAGE, LYRICIST, LYRICS, MEDIA, MIXER, MOOD, MOOD_ACOUSTIC, MOOD_AGGRESSIVE, MOOD_AROUSAL, MOOD_DANCEABILITY, MOOD_ELECTRONIC, MOOD_HAPPY, MOOD_INSTRUMENTAL, MOOD_PARTY, MOOD_RELAXED, MOOD_SAD, MOOD_VALENCE, MOVEMENT, MOVEMENT_NO, MOVEMENT_TOTAL, MUSICBRAINZ_ARTISTID, MUSICBRAINZ_DISC_ID, MUSICBRAINZ_ORIGINAL_RELEASE_ID, MUSICBRAINZ_RELEASEARTISTID, MUSICBRAINZ_RELEASEID, MUSICBRAINZ_RELEASE_COUNTRY, MUSICBRAINZ_RELEASE_GROUP_ID, MUSICBRAINZ_RELEASE_STATUS, MUSICBRAINZ_RELEASE_TRACK_ID, MUSICBRAINZ_RELEASE_TYPE, MUSICBRAINZ_TRACK_ID, MUSICBRAINZ_WORK, MUSICBRAINZ_WORK_ID, MUSICBRAINZ_WORK_COMPOSITION, MUSICBRAINZ_WORK_COMPOSITION_ID, MUSICBRAINZ_WORK_PART_LEVEL1, MUSICBRAINZ_WORK_PART_LEVEL1_ID, MUSICBRAINZ_WORK_PART_LEVEL1_TYPE, MUSICBRAINZ_WORK_PART_LEVEL2, MUSICBRAINZ_WORK_PART_LEVEL2_ID, MUSICBRAINZ_WORK_PART_LEVEL2_TYPE, MUSICBRAINZ_WORK_PART_LEVEL3, MUSICBRAINZ_WORK_PART_LEVEL3_ID, MUSICBRAINZ_WORK_PART_LEVEL3_TYPE, MUSICBRAINZ_WORK_PART_LEVEL4, MUSICBRAINZ_WORK_PART_LEVEL4_ID, MUSICBRAINZ_WORK_PART_LEVEL4_TYPE, MUSICBRAINZ_WORK_PART_LEVEL5, MUSICBRAINZ_WORK_PART_LEVEL5_ID, MUSICBRAINZ_WORK_PART_LEVEL5_TYPE, MUSICBRAINZ_WORK_PART_LEVEL6, MUSICBRAINZ_WORK_PART_LEVEL6_ID, MUSICBRAINZ_WORK_PART_LEVEL6_TYPE, MUSICIP_ID, OCCASION, OPUS, ORCHESTRA, ORCHESTRA_SORT, ORIGINAL_ALBUM, ORIGINAL_ARTIST, ORIGINAL_LYRICIST, ORIGINAL_YEAR, PART, PART_NUMBER, PART_TYPE, PERFORMER, PERFORMER_NAME, PERFORMER_NAME_SORT, PERIOD, PRODUCER, QUALITY, RANKING, RATING, RECORD_LABEL, REMIXER, SCRIPT, SINGLE_DISC_TRACK_NO, SUBTITLE, TAGS, TEMPO, TIMBRE, TITLE, TITLE_SORT, TITLE_MOVEMENT, TONALITY, TRACK, TRACK_TOTAL, URL_DISCOGS_ARTIST_SITE, URL_DISCOGS_RELEASE_SITE, URL_LYRICS_SITE, URL_OFFICIAL_ARTIST_SITE, URL_OFFICIAL_RELEASE_SITE, URL_WIKIPEDIA_ARTIST_SITE, URL_WIKIPEDIA_RELEASE_SITE, WORK, WORK_TYPE, YEAR};
        $VALUES = arrfieldKey;
    }

    public static FieldKey valueOf(String string2) {
        return (FieldKey)Enum.valueOf(FieldKey.class, (String)string2);
    }

    public static FieldKey[] values() {
        return (FieldKey[])$VALUES.clone();
    }
}
