/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.tag.asf;

import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.audio.asf.data.ContainerType;

public final class AsfFieldKey
extends Enum<AsfFieldKey> {
    private static final /* synthetic */ AsfFieldKey[] $VALUES;
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final /* enum */ AsfFieldKey ACOUSTID_FINGERPRINT;
    public static final /* enum */ AsfFieldKey ACOUSTID_FINGERPRINT_OLD;
    public static final /* enum */ AsfFieldKey ACOUSTID_ID;
    public static final /* enum */ AsfFieldKey ALBUM;
    public static final /* enum */ AsfFieldKey ALBUM_ARTIST;
    public static final /* enum */ AsfFieldKey ALBUM_ARTISTS;
    public static final /* enum */ AsfFieldKey ALBUM_ARTISTS_SORT;
    public static final /* enum */ AsfFieldKey ALBUM_ARTIST_SORT;
    public static final /* enum */ AsfFieldKey ALBUM_SORT;
    public static final /* enum */ AsfFieldKey AMAZON_ID;
    public static final /* enum */ AsfFieldKey ARRANGER;
    public static final /* enum */ AsfFieldKey ARRANGER_SORT;
    public static final /* enum */ AsfFieldKey ARTISTS;
    public static final /* enum */ AsfFieldKey ARTISTS_SORT;
    public static final /* enum */ AsfFieldKey ARTIST_SORT;
    public static final /* enum */ AsfFieldKey AUTHOR;
    public static final /* enum */ AsfFieldKey BANNER_IMAGE;
    public static final /* enum */ AsfFieldKey BANNER_IMAGE_TYPE;
    public static final /* enum */ AsfFieldKey BANNER_IMAGE_URL;
    public static final /* enum */ AsfFieldKey BARCODE;
    public static final /* enum */ AsfFieldKey BPM;
    public static final /* enum */ AsfFieldKey CATALOG_NO;
    public static final /* enum */ AsfFieldKey CATEGORY;
    public static final /* enum */ AsfFieldKey CHOIR;
    public static final /* enum */ AsfFieldKey CHOIR_SORT;
    public static final /* enum */ AsfFieldKey CLASSICAL_CATALOG;
    public static final /* enum */ AsfFieldKey CLASSICAL_NICKNAME;
    public static final /* enum */ AsfFieldKey COMPOSER;
    public static final /* enum */ AsfFieldKey COMPOSER_SORT;
    public static final /* enum */ AsfFieldKey CONDUCTOR;
    public static final /* enum */ AsfFieldKey CONDUCTOR_SORT;
    public static final /* enum */ AsfFieldKey COPYRIGHT;
    public static final /* enum */ AsfFieldKey COPYRIGHT_URL;
    public static final /* enum */ AsfFieldKey COUNTRY;
    public static final /* enum */ AsfFieldKey COVER_ART;
    public static final /* enum */ AsfFieldKey COVER_ART_URL;
    public static final /* enum */ AsfFieldKey CUSTOM;
    public static final /* enum */ AsfFieldKey CUSTOM1;
    public static final /* enum */ AsfFieldKey CUSTOM2;
    public static final /* enum */ AsfFieldKey CUSTOM3;
    public static final /* enum */ AsfFieldKey CUSTOM4;
    public static final /* enum */ AsfFieldKey CUSTOM5;
    public static final /* enum */ AsfFieldKey DESCRIPTION;
    public static final /* enum */ AsfFieldKey DIRECTOR;
    public static final /* enum */ AsfFieldKey DISC_NO;
    public static final /* enum */ AsfFieldKey DISC_SUBTITLE;
    public static final /* enum */ AsfFieldKey DISC_TOTAL;
    public static final /* enum */ AsfFieldKey DJMIXER;
    public static final /* enum */ AsfFieldKey ENCODED_BY;
    public static final /* enum */ AsfFieldKey ENCODER;
    public static final /* enum */ AsfFieldKey ENGINEER;
    public static final /* enum */ AsfFieldKey ENSEMBLE;
    public static final /* enum */ AsfFieldKey ENSEMBLE_SORT;
    public static final /* enum */ AsfFieldKey FBPM;
    private static final Map<String, AsfFieldKey> FIELD_ID_MAP;
    public static final /* enum */ AsfFieldKey GENRE;
    public static final /* enum */ AsfFieldKey GENRE_ID;
    public static final /* enum */ AsfFieldKey GROUP;
    public static final /* enum */ AsfFieldKey GROUPING;
    public static final /* enum */ AsfFieldKey INITIAL_KEY;
    public static final /* enum */ AsfFieldKey INSTRUMENT;
    public static final /* enum */ AsfFieldKey INVOLVED_PERSON;
    public static final /* enum */ AsfFieldKey ISRC;
    public static final /* enum */ AsfFieldKey ISVBR;
    public static final /* enum */ AsfFieldKey IS_CLASSICAL;
    public static final /* enum */ AsfFieldKey IS_COMPILATION;
    public static final /* enum */ AsfFieldKey IS_SOUNDTRACK;
    public static final /* enum */ AsfFieldKey LANGUAGE;
    public static final /* enum */ AsfFieldKey LYRICIST;
    public static final /* enum */ AsfFieldKey LYRICS;
    public static final /* enum */ AsfFieldKey LYRICS_SYNCHRONISED;
    public static final /* enum */ AsfFieldKey MEDIA;
    public static final /* enum */ AsfFieldKey MIXER;
    public static final /* enum */ AsfFieldKey MM_RATING;
    public static final /* enum */ AsfFieldKey MOOD;
    public static final /* enum */ AsfFieldKey MOOD_ACOUSTIC;
    public static final /* enum */ AsfFieldKey MOOD_AGGRESSIVE;
    public static final /* enum */ AsfFieldKey MOOD_AROUSAL;
    public static final /* enum */ AsfFieldKey MOOD_DANCEABILITY;
    public static final /* enum */ AsfFieldKey MOOD_ELECTRONIC;
    public static final /* enum */ AsfFieldKey MOOD_HAPPY;
    public static final /* enum */ AsfFieldKey MOOD_INSTRUMENTAL;
    public static final /* enum */ AsfFieldKey MOOD_PARTY;
    public static final /* enum */ AsfFieldKey MOOD_RELAXED;
    public static final /* enum */ AsfFieldKey MOOD_SAD;
    public static final /* enum */ AsfFieldKey MOOD_VALENCE;
    public static final /* enum */ AsfFieldKey MOVEMENT;
    public static final /* enum */ AsfFieldKey MOVEMENT_NO;
    public static final /* enum */ AsfFieldKey MOVEMENT_TOTAL;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_ARTISTID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_DISC_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_ORIGINAL_RELEASEID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASEARTISTID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASEGROUPID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASEID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASETRACKID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASE_COUNTRY;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASE_STATUS;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_RELEASE_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_TRACK_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORKID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_COMPOSITION;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_COMPOSITION_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL1;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL1_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL1_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL2;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL2_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL2_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL3;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL3_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL3_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL4;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL4_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL4_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL5;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL5_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL5_TYPE;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL6;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL6_ID;
    public static final /* enum */ AsfFieldKey MUSICBRAINZ_WORK_PART_LEVEL6_TYPE;
    public static final /* enum */ AsfFieldKey MUSICIP_ID;
    public static final /* enum */ AsfFieldKey OCCASION;
    public static final /* enum */ AsfFieldKey OPUS;
    public static final /* enum */ AsfFieldKey ORCHESTRA;
    public static final /* enum */ AsfFieldKey ORCHESTRA_SORT;
    public static final /* enum */ AsfFieldKey ORIGINAL_ALBUM;
    public static final /* enum */ AsfFieldKey ORIGINAL_ARTIST;
    public static final /* enum */ AsfFieldKey ORIGINAL_LYRICIST;
    public static final /* enum */ AsfFieldKey ORIGINAL_YEAR;
    public static final /* enum */ AsfFieldKey PART;
    public static final /* enum */ AsfFieldKey PART_NUMBER;
    public static final /* enum */ AsfFieldKey PART_TYPE;
    public static final /* enum */ AsfFieldKey PERFORMER;
    public static final /* enum */ AsfFieldKey PERFORMER_NAME;
    public static final /* enum */ AsfFieldKey PERFORMER_NAME_SORT;
    public static final /* enum */ AsfFieldKey PERIOD;
    public static final /* enum */ AsfFieldKey PRODUCER;
    public static final /* enum */ AsfFieldKey QUALITY;
    public static final /* enum */ AsfFieldKey RANKING;
    public static final /* enum */ AsfFieldKey RATING;
    public static final /* enum */ AsfFieldKey RECORD_LABEL;
    public static final /* enum */ AsfFieldKey REMIXER;
    public static final /* enum */ AsfFieldKey SCRIPT;
    public static final /* enum */ AsfFieldKey SINGLE_DISC_TRACK_NO;
    public static final /* enum */ AsfFieldKey SUBTITLE;
    public static final /* enum */ AsfFieldKey TAGS;
    public static final /* enum */ AsfFieldKey TEMPO;
    public static final /* enum */ AsfFieldKey TIMBRE;
    public static final /* enum */ AsfFieldKey TITLE;
    public static final /* enum */ AsfFieldKey TITLE_MOVEMENT;
    public static final /* enum */ AsfFieldKey TITLE_SORT;
    public static final /* enum */ AsfFieldKey TONALITY;
    public static final /* enum */ AsfFieldKey TRACK;
    public static final /* enum */ AsfFieldKey TRACK_TOTAL;
    public static final /* enum */ AsfFieldKey URL_DISCOGS_ARTIST_SITE;
    public static final /* enum */ AsfFieldKey URL_DISCOGS_RELEASE_SITE;
    public static final /* enum */ AsfFieldKey URL_LYRICS_SITE;
    public static final /* enum */ AsfFieldKey URL_OFFICIAL_ARTIST_SITE;
    public static final /* enum */ AsfFieldKey URL_OFFICIAL_RELEASE_SITE;
    public static final /* enum */ AsfFieldKey URL_PROMOTIONAL_SITE;
    public static final /* enum */ AsfFieldKey URL_WIKIPEDIA_ARTIST_SITE;
    public static final /* enum */ AsfFieldKey URL_WIKIPEDIA_RELEASE_SITE;
    public static final /* enum */ AsfFieldKey USER_RATING;
    public static final /* enum */ AsfFieldKey WORK;
    public static final /* enum */ AsfFieldKey WORK_TYPE;
    public static final /* enum */ AsfFieldKey YEAR;
    private final String fieldName;
    private final ContainerType highestContainer;
    private final ContainerType lowestContainer;
    private final boolean multiValued;

    static {
        AsfFieldKey asfFieldKey;
        AsfFieldKey asfFieldKey2;
        AsfFieldKey asfFieldKey3;
        AsfFieldKey asfFieldKey4;
        AsfFieldKey asfFieldKey5;
        AsfFieldKey asfFieldKey6;
        AsfFieldKey asfFieldKey7;
        AsfFieldKey asfFieldKey8;
        AsfFieldKey asfFieldKey9;
        ContainerType containerType = ContainerType.CONTENT_DESCRIPTION;
        AUTHOR = asfFieldKey3 = new AsfFieldKey("AUTHOR", false, containerType);
        TITLE = asfFieldKey6 = new AsfFieldKey("TITLE", false, containerType);
        RATING = asfFieldKey2 = new AsfFieldKey("RATING", false, containerType);
        COPYRIGHT = asfFieldKey7 = new AsfFieldKey("COPYRIGHT", false, containerType);
        DESCRIPTION = asfFieldKey5 = new AsfFieldKey("DESCRIPTION", false, containerType);
        ContainerType containerType2 = ContainerType.CONTENT_BRANDING;
        BANNER_IMAGE = asfFieldKey9 = new AsfFieldKey("BANNER_IMAGE", false, containerType2);
        BANNER_IMAGE_TYPE = asfFieldKey4 = new AsfFieldKey("BANNER_IMAGE_TYPE", false, containerType2);
        BANNER_IMAGE_URL = asfFieldKey = new AsfFieldKey("BANNER_IMAGE_URL", false, containerType2);
        COPYRIGHT_URL = asfFieldKey8 = new AsfFieldKey("COPYRIGHT_URL", false, containerType2);
        ACOUSTID_FINGERPRINT = new AsfFieldKey("Acoustid/Fingerprint", false);
        ACOUSTID_FINGERPRINT_OLD = new AsfFieldKey("AcoustId/Fingerprint", false);
        ACOUSTID_ID = new AsfFieldKey("Acoustid/Id", false);
        ALBUM = new AsfFieldKey("WM/AlbumTitle", false);
        ALBUM_ARTIST = new AsfFieldKey("WM/AlbumArtist", true);
        ALBUM_ARTIST_SORT = new AsfFieldKey("WM/AlbumArtistSortOrder", false);
        ALBUM_ARTISTS = new AsfFieldKey("ALBUM_ARTISTS", true);
        ALBUM_ARTISTS_SORT = new AsfFieldKey("ALBUM_ARTISTS_SORT", true);
        ALBUM_SORT = new AsfFieldKey("WM/AlbumSortOrder", false);
        AMAZON_ID = new AsfFieldKey("ASIN", false);
        ARRANGER = new AsfFieldKey("WM/Arranger", false);
        ARRANGER_SORT = new AsfFieldKey("ARRANGER_SORT", true);
        ARTISTS = new AsfFieldKey("WM/ARTISTS", true);
        ARTISTS_SORT = new AsfFieldKey("WM/ARTISTS_SORT", true);
        ARTIST_SORT = new AsfFieldKey("WM/ArtistSortOrder", false);
        BARCODE = new AsfFieldKey("WM/Barcode", false);
        BPM = new AsfFieldKey("WM/BeatsPerMinute", false);
        CATALOG_NO = new AsfFieldKey("WM/CatalogNo", false);
        CATEGORY = new AsfFieldKey("WM/Category", true);
        CHOIR = new AsfFieldKey("CHOIR", true);
        CHOIR_SORT = new AsfFieldKey("CHOIR_SORT", true);
        CLASSICAL_CATALOG = new AsfFieldKey("CLASSICAL_CATALOG", true);
        CLASSICAL_NICKNAME = new AsfFieldKey("CLASSICAL_NICKNAME", true);
        COMPOSER = new AsfFieldKey("WM/Composer", true);
        COMPOSER_SORT = new AsfFieldKey("WM/ComposerSort", false);
        CONDUCTOR = new AsfFieldKey("WM/Conductor", true);
        CONDUCTOR_SORT = new AsfFieldKey("CONDUCTOR_SORT", true);
        COUNTRY = new AsfFieldKey("WM/Country", false);
        COVER_ART = new AsfFieldKey("WM/Picture", true);
        COVER_ART_URL = new AsfFieldKey("WM/AlbumCoverURL", true);
        CUSTOM1 = new AsfFieldKey("CUSTOM1", true);
        CUSTOM2 = new AsfFieldKey("CUSTOM2", true);
        CUSTOM3 = new AsfFieldKey("CUSTOM3", true);
        CUSTOM4 = new AsfFieldKey("CUSTOM4", true);
        CUSTOM5 = new AsfFieldKey("CUSTOM5", true);
        DIRECTOR = new AsfFieldKey("WM/Director", true);
        DISC_NO = new AsfFieldKey("WM/PartOfSet", false);
        DISC_SUBTITLE = new AsfFieldKey("WM/SetSubTitle", false);
        DISC_TOTAL = new AsfFieldKey("WM/DiscTotal", false);
        DJMIXER = new AsfFieldKey("WM/DJMixer", false);
        ENCODED_BY = new AsfFieldKey("WM/EncodedBy", false);
        ENCODER = new AsfFieldKey("WM/ToolName", false);
        ENGINEER = new AsfFieldKey("WM/Engineer", false);
        ENSEMBLE = new AsfFieldKey("ENSEMBLE", true);
        ENSEMBLE_SORT = new AsfFieldKey("ENSEMBLE_SORT", true);
        FBPM = new AsfFieldKey("FBPM", true);
        GENRE = new AsfFieldKey("WM/Genre", true);
        GENRE_ID = new AsfFieldKey("WM/GenreID", true);
        GROUP = new AsfFieldKey("GROUP", false);
        GROUPING = new AsfFieldKey("WM/ContentGroupDescription", false);
        INITIAL_KEY = new AsfFieldKey("WM/InitialKey", false);
        INSTRUMENT = new AsfFieldKey("INSTRUMENT", true);
        INVOLVED_PERSON = new AsfFieldKey("WM/InvolvedPerson", true);
        ISRC = new AsfFieldKey("WM/ISRC", false);
        ISVBR = new AsfFieldKey("IsVBR", true);
        IS_CLASSICAL = new AsfFieldKey("IS_CLASSICAL", false);
        IS_COMPILATION = new AsfFieldKey("WM/IsCompilation", false);
        IS_SOUNDTRACK = new AsfFieldKey("IS_SOUNDTRACK", false);
        LANGUAGE = new AsfFieldKey("WM/Language", true);
        LYRICIST = new AsfFieldKey("WM/Writer", true);
        LYRICS = new AsfFieldKey("WM/Lyrics", false);
        LYRICS_SYNCHRONISED = new AsfFieldKey("WM/Lyrics_Synchronised", true);
        MEDIA = new AsfFieldKey("WM/Media", false);
        MIXER = new AsfFieldKey("WM/Mixer", false);
        MM_RATING = new AsfFieldKey("SDB/Rating", true);
        MOOD = new AsfFieldKey("WM/Mood", true);
        MOOD_ACOUSTIC = new AsfFieldKey("MOOD_ACOUSTIC", false);
        MOOD_AGGRESSIVE = new AsfFieldKey("MOOD_AGGRESSIVE", false);
        MOOD_AROUSAL = new AsfFieldKey("MOOD_AROUSAL", false);
        MOOD_DANCEABILITY = new AsfFieldKey("MOOD_DANCEABILITY", false);
        MOOD_ELECTRONIC = new AsfFieldKey("MOOD_ELECTRONIC", false);
        MOOD_HAPPY = new AsfFieldKey("MOOD_HAPPY", false);
        MOOD_INSTRUMENTAL = new AsfFieldKey("MOOD_INSTRUMENTAL", false);
        MOOD_PARTY = new AsfFieldKey("MOOD_PARTY", false);
        MOOD_RELAXED = new AsfFieldKey("MOOD_RELAXED", false);
        MOOD_SAD = new AsfFieldKey("MOOD_SAD", false);
        MOOD_VALENCE = new AsfFieldKey("MOOD_VALENCE", false);
        MOVEMENT = new AsfFieldKey("MOVEMENT", false);
        MOVEMENT_NO = new AsfFieldKey("MOVEMENT_NO", false);
        MOVEMENT_TOTAL = new AsfFieldKey("MOVEMENT_TOTAL", false);
        MUSICBRAINZ_ARTISTID = new AsfFieldKey("MusicBrainz/Artist Id", false);
        MUSICBRAINZ_DISC_ID = new AsfFieldKey("MusicBrainz/Disc Id", false);
        MUSICBRAINZ_ORIGINAL_RELEASEID = new AsfFieldKey("MusicBrainz/Original Album Id", false);
        MUSICBRAINZ_RELEASEARTISTID = new AsfFieldKey("MusicBrainz/Album Artist Id", false);
        MUSICBRAINZ_RELEASEGROUPID = new AsfFieldKey("MusicBrainz/Release Group Id", false);
        MUSICBRAINZ_RELEASEID = new AsfFieldKey("MusicBrainz/Album Id", false);
        MUSICBRAINZ_RELEASETRACKID = new AsfFieldKey("MusicBrainz/Release Track Id", false);
        MUSICBRAINZ_RELEASE_COUNTRY = new AsfFieldKey("MusicBrainz/Album Release Country", false);
        MUSICBRAINZ_RELEASE_STATUS = new AsfFieldKey("MusicBrainz/Album Status", false);
        MUSICBRAINZ_RELEASE_TYPE = new AsfFieldKey("MusicBrainz/Album Type", false);
        MUSICBRAINZ_TRACK_ID = new AsfFieldKey("MusicBrainz/Track Id", false);
        MUSICBRAINZ_WORKID = new AsfFieldKey("MusicBrainz/Work Id", false);
        MUSICBRAINZ_WORK_COMPOSITION = new AsfFieldKey("MUSICBRAINZ_WORK_COMPOSITION", true);
        MUSICBRAINZ_WORK_COMPOSITION_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_COMPOSITION_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL1 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL1", true);
        MUSICBRAINZ_WORK_PART_LEVEL1_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL1_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL1_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL1_TYPE", true);
        MUSICBRAINZ_WORK_PART_LEVEL2 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL2", true);
        MUSICBRAINZ_WORK_PART_LEVEL2_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL2_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL2_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL2_TYPE", true);
        MUSICBRAINZ_WORK_PART_LEVEL3 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL3", true);
        MUSICBRAINZ_WORK_PART_LEVEL3_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL3_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL3_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL3_TYPE", true);
        MUSICBRAINZ_WORK_PART_LEVEL4 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL4", true);
        MUSICBRAINZ_WORK_PART_LEVEL4_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL4_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL4_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL4_TYPE", true);
        MUSICBRAINZ_WORK_PART_LEVEL5 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL5", true);
        MUSICBRAINZ_WORK_PART_LEVEL5_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL5_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL5_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL5_TYPE", true);
        MUSICBRAINZ_WORK_PART_LEVEL6_ID = new AsfFieldKey("MUSICBRAINZ_MUSICBRAINZ_WORK_PART_LEVEL6_ID", true);
        MUSICBRAINZ_WORK_PART_LEVEL6 = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL6", true);
        MUSICBRAINZ_WORK_PART_LEVEL6_TYPE = new AsfFieldKey("MUSICBRAINZ_WORK_PART_LEVEL6_TYPE", true);
        MUSICIP_ID = new AsfFieldKey("MusicIP/PUID", false);
        OCCASION = new AsfFieldKey("Occasion", true);
        OPUS = new AsfFieldKey("OPUS", true);
        ORCHESTRA = new AsfFieldKey("ORCHESTRA", true);
        ORCHESTRA_SORT = new AsfFieldKey("ORCHESTRA_SORT", true);
        ORIGINAL_ALBUM = new AsfFieldKey("WM/OriginalAlbumTitle", true);
        ORIGINAL_ARTIST = new AsfFieldKey("WM/OriginalArtist", true);
        ORIGINAL_LYRICIST = new AsfFieldKey("WM/OriginalLyricist", true);
        ORIGINAL_YEAR = new AsfFieldKey("WM/OriginalReleaseYear", true);
        PART = new AsfFieldKey("PART", true);
        PART_NUMBER = new AsfFieldKey("PARTNUMBER", true);
        PART_TYPE = new AsfFieldKey("PART_TYPE", true);
        PERFORMER = new AsfFieldKey("PERFORMER", true);
        PERFORMER_NAME = new AsfFieldKey("PERFORMER_NAME", true);
        PERFORMER_NAME_SORT = new AsfFieldKey("PERFORMER_NAME_SORT", true);
        PERIOD = new AsfFieldKey("PERIOD", true);
        PRODUCER = new AsfFieldKey("WM/Producer", false);
        QUALITY = new AsfFieldKey("Quality", true);
        RANKING = new AsfFieldKey("RANKING", true);
        RECORD_LABEL = new AsfFieldKey("WM/Publisher", false);
        REMIXER = new AsfFieldKey("WM/ModifiedBy", false);
        SCRIPT = new AsfFieldKey("WM/Script", false);
        SINGLE_DISC_TRACK_NO = new AsfFieldKey("SINGLE_DISC_TRACK_NO", true);
        SUBTITLE = new AsfFieldKey("WM/SubTitle", false);
        TAGS = new AsfFieldKey("WM/Tags", false);
        TEMPO = new AsfFieldKey("Tempo", true);
        TIMBRE = new AsfFieldKey("TIMBRE_BRIGHTNESS", false);
        TITLE_MOVEMENT = new AsfFieldKey("TITLE_MOVEMENT", false);
        MUSICBRAINZ_WORK = new AsfFieldKey("MUSICBRAINZ_WORK", false);
        TITLE_SORT = new AsfFieldKey("WM/TitleSortOrder", false);
        TONALITY = new AsfFieldKey("TONALITY", false);
        TRACK = new AsfFieldKey("WM/TrackNumber", false);
        TRACK_TOTAL = new AsfFieldKey("WM/TrackTotal", false);
        URL_DISCOGS_ARTIST_SITE = new AsfFieldKey("WM/DiscogsArtistUrl", false);
        URL_DISCOGS_RELEASE_SITE = new AsfFieldKey("WM/DiscogsReleaseUrl", false);
        URL_LYRICS_SITE = new AsfFieldKey("WM/LyricsUrl", false);
        URL_OFFICIAL_ARTIST_SITE = new AsfFieldKey("WM/AuthorURL", false);
        URL_OFFICIAL_RELEASE_SITE = new AsfFieldKey("WM/OfficialReleaseUrl", false);
        URL_PROMOTIONAL_SITE = new AsfFieldKey("WM/PromotionURL", true);
        URL_WIKIPEDIA_ARTIST_SITE = new AsfFieldKey("WM/WikipediaArtistUrl", false);
        URL_WIKIPEDIA_RELEASE_SITE = new AsfFieldKey("WM/WikipediaReleaseUrl", false);
        USER_RATING = new AsfFieldKey("WM/SharedUserRating", true);
        WORK = new AsfFieldKey("WORK", true);
        WORK_TYPE = new AsfFieldKey("WORK_TYPE", true);
        YEAR = new AsfFieldKey("WM/Year", false);
        CUSTOM = new AsfFieldKey("___CUSTOM___", true);
        AsfFieldKey[] arrasfFieldKey = new AsfFieldKey[]{AUTHOR, TITLE, RATING, COPYRIGHT, DESCRIPTION, BANNER_IMAGE, BANNER_IMAGE_TYPE, BANNER_IMAGE_URL, COPYRIGHT_URL, ACOUSTID_FINGERPRINT, ACOUSTID_FINGERPRINT_OLD, ACOUSTID_ID, ALBUM, ALBUM_ARTIST, ALBUM_ARTIST_SORT, ALBUM_ARTISTS, ALBUM_ARTISTS_SORT, ALBUM_SORT, AMAZON_ID, ARRANGER, ARRANGER_SORT, ARTISTS, ARTISTS_SORT, ARTIST_SORT, BARCODE, BPM, CATALOG_NO, CATEGORY, CHOIR, CHOIR_SORT, CLASSICAL_CATALOG, CLASSICAL_NICKNAME, COMPOSER, COMPOSER_SORT, CONDUCTOR, CONDUCTOR_SORT, COUNTRY, COVER_ART, COVER_ART_URL, CUSTOM1, CUSTOM2, CUSTOM3, CUSTOM4, CUSTOM5, DIRECTOR, DISC_NO, DISC_SUBTITLE, DISC_TOTAL, DJMIXER, ENCODED_BY, ENCODER, ENGINEER, ENSEMBLE, ENSEMBLE_SORT, FBPM, GENRE, GENRE_ID, GROUP, GROUPING, INITIAL_KEY, INSTRUMENT, INVOLVED_PERSON, ISRC, ISVBR, IS_CLASSICAL, IS_COMPILATION, IS_SOUNDTRACK, LANGUAGE, LYRICIST, LYRICS, LYRICS_SYNCHRONISED, MEDIA, MIXER, MM_RATING, MOOD, MOOD_ACOUSTIC, MOOD_AGGRESSIVE, MOOD_AROUSAL, MOOD_DANCEABILITY, MOOD_ELECTRONIC, MOOD_HAPPY, MOOD_INSTRUMENTAL, MOOD_PARTY, MOOD_RELAXED, MOOD_SAD, MOOD_VALENCE, MOVEMENT, MOVEMENT_NO, MOVEMENT_TOTAL, MUSICBRAINZ_ARTISTID, MUSICBRAINZ_DISC_ID, MUSICBRAINZ_ORIGINAL_RELEASEID, MUSICBRAINZ_RELEASEARTISTID, MUSICBRAINZ_RELEASEGROUPID, MUSICBRAINZ_RELEASEID, MUSICBRAINZ_RELEASETRACKID, MUSICBRAINZ_RELEASE_COUNTRY, MUSICBRAINZ_RELEASE_STATUS, MUSICBRAINZ_RELEASE_TYPE, MUSICBRAINZ_TRACK_ID, MUSICBRAINZ_WORKID, MUSICBRAINZ_WORK_COMPOSITION, MUSICBRAINZ_WORK_COMPOSITION_ID, MUSICBRAINZ_WORK_PART_LEVEL1, MUSICBRAINZ_WORK_PART_LEVEL1_ID, MUSICBRAINZ_WORK_PART_LEVEL1_TYPE, MUSICBRAINZ_WORK_PART_LEVEL2, MUSICBRAINZ_WORK_PART_LEVEL2_ID, MUSICBRAINZ_WORK_PART_LEVEL2_TYPE, MUSICBRAINZ_WORK_PART_LEVEL3, MUSICBRAINZ_WORK_PART_LEVEL3_ID, MUSICBRAINZ_WORK_PART_LEVEL3_TYPE, MUSICBRAINZ_WORK_PART_LEVEL4, MUSICBRAINZ_WORK_PART_LEVEL4_ID, MUSICBRAINZ_WORK_PART_LEVEL4_TYPE, MUSICBRAINZ_WORK_PART_LEVEL5, MUSICBRAINZ_WORK_PART_LEVEL5_ID, MUSICBRAINZ_WORK_PART_LEVEL5_TYPE, MUSICBRAINZ_WORK_PART_LEVEL6_ID, MUSICBRAINZ_WORK_PART_LEVEL6, MUSICBRAINZ_WORK_PART_LEVEL6_TYPE, MUSICIP_ID, OCCASION, OPUS, ORCHESTRA, ORCHESTRA_SORT, ORIGINAL_ALBUM, ORIGINAL_ARTIST, ORIGINAL_LYRICIST, ORIGINAL_YEAR, PART, PART_NUMBER, PART_TYPE, PERFORMER, PERFORMER_NAME, PERFORMER_NAME_SORT, PERIOD, PRODUCER, QUALITY, RANKING, RECORD_LABEL, REMIXER, SCRIPT, SINGLE_DISC_TRACK_NO, SUBTITLE, TAGS, TEMPO, TIMBRE, TITLE_MOVEMENT, MUSICBRAINZ_WORK, TITLE_SORT, TONALITY, TRACK, TRACK_TOTAL, URL_DISCOGS_ARTIST_SITE, URL_DISCOGS_RELEASE_SITE, URL_LYRICS_SITE, URL_OFFICIAL_ARTIST_SITE, URL_OFFICIAL_RELEASE_SITE, URL_PROMOTIONAL_SITE, URL_WIKIPEDIA_ARTIST_SITE, URL_WIKIPEDIA_RELEASE_SITE, USER_RATING, WORK, WORK_TYPE, YEAR, CUSTOM};
        $VALUES = arrasfFieldKey;
        FIELD_ID_MAP = new HashMap(AsfFieldKey.values().length);
        for (AsfFieldKey asfFieldKey10 : AsfFieldKey.values()) {
            if (asfFieldKey10 == CUSTOM) continue;
            FIELD_ID_MAP.put((Object)asfFieldKey10.getFieldName(), (Object)asfFieldKey10);
        }
    }

    private AsfFieldKey(String string3, boolean bl) {
        this(string3, bl, ContainerType.EXTENDED_CONTENT, ContainerType.METADATA_LIBRARY_OBJECT);
    }

    private AsfFieldKey(String string3, boolean bl, ContainerType containerType) {
        this(string3, bl, containerType, containerType);
    }

    private AsfFieldKey(String string3, boolean bl, ContainerType containerType, ContainerType containerType2) {
        this.fieldName = string3;
        boolean bl2 = bl && containerType2.isMultiValued();
        this.multiValued = bl2;
        this.lowestContainer = containerType;
        this.highestContainer = containerType2;
    }

    public static AsfFieldKey getAsfFieldKey(String string2) {
        AsfFieldKey asfFieldKey = (AsfFieldKey)((Object)FIELD_ID_MAP.get((Object)string2));
        if (asfFieldKey == null) {
            asfFieldKey = CUSTOM;
        }
        return asfFieldKey;
    }

    public static boolean isMultiValued(String string2) {
        AsfFieldKey asfFieldKey = AsfFieldKey.getAsfFieldKey(string2);
        return asfFieldKey != null && asfFieldKey.isMultiValued();
    }

    public static AsfFieldKey valueOf(String string2) {
        return (AsfFieldKey)Enum.valueOf(AsfFieldKey.class, (String)string2);
    }

    public static AsfFieldKey[] values() {
        return (AsfFieldKey[])$VALUES.clone();
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public ContainerType getHighestContainer() {
        return this.highestContainer;
    }

    public ContainerType getLowestContainer() {
        return this.lowestContainer;
    }

    public boolean isMultiValued() {
        return this.multiValued;
    }

    public String toString() {
        return this.getFieldName();
    }
}

