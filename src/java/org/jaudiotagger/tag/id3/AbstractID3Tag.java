/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.util.logging.Logger;
import org.jaudiotagger.tag.id3.AbstractTag;

public abstract class AbstractID3Tag
extends AbstractTag {
    protected static final String TAG_RELEASE = "ID3v";
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");
    private String loggingFilename = "";

    public AbstractID3Tag() {
    }

    public AbstractID3Tag(AbstractID3Tag abstractID3Tag) {
        super(abstractID3Tag);
    }

    @Override
    public String getIdentifier() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG_RELEASE);
        stringBuilder.append((int)this.getRelease());
        stringBuilder.append(".");
        stringBuilder.append((int)this.getMajorVersion());
        stringBuilder.append(".");
        stringBuilder.append((int)this.getRevision());
        return stringBuilder.toString();
    }

    protected String getLoggingFilename() {
        return this.loggingFilename;
    }

    public abstract byte getMajorVersion();

    public abstract byte getRelease();

    public abstract byte getRevision();

    protected void setLoggingFilename(String string2) {
        this.loggingFilename = string2;
    }
}

