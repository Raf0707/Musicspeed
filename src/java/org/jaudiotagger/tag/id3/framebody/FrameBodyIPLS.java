/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 *  java.util.List
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyPairs;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyIPLS
extends AbstractFrameBodyPairs
implements ID3v23FrameBody {
    public FrameBodyIPLS() {
    }

    public FrameBodyIPLS(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyIPLS(byte by, List<Pair> list) {
        this.setObjectValue("TextEncoding", by);
        Object object = new Object(){
            private List<Pair> mapping;
            {
                this.mapping = new java.util.ArrayList();
            }

            static /* synthetic */ List access$000(PairedTextEncodedStringNullTerminated.ValuePairs valuePairs) {
                return valuePairs.mapping;
            }

            public void add(String string2, String string3) {
                this.mapping.add((Object)new Pair(string2, string3));
            }

            public void add(Pair pair) {
                this.mapping.add((Object)pair);
            }

            public boolean equals(Object object) {
                if (object == this) {
                    return true;
                }
                if (!(object instanceof PairedTextEncodedStringNullTerminated.ValuePairs)) {
                    return false;
                }
                PairedTextEncodedStringNullTerminated.ValuePairs valuePairs = object;
                return org.jaudiotagger.utils.EqualsUtil.areEqual(this.getNumberOfValues(), valuePairs.getNumberOfValues());
            }

            public List<Pair> getMapping() {
                return this.mapping;
            }

            public int getNumberOfPairs() {
                return this.mapping.size();
            }

            public int getNumberOfValues() {
                return this.mapping.size();
            }

            public String toString() {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (Pair pair : this.mapping) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append(pair.getKey());
                    stringBuilder.append(':');
                    stringBuilder.append(pair.getValue());
                    stringBuilder.append(',');
                    stringBuffer.append(stringBuilder.toString());
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.setLength(-1 + stringBuffer.length());
                }
                return stringBuffer.toString();
            }
        };
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            object.add((Pair)iterator.next());
        }
        this.setObjectValue("Text", object);
    }

    public FrameBodyIPLS(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyIPLS(FrameBodyIPLS frameBodyIPLS) {
        this.setObjectValue("TextEncoding", frameBodyIPLS.getTextEncoding());
        this.setObjectValue("Text", frameBodyIPLS.getPairing());
    }

    public FrameBodyIPLS(FrameBodyTIPL frameBodyTIPL) {
        this.setObjectValue("TextEncoding", frameBodyTIPL.getTextEncoding());
        this.setObjectValue("Text", frameBodyTIPL.getPairing());
    }

    @Override
    public String getIdentifier() {
        return "IPLS";
    }
}

