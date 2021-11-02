/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.PartOfSet;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyNumberTotal;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTRCK
extends AbstractFrameBodyNumberTotal
implements ID3v23FrameBody,
ID3v24FrameBody {
    public FrameBodyTRCK() {
    }

    public FrameBodyTRCK(byte by, Integer n2, Integer n3) {
        super(by, n2, n3);
    }

    public FrameBodyTRCK(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTRCK(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTRCK(FrameBodyTRCK frameBodyTRCK) {
        super(frameBodyTRCK);
    }

    @Override
    public String getIdentifier() {
        return "TRCK";
    }

    public Integer getTrackNo() {
        return this.getNumber();
    }

    public String getTrackNoAsText() {
        return this.getNumberAsText();
    }

    public Integer getTrackTotal() {
        return this.getTotal();
    }

    public String getTrackTotalAsText() {
        return this.getTotalAsText();
    }

    @Override
    public void setText(String string2) {
        this.setObjectValue("Text", new Object(string2){
            private static final String SEPARATOR = "/";
            private static final java.util.regex.Pattern trackNoPattern;
            private static final java.util.regex.Pattern trackNoPatternWithTotalCount;
            private Integer count;
            private String extra;
            private String rawCount;
            private String rawText;
            private String rawTotal;
            private Integer total;

            static {
                trackNoPatternWithTotalCount = java.util.regex.Pattern.compile((String)"([0-9]+)/([0-9]+)(.*)", (int)2);
                trackNoPattern = java.util.regex.Pattern.compile((String)"([0-9]+)(.*)", (int)2);
            }
            {
                this.rawText = "";
            }
            {
                this.count = n2;
                this.rawCount = n2.toString();
                this.total = n3;
                this.rawTotal = n3.toString();
                this.resetValueFromCounts();
            }
            {
                this.rawText = string2;
                this.initFromValue(string2);
            }

            /*
             * Exception decompiling
             */
            private void initFromValue(}
        java.lang.IllegalStateException: Parameters not created
        
        