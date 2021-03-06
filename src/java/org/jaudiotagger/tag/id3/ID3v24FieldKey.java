/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.tag.id3;

import org.jaudiotagger.tag.id3.Id3FieldType;
import org.jaudiotagger.tag.id3.valuepair.StandardIPLSKey;

public final class ID3v24FieldKey
extends Enum<ID3v24FieldKey> {
    private static final /* synthetic */ ID3v24FieldKey[] $VALUES;
    public static final /* enum */ ID3v24FieldKey ACOUSTID_FINGERPRINT;
    public static final /* enum */ ID3v24FieldKey ACOUSTID_ID;
    public static final /* enum */ ID3v24FieldKey ALBUM;
    public static final /* enum */ ID3v24FieldKey ALBUM_ARTIST;
    public static final /* enum */ ID3v24FieldKey ALBUM_ARTISTS;
    public static final /* enum */ ID3v24FieldKey ALBUM_ARTISTS_SORT;
    public static final /* enum */ ID3v24FieldKey ALBUM_ARTIST_SORT;
    public static final /* enum */ ID3v24FieldKey ALBUM_SORT;
    public static final /* enum */ ID3v24FieldKey AMAZON_ID;
    public static final /* enum */ ID3v24FieldKey ARRANGER;
    public static final /* enum */ ID3v24FieldKey ARRANGER_SORT;
    public static final /* enum */ ID3v24FieldKey ARTIST;
    public static final /* enum */ ID3v24FieldKey ARTISTS;
    public static final /* enum */ ID3v24FieldKey ARTISTS_SORT;
    public static final /* enum */ ID3v24FieldKey ARTIST_SORT;
    public static final /* enum */ ID3v24FieldKey BARCODE;
    public static final /* enum */ ID3v24FieldKey BPM;
    public static final /* enum */ ID3v24FieldKey CATALOG_NO;
    public static final /* enum */ ID3v24FieldKey CHOIR;
    public static final /* enum */ ID3v24FieldKey CHOIR_SORT;
    public static final /* enum */ ID3v24FieldKey CLASSICAL_CATALOG;
    public static final /* enum */ ID3v24FieldKey CLASSICAL_NICKNAME;
    public static final /* enum */ ID3v24FieldKey COMMENT;
    public static final /* enum */ ID3v24FieldKey COMPOSER;
    public static final /* enum */ ID3v24FieldKey COMPOSER_SORT;
    public static final /* enum */ ID3v24FieldKey CONDUCTOR;
    public static final /* enum */ ID3v24FieldKey CONDUCTOR_SORT;
    public static final /* enum */ ID3v24FieldKey COPYRIGHT;
    public static final /* enum */ ID3v24FieldKey COUNTRY;
    public static final /* enum */ ID3v24FieldKey COVER_ART;
    public static final /* enum */ ID3v24FieldKey CUSTOM1;
    public static final /* enum */ ID3v24FieldKey CUSTOM2;
    public static final /* enum */ ID3v24FieldKey CUSTOM3;
    public static final /* enum */ ID3v24FieldKey CUSTOM4;
    public static final /* enum */ ID3v24FieldKey CUSTOM5;
    public static final /* enum */ ID3v24FieldKey DISC_NO;
    public static final /* enum */ ID3v24FieldKey DISC_SUBTITLE;
    public static final /* enum */ ID3v24FieldKey DISC_TOTAL;
    public static final /* enum */ ID3v24FieldKey DJMIXER;
    public static final /* enum */ ID3v24FieldKey ENCODER;
    public static final /* enum */ ID3v24FieldKey ENGINEER;
    public static final /* enum */ ID3v24FieldKey ENSEMBLE;
    public static final /* enum */ ID3v24FieldKey ENSEMBLE_SORT;
    public static final /* enum */ ID3v24FieldKey FBPM;
    public static final /* enum */ ID3v24FieldKey GENRE;
    public static final /* enum */ ID3v24FieldKey GROUP;
    public static final /* enum */ ID3v24FieldKey GROUPING;
    public static final /* enum */ ID3v24FieldKey INSTRUMENT;
    public static final /* enum */ ID3v24FieldKey INVOLVED_PERSON;
    public static final /* enum */ ID3v24FieldKey ISRC;
    public static final /* enum */ ID3v24FieldKey IS_CLASSICAL;
    public static final /* enum */ ID3v24FieldKey IS_COMPILATION;
    public static final /* enum */ ID3v24FieldKey IS_SOUNDTRACK;
    public static final /* enum */ ID3v24FieldKey ITUNES_GROUPING;
    public static final /* enum */ ID3v24FieldKey KEY;
    public static final /* enum */ ID3v24FieldKey LANGUAGE;
    public static final /* enum */ ID3v24FieldKey LYRICIST;
    public static final /* enum */ ID3v24FieldKey LYRICS;
    public static final /* enum */ ID3v24FieldKey MEDIA;
    public static final /* enum */ ID3v24FieldKey MIXER;
    public static final /* enum */ ID3v24FieldKey MOOD;
    public static final /* enum */ ID3v24FieldKey MOOD_ACOUSTIC;
    public static final /* enum */ ID3v24FieldKey MOOD_AGGRESSIVE;
    public static final /* enum */ ID3v24FieldKey MOOD_AROUSAL;
    public static final /* enum */ ID3v24FieldKey MOOD_DANCEABILITY;
    public static final /* enum */ ID3v24FieldKey MOOD_ELECTRONIC;
    public static final /* enum */ ID3v24FieldKey MOOD_HAPPY;
    public static final /* enum */ ID3v24FieldKey MOOD_INSTRUMENTAL;
    public static final /* enum */ ID3v24FieldKey MOOD_PARTY;
    public static final /* enum */ ID3v24FieldKey MOOD_RELAXED;
    public static final /* enum */ ID3v24FieldKey MOOD_SAD;
    public static final /* enum */ ID3v24FieldKey MOOD_VALENCE;
    public static final /* enum */ ID3v24FieldKey MOVEMENT;
    public static final /* enum */ ID3v24FieldKey MOVEMENT_NO;
    public static final /* enum */ ID3v24FieldKey MOVEMENT_TOTAL;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_ARTISTID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_DISC_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_ORIGINAL_RELEASEID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASEARTISTID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASEID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASE_COUNTRY;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASE_GROUP_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASE_STATUS;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASE_TRACK_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_RELEASE_TYPE;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_TRACK_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_COMPOSITION_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL1_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL2_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL3_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL4_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL5_ID;
    public static final /* enum */ ID3v24FieldKey MUSICBRAINZ_WORK_PART_LEVEL6_ID;
    public static final /* enum */ ID3v24FieldKey MUSICIP_ID;
    public static final /* enum */ ID3v24FieldKey OCCASION;
    public static final /* enum */ ID3v24FieldKey OPUS;
    public static final /* enum */ ID3v24FieldKey ORCHESTRA;
    public static final /* enum */ ID3v24FieldKey ORCHESTRA_SORT;
    public static final /* enum */ ID3v24FieldKey ORIGINAL_ALBUM;
    public static final /* enum */ ID3v24FieldKey ORIGINAL_ARTIST;
    public static final /* enum */ ID3v24FieldKey ORIGINAL_LYRICIST;
    public static final /* enum */ ID3v24FieldKey ORIGINAL_YEAR;
    public static final /* enum */ ID3v24FieldKey PART;
    public static final /* enum */ ID3v24FieldKey PART_NUMBER;
    public static final /* enum */ ID3v24FieldKey PART_TYPE;
    public static final /* enum */ ID3v24FieldKey PERFORMER;
    public static final /* enum */ ID3v24FieldKey PERFORMER_NAME;
    public static final /* enum */ ID3v24FieldKey PERFORMER_NAME_SORT;
    public static final /* enum */ ID3v24FieldKey PERIOD;
    public static final /* enum */ ID3v24FieldKey PRODUCER;
    public static final /* enum */ ID3v24FieldKey QUALITY;
    public static final /* enum */ ID3v24FieldKey RANKING;
    public static final /* enum */ ID3v24FieldKey RATING;
    public static final /* enum */ ID3v24FieldKey RECORD_LABEL;
    public static final /* enum */ ID3v24FieldKey REMIXER;
    public static final /* enum */ ID3v24FieldKey SCRIPT;
    public static final /* enum */ ID3v24FieldKey SINGLE_DISC_TRACK_NO;
    public static final /* enum */ ID3v24FieldKey SUBTITLE;
    public static final /* enum */ ID3v24FieldKey TAGS;
    public static final /* enum */ ID3v24FieldKey TEMPO;
    public static final /* enum */ ID3v24FieldKey TIMBRE;
    public static final /* enum */ ID3v24FieldKey TITLE;
    public static final /* enum */ ID3v24FieldKey TITLE_MOVEMENT;
    public static final /* enum */ ID3v24FieldKey TITLE_SORT;
    public static final /* enum */ ID3v24FieldKey TONALITY;
    public static final /* enum */ ID3v24FieldKey TRACK;
    public static final /* enum */ ID3v24FieldKey TRACK_TOTAL;
    public static final /* enum */ ID3v24FieldKey URL_DISCOGS_ARTIST_SITE;
    public static final /* enum */ ID3v24FieldKey URL_DISCOGS_RELEASE_SITE;
    public static final /* enum */ ID3v24FieldKey URL_LYRICS_SITE;
    public static final /* enum */ ID3v24FieldKey URL_OFFICIAL_ARTIST_SITE;
    public static final /* enum */ ID3v24FieldKey URL_OFFICIAL_RELEASE_SITE;
    public static final /* enum */ ID3v24FieldKey URL_WIKIPEDIA_ARTIST_SITE;
    public static final /* enum */ ID3v24FieldKey URL_WIKIPEDIA_RELEASE_SITE;
    public static final /* enum */ ID3v24FieldKey WORK;
    public static final /* enum */ ID3v24FieldKey WORK_COMPOSITION;
    public static final /* enum */ ID3v24FieldKey WORK_PARTOF_LEVEL3_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL1;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL1_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL2;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL2_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL3;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL4;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL4_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL5;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL5_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL6;
    public static final /* enum */ ID3v24FieldKey WORK_PART_LEVEL6_TYPE;
    public static final /* enum */ ID3v24FieldKey WORK_TYPE;
    public static final /* enum */ ID3v24FieldKey YEAR;
    private String fieldName;
    private Id3FieldType fieldType;
    private String frameId;
    private String subId;

    static {
        ID3v24FieldKey iD3v24FieldKey;
        ID3v24FieldKey iD3v24FieldKey2;
        ID3v24FieldKey iD3v24FieldKey3;
        ID3v24FieldKey iD3v24FieldKey4;
        ID3v24FieldKey iD3v24FieldKey5;
        ID3v24FieldKey iD3v24FieldKey6;
        ID3v24FieldKey iD3v24FieldKey7;
        ID3v24FieldKey iD3v24FieldKey8;
        ID3v24FieldKey iD3v24FieldKey9;
        ID3v24FieldKey iD3v24FieldKey10;
        ID3v24FieldKey iD3v24FieldKey11;
        ID3v24FieldKey iD3v24FieldKey12;
        ID3v24FieldKey iD3v24FieldKey13;
        ID3v24FieldKey iD3v24FieldKey14;
        ID3v24FieldKey iD3v24FieldKey15;
        ID3v24FieldKey iD3v24FieldKey16;
        ID3v24FieldKey iD3v24FieldKey17;
        ID3v24FieldKey iD3v24FieldKey18;
        ID3v24FieldKey iD3v24FieldKey19;
        ID3v24FieldKey iD3v24FieldKey20;
        ID3v24FieldKey iD3v24FieldKey21;
        ID3v24FieldKey iD3v24FieldKey22;
        ID3v24FieldKey iD3v24FieldKey23;
        ID3v24FieldKey iD3v24FieldKey24;
        ID3v24FieldKey iD3v24FieldKey25;
        ID3v24FieldKey iD3v24FieldKey26;
        ID3v24FieldKey iD3v24FieldKey27;
        ID3v24FieldKey iD3v24FieldKey28;
        ID3v24FieldKey iD3v24FieldKey29;
        ID3v24FieldKey iD3v24FieldKey30;
        ID3v24FieldKey iD3v24FieldKey31;
        ID3v24FieldKey iD3v24FieldKey32;
        ID3v24FieldKey iD3v24FieldKey33;
        ID3v24FieldKey iD3v24FieldKey34;
        ID3v24FieldKey iD3v24FieldKey35;
        ID3v24FieldKey iD3v24FieldKey36;
        ID3v24FieldKey iD3v24FieldKey37;
        ID3v24FieldKey iD3v24FieldKey38;
        ID3v24FieldKey iD3v24FieldKey39;
        ID3v24FieldKey iD3v24FieldKey40;
        ID3v24FieldKey iD3v24FieldKey41;
        ID3v24FieldKey iD3v24FieldKey42;
        ID3v24FieldKey iD3v24FieldKey43;
        ID3v24FieldKey iD3v24FieldKey44;
        ID3v24FieldKey iD3v24FieldKey45;
        ID3v24FieldKey iD3v24FieldKey46;
        ID3v24FieldKey iD3v24FieldKey47;
        ID3v24FieldKey iD3v24FieldKey48;
        ID3v24FieldKey iD3v24FieldKey49;
        ID3v24FieldKey iD3v24FieldKey50;
        ID3v24FieldKey iD3v24FieldKey51;
        ID3v24FieldKey iD3v24FieldKey52;
        ID3v24FieldKey iD3v24FieldKey53;
        ID3v24FieldKey iD3v24FieldKey54;
        ID3v24FieldKey iD3v24FieldKey55;
        ID3v24FieldKey iD3v24FieldKey56;
        ID3v24FieldKey iD3v24FieldKey57;
        ID3v24FieldKey iD3v24FieldKey58;
        ID3v24FieldKey iD3v24FieldKey59;
        ID3v24FieldKey iD3v24FieldKey60;
        ID3v24FieldKey iD3v24FieldKey61;
        ID3v24FieldKey iD3v24FieldKey62;
        ID3v24FieldKey iD3v24FieldKey63;
        ID3v24FieldKey iD3v24FieldKey64;
        ID3v24FieldKey iD3v24FieldKey65;
        ID3v24FieldKey iD3v24FieldKey66;
        ID3v24FieldKey iD3v24FieldKey67;
        ID3v24FieldKey iD3v24FieldKey68;
        ID3v24FieldKey iD3v24FieldKey69;
        ID3v24FieldKey iD3v24FieldKey70;
        ID3v24FieldKey iD3v24FieldKey71;
        ID3v24FieldKey iD3v24FieldKey72;
        ID3v24FieldKey iD3v24FieldKey73;
        ID3v24FieldKey iD3v24FieldKey74;
        ID3v24FieldKey iD3v24FieldKey75;
        ID3v24FieldKey iD3v24FieldKey76;
        ID3v24FieldKey iD3v24FieldKey77;
        ID3v24FieldKey iD3v24FieldKey78;
        ID3v24FieldKey iD3v24FieldKey79;
        ID3v24FieldKey iD3v24FieldKey80;
        ID3v24FieldKey iD3v24FieldKey81;
        ID3v24FieldKey iD3v24FieldKey82;
        ID3v24FieldKey iD3v24FieldKey83;
        ID3v24FieldKey iD3v24FieldKey84;
        ID3v24FieldKey iD3v24FieldKey85;
        ID3v24FieldKey iD3v24FieldKey86;
        ID3v24FieldKey iD3v24FieldKey87;
        ID3v24FieldKey iD3v24FieldKey88;
        ID3v24FieldKey iD3v24FieldKey89;
        ID3v24FieldKey iD3v24FieldKey90;
        ID3v24FieldKey iD3v24FieldKey91;
        ID3v24FieldKey iD3v24FieldKey92;
        ID3v24FieldKey iD3v24FieldKey93;
        ID3v24FieldKey iD3v24FieldKey94;
        ID3v24FieldKey iD3v24FieldKey95;
        ID3v24FieldKey iD3v24FieldKey96;
        ID3v24FieldKey iD3v24FieldKey97;
        ID3v24FieldKey iD3v24FieldKey98;
        ID3v24FieldKey iD3v24FieldKey99;
        ID3v24FieldKey iD3v24FieldKey100;
        ID3v24FieldKey iD3v24FieldKey101;
        ID3v24FieldKey iD3v24FieldKey102;
        ID3v24FieldKey iD3v24FieldKey103;
        ID3v24FieldKey iD3v24FieldKey104;
        ID3v24FieldKey iD3v24FieldKey105;
        Id3FieldType id3FieldType = Id3FieldType.TEXT;
        ACOUSTID_FINGERPRINT = iD3v24FieldKey55 = new ID3v24FieldKey("TXXX", "Acoustid Fingerprint", id3FieldType);
        ACOUSTID_ID = iD3v24FieldKey90 = new ID3v24FieldKey("TXXX", "Acoustid Id", id3FieldType);
        ALBUM = new ID3v24FieldKey("TALB", id3FieldType);
        ALBUM_ARTIST = new ID3v24FieldKey("TPE2", id3FieldType);
        ALBUM_ARTIST_SORT = new ID3v24FieldKey("TSO2", id3FieldType);
        ALBUM_ARTISTS = iD3v24FieldKey105 = new ID3v24FieldKey("TXXX", "ALBUM_ARTISTS", id3FieldType);
        ALBUM_ARTISTS_SORT = iD3v24FieldKey63 = new ID3v24FieldKey("TXXX", "ALBUM_ARTISTS_SORT", id3FieldType);
        ALBUM_SORT = new ID3v24FieldKey("TSOA", id3FieldType);
        AMAZON_ID = iD3v24FieldKey87 = new ID3v24FieldKey("TXXX", "ASIN", id3FieldType);
        ARRANGER = iD3v24FieldKey26 = new ID3v24FieldKey("TIPL", StandardIPLSKey.ARRANGER.getKey(), id3FieldType);
        ARRANGER_SORT = iD3v24FieldKey58 = new ID3v24FieldKey("TXXX", "ARRANGER_SORT", id3FieldType);
        ARTIST = new ID3v24FieldKey("TPE1", id3FieldType);
        ARTISTS = iD3v24FieldKey34 = new ID3v24FieldKey("TXXX", "ARTISTS", id3FieldType);
        ARTISTS_SORT = iD3v24FieldKey47 = new ID3v24FieldKey("TXXX", "ARTISTS_SORT", id3FieldType);
        ARTIST_SORT = new ID3v24FieldKey("TSOP", id3FieldType);
        BARCODE = iD3v24FieldKey37 = new ID3v24FieldKey("TXXX", "BARCODE", id3FieldType);
        BPM = new ID3v24FieldKey("TBPM", id3FieldType);
        CATALOG_NO = iD3v24FieldKey23 = new ID3v24FieldKey("TXXX", "CATALOGNUMBER", id3FieldType);
        CHOIR = iD3v24FieldKey93 = new ID3v24FieldKey("TXXX", "CHOIR", id3FieldType);
        CHOIR_SORT = iD3v24FieldKey48 = new ID3v24FieldKey("TXXX", "CHOIR_SORT", id3FieldType);
        CLASSICAL_CATALOG = iD3v24FieldKey61 = new ID3v24FieldKey("TXXX", "CLASSICAL_CATALOG", id3FieldType);
        CLASSICAL_NICKNAME = iD3v24FieldKey73 = new ID3v24FieldKey("TXXX", "CLASSICAL_NICKNAME", id3FieldType);
        COMMENT = new ID3v24FieldKey("COMM", id3FieldType);
        COMPOSER = new ID3v24FieldKey("TCOM", id3FieldType);
        COMPOSER_SORT = new ID3v24FieldKey("TSOC", id3FieldType);
        CONDUCTOR = new ID3v24FieldKey("TPE3", id3FieldType);
        CONDUCTOR_SORT = iD3v24FieldKey28 = new ID3v24FieldKey("TXXX", "CONDUCTOR_SORT", id3FieldType);
        COPYRIGHT = new ID3v24FieldKey("TCOP", id3FieldType);
        COUNTRY = iD3v24FieldKey9 = new ID3v24FieldKey("TXXX", "Country", id3FieldType);
        COVER_ART = new ID3v24FieldKey("APIC", Id3FieldType.BINARY);
        CUSTOM1 = iD3v24FieldKey19 = new ID3v24FieldKey("COMM", "Songs-DB_Custom1", id3FieldType);
        CUSTOM2 = iD3v24FieldKey33 = new ID3v24FieldKey("COMM", "Songs-DB_Custom2", id3FieldType);
        CUSTOM3 = iD3v24FieldKey62 = new ID3v24FieldKey("COMM", "Songs-DB_Custom3", id3FieldType);
        CUSTOM4 = iD3v24FieldKey52 = new ID3v24FieldKey("COMM", "Songs-DB_Custom4", id3FieldType);
        CUSTOM5 = iD3v24FieldKey85 = new ID3v24FieldKey("COMM", "Songs-DB_Custom5", id3FieldType);
        DISC_NO = new ID3v24FieldKey("TPOS", id3FieldType);
        DISC_SUBTITLE = new ID3v24FieldKey("TSST", id3FieldType);
        DISC_TOTAL = new ID3v24FieldKey("TPOS", id3FieldType);
        DJMIXER = iD3v24FieldKey13 = new ID3v24FieldKey("TIPL", StandardIPLSKey.DJMIXER.getKey(), id3FieldType);
        ENCODER = new ID3v24FieldKey("TENC", id3FieldType);
        ENGINEER = iD3v24FieldKey6 = new ID3v24FieldKey("TIPL", StandardIPLSKey.ENGINEER.getKey(), id3FieldType);
        ENSEMBLE = iD3v24FieldKey89 = new ID3v24FieldKey("TXXX", "ENSEMBLE", id3FieldType);
        ENSEMBLE_SORT = iD3v24FieldKey81 = new ID3v24FieldKey("TXXX", "ENSEMBLE_SORT", id3FieldType);
        FBPM = iD3v24FieldKey53 = new ID3v24FieldKey("TXXX", "FBPM", id3FieldType);
        GENRE = new ID3v24FieldKey("TCON", id3FieldType);
        GROUP = iD3v24FieldKey101 = new ID3v24FieldKey("TXXX", "GROUP", id3FieldType);
        Id3FieldType id3FieldType2 = Id3FieldType.TEXT;
        GROUPING = new ID3v24FieldKey("TIT1", id3FieldType2);
        INVOLVED_PERSON = new ID3v24FieldKey("TIPL", id3FieldType2);
        INSTRUMENT = iD3v24FieldKey11 = new ID3v24FieldKey("TXXX", "INSTRUMENT", id3FieldType2);
        ISRC = new ID3v24FieldKey("TSRC", id3FieldType2);
        IS_CLASSICAL = iD3v24FieldKey21 = new ID3v24FieldKey("TXXX", "IS_CLASSICAL", id3FieldType2);
        IS_COMPILATION = new ID3v24FieldKey("TCMP", id3FieldType2);
        IS_SOUNDTRACK = iD3v24FieldKey43 = new ID3v24FieldKey("TXXX", "IS_SOUNDTRACK", id3FieldType2);
        ITUNES_GROUPING = new ID3v24FieldKey("GRP1", id3FieldType2);
        KEY = new ID3v24FieldKey("TKEY", id3FieldType2);
        LANGUAGE = new ID3v24FieldKey("TLAN", id3FieldType2);
        LYRICIST = new ID3v24FieldKey("TEXT", id3FieldType2);
        LYRICS = new ID3v24FieldKey("USLT", id3FieldType2);
        MEDIA = new ID3v24FieldKey("TMED", id3FieldType2);
        MIXER = iD3v24FieldKey57 = new ID3v24FieldKey("TIPL", StandardIPLSKey.MIXER.getKey(), id3FieldType2);
        MOOD = new ID3v24FieldKey("TMOO", id3FieldType2);
        MOOD_ACOUSTIC = iD3v24FieldKey72 = new ID3v24FieldKey("TXXX", "MOOD_ACOUSTIC", id3FieldType2);
        MOOD_AGGRESSIVE = iD3v24FieldKey39 = new ID3v24FieldKey("TXXX", "MOOD_AGGRESSIVE", id3FieldType2);
        MOOD_AROUSAL = iD3v24FieldKey103 = new ID3v24FieldKey("TXXX", "MOOD_AROUSAL", id3FieldType2);
        MOOD_DANCEABILITY = iD3v24FieldKey16 = new ID3v24FieldKey("TXXX", "MOOD_DANCEABILITY", id3FieldType2);
        MOOD_ELECTRONIC = iD3v24FieldKey35 = new ID3v24FieldKey("TXXX", "MOOD_ELECTRONIC", id3FieldType2);
        MOOD_HAPPY = iD3v24FieldKey95 = new ID3v24FieldKey("TXXX", "MOOD_HAPPY", id3FieldType2);
        MOOD_INSTRUMENTAL = iD3v24FieldKey40 = new ID3v24FieldKey("TXXX", "MOOD_INSTRUMENTAL", id3FieldType2);
        MOOD_PARTY = iD3v24FieldKey86 = new ID3v24FieldKey("TXXX", "MOOD_PARTY", id3FieldType2);
        MOOD_RELAXED = iD3v24FieldKey18 = new ID3v24FieldKey("TXXX", "MOOD_RELAXED", id3FieldType2);
        MOOD_SAD = iD3v24FieldKey8 = new ID3v24FieldKey("TXXX", "MOOD_SAD", id3FieldType2);
        MOOD_VALENCE = iD3v24FieldKey84 = new ID3v24FieldKey("TXXX", "MOOD_VALENCE", id3FieldType2);
        MOVEMENT = new ID3v24FieldKey("MVNM", id3FieldType2);
        MOVEMENT_NO = new ID3v24FieldKey("MVIN", id3FieldType2);
        MOVEMENT_TOTAL = new ID3v24FieldKey("MVIN", id3FieldType2);
        MUSICBRAINZ_ARTISTID = iD3v24FieldKey65 = new ID3v24FieldKey("TXXX", "MusicBrainz Artist Id", id3FieldType2);
        MUSICBRAINZ_DISC_ID = iD3v24FieldKey80 = new ID3v24FieldKey("TXXX", "MusicBrainz Disc Id", id3FieldType2);
        MUSICBRAINZ_ORIGINAL_RELEASEID = iD3v24FieldKey88 = new ID3v24FieldKey("TXXX", "MusicBrainz Original Album Id", id3FieldType2);
        MUSICBRAINZ_RELEASEARTISTID = iD3v24FieldKey41 = new ID3v24FieldKey("TXXX", "MusicBrainz Album Artist Id", id3FieldType2);
        MUSICBRAINZ_RELEASEID = iD3v24FieldKey2 = new ID3v24FieldKey("TXXX", "MusicBrainz Album Id", id3FieldType2);
        MUSICBRAINZ_RELEASE_COUNTRY = iD3v24FieldKey32 = new ID3v24FieldKey("TXXX", "MusicBrainz Album Release Country", id3FieldType2);
        MUSICBRAINZ_RELEASE_GROUP_ID = iD3v24FieldKey66 = new ID3v24FieldKey("TXXX", "MusicBrainz Release Group Id", id3FieldType2);
        MUSICBRAINZ_RELEASE_STATUS = iD3v24FieldKey54 = new ID3v24FieldKey("TXXX", "MusicBrainz Album Status", id3FieldType2);
        MUSICBRAINZ_RELEASE_TRACK_ID = iD3v24FieldKey36 = new ID3v24FieldKey("TXXX", "MusicBrainz Release Track Id", id3FieldType2);
        MUSICBRAINZ_RELEASE_TYPE = iD3v24FieldKey22 = new ID3v24FieldKey("TXXX", "MusicBrainz Album Type", id3FieldType2);
        MUSICBRAINZ_TRACK_ID = iD3v24FieldKey4 = new ID3v24FieldKey("UFID", "http://musicbrainz.org", id3FieldType2);
        MUSICBRAINZ_WORK_COMPOSITION_ID = iD3v24FieldKey42 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_COMPOSITION_ID", id3FieldType2);
        MUSICBRAINZ_WORK_ID = iD3v24FieldKey76 = new ID3v24FieldKey("TXXX", "MusicBrainz Work Id", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL1_ID = iD3v24FieldKey64 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL1_ID", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL2_ID = iD3v24FieldKey51 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL2_ID", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL3_ID = iD3v24FieldKey98 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL3_ID", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL4_ID = iD3v24FieldKey3 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL4_ID", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL5_ID = iD3v24FieldKey12 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL5_ID", id3FieldType2);
        MUSICBRAINZ_WORK_PART_LEVEL6_ID = iD3v24FieldKey91 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL6_ID", id3FieldType2);
        MUSICIP_ID = iD3v24FieldKey45 = new ID3v24FieldKey("TXXX", "MusicIP PUID", id3FieldType2);
        Id3FieldType id3FieldType3 = Id3FieldType.TEXT;
        OCCASION = iD3v24FieldKey83 = new ID3v24FieldKey("COMM", "Songs-DB_Occasion", id3FieldType3);
        OPUS = iD3v24FieldKey46 = new ID3v24FieldKey("TXXX", "OPUS", id3FieldType3);
        ORCHESTRA = iD3v24FieldKey7 = new ID3v24FieldKey("TXXX", "ORCHESTRA", id3FieldType3);
        ORCHESTRA_SORT = iD3v24FieldKey24 = new ID3v24FieldKey("TXXX", "ORCHESTRA_SORT", id3FieldType3);
        ORIGINAL_ALBUM = new ID3v24FieldKey("TOAL", id3FieldType3);
        ORIGINAL_ARTIST = new ID3v24FieldKey("TOPE", id3FieldType3);
        ORIGINAL_LYRICIST = new ID3v24FieldKey("TOLY", id3FieldType3);
        ORIGINAL_YEAR = new ID3v24FieldKey("TDOR", id3FieldType3);
        PART = iD3v24FieldKey77 = new ID3v24FieldKey("TXXX", "PART", id3FieldType3);
        PART_NUMBER = iD3v24FieldKey60 = new ID3v24FieldKey("TXXX", "PARTNUMBER", id3FieldType3);
        PART_TYPE = iD3v24FieldKey50 = new ID3v24FieldKey("TXXX", "PART_TYPE", id3FieldType3);
        PERFORMER = new ID3v24FieldKey("TMCL", id3FieldType3);
        PERFORMER_NAME = iD3v24FieldKey15 = new ID3v24FieldKey("TXXX", "PERFORMER_NAME", id3FieldType3);
        PERFORMER_NAME_SORT = iD3v24FieldKey5 = new ID3v24FieldKey("TXXX", "PERFORMER_NAME_SORT", id3FieldType3);
        PERIOD = iD3v24FieldKey44 = new ID3v24FieldKey("TXXX", "PERIOD", id3FieldType3);
        PRODUCER = iD3v24FieldKey94 = new ID3v24FieldKey("TIPL", StandardIPLSKey.PRODUCER.getKey(), id3FieldType3);
        QUALITY = iD3v24FieldKey82 = new ID3v24FieldKey("COMM", "Songs-DB_Preference", id3FieldType3);
        RANKING = iD3v24FieldKey38 = new ID3v24FieldKey("TXXX", "RANKING", id3FieldType3);
        RATING = new ID3v24FieldKey("POPM", id3FieldType3);
        RECORD_LABEL = new ID3v24FieldKey("TPUB", id3FieldType3);
        REMIXER = new ID3v24FieldKey("TPE4", id3FieldType3);
        SCRIPT = iD3v24FieldKey99 = new ID3v24FieldKey("TXXX", "Script", id3FieldType3);
        SINGLE_DISC_TRACK_NO = iD3v24FieldKey49 = new ID3v24FieldKey("TXXX", "SINGLE_DISC_TRACK_NO", id3FieldType3);
        SUBTITLE = new ID3v24FieldKey("TIT3", id3FieldType3);
        TAGS = iD3v24FieldKey92 = new ID3v24FieldKey("TXXX", "TAGS", id3FieldType3);
        TEMPO = iD3v24FieldKey79 = new ID3v24FieldKey("COMM", "Songs-DB_Tempo", id3FieldType3);
        TIMBRE = iD3v24FieldKey56 = new ID3v24FieldKey("TXXX", "TIMBRE_BRIGHTNESS", id3FieldType3);
        TITLE = new ID3v24FieldKey("TIT2", id3FieldType3);
        TITLE_MOVEMENT = iD3v24FieldKey97 = new ID3v24FieldKey("TXXX", "TITLE_MOVEMENT", id3FieldType3);
        MUSICBRAINZ_WORK = iD3v24FieldKey20 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK", id3FieldType3);
        TITLE_SORT = new ID3v24FieldKey("TSOT", id3FieldType3);
        TONALITY = iD3v24FieldKey10 = new ID3v24FieldKey("TXXX", "TONALITY", id3FieldType3);
        TRACK = new ID3v24FieldKey("TRCK", id3FieldType3);
        TRACK_TOTAL = new ID3v24FieldKey("TRCK", id3FieldType3);
        URL_DISCOGS_ARTIST_SITE = iD3v24FieldKey102 = new ID3v24FieldKey("WXXX", "DISCOGS_ARTIST", id3FieldType3);
        URL_DISCOGS_RELEASE_SITE = iD3v24FieldKey29 = new ID3v24FieldKey("WXXX", "DISCOGS_RELEASE", id3FieldType3);
        URL_LYRICS_SITE = iD3v24FieldKey75 = new ID3v24FieldKey("WXXX", "LYRICS_SITE", id3FieldType3);
        URL_OFFICIAL_ARTIST_SITE = new ID3v24FieldKey("WOAR", id3FieldType3);
        URL_OFFICIAL_RELEASE_SITE = iD3v24FieldKey68 = new ID3v24FieldKey("WXXX", "OFFICIAL_RELEASE", id3FieldType3);
        URL_WIKIPEDIA_ARTIST_SITE = iD3v24FieldKey31 = new ID3v24FieldKey("WXXX", "WIKIPEDIA_ARTIST", id3FieldType3);
        URL_WIKIPEDIA_RELEASE_SITE = iD3v24FieldKey100 = new ID3v24FieldKey("WXXX", "WIKIPEDIA_RELEASE", id3FieldType3);
        WORK = iD3v24FieldKey17 = new ID3v24FieldKey("TXXX", "WORK", id3FieldType3);
        WORK_COMPOSITION = iD3v24FieldKey30 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_COMPOSITION", id3FieldType3);
        WORK_PARTOF_LEVEL3_TYPE = iD3v24FieldKey104 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL3_TYPE", id3FieldType3);
        WORK_PART_LEVEL1 = iD3v24FieldKey59 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL1", id3FieldType3);
        WORK_PART_LEVEL1_TYPE = iD3v24FieldKey78 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL1_TYPE", id3FieldType3);
        WORK_PART_LEVEL2 = iD3v24FieldKey96 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL2", id3FieldType3);
        WORK_PART_LEVEL2_TYPE = iD3v24FieldKey = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL2_TYPE", id3FieldType3);
        WORK_PART_LEVEL3 = iD3v24FieldKey74 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL3", id3FieldType3);
        Id3FieldType id3FieldType4 = Id3FieldType.TEXT;
        WORK_PART_LEVEL4 = iD3v24FieldKey14 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL4", id3FieldType4);
        WORK_PART_LEVEL4_TYPE = iD3v24FieldKey71 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL4_TYPE", id3FieldType4);
        WORK_PART_LEVEL5 = iD3v24FieldKey70 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL5", id3FieldType4);
        WORK_PART_LEVEL5_TYPE = iD3v24FieldKey25 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL5_TYPE", id3FieldType4);
        WORK_PART_LEVEL6 = iD3v24FieldKey27 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL6", id3FieldType4);
        WORK_PART_LEVEL6_TYPE = iD3v24FieldKey69 = new ID3v24FieldKey("TXXX", "MUSICBRAINZ_WORK_PART_LEVEL6_TYPE", id3FieldType4);
        WORK_TYPE = iD3v24FieldKey67 = new ID3v24FieldKey("TXXX", "WORK_TYPE", id3FieldType4);
        YEAR = new ID3v24FieldKey("TDRC", id3FieldType4);
        ID3v24FieldKey[] arriD3v24FieldKey = new ID3v24FieldKey[]{ACOUSTID_FINGERPRINT, ACOUSTID_ID, ALBUM, ALBUM_ARTIST, ALBUM_ARTIST_SORT, ALBUM_ARTISTS, ALBUM_ARTISTS_SORT, ALBUM_SORT, AMAZON_ID, ARRANGER, ARRANGER_SORT, ARTIST, ARTISTS, ARTISTS_SORT, ARTIST_SORT, BARCODE, BPM, CATALOG_NO, CHOIR, CHOIR_SORT, CLASSICAL_CATALOG, CLASSICAL_NICKNAME, COMMENT, COMPOSER, COMPOSER_SORT, CONDUCTOR, CONDUCTOR_SORT, COPYRIGHT, COUNTRY, COVER_ART, CUSTOM1, CUSTOM2, CUSTOM3, CUSTOM4, CUSTOM5, DISC_NO, DISC_SUBTITLE, DISC_TOTAL, DJMIXER, ENCODER, ENGINEER, ENSEMBLE, ENSEMBLE_SORT, FBPM, GENRE, GROUP, GROUPING, INVOLVED_PERSON, INSTRUMENT, ISRC, IS_CLASSICAL, IS_COMPILATION, IS_SOUNDTRACK, ITUNES_GROUPING, KEY, LANGUAGE, LYRICIST, LYRICS, MEDIA, MIXER, MOOD, MOOD_ACOUSTIC, MOOD_AGGRESSIVE, MOOD_AROUSAL, MOOD_DANCEABILITY, MOOD_ELECTRONIC, MOOD_HAPPY, MOOD_INSTRUMENTAL, MOOD_PARTY, MOOD_RELAXED, MOOD_SAD, MOOD_VALENCE, MOVEMENT, MOVEMENT_NO, MOVEMENT_TOTAL, MUSICBRAINZ_ARTISTID, MUSICBRAINZ_DISC_ID, MUSICBRAINZ_ORIGINAL_RELEASEID, MUSICBRAINZ_RELEASEARTISTID, MUSICBRAINZ_RELEASEID, MUSICBRAINZ_RELEASE_COUNTRY, MUSICBRAINZ_RELEASE_GROUP_ID, MUSICBRAINZ_RELEASE_STATUS, MUSICBRAINZ_RELEASE_TRACK_ID, MUSICBRAINZ_RELEASE_TYPE, MUSICBRAINZ_TRACK_ID, MUSICBRAINZ_WORK_COMPOSITION_ID, MUSICBRAINZ_WORK_ID, MUSICBRAINZ_WORK_PART_LEVEL1_ID, MUSICBRAINZ_WORK_PART_LEVEL2_ID, MUSICBRAINZ_WORK_PART_LEVEL3_ID, MUSICBRAINZ_WORK_PART_LEVEL4_ID, MUSICBRAINZ_WORK_PART_LEVEL5_ID, MUSICBRAINZ_WORK_PART_LEVEL6_ID, MUSICIP_ID, OCCASION, OPUS, ORCHESTRA, ORCHESTRA_SORT, ORIGINAL_ALBUM, ORIGINAL_ARTIST, ORIGINAL_LYRICIST, ORIGINAL_YEAR, PART, PART_NUMBER, PART_TYPE, PERFORMER, PERFORMER_NAME, PERFORMER_NAME_SORT, PERIOD, PRODUCER, QUALITY, RANKING, RATING, RECORD_LABEL, REMIXER, SCRIPT, SINGLE_DISC_TRACK_NO, SUBTITLE, TAGS, TEMPO, TIMBRE, TITLE, TITLE_MOVEMENT, MUSICBRAINZ_WORK, TITLE_SORT, TONALITY, TRACK, TRACK_TOTAL, URL_DISCOGS_ARTIST_SITE, URL_DISCOGS_RELEASE_SITE, URL_LYRICS_SITE, URL_OFFICIAL_ARTIST_SITE, URL_OFFICIAL_RELEASE_SITE, URL_WIKIPEDIA_ARTIST_SITE, URL_WIKIPEDIA_RELEASE_SITE, WORK, WORK_COMPOSITION, WORK_PARTOF_LEVEL3_TYPE, WORK_PART_LEVEL1, WORK_PART_LEVEL1_TYPE, WORK_PART_LEVEL2, WORK_PART_LEVEL2_TYPE, WORK_PART_LEVEL3, WORK_PART_LEVEL4, WORK_PART_LEVEL4_TYPE, WORK_PART_LEVEL5, WORK_PART_LEVEL5_TYPE, WORK_PART_LEVEL6, WORK_PART_LEVEL6_TYPE, WORK_TYPE, YEAR};
        $VALUES = arriD3v24FieldKey;
    }

    private ID3v24FieldKey(String string3, String string4, Id3FieldType id3FieldType) {
        this.frameId = string3;
        this.subId = string4;
        this.fieldType = id3FieldType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(":");
        stringBuilder.append(string4);
        this.fieldName = stringBuilder.toString();
    }

    private ID3v24FieldKey(String string3, Id3FieldType id3FieldType) {
        this.frameId = string3;
        this.fieldType = id3FieldType;
        this.fieldName = string3;
    }

    public static ID3v24FieldKey valueOf(String string2) {
        return (ID3v24FieldKey)Enum.valueOf(ID3v24FieldKey.class, (String)string2);
    }

    public static ID3v24FieldKey[] values() {
        return (ID3v24FieldKey[])$VALUES.clone();
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Id3FieldType getFieldType() {
        return this.fieldType;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public String getSubId() {
        return this.subId;
    }
}

