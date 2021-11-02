/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.EmptyFrameException;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidFrameIdentifierException;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3Compression;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.id3.ID3TextEncodingConversion;
import org.jaudiotagger.tag.id3.ID3v22Frame;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyDeprecated;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.utils.EqualsUtil;

public class ID3v23Frame
extends AbstractID3v2Frame {
    protected static final int FRAME_COMPRESSION_UNCOMPRESSED_SIZE = 4;
    protected static final int FRAME_ENCRYPTION_INDICATOR_SIZE = 1;
    protected static final int FRAME_FLAGS_SIZE = 2;
    protected static final int FRAME_GROUPING_INDICATOR_SIZE = 1;
    protected static final int FRAME_HEADER_SIZE = 10;
    protected static final int FRAME_ID_SIZE = 4;
    protected static final int FRAME_SIZE_SIZE = 4;
    private static Pattern validFrameIdentifier = Pattern.compile((String)"[A-Z][0-9A-Z]{3}");
    private int encryptionMethod;
    private int groupIdentifier;

    public ID3v23Frame() {
    }

    public ID3v23Frame(String string2) {
        super(string2);
        this.statusFlags = new AbstractID3v2Frame.StatusFlags(){
            public static final int MASK_FILE_ALTER_PRESERVATION = 64;
            public static final int MASK_READ_ONLY = 32;
            public static final int MASK_TAG_ALTER_PRESERVATION = 128;
            public static final String TYPE_FILEALTERPRESERVATION = "typeFileAlterPreservation";
            public static final String TYPE_READONLY = "typeReadOnly";
            public static final String TYPE_TAGALTERPRESERVATION = "typeTagAlterPreservation";
            {
                this.originalFlags = 0;
                this.writeFlags = 0;
            }
            {
                this.originalFlags = by;
                this.writeFlags = by;
                this.modifyFlags();
            }
            {
                byte by;
                super(ID3v23Frame.this);
                this.originalFlags = by = this.convertV4ToV3Flags(statusFlags.getOriginalFlags());
                this.writeFlags = by;
                this.modifyFlags();
            }

            private byte convertV4ToV3Flags(byte by) {
                byte by2 = (by & 32) != 0 ? (byte)64 : 0;
                if ((by & 64) != 0) {
                    by2 = (byte)(by2 | -128);
                }
                return by2;
            }

            @Override
            public void createStructure() {
                MP3File.getStructureFormatter().openHeadingElement("statusFlags", "");
                MP3File.getStructureFormatter().addElement(TYPE_TAGALTERPRESERVATION, 128 & this.originalFlags);
                MP3File.getStructureFormatter().addElement(TYPE_FILEALTERPRESERVATION, 64 & this.originalFlags);
                MP3File.getStructureFormatter().addElement(TYPE_READONLY, 32 & this.originalFlags);
                MP3File.getStructureFormatter().closeHeadingElement("statusFlags");
            }

            protected void modifyFlags() {
                byte by;
                String string2 = ID3v23Frame.this.getIdentifier();
                if (ID3v23Frames.getInstanceOf().isDiscardIfFileAltered(string2)) {
                    byte by2;
                    this.writeFlags = by2 = (byte)(64 | this.writeFlags);
                    this.writeFlags = (byte)(by2 & 127);
                    return;
                }
                this.writeFlags = by = (byte)(-65 & this.writeFlags);
                this.writeFlags = (byte)(by & 127);
            }
        };
        this.encodingFlags = new AbstractID3v2Frame.EncodingFlags(){
            public static final int MASK_COMPRESSION = 128;
            public static final int MASK_ENCRYPTION = 64;
            public static final int MASK_GROUPING_IDENTITY = 32;
            public static final String TYPE_COMPRESSION = "compression";
            public static final String TYPE_ENCRYPTION = "encryption";
            public static final String TYPE_GROUPIDENTITY = "groupidentity";
            {
                this.logEnabledFlags();
            }

            @Override
            public void createStructure() {
                MP3File.getStructureFormatter().openHeadingElement("encodingFlags", "");
                MP3File.getStructureFormatter().addElement(TYPE_COMPRESSION, 128 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_ENCRYPTION, 64 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_GROUPIDENTITY, 32 & this.flags);
                MP3File.getStructureFormatter().closeHeadingElement("encodingFlags");
            }

            public boolean isCompression() {
                return (128 & this.flags) > 0;
            }

            public boolean isEncryption() {
                return (64 & this.flags) > 0;
            }

            public boolean isGrouping() {
                return (32 & this.flags) > 0;
            }

            public boolean isNonStandardFlags() {
                byte by = this.flags;
                int n2 = by & 16;
                boolean bl = true;
                if (n2 <= 0 && (by & 8) <= 0 && (by & 4) <= 0 && (by & 2) <= 0) {
                    if ((by & bl) > 0) {
                        return bl;
                    }
                    bl = false;
                }
                return bl;
            }

            public void logEnabledFlags() {
                if (this.isNonStandardFlags()) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v23Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v23Frame.this.identifier);
                    stringBuilder.append(":Unknown Encoding Flags:");
                    stringBuilder.append(Hex.asHex(this.flags));
                    logger.warning(stringBuilder.toString());
                }
                if (this.isCompression()) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v23Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v23Frame.this.identifier);
                    stringBuilder.append(" is compressed");
                    logger.warning(stringBuilder.toString());
                }
                if (this.isEncryption()) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v23Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v23Frame.this.identifier);
                    stringBuilder.append(" is encrypted");
                    logger.warning(stringBuilder.toString());
                }
                if (this.isGrouping()) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v23Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v23Frame.this.identifier);
                    stringBuilder.append(" is grouped");
                    logger.warning(stringBuilder.toString());
                }
            }

            public void setCompression() {
                this.flags = (byte)(128 | this.flags);
            }

            public void setEncryption() {
                this.flags = (byte)(64 | this.flags);
            }

            public void setGrouping() {
                this.flags = (byte)(32 | this.flags);
            }

            public void unsetCompression() {
                this.flags = (byte)(127 & this.flags);
            }

            public void unsetEncryption() {
                this.flags = (byte)(-65 & this.flags);
            }

            public void unsetGrouping() {
                this.flags = (byte)(-33 & this.flags);
            }

            public void unsetNonStandardFlags() {
                if (this.isNonStandardFlags()) {
                    byte by;
                    byte by2;
                    byte by3;
                    byte by4;
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v23Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v23Frame.this.getIdentifier());
                    stringBuilder.append(":Unsetting Unknown Encoding Flags:");
                    stringBuilder.append(Hex.asHex(this.flags));
                    logger.warning(stringBuilder.toString());
                    this.flags = by3 = (byte)(-17 & this.flags);
                    this.flags = by2 = (byte)(by3 & -9);
                    this.flags = by4 = (byte)(by2 & -5);
                    this.flags = by = (byte)(by4 & -3);
                    this.flags = (byte)(by & -2);
                }
            }
        };
    }

    public ID3v23Frame(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        this(byteBuffer, "");
    }

    public ID3v23Frame(ByteBuffer byteBuffer, String string2) throws InvalidFrameException, InvalidDataTypeException {
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public ID3v23Frame(AbstractID3v2Frame var1_1) throws InvalidFrameException {
        super();
        AbstractTagItem.logger.finer("Creating frame from a frame of a different version");
        if (var1_1 instanceof ID3v23Frame != false) throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
        var2_2 = var1_1 instanceof ID3v22Frame;
        if (var2_2) {
            this.statusFlags = new /* invalid duplicate definition of identical inner class */;
            this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
        } else if (var1_1 instanceof ID3v24Frame) {
            this.statusFlags = new /* invalid duplicate definition of identical inner class */;
            this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
        }
        if (!(var1_1 instanceof ID3v24Frame)) ** GOTO lbl112
        if (var1_1.getBody() instanceof FrameBodyUnsupported) {
            var37_3 = new FrameBodyUnsupported((FrameBodyUnsupported)var1_1.getBody());
            this.frameBody = var37_3;
            var37_3.setHeader(this);
            this.identifier = var1_1.getIdentifier();
            var38_4 = AbstractTagItem.logger;
            var39_5 = new StringBuilder();
            var39_5.append("UNKNOWN:Orig id is:");
            var39_5.append(var1_1.getIdentifier());
            var39_5.append(":New id is:");
            var39_5.append(this.identifier);
            var38_4.config(var39_5.toString());
            return;
        }
        if (var1_1.getBody() instanceof FrameBodyDeprecated) {
            if (!ID3Tags.isID3v23FrameIdentifier(var1_1.getIdentifier())) {
                var80_10 = new FrameBodyDeprecated((FrameBodyDeprecated)var1_1.getBody());
                this.frameBody = var80_10;
                var80_10.setHeader(this);
                var81_11 = this.frameBody;
                var81_11.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this, var81_11.getTextEncoding()));
                this.identifier = var1_1.getIdentifier();
                var82_12 = AbstractTagItem.logger;
                var83_13 = new StringBuilder();
                var83_13.append("DEPRECATED:Orig id is:");
                var83_13.append(var1_1.getIdentifier());
                var83_13.append(":New id is:");
                var83_13.append(this.identifier);
                var82_12.config(var83_13.toString());
                return;
            }
            var88_6 = ((FrameBodyDeprecated)var1_1.getBody()).getOriginalFrameBody();
            this.frameBody = var88_6;
            var88_6.setHeader(this);
            var89_7 = this.frameBody;
            var89_7.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this, var89_7.getTextEncoding()));
            this.identifier = var1_1.getIdentifier();
            var90_8 = AbstractTagItem.logger;
            var91_9 = new StringBuilder();
            var91_9.append("DEPRECATED:Orig id is:");
            var91_9.append(var1_1.getIdentifier());
            var91_9.append(":New id is:");
            var91_9.append(this.identifier);
            var90_8.config(var91_9.toString());
        } else {
            if (!ID3Tags.isID3v24FrameIdentifier(var1_1.getIdentifier())) {
                var44_29 = AbstractTagItem.logger;
                var45_30 = new StringBuilder();
                var45_30.append("Orig id is:");
                var45_30.append(var1_1.getIdentifier());
                var45_30.append("Unable to create Frame Body");
                var44_29.severe(var45_30.toString());
                var49_31 = new StringBuilder();
                var49_31.append("Orig id is:");
                var49_31.append(var1_1.getIdentifier());
                var49_31.append("Unable to create Frame Body");
                throw new InvalidFrameException(var49_31.toString());
            }
            AbstractTagItem.logger.finer("isID3v24FrameIdentifier");
            this.identifier = var53_14 = ID3Tags.convertFrameID24To23(var1_1.getIdentifier());
            if (var53_14 != null) {
                var72_15 = AbstractTagItem.logger;
                var73_16 = new StringBuilder();
                var73_16.append("V4:Orig id is:");
                var73_16.append(var1_1.getIdentifier());
                var73_16.append(":New id is:");
                var73_16.append(this.identifier);
                var72_15.finer(var73_16.toString());
                this.frameBody = var78_17 = (AbstractTagFrameBody)ID3Tags.copyObject(var1_1.getBody());
                var78_17.setHeader(this);
                var79_18 = this.frameBody;
                var79_18.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this, var79_18.getTextEncoding()));
                return;
            }
            this.identifier = var54_19 = ID3Tags.forceFrameID24To23(var1_1.getIdentifier());
            if (var54_19 != null) {
                var64_20 = AbstractTagItem.logger;
                var65_21 = new StringBuilder();
                var65_21.append("V4:Orig id is:");
                var65_21.append(var1_1.getIdentifier());
                var65_21.append(":New id is:");
                var65_21.append(this.identifier);
                var64_20.finer(var65_21.toString());
                var70_22 = this.readBody(this.identifier, (AbstractID3v2FrameBody)var1_1.getBody());
                this.frameBody = var70_22;
                var70_22.setHeader(this);
                var71_23 = this.frameBody;
                var71_23.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this, var71_23.getTextEncoding()));
                return;
            }
            var55_24 = new ByteArrayOutputStream();
            ((AbstractID3v2FrameBody)var1_1.getBody()).write(var55_24);
            this.identifier = var56_25 = var1_1.getIdentifier();
            var57_26 = new FrameBodyUnsupported(var56_25, var55_24.toByteArray());
            this.frameBody = var57_26;
            var57_26.setHeader(this);
            var58_27 = AbstractTagItem.logger;
            var59_28 = new StringBuilder();
            var59_28.append("V4:Orig id is:");
            var59_28.append(var1_1.getIdentifier());
            var59_28.append(":New Id Unsupported is:");
            var59_28.append(this.identifier);
            var58_27.finer(var59_28.toString());
            return;
