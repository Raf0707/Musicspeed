/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.PaddingException
 *  org.jaudiotagger.tag.id3.ID3v23Frame
 *  org.jaudiotagger.tag.id3.ID3v24Frame
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyEncrypted
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.PaddingException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyEncrypted;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.utils.EqualsUtil;

public abstract class AbstractID3v2Frame
extends AbstractTagFrame
implements TagTextField {
    protected static final String TYPE_FRAME = "frame";
    protected static final String TYPE_FRAME_SIZE = "frameSize";
    protected static final String UNSUPPORTED_ID = "Unsupported";
    EncodingFlags encodingFlags = null;
    protected int frameSize;
    protected String identifier = "";
    private String loggingFilename = "";
    StatusFlags statusFlags = null;

    protected AbstractID3v2Frame() {
    }

    public AbstractID3v2Frame(String string2) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Creating empty frame of type");
        stringBuilder.append(string2);
        logger.config(stringBuilder.toString());
        this.identifier = string2;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("org.jaudiotagger.tag.id3.framebody.FrameBody");
            stringBuilder2.append(string2);
            this.frameBody = (AbstractTagFrameBody)Class.forName((String)stringBuilder2.toString()).newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger logger2 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("IllegalAccessException:");
            stringBuilder3.append(string2);
            logger2.log(level, stringBuilder3.toString(), (Throwable)illegalAccessException);
            throw new RuntimeException((Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            Logger logger3 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("InstantiationException:");
            stringBuilder4.append(string2);
            logger3.log(level, stringBuilder4.toString(), (Throwable)instantiationException);
            throw new RuntimeException((Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            AbstractTagItem.logger.severe(classNotFoundException.getMessage());
            this.frameBody = new FrameBodyUnsupported(string2);
        }
        this.frameBody.setHeader(this);
        if (this instanceof ID3v24Frame) {
            this.frameBody.setTextEncoding(TagOptionSingleton.getInstance().getId3v24DefaultTextEncoding());
        } else if (this instanceof ID3v23Frame) {
            this.frameBody.setTextEncoding(TagOptionSingleton.getInstance().getId3v23DefaultTextEncoding());
        }
        Logger logger4 = AbstractTagItem.logger;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Created empty frame of type");
        stringBuilder5.append(string2);
        logger4.config(stringBuilder5.toString());
    }

    public AbstractID3v2Frame(AbstractID3v2Frame abstractID3v2Frame) {
        super(abstractID3v2Frame);
    }

    public AbstractID3v2Frame(AbstractID3v2FrameBody abstractID3v2FrameBody) {
        this.frameBody = abstractID3v2FrameBody;
        abstractID3v2FrameBody.setHeader(this);
    }

    @Override
    public void copyContent(TagField tagField) {
    }

    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement(TYPE_FRAME, this.getIdentifier());
        MP3File.getStructureFormatter().closeHeadingElement(TYPE_FRAME);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AbstractID3v2Frame)) {
            return false;
        }
        return super.equals((AbstractID3v2Frame)object);
    }

    @Override
    public String getContent() {
        return this.getBody().getUserFriendlyValue();
    }

    @Override
    public Charset getEncoding() {
        byte by = this.getBody().getTextEncoding();
        return TextEncoding.getInstanceOf().getCharsetForId(by);
    }

    public EncodingFlags getEncodingFlags() {
        return this.encodingFlags;
    }

    protected abstract int getFrameHeaderSize();

    protected abstract int getFrameIdSize();

    protected abstract int getFrameSizeSize();

    @Override
    public String getId() {
        return this.getIdentifier();
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    protected String getLoggingFilename() {
        return this.loggingFilename;
    }

    @Override
    public byte[] getRawContent() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.write(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public StatusFlags getStatusFlags() {
        return this.statusFlags;
    }

    @Override
    public void isBinary(boolean bl) {
    }

    @Override
    public boolean isEmpty() {
        return this.getBody() == null;
    }

    protected boolean isPadding(byte[] arrby) {
        return arrby[0] == 0 && arrby[1] == 0 && arrby[2] == 0 && arrby[3] == 0;
    }

    /*
     * Exception decompiling
     */
    protected AbstractID3v2FrameBody readBody(String var1, ByteBuffer var2, int var3) throws InvalidFrameException, InvalidDataTypeException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl263 : GETSTATIC : trying to set 1 previously set to 0
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

    protected AbstractID3v2FrameBody readBody(String string2, AbstractID3v2FrameBody abstractID3v2FrameBody) throws InvalidFrameException {
        AbstractID3v2FrameBody abstractID3v2FrameBody2;
        Logger logger;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("org.jaudiotagger.tag.id3.framebody.FrameBody");
            stringBuilder.append(string2);
            Class class_ = Class.forName((String)stringBuilder.toString());
            Class[] arrclass = new Class[]{abstractID3v2FrameBody.getClass()};
            Object[] arrobject = new Object[]{abstractID3v2FrameBody};
            abstractID3v2FrameBody2 = (AbstractID3v2FrameBody)class_.getConstructor(arrclass).newInstance(arrobject);
            logger = AbstractTagItem.logger;
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger logger2 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal access exception :");
            stringBuilder.append(illegalAccessException.getMessage());
            logger2.log(level, stringBuilder.toString(), (Throwable)illegalAccessException);
            throw new RuntimeException(illegalAccessException.getMessage());
        }
        catch (InstantiationException instantiationException) {
            Logger logger3 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Instantiation exception:");
            stringBuilder.append(instantiationException.getMessage());
            logger3.log(level, stringBuilder.toString(), (Throwable)instantiationException);
            throw new RuntimeException(instantiationException.getMessage());
        }
        catch (InvocationTargetException invocationTargetException) {
            AbstractTagItem.logger.severe("An error occurred within abstractID3v2FrameBody");
            Logger logger4 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invocation target exception:");
            stringBuilder.append(invocationTargetException.getCause().getMessage());
            logger4.log(level, stringBuilder.toString(), invocationTargetException.getCause());
            if (!(invocationTargetException.getCause() instanceof Error)) {
                if (invocationTargetException.getCause() instanceof RuntimeException) {
                    throw (RuntimeException)invocationTargetException.getCause();
                }
                throw new InvalidFrameException(invocationTargetException.getCause().getMessage());
            }
            throw (Error)invocationTargetException.getCause();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Logger logger5 = AbstractTagItem.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No such method:");
            stringBuilder.append(noSuchMethodException.getMessage());
            logger5.log(level, stringBuilder.toString(), (Throwable)noSuchMethodException);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("FrameBody");
            stringBuilder2.append(string2);
            stringBuilder2.append(" does not have a constructor that takes:");
            stringBuilder2.append(abstractID3v2FrameBody.getClass().getName());
            throw new InvalidFrameException(stringBuilder2.toString());
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger logger6 = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Identifier not recognised:");
            stringBuilder.append(string2);
            stringBuilder.append(" unable to create framebody");
            logger6.config(stringBuilder.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("FrameBody");
            stringBuilder3.append(string2);
            stringBuilder3.append(" does not exist");
            throw new InvalidFrameException(stringBuilder3.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("frame Body created");
        stringBuilder.append(abstractID3v2FrameBody2.getIdentifier());
        logger.finer(stringBuilder.toString());
        abstractID3v2FrameBody2.setHeader(this);
        return abstractID3v2FrameBody2;
    }

    protected AbstractID3v2FrameBody readEncryptedBody(String string2, ByteBuffer byteBuffer, int n2) throws InvalidFrameException, InvalidDataTypeException {
        try {
            FrameBodyEncrypted frameBodyEncrypted = new FrameBodyEncrypted(string2, byteBuffer, n2);
            frameBodyEncrypted.setHeader(this);
            return frameBodyEncrypted;
        }
        catch (InvalidTagException invalidTagException) {
            throw new InvalidDataTypeException((Throwable)invalidTagException);
        }
    }

    protected String readIdentifier(ByteBuffer byteBuffer) throws PaddingException, InvalidFrameException {
        byte[] arrby = new byte[this.getFrameIdSize()];
        if (this.getFrameIdSize() <= byteBuffer.remaining()) {
            byteBuffer.get(arrby, 0, this.getFrameIdSize());
        }
        if (!this.isPadding(arrby)) {
            if (this.getFrameHeaderSize() - this.getFrameIdSize() <= byteBuffer.remaining()) {
                this.identifier = new String(arrby);
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.getLoggingFilename());
                stringBuilder.append(":Identifier is");
                stringBuilder.append(this.identifier);
                logger.fine(stringBuilder.toString());
                return this.identifier;
            }
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":No space to find another frame:");
            logger.warning(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":No space to find another frame");
            throw new InvalidFrameException(stringBuilder2.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":only padding found");
        throw new PaddingException(stringBuilder.toString());
    }

    @Override
    public void setContent(String string2) {
        throw new UnsupportedOperationException("Not implemented please use the generic tag methods for setting content");
    }

    protected void setLoggingFilename(String string2) {
        this.loggingFilename = string2;
    }

    public abstract void write(ByteArrayOutputStream var1);

}

