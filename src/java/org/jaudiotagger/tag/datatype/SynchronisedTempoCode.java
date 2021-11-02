/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
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
import org.jaudiotagger.tag.datatype.TempoCode;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTypes;

public class SynchronisedTempoCode
extends AbstractDataType
implements Cloneable {
    private TempoCode tempo = new TempoCode("SynchronisedTempoData", null, 1);
    private NumberFixedLength timestamp = new NumberFixedLength("DateTime", null, 4);

    public SynchronisedTempoCode(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        this(string2, abstractTagFrameBody, 0, 0L);
    }

    public SynchronisedTempoCode(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2, long l2) {
        super(string2, abstractTagFrameBody);
        this.setBody(abstractTagFrameBody);
        this.tempo.setValue(n2);
        this.timestamp.setValue(l2);
    }

    public SynchronisedTempoCode(SynchronisedTempoCode synchronisedTempoCode) {
        super(synchronisedTempoCode);
        this.tempo.setValue(synchronisedTempoCode.tempo.getValue());
        this.timestamp.setValue(synchronisedTempoCode.timestamp.getValue());
    }

    public Object clone() throws CloneNotSupportedException {
        return new SynchronisedTempoCode(this);
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
            SynchronisedTempoCode synchronisedTempoCode = (SynchronisedTempoCode)object;
            if (this.getTempo() == synchronisedTempoCode.getTempo()) {
                return this.getTimestamp() == synchronisedTempoCode.getTimestamp();
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.tempo.getSize() + this.timestamp.getSize();
    }

    public int getTempo() {
        return ((Number)this.tempo.getValue()).intValue();
    }

    public long getTimestamp() {
        return ((Number)this.timestamp.getValue()).longValue();
    }

    public int hashCode() {
        TempoCode tempoCode = this.tempo;
        int n2 = tempoCode != null ? tempoCode.hashCode() : 0;
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
            this.tempo.readByteArray(arrby, n2);
            int n4 = n2 + this.tempo.getSize();
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
        this.tempo.setBody(abstractTagFrameBody);
        this.timestamp.setBody(abstractTagFrameBody);
    }

    public void setTempo(int n2) {
        if (n2 >= 0 && n2 <= 510) {
            this.tempo.setValue(n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tempo must be a positive value less than 511: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setTimestamp(long l2) {
        this.timestamp.setValue(l2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.getTempo());
        stringBuilder.append(" (\"");
        stringBuilder.append(EventTimingTypes.getInstanceOf().getValueForId(this.getTempo()));
        stringBuilder.append("\"), ");
        stringBuilder.append(this.getTimestamp());
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby = this.tempo.writeByteArray();
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

