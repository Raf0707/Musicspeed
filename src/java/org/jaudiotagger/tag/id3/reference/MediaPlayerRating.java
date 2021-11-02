/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.tag.id3.reference;

import org.jaudiotagger.tag.id3.reference.ID3Rating;

public class MediaPlayerRating
extends ID3Rating {
    private static ID3Rating rating;

    private MediaPlayerRating() {
    }

    public static ID3Rating getInstance() {
        if (rating == null) {
            rating = new MediaPlayerRating();
        }
        return rating;
    }

    @Override
    public int convertRatingFromFiveStarScale(int n2) {
        if (n2 >= 0 && n2 <= 5) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 5) {
                                return 0;
                            }
                            return 255;
                        }
                        return 196;
                    }
                    return 128;
                }
                return 64;
            }
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("convert Ratings from Five Star Scale accepts values from 0 to 5 not:");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public int convertRatingToFiveStarScale(int n2) {
        if (n2 <= 0) {
            return 0;
        }
        if (n2 <= 1) {
            return 1;
        }
        if (n2 <= 64) {
            return 2;
        }
        if (n2 <= 128) {
            return 3;
        }
        if (n2 <= 196) {
            return 4;
        }
        return 5;
    }
}

