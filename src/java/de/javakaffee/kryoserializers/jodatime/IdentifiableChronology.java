/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.io.Input
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.joda.time.Chronology
 *  org.joda.time.chrono.BuddhistChronology
 *  org.joda.time.chrono.CopticChronology
 *  org.joda.time.chrono.EthiopicChronology
 *  org.joda.time.chrono.GJChronology
 *  org.joda.time.chrono.GregorianChronology
 *  org.joda.time.chrono.ISOChronology
 *  org.joda.time.chrono.IslamicChronology
 *  org.joda.time.chrono.JulianChronology
 */
package de.javakaffee.kryoserializers.jodatime;

import com.esotericsoftware.kryo.io.Input;
import org.joda.time.Chronology;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.JulianChronology;

final class IdentifiableChronology
extends Enum<IdentifiableChronology> {
    private static final /* synthetic */ IdentifiableChronology[] $VALUES;
    public static final /* enum */ IdentifiableChronology BUDDHIST;
    public static final /* enum */ IdentifiableChronology COPTIC;
    public static final /* enum */ IdentifiableChronology ETHIOPIC;
    public static final /* enum */ IdentifiableChronology GJ;
    public static final /* enum */ IdentifiableChronology GREGORIAN;
    public static final /* enum */ IdentifiableChronology ISLAMIC;
    public static final /* enum */ IdentifiableChronology ISO;
    public static final /* enum */ IdentifiableChronology JULIAN;
    private final Chronology _chronology;
    private final String _id;

    static {
        IdentifiableChronology identifiableChronology;
        IdentifiableChronology identifiableChronology2;
        IdentifiableChronology identifiableChronology3;
        IdentifiableChronology identifiableChronology4;
        IdentifiableChronology identifiableChronology5;
        IdentifiableChronology identifiableChronology6;
        IdentifiableChronology identifiableChronology7;
        IdentifiableChronology identifiableChronology8;
        ISO = identifiableChronology8 = new IdentifiableChronology(null, (Chronology)ISOChronology.getInstance());
        COPTIC = identifiableChronology2 = new IdentifiableChronology("COPTIC", (Chronology)CopticChronology.getInstance());
        ETHIOPIC = identifiableChronology4 = new IdentifiableChronology("ETHIOPIC", (Chronology)EthiopicChronology.getInstance());
        GREGORIAN = identifiableChronology7 = new IdentifiableChronology("GREGORIAN", (Chronology)GregorianChronology.getInstance());
        JULIAN = identifiableChronology5 = new IdentifiableChronology("JULIAN", (Chronology)JulianChronology.getInstance());
        ISLAMIC = identifiableChronology = new IdentifiableChronology("ISLAMIC", (Chronology)IslamicChronology.getInstance());
        BUDDHIST = identifiableChronology6 = new IdentifiableChronology("BUDDHIST", (Chronology)BuddhistChronology.getInstance());
        GJ = identifiableChronology3 = new IdentifiableChronology("GJ", (Chronology)GJChronology.getInstance());
        $VALUES = new IdentifiableChronology[]{identifiableChronology8, identifiableChronology2, identifiableChronology4, identifiableChronology7, identifiableChronology5, identifiableChronology, identifiableChronology6, identifiableChronology3};
    }

    private IdentifiableChronology(String string3, Chronology chronology) {
        this._id = string3;
        this._chronology = chronology;
    }

    static String getChronologyId(Chronology chronology) {
        return IdentifiableChronology.getIdByChronology((Class<? extends Chronology>)chronology.getClass());
    }

    public static String getIdByChronology(Class<? extends Chronology> class_) throws IllegalArgumentException {
        for (IdentifiableChronology identifiableChronology : IdentifiableChronology.values()) {
            if (!class_.equals((Object)identifiableChronology._chronology.getClass())) continue;
            return identifiableChronology._id;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Chronology not supported: ");
        stringBuilder.append(class_.getSimpleName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Chronology readChronology(Input input) {
        String string2 = input.readString();
        if ("".equals((Object)string2)) {
            string2 = null;
        }
        return IdentifiableChronology.valueOfId(string2);
    }

    public static IdentifiableChronology valueOf(String string2) {
        return (IdentifiableChronology)Enum.valueOf(IdentifiableChronology.class, (String)string2);
    }

    public static Chronology valueOfId(String string2) throws IllegalArgumentException {
        if (string2 == null) {
            return IdentifiableChronology.ISO._chronology;
        }
        for (IdentifiableChronology identifiableChronology : IdentifiableChronology.values()) {
            if (!string2.equals((Object)identifiableChronology._id)) continue;
            return identifiableChronology._chronology;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No chronology found for id ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static IdentifiableChronology[] values() {
        return (IdentifiableChronology[])$VALUES.clone();
    }

    public String getId() {
        return this._id;
    }
}