lbl112: // 1 sources:
            if (var2_2) {
                if (!ID3Tags.isID3v22FrameIdentifier(var1_1.getIdentifier())) {
                    var7_43 = new FrameBodyUnsupported((FrameBodyUnsupported)var1_1.getBody());
                    this.frameBody = var7_43;
                    var7_43.setHeader(this);
                    this.identifier = var1_1.getIdentifier();
                    var8_44 = AbstractTagItem.logger;
                    var9_45 = new StringBuilder();
                    var9_45.append("UNKNOWN:Orig id is:");
                    var9_45.append(var1_1.getIdentifier());
                    var9_45.append(":New id is:");
                    var9_45.append(this.identifier);
                    var8_44.config(var9_45.toString());
                    return;
                }
                this.identifier = var14_32 = ID3Tags.convertFrameID22To23(var1_1.getIdentifier());
                if (var14_32 != null) {
                    var30_33 = AbstractTagItem.logger;
                    var31_34 = new StringBuilder();
                    var31_34.append("V3:Orig id is:");
                    var31_34.append(var1_1.getIdentifier());
                    var31_34.append(":New id is:");
                    var31_34.append(this.identifier);
                    var30_33.config(var31_34.toString());
                    this.frameBody = var36_35 = (AbstractTagFrameBody)ID3Tags.copyObject(var1_1.getBody());
                    var36_35.setHeader(this);
                    return;
                }
                if (ID3Tags.isID3v22FrameIdentifier(var1_1.getIdentifier())) {
                    this.identifier = var15_36 = ID3Tags.forceFrameID22To23(var1_1.getIdentifier());
                    if (var15_36 != null) {
                        var23_37 = AbstractTagItem.logger;
                        var24_38 = new StringBuilder();
                        var24_38.append("V22Orig id is:");
                        var24_38.append(var1_1.getIdentifier());
                        var24_38.append("New id is:");
                        var24_38.append(this.identifier);
                        var23_37.config(var24_38.toString());
                        var29_39 = this.readBody(this.identifier, (AbstractID3v2FrameBody)var1_1.getBody());
                        this.frameBody = var29_39;
                        var29_39.setHeader(this);
                        return;
                    }
                    var16_40 = new FrameBodyDeprecated((AbstractID3v2FrameBody)var1_1.getBody());
                    this.frameBody = var16_40;
                    var16_40.setHeader(this);
                    this.identifier = var1_1.getIdentifier();
                    var17_41 = AbstractTagItem.logger;
                    var18_42 = new StringBuilder();
                    var18_42.append("Deprecated:V22:orig id id is:");
                    var18_42.append(var1_1.getIdentifier());
                    var18_42.append(":New id is:");
                    var18_42.append(this.identifier);
                    var17_41.config(var18_42.toString());
                    return;
                }
            }
        }
        var3_46 = AbstractTagItem.logger;
        var4_47 = new StringBuilder();
        var4_47.append("Frame is unknown version:");
        var4_47.append((Object)var1_1.getClass());
        var3_46.warning(var4_47.toString());
    }

    public ID3v23Frame(ID3v23Frame iD3v23Frame) {
        super(iD3v23Frame);
        this.statusFlags = new /* invalid duplicate definition of identical inner class */;
        this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
    }

    protected ID3v23Frame(ID3v24Frame iD3v24Frame, String string2) throws InvalidFrameException {
        this.identifier = string2;
        this.statusFlags = new /* invalid duplicate definition of identical inner class */;
        this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("frame", this.getIdentifier());
        MP3File.getStructureFormatter().addElement("frameSize", this.frameSize);
        this.statusFlags.createStructure();
        this.encodingFlags.createStructure();
        this.frameBody.createStructure();
        MP3File.getStructureFormatter().closeHeadingElement("frame");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ID3v23Frame)) {
            return false;
        }
        ID3v23Frame iD3v23Frame = (ID3v23Frame)object;
        return EqualsUtil.areEqual(this.statusFlags, iD3v23Frame.statusFlags) && EqualsUtil.areEqual(this.encodingFlags, iD3v23Frame.encodingFlags) && super.equals(iD3v23Frame);
    }

    @Override
    public AbstractID3v2Frame.EncodingFlags getEncodingFlags() {
        return this.encodingFlags;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    @Override
    protected int getFrameHeaderSize() {
        return 10;
    }

    @Override
    protected int getFrameIdSize() {
        return 4;
    }

    @Override
    protected int getFrameSizeSize() {
        return 4;
    }

    public int getGroupIdentifier() {
        return this.groupIdentifier;
    }

    @Override
    public int getSize() {
        return 10 + this.frameBody.getSize();
    }

    @Override
    public AbstractID3v2Frame.StatusFlags getStatusFlags() {
        return this.statusFlags;
    }

    @Override
    public boolean isBinary() {
        return ID3v23Frames.getInstanceOf().isBinary(this.getId());
    }

    @Override
    public boolean isCommon() {
        return ID3v23Frames.getInstanceOf().isCommon(this.getId());
    }

    public boolean isValidID3v2FrameIdentifier(String string2) {
        return validFrameIdentifier.matcher((CharSequence)string2).matches();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        String string2 = this.readIdentifier(byteBuffer);
        if (this.isValidID3v2FrameIdentifier(string2)) {
            int n2;
            this.frameSize = n2 = byteBuffer.getInt();
            if (n2 >= 0) {
                if (n2 != 0) {
                    if (n2 <= byteBuffer.remaining()) {
                        this.statusFlags = new /* invalid duplicate definition of identical inner class */;
                        this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
                        String string3 = ID3Tags.convertFrameID23To24(string2);
                        if (string3 == null) {
                            string3 = ID3Tags.isID3v23FrameIdentifier(string2) ? string2 : "Unsupported";
                        }
                        Logger logger = AbstractTagItem.logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.getLoggingFilename());
                        stringBuilder.append(":Identifier was:");
                        stringBuilder.append(string2);
                        stringBuilder.append(" reading using:");
                        stringBuilder.append(string3);
                        stringBuilder.append("with frame size:");
                        stringBuilder.append(this.frameSize);
                        logger.fine(stringBuilder.toString());
                        int n3 = -1;
                        boolean bl = (this.encodingFlags).isCompression();
                        int n4 = 0;
                        if (bl) {
                            n3 = byteBuffer.getInt();
                            n4 = 4;
                            Logger logger2 = AbstractTagItem.logger;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(this.getLoggingFilename());
                            stringBuilder2.append(":Decompressed frame size is:");
                            stringBuilder2.append(n3);
                            logger2.fine(stringBuilder2.toString());
                        }
                        if ((this.encodingFlags).isEncryption()) {
                            ++n4;
                            this.encryptionMethod = byteBuffer.get();
                        }
                        if ((this.encodingFlags).isGrouping()) {
                            ++n4;
                            this.groupIdentifier = byteBuffer.get();
                        }
                        if ((this.encodingFlags).isNonStandardFlags()) {
                            Logger logger3 = AbstractTagItem.logger;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(this.getLoggingFilename());
                            stringBuilder3.append(":InvalidEncodingFlags:");
                            stringBuilder3.append(Hex.asHex((this.encodingFlags).getFlags()));
                            logger3.severe(stringBuilder3.toString());
                        }
                        if ((this.encodingFlags).isCompression() && n3 > 100 * this.frameSize) {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(string2);
                            stringBuilder4.append(" is invalid frame, frame size ");
                            stringBuilder4.append(this.frameSize);
                            stringBuilder4.append(" cannot be:");
                            stringBuilder4.append(n3);
                            stringBuilder4.append(" when uncompressed");
                            throw new InvalidFrameException(stringBuilder4.toString());
                        }
                        int n5 = this.frameSize - n4;
                        if (n5 > 0) {
                            try {
                                if ((this.encodingFlags).isCompression()) {
                                    ByteBuffer byteBuffer2 = ID3Compression.uncompress(string2, this.getLoggingFilename(), byteBuffer, n3, n5);
                                    this.frameBody = (this.encodingFlags).isEncryption() ? this.readEncryptedBody(string3, byteBuffer2, n3) : this.readBody(string3, byteBuffer2, n3);
                                } else if ((this.encodingFlags).isEncryption()) {
                                    ByteBuffer byteBuffer3 = byteBuffer.slice();
                                    byteBuffer3.limit(this.frameSize);
                                    this.frameBody = this.readEncryptedBody(string2, byteBuffer3, this.frameSize);
                                } else {
                                    ByteBuffer byteBuffer4 = byteBuffer.slice();
                                    byteBuffer4.limit(n5);
                                    this.frameBody = this.readBody(string3, byteBuffer4, n5);
                                }
                                if (!(this.frameBody instanceof ID3v23FrameBody)) {
                                    Logger logger4 = AbstractTagItem.logger;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append(this.getLoggingFilename());
                                    stringBuilder5.append(":Converted frameBody with:");
                                    stringBuilder5.append(string2);
                                    stringBuilder5.append(" to deprecated frameBody");
                                    logger4.config(stringBuilder5.toString());
                                    this.frameBody = new FrameBodyDeprecated((AbstractID3v2FrameBody)this.frameBody);
                                }
                                return;
                            }
                            finally {
                                byteBuffer.position(n5 + byteBuffer.position());
                            }
                        }
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(string2);
                        stringBuilder6.append(" is invalid frame, realframeSize is:");
                        stringBuilder6.append(n5);
                        throw new InvalidFrameException(stringBuilder6.toString());
                    }
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(":Invalid Frame size of ");
                    stringBuilder.append(this.frameSize);
                    stringBuilder.append(" larger than size of");
                    stringBuilder.append(byteBuffer.remaining());
                    stringBuilder.append(" before mp3 audio:");
                    stringBuilder.append(string2);
                    logger.warning(stringBuilder.toString());
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(string2);
                    stringBuilder7.append(" is invalid frame:");
                    stringBuilder7.append(this.frameSize);
                    stringBuilder7.append(" larger than size of");
                    stringBuilder7.append(byteBuffer.remaining());
                    stringBuilder7.append(" before mp3 audio:");
                    stringBuilder7.append(string2);
                    throw new InvalidFrameException(stringBuilder7.toString());
                }
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Empty Frame Size:");
                stringBuilder.append(string2);
                logger.warning(stringBuilder.toString());
                byteBuffer.get();
                byteBuffer.get();
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(string2);
                stringBuilder8.append(" is empty frame");
                throw new EmptyFrameException(stringBuilder8.toString());
            }
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Invalid Frame Size:");
            stringBuilder.append(this.frameSize);
            stringBuilder.append(":");
            stringBuilder.append(string2);
            logger.warning(stringBuilder.toString());
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(string2);
            stringBuilder9.append(" is invalid frame:");
            stringBuilder9.append(this.frameSize);
            throw new InvalidFrameException(stringBuilder9.toString());
        }
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":Invalid identifier:");
        stringBuilder.append(string2);
        logger.config(stringBuilder.toString());
        byteBuffer.position(byteBuffer.position() - (-1 + this.getFrameIdSize()));
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append(this.getLoggingFilename());
        stringBuilder10.append(":");
        stringBuilder10.append(string2);
        stringBuilder10.append(":is not a valid ID3v2.30 frame");
        throw new InvalidFrameIdentifierException(stringBuilder10.toString());
    }

    @Override
    public void setEncoding(Charset charset) {
        Integer n2 = TextEncoding.getInstanceOf().getIdForCharset(charset);
        if (n2 != null && n2 < 2) {
            this.getBody().setTextEncoding(n2.byteValue());
        }
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing frame to buffer:");
        stringBuilder.append(this.getIdentifier());
        logger.config(stringBuilder.toString());
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)10);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ((AbstractID3v2FrameBody)this.frameBody).write(byteArrayOutputStream2);
        if (this.getIdentifier().length() == 3) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.identifier);
            stringBuilder2.append(' ');
            this.identifier = stringBuilder2.toString();
        }
        byteBuffer.put(this.getIdentifier().getBytes(StandardCharsets.ISO_8859_1), 0, 4);
        int n2 = this.frameBody.getSize();
        Logger logger2 = AbstractTagItem.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Frame Size Is:");
        stringBuilder3.append(n2);
        logger2.fine(stringBuilder3.toString());
        byteBuffer.putInt(this.frameBody.getSize());
        byteBuffer.put(this.statusFlags.getWriteFlags());
        (this.encodingFlags).unsetNonStandardFlags();
        (this.encodingFlags).unsetCompression();
        byteBuffer.put(this.encodingFlags.getFlags());
        try {
            byteArrayOutputStream.write(byteBuffer.array());
            if ((this.encodingFlags).isEncryption()) {
                byteArrayOutputStream.write(this.encryptionMethod);
            }
            if ((this.encodingFlags).isGrouping()) {
                byteArrayOutputStream.write(this.groupIdentifier);
            }
            byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

}

