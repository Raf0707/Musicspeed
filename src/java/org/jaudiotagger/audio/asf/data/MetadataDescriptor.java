/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Comparable
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 *  java.util.Arrays
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.asf.data.AsfHeader
 */
package org.jaudiotagger.audio.asf.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.TagOptionSingleton;

public class MetadataDescriptor
implements Comparable<MetadataDescriptor>,
Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long DWORD_MAXVALUE = 0L;
    private static final Logger LOGGER;
    public static final int MAX_LANG_INDEX = 127;
    public static final int MAX_STREAM_NUMBER = 127;
    public static final BigInteger QWORD_MAXVALUE;
    public static final int TYPE_BINARY = 1;
    public static final int TYPE_BOOLEAN = 2;
    public static final int TYPE_DWORD = 3;
    public static final int TYPE_GUID = 6;
    public static final int TYPE_QWORD = 4;
    public static final int TYPE_STRING = 0;
    public static final int TYPE_WORD = 5;
    public static final int WORD_MAXVALUE = 65535;
    private final ContainerType containerType;
    private byte[] content = new byte[0];
    private int descriptorType;
    private int languageIndex = 0;
    private final String name;
    private int streamNumber = 0;

    static {
        DWORD_MAXVALUE = new BigInteger("FFFFFFFF", 16).longValue();
        LOGGER = Logger.getLogger((String)"org.jaudiotagger.audio.asf.data");
        QWORD_MAXVALUE = new BigInteger("FFFFFFFFFFFFFFFF", 16);
    }

    public MetadataDescriptor(String string2) {
        this(string2, 0);
    }

    public MetadataDescriptor(String string2, int n2) {
        this(ContainerType.METADATA_LIBRARY_OBJECT, string2, n2, 0, 0);
    }

    public MetadataDescriptor(ContainerType containerType, String string2, int n2) {
        this(containerType, string2, n2, 0, 0);
    }

    public MetadataDescriptor(ContainerType containerType, String string2, int n2, int n3, int n4) {
        containerType.assertConstraints(string2, new byte[0], n2, n3, n4);
        this.containerType = containerType;
        this.name = string2;
        this.descriptorType = n2;
        this.streamNumber = n3;
        this.languageIndex = n4;
    }

    public BigInteger asNumber() {
        BigInteger bigInteger;
        switch (this.descriptorType) {
            default: {
                throw new IllegalStateException();
            }
            case 6: {
                throw new NumberFormatException("GUID cannot be converted to a number.");
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                if (this.content.length <= 8) {
                    bigInteger = null;
                    break;
                }
                throw new NumberFormatException("Binary data would exceed QWORD");
            }
            case 0: {
                bigInteger = new BigInteger(this.getString(), 10);
            }
        }
        if (bigInteger == null) {
            int n2 = this.content.length;
            byte[] arrby = new byte[n2];
            int n3 = 0;
            while (n3 < n2) {
                byte[] arrby2 = this.content;
                int n4 = arrby2.length;
                int n5 = n3 + 1;
                arrby[n3] = arrby2[n4 - n5];
                n3 = n5;
            }
            bigInteger = new BigInteger(1, arrby);
        }
        return bigInteger;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareTo(MetadataDescriptor metadataDescriptor) {
        return this.getName().compareTo(metadataDescriptor.getName());
    }

    public MetadataDescriptor createCopy() {
        MetadataDescriptor metadataDescriptor = new MetadataDescriptor(this.containerType, this.name, this.descriptorType, this.streamNumber, this.languageIndex);
        metadataDescriptor.content = this.getRawData();
        return metadataDescriptor;
    }

    public boolean equals(Object object) {
        if (object instanceof MetadataDescriptor) {
            if (object == this) {
                return true;
            }
            MetadataDescriptor metadataDescriptor = (MetadataDescriptor)object;
            if (metadataDescriptor.getName().equals((Object)this.getName()) && metadataDescriptor.descriptorType == this.descriptorType && metadataDescriptor.languageIndex == this.languageIndex && metadataDescriptor.streamNumber == this.streamNumber && Arrays.equals((byte[])this.content, (byte[])metadataDescriptor.content)) {
                return true;
            }
        }
        return false;
    }

    public boolean getBoolean() {
        byte[] arrby = this.content;
        int n2 = arrby.length;
        boolean bl = false;
        if (n2 > 0) {
            byte by = arrby[0];
            bl = false;
            if (by != 0) {
                bl = true;
            }
        }
        return bl;
    }

    @Deprecated
    public byte[] getBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.writeInto((OutputStream)byteArrayOutputStream, this.containerType);
        }
        catch (IOException iOException) {
            LOGGER.warning(iOException.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public ContainerType getContainerType() {
        return this.containerType;
    }

    public int getCurrentAsfSize(ContainerType containerType) {
        int n2;
        block3 : {
            block4 : {
                int n3;
                block2 : {
                    ContainerType containerType2 = ContainerType.EXTENDED_CONTENT;
                    int n4 = containerType != containerType2 ? 14 : 8;
                    n3 = n4 + 2 * this.getName().length();
                    if (this.getType() != 2) break block2;
                    n2 = n3 + 2;
                    if (containerType != containerType2) break block3;
                    break block4;
                }
                n2 = n3 + this.content.length;
                if (this.getType() != 0) break block3;
            }
            n2 += 2;
        }
        return n2;
    }

    public GUID getGuid() {
        if (this.getType() == 6 && this.content.length == 16) {
            return new GUID(this.content);
        }
        return null;
    }

    public int getLanguageIndex() {
        return this.languageIndex;
    }

    public String getName() {
        return this.name;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long getNumber() {
        int n2 = this.getType();
        int n3 = 4;
        if (n2 != 2) {
            if (n2 != 3) {
                if (n2 != n3) {
                    if (n2 != 5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("The current type doesn't allow an interpretation as a number. (");
                        stringBuilder.append(this.getType());
                        stringBuilder.append(")");
                        throw new UnsupportedOperationException(stringBuilder.toString());
                    }
                    n3 = 2;
                } else {
                    n3 = 8;
                }
            }
        } else {
            n3 = 1;
        }
        if (n3 > this.content.length) {
            throw new IllegalStateException("The stored data cannot represent the type of current object.");
        }
        long l2 = 0L;
        int n4 = 0;
        while (n4 < n3) {
            l2 |= (255L & (long)this.content[n4]) << n4 * 8;
            ++n4;
        }
        return l2;
    }

    public byte[] getRawData() {
        byte[] arrby = this.content;
        byte[] arrby2 = new byte[arrby.length];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)arrby.length);
        return arrby2;
    }

    public int getRawDataSize() {
        return this.content.length;
    }

    public int getStreamNumber() {
        return this.streamNumber;
    }

    public String getString() {
        switch (this.getType()) {
            default: {
                throw new IllegalStateException("Current type is not known.");
            }
            case 6: {
                if (this.getGuid() == null) {
                    return "Invalid GUID";
                }
                return this.getGuid().toString();
            }
            case 3: 
            case 4: 
            case 5: {
                return String.valueOf((long)this.getNumber());
            }
            case 2: {
                return String.valueOf((boolean)this.getBoolean());
            }
            case 1: {
                return "binary data";
            }
            case 0: 
        }
        try {
            String string2 = new String(this.content, "UTF-16LE");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LOGGER.warning(unsupportedEncodingException.getMessage());
            return null;
        }
    }

    public int getType() {
        return this.descriptorType;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isEmpty() {
        return this.content.length == 0;
    }

    public void setBinaryValue(byte[] arrby) throws IllegalArgumentException {
        this.containerType.assertConstraints(this.name, arrby, this.descriptorType, this.streamNumber, this.languageIndex);
        this.content = (byte[])arrby.clone();
        this.descriptorType = 1;
    }

    public void setBooleanValue(boolean bl) {
        this.content = new byte[]{(byte)(bl ? 1 : 0)};
        this.descriptorType = 2;
    }

    public void setDWordValue(long l2) {
        if (l2 >= 0L && l2 <= DWORD_MAXVALUE) {
            this.content = Utils.getBytes(l2, 4);
            this.descriptorType = 3;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("value out of range (0-");
        stringBuilder.append(DWORD_MAXVALUE);
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setGUIDValue(GUID gUID) {
        this.containerType.assertConstraints(this.name, gUID.getBytes(), 6, this.streamNumber, this.languageIndex);
        this.content = gUID.getBytes();
        this.descriptorType = 6;
    }

    public void setLanguageIndex(int n2) {
        this.containerType.assertConstraints(this.name, this.content, this.descriptorType, this.streamNumber, n2);
        this.languageIndex = n2;
    }

    public void setQWordValue(long l2) {
        if (l2 >= 0L) {
            this.content = Utils.getBytes(l2, 8);
            this.descriptorType = 4;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("value out of range (0-");
        stringBuilder.append(QWORD_MAXVALUE.toString());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setQWordValue(BigInteger bigInteger) throws IllegalArgumentException {
        if (bigInteger != null) {
            if (BigInteger.ZERO.compareTo(bigInteger) <= 0) {
                if (QWORD_MAXVALUE.compareTo(bigInteger) >= 0) {
                    this.content = new byte[8];
                    byte[] arrby = bigInteger.toByteArray();
                    if (arrby.length <= 8) {
                        for (int i2 = -1 + arrby.length; i2 >= 0; --i2) {
                            this.content[arrby.length - (i2 + 1)] = arrby[i2];
                        }
                    } else {
                        Arrays.fill((byte[])this.content, (byte)-1);
                    }
                    this.descriptorType = 4;
                    return;
                }
                throw new IllegalArgumentException("Value exceeds QWORD (64 bit unsigned)");
            }
            throw new IllegalArgumentException("Only unsigned values allowed (no negative)");
        }
        throw new NumberFormatException("null");
    }

    public void setStreamNumber(int n2) {
        this.containerType.assertConstraints(this.name, this.content, this.descriptorType, n2, this.languageIndex);
        this.streamNumber = n2;
    }

    public void setString(String string2) throws IllegalArgumentException {
        try {
            switch (this.getType()) {
                default: {
                    break;
                }
                case 6: {
                    this.setGUIDValue(GUID.parseGUID(string2));
                    return;
                }
                case 5: {
                    this.setWordValue(Integer.parseInt((String)string2));
                    return;
                }
                case 4: {
                    this.setQWordValue(new BigInteger(string2, 10));
                    return;
                }
                case 3: {
                    this.setDWordValue(Long.parseLong((String)string2));
                    return;
                }
                case 2: {
                    this.setBooleanValue(Boolean.parseBoolean((String)string2));
                    return;
                }
                case 1: {
                    throw new IllegalArgumentException("Cannot interpret binary as string.");
                }
                case 0: {
                    this.setStringValue(string2);
                    return;
                }
            }
            throw new IllegalStateException();
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value cannot be parsed as Number or is out of range (\"");
            stringBuilder.append(string2);
            stringBuilder.append("\")");
            throw new IllegalArgumentException(stringBuilder.toString(), (Throwable)numberFormatException);
        }
    }

    public void setStringValue(String string2) throws IllegalArgumentException {
        byte[] arrby;
        block7 : {
            block5 : {
                block6 : {
                    block4 : {
                        if (string2 != null) break block4;
                        this.content = new byte[0];
                        break block5;
                    }
                    arrby = Utils.getBytes(string2, AsfHeader.ASF_CHARSET);
                    if (!this.getContainerType().isWithinValueRange(arrby.length)) break block6;
                    this.content = arrby;
                    break block5;
                }
                if (!TagOptionSingleton.getInstance().isTruncateTextWithoutErrors()) break block7;
                int n2 = (int)this.getContainerType().getMaximumDataLength().longValue();
                if (n2 % 2 != 0) {
                    --n2;
                }
                byte[] arrby2 = new byte[n2];
                this.content = arrby2;
                System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)arrby2.length);
            }
            this.descriptorType = 0;
            return;
        }
        ErrorMessage errorMessage = ErrorMessage.WMA_LENGTH_OF_DATA_IS_TOO_LARGE;
        Object[] arrobject = new Object[]{arrby.length, this.getContainerType().getMaximumDataLength(), this.getContainerType().getContainerGUID().getDescription()};
        throw new IllegalArgumentException(errorMessage.getMsg(arrobject));
    }

    public void setWordValue(int n2) throws IllegalArgumentException {
        if (n2 >= 0 && n2 <= 65535) {
            this.content = Utils.getBytes(n2, 2);
            this.descriptorType = 5;
            return;
        }
        throw new IllegalArgumentException("value out of range (0-65535)");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getName());
        stringBuilder.append(" : ");
        stringBuilder.append(new String[]{"String: ", "Binary: ", "Boolean: ", "DWORD: ", "QWORD:", "WORD:", "GUID:"}[this.descriptorType]);
        stringBuilder.append(this.getString());
        stringBuilder.append(" (language: ");
        stringBuilder.append(this.languageIndex);
        stringBuilder.append(" / stream: ");
        stringBuilder.append(this.streamNumber);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int writeInto(OutputStream outputStream, ContainerType containerType) throws IOException {
        byte[] arrby;
        int n2 = this.getCurrentAsfSize(containerType);
        if (this.descriptorType == 2) {
            int n3 = containerType == ContainerType.EXTENDED_CONTENT ? 4 : 2;
            arrby = new byte[n3];
            arrby[0] = (byte)(this.getBoolean() ? 1 : 0);
        } else {
            arrby = this.content;
        }
        ContainerType containerType2 = ContainerType.EXTENDED_CONTENT;
        if (containerType != containerType2) {
            Utils.writeUINT16(this.getLanguageIndex(), outputStream);
            Utils.writeUINT16(this.getStreamNumber(), outputStream);
        }
        Utils.writeUINT16(2 + 2 * this.getName().length(), outputStream);
        if (containerType == containerType2) {
            outputStream.write(Utils.getBytes(this.getName(), AsfHeader.ASF_CHARSET));
            outputStream.write(AsfHeader.ZERO_TERM);
        }
        int n4 = this.getType();
        Utils.writeUINT16(n4, outputStream);
        int n5 = arrby.length;
        if (n4 == 0) {
            n5 += 2;
        }
        if (containerType == containerType2) {
            Utils.writeUINT16(n5, outputStream);
        } else {
            Utils.writeUINT32(n5, outputStream);
        }
        if (containerType != containerType2) {
            outputStream.write(Utils.getBytes(this.getName(), AsfHeader.ASF_CHARSET));
            outputStream.write(AsfHeader.ZERO_TERM);
        }
        outputStream.write(arrby);
        if (n4 == 0) {
            outputStream.write(AsfHeader.ZERO_TERM);
        }
        return n2;
    }
}

