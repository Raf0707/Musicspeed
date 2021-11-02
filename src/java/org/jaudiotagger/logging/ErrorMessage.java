/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.text.MessageFormat
 */
package org.jaudiotagger.logging;

import java.text.MessageFormat;

public final class ErrorMessage
extends Enum<ErrorMessage> {
    private static final /* synthetic */ ErrorMessage[] $VALUES;
    public static final /* enum */ ErrorMessage ADDITIONAL_MOOV_ATOM_AT_END_OF_MP4;
    public static final /* enum */ ErrorMessage ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD;
    public static final /* enum */ ErrorMessage ARTWORK_CANNOT_BE_RETRIEVED_WITH_THIS_METHOD;
    public static final /* enum */ ErrorMessage ASF_FILE_HEADER_MISSING;
    public static final /* enum */ ErrorMessage ASF_FILE_HEADER_SIZE_DOES_NOT_MATCH_FILE_SIZE;
    public static final /* enum */ ErrorMessage ASF_HEADER_MISSING;
    public static final /* enum */ ErrorMessage ATOM_LENGTH_LARGER_THAN_DATA;
    public static final /* enum */ ErrorMessage DO_NOT_KNOW_HOW_TO_CREATE_THIS_ATOM_TYPE;
    public static final /* enum */ ErrorMessage FLAC_CONTAINS_ID3TAG;
    public static final /* enum */ ErrorMessage FLAC_NO_BLOCKTYPE;
    public static final /* enum */ ErrorMessage FLAC_NO_FLAC_HEADER_FOUND;
    public static final /* enum */ ErrorMessage GENERAL_DELETE_FAILED;
    public static final /* enum */ ErrorMessage GENERAL_DELETE_FAILED_BECAUSE_FILE_IS_TOO_SMALL;
    public static final /* enum */ ErrorMessage GENERAL_DELETE_FAILED_FILE_LOCKED;
    public static final /* enum */ ErrorMessage GENERAL_GET_CREATION_TIME_FAILED;
    public static final /* enum */ ErrorMessage GENERAL_INVALID_NULL_ARGUMENT;
    public static final /* enum */ ErrorMessage GENERAL_READ;
    public static final /* enum */ ErrorMessage GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE;
    public static final /* enum */ ErrorMessage GENERAL_READ_FAILED_FILE_TOO_SMALL;
    public static final /* enum */ ErrorMessage GENERAL_READ_FAILED_UNABLE_TO_CLOSE_RANDOM_ACCESS_FILE;
    public static final /* enum */ ErrorMessage GENERAL_SET_CREATION_TIME_FAILED;
    public static final /* enum */ ErrorMessage GENERAL_UNIDENITIFED_IMAGE_FORMAT;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_BECAUSE;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_FILE_LOCKED;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_DELETE_ORIGINAL_FILE;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_BACKUP_TO_ORIGINAL;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_FILE_TO_BACKUP;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE;
    public static final /* enum */ ErrorMessage GENERAL_WRITE_WARNING_UNABLE_TO_DELETE_BACKUP_FILE;
    public static final /* enum */ ErrorMessage GENERIC_NOT_SUPPORTED;
    public static final /* enum */ ErrorMessage ID3_EXTENDED_HEADER_SIZE_INVALID;
    public static final /* enum */ ErrorMessage ID3_EXTENDED_HEADER_SIZE_TOO_SMALL;
    public static final /* enum */ ErrorMessage ID3_INVALID_OR_UNKNOWN_FLAG_SET;
    public static final /* enum */ ErrorMessage ID3_TAG_COMPRESSED;
    public static final /* enum */ ErrorMessage ID3_TAG_CRC;
    public static final /* enum */ ErrorMessage ID3_TAG_CRC_FLAG_SET_INCORRECTLY;
    public static final /* enum */ ErrorMessage ID3_TAG_CRC_SIZE;
    public static final /* enum */ ErrorMessage ID3_TAG_EXPERIMENTAL;
    public static final /* enum */ ErrorMessage ID3_TAG_EXTENDED;
    public static final /* enum */ ErrorMessage ID3_TAG_FOOTER;
    public static final /* enum */ ErrorMessage ID3_TAG_PADDING_SIZE;
    public static final /* enum */ ErrorMessage ID3_TAG_UNSYNCHRONIZED;
    public static final /* enum */ ErrorMessage ID3_UNABLE_TO_DECOMPRESS_FRAME;
    public static final /* enum */ ErrorMessage ID_TAG_SIZE;
    public static final /* enum */ ErrorMessage INVALID_FIELD_FOR_ID3V1TAG;
    public static final /* enum */ ErrorMessage MP3_FRAME_IS_COMPRESSED;
    public static final /* enum */ ErrorMessage MP3_FRAME_IS_DATA_LENGTH_INDICATOR;
    public static final /* enum */ ErrorMessage MP3_FRAME_IS_ENCRYPTED;
    public static final /* enum */ ErrorMessage MP3_FRAME_IS_GROUPED;
    public static final /* enum */ ErrorMessage MP3_FRAME_IS_UNSYNCHRONISED;
    public static final /* enum */ ErrorMessage MP3_ID3TAG_LENGTH_INCORRECT;
    public static final /* enum */ ErrorMessage MP3_PICTURE_TYPE_INVALID;
    public static final /* enum */ ErrorMessage MP3_RECALCULATED_POSSIBLE_START_OF_MP3_AUDIO;
    public static final /* enum */ ErrorMessage MP3_RECALCULATED_START_OF_MP3_AUDIO;
    public static final /* enum */ ErrorMessage MP3_REFERENCE_KEY_INVALID;
    public static final /* enum */ ErrorMessage MP3_START_OF_AUDIO_CONFIRMED;
    public static final /* enum */ ErrorMessage MP3_UNABLE_TO_ADJUST_PADDING;
    public static final /* enum */ ErrorMessage MP3_UNABLE_TO_ENCODE_URL;
    public static final /* enum */ ErrorMessage MP3_URL_SAVED_ENCODED;
    public static final /* enum */ ErrorMessage MP4_CANNOT_FIND_AUDIO;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_CANNOT_FIND_AUDIO;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_DATA_CORRUPT;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_INCORRECT_NUMBER_OF_TRACKS;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_INCORRECT_OFFSETS;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_NO_DATA;
    public static final /* enum */ ErrorMessage MP4_CHANGES_TO_FILE_FAILED_NO_TAG_DATA;
    public static final /* enum */ ErrorMessage MP4_FILE_CONTAINS_MULTIPLE_DATA_ATOMS;
    public static final /* enum */ ErrorMessage MP4_FILE_HAS_NO_METADATA;
    public static final /* enum */ ErrorMessage MP4_FILE_IS_VIDEO;
    public static final /* enum */ ErrorMessage MP4_FILE_META_ATOM_CHILD_DATA_NOT_NULL;
    public static final /* enum */ ErrorMessage MP4_FILE_NOT_AUDIO;
    public static final /* enum */ ErrorMessage MP4_FILE_NOT_CONTAINER;
    public static final /* enum */ ErrorMessage MP4_GENRE_OUT_OF_RANGE;
    public static final /* enum */ ErrorMessage MP4_IMAGE_FORMAT_IS_NOT_TO_EXPECTED_TYPE;
    public static final /* enum */ ErrorMessage MP4_NO_GENREID_FOR_GENRE;
    public static final /* enum */ ErrorMessage MP4_REVERSE_DNS_FIELD_HAS_NO_DATA;
    public static final /* enum */ ErrorMessage MP4_UNABLE_READ_REVERSE_DNS_FIELD;
    public static final /* enum */ ErrorMessage MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_IDENTIFIER_IS_INVALID;
    public static final /* enum */ ErrorMessage MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_LENGTH_IS_INVALID;
    public static final /* enum */ ErrorMessage MP4_UNABLE_TO_PRIME_FILE_FOR_WRITE_SAFETLY;
    public static final /* enum */ ErrorMessage NOT_STANDARD_MP$_GENRE;
    public static final /* enum */ ErrorMessage NO_AUDIO_HEADER_FOUND;
    public static final /* enum */ ErrorMessage NO_DELETER_FOR_THIS_FORMAT;
    public static final /* enum */ ErrorMessage NO_PERMISSIONS_TO_WRITE_TO_FILE;
    public static final /* enum */ ErrorMessage NO_READER_FOR_THIS_FORMAT;
    public static final /* enum */ ErrorMessage NO_WRITER_FOR_THIS_FORMAT;
    public static final /* enum */ ErrorMessage NULL_PADDING_FOUND_AT_END_OF_MP4;
    public static final /* enum */ ErrorMessage OGG_CONTAINS_ID3TAG;
    public static final /* enum */ ErrorMessage OGG_HEADER_CANNOT_BE_FOUND;
    public static final /* enum */ ErrorMessage OGG_VORBIS_NO_FRAMING_BIT;
    public static final /* enum */ ErrorMessage OGG_VORBIS_NO_SETUP_BLOCK;
    public static final /* enum */ ErrorMessage OGG_VORBIS_NO_VORBIS_HEADER_FOUND;
    public static final /* enum */ ErrorMessage OPERATION_NOT_SUPPORTED_FOR_FIELD;
    public static final /* enum */ ErrorMessage UNABLE_TO_FIND_FILE;
    public static final /* enum */ ErrorMessage VORBIS_COMMENT_LENGTH_LARGE_THAN_HEADER;
    public static final /* enum */ ErrorMessage VORBIS_COMMENT_LENGTH_TOO_LARGE;
    public static final /* enum */ ErrorMessage WMA_INVALID_FIELD_NAME;
    public static final /* enum */ ErrorMessage WMA_INVALID_GUID_USE;
    public static final /* enum */ ErrorMessage WMA_INVALID_LANGUAGE_USE;
    public static final /* enum */ ErrorMessage WMA_INVALID_STREAM_REFERNCE;
    public static final /* enum */ ErrorMessage WMA_LENGTH_OF_DATA_IS_TOO_LARGE;
    public static final /* enum */ ErrorMessage WMA_LENGTH_OF_LANGUAGE_IS_TOO_LARGE;
    public static final /* enum */ ErrorMessage WMA_LENGTH_OF_STRING_IS_TOO_LARGE;
    public static final /* enum */ ErrorMessage WMA_ONLY_STRING_IN_CD;
    String msg;

    static {
        GENERAL_READ = new ErrorMessage("File {0} being read");
        MP4_FILE_NOT_CONTAINER = new ErrorMessage("This file does not appear to be an Mp4  file");
        MP4_FILE_NOT_AUDIO = new ErrorMessage("This file does not appear to be an Mp4 Audio file, could be corrupted or video ");
        MP4_FILE_IS_VIDEO = new ErrorMessage("This file appears to be an Mp4 Video file, video files are not supported ");
        MP4_UNABLE_TO_PRIME_FILE_FOR_WRITE_SAFETLY = new ErrorMessage("Unable to safetly check consistency in Mp4 file so cancelling save");
        MP4_FILE_CONTAINS_MULTIPLE_DATA_ATOMS = new ErrorMessage("File contains multiple data atoms");
        MP4_CHANGES_TO_FILE_FAILED = new ErrorMessage("Unable to make changes to Mp4 file");
        MP4_CHANGES_TO_FILE_FAILED_NO_DATA = new ErrorMessage("Unable to make changes to Mp4 file, no data was written");
        MP4_CHANGES_TO_FILE_FAILED_DATA_CORRUPT = new ErrorMessage("Unable to make changes to Mp4 file, invalid data length has been written");
        MP4_CHANGES_TO_FILE_FAILED_NO_TAG_DATA = new ErrorMessage("Unable to make changes to Mp4 file, no tag data has been written");
        MP4_CHANGES_TO_FILE_FAILED_INCORRECT_OFFSETS = new ErrorMessage("Unable to make changes to Mp4 file, incorrect offsets written difference was {0}");
        MP4_CHANGES_TO_FILE_FAILED_INCORRECT_NUMBER_OF_TRACKS = new ErrorMessage("Unable to make changes to Mp4 file, incorrect number of tracks: {0} vs {1}");
        MP4_CHANGES_TO_FILE_FAILED_CANNOT_FIND_AUDIO = new ErrorMessage("Unable to make changes to Mp4 file, unable to determine start of audio");
        FLAC_NO_FLAC_HEADER_FOUND = new ErrorMessage("Flac Header not found, not a flac file");
        OGG_VORBIS_NO_VORBIS_HEADER_FOUND = new ErrorMessage("Cannot find vorbis setup parentHeader");
        MP4_REVERSE_DNS_FIELD_HAS_NO_DATA = new ErrorMessage("Reverse dns field:{0} has no data");
        MP4_UNABLE_READ_REVERSE_DNS_FIELD = new ErrorMessage("Unable to create reverse dns field because of exception:{0} adding as binary data instead");
        OGG_VORBIS_NO_FRAMING_BIT = new ErrorMessage("The OGG Stream is not valid, Vorbis tag valid framing bit is wrong {0} ");
        GENERAL_GET_CREATION_TIME_FAILED = new ErrorMessage("Failed to read creation time for file {0}");
        GENERAL_SET_CREATION_TIME_FAILED = new ErrorMessage("Failed to write creation time for file {0}");
        GENERAL_WRITE_FAILED = new ErrorMessage("Cannot make changes to file {0}");
        GENERAL_WRITE_FAILED_FILE_LOCKED = new ErrorMessage("Cannot make changes to file {0} because it is being used by another application");
        GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL = new ErrorMessage("Cannot make changes to file {0} because too small to be an audio file");
        GENERAL_WRITE_FAILED_TO_DELETE_ORIGINAL_FILE = new ErrorMessage("Cannot make changes to file {0} because unable to delete the original file ready for updating from temporary file {1}");
        GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE = new ErrorMessage("Cannot make changes to file {0} because unable to rename from temporary file {1}");
        GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_FILE_TO_BACKUP = new ErrorMessage("Cannot make changes to file {0} because unable to rename the original file to {1}");
        GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_BACKUP_TO_ORIGINAL = new ErrorMessage("Unable to rename backup {0} back to file {1}");
        GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST = new ErrorMessage("New file {0} does not appear to exist");
        GENERAL_WRITE_FAILED_BECAUSE = new ErrorMessage("Cannot make changes to file {0} because {1}");
        GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND = new ErrorMessage("Cannot make changes to file {0} because the file cannot be found");
        GENERAL_WRITE_WARNING_UNABLE_TO_DELETE_BACKUP_FILE = new ErrorMessage("Unable to delete the backup file {0}");
        GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE = new ErrorMessage("Problem closing file handles for file {0} because {1}");
        GENERAL_DELETE_FAILED = new ErrorMessage("Cannot delete file {0} because not writable");
        GENERAL_DELETE_FAILED_FILE_LOCKED = new ErrorMessage("Cannot delete file {0} because it is being used by another application");
        GENERAL_DELETE_FAILED_BECAUSE_FILE_IS_TOO_SMALL = new ErrorMessage("Cannot write to file {0} because too small to be an audio file");
        MP3_ID3TAG_LENGTH_INCORRECT = new ErrorMessage(" {0}:Checking further because the ID3 Tag ends at {1} but the mp3 audio doesnt start until {2}");
        MP3_RECALCULATED_POSSIBLE_START_OF_MP3_AUDIO = new ErrorMessage("{0}: Recalculated possible start of the audio to be at {1}");
        MP3_RECALCULATED_START_OF_MP3_AUDIO = new ErrorMessage("{0}: Recalculated the start of the audio to be at {1}");
        MP3_START_OF_AUDIO_CONFIRMED = new ErrorMessage("{0}: Confirmed audio starts at {1} whether searching from start or from end of ID3 tag");
        MP3_URL_SAVED_ENCODED = new ErrorMessage("Url:{0} saved in encoded form as {1}");
        MP3_UNABLE_TO_ENCODE_URL = new ErrorMessage("Unable to save url:{0} because cannot encode all characters setting to blank instead");
        MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_IDENTIFIER_IS_INVALID = new ErrorMessage("Unable to find next atom because identifier is invalid {0}");
        MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_LENGTH_IS_INVALID = new ErrorMessage("Unable to find next atom {0} because length is invalid {1}");
        GENERAL_INVALID_NULL_ARGUMENT = new ErrorMessage("Argument cannot be null");
        MP4_NO_GENREID_FOR_GENRE = new ErrorMessage("No genre id could be found for this genre atom with data length {0}");
        MP4_GENRE_OUT_OF_RANGE = new ErrorMessage("Genre Id {0} does not map to a valid genre");
        MP3_PICTURE_TYPE_INVALID = new ErrorMessage("Picture Type is set to invalid value:{0}");
        MP3_REFERENCE_KEY_INVALID = new ErrorMessage("{0}:No key could be found with the value of:{1}");
        MP3_UNABLE_TO_ADJUST_PADDING = new ErrorMessage("Problem adjusting padding in large file, expecting to write:{0} only wrote:{1}");
        GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE = new ErrorMessage("Unable to delete the temporary file {0}");
        GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER = new ErrorMessage("Cannot modify {0} because do not have permissions to create files in the folder {1}");
        GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER = new ErrorMessage("Cannot modify {0} because do not have permissions to modify files in the folder {1}");
        GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING = new ErrorMessage("Cannot modify {0} because do not have permissions to modify file");
        NULL_PADDING_FOUND_AT_END_OF_MP4 = new ErrorMessage("Null Padding found at end of file starting at offset {0}");
        OGG_VORBIS_NO_SETUP_BLOCK = new ErrorMessage("Could not find the Ogg Setup block");
        OGG_HEADER_CANNOT_BE_FOUND = new ErrorMessage("OggS Header could not be found, not an ogg stream {0}");
        GENERAL_READ_FAILED_UNABLE_TO_CLOSE_RANDOM_ACCESS_FILE = new ErrorMessage("Unable to close random access file: {0}");
        GENERAL_READ_FAILED_FILE_TOO_SMALL = new ErrorMessage("Unable to read file because it is too small to be valid audio file: {0}");
        GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE = new ErrorMessage("Unable to read file do not have permission to read: {0}");
        ASF_FILE_HEADER_SIZE_DOES_NOT_MATCH_FILE_SIZE = new ErrorMessage("For file {0} the File header size is {1} but different to actual file size of {2}");
        ASF_FILE_HEADER_MISSING = new ErrorMessage("For file {0} the File Header missing. Invalid ASF/WMA file.");
        ASF_HEADER_MISSING = new ErrorMessage("For file {0} the Asf Header missing. Invalid ASF/WMA file.");
        GENERAL_UNIDENITIFED_IMAGE_FORMAT = new ErrorMessage("Cannot safetly identify the format of this image setting to default type of Png");
        MP4_IMAGE_FORMAT_IS_NOT_TO_EXPECTED_TYPE = new ErrorMessage("ImageFormat for cover art atom is not set to a known image format, instead set to {0}");
        MP3_FRAME_IS_COMPRESSED = new ErrorMessage("Filename {0}:{1} is compressed");
        MP3_FRAME_IS_ENCRYPTED = new ErrorMessage("Filename {0}:{1} is encrypted");
        MP3_FRAME_IS_GROUPED = new ErrorMessage("Filename {0}:{1} is grouped");
        MP3_FRAME_IS_UNSYNCHRONISED = new ErrorMessage("Filename {0}:{1} is unsynchronised");
        MP3_FRAME_IS_DATA_LENGTH_INDICATOR = new ErrorMessage("Filename {0}:{1} has a data length indicator");
        MP4_FILE_HAS_NO_METADATA = new ErrorMessage("This file does not currently contain any metadata");
        MP4_FILE_META_ATOM_CHILD_DATA_NOT_NULL = new ErrorMessage("Expect data in meta box to be null");
        WMA_INVALID_FIELD_NAME = new ErrorMessage("The field name {0} is not allowed for {1}");
        WMA_INVALID_LANGUAGE_USE = new ErrorMessage("The use of language {0} ist not allowed for {1} (only {2} allowed)");
        WMA_INVALID_STREAM_REFERNCE = new ErrorMessage("The stream number {0} is invalid. Only {1} allowed for {2}.");
        WMA_INVALID_GUID_USE = new ErrorMessage("The use of GUID ist not allowed for {0}");
        WMA_LENGTH_OF_DATA_IS_TOO_LARGE = new ErrorMessage("Trying to create field with {0} bytes of data but the maximum data allowed in WMA files is {1} for {2}.");
        WMA_LENGTH_OF_LANGUAGE_IS_TOO_LARGE = new ErrorMessage("Trying to create language entry, but UTF-16LE representation is {0} and exceeds maximum allowed of 255.");
        WMA_LENGTH_OF_STRING_IS_TOO_LARGE = new ErrorMessage("Trying to create field but UTF-16LE representation is {0} and exceeds maximum allowed of 65535.");
        WMA_ONLY_STRING_IN_CD = new ErrorMessage("Only Strings are allowed in content description objects");
        ID3_EXTENDED_HEADER_SIZE_INVALID = new ErrorMessage("{0} Invalid Extended Header Size of {0} assuming no extended header after all");
        ID3_EXTENDED_HEADER_SIZE_TOO_SMALL = new ErrorMessage("{0} Invalid Extended Header Size of {0} is too smal to be valid");
        ID3_INVALID_OR_UNKNOWN_FLAG_SET = new ErrorMessage("{0} Invalid or unknown bit flag 0x{1} set in ID3 tag header");
        ID3_TAG_UNSYNCHRONIZED = new ErrorMessage("{0} the ID3 Tag is unsynchronized");
        ID3_TAG_EXPERIMENTAL = new ErrorMessage("{0} the ID3 Tag is experimental");
        ID3_TAG_FOOTER = new ErrorMessage("{0} the ID3 Tag is has a footer");
        ID3_TAG_EXTENDED = new ErrorMessage("{0} the ID3 Tag is extended");
        ID3_TAG_CRC = new ErrorMessage("{0} the ID3 Tag has crc check");
        ID3_TAG_COMPRESSED = new ErrorMessage("{0} the ID3 Tag is compressed");
        ID3_TAG_CRC_SIZE = new ErrorMessage("{0} According to Extended Header the ID3 Tag has crc32 of {1}");
        ID3_TAG_PADDING_SIZE = new ErrorMessage("{0} According to Extended Header the ID3 Tag has padding size of {1}");
        ID_TAG_SIZE = new ErrorMessage("{0} Tag size is {1} according to header (does not include header size, add 10)");
        ID3_TAG_CRC_FLAG_SET_INCORRECTLY = new ErrorMessage("{0} CRC Data flag not set correctly.");
        MP4_CANNOT_FIND_AUDIO = new ErrorMessage("Unable to determine start of audio in file");
        VORBIS_COMMENT_LENGTH_TOO_LARGE = new ErrorMessage("Comment field length is very large {0} , assuming comment is corrupt");
        VORBIS_COMMENT_LENGTH_LARGE_THAN_HEADER = new ErrorMessage("Comment field length {0} is larger than total comment header {1} ");
        ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD = new ErrorMessage("Cover Art cannot be created using this method");
        ARTWORK_CANNOT_BE_RETRIEVED_WITH_THIS_METHOD = new ErrorMessage("Cover Art cannot be retrieved using this method");
        GENERIC_NOT_SUPPORTED = new ErrorMessage("Not implemented for this format");
        OPERATION_NOT_SUPPORTED_FOR_FIELD = new ErrorMessage("Not available for this field {0}");
        ID3_UNABLE_TO_DECOMPRESS_FRAME = new ErrorMessage("Unable to decompress frame {0} in file {1} because {2}");
        NO_WRITER_FOR_THIS_FORMAT = new ErrorMessage("No Writer associated with this extension:{0}");
        NO_READER_FOR_THIS_FORMAT = new ErrorMessage("No Reader associated with this extension:{0}");
        NO_DELETER_FOR_THIS_FORMAT = new ErrorMessage("No Deleter associated with this extension:{0}");
        UNABLE_TO_FIND_FILE = new ErrorMessage("Unable to find:{0}");
        NO_PERMISSIONS_TO_WRITE_TO_FILE = new ErrorMessage("Unable to write to:{0}");
        DO_NOT_KNOW_HOW_TO_CREATE_THIS_ATOM_TYPE = new ErrorMessage("DO not know how to create this atom type {0}");
        OGG_CONTAINS_ID3TAG = new ErrorMessage("Ogg File contains invalid ID3 Tag, skipping ID3 Tag of length:{0}");
        FLAC_CONTAINS_ID3TAG = new ErrorMessage("Flac File contains invalid ID3 Tag, skipping ID3 Tag of length:{0}");
        ADDITIONAL_MOOV_ATOM_AT_END_OF_MP4 = new ErrorMessage("Additional moov atom found at end of file starting at offset {0}");
        ATOM_LENGTH_LARGER_THAN_DATA = new ErrorMessage("The atom {0} states its data length to be {1} but there are only {2} bytes remaining in the file");
        INVALID_FIELD_FOR_ID3V1TAG = new ErrorMessage("Invalid field {0} for ID3v1 tag");
        NO_AUDIO_HEADER_FOUND = new ErrorMessage("No audio header found within {0}");
        NOT_STANDARD_MP$_GENRE = new ErrorMessage("This is not a standard genre value, use custom genre field instead");
        FLAC_NO_BLOCKTYPE = new ErrorMessage("Flac file has invalid block type {0}");
        ErrorMessage[] arrerrorMessage = new ErrorMessage[]{GENERAL_READ, MP4_FILE_NOT_CONTAINER, MP4_FILE_NOT_AUDIO, MP4_FILE_IS_VIDEO, MP4_UNABLE_TO_PRIME_FILE_FOR_WRITE_SAFETLY, MP4_FILE_CONTAINS_MULTIPLE_DATA_ATOMS, MP4_CHANGES_TO_FILE_FAILED, MP4_CHANGES_TO_FILE_FAILED_NO_DATA, MP4_CHANGES_TO_FILE_FAILED_DATA_CORRUPT, MP4_CHANGES_TO_FILE_FAILED_NO_TAG_DATA, MP4_CHANGES_TO_FILE_FAILED_INCORRECT_OFFSETS, MP4_CHANGES_TO_FILE_FAILED_INCORRECT_NUMBER_OF_TRACKS, MP4_CHANGES_TO_FILE_FAILED_CANNOT_FIND_AUDIO, FLAC_NO_FLAC_HEADER_FOUND, OGG_VORBIS_NO_VORBIS_HEADER_FOUND, MP4_REVERSE_DNS_FIELD_HAS_NO_DATA, MP4_UNABLE_READ_REVERSE_DNS_FIELD, OGG_VORBIS_NO_FRAMING_BIT, GENERAL_GET_CREATION_TIME_FAILED, GENERAL_SET_CREATION_TIME_FAILED, GENERAL_WRITE_FAILED, GENERAL_WRITE_FAILED_FILE_LOCKED, GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL, GENERAL_WRITE_FAILED_TO_DELETE_ORIGINAL_FILE, GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE, GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_FILE_TO_BACKUP, GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_BACKUP_TO_ORIGINAL, GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST, GENERAL_WRITE_FAILED_BECAUSE, GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND, GENERAL_WRITE_WARNING_UNABLE_TO_DELETE_BACKUP_FILE, GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE, GENERAL_DELETE_FAILED, GENERAL_DELETE_FAILED_FILE_LOCKED, GENERAL_DELETE_FAILED_BECAUSE_FILE_IS_TOO_SMALL, MP3_ID3TAG_LENGTH_INCORRECT, MP3_RECALCULATED_POSSIBLE_START_OF_MP3_AUDIO, MP3_RECALCULATED_START_OF_MP3_AUDIO, MP3_START_OF_AUDIO_CONFIRMED, MP3_URL_SAVED_ENCODED, MP3_UNABLE_TO_ENCODE_URL, MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_IDENTIFIER_IS_INVALID, MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_LENGTH_IS_INVALID, GENERAL_INVALID_NULL_ARGUMENT, MP4_NO_GENREID_FOR_GENRE, MP4_GENRE_OUT_OF_RANGE, MP3_PICTURE_TYPE_INVALID, MP3_REFERENCE_KEY_INVALID, MP3_UNABLE_TO_ADJUST_PADDING, GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE, GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER, GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER, GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING, NULL_PADDING_FOUND_AT_END_OF_MP4, OGG_VORBIS_NO_SETUP_BLOCK, OGG_HEADER_CANNOT_BE_FOUND, GENERAL_READ_FAILED_UNABLE_TO_CLOSE_RANDOM_ACCESS_FILE, GENERAL_READ_FAILED_FILE_TOO_SMALL, GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE, ASF_FILE_HEADER_SIZE_DOES_NOT_MATCH_FILE_SIZE, ASF_FILE_HEADER_MISSING, ASF_HEADER_MISSING, GENERAL_UNIDENITIFED_IMAGE_FORMAT, MP4_IMAGE_FORMAT_IS_NOT_TO_EXPECTED_TYPE, MP3_FRAME_IS_COMPRESSED, MP3_FRAME_IS_ENCRYPTED, MP3_FRAME_IS_GROUPED, MP3_FRAME_IS_UNSYNCHRONISED, MP3_FRAME_IS_DATA_LENGTH_INDICATOR, MP4_FILE_HAS_NO_METADATA, MP4_FILE_META_ATOM_CHILD_DATA_NOT_NULL, WMA_INVALID_FIELD_NAME, WMA_INVALID_LANGUAGE_USE, WMA_INVALID_STREAM_REFERNCE, WMA_INVALID_GUID_USE, WMA_LENGTH_OF_DATA_IS_TOO_LARGE, WMA_LENGTH_OF_LANGUAGE_IS_TOO_LARGE, WMA_LENGTH_OF_STRING_IS_TOO_LARGE, WMA_ONLY_STRING_IN_CD, ID3_EXTENDED_HEADER_SIZE_INVALID, ID3_EXTENDED_HEADER_SIZE_TOO_SMALL, ID3_INVALID_OR_UNKNOWN_FLAG_SET, ID3_TAG_UNSYNCHRONIZED, ID3_TAG_EXPERIMENTAL, ID3_TAG_FOOTER, ID3_TAG_EXTENDED, ID3_TAG_CRC, ID3_TAG_COMPRESSED, ID3_TAG_CRC_SIZE, ID3_TAG_PADDING_SIZE, ID_TAG_SIZE, ID3_TAG_CRC_FLAG_SET_INCORRECTLY, MP4_CANNOT_FIND_AUDIO, VORBIS_COMMENT_LENGTH_TOO_LARGE, VORBIS_COMMENT_LENGTH_LARGE_THAN_HEADER, ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD, ARTWORK_CANNOT_BE_RETRIEVED_WITH_THIS_METHOD, GENERIC_NOT_SUPPORTED, OPERATION_NOT_SUPPORTED_FOR_FIELD, ID3_UNABLE_TO_DECOMPRESS_FRAME, NO_WRITER_FOR_THIS_FORMAT, NO_READER_FOR_THIS_FORMAT, NO_DELETER_FOR_THIS_FORMAT, UNABLE_TO_FIND_FILE, NO_PERMISSIONS_TO_WRITE_TO_FILE, DO_NOT_KNOW_HOW_TO_CREATE_THIS_ATOM_TYPE, OGG_CONTAINS_ID3TAG, FLAC_CONTAINS_ID3TAG, ADDITIONAL_MOOV_ATOM_AT_END_OF_MP4, ATOM_LENGTH_LARGER_THAN_DATA, INVALID_FIELD_FOR_ID3V1TAG, NO_AUDIO_HEADER_FOUND, NOT_STANDARD_MP$_GENRE, FLAC_NO_BLOCKTYPE};
        $VALUES = arrerrorMessage;
    }

    private ErrorMessage(String string3) {
        this.msg = string3;
    }

    public static ErrorMessage valueOf(String string2) {
        return (ErrorMessage)Enum.valueOf(ErrorMessage.class, (String)string2);
    }

    public static ErrorMessage[] values() {
        return (ErrorMessage[])$VALUES.clone();
    }

    public String getMsg() {
        return this.msg;
    }

    public /* varargs */ String getMsg(Object ... arrobject) {
        return MessageFormat.format((String)this.getMsg(), (Object[])arrobject);
    }
}

