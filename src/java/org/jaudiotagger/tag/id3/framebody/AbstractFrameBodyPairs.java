/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.StringTokenizer
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public abstract class AbstractFrameBodyPairs
extends AbstractID3v2FrameBody
implements ID3v24FrameBody {
    public AbstractFrameBodyPairs() {
        this.setObjectValue("TextEncoding", (byte)0);
    }

    public AbstractFrameBodyPairs(byte by, String string2) {
        this.setObjectValue("TextEncoding", by);
        this.setText(string2);
    }

    public AbstractFrameBodyPairs(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public void addPair(String string2) {
        StringTokenizer stringTokenizer = new StringTokenizer(string2, "\u0000");
        if (stringTokenizer.countTokens() == 2) {
            this.addPair(stringTokenizer.nextToken(), stringTokenizer.nextToken());
            return;
        }
        this.addPair("", string2);
    }

    public void addPair(String string2, String string3) {
        ((PairedTextEncodedStringNullTerminated)this.getObject("Text")).getValue().add(string2, string3);
    }

    @Override
    public abstract String getIdentifier();

    public String getKeyAtIndex(int n2) {
        return ((Pair)((PairedTextEncodedStringNullTerminated)this.getObject("Text")).getValue().getMapping().get(n2)).getKey();
    }

    public int getNumberOfPairs() {
        return ((PairedTextEncodedStringNullTerminated)this.getObject("Text")).getValue().getNumberOfPairs();
    }

    public PairedTextEncodedStringNullTerminated.ValuePairs getPairing() {
        return this.getObject("Text").getValue();
    }

    public String getText() {
        PairedTextEncodedStringNullTerminated pairedTextEncodedStringNullTerminated = (PairedTextEncodedStringNullTerminated)this.getObject("Text");
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = pairedTextEncodedStringNullTerminated.getValue().getMapping().iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(pair.getKey());
            stringBuilder2.append('\u0000');
            stringBuilder2.append(pair.getValue());
            stringBuilder.append(stringBuilder2.toString());
            if (n2 != this.getNumberOfPairs()) {
                stringBuilder.append('\u0000');
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    @Override
    public String getUserFriendlyValue() {
        return this.getText();
    }

    public String getValueAtIndex(int n2) {
        return ((Pair)((PairedTextEncodedStringNullTerminated)this.getObject("Text")).getValue().getMapping().get(n2)).getValue();
    }

    public void resetPairs() {
        ((PairedTextEncodedStringNullTerminated)this.getObject("Text")).getValue().getMapping().clear();
    }

    public void setText(String string2) {
        Object object = new Object(){
            private List<Pair> mapping;
            {
                this.mapping = new ArrayList();
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
                    StringBuilder stringBuilder = new StringBuilder();
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
        StringTokenizer stringTokenizer = new StringTokenizer(string2, "\u0000");
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            if (!stringTokenizer.hasMoreTokens()) continue;
            object.add(string3, stringTokenizer.nextToken());
        }
        this.setObjectValue("Text", object);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new PairedTextEncodedStringNullTerminated("Text", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (!((PairedTextEncodedStringNullTerminated)this.getObject("Text")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

