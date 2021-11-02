/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.mp3;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.logging.AbstractTagDisplayFormatter;

public class MPEGFrameHeader {
    private static final int BYTE_1 = 0;
    private static final int BYTE_2 = 1;
    private static final int BYTE_3 = 2;
    private static final int BYTE_4 = 3;
    public static final int EMPHASIS_5015MS = 1;
    public static final int EMPHASIS_CCITT = 3;
    public static final int EMPHASIS_NONE = 0;
    public static final int EMPHASIS_RESERVED = 2;
    public static final int HEADER_SIZE = 4;
    public static final int LAYER_I = 3;
    public static final int LAYER_II = 2;
    public static final int LAYER_III = 1;
    private static final int LAYER_III_FRAME_SIZE_COEFFICIENT = 144;
    public static final int LAYER_III_SLOT_SIZE = 1;
    private static final int LAYER_II_FRAME_SIZE_COEFFICIENT = 144;
    public static final int LAYER_II_SLOT_SIZE = 1;
    private static final int LAYER_I_FRAME_SIZE_COEFFICIENT = 12;
    public static final int LAYER_I_SLOT_SIZE = 4;
    private static final int MASK_MP3_BITRATE = 240;
    private static final int MASK_MP3_COPY = 8;
    private static final int MASK_MP3_EMPHASIS = 3;
    private static final int MASK_MP3_FREQUENCY = 12;
    private static final int MASK_MP3_HOME = 4;
    private static final int MASK_MP3_ID = 8;
    private static final int MASK_MP3_LAYER = 6;
    private static final int MASK_MP3_MODE = 192;
    private static final int MASK_MP3_MODE_EXTENSION = 48;
    private static final int MASK_MP3_PADDING = 2;
    private static final int MASK_MP3_PRIVACY = 1;
    private static final int MASK_MP3_PROTECTION = 1;
    private static final int MASK_MP3_VERSION = 24;
    public static final int MODE_DUAL_CHANNEL = 2;
    private static final int MODE_EXTENSION_NONE = 0;
    private static final int MODE_EXTENSION_OFF_OFF = 0;
    private static final int MODE_EXTENSION_OFF_ON = 2;
    private static final int MODE_EXTENSION_ONE = 1;
    private static final int MODE_EXTENSION_ON_OFF = 1;
    private static final int MODE_EXTENSION_ON_ON = 3;
    private static final int MODE_EXTENSION_THREE = 3;
    private static final int MODE_EXTENSION_TWO = 2;
    public static final int MODE_JOINT_STEREO = 1;
    public static final int MODE_MONO = 3;
    public static final int MODE_STEREO = 0;
    private static final int SCALE_BY_THOUSAND = 1000;
    public static final int SYNC_BIT_ANDSAMPING_BYTE3 = 252;
    public static final int SYNC_BYTE1 = 255;
    public static final int SYNC_BYTE2 = 224;
    public static final int SYNC_SIZE = 2;
    public static final int VERSION_1 = 3;
    public static final int VERSION_2 = 2;
    public static final int VERSION_2_5;
    private static final Map<Integer, Integer> bitrateMap;
    private static final Map<Integer, String> emphasisMap;
    private static final byte[] header;
    private static final Map<Integer, String> modeExtensionLayerIIIMap;
    private static final Map<Integer, String> modeExtensionMap;
    public static final Map<Integer, String> modeMap;
    public static final Map<Integer, String> mpegLayerMap;
    public static final Map<Integer, String> mpegVersionMap;
    private static final Map<Integer, Map<Integer, Integer>> samplesPerFrameMap;
    private static final Map<Integer, Integer> samplesPerFrameV1Map;
    private static final Map<Integer, Integer> samplesPerFrameV25Map;
    private static final Map<Integer, Integer> samplesPerFrameV2Map;
    private static final Map<Integer, Map<Integer, Integer>> samplingRateMap;
    private static final Map<Integer, Integer> samplingV1Map;
    private static final Map<Integer, Integer> samplingV25Map;
    private static final Map<Integer, Integer> samplingV2Map;
    private Integer bitRate;
    private int channelMode;
    private String channelModeAsString;
    private int emphasis;
    private String emphasisAsString;
    private boolean isCopyrighted;
    private boolean isOriginal;
    private boolean isPadding;
    private boolean isPrivate;
    private boolean isProtected;
    private int layer;
    private String layerAsString;
    private String modeExtension;
    private byte[] mpegBytes;
    private Integer samplingRate;
    private int version;
    private String versionAsString;

