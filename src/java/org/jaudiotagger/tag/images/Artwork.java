/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture
 */
package org.jaudiotagger.tag.images;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;

public interface Artwork {
    public byte[] getBinaryData();

    public String getDescription();

    public int getHeight();

    public Object getImage() throws IOException;

    public String getImageUrl();

    public String getMimeType();

    public int getPictureType();

    public int getWidth();

    public boolean isLinked();

    public void setBinaryData(byte[] var1);

    public void setDescription(String var1);

    public void setFromFile(File var1) throws IOException;

    public void setFromMetadataBlockDataPicture(MetadataBlockDataPicture var1);

    public void setHeight(int var1);

    public boolean setImageFromData();

    public void setImageUrl(String var1);

    public void setLinked(boolean var1);

    public void setMimeType(String var1);

    public void setPictureType(int var1);

    public void setWidth(int var1);
}

