/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.logging.ErrorMessage;

public final class ContainerType
extends Enum<ContainerType> {
    private static final /* synthetic */ ContainerType[] $VALUES;
    public static final /* enum */ ContainerType CONTENT_BRANDING;
    public static final /* enum */ ContainerType CONTENT_DESCRIPTION;
    public static final /* enum */ ContainerType EXTENDED_CONTENT;
    public static final /* enum */ ContainerType METADATA_LIBRARY_OBJECT;
    public static final /* enum */ ContainerType METADATA_OBJECT;
    private final GUID containerGUID;
    private final boolean guidEnabled;
    private final boolean languageEnabled;
    private final BigInteger maximumDataLength;
    private final boolean multiValued;
    private final long perfMaxDataLen;
    private final boolean streamEnabled;

    static {
        ContainerType containerType;
        ContainerType containerType2;
        ContainerType containerType3;
        ContainerType containerType4;
        ContainerType containerType5;
        CONTENT_BRANDING = containerType4 = new ContainerType(GUID.GUID_CONTENT_BRANDING, 32, false, false, false, false);
        CONTENT_DESCRIPTION = containerType3 = new ContainerType(GUID.GUID_CONTENTDESCRIPTION, 16, false, false, false, false);
        EXTENDED_CONTENT = containerType = new ContainerType(GUID.GUID_EXTENDED_CONTENT_DESCRIPTION, 16, false, false, false, false);
        METADATA_LIBRARY_OBJECT = containerType5 = new ContainerType(GUID.GUID_METADATA_LIBRARY, 32, true, true, true, true);
        METADATA_OBJECT = containerType2 = new ContainerType(GUID.GUID_METADATA, 16, false, true, false, true);
        $VALUES = new ContainerType[]{containerType4, containerType3, containerType, containerType5, containerType2};
    }

    private ContainerType(GUID gUID, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        BigInteger bigInteger;
        this.containerGUID = gUID;
        this.maximumDataLength = bigInteger = BigInteger.valueOf((long)2L).pow(n3).subtract(BigInteger.ONE);
        this.perfMaxDataLen = bigInteger.compareTo(BigInteger.valueOf((long)Long.MAX_VALUE)) <= 0 ? bigInteger.longValue() : -1L;
        this.guidEnabled = bl;
        this.streamEnabled = bl2;
        this.languageEnabled = bl3;
        this.multiValued = bl4;
    }

    public static boolean areInCorrectOrder(ContainerType containerType, ContainerType containerType2) {
        List list = Arrays.asList((Object[])ContainerType.getOrdered());
        return list.indexOf((Object)containerType) <= list.indexOf((Object)containerType2);
    }

    public static ContainerType[] getOrdered() {
        ContainerType[] arrcontainerType = new ContainerType[]{CONTENT_DESCRIPTION, CONTENT_BRANDING, EXTENDED_CONTENT, METADATA_OBJECT, METADATA_LIBRARY_OBJECT};
        return arrcontainerType;
    }

    public static ContainerType valueOf(String string2) {
        return (ContainerType)Enum.valueOf(ContainerType.class, (String)string2);
    }

    public static ContainerType[] values() {
        return (ContainerType[])$VALUES.clone();
    }

    public void assertConstraints(String string2, byte[] arrby, int n2, int n3, int n4) {
        RuntimeException runtimeException = this.checkConstraints(string2, arrby, n2, n3, n4);
        if (runtimeException == null) {
            return;
        }
        throw runtimeException;
    }

    public RuntimeException checkConstraints(String string2, byte[] arrby, int n2, int n3, int n4) {
        IllegalArgumentException illegalArgumentException;
        if (string2 != null && arrby != null) {
            if (!Utils.isStringLengthValidNullSafe(string2)) {
                ErrorMessage errorMessage = ErrorMessage.WMA_LENGTH_OF_STRING_IS_TOO_LARGE;
                Object[] arrobject = new Object[]{string2.length()};
                illegalArgumentException = new IllegalArgumentException(errorMessage.getMsg(arrobject));
            } else {
                illegalArgumentException = null;
            }
        } else {
            illegalArgumentException = new IllegalArgumentException("Arguments must not be null.");
        }
        if (illegalArgumentException == null && !this.isWithinValueRange(arrby.length)) {
            ErrorMessage errorMessage = ErrorMessage.WMA_LENGTH_OF_DATA_IS_TOO_LARGE;
            Object[] arrobject = new Object[]{arrby.length, this.getMaximumDataLength(), this.getContainerGUID().getDescription()};
            illegalArgumentException = new IllegalArgumentException(errorMessage.getMsg(arrobject));
        }
        String string3 = "0";
        if (illegalArgumentException == null && (n3 < 0 || n3 > 127 || !this.isStreamNumberEnabled() && n3 != 0)) {
            String string4 = this.isStreamNumberEnabled() ? "0 to 127" : string3;
            ErrorMessage errorMessage = ErrorMessage.WMA_INVALID_STREAM_REFERNCE;
            Object[] arrobject = new Object[]{n3, string4, this.getContainerGUID().getDescription()};
            illegalArgumentException = new IllegalArgumentException(errorMessage.getMsg(arrobject));
        }
        if (illegalArgumentException == null && n2 == 6 && !this.isGuidEnabled()) {
            ErrorMessage errorMessage = ErrorMessage.WMA_INVALID_GUID_USE;
            Object[] arrobject = new Object[]{this.getContainerGUID().getDescription()};
            illegalArgumentException = new IllegalArgumentException(errorMessage.getMsg(arrobject));
        }
        if (illegalArgumentException == null && (n4 != 0 && !this.isLanguageEnabled() || n4 < 0 || n4 >= 127)) {
            if (this.isStreamNumberEnabled()) {
                string3 = "0 to 126";
            }
            ErrorMessage errorMessage = ErrorMessage.WMA_INVALID_LANGUAGE_USE;
            Object[] arrobject = new Object[]{n4, this.getContainerGUID().getDescription(), string3};
            illegalArgumentException = new IllegalArgumentException(errorMessage.getMsg(arrobject));
        }
        if (illegalArgumentException == null && this == CONTENT_DESCRIPTION && n2 != 0) {
            illegalArgumentException = new IllegalArgumentException(ErrorMessage.WMA_ONLY_STRING_IN_CD.getMsg());
        }
        return illegalArgumentException;
    }

    public GUID getContainerGUID() {
        return this.containerGUID;
    }

    public BigInteger getMaximumDataLength() {
        return this.maximumDataLength;
    }

    public boolean isGuidEnabled() {
        return this.guidEnabled;
    }

    public boolean isLanguageEnabled() {
        return this.languageEnabled;
    }

    public boolean isMultiValued() {
        return this.multiValued;
    }

    public boolean isStreamNumberEnabled() {
        return this.streamEnabled;
    }

    public boolean isWithinValueRange(long l2) {
        long l3 = this.perfMaxDataLen;
        return (l3 == -1L || l3 >= l2) && l2 >= 0L;
    }
}