    static {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        HashMap hashMap6;
        HashMap hashMap7;
        HashMap hashMap8;
        HashMap hashMap9;
        HashMap hashMap10;
        HashMap hashMap11;
        HashMap hashMap12;
        HashMap hashMap13;
        HashMap hashMap14;
        HashMap hashMap15;
        header = new byte[4];
        mpegVersionMap = hashMap10 = new HashMap();
        Integer n2 = 0;
        hashMap10.put((Object)n2, (Object)"MPEG-2.5");
        Integer n3 = 2;
        hashMap10.put((Object)n3, (Object)"MPEG-2");
        Integer n4 = 3;
        hashMap10.put((Object)n4, (Object)"MPEG-1");
        mpegLayerMap = hashMap8 = new HashMap();
        hashMap8.put((Object)n4, (Object)"Layer 1");
        hashMap8.put((Object)n3, (Object)"Layer 2");
        Integer n5 = 1;
        hashMap8.put((Object)n5, (Object)"Layer 3");
        bitrateMap = hashMap6 = new HashMap();
        Integer n6 = 30;
        Integer n7 = 32;
        hashMap6.put((Object)n6, (Object)n7);
        Integer n8 = 46;
        Integer n9 = 64;
        hashMap6.put((Object)n8, (Object)n9);
        Integer n10 = 62;
        Integer n11 = 96;
        hashMap6.put((Object)n10, (Object)n11);
        Integer n12 = 78;
        Integer n13 = 128;
        hashMap6.put((Object)n12, (Object)n13);
        Integer n14 = 94;
        Integer n15 = 160;
        hashMap6.put((Object)n14, (Object)n15);
        hashMap6.put((Object)110, (Object)192);
        hashMap6.put((Object)126, (Object)224);
        hashMap6.put((Object)142, (Object)256);
        hashMap6.put((Object)158, (Object)288);
        hashMap6.put((Object)174, (Object)320);
        hashMap6.put((Object)190, (Object)352);
        Integer n16 = 206;
        Integer n17 = 384;
        hashMap6.put((Object)n16, (Object)n17);
        hashMap6.put((Object)222, (Object)416);
        hashMap6.put((Object)238, (Object)448);
        hashMap6.put((Object)28, (Object)n7);
        Integer n18 = 44;
        Integer n19 = 48;
        hashMap6.put((Object)n18, (Object)n19);
        Integer n20 = 60;
        Integer n21 = 56;
        hashMap6.put((Object)n20, (Object)n21);
        hashMap6.put((Object)76, (Object)n9);
        Integer n22 = 92;
        Integer n23 = 80;
        hashMap6.put((Object)n22, (Object)n23);
        hashMap6.put((Object)108, (Object)n11);
        Integer n24 = 124;
        Integer n25 = 112;
        hashMap6.put((Object)n24, (Object)n25);
        hashMap6.put((Object)140, (Object)n13);
        hashMap6.put((Object)156, (Object)n15);
        hashMap6.put((Object)172, (Object)192);
        hashMap6.put((Object)188, (Object)224);
        hashMap6.put((Object)204, (Object)256);
        hashMap6.put((Object)220, (Object)320);
        hashMap6.put((Object)236, (Object)n17);
        hashMap6.put((Object)26, (Object)n7);
        hashMap6.put((Object)42, (Object)40);
        hashMap6.put((Object)58, (Object)n19);
        hashMap6.put((Object)74, (Object)n21);
        hashMap6.put((Object)90, (Object)n9);
        hashMap6.put((Object)106, (Object)n23);
        hashMap6.put((Object)122, (Object)n11);
        hashMap6.put((Object)138, (Object)n25);
        hashMap6.put((Object)154, (Object)n13);
        hashMap6.put((Object)170, (Object)n15);
        hashMap6.put((Object)186, (Object)192);
        hashMap6.put((Object)202, (Object)224);
        hashMap6.put((Object)218, (Object)256);
        hashMap6.put((Object)234, (Object)320);
        hashMap6.put((Object)22, (Object)n7);
        hashMap6.put((Object)38, (Object)n19);
        hashMap6.put((Object)54, (Object)n21);
        hashMap6.put((Object)70, (Object)n9);
        hashMap6.put((Object)86, (Object)n23);
        hashMap6.put((Object)102, (Object)n11);
        hashMap6.put((Object)118, (Object)n25);
        hashMap6.put((Object)134, (Object)n13);
        hashMap6.put((Object)150, (Object)144);
        hashMap6.put((Object)166, (Object)n15);
        hashMap6.put((Object)182, (Object)176);
        hashMap6.put((Object)198, (Object)192);
        hashMap6.put((Object)214, (Object)224);
        hashMap6.put((Object)230, (Object)256);
        hashMap6.put((Object)20, (Object)8);
        hashMap6.put((Object)36, (Object)16);
        hashMap6.put((Object)52, (Object)24);
        hashMap6.put((Object)68, (Object)n7);
        hashMap6.put((Object)84, (Object)40);
        hashMap6.put((Object)100, (Object)n19);
        hashMap6.put((Object)116, (Object)n21);
        hashMap6.put((Object)132, (Object)n9);
        hashMap6.put((Object)148, (Object)n23);
        hashMap6.put((Object)164, (Object)n11);
        hashMap6.put((Object)180, (Object)n25);
        hashMap6.put((Object)196, (Object)n13);
        hashMap6.put((Object)212, (Object)144);
        hashMap6.put((Object)228, (Object)n15);
        hashMap6.put((Object)18, (Object)8);
        hashMap6.put((Object)34, (Object)16);
        hashMap6.put((Object)50, (Object)24);
        hashMap6.put((Object)66, (Object)n7);
        hashMap6.put((Object)82, (Object)40);
        hashMap6.put((Object)98, (Object)n19);
        hashMap6.put((Object)114, (Object)n21);
        hashMap6.put((Object)130, (Object)n9);
        hashMap6.put((Object)146, (Object)n23);
        hashMap6.put((Object)162, (Object)n11);
        hashMap6.put((Object)178, (Object)n25);
        hashMap6.put((Object)194, (Object)n13);
        hashMap6.put((Object)210, (Object)144);
        hashMap6.put((Object)226, (Object)n15);
        modeMap = hashMap4 = new HashMap();
        hashMap4.put((Object)n2, (Object)"Stereo");
        hashMap4.put((Object)n5, (Object)"Joint Stereo");
        hashMap4.put((Object)n3, (Object)"Dual");
        hashMap4.put((Object)n4, (Object)"Mono");
        emphasisMap = hashMap9 = new HashMap();
        hashMap9.put((Object)n2, (Object)"None");
        hashMap9.put((Object)n5, (Object)"5015MS");
        hashMap9.put((Object)n3, (Object)"Reserved");
        hashMap9.put((Object)n4, (Object)"CCITT");
        modeExtensionMap = hashMap3 = new HashMap();
        modeExtensionLayerIIIMap = hashMap = new HashMap();
        hashMap3.put((Object)n2, (Object)"4-31");
        hashMap3.put((Object)n5, (Object)"8-31");
        hashMap3.put((Object)n3, (Object)"12-31");
        hashMap3.put((Object)n4, (Object)"16-31");
        hashMap.put((Object)n2, (Object)"off-off");
        hashMap.put((Object)n5, (Object)"on-off");
        hashMap.put((Object)n3, (Object)"off-on");
        hashMap.put((Object)n4, (Object)"on-on");
        samplingRateMap = hashMap15 = new HashMap();
        samplingV1Map = hashMap7 = new HashMap();
        samplingV2Map = hashMap2 = new HashMap();
        samplingV25Map = hashMap13 = new HashMap();
        hashMap7.put((Object)n2, (Object)44100);
        hashMap7.put((Object)n5, (Object)48000);
        hashMap7.put((Object)n3, (Object)32000);
        hashMap2.put((Object)n2, (Object)22050);
        hashMap2.put((Object)n5, (Object)24000);
        hashMap2.put((Object)n3, (Object)16000);
        hashMap13.put((Object)n2, (Object)11025);
        hashMap13.put((Object)n5, (Object)12000);
        hashMap13.put((Object)n3, (Object)8000);
        hashMap15.put((Object)n4, (Object)hashMap7);
        hashMap15.put((Object)n3, (Object)hashMap2);
        hashMap15.put((Object)n2, (Object)hashMap13);
        samplesPerFrameMap = hashMap11 = new HashMap();
        samplesPerFrameV1Map = hashMap14 = new HashMap();
        samplesPerFrameV2Map = hashMap5 = new HashMap();
        samplesPerFrameV25Map = hashMap12 = new HashMap();
        hashMap14.put((Object)n4, (Object)n17);
        Integer n26 = 1152;
        hashMap14.put((Object)n3, (Object)n26);
        hashMap14.put((Object)n5, (Object)n26);
        hashMap5.put((Object)n4, (Object)n17);
        hashMap5.put((Object)n3, (Object)n26);
        hashMap5.put((Object)n5, (Object)n26);
        hashMap12.put((Object)n4, (Object)n17);
        hashMap12.put((Object)n3, (Object)n26);
        hashMap12.put((Object)n5, (Object)n26);
        hashMap11.put((Object)n4, (Object)hashMap14);
        hashMap11.put((Object)n3, (Object)hashMap5);
        hashMap11.put((Object)n2, (Object)hashMap12);
    }

