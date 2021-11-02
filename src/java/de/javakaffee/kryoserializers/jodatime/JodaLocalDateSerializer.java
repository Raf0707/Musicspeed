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
 *  org.joda.time.LocalDate
 */
package de.javakaffee.kryoserializers.jodatime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.jodatime.IdentifiableChronology;
import org.joda.time.Chronology;
import org.joda.time.LocalDate;

public class JodaLocalDateSerializer
extends Serializer<LocalDate> {
    public JodaLocalDateSerializer() {
        this.setImmutable(true);
    }

    public LocalDate read(Kryo kryo, Input input, Class<LocalDate> class_) {
        int n2 = input.readInt(true);
        Chronology chronology = IdentifiableChronology.readChronology(input);
        return new LocalDate(n2 / 416, n2 % 416 / 32, n2 % 32, chronology);
    }

    public void write(Kryo kryo, Output output, LocalDate localDate) {
        output.writeInt(32 * (13 * localDate.getYear()) + 32 * localDate.getMonthOfYear() + localDate.getDayOfMonth(), true);
        String string2 = IdentifiableChronology.getChronologyId(localDate.getChronology());
        if (string2 == null) {
            string2 = "";
        }
        output.writeString(string2);
    }
}

