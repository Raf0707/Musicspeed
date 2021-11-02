/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package org.jaudiotagger.tag.images;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.reference.PictureTypes;

public class AndroidArtwork
implements Artwork {
    private byte[] binaryData;
    private String description = "";
    private int height;
    private String imageUrl = "";
    private boolean isLinked = false;
    private String mimeType = "";
    private int pictureType = -1;
    private int width;

    public static AndroidArtwork createArtworkFromFile(File file) throws IOException {
        AndroidArtwork androidArtwork = new AndroidArtwork();
        androidArtwork.setFromFile(file);
        return androidArtwork;
    }

    public static AndroidArtwork createArtworkFromMetadataBlockDataPicture(MetadataBlockDataPicture metadataBlockDataPicture) {
        AndroidArtwork androidArtwork = new AndroidArtwork();
        androidArtwork.setFromMetadataBlockDataPicture(metadataBlockDataPicture);
        return androidArtwork;
    }

    public static AndroidArtwork createLinkedArtworkFromURL(String string2) throws IOException {
        AndroidArtwork androidArtwork = new AndroidArtwork();
        androidArtwork.setLinkedFromURL(string2);
        return androidArtwork;
    }

    @Override
    public byte[] getBinaryData() {
        return this.binaryData;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Object getImage() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override
    public String getMimeType() {
        return this.mimeType;
    }

    @Override
    public int getPictureType() {
        return this.pictureType;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public boolean isLinked() {
        return this.isLinked;
    }

    @Override
    public void setBinaryData(byte[] arrby) {
        this.binaryData = arrby;
    }

    @Override
    public void setDescription(String string2) {
        this.description = string2;
    }

    @Override
    public void setFromFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] arrby = new byte[(int)randomAccessFile.length()];
        randomAccessFile.read(arrby);
        randomAccessFile.close();
        this.setBinaryData(arrby);
        this.setMimeType(ImageFormats.getMimeTypeForBinarySignature(arrby));
        this.setDescription("");
        this.setPictureType(PictureTypes.DEFAULT_ID);
    }

    @Override
    public void setFromMetadataBlockDataPicture(MetadataBlockDataPicture metadataBlockDataPicture) {
        this.setMimeType(metadataBlockDataPicture.getMimeType());
        this.setDescription(metadataBlockDataPicture.getDescription());
        this.setPictureType(metadataBlockDataPicture.getPictureType());
        if (metadataBlockDataPicture.isImageUrl()) {
            this.setLinked(metadataBlockDataPicture.isImageUrl());
            this.setImageUrl(metadataBlockDataPicture.getImageUrl());
        } else {
            this.setBinaryData(metadataBlockDataPicture.getImageData());
        }
        this.setWidth(metadataBlockDataPicture.getWidth());
        this.setHeight(metadataBlockDataPicture.getHeight());
    }

    @Override
    public void setHeight(int n2) {
        this.height = n2;
    }

    @Override
    public boolean setImageFromData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setImageUrl(String string2) {
        this.imageUrl = string2;
    }

    @Override
    public void setLinked(boolean bl) {
        this.isLinked = bl;
    }

    public void setLinkedFromURL(String string2) throws IOException {
        this.setLinked(true);
        this.setImageUrl(string2);
    }

    @Override
    public void setMimeType(String string2) {
        this.mimeType = string2;
    }

    @Override
    public void setPictureType(int n2) {
        this.pictureType = n2;
    }

    @Override
    public void setWidth(int n2) {
        this.width = n2;
    }
}

