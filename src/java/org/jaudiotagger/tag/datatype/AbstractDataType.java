/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.LinkedList
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.mp3.MP3File
 *  org.jaudiotagger.tag.InvalidDataTypeException
 *  org.jaudiotagger.tag.datatype.MultipleTextEncodedStringNullTerminated
 *  org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated
 *  org.jaudiotagger.tag.datatype.PartOfSet
 *  org.jaudiotagger.tag.id3.AbstractTagFrameBody
 */
package org.jaudiotagger.tag.datatype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.MultipleTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.PartOfSet;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public abstract class AbstractDataType {
    protected static final String TYPE_ELEMENT = "element";
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.datatype");
    protected AbstractTagFrameBody frameBody = null;
    protected String identifier = "";
    protected int size;
    protected Object value = null;

    protected AbstractDataType(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        this.identifier = string2;
        this.frameBody = abstractTagFrameBody;
    }

    protected AbstractDataType(String string2, AbstractTagFrameBody abstractTagFrameBody, Object object) {
        this.identifier = string2;
        this.frameBody = abstractTagFrameBody;
        this.setValue(object);
    }

    public AbstractDataType(AbstractDataType abstractDataType) {
        this.identifier = abstractDataType.identifier;
        Object object = abstractDataType.value;
        if (object == null) {
            this.value = null;
            return;
        }
        if (object instanceof String) {
            this.value = object;
            return;
        }
        if (object instanceof Boolean) {
            this.value = object;
            return;
        }
        if (object instanceof Byte) {
            this.value = object;
            return;
        }
        if (object instanceof Character) {
            this.value = object;
            return;
        }
        if (object instanceof Double) {
            this.value = object;
            return;
        }
        if (object instanceof Float) {
            this.value = object;
            return;
        }
        if (object instanceof Integer) {
            this.value = object;
            return;
        }
        if (object instanceof Long) {
            this.value = object;
            return;
        }
        if (object instanceof Short) {
            this.value = object;
            return;
        }
        if (object instanceof MultipleTextEncodedStringNullTerminated.Values) {
            this.value = object;
            return;
        }
        if (object instanceof PairedTextEncodedStringNullTerminated.ValuePairs) {
            this.value = object;
            return;
        }
        if (object instanceof PartOfSet.PartOfSetValue) {
            this.value = object;
            return;
        }
        if (object instanceof boolean[]) {
            this.value = ((boolean[])object).clone();
            return;
        }
        if (object instanceof byte[]) {
            this.value = ((byte[])object).clone();
            return;
        }
        if (object instanceof char[]) {
            this.value = ((char[])object).clone();
            return;
        }
        if (object instanceof double[]) {
            this.value = ((double[])object).clone();
            return;
        }
        if (object instanceof float[]) {
            this.value = ((float[])object).clone();
            return;
        }
        if (object instanceof int[]) {
            this.value = ((int[])object).clone();
            return;
        }
        if (object instanceof long[]) {
            this.value = ((long[])object).clone();
            return;
        }
        if (object instanceof short[]) {
            this.value = ((short[])object).clone();
            return;
        }
        if (object instanceof Object[]) {
            this.value = ((Object[])object).clone();
            return;
        }
        if (object instanceof ArrayList) {
            this.value = ((ArrayList)object).clone();
            return;
        }
        if (object instanceof LinkedList) {
            this.value = ((LinkedList)object).clone();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to create copy of class ");
        stringBuilder.append((Object)abstractDataType.getClass());
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public void createStructure() {
        MP3File.getStructureFormatter().addElement(this.identifier, this.getValue().toString());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AbstractDataType)) {
            return false;
        }
        AbstractDataType abstractDataType = (AbstractDataType)object;
        if (!this.identifier.equals((Object)abstractDataType.identifier)) {
            return false;
        }
        Object object2 = this.value;
        if (object2 == null && abstractDataType.value == null) {
            return true;
        }
        if (object2 != null) {
            Object object3 = abstractDataType.value;
            if (object3 == null) {
                return false;
            }
            return !(object2 instanceof boolean[] && object3 instanceof boolean[] ? !Arrays.equals((boolean[])((boolean[])object2), (boolean[])((boolean[])object3)) : (object2 instanceof byte[] && object3 instanceof byte[] ? !Arrays.equals((byte[])((byte[])object2), (byte[])((byte[])object3)) : (object2 instanceof char[] && object3 instanceof char[] ? !Arrays.equals((char[])((char[])object2), (char[])((char[])object3)) : (object2 instanceof double[] && object3 instanceof double[] ? !Arrays.equals((double[])((double[])object2), (double[])((double[])object3)) : (object2 instanceof float[] && object3 instanceof float[] ? !Arrays.equals((float[])((float[])object2), (float[])((float[])object3)) : (object2 instanceof int[] && object3 instanceof int[] ? !Arrays.equals((int[])((int[])object2), (int[])((int[])object3)) : (object2 instanceof long[] && object3 instanceof long[] ? !Arrays.equals((long[])((long[])object2), (long[])((long[])object3)) : (object2 instanceof Object[] && object3 instanceof Object[] ? !Arrays.equals((Object[])((Object[])object2), (Object[])((Object[])object3)) : (object2 instanceof short[] && object3 instanceof short[] ? !Arrays.equals((short[])((short[])object2), (short[])((short[])object3)) : !object2.equals(object3))))))))));
        }
        return false;
    }

    public AbstractTagFrameBody getBody() {
        return this.frameBody;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public abstract int getSize();

    public Object getValue() {
        return this.value;
    }

    public final void readByteArray(byte[] arrby) throws InvalidDataTypeException {
        this.readByteArray(arrby, 0);
    }

    public abstract void readByteArray(byte[] var1, int var2) throws InvalidDataTypeException;

    public void setBody(AbstractTagFrameBody abstractTagFrameBody) {
        this.frameBody = abstractTagFrameBody;
    }

    public void setValue(Object object) {
        this.value = object;
    }

    public abstract byte[] writeByteArray();
}

