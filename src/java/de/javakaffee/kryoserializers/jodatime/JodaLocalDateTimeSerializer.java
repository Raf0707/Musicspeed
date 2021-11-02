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
 *  org.joda.time.LocalDateTime
 */
package de.javakaffee.kryoserializers.jodatime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.jodatime.IdentifiableChronology;
import org.joda.time.Chronology;
import org.joda.time.LocalDateTime;

public class JodaLocalDateTimeSerializer
extends Serializer<LocalDateTime> {
    public JodaLocalDateTimeSerializer() {
        this.setImmutable(true);
    }

    public LocalDateTime read(Kryo kryo, Input input, Class<LocalDateTime> class_) {
        long l2 = input.readLong(true);
        int n2 = (int)(l2 / 86400000L);
        int n3 = (int)(l2 % 86400000L);
        Chronology chronology = IdentifiableChronology.readChronology(input);
        LocalDateTime localDateTime = new LocalDateTime(n2 / 416, n2 % 416 / 32, n2 % 32, n3 / 3600000, n3 % 3600000 / 60000, n3 % 60000 / 1000, n3 % 1000, chronology);
        return localDateTime;
    }

    public void write(Kryo kryo, Output output, LocalDateTime localDateTime) {
        output.writeLong(86400000L * (long)(32 * (13 * localDateTime.getYear()) + 32 * localDateTime.getMonthOfYear() + localDateTime.getDayOfMonth()) + (long)localDateTime.getMillisOfDay(), true);
        String string2 = IdentifiableChronology.getChronologyId(localDateTime.getChronology());
        if (string2 == null) {
            string2 = "";
        }
        output.writeString(string2);
    }
}