    private MPEGFrameHeader() throws InvalidAudioFrameException {
    }

    private MPEGFrameHeader(byte[] arrby) throws InvalidAudioFrameException {
        this.mpegBytes = arrby;
        this.setBitrate();
        this.setVersion();
        this.setLayer();
        this.setProtected();
        this.setSamplingRate();
        this.setPadding();
        this.setPrivate();
        this.setChannelMode();
        this.setModeExtension();
        this.setCopyrighted();
        this.setOriginal();
        this.setEmphasis();
    }

    public static boolean isMPEGFrame(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.position();
        return (255 & byteBuffer.get(n2)) == 255 && (224 & byteBuffer.get(n2 + 1)) == 224 && (252 & byteBuffer.get(n2 + 2)) != 252;
    }

    public static MPEGFrameHeader parseMPEGHeader(ByteBuffer byteBuffer) throws InvalidAudioFrameException {
        int n2 = byteBuffer.position();
        byte[] arrby = header;
        byteBuffer.get(arrby, 0, 4);
        byteBuffer.position(n2);
        return new MPEGFrameHeader(arrby);
    }

    private void setBitrate() throws InvalidAudioFrameException {
        Integer n2;
        byte[] arrby = this.mpegBytes;
        int n3 = 240 & arrby[2] | 8 & arrby[1] | 6 & arrby[1];
        this.bitRate = n2 = (Integer)bitrateMap.get((Object)n3);
        if (n2 != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid bitrate");
    }

    private void setChannelMode() throws InvalidAudioFrameException {
        String string2;
        int n2;
        this.channelMode = n2 = (192 & this.mpegBytes[3]) >>> 6;
        this.channelModeAsString = string2 = (String)modeMap.get((Object)n2);
        if (string2 != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid channel mode");
    }

    private void setCopyrighted() {
        boolean bl = (8 & this.mpegBytes[3]) != 0;
        this.isCopyrighted = bl;
    }

    private void setEmphasis() throws InvalidAudioFrameException {
        int n2;
        this.emphasis = n2 = 3 & this.mpegBytes[3];
        this.emphasisAsString = (String)emphasisMap.get((Object)n2);
        if (this.getEmphasisAsString() != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid emphasis");
    }

    private void setLayer() throws InvalidAudioFrameException {
        String string2;
        int n2;
        this.layer = n2 = (6 & this.mpegBytes[1]) >>> 1;
        this.layerAsString = string2 = (String)mpegLayerMap.get((Object)n2);
        if (string2 != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid Layer");
    }

    private void setModeExtension() throws InvalidAudioFrameException {
        int n2 = (48 & this.mpegBytes[3]) >> 4;
        if (this.layer == 1) {
            this.modeExtension = (String)modeExtensionLayerIIIMap.get((Object)n2);
            if (this.getModeExtension() != null) {
                return;
            }
            throw new InvalidAudioFrameException("Invalid Mode Extension");
        }
        this.modeExtension = (String)modeExtensionMap.get((Object)n2);
        if (this.getModeExtension() != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid Mode Extension");
    }

    private void setOriginal() {
        boolean bl = (4 & this.mpegBytes[3]) != 0;
        this.isOriginal = bl;
    }

    private void setPadding() {
        boolean bl = (2 & this.mpegBytes[2]) != 0;
        this.isPadding = bl;
    }

    private void setPrivate() {
        byte by = this.mpegBytes[2];
        byte by2 = 1;
        if ((by & by2) == 0) {
            by2 = 0;
        }
        this.isPrivate = by2;
    }

    private void setProtected() {
        int n2 = 1;
        byte[] arrby = this.mpegBytes;
        if ((n2 & arrby[n2]) != 0) {
            n2 = 0;
        }
        this.isProtected = n2;
    }

    private void setSamplingRate() throws InvalidAudioFrameException {
        int n2 = (12 & this.mpegBytes[2]) >>> 2;
        Map map = (Map)samplingRateMap.get((Object)this.version);
        if (map != null) {
            Integer n3;
            this.samplingRate = n3 = (Integer)map.get((Object)n2);
            if (n3 != null) {
                return;
            }
            throw new InvalidAudioFrameException("Invalid sampling rate");
        }
        throw new InvalidAudioFrameException("Invalid version");
    }

    private void setVersion() throws InvalidAudioFrameException {
        String string2;
        byte by = (byte)((24 & this.mpegBytes[1]) >> 3);
        this.version = by;
        this.versionAsString = string2 = (String)mpegVersionMap.get((Object)by);
        if (string2 != null) {
            return;
        }
        throw new InvalidAudioFrameException("Invalid mpeg version");
    }

    public Integer getBitRate() {
        return this.bitRate;
    }

    public int getChannelMode() {
        return this.channelMode;
    }

    public String getChannelModeAsString() {
        return this.channelModeAsString;
    }

    public int getEmphasis() {
        return this.emphasis;
    }

    public String getEmphasisAsString() {
        return this.emphasisAsString;
    }

    public int getFrameLength() {
        int n2 = this.version;
        if (n2 != 0 && n2 != 2) {
            if (n2 == 3) {
                int n3 = this.layer;
                if (n3 != 1) {
                    if (n3 != 2) {
                        if (n3 == 3) {
                            return 4 * (12 * (1000 * this.getBitRate()) / this.getSamplingRate() + this.getPaddingLength());
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Mp3 Unknown Layer:");
                        stringBuilder.append(this.layer);
                        throw new RuntimeException(stringBuilder.toString());
                    }
                    return 144 * (1000 * this.getBitRate()) / this.getSamplingRate() + 1 * this.getPaddingLength();
                }
                return 144 * (1000 * this.getBitRate()) / this.getSamplingRate() + 1 * this.getPaddingLength();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Mp3 Unknown Version:");
            stringBuilder.append(this.version);
            throw new RuntimeException(stringBuilder.toString());
        }
        int n4 = this.layer;
        if (n4 != 1) {
            if (n4 != 2) {
                if (n4 == 3) {
                    return 4 * (12 * (1000 * this.getBitRate()) / this.getSamplingRate() + this.getPaddingLength());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mp3 Unknown Layer:");
                stringBuilder.append(this.layer);
                throw new RuntimeException(stringBuilder.toString());
            }
            return 144 * (1000 * this.getBitRate()) / this.getSamplingRate() + 1 * this.getPaddingLength();
        }
        if (this.getChannelMode() == 3) {
            return 72 * (1000 * this.getBitRate()) / this.getSamplingRate() + 1 * this.getPaddingLength();
        }
        return 144 * (1000 * this.getBitRate()) / this.getSamplingRate() + 1 * this.getPaddingLength();
    }

    public int getLayer() {
        return this.layer;
    }

    public String getLayerAsString() {
        return this.layerAsString;
    }

    public String getModeExtension() {
        return this.modeExtension;
    }

    public int getNoOfSamples() {
        return (Integer)((Map)samplesPerFrameMap.get((Object)this.version)).get((Object)this.layer);
    }

    public int getNumberOfChannels() {
        int n2 = this.channelMode;
        if (n2 != 0 && n2 != 1 && n2 != 2) {
            return n2 == 3;
        }
        return 2;
    }

    public int getPaddingLength() {
        return this.isPadding();
    }

    public Integer getSamplingRate() {
        return this.samplingRate;
    }

    public int getVersion() {
        return this.version;
    }

    public String getVersionAsString() {
        return this.versionAsString;
    }

    public boolean isCopyrighted() {
        return this.isCopyrighted;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public boolean isPadding() {
        return this.isPadding;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public boolean isVariableBitRate() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" mpeg frameheader: frame length:");
        stringBuilder.append(this.getFrameLength());
        stringBuilder.append(" version:");
        stringBuilder.append(this.versionAsString);
        stringBuilder.append(" layer:");
        stringBuilder.append(this.layerAsString);
        stringBuilder.append(" channelMode:");
        stringBuilder.append(this.channelModeAsString);
        stringBuilder.append(" noOfSamples:");
        stringBuilder.append(this.getNoOfSamples());
        stringBuilder.append(" samplingRate:");
        stringBuilder.append((Object)this.samplingRate);
        stringBuilder.append(" isPadding:");
        stringBuilder.append(this.isPadding);
        stringBuilder.append(" isProtected:");
        stringBuilder.append(this.isProtected);
        stringBuilder.append(" isPrivate:");
        stringBuilder.append(this.isPrivate);
        stringBuilder.append(" isCopyrighted:");
        stringBuilder.append(this.isCopyrighted);
        stringBuilder.append(" isOriginal:");
        stringBuilder.append(this.isCopyrighted);
        stringBuilder.append(" isVariableBitRate");
        stringBuilder.append(this.isVariableBitRate());
        stringBuilder.append(" header as binary:");
        stringBuilder.append(AbstractTagDisplayFormatter.displayAsBinary(this.mpegBytes[0]));
        stringBuilder.append(" ");
        stringBuilder.append(AbstractTagDisplayFormatter.displayAsBinary(this.mpegBytes[1]));
        stringBuilder.append(" ");
        stringBuilder.append(AbstractTagDisplayFormatter.displayAsBinary(this.mpegBytes[2]));
        stringBuilder.append(" ");
        stringBuilder.append(AbstractTagDisplayFormatter.displayAsBinary(this.mpegBytes[3]));
        return stringBuilder.toString();
    }
}

