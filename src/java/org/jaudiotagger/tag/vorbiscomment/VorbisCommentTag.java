/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.EnumMap
 *  java.util.List
 *  java.util.Map
 */
package org.jaudiotagger.tag.vorbiscomment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.vorbiscomment.VorbisAlbumArtistReadOptions;
import org.jaudiotagger.tag.vorbiscomment.VorbisAlbumArtistSaveOptions;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTagField;
import org.jaudiotagger.tag.vorbiscomment.util.Base64Coder;

public class VorbisCommentTag
extends AbstractTag {
    public static final String DEFAULT_VENDOR = "jaudiotagger";
    private static EnumMap<FieldKey, VorbisCommentFieldKey> tagFieldToOggField;

    static {
        EnumMap enumMap;
        tagFieldToOggField = enumMap = new EnumMap(FieldKey.class);
        enumMap.put((Enum)FieldKey.ACOUSTID_FINGERPRINT, (Object)VorbisCommentFieldKey.ACOUSTID_FINGERPRINT);
        tagFieldToOggField.put((Enum)FieldKey.ACOUSTID_ID, (Object)VorbisCommentFieldKey.ACOUSTID_ID);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM, (Object)VorbisCommentFieldKey.ALBUM);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM_ARTIST, (Object)VorbisCommentFieldKey.ALBUMARTIST);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM_ARTISTS, (Object)VorbisCommentFieldKey.ALBUMARTISTS);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM_ARTISTS_SORT, (Object)VorbisCommentFieldKey.ALBUMARTISTSSORT);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM_ARTIST_SORT, (Object)VorbisCommentFieldKey.ALBUMARTISTSORT);
        tagFieldToOggField.put((Enum)FieldKey.ALBUM_SORT, (Object)VorbisCommentFieldKey.ALBUMSORT);
        tagFieldToOggField.put((Enum)FieldKey.AMAZON_ID, (Object)VorbisCommentFieldKey.ASIN);
        tagFieldToOggField.put((Enum)FieldKey.ARRANGER, (Object)VorbisCommentFieldKey.ARRANGER);
        tagFieldToOggField.put((Enum)FieldKey.ARRANGER_SORT, (Object)VorbisCommentFieldKey.ARRANGER_SORT);
        tagFieldToOggField.put((Enum)FieldKey.ARTIST, (Object)VorbisCommentFieldKey.ARTIST);
        tagFieldToOggField.put((Enum)FieldKey.ARTISTS, (Object)VorbisCommentFieldKey.ARTISTS);
        tagFieldToOggField.put((Enum)FieldKey.ARTISTS_SORT, (Object)VorbisCommentFieldKey.ARTISTS_SORT);
        tagFieldToOggField.put((Enum)FieldKey.ARTIST_SORT, (Object)VorbisCommentFieldKey.ARTISTSORT);
        tagFieldToOggField.put((Enum)FieldKey.BARCODE, (Object)VorbisCommentFieldKey.BARCODE);
        tagFieldToOggField.put((Enum)FieldKey.BPM, (Object)VorbisCommentFieldKey.BPM);
        tagFieldToOggField.put((Enum)FieldKey.CATALOG_NO, (Object)VorbisCommentFieldKey.CATALOGNUMBER);
        tagFieldToOggField.put((Enum)FieldKey.CHOIR, (Object)VorbisCommentFieldKey.CHOIR);
        tagFieldToOggField.put((Enum)FieldKey.CHOIR_SORT, (Object)VorbisCommentFieldKey.CHOIR_SORT);
        tagFieldToOggField.put((Enum)FieldKey.CLASSICAL_CATALOG, (Object)VorbisCommentFieldKey.CLASSICAL_CATALOG);
        tagFieldToOggField.put((Enum)FieldKey.CLASSICAL_NICKNAME, (Object)VorbisCommentFieldKey.CLASSICAL_NICKNAME);
        tagFieldToOggField.put((Enum)FieldKey.COMMENT, (Object)VorbisCommentFieldKey.COMMENT);
        tagFieldToOggField.put((Enum)FieldKey.COMPOSER, (Object)VorbisCommentFieldKey.COMPOSER);
        tagFieldToOggField.put((Enum)FieldKey.COMPOSER_SORT, (Object)VorbisCommentFieldKey.COMPOSERSORT);
        tagFieldToOggField.put((Enum)FieldKey.COPYRIGHT, (Object)VorbisCommentFieldKey.COPYRIGHT);
        tagFieldToOggField.put((Enum)FieldKey.CONDUCTOR, (Object)VorbisCommentFieldKey.CONDUCTOR);
        tagFieldToOggField.put((Enum)FieldKey.CONDUCTOR_SORT, (Object)VorbisCommentFieldKey.CONDUCTOR_SORT);
        tagFieldToOggField.put((Enum)FieldKey.COUNTRY, (Object)VorbisCommentFieldKey.COUNTRY);
        tagFieldToOggField.put((Enum)FieldKey.COVER_ART, (Object)VorbisCommentFieldKey.METADATA_BLOCK_PICTURE);
        tagFieldToOggField.put((Enum)FieldKey.CUSTOM1, (Object)VorbisCommentFieldKey.CUSTOM1);
        tagFieldToOggField.put((Enum)FieldKey.CUSTOM2, (Object)VorbisCommentFieldKey.CUSTOM2);
        tagFieldToOggField.put((Enum)FieldKey.CUSTOM3, (Object)VorbisCommentFieldKey.CUSTOM3);
        tagFieldToOggField.put((Enum)FieldKey.CUSTOM4, (Object)VorbisCommentFieldKey.CUSTOM4);
        tagFieldToOggField.put((Enum)FieldKey.CUSTOM5, (Object)VorbisCommentFieldKey.CUSTOM5);
        tagFieldToOggField.put((Enum)FieldKey.DISC_NO, (Object)VorbisCommentFieldKey.DISCNUMBER);
        tagFieldToOggField.put((Enum)FieldKey.DISC_SUBTITLE, (Object)VorbisCommentFieldKey.DISCSUBTITLE);
        tagFieldToOggField.put((Enum)FieldKey.DISC_TOTAL, (Object)VorbisCommentFieldKey.DISCTOTAL);
        tagFieldToOggField.put((Enum)FieldKey.DJMIXER, (Object)VorbisCommentFieldKey.DJMIXER);
        tagFieldToOggField.put((Enum)FieldKey.ENCODER, (Object)VorbisCommentFieldKey.VENDOR);
        tagFieldToOggField.put((Enum)FieldKey.ENGINEER, (Object)VorbisCommentFieldKey.ENGINEER);
        tagFieldToOggField.put((Enum)FieldKey.ENSEMBLE, (Object)VorbisCommentFieldKey.ENSEMBLE);
        tagFieldToOggField.put((Enum)FieldKey.ENSEMBLE_SORT, (Object)VorbisCommentFieldKey.ENSEMBLE_SORT);
        tagFieldToOggField.put((Enum)FieldKey.FBPM, (Object)VorbisCommentFieldKey.FBPM);
        tagFieldToOggField.put((Enum)FieldKey.GENRE, (Object)VorbisCommentFieldKey.GENRE);
        tagFieldToOggField.put((Enum)FieldKey.GROUP, (Object)VorbisCommentFieldKey.GROUP);
        tagFieldToOggField.put((Enum)FieldKey.GROUPING, (Object)VorbisCommentFieldKey.GROUPING);
        tagFieldToOggField.put((Enum)FieldKey.INSTRUMENT, (Object)VorbisCommentFieldKey.INSTRUMENT);
        tagFieldToOggField.put((Enum)FieldKey.INVOLVED_PERSON, (Object)VorbisCommentFieldKey.INVOLVED_PERSON);
        tagFieldToOggField.put((Enum)FieldKey.ISRC, (Object)VorbisCommentFieldKey.ISRC);
        tagFieldToOggField.put((Enum)FieldKey.IS_CLASSICAL, (Object)VorbisCommentFieldKey.IS_CLASSICAL);
        tagFieldToOggField.put((Enum)FieldKey.IS_COMPILATION, (Object)VorbisCommentFieldKey.COMPILATION);
        tagFieldToOggField.put((Enum)FieldKey.IS_SOUNDTRACK, (Object)VorbisCommentFieldKey.IS_SOUNDTRACK);
        tagFieldToOggField.put((Enum)FieldKey.KEY, (Object)VorbisCommentFieldKey.KEY);
        tagFieldToOggField.put((Enum)FieldKey.LANGUAGE, (Object)VorbisCommentFieldKey.LANGUAGE);
        tagFieldToOggField.put((Enum)FieldKey.LYRICIST, (Object)VorbisCommentFieldKey.LYRICIST);
        tagFieldToOggField.put((Enum)FieldKey.LYRICS, (Object)VorbisCommentFieldKey.LYRICS);
        tagFieldToOggField.put((Enum)FieldKey.MEDIA, (Object)VorbisCommentFieldKey.MEDIA);
        tagFieldToOggField.put((Enum)FieldKey.MIXER, (Object)VorbisCommentFieldKey.MIXER);
        tagFieldToOggField.put((Enum)FieldKey.MOOD, (Object)VorbisCommentFieldKey.MOOD);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_ACOUSTIC, (Object)VorbisCommentFieldKey.MOOD_ACOUSTIC);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_AGGRESSIVE, (Object)VorbisCommentFieldKey.MOOD_AGGRESSIVE);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_AROUSAL, (Object)VorbisCommentFieldKey.MOOD_AROUSAL);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_DANCEABILITY, (Object)VorbisCommentFieldKey.MOOD_DANCEABILITY);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_ELECTRONIC, (Object)VorbisCommentFieldKey.MOOD_ELECTRONIC);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_HAPPY, (Object)VorbisCommentFieldKey.MOOD_HAPPY);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_INSTRUMENTAL, (Object)VorbisCommentFieldKey.MOOD_INSTRUMENTAL);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_PARTY, (Object)VorbisCommentFieldKey.MOOD_PARTY);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_RELAXED, (Object)VorbisCommentFieldKey.MOOD_RELAXED);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_SAD, (Object)VorbisCommentFieldKey.MOOD_SAD);
        tagFieldToOggField.put((Enum)FieldKey.MOOD_VALENCE, (Object)VorbisCommentFieldKey.MOOD_VALENCE);
        tagFieldToOggField.put((Enum)FieldKey.MOVEMENT, (Object)VorbisCommentFieldKey.MOVEMENT);
        tagFieldToOggField.put((Enum)FieldKey.MOVEMENT_NO, (Object)VorbisCommentFieldKey.MOVEMENT_NO);
        tagFieldToOggField.put((Enum)FieldKey.MOVEMENT_TOTAL, (Object)VorbisCommentFieldKey.MOVEMENT_TOTAL);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_ARTISTID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ARTISTID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_DISC_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_DISCID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_ORIGINAL_RELEASE_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ORIGINAL_ALBUMID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASEARTISTID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ALBUMARTISTID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASEID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ALBUMID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_COUNTRY, (Object)VorbisCommentFieldKey.RELEASECOUNTRY);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_GROUP_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_RELEASEGROUPID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_STATUS, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ALBUMSTATUS);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TRACK_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_RELEASETRACKID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_RELEASE_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_ALBUMTYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_TRACK_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_TRACKID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_COMPOSITION);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_COMPOSITION_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORKID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL1_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL2_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL3_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL4_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL5_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_ID);
        tagFieldToOggField.put((Enum)FieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE, (Object)VorbisCommentFieldKey.MUSICBRAINZ_WORK_PART_LEVEL6_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.MUSICIP_ID, (Object)VorbisCommentFieldKey.MUSICIP_PUID);
        tagFieldToOggField.put((Enum)FieldKey.OCCASION, (Object)VorbisCommentFieldKey.OCCASION);
        tagFieldToOggField.put((Enum)FieldKey.OPUS, (Object)VorbisCommentFieldKey.OPUS);
        tagFieldToOggField.put((Enum)FieldKey.ORCHESTRA, (Object)VorbisCommentFieldKey.ORCHESTRA);
        tagFieldToOggField.put((Enum)FieldKey.ORCHESTRA_SORT, (Object)VorbisCommentFieldKey.ORCHESTRA_SORT);
        tagFieldToOggField.put((Enum)FieldKey.ORIGINAL_ALBUM, (Object)VorbisCommentFieldKey.ORIGINAL_ALBUM);
        tagFieldToOggField.put((Enum)FieldKey.ORIGINAL_ARTIST, (Object)VorbisCommentFieldKey.ORIGINAL_ARTIST);
        tagFieldToOggField.put((Enum)FieldKey.ORIGINAL_LYRICIST, (Object)VorbisCommentFieldKey.ORIGINAL_LYRICIST);
        tagFieldToOggField.put((Enum)FieldKey.ORIGINAL_YEAR, (Object)VorbisCommentFieldKey.ORIGINAL_YEAR);
        tagFieldToOggField.put((Enum)FieldKey.PART, (Object)VorbisCommentFieldKey.PART);
        tagFieldToOggField.put((Enum)FieldKey.PART_NUMBER, (Object)VorbisCommentFieldKey.PART_NUMBER);
        tagFieldToOggField.put((Enum)FieldKey.PART_TYPE, (Object)VorbisCommentFieldKey.PART_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.PERFORMER, (Object)VorbisCommentFieldKey.PERFORMER);
        tagFieldToOggField.put((Enum)FieldKey.PERFORMER_NAME, (Object)VorbisCommentFieldKey.PERFORMER_NAME);
        tagFieldToOggField.put((Enum)FieldKey.PERFORMER_NAME_SORT, (Object)VorbisCommentFieldKey.PERFORMER_NAME_SORT);
        tagFieldToOggField.put((Enum)FieldKey.PERIOD, (Object)VorbisCommentFieldKey.PERIOD);
        tagFieldToOggField.put((Enum)FieldKey.PRODUCER, (Object)VorbisCommentFieldKey.PRODUCER);
        tagFieldToOggField.put((Enum)FieldKey.QUALITY, (Object)VorbisCommentFieldKey.QUALITY);
        tagFieldToOggField.put((Enum)FieldKey.RANKING, (Object)VorbisCommentFieldKey.RANKING);
        tagFieldToOggField.put((Enum)FieldKey.RATING, (Object)VorbisCommentFieldKey.RATING);
        tagFieldToOggField.put((Enum)FieldKey.RECORD_LABEL, (Object)VorbisCommentFieldKey.LABEL);
        tagFieldToOggField.put((Enum)FieldKey.REMIXER, (Object)VorbisCommentFieldKey.REMIXER);
        tagFieldToOggField.put((Enum)FieldKey.SCRIPT, (Object)VorbisCommentFieldKey.SCRIPT);
        tagFieldToOggField.put((Enum)FieldKey.SINGLE_DISC_TRACK_NO, (Object)VorbisCommentFieldKey.SINGLE_DISC_TRACK_NO);
        tagFieldToOggField.put((Enum)FieldKey.SUBTITLE, (Object)VorbisCommentFieldKey.SUBTITLE);
        tagFieldToOggField.put((Enum)FieldKey.TAGS, (Object)VorbisCommentFieldKey.TAGS);
        tagFieldToOggField.put((Enum)FieldKey.TEMPO, (Object)VorbisCommentFieldKey.TEMPO);
        tagFieldToOggField.put((Enum)FieldKey.TIMBRE, (Object)VorbisCommentFieldKey.TIMBRE);
        tagFieldToOggField.put((Enum)FieldKey.TITLE, (Object)VorbisCommentFieldKey.TITLE);
        tagFieldToOggField.put((Enum)FieldKey.TITLE_MOVEMENT, (Object)VorbisCommentFieldKey.TITLE_MOVEMENT);
        tagFieldToOggField.put((Enum)FieldKey.TITLE_SORT, (Object)VorbisCommentFieldKey.TITLESORT);
        tagFieldToOggField.put((Enum)FieldKey.TONALITY, (Object)VorbisCommentFieldKey.TONALITY);
        tagFieldToOggField.put((Enum)FieldKey.TRACK, (Object)VorbisCommentFieldKey.TRACKNUMBER);
        tagFieldToOggField.put((Enum)FieldKey.TRACK_TOTAL, (Object)VorbisCommentFieldKey.TRACKTOTAL);
        tagFieldToOggField.put((Enum)FieldKey.URL_DISCOGS_ARTIST_SITE, (Object)VorbisCommentFieldKey.URL_DISCOGS_ARTIST_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_DISCOGS_RELEASE_SITE, (Object)VorbisCommentFieldKey.URL_DISCOGS_RELEASE_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_LYRICS_SITE, (Object)VorbisCommentFieldKey.URL_LYRICS_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_OFFICIAL_ARTIST_SITE, (Object)VorbisCommentFieldKey.URL_OFFICIAL_ARTIST_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_OFFICIAL_RELEASE_SITE, (Object)VorbisCommentFieldKey.URL_OFFICIAL_RELEASE_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_WIKIPEDIA_ARTIST_SITE, (Object)VorbisCommentFieldKey.URL_WIKIPEDIA_ARTIST_SITE);
        tagFieldToOggField.put((Enum)FieldKey.URL_WIKIPEDIA_RELEASE_SITE, (Object)VorbisCommentFieldKey.URL_WIKIPEDIA_RELEASE_SITE);
        tagFieldToOggField.put((Enum)FieldKey.WORK, (Object)VorbisCommentFieldKey.WORK);
        tagFieldToOggField.put((Enum)FieldKey.WORK_TYPE, (Object)VorbisCommentFieldKey.WORK_TYPE);
        tagFieldToOggField.put((Enum)FieldKey.YEAR, (Object)VorbisCommentFieldKey.DATE);
    }

    private MetadataBlockDataPicture createMetadataBlockDataPicture(Artwork artwork) throws FieldDataInvalidException {
        if (artwork.isLinked()) {
            MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(artwork.getImageUrl().getBytes(StandardCharsets.ISO_8859_1), artwork.getPictureType(), "-->", "", 0, 0, 0, 0);
            return metadataBlockDataPicture;
        }
        if (artwork.setImageFromData()) {
            MetadataBlockDataPicture metadataBlockDataPicture = new MetadataBlockDataPicture(artwork.getBinaryData(), artwork.getPictureType(), artwork.getMimeType(), artwork.getDescription(), artwork.getWidth(), artwork.getHeight(), 0, 0);
            return metadataBlockDataPicture;
        }
        throw new FieldDataInvalidException("Unable to create MetadataBlockDataPicture from buffered");
    }

    public static VorbisCommentTag createNewTag() {
        VorbisCommentTag vorbisCommentTag = new VorbisCommentTag();
        vorbisCommentTag.setVendor(DEFAULT_VENDOR);
        return vorbisCommentTag;
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
                        this.addField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                        return;
                    }
                    this.addField(this.createField(fieldKey, string2));
                    this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName());
                    return;
                }
                this.addField(this.createField(fieldKey, string2));
                return;
            }
            this.addField(this.createField(fieldKey, string2));
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void addField(TagField tagField) {
        if (tagField.getId().equals((Object)VorbisCommentFieldKey.VENDOR.getFieldName())) {
            super.setField(tagField);
            return;
        }
        super.addField(tagField);
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

    public TagField createField(String string2, String string3) {
        if (string3 != null) {
            return new VorbisCommentTagField(string2, string3);
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != null) {
            return this.createField((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey)), arrstring[0]);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        try {
            String string2 = new String(Base64Coder.encode(this.createMetadataBlockDataPicture(artwork).getRawContent()));
            TagField tagField = this.createField(VorbisCommentFieldKey.METADATA_BLOCK_PICTURE, string2);
            return tagField;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException((Throwable)unsupportedEncodingException);
        }
    }

    public TagField createField(VorbisCommentFieldKey vorbisCommentFieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (string2 != null) {
            if (vorbisCommentFieldKey != null) {
                return new VorbisCommentTagField(vorbisCommentFieldKey.getFieldName(), string2);
            }
            throw new KeyNotFoundException();
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.deleteField(VorbisCommentFieldKey.METADATA_BLOCK_PICTURE);
        this.deleteField(VorbisCommentFieldKey.COVERART);
        this.deleteField(VorbisCommentFieldKey.COVERARTMIME);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.ALBUM_ARTIST) {
                int n2 = 1.$SwitchMap$org$jaudiotagger$tag$vorbiscomment$VorbisAlbumArtistSaveOptions[TagOptionSingleton.getInstance().getVorbisAlbumArtistSaveOptions().ordinal()];
                if (n2 != 1 && n2 != 2) {
                    if (n2 != 3 && n2 != 4) {
                        if (n2 != 5) {
                            return;
                        }
                        this.deleteField((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey)));
                        this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER);
                        return;
                    }
                    this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER);
                    return;
                }
                this.deleteField((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey)));
                return;
            }
            this.deleteField((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey)));
            return;
        }
        throw new KeyNotFoundException();
    }

    public void deleteField(VorbisCommentFieldKey vorbisCommentFieldKey) throws KeyNotFoundException {
        if (vorbisCommentFieldKey != null) {
            super.deleteField(vorbisCommentFieldKey.getFieldName());
            return;
        }
        throw new KeyNotFoundException();
    }

    public List<TagField> get(VorbisCommentFieldKey vorbisCommentFieldKey) throws KeyNotFoundException {
        if (vorbisCommentFieldKey != null) {
            return super.getFields(vorbisCommentFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        VorbisCommentFieldKey vorbisCommentFieldKey = (VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey));
        if (vorbisCommentFieldKey != null) {
            return super.getAll(vorbisCommentFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    public byte[] getArtworkBinaryData() {
        return Base64Coder.decode(this.getFirst(VorbisCommentFieldKey.COVERART).toCharArray());
    }

    @Override
    public List<Artwork> getArtworkList() {
        int n2 = 1;
        ArrayList arrayList = new ArrayList(n2);
        int n3 = this.getArtworkBinaryData() != null ? 1 : 0;
        if (this.getArtworkBinaryData().length <= 0) {
            n2 = 0;
        }
        if ((n2 & n3) != 0) {
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setMimeType(this.getArtworkMimeType());
            artwork.setBinaryData(this.getArtworkBinaryData());
            arrayList.add((Object)artwork);
        }
        for (TagField tagField : this.get(VorbisCommentFieldKey.METADATA_BLOCK_PICTURE)) {
            try {
                arrayList.add((Object)ArtworkFactory.createArtworkFromMetadataBlockDataPicture(new MetadataBlockDataPicture(ByteBuffer.wrap((byte[])Base64Coder.decode(((TagTextField)tagField).getContent())))));
            }
            catch (InvalidFrameException invalidFrameException) {
                throw new RuntimeException((Throwable)invalidFrameException);
            }
            catch (IOException iOException) {
                throw new RuntimeException((Throwable)iOException);
            }
        }
        return arrayList;
    }

    public String getArtworkMimeType() {
        return this.getFirst(VorbisCommentFieldKey.COVERARTMIME);
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        VorbisCommentFieldKey vorbisCommentFieldKey = (VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey));
        if (vorbisCommentFieldKey != null) {
            return super.getFields(vorbisCommentFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    public String getFirst(VorbisCommentFieldKey vorbisCommentFieldKey) throws KeyNotFoundException {
        if (vorbisCommentFieldKey != null) {
            return super.getFirst(vorbisCommentFieldKey.getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            return this.getFirstField(((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey))).getFieldName());
        }
        throw new KeyNotFoundException();
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey == FieldKey.ALBUM_ARTIST) {
            int n3 = 1.$SwitchMap$org$jaudiotagger$tag$vorbiscomment$VorbisAlbumArtistReadOptions[TagOptionSingleton.getInstance().getVorbisAlbumArtisReadOptions().ordinal()];
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 4) {
                            VorbisCommentFieldKey vorbisCommentFieldKey = (VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey));
                            if (vorbisCommentFieldKey != null) {
                                return super.getItem(vorbisCommentFieldKey.getFieldName(), n2);
                            }
                            throw new KeyNotFoundException();
                        }
                        String string2 = super.getItem(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName(), n2);
                        if (string2.isEmpty()) {
                            string2 = super.getItem(VorbisCommentFieldKey.ALBUMARTIST.getFieldName(), n2);
                        }
                        return string2;
                    }
                    String string3 = super.getItem(VorbisCommentFieldKey.ALBUMARTIST.getFieldName(), n2);
                    if (string3.isEmpty()) {
                        string3 = super.getItem(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName(), n2);
                    }
                    return string3;
                }
                return super.getItem(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName(), n2);
            }
            return super.getItem(VorbisCommentFieldKey.ALBUMARTIST.getFieldName(), n2);
        }
        VorbisCommentFieldKey vorbisCommentFieldKey = (VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey));
        if (vorbisCommentFieldKey != null) {
            return super.getItem(vorbisCommentFieldKey.getFieldName(), n2);
        }
        throw new KeyNotFoundException();
    }

    public String getVendor() {
        return this.getFirst(VorbisCommentFieldKey.VENDOR.getFieldName());
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.getFields(((VorbisCommentFieldKey)((Object)tagFieldToOggField.get((Object)fieldKey))).getFieldName()).size() != 0;
    }

    public boolean hasField(VorbisCommentFieldKey vorbisCommentFieldKey) {
        return this.getFields(vorbisCommentFieldKey.getFieldName()).size() != 0;
    }

    @Override
    protected boolean isAllowedEncoding(Charset charset) {
        return charset.equals((Object)"UTF-8");
    }

    @Override
    public boolean isEmpty() {
        return this.fields.size() <= 1;
    }

    @Deprecated
    public void setArtworkField(byte[] arrby, String string2) {
        String string3 = new String(Base64Coder.encode(arrby));
        VorbisCommentTagField vorbisCommentTagField = new VorbisCommentTagField(VorbisCommentFieldKey.COVERART.getFieldName(), string3);
        VorbisCommentTagField vorbisCommentTagField2 = new VorbisCommentTagField(VorbisCommentFieldKey.COVERARTMIME.getFieldName(), string2);
        this.setField(vorbisCommentTagField);
        this.setField(vorbisCommentTagField2);
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
                        this.setField(this.createField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER, string2));
                        return;
                    }
                    this.setField(this.createField(fieldKey, string2));
                    this.deleteField(VorbisCommentFieldKey.ALBUMARTIST_JRIVER.getFieldName());
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
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.setField(this.createField(artwork));
        VorbisCommentFieldKey vorbisCommentFieldKey = VorbisCommentFieldKey.COVERART;
        if (this.getFirst(vorbisCommentFieldKey).length() > 0) {
            this.deleteField(vorbisCommentFieldKey);
            this.deleteField(VorbisCommentFieldKey.COVERARTMIME);
        }
    }

    public void setVendor(String string2) {
        if (string2 == null) {
            string2 = DEFAULT_VENDOR;
        }
        super.setField(new VorbisCommentTagField(VorbisCommentFieldKey.VENDOR.getFieldName(), string2));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OGG ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}

