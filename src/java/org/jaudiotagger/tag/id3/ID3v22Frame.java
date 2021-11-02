/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.math.BigInteger
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.EmptyFrameException;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidFrameIdentifierException;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.id3.ID3v22Frames;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyDeprecated;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.utils.EqualsUtil;

public class ID3v22Frame
extends AbstractID3v2Frame {
    protected static final int FRAME_HEADER_SIZE = 6;
    protected static final int FRAME_ID_SIZE = 3;
    protected static final int FRAME_SIZE_SIZE = 3;
    private static Pattern validFrameIdentifier = Pattern.compile((String)"[A-Z][0-9A-Z]{2}");

    public ID3v22Frame() {
    }

    public ID3v22Frame(String string2) {
        String string3;
        block6 : {
            block4 : {
                block5 : {
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Creating empty frame of type");
                    stringBuilder.append(string2);
                    logger.config(stringBuilder.toString());
                    this.identifier = string2;
                    if (!ID3Tags.isID3v22FrameIdentifier(string2) || ID3Tags.forceFrameID22To23(string2) != null || string2.equals((Object)"CRM")) break block4;
                    if (string2.equals((Object)"TYE") || string2.equals((Object)"TIM")) break block5;
                    if (!ID3Tags.isID3v22FrameIdentifier(string2)) break block4;
                    string3 = ID3Tags.convertFrameID22To23(string2);
                    break block6;
                }
                string3 = "TDRC";
                break block6;
            }
            string3 = string2;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("org.jaudiotagger.tag.id3.framebody.FrameBody");
            stringBuilder.append(string3);
            this.frameBody = (AbstractTagFrameBody)Class.forName((String)stringBuilder.toString()).newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            AbstractTagItem.logger.log(Level.SEVERE, illegalAccessException.getMessage(), (Throwable)illegalAccessException);
            throw new RuntimeException((Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            AbstractTagItem.logger.log(Level.SEVERE, instantiationException.getMessage(), (Throwable)instantiationException);
            throw new RuntimeException((Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            AbstractTagItem.logger.log(Level.SEVERE, classNotFoundException.getMessage(), (Throwable)classNotFoundException);
            this.frameBody = new FrameBodyUnsupported(string2);
        }
        this.frameBody.setHeader(this);
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created empty frame of type");
        stringBuilder.append(this.identifier);
        stringBuilder.append("with frame body of");
        stringBuilder.append(string3);
        logger.config(stringBuilder.toString());
    }

    public ID3v22Frame(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        this(byteBuffer, "");
    }

    public ID3v22Frame(ByteBuffer byteBuffer, String string2) throws InvalidFrameException, InvalidDataTypeException {
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    public ID3v22Frame(AbstractID3v2Frame abstractID3v2Frame) throws InvalidFrameException {
        AbstractTagItem.logger.config("Creating frame from a frame of a different version");
        if (!(abstractID3v2Frame instanceof ID3v22Frame)) {
            if (abstractID3v2Frame instanceof ID3v24Frame) {
                this.createV22FrameFromV23Frame(new ID3v23Frame(abstractID3v2Frame));
            } else if (abstractID3v2Frame instanceof ID3v23Frame) {
                this.createV22FrameFromV23Frame((ID3v23Frame)abstractID3v2Frame);
            }
            this.frameBody.setHeader(this);
            AbstractTagItem.logger.config("Created frame from a frame of a different version");
            return;
        }
        throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
    }

    public ID3v22Frame(ID3v22Frame iD3v22Frame) {
        super(iD3v22Frame);
        AbstractTagItem.logger.config("Creating frame from a frame of same version");
    }

    public ID3v22Frame(AbstractID3v2FrameBody abstractID3v2FrameBody) {
        super(abstractID3v2FrameBody);
    }

    private void createV22FrameFromV23Frame(ID3v23Frame iD3v23Frame) throws InvalidFrameException {
        String string2;
        this.identifier = string2 = ID3Tags.convertFrameID23To22(iD3v23Frame.getIdentifier());
        if (string2 != null) {
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("V2:Orig id is:");
            stringBuilder.append(iD3v23Frame.getIdentifier());
            stringBuilder.append(":New id is:");
            stringBuilder.append(this.identifier);
            logger.config(stringBuilder.toString());
            this.frameBody = (AbstractID3v2FrameBody)ID3Tags.copyObject(iD3v23Frame.getBody());
            return;
        }
        if (ID3Tags.isID3v23FrameIdentifier(iD3v23Frame.getIdentifier())) {
            String string3;
            this.identifier = string3 = ID3Tags.forceFrameID23To22(iD3v23Frame.getIdentifier());
            if (string3 != null) {
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("V2:Force:Orig id is:");
                stringBuilder.append(iD3v23Frame.getIdentifier());
                stringBuilder.append(":New id is:");
                stringBuilder.append(this.identifier);
                logger.config(stringBuilder.toString());
                this.frameBody = this.readBody(this.identifier, (AbstractID3v2FrameBody)iD3v23Frame.getBody());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to convert v23 frame:");
            stringBuilder.append(iD3v23Frame.getIdentifier());
            stringBuilder.append(" to a v22 frame");
            throw new InvalidFrameException(stringBuilder.toString());
        }
        if (iD3v23Frame.getBody() instanceof FrameBodyDeprecated) {
            if (ID3Tags.isID3v22FrameIdentifier(iD3v23Frame.getIdentifier())) {
                this.frameBody = iD3v23Frame.getBody();
                this.identifier = iD3v23Frame.getIdentifier();
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DEPRECATED:Orig id is:");
                stringBuilder.append(iD3v23Frame.getIdentifier());
                stringBuilder.append(":New id is:");
                stringBuilder.append(this.identifier);
                logger.config(stringBuilder.toString());
                return;
            }
            this.frameBody = new FrameBodyDeprecated((FrameBodyDeprecated)iD3v23Frame.getBody());
            this.identifier = iD3v23Frame.getIdentifier();
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DEPRECATED:Orig id is:");
            stringBuilder.append(iD3v23Frame.getIdentifier());
            stringBuilder.append(":New id is:");
            stringBuilder.append(this.identifier);
            logger.config(stringBuilder.toString());
            return;
        }
        this.frameBody = new FrameBodyUnsupported((FrameBodyUnsupported)iD3v23Frame.getBody());
        this.identifier = iD3v23Frame.getIdentifier();
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v2:UNKNOWN:Orig id is:");
        stringBuilder.append(iD3v23Frame.getIdentifier());
        stringBuilder.append(":New id is:");
        stringBuilder.append(this.identifier);
        logger.config(stringBuilder.toString());
    }

    private int decodeSize(byte[] arrby) {
        int n2 = new BigInteger(arrby).intValue();
        if (n2 < 0) {
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Frame Size of:");
            stringBuilder.append(n2);
            stringBuilder.append("Decoded from bin:");
            stringBuilder.append(Integer.toBinaryString((int)n2));
            stringBuilder.append("Decoded from hex:");
            stringBuilder.append(Integer.toHexString((int)n2));
            logger.warning(stringBuilder.toString());
        }
        return n2;
    }

    private void encodeSize(ByteBuffer byteBuffer, int n2) {
        byteBuffer.put((byte)((16711680 & n2) >> 16));
        byteBuffer.put((byte)((65280 & n2) >> 8));
        byteBuffer.put((byte)(n2 & 255));
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Frame Size Is Actual:");
        stringBuilder.append(n2);
        stringBuilder.append(":Encoded bin:");
        stringBuilder.append(Integer.toBinaryString((int)n2));
        stringBuilder.append(":Encoded Hex");
        stringBuilder.append(Integer.toHexString((int)n2));
        logger.fine(stringBuilder.toString());
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("frame", this.getIdentifier());
        MP3File.getStructureFormatter().addElement("frameSize", this.frameSize);
        this.frameBody.createStructure();
        MP3File.getStructureFormatter().closeHeadingElement("frame");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ID3v22Frame)) {
            return false;
        }
        ID3v22Frame iD3v22Frame = (ID3v22Frame)object;
        return EqualsUtil.areEqual(this.statusFlags, iD3v22Frame.statusFlags) && EqualsUtil.areEqual(this.encodingFlags, iD3v22Frame.encodingFlags) && super.equals(iD3v22Frame);
    }

    @Override
    protected int getFrameHeaderSize() {
        return 6;
    }

    @Override
    protected int getFrameIdSize() {
        return 3;
    }

    @Override
    protected int getFrameSizeSize() {
        return 3;
    }

    @Override
    public int getSize() {
        return this.frameBody.getSize() + this.getFrameHeaderSize();
    }

    @Override
    public boolean isBinary() {
        return ID3v22Frames.getInstanceOf().isBinary(this.getId());
    }

    @Override
    public boolean isCommon() {
        return ID3v22Frames.getInstanceOf().isCommon(this.getId());
    }

    @Override
    protected boolean isPadding(byte[] arrby) {
        return arrby[0] == 0 && arrby[1] == 0 && arrby[2] == 0;
    }

    public boolean isValidID3v2FrameIdentifier(String string2) {
        return validFrameIdentifier.matcher((CharSequence)string2).matches();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidFrameException, InvalidDataTypeException {
        String string2 = this.readIdentifier(byteBuffer);
        byte[] arrby = new byte[this.getFrameSizeSize()];
        if (this.isValidID3v2FrameIdentifier(string2)) {
            int n2;
            byteBuffer.get(arrby, 0, this.getFrameSizeSize());
            this.frameSize = n2 = this.decodeSize(arrby);
            if (n2 >= 0) {
                if (n2 != 0) {
                    if (n2 <= byteBuffer.remaining()) {
                        Logger logger = AbstractTagItem.logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Frame Size Is:");
                        stringBuilder.append(this.frameSize);
                        logger.fine(stringBuilder.toString());
                        String string3 = ID3Tags.convertFrameID22To24(string2);
                        if (string3 == null && (string3 = ID3Tags.convertFrameID22To23(string2)) == null) {
                            string3 = ID3Tags.isID3v22FrameIdentifier(string2) ? string2 : "Unsupported";
                        }
                        Logger logger2 = AbstractTagItem.logger;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Identifier was:");
                        stringBuilder2.append(string2);
                        stringBuilder2.append(" reading using:");
                        stringBuilder2.append(string3);
                        logger2.fine(stringBuilder2.toString());
                        ByteBuffer byteBuffer2 = byteBuffer.slice();
                        byteBuffer2.limit(this.frameSize);
                        try {
                            this.frameBody = this.readBody(string3, byteBuffer2, this.frameSize);
                            return;
                        }
                        finally {
                            byteBuffer.position(byteBuffer.position() + this.frameSize);
                        }
                    }
                    Logger logger = AbstractTagItem.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid Frame size larger than size before mp3 audio:");
                    stringBuilder.append(string2);
                    logger.warning(stringBuilder.toString());
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(string2);
                    stringBuilder3.append(" is invalid frame");
                    throw new InvalidFrameException(stringBuilder3.toString());
                }
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Empty Frame:");
                stringBuilder.append(string2);
                logger.warning(stringBuilder.toString());
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string2);
                stringBuilder4.append(" is empty frame");
                throw new EmptyFrameException(stringBuilder4.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" has invalid size of:");
            stringBuilder.append(this.frameSize);
            throw new InvalidFrameException(stringBuilder.toString());
        }
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid identifier:");
        stringBuilder.append(string2);
        logger.config(stringBuilder.toString());
        byteBuffer.position(byteBuffer.position() - (-1 + this.getFrameIdSize()));
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(this.getLoggingFilename());
        stringBuilder5.append(":");
        stringBuilder5.append(string2);
        stringBuilder5.append(":is not a valid ID3v2.20 frame");
        throw new InvalidFrameIdentifierException(stringBuilder5.toString());
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
        stringBuilder.append("Write Frame to Buffer");
        stringBuilder.append(this.getIdentifier());
        logger.config(stringBuilder.toString());
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.getFrameHeaderSize());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ((AbstractID3v2FrameBody)this.frameBody).write(byteArrayOutputStream2);
        byteBuffer.put(this.getIdentifier().getBytes(StandardCharsets.ISO_8859_1), 0, this.getFrameIdSize());
        this.encodeSize(byteBuffer, this.frameBody.getSize());
        try {
            byteArrayOutputStream.write(byteBuffer.array());
            byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }
}

