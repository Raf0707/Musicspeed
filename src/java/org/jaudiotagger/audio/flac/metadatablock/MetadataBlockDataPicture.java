/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.reference.PictureTypes;

public class MetadataBlockDataPicture
implements MetadataBlockData,
TagField {
    public static final String IMAGE_IS_URL = "-->";
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac.MetadataBlockDataPicture");
    private int colourDepth;
    private String description;
    private int height;
    private byte[] imageData;
    private int indexedColouredCount;
    private int lengthOfPictureInBytes;
    private String mimeType = "";
    private int pictureType;
    private int width;

    public MetadataBlockDataPicture(ByteBuffer byteBuffer) throws IOException, InvalidFrameException {
        this.initFromByteBuffer(byteBuffer);
    }

    public MetadataBlockDataPicture(MetadataBlockHeader metadataBlockHeader, FileChannel fileChannel) throws IOException, InvalidFrameException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)metadataBlockHeader.getDataLength());
        int n2 = fileChannel.read(byteBuffer);
        if (n2 >= metadataBlockHeader.getDataLength()) {
            byteBuffer.rewind();
            this.initFromByteBuffer(byteBuffer);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to read required number of databytes read:");
        stringBuilder.append(n2);
        stringBuilder.append(":required:");
        stringBuilder.append(metadataBlockHeader.getDataLength());
        throw new IOException(stringBuilder.toString());
    }

    public MetadataBlockDataPicture(byte[] arrby, int n2, String string2, String string3, int n3, int n4, int n5, int n6) {
        this.pictureType = n2;
        if (string2 != null) {
            this.mimeType = string2;
        }
        this.description = string3;
        this.width = n3;
        this.height = n4;
        this.colourDepth = n5;
        this.indexedColouredCount = n6;
        this.imageData = arrby;
    }

    private String getString(ByteBuffer byteBuffer, int n2, String string2) throws IOException {
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        return new String(arrby, string2);
    }

    private void initFromByteBuffer(ByteBuffer byteBuffer) throws IOException, InvalidFrameException {
        int n2;
        this.pictureType = n2 = byteBuffer.getInt();
        if (n2 < PictureTypes.getInstanceOf().getSize()) {
            int n3;
            this.mimeType = this.getString(byteBuffer, byteBuffer.getInt(), StandardCharsets.ISO_8859_1.name());
            this.description = this.getString(byteBuffer, byteBuffer.getInt(), StandardCharsets.UTF_8.name());
            this.width = byteBuffer.getInt();
            this.height = byteBuffer.getInt();
            this.colourDepth = byteBuffer.getInt();
            this.indexedColouredCount = byteBuffer.getInt();
            this.lengthOfPictureInBytes = n3 = byteBuffer.getInt();
            byte[] arrby = new byte[n3];
            this.imageData = arrby;
            byteBuffer.get(arrby);
            Logger logger = MetadataBlockDataPicture.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Read image:");
            stringBuilder.append(this.toString());
            logger.config(stringBuilder.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PictureType was:");
        stringBuilder.append(this.pictureType);
        stringBuilder.append("but the maximum allowed is ");
        stringBuilder.append(-1 + PictureTypes.getInstanceOf().getSize());
        throw new InvalidFrameException(stringBuilder.toString());
    }

    @Override
    public void copyContent(TagField tagField) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ByteBuffer getBytes() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.pictureType));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.mimeType.length()));
            byteArrayOutputStream.write(this.mimeType.getBytes(StandardCharsets.ISO_8859_1));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.description.length()));
            byteArrayOutputStream.write(this.description.getBytes(StandardCharsets.UTF_8));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.width));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.height));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.colourDepth));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.indexedColouredCount));
            byteArrayOutputStream.write(Utils.getSizeBEInt32(this.imageData.length));
            byteArrayOutputStream.write(this.imageData);
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
            return byteBuffer;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException.getMessage());
        }
    }

    public int getColourDepth() {
        return this.colourDepth;
    }

    public String getDescription() {
        return this.description;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String getId() {
        return FieldKey.COVER_ART.name();
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public String getImageUrl() {
        if (this.isImageUrl()) {
            return new String(this.getImageData(), 0, this.getImageData().length, StandardCharsets.ISO_8859_1);
        }
        return "";
    }

    public int getIndexedColourCount() {
        return this.indexedColouredCount;
    }

    @Override
    public int getLength() {
        return this.getBytes().limit();
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getPictureType() {
        return this.pictureType;
    }

    @Override
    public byte[] getRawContent() throws UnsupportedEncodingException {
        return this.getBytes().array();
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public void isBinary(boolean bl) {
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isCommon() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public boolean isImageUrl() {
        return this.getMimeType().equals((Object)IMAGE_IS_URL);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PictureTypes.getInstanceOf().getValueForId(this.pictureType));
        stringBuilder.append(":");
        stringBuilder.append(this.mimeType);
        stringBuilder.append(":");
        stringBuilder.append(this.description);
        stringBuilder.append(":width:");
        stringBuilder.append(this.width);
        stringBuilder.append(":height:");
        stringBuilder.append(this.height);
        stringBuilder.append(":colourdepth:");
        stringBuilder.append(this.colourDepth);
        stringBuilder.append(":indexedColourCount:");
        stringBuilder.append(this.indexedColouredCount);
        stringBuilder.append(":image size in bytes:");
        stringBuilder.append(this.lengthOfPictureInBytes);
        stringBuilder.append("/");
        stringBuilder.append(this.imageData.length);
        return stringBuilder.toString();
    }
}

