/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.List
 *  org.jaudiotagger.tag.mp4.field.Mp4TagCoverField
 */
package org.jaudiotagger.tag.mp4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.AbstractTagCreator;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.field.Mp4TagCoverField;

public class Mp4TagCreator
extends AbstractTagCreator {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ByteBuffer convert(Tag tag, int n2) throws UnsupportedEncodingException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator<TagField> iterator = tag.getFields();
            boolean bl = false;
            do {
                if (!iterator.hasNext()) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    byteArrayOutputStream2.write(Utils.getSizeBEInt32(8 + byteArrayOutputStream.size()));
                    byteArrayOutputStream2.write(Mp4AtomIdentifier.ILST.getFieldName().getBytes(StandardCharsets.ISO_8859_1));
                    byteArrayOutputStream2.write(byteArrayOutputStream.toByteArray());
                    ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream2.toByteArray());
                    byteBuffer.rewind();
                    return byteBuffer;
                }
                TagField tagField = (TagField)iterator.next();
                if (tagField instanceof Mp4TagCoverField) {
                    if (bl) continue;
                    bl = true;
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    try {
                        Iterator iterator2 = tag.getFields(FieldKey.COVER_ART).iterator();
                        while (iterator2.hasNext()) {
                            byteArrayOutputStream3.write(((Mp4TagField)((TagField)iterator2.next())).getRawContentDataOnly());
                        }
                    }
                    catch (KeyNotFoundException keyNotFoundException) {
                        throw new RuntimeException("Unable to find COVERART Key");
                    }
                    byte[] arrby = byteArrayOutputStream3.toByteArray();
                    byteArrayOutputStream.write(Utils.getSizeBEInt32(8 + arrby.length));
                    byteArrayOutputStream.write(Mp4FieldKey.ARTWORK.getFieldName().getBytes(StandardCharsets.ISO_8859_1));
                    byteArrayOutputStream.write(arrby);
                    continue;
                }
                byteArrayOutputStream.write(tagField.getRawContent());
            } while (true);
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }
}

