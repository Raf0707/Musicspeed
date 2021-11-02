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
 */
package org.jaudiotagger.tag.vorbiscomment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.AbstractTagCreator;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class VorbisCommentCreator
extends AbstractTagCreator {
    @Override
    public ByteBuffer convert(Tag tag, int n2) throws UnsupportedEncodingException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String string2 = ((VorbisCommentTag)tag).getVendor();
            Charset charset = StandardCharsets.UTF_8;
            byteArrayOutputStream.write(Utils.getSizeLEInt32(string2.getBytes(charset).length));
            byteArrayOutputStream.write(string2.getBytes(charset));
            byteArrayOutputStream.write(Utils.getSizeLEInt32(-1 + tag.getFieldCount()));
            Iterator<TagField> iterator = tag.getFields();
            while (iterator.hasNext()) {
                TagField tagField = (TagField)iterator.next();
                if (tagField.getId().equals((Object)VorbisCommentFieldKey.VENDOR.getFieldName())) continue;
                byteArrayOutputStream.write(tagField.getRawContent());
            }
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
            byteBuffer.rewind();
            return byteBuffer;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }
}

