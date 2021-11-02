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

public class ITunesRating
extends ID3Rating {
    private static ID3Rating rating;

    private ITunesRating() {
    }

    public static ID3Rating getInstance() {
        if (rating == null) {
            rating = new ITunesRating();
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
                            return 100;
                        }
                        return 80;
                    }
                    return 60;
                }
                return 40;
            }
            return 20;
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
        if (n2 <= 20) {
            return 1;
        }
        if (n2 <= 40) {
            return 2;
        }
        if (n2 <= 60) {
            return 3;
        }
        if (n2 <= 80) {
            return 4;
        }
        return 5;
    }
}

