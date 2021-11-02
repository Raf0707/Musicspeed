/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.jaudiotagger.audio.asf.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.audio.asf.data.GUIDFormatException;
import org.jaudiotagger.audio.asf.util.Utils;

public final class GUID {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final GUID GUID_AUDIOSTREAM;
    public static final GUID GUID_AUDIO_ERROR_CONCEALEMENT_ABSENT;
    public static final GUID GUID_AUDIO_ERROR_CONCEALEMENT_INTERLEAVED;
    public static final GUID GUID_CONTENTDESCRIPTION;
    public static final GUID GUID_CONTENT_BRANDING;
    public static final GUID GUID_CONTENT_ENCRYPTION;
    public static final GUID GUID_ENCODING;
    public static final GUID GUID_EXTENDED_CONTENT_DESCRIPTION;
    public static final GUID GUID_FILE;
    public static final GUID GUID_HEADER;
    public static final GUID GUID_HEADER_EXTENSION;
    public static final GUID GUID_LANGUAGE_LIST;
    public static final int GUID_LENGTH = 16;
    public static final GUID GUID_METADATA;
    public static final GUID GUID_METADATA_LIBRARY;
    private static final Pattern GUID_PATTERN;
    public static final GUID GUID_STREAM;
    public static final GUID GUID_STREAM_BITRATE_PROPERTIES;
    private static final Map<GUID, GUID> GUID_TO_CONFIGURED;
    public static final GUID GUID_UNSPECIFIED;
    public static final GUID GUID_VIDEOSTREAM;
    public static final GUID[] KNOWN_GUIDS;
    public static final GUID SCRIPT_COMMAND_OBJECT;
    private String description = "";
    private int[] guidData = null;
    private int hash;

