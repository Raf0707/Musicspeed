/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public abstract class AbstractDataTypeList<T extends AbstractDataType>
extends AbstractDataType {
    public AbstractDataTypeList(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
        this.setValue((List<T>)new ArrayList());
    }

    protected AbstractDataTypeList(AbstractDataTypeList<T> abstractDataTypeList) {
        super(abstractDataTypeList);
    }

    protected abstract T createListElement();

    @Override
    public int getSize() {
        Iterator iterator = this.getValue().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((AbstractDataType)iterator.next()).getSize();
        }
        return n2;
    }

    public List<T> getValue() {
        return (List)super.getValue();
    }

    public int hashCode() {
        if (this.getValue() != null) {
            return this.getValue().hashCode();
        }
        return 0;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0) {
            if (n2 >= arrby.length) {
                this.getValue().clear();
                return;
            }
            while (n2 < arrby.length) {
                T t2 = this.createListElement();
                ((AbstractDataType)t2).readByteArray(arrby, n2);
                ((AbstractDataType)t2).setBody(this.frameBody);
                this.getValue().add(t2);
                n2 += ((AbstractDataType)t2).getSize();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to byte array is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", array.length = ");
        stringBuilder.append(arrby.length);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void setValue(List<T> list) {
        ArrayList arrayList = list == null ? new ArrayList() : new ArrayList(list);
        super.setValue((Object)arrayList);
    }

    public String toString() {
        if (this.getValue() != null) {
            return this.getValue().toString();
        }
        return "{}";
    }

    @Override
    public byte[] writeByteArray() {
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing DataTypeList ");
        stringBuilder.append(this.getIdentifier());
        logger.config(stringBuilder.toString());
        byte[] arrby = new byte[this.getSize()];
        Iterator iterator = this.getValue().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            byte[] arrby2 = ((AbstractDataType)iterator.next()).writeByteArray();
            System.arraycopy((Object)arrby2, (int)0, (Object)arrby, (int)n2, (int)arrby2.length);
            n2 += arrby2.length;
        }
        return arrby;
    }
}

