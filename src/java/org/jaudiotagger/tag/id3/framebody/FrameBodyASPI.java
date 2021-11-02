/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.datatype.NumberVariableLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyASPI
extends AbstractID3v2FrameBody
implements ID3v24FrameBody {
    private static final String BITS_PER_INDEX_POINT = "BitsPerIndexPoint";
    private static final int BITS_PER_INDEX_POINTS_FIELD_SIZE = 1;
    private static final int DATA_LENGTH_FIELD_SIZE = 4;
    private static final int DATA_START_FIELD_SIZE = 4;
    private static final String FRACTION_AT_INDEX = "FractionAtIndex";
    private static final int FRACTION_AT_INDEX_MINIMUM_FIELD_SIZE = 1;
    private static final String INDEXED_DATA_LENGTH = "IndexedDataLength";
    private static final String INDEXED_DATA_START = "IndexedDataStart";
    private static final int NO_OF_INDEX_POINTS_FIELD_SIZE = 2;
    private static final String NUMBER_OF_INDEX_POINTS = "NumberOfIndexPoints";

    public FrameBodyASPI() {
    }

    public FrameBodyASPI(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyASPI(FrameBodyASPI frameBodyASPI) {
        super(frameBodyASPI);
    }

    @Override
    public String getIdentifier() {
        return "ASPI";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberFixedLength(INDEXED_DATA_START, this, 4));
        this.objectList.add((Object)new NumberFixedLength(INDEXED_DATA_LENGTH, this, 4));
        this.objectList.add((Object)new NumberFixedLength(NUMBER_OF_INDEX_POINTS, this, 2));
        this.objectList.add((Object)new NumberFixedLength(BITS_PER_INDEX_POINT, this, 1));
        this.objectList.add((Object)new NumberVariableLength(FRACTION_AT_INDEX, this, 1));
    }
}