    static {
        GUID gUID;
        GUID gUID2;
        GUID gUID3;
        GUID gUID4;
        GUID gUID5;
        GUID gUID6;
        GUID gUID7;
        GUID gUID8;
        GUID gUID9;
        GUID gUID10;
        GUID gUID11;
        GUID gUID12;
        GUID gUID13;
        GUID gUID14;
        GUID gUID15;
        GUID gUID16;
        GUID gUID17;
        GUID gUID18;
        GUID_AUDIO_ERROR_CONCEALEMENT_ABSENT = gUID12 = new GUID(new int[]{64, 164, 241, 73, 206, 78, 208, 17, 163, 172, 0, 160, 201, 3, 72, 246}, "Audio error concealment absent.");
        GUID_AUDIO_ERROR_CONCEALEMENT_INTERLEAVED = new GUID(new int[]{64, 164, 241, 73, 206, 78, 208, 17, 163, 172, 0, 160, 201, 3, 72, 246}, "Interleaved audio error concealment.");
        GUID_AUDIOSTREAM = gUID15 = new GUID(new int[]{64, 158, 105, 248, 77, 91, 207, 17, 168, 253, 0, 128, 95, 92, 68, 43}, " Audio stream");
        GUID_CONTENT_BRANDING = gUID = new GUID(new int[]{250, 179, 17, 34, 35, 189, 210, 17, 180, 183, 0, 160, 201, 85, 252, 110}, "Content Branding");
        GUID_CONTENT_ENCRYPTION = gUID11 = new GUID(new int[]{251, 179, 17, 34, 35, 189, 210, 17, 180, 183, 0, 160, 201, 85, 252, 110}, "Content Encryption Object");
        GUID_CONTENTDESCRIPTION = gUID3 = new GUID(new int[]{51, 38, 178, 117, 142, 102, 207, 17, 166, 217, 0, 170, 0, 98, 206, 108}, "Content Description");
        GUID_ENCODING = gUID17 = new GUID(new int[]{64, 82, 209, 134, 29, 49, 208, 17, 163, 164, 0, 160, 201, 3, 72, 246}, "Encoding description");
        GUID_EXTENDED_CONTENT_DESCRIPTION = gUID10 = new GUID(new int[]{64, 164, 208, 210, 7, 227, 210, 17, 151, 240, 0, 160, 201, 94, 168, 80}, "Extended Content Description");
        GUID_FILE = gUID8 = new GUID(new int[]{161, 220, 171, 140, 71, 169, 207, 17, 142, 228, 0, 192, 12, 32, 83, 101}, "File header");
        GUID_HEADER = gUID16 = new GUID(new int[]{48, 38, 178, 117, 142, 102, 207, 17, 166, 217, 0, 170, 0, 98, 206, 108}, "Asf header");
        GUID_HEADER_EXTENSION = gUID13 = new GUID(new int[]{181, 3, 191, 95, 46, 169, 207, 17, 142, 227, 0, 192, 12, 32, 83, 101}, "Header Extension");
        GUID_LANGUAGE_LIST = gUID4 = new GUID(new int[]{169, 70, 67, 124, 224, 239, 252, 75, 178, 41, 57, 62, 222, 65, 92, 133}, "Language List");
        GUID_METADATA = gUID9 = new GUID(new int[]{234, 203, 248, 197, 175, 91, 119, 72, 132, 103, 170, 140, 68, 250, 76, 202}, "Metadata");
        GUID_METADATA_LIBRARY = gUID5 = new GUID(new int[]{148, 28, 35, 68, 152, 148, 209, 73, 161, 65, 29, 19, 78, 69, 112, 84}, "Metadata Library");
        GUID_PATTERN = Pattern.compile((String)"[a-f0-9]{8}\\-[a-f0-9]{4}\\-[a-f0-9]{4}\\-[a-f0-9]{4}\\-[a-f0-9]{12}", (int)2);
        GUID_STREAM = gUID2 = new GUID(new int[]{145, 7, 220, 183, 183, 169, 207, 17, 142, 230, 0, 192, 12, 32, 83, 101}, "Stream");
        GUID_STREAM_BITRATE_PROPERTIES = gUID18 = new GUID(new int[]{206, 117, 248, 123, 141, 70, 209, 17, 141, 130, 0, 96, 151, 201, 162, 178}, "Stream bitrate properties");
        GUID_UNSPECIFIED = gUID14 = new GUID(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "Unspecified");
        GUID_VIDEOSTREAM = gUID6 = new GUID(new int[]{192, 239, 25, 188, 77, 91, 207, 17, 168, 253, 0, 128, 95, 92, 68, 43}, "Video stream");
        SCRIPT_COMMAND_OBJECT = gUID7 = new GUID(new int[]{48, 26, 251, 30, 98, 11, 208, 17, 163, 155, 0, 160, 201, 3, 72, 246}, "Script Command Object");
        GUID[] arrgUID = new GUID[18];
        arrgUID[0] = gUID12;
        arrgUID[1] = gUID3;
        arrgUID[2] = gUID15;
        arrgUID[3] = gUID17;
        arrgUID[4] = gUID8;
        arrgUID[5] = gUID16;
        arrgUID[6] = gUID2;
        arrgUID[7] = gUID10;
        arrgUID[8] = gUID6;
        arrgUID[9] = gUID13;
        arrgUID[10] = gUID18;
        arrgUID[11] = gUID7;
        arrgUID[12] = gUID11;
        arrgUID[13] = gUID;
        arrgUID[14] = gUID14;
        arrgUID[15] = gUID5;
        arrgUID[16] = gUID9;
        arrgUID[17] = gUID4;
        KNOWN_GUIDS = arrgUID;
        GUID_TO_CONFIGURED = new HashMap(arrgUID.length);
        for (GUID gUID19 : arrgUID) {
            GUID_TO_CONFIGURED.put((Object)gUID19, (Object)gUID19);
        }
    }

    public GUID(String string2, String string3) {
        this(GUID.parseGUID(string2).getGUID());
        if (string3 != null) {
            this.description = string3;
            return;
        }
        throw new IllegalArgumentException("Argument must not be null.");
    }

    public GUID(byte[] arrby) {
        int[] arrn = new int[arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrn[i2] = 255 & arrby[i2];
        }
        this.setGUID(arrn);
    }

    public GUID(int[] arrn) {
        this.setGUID(arrn);
    }

    public GUID(int[] arrn, String string2) {
        this(arrn);
        if (string2 != null) {
            this.description = string2;
            return;
        }
        throw new IllegalArgumentException("Argument must not be null.");
    }

    public static boolean assertGUID(int[] arrn) {
        return arrn != null && arrn.length == 16;
    }

