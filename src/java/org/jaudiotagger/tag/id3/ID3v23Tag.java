/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Set
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractID3Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AggregatedFrame;
import org.jaudiotagger.tag.id3.ID3Frames;
import org.jaudiotagger.tag.id3.ID3SyncSafeInteger;
import org.jaudiotagger.tag.id3.ID3Unsynchronization;
import org.jaudiotagger.tag.id3.ID3v23FieldKey;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v23PreferredFrameOrderComparator;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.TyerTdatAggregatedFrame;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyIPLS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDAT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIME;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMCL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTYER;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.reference.PictureTypes;

public class ID3v23Tag
extends AbstractID3v2Tag {
    protected static int FIELD_TAG_EXT_SIZE_LENGTH = 4;
    public static final byte MAJOR_VERSION = 3;
    public static final int MASK_V23_CRC_DATA_PRESENT = 128;
    public static final int MASK_V23_EMBEDDED_INFO_FLAG = 2;
    public static final int MASK_V23_EXPERIMENTAL = 32;
    public static final int MASK_V23_EXTENDED_HEADER = 64;
    public static final int MASK_V23_UNSYNCHRONIZATION = 128;
    public static final byte RELEASE = 2;
    public static final byte REVISION = 0;
    protected static int TAG_EXT_HEADER_CRC_LENGTH = 4;
    protected static int TAG_EXT_HEADER_DATA_LENGTH = 0;
    protected static int TAG_EXT_HEADER_LENGTH = 10;
    protected static final String TYPE_CRCDATA = "crcdata";
    protected static final String TYPE_EXPERIMENTAL = "experimental";
    protected static final String TYPE_EXTENDED = "extended";
    protected static final String TYPE_PADDINGSIZE = "paddingsize";
    protected static final String TYPE_UNSYNCHRONISATION = "unsyncronisation";
    protected boolean compression = false;
    private int crc32;
    protected boolean crcDataFlag = false;
    protected boolean experimental = false;
    protected boolean extended = false;
    private int paddingSize = 0;
    protected boolean unsynchronization = false;

    static {
        TAG_EXT_HEADER_DATA_LENGTH = 10 - 4;
    }

    public ID3v23Tag() {
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
    }

    public ID3v23Tag(ByteBuffer byteBuffer) throws TagException {
        this(byteBuffer, "");
    }

    public ID3v23Tag(ByteBuffer byteBuffer, String string2) throws TagException {
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    public ID3v23Tag(AbstractTag abstractTag) {
        AbstractID3Tag.logger.config("Creating tag from a tag of a different version");
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
        if (abstractTag != null) {
            if (!(abstractTag instanceof ID3v23Tag)) {
                ID3v24Tag iD3v24Tag = abstractTag instanceof ID3v24Tag ? (ID3v24Tag)abstractTag : new ID3v24Tag(abstractTag);
                this.setLoggingFilename(iD3v24Tag.getLoggingFilename());
                this.copyPrimitives(iD3v24Tag);
                this.copyFrames(iD3v24Tag);
                AbstractID3Tag.logger.config("Created tag from a tag of a different version");
                return;
            }
            throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
        }
    }

    public ID3v23Tag(ID3v23Tag iD3v23Tag) {
        super(iD3v23Tag);
        AbstractID3Tag.logger.config("Creating tag from another tag of same type");
        this.copyPrimitives(iD3v23Tag);
        this.copyFrames(iD3v23Tag);
    }

    private void readExtendedHeader(ByteBuffer byteBuffer, int n2) {
        int n3;
        int n4 = byteBuffer.getInt();
        if (n4 == (n3 = TAG_EXT_HEADER_DATA_LENGTH)) {
            int n5;
            boolean bl = (128 & byteBuffer.get()) != 0;
            this.crcDataFlag = bl;
            if (bl) {
                Logger logger = AbstractID3Tag.logger;
                ErrorMessage errorMessage = ErrorMessage.ID3_TAG_CRC_FLAG_SET_INCORRECTLY;
                Object[] arrobject = new Object[]{this.getLoggingFilename()};
                logger.warning(errorMessage.getMsg(arrobject));
            }
            byteBuffer.get();
            this.paddingSize = n5 = byteBuffer.getInt();
            if (n5 > 0) {
                Logger logger = AbstractID3Tag.logger;
                ErrorMessage errorMessage = ErrorMessage.ID3_TAG_PADDING_SIZE;
                Object[] arrobject = new Object[]{this.getLoggingFilename(), this.paddingSize};
                logger.config(errorMessage.getMsg(arrobject));
                return;
            }
        } else {
            if (n4 == n3 + TAG_EXT_HEADER_CRC_LENGTH) {
                int n6;
                Logger logger = AbstractID3Tag.logger;
                ErrorMessage errorMessage = ErrorMessage.ID3_TAG_CRC;
                Object[] arrobject = new Object[]{this.getLoggingFilename()};
                logger.config(errorMessage.getMsg(arrobject));
                boolean bl = (128 & byteBuffer.get()) != 0;
                this.crcDataFlag = bl;
                if (!bl) {
                    Logger logger2 = AbstractID3Tag.logger;
                    ErrorMessage errorMessage2 = ErrorMessage.ID3_TAG_CRC_FLAG_SET_INCORRECTLY;
                    Object[] arrobject2 = new Object[]{this.getLoggingFilename()};
                    logger2.warning(errorMessage2.getMsg(arrobject2));
                }
                byteBuffer.get();
                this.paddingSize = n6 = byteBuffer.getInt();
                if (n6 > 0) {
                    Logger logger3 = AbstractID3Tag.logger;
                    ErrorMessage errorMessage3 = ErrorMessage.ID3_TAG_PADDING_SIZE;
                    Object[] arrobject3 = new Object[]{this.getLoggingFilename(), this.paddingSize};
                    logger3.config(errorMessage3.getMsg(arrobject3));
                }
                this.crc32 = byteBuffer.getInt();
                Logger logger4 = AbstractID3Tag.logger;
                ErrorMessage errorMessage4 = ErrorMessage.ID3_TAG_CRC_SIZE;
                Object[] arrobject4 = new Object[]{this.getLoggingFilename(), this.crc32};
                logger4.config(errorMessage4.getMsg(arrobject4));
                return;
            }
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_EXTENDED_HEADER_SIZE_INVALID;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), n4};
            logger.warning(errorMessage.getMsg(arrobject));
            byteBuffer.position(byteBuffer.position() - FIELD_TAG_EXT_SIZE_LENGTH);
        }
    }

    private void readHeaderFlags(ByteBuffer byteBuffer) throws TagException {
        byte by = byteBuffer.get();
        boolean bl = (by & 128) != 0;
        this.unsynchronization = bl;
        boolean bl2 = (by & 64) != 0;
        this.extended = bl2;
        boolean bl3 = (by & 32) != 0;
        this.experimental = bl3;
        if ((by & 16) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 16};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 8) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 8};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 4) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 4};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 2) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 2};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 1) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 1};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if (this.isUnsynchronization()) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_UNSYNCHRONIZED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.extended) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_EXTENDED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.experimental) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_EXPERIMENTAL;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
    }

    private ByteBuffer writeHeaderToBuffer(int n2, int n3) throws IOException {
        int n4;
        this.extended = false;
        this.experimental = false;
        this.crcDataFlag = false;
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)(10 + TAG_EXT_HEADER_LENGTH + TAG_EXT_HEADER_CRC_LENGTH));
        byteBuffer.put(AbstractID3v2Tag.TAG_ID);
        byteBuffer.put(this.getMajorVersion());
        byteBuffer.put(this.getRevision());
        byte by = this.isUnsynchronization() ? (byte)128 : (byte)0;
        if (this.extended) {
            by = (byte)(by | 64);
        }
        if (this.experimental) {
            by = (byte)(by | 32);
        }
        byteBuffer.put(by);
        if (this.extended) {
            n4 = 0 + TAG_EXT_HEADER_LENGTH;
            if (this.crcDataFlag) {
                n4 += TAG_EXT_HEADER_CRC_LENGTH;
            }
        } else {
            n4 = 0;
        }
        byteBuffer.put(ID3SyncSafeInteger.valueToBuffer(n4 + (n3 + n2)));
        if (this.extended) {
            if (this.crcDataFlag) {
                byteBuffer.putInt(TAG_EXT_HEADER_DATA_LENGTH + TAG_EXT_HEADER_CRC_LENGTH);
                byteBuffer.put((byte)128);
                byteBuffer.put((byte)0);
                byteBuffer.putInt(this.paddingSize);
                byteBuffer.putInt(this.crc32);
            } else {
                byteBuffer.putInt(TAG_EXT_HEADER_DATA_LENGTH);
                byteBuffer.put((byte)0);
                byteBuffer.put((byte)0);
                byteBuffer.putInt(n2);
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void addFrame(AbstractID3v2Frame var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl50 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    protected List<AbstractID3v2Frame> convertFrame(AbstractID3v2Frame abstractID3v2Frame) throws InvalidFrameException {
        ArrayList arrayList = new ArrayList();
        if (abstractID3v2Frame.getIdentifier().equals((Object)"TDRC") && abstractID3v2Frame.getBody() instanceof FrameBodyTDRC) {
            FrameBodyTDRC frameBodyTDRC = (FrameBodyTDRC)abstractID3v2Frame.getBody();
            frameBodyTDRC.findMatchingMaskAndExtractV3Values();
            if (!frameBodyTDRC.getYear().equals((Object)"")) {
                ID3v23Frame iD3v23Frame = new ID3v23Frame("TYER");
                ((FrameBodyTYER)iD3v23Frame.getBody()).setText(frameBodyTDRC.getYear());
                arrayList.add((Object)iD3v23Frame);
            }
            if (!frameBodyTDRC.getDate().equals((Object)"")) {
                ID3v23Frame iD3v23Frame = new ID3v23Frame("TDAT");
                ((FrameBodyTDAT)iD3v23Frame.getBody()).setText(frameBodyTDRC.getDate());
                ((FrameBodyTDAT)iD3v23Frame.getBody()).setMonthOnly(frameBodyTDRC.isMonthOnly());
                arrayList.add((Object)iD3v23Frame);
            }
            if (!frameBodyTDRC.getTime().equals((Object)"")) {
                ID3v23Frame iD3v23Frame = new ID3v23Frame("TIME");
                ((FrameBodyTIME)iD3v23Frame.getBody()).setText(frameBodyTDRC.getTime());
                ((FrameBodyTIME)iD3v23Frame.getBody()).setHoursOnly(frameBodyTDRC.isHoursOnly());
                arrayList.add((Object)iD3v23Frame);
                return arrayList;
            }
        } else {
            if (abstractID3v2Frame.getIdentifier().equals((Object)"TIPL") && abstractID3v2Frame.getBody() instanceof FrameBodyTIPL) {
                List<Pair> list = ((FrameBodyTIPL)abstractID3v2Frame.getBody()).getPairing().getMapping();
                ID3v23Frame iD3v23Frame = new ID3v23Frame((ID3v24Frame)abstractID3v2Frame, "IPLS");
                iD3v23Frame.setBody(new FrameBodyIPLS(abstractID3v2Frame.getBody().getTextEncoding(), list));
                arrayList.add((Object)iD3v23Frame);
                return arrayList;
            }
            if (abstractID3v2Frame.getIdentifier().equals((Object)"TMCL") && abstractID3v2Frame.getBody() instanceof FrameBodyTMCL) {
                List<Pair> list = ((FrameBodyTMCL)abstractID3v2Frame.getBody()).getPairing().getMapping();
                ID3v23Frame iD3v23Frame = new ID3v23Frame((ID3v24Frame)abstractID3v2Frame, "IPLS");
                iD3v23Frame.setBody(new FrameBodyIPLS(abstractID3v2Frame.getBody().getTextEncoding(), list));
                arrayList.add((Object)iD3v23Frame);
                return arrayList;
            }
            arrayList.add((Object)new ID3v23Frame(abstractID3v2Frame));
        }
        return arrayList;
    }

    @Override
    protected void copyPrimitives(AbstractID3v2Tag abstractID3v2Tag) {
        AbstractID3Tag.logger.config("Copying primitives");
        super.copyPrimitives(abstractID3v2Tag);
        if (abstractID3v2Tag instanceof ID3v23Tag) {
            ID3v23Tag iD3v23Tag = (ID3v23Tag)abstractID3v2Tag;
            this.crcDataFlag = iD3v23Tag.crcDataFlag;
            this.experimental = iD3v23Tag.experimental;
            this.extended = iD3v23Tag.extended;
            this.crc32 = iD3v23Tag.crc32;
            this.paddingSize = iD3v23Tag.paddingSize;
        }
    }

    public TagField createArtworkField(byte[] arrby, String string2) {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)abstractID3v2Frame.getBody();
        frameBodyAPIC.setObjectValue("PictureData", arrby);
        frameBodyAPIC.setObjectValue("PictureType", (Object)PictureTypes.DEFAULT_ID);
        frameBodyAPIC.setObjectValue("MIMEType", string2);
        frameBodyAPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != null) {
            if (arrstring != null && arrstring[0] != null) {
                String string2 = arrstring[0];
                if (fieldKey == FieldKey.GENRE) {
                    if (string2 != null) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(fieldKey).getFrameId());
                        FrameBodyTCON frameBodyTCON = (FrameBodyTCON)abstractID3v2Frame.getBody();
                        frameBodyTCON.setV23Format();
                        if (TagOptionSingleton.getInstance().isWriteMp3GenresAsText()) {
                            frameBodyTCON.setText(string2);
                            return abstractID3v2Frame;
                        }
                        frameBodyTCON.setText(FrameBodyTCON.convertGenericToID3v23Genre(string2));
                        return abstractID3v2Frame;
                    }
                    throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
                }
                if (fieldKey == FieldKey.YEAR) {
                    if (string2.length() == 1) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame("TYER");
                        AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("000");
                        stringBuilder.append(string2);
                        abstractFrameBodyTextInfo.setText(stringBuilder.toString());
                        return abstractID3v2Frame;
                    }
                    if (string2.length() == 2) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame("TYER");
                        AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("00");
                        stringBuilder.append(string2);
                        abstractFrameBodyTextInfo.setText(stringBuilder.toString());
                        return abstractID3v2Frame;
                    }
                    if (string2.length() == 3) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame("TYER");
                        AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("0");
                        stringBuilder.append(string2);
                        abstractFrameBodyTextInfo.setText(stringBuilder.toString());
                        return abstractID3v2Frame;
                    }
                    if (string2.length() == 4) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame("TYER");
                        ((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).setText(string2);
                        return abstractID3v2Frame;
                    }
                    if (string2.length() > 4) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame("TYER");
                        ((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).setText(string2.substring(0, 4));
                        if (string2.length() >= 10) {
                            String string3 = string2.substring(5, 7);
                            String string4 = string2.substring(8, 10);
                            AbstractID3v2Frame abstractID3v2Frame2 = this.createFrame("TDAT");
                            AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame2.getBody();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string4);
                            stringBuilder.append(string3);
                            abstractFrameBodyTextInfo.setText(stringBuilder.toString());
                            TyerTdatAggregatedFrame tyerTdatAggregatedFrame = new TyerTdatAggregatedFrame();
                            tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame);
                            tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame2);
                            return tyerTdatAggregatedFrame;
                        }
                        if (string2.length() >= 7) {
                            String string5 = string2.substring(5, 7);
                            AbstractID3v2Frame abstractID3v2Frame3 = this.createFrame("TDAT");
                            AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame3.getBody();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("01");
                            stringBuilder.append(string5);
                            abstractFrameBodyTextInfo.setText(stringBuilder.toString());
                            TyerTdatAggregatedFrame tyerTdatAggregatedFrame = new TyerTdatAggregatedFrame();
                            tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame);
                            tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame3);
                            return tyerTdatAggregatedFrame;
                        }
                        return abstractID3v2Frame;
                    }
                    return null;
                }
                return super.createField(fieldKey, arrstring);
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new KeyNotFoundException();
    }

    public TagField createField(ID3v23FieldKey iD3v23FieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (iD3v23FieldKey != null) {
            return super.doCreateTagField(new Object(null, iD3v23FieldKey.getFrameId(), iD3v23FieldKey.getSubId()){
                private String frameId;
                private FieldKey genericKey;
                private String subId;
                {
                    this.genericKey = fieldKey;
                    this.frameId = string2;
                    this.subId = string3;
                }

                public String getFrameId() {
                    return this.frameId;
                }

                public FieldKey getGenericKey() {
                    return this.genericKey;
                }

                public String getSubId() {
                    return this.subId;
                }
            }, string2);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)abstractID3v2Frame.getBody();
        if (!artwork.isLinked()) {
            frameBodyAPIC.setObjectValue("PictureData", artwork.getBinaryData());
            frameBodyAPIC.setObjectValue("PictureType", artwork.getPictureType());
            frameBodyAPIC.setObjectValue("MIMEType", artwork.getMimeType());
            frameBodyAPIC.setObjectValue("Description", "");
            return abstractID3v2Frame;
        }
        try {
            frameBodyAPIC.setObjectValue("PictureData", artwork.getImageUrl().getBytes("ISO-8859-1"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
        frameBodyAPIC.setObjectValue("PictureType", artwork.getPictureType());
        frameBodyAPIC.setObjectValue("MIMEType", "-->");
        frameBodyAPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public ID3v23Frame createFrame(String string2) {
        return new ID3v23Frame(string2);
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("tag", this.getIdentifier());
        super.createStructureHeader();
        MP3File.getStructureFormatter().openHeadingElement("header", "");
        MP3File.getStructureFormatter().addElement(TYPE_UNSYNCHRONISATION, this.isUnsynchronization());
        MP3File.getStructureFormatter().addElement(TYPE_EXTENDED, this.extended);
        MP3File.getStructureFormatter().addElement(TYPE_EXPERIMENTAL, this.experimental);
        MP3File.getStructureFormatter().addElement(TYPE_CRCDATA, this.crc32);
        MP3File.getStructureFormatter().addElement(TYPE_PADDINGSIZE, this.paddingSize);
        MP3File.getStructureFormatter().closeHeadingElement("header");
        super.createStructureBody();
        MP3File.getStructureFormatter().closeHeadingElement("tag");
    }

    @Override
    public void deleteField(String string2) {
        super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
    }

    public void deleteField(ID3v23FieldKey iD3v23FieldKey) throws KeyNotFoundException {
        if (iD3v23FieldKey != null) {
            super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
            return;
        }
        throw new KeyNotFoundException();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v23Tag)) {
            return false;
        }
        ID3v23Tag iD3v23Tag = (ID3v23Tag)object;
        if (this.crc32 != iD3v23Tag.crc32) {
            return false;
        }
        if (this.crcDataFlag != iD3v23Tag.crcDataFlag) {
            return false;
        }
        if (this.experimental != iD3v23Tag.experimental) {
            return false;
        }
        if (this.extended != iD3v23Tag.extended) {
            return false;
        }
        int n2 = this.paddingSize;
        int n3 = iD3v23Tag.paddingSize;
        boolean bl = false;
        if (n2 == n3) {
            boolean bl2 = super.equals(object);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey == FieldKey.GENRE) {
            List<TagField> list = this.getFields(fieldKey);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                Iterator iterator = ((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)FrameBodyTCON.convertID3v23GenreToGeneric((String)iterator.next()));
                }
            }
            return arrayList;
        }
        if (fieldKey == FieldKey.YEAR) {
            List<TagField> list = this.getFields(fieldKey);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (TagField tagField : list) {
                    if (!(tagField instanceof TagTextField)) continue;
                    arrayList.add((Object)((TagTextField)tagField).getContent());
                }
            }
            return arrayList;
        }
        return super.getAll(fieldKey);
    }

    @Override
    public List<Artwork> getArtworkList() {
        List<TagField> list = this.getFields(FieldKey.COVER_ART);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)((AbstractID3v2Frame)((TagField)iterator.next())).getBody();
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setMimeType(frameBodyAPIC.getMimeType());
            artwork.setPictureType(frameBodyAPIC.getPictureType());
            if (frameBodyAPIC.isImageUrl()) {
                artwork.setLinked(true);
                artwork.setImageUrl(frameBodyAPIC.getImageUrl());
            } else {
                artwork.setBinaryData(frameBodyAPIC.getImageData());
            }
            arrayList.add((Object)artwork);
        }
        return arrayList;
    }

    public int getCrc32() {
        return this.crc32;
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.YEAR) {
                AggregatedFrame aggregatedFrame = (AggregatedFrame)this.getFrame("TYERTDAT");
                if (aggregatedFrame != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((Object)aggregatedFrame);
                    return arrayList;
                }
                return super.getFields(fieldKey);
            }
            return super.getFields(fieldKey);
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public String getFirst(ID3v23FieldKey iD3v23FieldKey) throws KeyNotFoundException {
        if (iD3v23FieldKey != null) {
            FieldKey fieldKey = ID3v23Frames.getInstanceOf().getGenericKeyFromId3(iD3v23FieldKey);
            if (fieldKey != null) {
                return super.getFirst(fieldKey);
            }
            return super.doGetValueAtIndex(new /* invalid duplicate definition of identical inner class */, 0);
        }
        throw new KeyNotFoundException();
    }

    @Override
    protected AbstractID3v2Tag.FrameAndSubId getFrameAndSubIdFromGenericKey(FieldKey fieldKey) {
        if (fieldKey != null) {
            ID3v23FieldKey iD3v23FieldKey = ID3v23Frames.getInstanceOf().getId3KeyFromGenericKey(fieldKey);
            if (iD3v23FieldKey != null) {
                return new /* invalid duplicate definition of identical inner class */;
            }
            throw new KeyNotFoundException(fieldKey.name());
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    protected ID3Frames getID3Frames() {
        return ID3v23Frames.getInstanceOf();
    }

    @Override
    public String getIdentifier() {
        return "ID3v2.30";
    }

    @Override
    public byte getMajorVersion() {
        return 3;
    }

    public int getPaddingSize() {
        return this.paddingSize;
    }

    @Override
    public Comparator getPreferredFrameOrderComparator() {
        return ID3v23PreferredFrameOrderComparator.getInstanceof();
    }

    @Override
    public byte getRelease() {
        return 2;
    }

    @Override
    public byte getRevision() {
        return 0;
    }

    @Override
    public int getSize() {
        boolean bl = this.extended;
        int n2 = 10;
        if (bl) {
            n2 += TAG_EXT_HEADER_LENGTH;
            if (this.crcDataFlag) {
                n2 += TAG_EXT_HEADER_CRC_LENGTH;
            }
        }
        return n2 + super.getSize();
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.YEAR) {
                AggregatedFrame aggregatedFrame = (AggregatedFrame)this.getFrame("TYERTDAT");
                if (aggregatedFrame != null) {
                    return aggregatedFrame.getContent();
                }
                return super.getValue(fieldKey, n2);
            }
            if (fieldKey == FieldKey.GENRE) {
                List<TagField> list = this.getFields(fieldKey);
                if (list != null && list.size() > 0) {
                    return FrameBodyTCON.convertID3v23GenreToGeneric((String)((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().get(n2));
                }
                return "";
            }
            return super.getValue(fieldKey, n2);
        }
        throw new KeyNotFoundException();
    }

    public boolean isUnsynchronization() {
        return this.unsynchronization;
    }

    @Override
    protected void loadFrameIntoMap(String string2, AbstractID3v2Frame abstractID3v2Frame) {
        if (abstractID3v2Frame.getBody() instanceof FrameBodyTCON) {
            ((FrameBodyTCON)abstractID3v2Frame.getBody()).setV23Format();
        }
        super.loadFrameIntoMap(string2, abstractID3v2Frame);
    }

    @Override
    protected void loadFrameIntoSpecifiedMap(HashMap hashMap, String string2, AbstractID3v2Frame abstractID3v2Frame) {
        if (!string2.equals((Object)"TYER") && !string2.equals((Object)"TDAT")) {
            super.loadFrameIntoSpecifiedMap(hashMap, string2, abstractID3v2Frame);
            return;
        }
        if (string2.equals((Object)"TDAT") && abstractID3v2Frame.getContent().length() == 0) {
            AbstractID3Tag.logger.warning("TDAT is empty so just ignoring");
            return;
        }
        if (!hashMap.containsKey((Object)string2) && !hashMap.containsKey((Object)"TYERTDAT")) {
            if (string2.equals((Object)"TYER")) {
                if (hashMap.containsKey((Object)"TDAT")) {
                    TyerTdatAggregatedFrame tyerTdatAggregatedFrame = new TyerTdatAggregatedFrame();
                    tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame);
                    tyerTdatAggregatedFrame.addFrame((AbstractID3v2Frame)hashMap.get((Object)"TDAT"));
                    hashMap.remove((Object)"TDAT");
                    hashMap.put((Object)"TYERTDAT", (Object)tyerTdatAggregatedFrame);
                    return;
                }
                hashMap.put((Object)"TYER", (Object)abstractID3v2Frame);
                return;
            }
            if (string2.equals((Object)"TDAT")) {
                if (hashMap.containsKey((Object)"TYER")) {
                    TyerTdatAggregatedFrame tyerTdatAggregatedFrame = new TyerTdatAggregatedFrame();
                    tyerTdatAggregatedFrame.addFrame((AbstractID3v2Frame)hashMap.get((Object)"TYER"));
                    tyerTdatAggregatedFrame.addFrame(abstractID3v2Frame);
                    hashMap.remove((Object)"TYER");
                    hashMap.put((Object)"TYERTDAT", (Object)tyerTdatAggregatedFrame);
                    return;
                }
                hashMap.put((Object)"TDAT", (Object)abstractID3v2Frame);
                return;
            }
        } else {
            if (this.duplicateFrameId.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.duplicateFrameId);
                stringBuilder.append(";");
                this.duplicateFrameId = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.duplicateFrameId);
            stringBuilder.append(string2);
            this.duplicateFrameId = stringBuilder.toString();
            this.duplicateBytes += abstractID3v2Frame.getSize();
        }
    }

    @Override
    protected void processDuplicateFrame(AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        if (abstractID3v2Frame.getIdentifier().equals((Object)"IPLS")) {
            PairedTextEncodedStringNullTerminated.ValuePairs valuePairs = ((FrameBodyIPLS)abstractID3v2Frame2.getBody()).getPairing();
            Iterator iterator = ((FrameBodyIPLS)abstractID3v2Frame.getBody()).getPairing().getMapping().iterator();
            while (iterator.hasNext()) {
                valuePairs.add((Pair)iterator.next());
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)abstractID3v2Frame2);
            arrayList.add((Object)abstractID3v2Frame);
            this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)arrayList);
        }
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws TagException {
        if (this.seek(byteBuffer)) {
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Reading ID3v23 tag");
            logger.config(stringBuilder.toString());
            this.readHeaderFlags(byteBuffer);
            int n2 = ID3SyncSafeInteger.bufferToValue(byteBuffer);
            Logger logger2 = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID_TAG_SIZE;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), n2};
            logger2.config(errorMessage.getMsg(arrobject));
            if (this.extended) {
                this.readExtendedHeader(byteBuffer, n2);
            }
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            if (this.isUnsynchronization()) {
                byteBuffer2 = ID3Unsynchronization.synchronize(byteBuffer2);
            }
            this.readFrames(byteBuffer2, n2);
            Logger logger3 = AbstractID3Tag.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":Loaded Frames,there are:");
            stringBuilder2.append(this.frameMap.keySet().size());
            logger3.config(stringBuilder2.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" tag not found");
        throw new TagNotFoundException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    protected void readFrames(ByteBuffer var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl274 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public long write(File file, long l2) throws IOException {
        this.setLoggingFilename(file.getName());
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing tag to file:");
        stringBuilder.append(this.getLoggingFilename());
        logger.config(stringBuilder.toString());
        byte[] arrby = this.writeFramesToBuffer().toByteArray();
        Logger logger2 = AbstractID3Tag.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.getLoggingFilename());
        stringBuilder2.append(":bodybytebuffer:sizebeforeunsynchronisation:");
        stringBuilder2.append(arrby.length);
        logger2.config(stringBuilder2.toString());
        boolean bl = TagOptionSingleton.getInstance().isUnsyncTags() && ID3Unsynchronization.requiresUnsynchronization(arrby);
        this.unsynchronization = bl;
        if (this.isUnsynchronization()) {
            arrby = ID3Unsynchronization.unsynchronize(arrby);
            Logger logger3 = AbstractID3Tag.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.getLoggingFilename());
            stringBuilder3.append(":bodybytebuffer:sizeafterunsynchronisation:");
            stringBuilder3.append(arrby.length);
            logger3.config(stringBuilder3.toString());
        }
        byte[] arrby2 = arrby;
        int n2 = this.calculateTagSize(10 + arrby2.length, (int)l2);
        int n3 = n2 - (10 + arrby2.length);
        Logger logger4 = AbstractID3Tag.logger;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.getLoggingFilename());
        stringBuilder4.append(":Current audiostart:");
        stringBuilder4.append(l2);
        logger4.config(stringBuilder4.toString());
        Logger logger5 = AbstractID3Tag.logger;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(this.getLoggingFilename());
        stringBuilder5.append(":Size including padding:");
        stringBuilder5.append(n2);
        logger5.config(stringBuilder5.toString());
        Logger logger6 = AbstractID3Tag.logger;
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(this.getLoggingFilename());
        stringBuilder6.append(":Padding:");
        stringBuilder6.append(n3);
        logger6.config(stringBuilder6.toString());
        this.writeBufferToFile(file, this.writeHeaderToBuffer(n3, arrby2.length), arrby2, n3, n2, l2);
        return n2;
    }

    @Override
    public void write(WritableByteChannel writableByteChannel, int n2) throws IOException {
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":Writing tag to channel");
        logger.config(stringBuilder.toString());
        byte[] arrby = this.writeFramesToBuffer().toByteArray();
        Logger logger2 = AbstractID3Tag.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.getLoggingFilename());
        stringBuilder2.append(":bodybytebuffer:sizebeforeunsynchronisation:");
        stringBuilder2.append(arrby.length);
        logger2.config(stringBuilder2.toString());
        boolean bl = TagOptionSingleton.getInstance().isUnsyncTags() && ID3Unsynchronization.requiresUnsynchronization(arrby);
        this.unsynchronization = bl;
        if (this.isUnsynchronization()) {
            arrby = ID3Unsynchronization.unsynchronize(arrby);
            Logger logger3 = AbstractID3Tag.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.getLoggingFilename());
            stringBuilder3.append(":bodybytebuffer:sizeafterunsynchronisation:");
            stringBuilder3.append(arrby.length);
            logger3.config(stringBuilder3.toString());
        }
        int n3 = 0;
        if (n2 > 0) {
            n3 = this.calculateTagSize(10 + arrby.length, n2) - (10 + arrby.length);
            Logger logger4 = AbstractID3Tag.logger;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(this.getLoggingFilename());
            stringBuilder4.append(":Padding:");
            stringBuilder4.append(n3);
            logger4.config(stringBuilder4.toString());
        }
        writableByteChannel.write(this.writeHeaderToBuffer(n3, arrby.length));
        writableByteChannel.write(ByteBuffer.wrap((byte[])arrby));
        this.writePadding(writableByteChannel, n3);
    }
}

