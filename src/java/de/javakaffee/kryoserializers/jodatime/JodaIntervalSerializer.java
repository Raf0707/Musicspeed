/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.joda.time.Chronology
 *  org.joda.time.Interval
 */
package de.javakaffee.kryoserializers.jodatime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.jodatime.IdentifiableChronology;
import org.joda.time.Chronology;
import org.joda.time.Interval;

public class JodaIntervalSerializer
extends Serializer<Interval> {
    public JodaIntervalSerializer() {
        this.setImmutable(true);
    }

    public Interval read(Kryo kryo, Input input, Class<Interval> class_) {
        long l2 = input.readLong(true);
        long l3 = input.readLong(true);
        Chronology chronology = IdentifiableChronology.readChronology(input);
        Interval interval = new Interval(l2, l3, chronology);
        return interval;
    }

    public void write(Kryo kryo, Output output, Interval interval) {
        long l2 = interval.getStartMillis();
        long l3 = interval.getEndMillis();
        String string2 = IdentifiableChronology.getChronologyId(interval.getChronology());
        output.writeLong(l2, true);
        output.writeLong(l3, true);
        if (string2 == null) {
            string2 = "";
        }
        output.writeString(string2);
    }
}

