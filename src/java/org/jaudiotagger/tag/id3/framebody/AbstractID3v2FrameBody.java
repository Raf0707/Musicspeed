/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;

public abstract class AbstractID3v2FrameBody
extends AbstractTagFrameBody {
    protected static final String TYPE_BODY = "body";
    private int size;

    protected AbstractID3v2FrameBody() {
    }

    protected AbstractID3v2FrameBody(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        this.setSize(n2);
        this.read(byteBuffer);
    }

    protected AbstractID3v2FrameBody(AbstractID3v2FrameBody abstractID3v2FrameBody) {
        super(abstractID3v2FrameBody);
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement(TYPE_BODY, "");
        Iterator iterator = this.objectList.iterator();
        while (iterator.hasNext()) {
            ((AbstractDataType)iterator.next()).createStructure();
        }
        MP3File.getStructureFormatter().closeHeadingElement(TYPE_BODY);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof AbstractID3v2FrameBody && super.equals(object);
    }

    @Override
    public abstract String getIdentifier();

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        int n2 = this.getSize();
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading body for");
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(":");
        stringBuilder.append(n2);
        logger.config(stringBuilder.toString());
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        Iterator iterator = this.objectList.iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            AbstractDataType abstractDataType = (AbstractDataType)iterator.next();
            Logger logger2 = AbstractTagItem.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("offset:");
            stringBuilder2.append(n3);
            logger2.finest(stringBuilder2.toString());
            if (n3 <= n2) {
                try {
                    abstractDataType.readByteArray(arrby, n3);
                }
                catch (InvalidDataTypeException invalidDataTypeException) {
                    Logger logger3 = AbstractTagItem.logger;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Problem reading datatype within Frame Body:");
                    stringBuilder3.append(invalidDataTypeException.getMessage());
                    logger3.warning(stringBuilder3.toString());
                    throw invalidDataTypeException;
                }
                n3 += abstractDataType.getSize();
                continue;
            }
            AbstractTagItem.logger.warning("Invalid Size for FrameBody");
            throw new InvalidFrameException("Invalid size for Frame Body");
        }
    }

    public void setSize() {
        this.size = 0;
        for (AbstractDataType abstractDataType : this.objectList) {
            this.size += abstractDataType.getSize();
        }
    }

    public void setSize(int n2) {
        this.size = n2;
    }

    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing frame body for");
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(":Est Size:");
        stringBuilder.append(this.size);
        logger.config(stringBuilder.toString());
        Iterator iterator = this.objectList.iterator();
        while (iterator.hasNext()) {
            byte[] arrby = ((AbstractDataType)iterator.next()).writeByteArray();
            if (arrby == null) continue;
            try {
                byteArrayOutputStream.write(arrby);
            }
            catch (IOException iOException) {
                throw new RuntimeException((Throwable)iOException);
            }
        }
        this.setSize();
        Logger logger2 = AbstractTagItem.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Written frame body for");
        stringBuilder2.append(this.getIdentifier());
        stringBuilder2.append(":Real Size:");
        stringBuilder2.append(this.size);
        logger2.config(stringBuilder2.toString());
    }
}

