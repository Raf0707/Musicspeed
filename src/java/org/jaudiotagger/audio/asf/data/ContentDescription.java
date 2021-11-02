/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.data;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.util.Utils;

public final class ContentDescription
extends MetadataContainer {
    public static final Set<String> ALLOWED = new HashSet((Collection)Arrays.asList((Object[])new String[]{"AUTHOR", "COPYRIGHT", "DESCRIPTION", "RATING", "TITLE"}));
    public static final String KEY_AUTHOR = "AUTHOR";
    public static final String KEY_COPYRIGHT = "COPYRIGHT";
    public static final String KEY_DESCRIPTION = "DESCRIPTION";
    public static final String KEY_RATING = "RATING";
    public static final String KEY_TITLE = "TITLE";

    public ContentDescription() {
        this(0L, BigInteger.ZERO);
    }

    public ContentDescription(long l2, BigInteger bigInteger) {
        super(ContainerType.CONTENT_DESCRIPTION, l2, bigInteger);
    }

    public String getAuthor() {
        return this.getValueFor(KEY_AUTHOR);
    }

    public String getComment() {
        return this.getValueFor(KEY_DESCRIPTION);
    }

    public String getCopyRight() {
        return this.getValueFor(KEY_COPYRIGHT);
    }

    @Override
    public long getCurrentAsfChunkSize() {
        return 44L + (long)(2 * this.getAuthor().length()) + (long)(2 * this.getComment().length()) + (long)(2 * this.getRating().length()) + (long)(2 * this.getTitle().length()) + (long)(2 * this.getCopyRight().length());
    }

    public String getRating() {
        return this.getValueFor(KEY_RATING);
    }

    public String getTitle() {
        return this.getValueFor(KEY_TITLE);
    }

    @Override
    public boolean isAddSupported(MetadataDescriptor metadataDescriptor) {
        return ALLOWED.contains((Object)metadataDescriptor.getName()) && super.isAddSupported(metadataDescriptor);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        stringBuilder.append(string2);
        stringBuilder.append("  |->Title      : ");
        stringBuilder.append(this.getTitle());
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |->Author     : ");
        stringBuilder.append(this.getAuthor());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |->Copyright  : ");
        stringBuilder.append(this.getCopyRight());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |->Description: ");
        stringBuilder.append(this.getComment());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |->Rating     :");
        stringBuilder.append(this.getRating());
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void setAuthor(String string2) throws IllegalArgumentException {
        this.setStringValue(KEY_AUTHOR, string2);
    }

    public void setComment(String string2) throws IllegalArgumentException {
        this.setStringValue(KEY_DESCRIPTION, string2);
    }

    public void setCopyright(String string2) throws IllegalArgumentException {
        this.setStringValue(KEY_COPYRIGHT, string2);
    }

    public void setRating(String string2) throws IllegalArgumentException {
        this.setStringValue(KEY_RATING, string2);
    }

    public void setTitle(String string2) throws IllegalArgumentException {
        this.setStringValue(KEY_TITLE, string2);
    }

    @Override
    public long writeInto(OutputStream outputStream) throws IOException {
        long l2 = this.getCurrentAsfChunkSize();
        outputStream.write(this.getGuid().getBytes());
        Utils.writeUINT64(this.getCurrentAsfChunkSize(), outputStream);
        Utils.writeUINT16(2 + 2 * this.getTitle().length(), outputStream);
        Utils.writeUINT16(2 + 2 * this.getAuthor().length(), outputStream);
        Utils.writeUINT16(2 + 2 * this.getCopyRight().length(), outputStream);
        Utils.writeUINT16(2 + 2 * this.getComment().length(), outputStream);
        Utils.writeUINT16(2 + 2 * this.getRating().length(), outputStream);
        String string2 = this.getTitle();
        Charset charset = AsfHeader.ASF_CHARSET;
        outputStream.write(Utils.getBytes(string2, charset));
        byte[] arrby = AsfHeader.ZERO_TERM;
        outputStream.write(arrby);
        outputStream.write(Utils.getBytes(this.getAuthor(), charset));
        outputStream.write(arrby);
        outputStream.write(Utils.getBytes(this.getCopyRight(), charset));
        outputStream.write(arrby);
        outputStream.write(Utils.getBytes(this.getComment(), charset));
        outputStream.write(arrby);
        outputStream.write(Utils.getBytes(this.getRating(), charset));
        outputStream.write(arrby);
        return l2;
    }
}