    public static GUID getConfigured(GUID gUID) {
        return (GUID)GUID_TO_CONFIGURED.get((Object)gUID);
    }

    public static String getGuidDescription(GUID gUID) {
        if (gUID != null) {
            if (GUID.getConfigured(gUID) != null) {
                return GUID.getConfigured(gUID).getDescription();
            }
            return null;
        }
        throw new IllegalArgumentException("Argument must not be null.");
    }

    private String[] getHex(byte[] arrby) {
        String[] arrstring = new String[arrby.length];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(Integer.toHexString((int)(255 & arrby[i2])));
            if (stringBuilder.length() == 1) {
                stringBuilder.insert(0, "0");
            }
            arrstring[i2] = stringBuilder.toString();
        }
        return arrstring;
    }

    public static GUID parseGUID(String string2) throws GUIDFormatException {
        if (string2 != null) {
            if (GUID_PATTERN.matcher((CharSequence)string2).matches()) {
                int[] arrn = new int[16];
                int[] arrn2 = new int[]{3, 2, 1, 0, 5, 4, 7, 6, 8, 9, 10, 11, 12, 13, 14, 15};
                int n2 = 0;
                for (int i2 = 0; i2 < string2.length(); ++i2) {
                    if (string2.charAt(i2) == '-') continue;
                    int n3 = n2 + 1;
                    arrn[arrn2[n2]] = Integer.parseInt((String)string2.substring(i2, i2 + 2), (int)16);
                    ++i2;
                    n2 = n3;
                }
                return new GUID(arrn);
            }
            throw new GUIDFormatException("Invalid guidData format.");
        }
        throw new GUIDFormatException("null");
    }

    private void setGUID(int[] arrn) {
        if (GUID.assertGUID(arrn)) {
            int[] arrn2 = new int[16];
            this.guidData = arrn2;
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)16);
            return;
        }
        throw new IllegalArgumentException("The given guidData doesn't match the GUID specification.");
    }

    public boolean equals(Object object) {
        if (object instanceof GUID) {
            GUID gUID = (GUID)object;
            return Arrays.equals((int[])this.getGUID(), (int[])gUID.getGUID());
        }
        return false;
    }

    public byte[] getBytes() {
        int n2 = this.guidData.length;
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrby[i2] = (byte)(255 & this.guidData[i2]);
        }
        return arrby;
    }

    public String getDescription() {
        return this.description;
    }

    public int[] getGUID() {
        int[] arrn = this.guidData;
        int[] arrn2 = new int[arrn.length];
        System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
        return arrn2;
    }

    public int hashCode() {
        if (this.hash == -1) {
            int[] arrn = this.getGUID();
            int n2 = arrn.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                n3 = arrn[i2] + n3 * 31;
            }
            this.hash = n3;
        }
        return this.hash;
    }

    public boolean isValid() {
        return GUID.assertGUID(this.getGUID());
    }

    public String prettyPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getDescription();
        if (Utils.isBlank(string2)) {
            string2 = GUID.getGuidDescription(this);
        }
        if (!Utils.isBlank(string2)) {
            stringBuilder.append("Description: ");
            stringBuilder.append(string2);
            stringBuilder.append(Utils.LINE_SEPARATOR);
            stringBuilder.append("   ");
        }
        stringBuilder.append(this.toString());
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arrstring = this.getHex(this.getBytes());
        stringBuilder.append(arrstring[3]);
        stringBuilder.append(arrstring[2]);
        stringBuilder.append(arrstring[1]);
        stringBuilder.append(arrstring[0]);
        stringBuilder.append('-');
        stringBuilder.append(arrstring[5]);
        stringBuilder.append(arrstring[4]);
        stringBuilder.append('-');
        stringBuilder.append(arrstring[7]);
        stringBuilder.append(arrstring[6]);
        stringBuilder.append('-');
        stringBuilder.append(arrstring[8]);
        stringBuilder.append(arrstring[9]);
        stringBuilder.append('-');
        stringBuilder.append(arrstring[10]);
        stringBuilder.append(arrstring[11]);
        stringBuilder.append(arrstring[12]);
        stringBuilder.append(arrstring[13]);
        stringBuilder.append(arrstring[14]);
        stringBuilder.append(arrstring[15]);
        return stringBuilder.toString();
    }
}

