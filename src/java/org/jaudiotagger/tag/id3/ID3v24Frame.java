/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
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
 *  java.util.Iterator
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
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.EmptyFrameException;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidFrameIdentifierException;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.Lyrics3Line;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3Compression;
import org.jaudiotagger.tag.id3.ID3SyncSafeInteger;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.id3.ID3Unsynchronization;
import org.jaudiotagger.tag.id3.ID3v22Frame;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v24Frames;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyDeprecated;
import org.jaudiotagger.tag.id3.framebody.FrameBodySYLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTALB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCOM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT2;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMOO;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE1;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyAUT;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAL;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyEAR;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyETT;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyINF;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyLYR;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Field;
import org.jaudiotagger.utils.EqualsUtil;

public class ID3v24Frame
extends AbstractID3v2Frame {
    protected static final int FRAME_DATA_LENGTH_SIZE = 4;
    protected static final int FRAME_ENCRYPTION_INDICATOR_SIZE = 1;
    protected static final int FRAME_FLAGS_SIZE = 2;
    protected static final int FRAME_GROUPING_INDICATOR_SIZE = 1;
    protected static final int FRAME_HEADER_SIZE = 10;
    protected static final int FRAME_ID_SIZE = 4;
    protected static final int FRAME_SIZE_SIZE = 4;
    private static Pattern validFrameIdentifier = Pattern.compile((String)"[A-Z][0-9A-Z]{3}");
    private int encryptionMethod;
    private int groupIdentifier;

    public ID3v24Frame() {
    }

    public ID3v24Frame(String string2) {
        super(string2);
        this.statusFlags = new AbstractID3v2Frame.StatusFlags(){
            public static final int MASK_FILE_ALTER_PRESERVATION = 32;
            public static final int MASK_READ_ONLY = 16;
            public static final int MASK_TAG_ALTER_PRESERVATION = 64;
            public static final String TYPE_FILEALTERPRESERVATION = "typeFileAlterPreservation";
            public static final String TYPE_READONLY = "typeReadOnly";
            public static final String TYPE_TAGALTERPRESERVATION = "typeTagAlterPreservation";
            {
                this.originalFlags = by;
                this.writeFlags = by;
                this.modifyFlags();
            }
            {
                byte by;
                super(ID3v24Frame.this);
                this.originalFlags = by = this.convertV3ToV4Flags(statusFlags.getOriginalFlags());
                this.writeFlags = by;
                this.modifyFlags();
            }

            private byte convertV3ToV4Flags(byte by) {
                byte by2 = (by & 64) != 0 ? (byte)32 : 0;
                if ((by & 128) != 0) {
                    by2 = (byte)(by2 | 64);
                }
                return by2;
            }

            @Override
            public void createStructure() {
                MP3File.getStructureFormatter().openHeadingElement("statusFlags", "");
                MP3File.getStructureFormatter().addElement(TYPE_TAGALTERPRESERVATION, 64 & this.originalFlags);
                MP3File.getStructureFormatter().addElement(TYPE_FILEALTERPRESERVATION, 32 & this.originalFlags);
                MP3File.getStructureFormatter().addElement(TYPE_READONLY, 16 & this.originalFlags);
                MP3File.getStructureFormatter().closeHeadingElement("statusFlags");
            }

            protected void modifyFlags() {
                byte by;
                String string2 = ID3v24Frame.this.getIdentifier();
                if (ID3v24Frames.getInstanceOf().isDiscardIfFileAltered(string2)) {
                    byte by2;
                    this.writeFlags = by2 = (byte)(32 | this.writeFlags);
                    this.writeFlags = (byte)(by2 & -65);
                    return;
                }
                this.writeFlags = by = (byte)(-33 & this.writeFlags);
                this.writeFlags = (byte)(by & -65);
            }
        };
        this.encodingFlags = new AbstractID3v2Frame.EncodingFlags(){
            public static final int MASK_COMPRESSION = 8;
            public static final int MASK_DATA_LENGTH_INDICATOR = 1;
            public static final int MASK_ENCRYPTION = 4;
            public static final int MASK_FRAME_UNSYNCHRONIZATION = 2;
            public static final int MASK_GROUPING_IDENTITY = 64;
            public static final String TYPE_COMPRESSION = "compression";
            public static final String TYPE_DATALENGTHINDICATOR = "dataLengthIndicator";
            public static final String TYPE_ENCRYPTION = "encryption";
            public static final String TYPE_FRAMEUNSYNCHRONIZATION = "frameUnsynchronisation";
            public static final String TYPE_GROUPIDENTITY = "groupidentity";
            {
                this.logEnabledFlags();
            }

            @Override
            public void createStructure() {
                MP3File.getStructureFormatter().openHeadingElement("encodingFlags", "");
                MP3File.getStructureFormatter().addElement(TYPE_COMPRESSION, 8 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_ENCRYPTION, 4 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_GROUPIDENTITY, 64 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_FRAMEUNSYNCHRONIZATION, 2 & this.flags);
                MP3File.getStructureFormatter().addElement(TYPE_DATALENGTHINDICATOR, 1 & this.flags);
                MP3File.getStructureFormatter().closeHeadingElement("encodingFlags");
            }

            @Override
            public byte getFlags() {
                return this.flags;
            }

            public boolean isCompression() {
                return (8 & this.flags) > 0;
            }

            public boolean isDataLengthIndicator() {
                return (1 & this.flags) > 0;
            }

            public boolean isEncryption() {
                return (4 & this.flags) > 0;
            }

            public boolean isGrouping() {
                return (64 & this.flags) > 0;
            }

            public boolean isNonStandardFlags() {
                byte by = this.flags;
                return (by & 128) > 0 || (by & 32) > 0 || (by & 16) > 0;
                {
                }
            }

            public boolean isUnsynchronised() {
                return (2 & this.flags) > 0;
            }

            public void logEnabledFlags() {
                if (this.isNonStandardFlags()) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v24Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v24Frame.this.identifier);
                    stringBuilder.append(":Unknown Encoding Flags:");
                    stringBuilder.append(Hex.asHex(this.flags));
                    logger.warning(stringBuilder.toString());
                }
                if (this.isCompression()) {
                    Logger logger = AbstractTagItem.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_FRAME_IS_COMPRESSED;
                    Object[] arrobject = new Object[]{ID3v24Frame.this.getLoggingFilename(), ID3v24Frame.this.identifier};
                    logger.warning(errorMessage.getMsg(arrobject));
                }
                if (this.isEncryption()) {
                    Logger logger = AbstractTagItem.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_FRAME_IS_ENCRYPTED;
                    Object[] arrobject = new Object[]{ID3v24Frame.this.getLoggingFilename(), ID3v24Frame.this.identifier};
                    logger.warning(errorMessage.getMsg(arrobject));
                }
                if (this.isGrouping()) {
                    Logger logger = AbstractTagItem.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_FRAME_IS_GROUPED;
                    Object[] arrobject = new Object[]{ID3v24Frame.this.getLoggingFilename(), ID3v24Frame.this.identifier};
                    logger.config(errorMessage.getMsg(arrobject));
                }
                if (this.isUnsynchronised()) {
                    Logger logger = AbstractTagItem.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_FRAME_IS_UNSYNCHRONISED;
                    Object[] arrobject = new Object[]{ID3v24Frame.this.getLoggingFilename(), ID3v24Frame.this.identifier};
                    logger.config(errorMessage.getMsg(arrobject));
                }
                if (this.isDataLengthIndicator()) {
                    Logger logger = AbstractTagItem.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_FRAME_IS_DATA_LENGTH_INDICATOR;
                    Object[] arrobject = new Object[]{ID3v24Frame.this.getLoggingFilename(), ID3v24Frame.this.identifier};
                    logger.config(errorMessage.getMsg(arrobject));
                }
            }

            public void setCompression() {
                this.flags = (byte)(8 | this.flags);
            }

            public void setDataLengthIndicator() {
                this.flags = (byte)(1 | this.flags);
            }

            public void setEncryption() {
                this.flags = (byte)(4 | this.flags);
            }

            public void setGrouping() {
                this.flags = (byte)(64 | this.flags);
            }

            public void setUnsynchronised() {
                this.flags = (byte)(2 | this.flags);
            }

            public void unsetCompression() {
                this.flags = (byte)(-9 & this.flags);
            }

            public void unsetDataLengthIndicator() {
                this.flags = (byte)(-2 & this.flags);
            }

            public void unsetEncryption() {
                this.flags = (byte)(-5 & this.flags);
            }

            public void unsetGrouping() {
                this.flags = (byte)(-65 & this.flags);
            }

            public void unsetNonStandardFlags() {
                if (this.isNonStandardFlags()) {
                    byte by;
                    byte by2;
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ID3v24Frame.this.getLoggingFilename());
                    stringBuilder.append(":");
                    stringBuilder.append(ID3v24Frame.this.getIdentifier());
                    stringBuilder.append(":Unsetting Unknown Encoding Flags:");
                    stringBuilder.append(Hex.asHex(this.flags));
                    logger.warning(stringBuilder.toString());
                    this.flags = by2 = (byte)(127 & this.flags);
                    this.flags = by = (byte)(by2 & -33);
                    this.flags = (byte)(by & -17);
                }
            }

            public void unsetUnsynchronised() {
                this.flags = (byte)(-3 & this.flags);
            }
        };
    }

    public ID3v24Frame(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        this(byteBuffer, "");
    }

    public ID3v24Frame(ByteBuffer byteBuffer, String string2) throws InvalidFrameException, InvalidDataTypeException {
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    public ID3v24Frame(AbstractID3v2Frame abstractID3v2Frame) throws InvalidFrameException {
        if (!(abstractID3v2Frame instanceof ID3v24Frame)) {
            boolean bl = abstractID3v2Frame instanceof ID3v23Frame;
            if (bl) {
                this.statusFlags = new /* invalid duplicate definition of identical inner class */;
                this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
            } else if (abstractID3v2Frame instanceof ID3v22Frame) {
                this.statusFlags = new /* invalid duplicate definition of identical inner class */;
                this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
            }
            if (bl) {
                this.createV24FrameFromV23Frame((ID3v23Frame)abstractID3v2Frame);
            } else if (abstractID3v2Frame instanceof ID3v22Frame) {
                this.createV24FrameFromV23Frame(new ID3v23Frame(abstractID3v2Frame));
            }
            this.frameBody.setHeader(this);
            return;
        }
        throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
    }

    protected ID3v24Frame(ID3v23Frame iD3v23Frame, String string2) throws InvalidFrameException {
        this.identifier = string2;
        this.statusFlags = new /* invalid duplicate definition of identical inner class */;
        this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
    }

    public ID3v24Frame(ID3v24Frame iD3v24Frame) {
        super(iD3v24Frame);
        this.statusFlags = new /* invalid duplicate definition of identical inner class */;
        this.encodingFlags = new /* invalid duplicate definition of identical inner class */;
    }

    public ID3v24Frame(Lyrics3v2Field lyrics3v2Field) throws InvalidTagException {
        String string2 = lyrics3v2Field.getIdentifier();
        if (!string2.equals((Object)"IND")) {
            if (string2.equals((Object)"LYR")) {
                FieldFrameBodyLYR fieldFrameBodyLYR = (FieldFrameBodyLYR)lyrics3v2Field.getBody();
                Iterator<Lyrics3Line> iterator = fieldFrameBodyLYR.iterator();
                boolean bl = fieldFrameBodyLYR.hasTimeStamp();
                FrameBodySYLT frameBodySYLT = new FrameBodySYLT(0, "ENG", 2, 1, "", new byte[0]);
                FrameBodyUSLT frameBodyUSLT = new FrameBodyUSLT(0, "ENG", "", "");
                while (iterator.hasNext()) {
                    Lyrics3Line lyrics3Line = (Lyrics3Line)iterator.next();
                    if (bl) continue;
                    frameBodyUSLT.addLyric(lyrics3Line);
                }
                if (bl) {
                    this.frameBody = frameBodySYLT;
                    frameBodySYLT.setHeader(this);
                    return;
                }
                this.frameBody = frameBodyUSLT;
                frameBodyUSLT.setHeader(this);
                return;
            }
            if (string2.equals((Object)"INF")) {
                FrameBodyCOMM frameBodyCOMM = new FrameBodyCOMM(0, "ENG", "", ((FieldFrameBodyINF)lyrics3v2Field.getBody()).getAdditionalInformation());
                this.frameBody = frameBodyCOMM;
                frameBodyCOMM.setHeader(this);
                return;
            }
            if (string2.equals((Object)"AUT")) {
                FrameBodyTCOM frameBodyTCOM = new FrameBodyTCOM(0, ((FieldFrameBodyAUT)lyrics3v2Field.getBody()).getAuthor());
                this.frameBody = frameBodyTCOM;
                frameBodyTCOM.setHeader(this);
                return;
            }
            if (string2.equals((Object)"EAL")) {
                FrameBodyTALB frameBodyTALB = new FrameBodyTALB(0, ((FieldFrameBodyEAL)lyrics3v2Field.getBody()).getAlbum());
                this.frameBody = frameBodyTALB;
                frameBodyTALB.setHeader(this);
                return;
            }
            if (string2.equals((Object)"EAR")) {
                FrameBodyTPE1 frameBodyTPE1 = new FrameBodyTPE1(0, ((FieldFrameBodyEAR)lyrics3v2Field.getBody()).getArtist());
                this.frameBody = frameBodyTPE1;
                frameBodyTPE1.setHeader(this);
                return;
            }
            if (string2.equals((Object)"ETT")) {
                FrameBodyTIT2 frameBodyTIT2 = new FrameBodyTIT2(0, ((FieldFrameBodyETT)lyrics3v2Field.getBody()).getTitle());
                this.frameBody = frameBodyTIT2;
                frameBodyTIT2.setHeader(this);
                return;
            }
            if (string2.equals((Object)"IMG")) {
                throw new InvalidTagException("Cannot create ID3v2.40 frame from Lyrics3 image field.");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot caret ID3v2.40 frame from ");
            stringBuilder.append(string2);
            stringBuilder.append(" Lyrics3 field");
            throw new InvalidTagException(stringBuilder.toString());
        }
        throw new InvalidTagException("Cannot create ID3v2.40 frame from Lyrics3 indications field.");
    }

    private void checkIfFrameSizeThatIsNotSyncSafe(ByteBuffer byteBuffer) throws InvalidFrameException {
        if (this.frameSize > 127) {
            int n2 = byteBuffer.position();
            byteBuffer.position(n2 - this.getFrameIdSize());
            int n3 = byteBuffer.getInt();
            byteBuffer.position(n2 - this.getFrameIdSize());
            boolean bl = ID3SyncSafeInteger.isBufferNotSyncSafe(byteBuffer);
            byteBuffer.position(n2);
            if (bl) {
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Frame size is NOT stored as a sync safe integer:");
                stringBuilder.append(this.identifier);
                logger.warning(stringBuilder.toString());
                if (n3 <= byteBuffer.remaining() - -this.getFrameFlagsSize()) {
                    this.frameSize = n3;
                    return;
                }
                Logger logger2 = AbstractTagItem.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.getLoggingFilename());
                stringBuilder2.append(":Invalid Frame size larger than size before mp3 audio:");
                stringBuilder2.append(this.identifier);
                logger2.warning(stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(this.identifier);
                stringBuilder3.append(" is invalid frame");
                throw new InvalidFrameException(stringBuilder3.toString());
            }
            byte[] arrby = new byte[this.getFrameIdSize()];
            byteBuffer.position(n2 + this.frameSize + this.getFrameFlagsSize());
            if (byteBuffer.remaining() < this.getFrameIdSize()) {
                byteBuffer.position(n2);
                return;
            }
            byteBuffer.get(arrby, 0, this.getFrameIdSize());
            byteBuffer.position(n2);
            if (this.isValidID3v2FrameIdentifier(new String(arrby))) {
                return;
            }
            if (ID3SyncSafeInteger.isBufferEmpty(arrby)) {
                return;
            }
            if (n3 > byteBuffer.remaining() - this.getFrameFlagsSize()) {
                byteBuffer.position(n2);
                return;
            }
            byte[] arrby2 = new byte[this.getFrameIdSize()];
            byteBuffer.position(n2 + n3 + this.getFrameFlagsSize());
            if (byteBuffer.remaining() >= this.getFrameIdSize()) {
                byteBuffer.get(arrby2, 0, this.getFrameIdSize());
                String string2 = new String(arrby2);
                byteBuffer.position(n2);
                if (this.isValidID3v2FrameIdentifier(string2)) {
                    this.frameSize = n3;
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(":Assuming frame size is NOT stored as a sync safe integer:");
                    stringBuilder.append(this.identifier);
                    logger.warning(stringBuilder.toString());
                    return;
                }
                if (ID3SyncSafeInteger.isBufferEmpty(arrby2)) {
                    this.frameSize = n3;
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(":Assuming frame size is NOT stored as a sync safe integer:");
                    stringBuilder.append(this.identifier);
                    logger.warning(stringBuilder.toString());
                    return;
                }
            } else {
                byteBuffer.position(n2);
                if (byteBuffer.remaining() == 0) {
                    this.frameSize = n3;
                }
            }
        }
    }

    private void createV24FrameFromV23Frame(ID3v23Frame iD3v23Frame) throws InvalidFrameException {
        this.identifier = ID3Tags.convertFrameID23To24(iD3v23Frame.getIdentifier());
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Creating V24frame from v23:");
        stringBuilder.append(iD3v23Frame.getIdentifier());
        stringBuilder.append(":");
        stringBuilder.append(this.identifier);
        logger.finer(stringBuilder.toString());
        if (iD3v23Frame.getBody() instanceof FrameBodyUnsupported) {
            FrameBodyUnsupported frameBodyUnsupported = new FrameBodyUnsupported((FrameBodyUnsupported)iD3v23Frame.getBody());
            this.frameBody = frameBodyUnsupported;
            frameBodyUnsupported.setHeader(this);
            this.identifier = iD3v23Frame.getIdentifier();
            Logger logger2 = AbstractTagItem.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("V3:UnsupportedBody:Orig id is:");
            stringBuilder2.append(iD3v23Frame.getIdentifier());
            stringBuilder2.append(":New id is:");
            stringBuilder2.append(this.identifier);
            logger2.finer(stringBuilder2.toString());
            return;
        }
        if (this.identifier != null) {
            AbstractTagFrameBody abstractTagFrameBody;
            if (iD3v23Frame.getIdentifier().equals((Object)"TXXX") && ((FrameBodyTXXX)iD3v23Frame.getBody()).getDescription().equals((Object)"MOOD")) {
                FrameBodyTMOO frameBodyTMOO = new FrameBodyTMOO((FrameBodyTXXX)iD3v23Frame.getBody());
                this.frameBody = frameBodyTMOO;
                frameBodyTMOO.setHeader(this);
                this.identifier = this.frameBody.getIdentifier();
                return;
            }
            Logger logger3 = AbstractTagItem.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("V3:Orig id is:");
            stringBuilder3.append(iD3v23Frame.getIdentifier());
            stringBuilder3.append(":New id is:");
            stringBuilder3.append(this.identifier);
            logger3.finer(stringBuilder3.toString());
            this.frameBody = abstractTagFrameBody = (AbstractTagFrameBody)ID3Tags.copyObject(iD3v23Frame.getBody());
            abstractTagFrameBody.setHeader(this);
            return;
        }
        if (ID3Tags.isID3v23FrameIdentifier(iD3v23Frame.getIdentifier())) {
            String string2;
            this.identifier = string2 = ID3Tags.forceFrameID23To24(iD3v23Frame.getIdentifier());
            if (string2 != null) {
                Logger logger4 = AbstractTagItem.logger;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("V3:Orig id is:");
                stringBuilder4.append(iD3v23Frame.getIdentifier());
                stringBuilder4.append(":New id is:");
                stringBuilder4.append(this.identifier);
                logger4.config(stringBuilder4.toString());
                AbstractID3v2FrameBody abstractID3v2FrameBody = this.readBody(this.identifier, (AbstractID3v2FrameBody)iD3v23Frame.getBody());
                this.frameBody = abstractID3v2FrameBody;
                abstractID3v2FrameBody.setHeader(this);
                return;
            }
            FrameBodyDeprecated frameBodyDeprecated = new FrameBodyDeprecated((AbstractID3v2FrameBody)iD3v23Frame.getBody());
            this.frameBody = frameBodyDeprecated;
            frameBodyDeprecated.setHeader(this);
            this.identifier = iD3v23Frame.getIdentifier();
            Logger logger5 = AbstractTagItem.logger;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("V3:Deprecated:Orig id is:");
            stringBuilder5.append(iD3v23Frame.getIdentifier());
            stringBuilder5.append(":New id is:");
            stringBuilder5.append(this.identifier);
            logger5.finer(stringBuilder5.toString());
            return;
        }
        FrameBodyUnsupported frameBodyUnsupported = new FrameBodyUnsupported((FrameBodyUnsupported)iD3v23Frame.getBody());
        this.frameBody = frameBodyUnsupported;
        frameBodyUnsupported.setHeader(this);
        this.identifier = iD3v23Frame.getIdentifier();
        Logger logger6 = AbstractTagItem.logger;
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("V3:Unknown:Orig id is:");
        stringBuilder6.append(iD3v23Frame.getIdentifier());
        stringBuilder6.append(":New id is:");
        stringBuilder6.append(this.identifier);
        logger6.finer(stringBuilder6.toString());
    }

    private void getFrameSize(ByteBuffer byteBuffer) throws InvalidFrameException {
        int n2;
        this.frameSize = n2 = ID3SyncSafeInteger.bufferToValue(byteBuffer);
        if (n2 >= 0) {
            if (n2 != 0) {
                if (n2 <= -2 + byteBuffer.remaining()) {
                    this.checkIfFrameSizeThatIsNotSyncSafe(byteBuffer);
                    return;
                }
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Invalid Frame size larger than size before mp3 audio:");
                stringBuilder.append(this.identifier);
                logger.warning(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.identifier);
                stringBuilder2.append(" is invalid frame");
                throw new InvalidFrameException(stringBuilder2.toString());
            }
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Empty Frame:");
            stringBuilder.append(this.identifier);
            logger.warning(stringBuilder.toString());
            byteBuffer.get();
            byteBuffer.get();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.identifier);
            stringBuilder3.append(" is empty frame");
            throw new EmptyFrameException(stringBuilder3.toString());
        }
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":Invalid Frame size:");
        stringBuilder.append(this.identifier);
        logger.warning(stringBuilder.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.identifier);
        stringBuilder4.append(" is invalid frame");
        throw new InvalidFrameException(stringBuilder4.toString());
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
        if (!(object instanceof ID3v24Frame)) {
            return false;
        }
        ID3v24Frame iD3v24Frame = (ID3v24Frame)object;
        return EqualsUtil.areEqual(this.statusFlags, iD3v24Frame.statusFlags) && EqualsUtil.areEqual(this.encodingFlags, iD3v24Frame.encodingFlags) && super.equals(iD3v24Frame);
    }

    @Override
    public AbstractID3v2Frame.EncodingFlags getEncodingFlags() {
        return this.encodingFlags;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    protected int getFrameFlagsSize() {
        return 2;
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
        return ID3v24Frames.getInstanceOf().isBinary(this.getId());
    }

    @Override
    public boolean isCommon() {
        return ID3v24Frames.getInstanceOf().isCommon(this.getId());
    }

    public boolean isValidID3v2FrameIdentifier(String string2) {
        return validFrameIdentifier.matcher((CharSequence)string2).matches();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        String string2 = this.readIdentifier(byteBuffer);
        boolean bl = this.isValidID3v2FrameIdentifier(string2);
        int n2 = 1;
        if (bl) {
            AbstractID3v2Frame.EncodingFlags encodingFlags;
            int n3;
            this.getFrameSize(byteBuffer);
            this.statusFlags = new /* invalid duplicate definition of identical inner class */;
            this.encodingFlags = encodingFlags = new /* invalid duplicate definition of identical inner class */;
            int n4 = -1;
            if (encodingFlags.isGrouping()) {
                this.groupIdentifier = byteBuffer.get();
            } else {
                n2 = 0;
            }
            if ((this.encodingFlags).isEncryption()) {
                ++n2;
                this.encryptionMethod = byteBuffer.get();
            }
            if ((this.encodingFlags).isDataLengthIndicator()) {
                n4 = ID3SyncSafeInteger.bufferToValue(byteBuffer);
                n2 += 4;
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Frame Size Is:");
                stringBuilder.append(this.frameSize);
                stringBuilder.append(" Data Length Size:");
                stringBuilder.append(n4);
                logger.config(stringBuilder.toString());
            }
            int n5 = this.frameSize - n2;
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.limit(n5);
            if ((this.encodingFlags).isUnsynchronised()) {
                byteBuffer2 = ID3Unsynchronization.synchronize(byteBuffer2);
                n3 = byteBuffer2.limit();
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Frame Size After Syncing is:");
                stringBuilder.append(n3);
                logger.config(stringBuilder.toString());
            } else {
                n3 = n5;
            }
            try {
                if ((this.encodingFlags).isCompression()) {
                    ByteBuffer byteBuffer3 = ID3Compression.uncompress(string2, this.getLoggingFilename(), byteBuffer, n4, n5);
                    this.frameBody = (this.encodingFlags).isEncryption() ? this.readEncryptedBody(string2, byteBuffer3, n4) : this.readBody(string2, byteBuffer3, n4);
                } else if ((this.encodingFlags).isEncryption()) {
                    byteBuffer.slice().limit(n5);
                    this.frameBody = this.readEncryptedBody(string2, byteBuffer, this.frameSize);
                } else {
                    this.frameBody = this.readBody(string2, byteBuffer2, n3);
                }
                if (!(this.frameBody instanceof ID3v24FrameBody)) {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(":Converted frame body with:");
                    stringBuilder.append(string2);
                    stringBuilder.append(" to deprecated framebody");
                    logger.config(stringBuilder.toString());
                    this.frameBody = new FrameBodyDeprecated((AbstractID3v2FrameBody)this.frameBody);
                }
                return;
            }
            finally {
                byteBuffer.position(n5 + byteBuffer.position());
            }
        }
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":Invalid identifier:");
        stringBuilder.append(string2);
        logger.config(stringBuilder.toString());
        byteBuffer.position(byteBuffer.position() - (this.getFrameIdSize() - n2));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.getLoggingFilename());
        stringBuilder2.append(":");
        stringBuilder2.append(string2);
        stringBuilder2.append(":is not a valid ID3v2.30 frame");
        throw new InvalidFrameIdentifierException(stringBuilder2.toString());
    }

    @Override
    public void setEncoding(Charset charset) {
        Integer n2 = TextEncoding.getInstanceOf().getIdForCharset(charset);
        if (n2 != null && n2 < 4) {
            this.getBody().setTextEncoding(n2.byteValue());
        }
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing frame to file:");
        stringBuilder.append(this.getIdentifier());
        logger.config(stringBuilder.toString());
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)10);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ((AbstractID3v2FrameBody)this.frameBody).write(byteArrayOutputStream2);
        byte[] arrby = byteArrayOutputStream2.toByteArray();
        boolean bl = TagOptionSingleton.getInstance().isUnsyncTags() && ID3Unsynchronization.requiresUnsynchronization(arrby);
        if (bl) {
            arrby = ID3Unsynchronization.unsynchronize(arrby);
            Logger logger2 = AbstractTagItem.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("bodybytebuffer:sizeafterunsynchronisation:");
            stringBuilder2.append(arrby.length);
            logger2.config(stringBuilder2.toString());
        }
        if (this.getIdentifier().length() == 3) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.identifier);
            stringBuilder3.append(' ');
            this.identifier = stringBuilder3.toString();
        }
        byteBuffer.put(this.getIdentifier().getBytes(StandardCharsets.ISO_8859_1), 0, 4);
        int n2 = arrby.length;
        Logger logger3 = AbstractTagItem.logger;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Frame Size Is:");
        stringBuilder4.append(n2);
        logger3.fine(stringBuilder4.toString());
        byteBuffer.put(ID3SyncSafeInteger.valueToBuffer(n2));
        byteBuffer.put(this.statusFlags.getWriteFlags());
        (this.encodingFlags).unsetNonStandardFlags();
        if (bl) {
            (this.encodingFlags).setUnsynchronised();
        } else {
            (this.encodingFlags).unsetUnsynchronised();
        }
        (this.encodingFlags).unsetCompression();
        (this.encodingFlags).unsetDataLengthIndicator();
        byteBuffer.put(this.encodingFlags.getFlags());
        try {
            byteArrayOutputStream.write(byteBuffer.array());
            if ((this.encodingFlags).isEncryption()) {
                byteArrayOutputStream.write(this.encryptionMethod);
            }
            if ((this.encodingFlags).isGrouping()) {
                byteArrayOutputStream.write(this.groupIdentifier);
            }
            byteArrayOutputStream.write(arrby);
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

}

