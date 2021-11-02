/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 *  org.jaudiotagger.tag.reference.GenreTypes
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.Collections;
import java.util.List;
import org.jaudiotagger.tag.id3.valuepair.ID3V2ExtendedGenreTypes;
import org.jaudiotagger.tag.reference.GenreTypes;

public class V2GenreTypes {
    private static V2GenreTypes v2GenresTypes;

    private V2GenreTypes() {
    }

    public static V2GenreTypes getInstanceOf() {
        if (v2GenresTypes == null) {
            v2GenresTypes = new V2GenreTypes();
        }
        return v2GenresTypes;
    }

    public List<String> getAlphabeticalValueList() {
        List list = GenreTypes.getInstanceOf().getAlphabeticalValueList();
        list.add((Object)ID3V2ExtendedGenreTypes.CR.getDescription());
        list.add((Object)ID3V2ExtendedGenreTypes.RX.getDescription());
        Collections.sort(list);
        return list;
    }
}

