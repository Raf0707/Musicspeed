/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  org.jaudiotagger.tag.id3.reference.ITunesRating
 *  org.jaudiotagger.tag.id3.reference.MediaMonkeyPlayerRating
 *  org.jaudiotagger.tag.id3.reference.MediaPlayerRating
 */
package org.jaudiotagger.tag.id3.reference;

import org.jaudiotagger.tag.id3.reference.ITunesRating;
import org.jaudiotagger.tag.id3.reference.MediaMonkeyPlayerRating;
import org.jaudiotagger.tag.id3.reference.MediaPlayerRating;
import org.jaudiotagger.tag.reference.Tagger;

public abstract class ID3Rating {
    public static ID3Rating getInstance(Tagger tagger) {
        int n2 = 1.$SwitchMap$org$jaudiotagger$tag$reference$Tagger[tagger.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return MediaPlayerRating.getInstance();
                }
                return MediaPlayerRating.getInstance();
            }
            return MediaMonkeyPlayerRating.getInstance();
        }
        return ITunesRating.getInstance();
    }

    public abstract int convertRatingFromFiveStarScale(int var1);

    public abstract int convertRatingToFiveStarScale(int var1);

}

