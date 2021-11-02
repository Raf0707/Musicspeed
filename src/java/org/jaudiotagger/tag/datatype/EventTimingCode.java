/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTypes;

public class EventTimingCode
extends AbstractDataType
implements Cloneable {
    private static final int SIZE = 5;
    private NumberFixedLength timestamp = new NumberFixedLength("DateTime", null, 4);
    private NumberHashMap type = new NumberHashMap("TypeOfEvent", null, 1);

    public EventTimingCode(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        this(string2, abstractTagFrameBody, 0, 0L);
    }

    public EventTimingCode(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2, long l2) {
        super(string2, abstractTagFrameBody);
        this.setBody(abstractTagFrameBody);
        this.type.setValue(n2);
        this.timestamp.setValue(l2);
    }

    public EventTimingCode(EventTimingCode eventTimingCode) {
        super(eventTimingCode);
        this.type.setValue(eventTimingCode.type.getValue());
        this.timestamp.setValue(eventTimingCode.timestamp.getValue());
    }

    public Object clone() throws CloneNotSupportedException {
        return new EventTimingCode(this);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            if (!super.equals(object)) {
                return false;
            }
            EventTimingCode eventTimingCode = (EventTimingCode)object;
            if (this.getType() == eventTimingCode.getType()) {
                return this.getTimestamp() == eventTimingCode.getTimestamp();
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return 5;
    }

    public long getTimestamp() {
        return ((Number)this.timestamp.getValue()).longValue();
    }

    public int getType() {
        return ((Number)this.type.getValue()).intValue();
    }

    public int hashCode() {
        NumberHashMap numberHashMap = this.type;
        int n2 = numberHashMap != null ? numberHashMap.hashCode() : 0;
        int n3 = n2 * 31;
        NumberFixedLength numberFixedLength = this.timestamp;
        int n4 = 0;
        if (numberFixedLength != null) {
            n4 = numberFixedLength.hashCode();
        }
        return n3 + n4;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        int n3 = this.getSize();
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("offset:");
        stringBuilder.append(n2);
        logger.finest(stringBuilder.toString());
        if (n2 <= arrby.length - n3) {
            this.type.readByteArray(arrby, n2);
            int n4 = n2 + this.type.getSize();
            this.timestamp.readByteArray(arrby, n4);
            this.timestamp.getSize();
            return;
        }
        AbstractDataType.logger.warning("Invalid size for FrameBody");
        throw new InvalidDataTypeException("Invalid size for FrameBody");
    }

    @Override
    public void setBody(AbstractTagFrameBody abstractTagFrameBody) {
        super.setBody(abstractTagFrameBody);
        this.type.setBody(abstractTagFrameBody);
        this.timestamp.setBody(abstractTagFrameBody);
    }

    public void setTimestamp(long l2) {
        this.timestamp.setValue(l2);
    }

    public void setType(int n2) {
        this.type.setValue(n2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.getType());
        stringBuilder.append(" (\"");
        stringBuilder.append(EventTimingTypes.getInstanceOf().getValueForId(this.getType()));
        stringBuilder.append("\"), ");
        stringBuilder.append(this.getTimestamp());
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby = this.type.writeByteArray();
        byte[] arrby2 = this.timestamp.writeByteArray();
        if (arrby != null && arrby2 != null) {
            byte[] arrby3 = new byte[arrby.length + arrby2.length];
            System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)arrby.length);
            System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)arrby.length, (int)arrby2.length);
            return arrby3;
        }
        return null;
    }
}

