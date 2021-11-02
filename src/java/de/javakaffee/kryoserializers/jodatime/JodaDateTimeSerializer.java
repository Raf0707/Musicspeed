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
 *  org.joda.time.DateTime
 *  org.joda.time.DateTimeZone
 */
package de.javakaffee.kryoserializers.jodatime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.jodatime.IdentifiableChronology;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaDateTimeSerializer
extends Serializer<DateTime> {
    static final String CHRONOLOGY = "ch";
    static final String DATE_TIME = "dt";
    static final String MILLIS = "millis";
    static final String TIME_ZONE = "tz";

    public JodaDateTimeSerializer() {
        this.setImmutable(true);
    }

    private DateTimeZone readTimeZone(Input input) {
        String string2 = input.readString();
        if ("".equals((Object)string2)) {
            return DateTimeZone.getDefault();
        }
        return DateTimeZone.forID((String)string2);
    }

    public DateTime read(Kryo kryo, Input input, Class<DateTime> class_) {
        return new DateTime(input.readLong(true), IdentifiableChronology.readChronology(input).withZone(this.readTimeZone(input)));
    }

    public void write(Kryo kryo, Output output, DateTime dateTime) {
        output.writeLong(dateTime.getMillis(), true);
        String string2 = IdentifiableChronology.getChronologyId(dateTime.getChronology());
        if (string2 == null) {
            string2 = "";
        }
        output.writeString(string2);
        output.writeString(dateTime.getZone().getID());
    }
}

