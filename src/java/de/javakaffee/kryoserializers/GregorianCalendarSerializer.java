/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.Calendar
 *  java.util.GregorianCalendar
 *  java.util.TimeZone
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarSerializer
extends Serializer<GregorianCalendar> {
    private final Field _zoneField;

    public GregorianCalendarSerializer() {
        try {
            Field field;
            this._zoneField = field = Calendar.class.getDeclaredField("zone");
            field.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    private TimeZone getTimeZone(Calendar calendar) {
        try {
            TimeZone timeZone = (TimeZone)this._zoneField.get((Object)calendar);
            return timeZone;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public GregorianCalendar copy(Kryo kryo, GregorianCalendar gregorianCalendar) {
        return (GregorianCalendar)gregorianCalendar.clone();
    }

    public GregorianCalendar read(Kryo kryo, Input input, Class<GregorianCalendar> class_) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(input.readLong(true));
        calendar.setLenient(input.readBoolean());
        calendar.setFirstDayOfWeek(input.readInt(true));
        calendar.setMinimalDaysInFirstWeek(input.readInt(true));
        String string2 = input.readString();
        if (!this.getTimeZone(calendar).getID().equals((Object)string2)) {
            calendar.setTimeZone(TimeZone.getTimeZone((String)string2));
        }
        return (GregorianCalendar)calendar;
    }

    public void write(Kryo kryo, Output output, GregorianCalendar gregorianCalendar) {
        output.writeLong(gregorianCalendar.getTimeInMillis(), true);
        output.writeBoolean(gregorianCalendar.isLenient());
        output.writeInt(gregorianCalendar.getFirstDayOfWeek(), true);
        output.writeInt(gregorianCalendar.getMinimalDaysInFirstWeek(), true);
        output.writeString(this.getTimeZone((Calendar)gregorianCalendar).getID());
    }
}

