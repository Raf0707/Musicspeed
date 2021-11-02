/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package org.jaudiotagger.tag.id3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;

public class AggregatedFrame
implements TagTextField {
    protected Set<AbstractID3v2Frame> frames = new LinkedHashSet();

    public void addFrame(AbstractID3v2Frame abstractID3v2Frame) {
        this.frames.add((Object)abstractID3v2Frame);
    }

    @Override
    public void copyContent(TagField tagField) {
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.frames.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((AbstractID3v2Frame)iterator.next()).getContent());
        }
        return stringBuilder.toString();
    }

    @Override
    public Charset getEncoding() {
        byte by = ((AbstractID3v2Frame)this.frames.iterator().next()).getBody().getTextEncoding();
        return TextEncoding.getInstanceOf().getCharsetForId(by);
    }

    public Set<AbstractID3v2Frame> getFrames() {
        return this.frames;
    }

    @Override
    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.frames.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((AbstractID3v2Frame)iterator.next()).getId());
        }
        return stringBuilder.toString();
    }

    @Override
    public byte[] getRawContent() throws UnsupportedEncodingException {
        throw new UnsupportedEncodingException();
    }

    @Override
    public void isBinary(boolean bl) {
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isCommon() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setContent(String string2) {
    }

    @Override
    public void setEncoding(Charset charset) {
    }
}

