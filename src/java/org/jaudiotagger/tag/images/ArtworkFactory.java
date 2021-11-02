/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture
 *  org.jaudiotagger.tag.images.AndroidArtwork
 */
package org.jaudiotagger.tag.images;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.tag.images.AndroidArtwork;
import org.jaudiotagger.tag.images.Artwork;

public class ArtworkFactory {
    public static Artwork createArtworkFromFile(File file) throws IOException {
        return AndroidArtwork.createArtworkFromFile((File)file);
    }

    public static Artwork createArtworkFromMetadataBlockDataPicture(MetadataBlockDataPicture metadataBlockDataPicture) {
        return AndroidArtwork.createArtworkFromMetadataBlockDataPicture((MetadataBlockDataPicture)metadataBlockDataPicture);
    }

    public static Artwork createLinkedArtworkFromURL(String string2) throws IOException {
        return AndroidArtwork.createLinkedArtworkFromURL((String)string2);
    }

    public static Artwork getNew() {
        return new AndroidArtwork();
    }
}

