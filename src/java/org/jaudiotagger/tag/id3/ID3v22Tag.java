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
import org.jaudiotagger.tag.id3.AbstractID3Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Frames;
import org.jaudiotagger.tag.id3.ID3SyncSafeInteger;
import org.jaudiotagger.tag.id3.ID3Unsynchronization;
import org.jaudiotagger.tag.id3.ID3v22FieldKey;
import org.jaudiotagger.tag.id3.ID3v22Frame;
import org.jaudiotagger.tag.id3.ID3v22Frames;
import org.jaudiotagger.tag.id3.ID3v22PreferredFrameOrderComparator;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.reference.PictureTypes;

public class ID3v22Tag
extends AbstractID3v2Tag {
    public static final byte MAJOR_VERSION = 2;
    public static final int MASK_V22_COMPRESSION = 64;
    public static final int MASK_V22_UNSYNCHRONIZATION = 128;
    public static final byte RELEASE = 2;
    public static final byte REVISION = 0;
    protected static final String TYPE_COMPRESSION = "compression";
    protected static final String TYPE_UNSYNCHRONISATION = "unsyncronisation";
    protected boolean compression = false;
    protected boolean unsynchronization = false;

    public ID3v22Tag() {
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
    }

    public ID3v22Tag(ByteBuffer byteBuffer) throws TagException {
        this(byteBuffer, "");
    }

    public ID3v22Tag(ByteBuffer byteBuffer, String string2) throws TagException {
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    public ID3v22Tag(AbstractTag abstractTag) {
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
        AbstractID3Tag.logger.config("Creating tag from a tag of a different version");
        if (abstractTag != null) {
            if (!(abstractTag instanceof ID3v23Tag) && abstractTag instanceof ID3v22Tag) {
                throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
            }
            ID3v24Tag iD3v24Tag = abstractTag instanceof ID3v24Tag ? (ID3v24Tag)abstractTag : new ID3v24Tag(abstractTag);
            this.setLoggingFilename(iD3v24Tag.getLoggingFilename());
            this.copyPrimitives(iD3v24Tag);
            this.copyFrames(iD3v24Tag);
            AbstractID3Tag.logger.config("Created tag from a tag of a different version");
        }
    }

    public ID3v22Tag(ID3v22Tag iD3v22Tag) {
        super(iD3v22Tag);
        AbstractID3Tag.logger.config("Creating tag from another tag of same type");
        this.copyPrimitives(iD3v22Tag);
        this.copyFrames(iD3v22Tag);
    }

    private void readHeaderFlags(ByteBuffer byteBuffer) throws TagException {
        byte by = byteBuffer.get();
        boolean bl = (by & 128) != 0;
        this.unsynchronization = bl;
        boolean bl2 = (by & 64) != 0;
        this.compression = bl2;
        if (bl) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_UNSYNCHRONIZED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.compression) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_COMPRESSED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if ((by & 32) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 32};
            logger.warning(errorMessage.getMsg(arrobject));
        }
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
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 8};
            logger.warning(errorMessage.getMsg(arrobject));
        }
    }

    private ByteBuffer writeHeaderToBuffer(int n2, int n3) throws IOException {
        this.compression = false;
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)10);
        byteBuffer.put(AbstractID3v2Tag.TAG_ID);
        byteBuffer.put(this.getMajorVersion());
        byteBuffer.put(this.getRevision());
        boolean bl = this.unsynchronization;
        byte by = 0;
        if (bl) {
            by = -128;
        }
        if (this.compression) {
            by = (byte)(by | 64);
        }
        byteBuffer.put(by);
        byteBuffer.put(ID3SyncSafeInteger.valueToBuffer(n2 + n3));
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
            if (frameBodyTDRC.getYear().length() != 0) {
                ID3v22Frame iD3v22Frame = new ID3v22Frame("TYE");
                ((AbstractFrameBodyTextInfo)iD3v22Frame.getBody()).setText(frameBodyTDRC.getYear());
                arrayList.add((Object)iD3v22Frame);
            }
            if (frameBodyTDRC.getTime().length() != 0) {
                ID3v22Frame iD3v22Frame = new ID3v22Frame("TIM");
                ((AbstractFrameBodyTextInfo)iD3v22Frame.getBody()).setText(frameBodyTDRC.getTime());
                arrayList.add((Object)iD3v22Frame);
                return arrayList;
            }
        } else {
            arrayList.add((Object)new ID3v22Frame(abstractID3v2Frame));
        }
        return arrayList;
    }

    @Override
    protected void copyPrimitives(AbstractID3v2Tag abstractID3v2Tag) {
        AbstractID3Tag.logger.config("Copying primitives");
        super.copyPrimitives(abstractID3v2Tag);
        if (abstractID3v2Tag instanceof ID3v22Tag) {
            ID3v22Tag iD3v22Tag = (ID3v22Tag)abstractID3v2Tag;
            this.compression = iD3v22Tag.compression;
            this.unsynchronization = iD3v22Tag.unsynchronization;
            return;
        }
        if (abstractID3v2Tag instanceof ID3v23Tag) {
            ID3v23Tag iD3v23Tag = (ID3v23Tag)abstractID3v2Tag;
            this.compression = iD3v23Tag.compression;
            this.unsynchronization = iD3v23Tag.unsynchronization;
            return;
        }
        if (abstractID3v2Tag instanceof ID3v24Tag) {
            ID3v24Tag iD3v24Tag = (ID3v24Tag)abstractID3v2Tag;
            this.compression = false;
            this.unsynchronization = iD3v24Tag.unsynchronization;
        }
    }

    public TagField createArtworkField(byte[] arrby, String string2) {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        FrameBodyPIC frameBodyPIC = (FrameBodyPIC)abstractID3v2Frame.getBody();
        frameBodyPIC.setObjectValue("PictureData", arrby);
        frameBodyPIC.setObjectValue("PictureType", (Object)PictureTypes.DEFAULT_ID);
        frameBodyPIC.setObjectValue("ImageType", ImageFormats.getFormatForMimeType(string2));
        frameBodyPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != null) {
            if (arrstring != null) {
                String string2 = arrstring[0];
                if (fieldKey == FieldKey.GENRE) {
                    if (string2 != null) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(fieldKey).getFrameId());
                        FrameBodyTCON frameBodyTCON = (FrameBodyTCON)abstractID3v2Frame.getBody();
                        frameBodyTCON.setV23Format();
                        frameBodyTCON.setText(FrameBodyTCON.convertGenericToID3v22Genre(string2));
                        return abstractID3v2Frame;
                    }
                    throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
                }
                return super.createField(fieldKey, arrstring);
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new KeyNotFoundException();
    }

    public TagField createField(ID3v22FieldKey iD3v22FieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (iD3v22FieldKey != null) {
            return this.doCreateTagField(new Object(null, iD3v22FieldKey.getFrameId(), iD3v22FieldKey.getSubId()){
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
        FrameBodyPIC frameBodyPIC = (FrameBodyPIC)abstractID3v2Frame.getBody();
        if (!artwork.isLinked()) {
            frameBodyPIC.setObjectValue("PictureData", artwork.getBinaryData());
            frameBodyPIC.setObjectValue("PictureType", artwork.getPictureType());
            frameBodyPIC.setObjectValue("ImageType", ImageFormats.getFormatForMimeType(artwork.getMimeType()));
            frameBodyPIC.setObjectValue("Description", "");
            return abstractID3v2Frame;
        }
        try {
            frameBodyPIC.setObjectValue("PictureData", artwork.getImageUrl().getBytes("ISO-8859-1"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
        frameBodyPIC.setObjectValue("PictureType", artwork.getPictureType());
        frameBodyPIC.setObjectValue("ImageType", "-->");
        frameBodyPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public ID3v22Frame createFrame(String string2) {
        return new ID3v22Frame(string2);
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("tag", this.getIdentifier());
        super.createStructureHeader();
        MP3File.getStructureFormatter().openHeadingElement("header", "");
        MP3File.getStructureFormatter().addElement(TYPE_COMPRESSION, this.compression);
        MP3File.getStructureFormatter().addElement(TYPE_UNSYNCHRONISATION, this.unsynchronization);
        MP3File.getStructureFormatter().closeHeadingElement("header");
        super.createStructureBody();
        MP3File.getStructureFormatter().closeHeadingElement("tag");
    }

    @Override
    public void deleteField(String string2) {
        super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
    }

    public void deleteField(ID3v22FieldKey iD3v22FieldKey) throws KeyNotFoundException {
        if (iD3v22FieldKey != null) {
            super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
            return;
        }
        throw new KeyNotFoundException();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v22Tag)) {
            return false;
        }
        ID3v22Tag iD3v22Tag = (ID3v22Tag)object;
        if (this.compression != iD3v22Tag.compression) {
            return false;
        }
        boolean bl = this.unsynchronization;
        boolean bl2 = iD3v22Tag.unsynchronization;
        boolean bl3 = false;
        if (bl == bl2) {
            boolean bl4 = super.equals(object);
            bl3 = false;
            if (bl4) {
                bl3 = true;
            }
        }
        return bl3;
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey == FieldKey.GENRE) {
            List<TagField> list = this.getFields(fieldKey);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                Iterator iterator = ((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)FrameBodyTCON.convertID3v22GenreToGeneric((String)iterator.next()));
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
            FrameBodyPIC frameBodyPIC = (FrameBodyPIC)((AbstractID3v2Frame)((TagField)iterator.next())).getBody();
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setMimeType(ImageFormats.getMimeTypeForFormat(frameBodyPIC.getFormatType()));
            artwork.setPictureType(frameBodyPIC.getPictureType());
            if (frameBodyPIC.isImageUrl()) {
                artwork.setLinked(true);
                artwork.setImageUrl(frameBodyPIC.getImageUrl());
            } else {
                artwork.setBinaryData(frameBodyPIC.getImageData());
            }
            arrayList.add((Object)artwork);
        }
        return arrayList;
    }

    public String getFirst(ID3v22FieldKey iD3v22FieldKey) throws KeyNotFoundException {
        if (iD3v22FieldKey != null) {
            FieldKey fieldKey = ID3v22Frames.getInstanceOf().getGenericKeyFromId3(iD3v22FieldKey);
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
            ID3v22FieldKey iD3v22FieldKey = ID3v22Frames.getInstanceOf().getId3KeyFromGenericKey(fieldKey);
            if (iD3v22FieldKey != null) {
                return new /* invalid duplicate definition of identical inner class */;
            }
            throw new KeyNotFoundException(fieldKey.name());
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    protected ID3Frames getID3Frames() {
        return ID3v22Frames.getInstanceOf();
    }

    @Override
    public String getIdentifier() {
        return "ID3v2_2.20";
    }

    @Override
    public byte getMajorVersion() {
        return 2;
    }

    @Override
    public Comparator getPreferredFrameOrderComparator() {
        return ID3v22PreferredFrameOrderComparator.getInstanceof();
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
        return 10 + super.getSize();
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.GENRE) {
                List<TagField> list = this.getFields(fieldKey);
                if (list != null && list.size() > 0) {
                    return FrameBodyTCON.convertID3v22GenreToGeneric((String)((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().get(n2));
                }
                return "";
            }
            return super.getValue(fieldKey, n2);
        }
        throw new KeyNotFoundException();
    }

    public boolean isCompression() {
        return this.compression;
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
    public void read(ByteBuffer byteBuffer) throws TagException {
        if (this.seek(byteBuffer)) {
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Reading tag from file");
            logger.config(stringBuilder.toString());
            this.readHeaderFlags(byteBuffer);
            int n2 = ID3SyncSafeInteger.bufferToValue(byteBuffer);
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            if (this.unsynchronization) {
                byteBuffer2 = ID3Unsynchronization.synchronize(byteBuffer2);
            }
            this.readFrames(byteBuffer2, n2);
            Logger logger2 = AbstractID3Tag.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":Loaded Frames,there are:");
            stringBuilder2.append(this.frameMap.keySet().size());
            logger2.config(stringBuilder2.toString());
            return;
        }
        throw new TagNotFoundException("ID3v2.20 tag not found");
    }

    /*
     * Exception decompiling
     */
    protected void readFrames(ByteBuffer var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl239 : RETURN : trying to set 0 previously set to 1
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

    protected void translateFrame(AbstractID3v2Frame abstractID3v2Frame) {
        FrameBodyTDRC frameBodyTDRC = (FrameBodyTDRC)abstractID3v2Frame.getBody();
        if (frameBodyTDRC.getYear().length() != 0) {
            ID3v22Frame iD3v22Frame = new ID3v22Frame("TYE");
            ((AbstractFrameBodyTextInfo)iD3v22Frame.getBody()).setText(frameBodyTDRC.getYear());
            this.frameMap.put((Object)iD3v22Frame.getIdentifier(), (Object)iD3v22Frame);
        }
        if (frameBodyTDRC.getTime().length() != 0) {
            ID3v22Frame iD3v22Frame = new ID3v22Frame("TIM");
            ((AbstractFrameBodyTextInfo)iD3v22Frame.getBody()).setText(frameBodyTDRC.getTime());
            this.frameMap.put((Object)iD3v22Frame.getIdentifier(), (Object)iD3v22Frame);
        }
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
        boolean bl = TagOptionSingleton.getInstance().isUnsyncTags() && ID3Unsynchronization.requiresUnsynchronization(arrby);
        this.unsynchronization = bl;
        if (this.isUnsynchronization()) {
            arrby = ID3Unsynchronization.unsynchronize(arrby);
            Logger logger2 = AbstractID3Tag.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":bodybytebuffer:sizeafterunsynchronisation:");
            stringBuilder2.append(arrby.length);
            logger2.config(stringBuilder2.toString());
        }
        byte[] arrby2 = arrby;
        int n2 = this.calculateTagSize(10 + arrby2.length, (int)l2);
        int n3 = n2 - (10 + arrby2.length);
        Logger logger3 = AbstractID3Tag.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.getLoggingFilename());
        stringBuilder3.append(":Current audiostart:");
        stringBuilder3.append(l2);
        logger3.config(stringBuilder3.toString());
        Logger logger4 = AbstractID3Tag.logger;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.getLoggingFilename());
        stringBuilder4.append(":Size including padding:");
        stringBuilder4.append(n2);
        logger4.config(stringBuilder4.toString());
        Logger logger5 = AbstractID3Tag.logger;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(this.getLoggingFilename());
        stringBuilder5.append(":Padding:");
        stringBuilder5.append(n3);
        logger5.config(stringBuilder5.toString());
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
        }
        writableByteChannel.write(this.writeHeaderToBuffer(n3, arrby.length));
        writableByteChannel.write(ByteBuffer.wrap((byte[])arrby));
        this.writePadding(writableByteChannel, n3);
    }
}

