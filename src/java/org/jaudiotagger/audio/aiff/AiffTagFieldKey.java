/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.aiff;

public final class AiffTagFieldKey
extends Enum<AiffTagFieldKey> {
    private static final /* synthetic */ AiffTagFieldKey[] $VALUES;
    public static final /* enum */ AiffTagFieldKey TIMESTAMP;
    private String fieldName;

    static {
        AiffTagFieldKey aiffTagFieldKey;
        TIMESTAMP = aiffTagFieldKey = new AiffTagFieldKey("TIMESTAMP");
        $VALUES = new AiffTagFieldKey[]{aiffTagFieldKey};
    }

    private AiffTagFieldKey(String string3) {
        this.fieldName = string3;
    }

    public static AiffTagFieldKey valueOf(String string2) {
        return (AiffTagFieldKey)Enum.valueOf(AiffTagFieldKey.class, (String)string2);
    }

    public static AiffTagFieldKey[] values() {
        return (AiffTagFieldKey[])$VALUES.clone();
    }

    public String getFieldName() {
        return this.fieldName;
    }
}

