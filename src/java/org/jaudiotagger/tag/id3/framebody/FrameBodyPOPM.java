/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.datatype.NumberVariableLength;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyPOPM
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    private static final int COUNTER_MINIMUM_FIELD_SIZE = 0;
    public static final String MEDIA_MONKEY_NO_EMAIL = "no@email";
    private static final int RATING_FIELD_SIZE = 1;

    public FrameBodyPOPM() {
        this.setObjectValue("Email", "");
        Long l2 = 0L;
        this.setObjectValue("Rating", (Object)l2);
        this.setObjectValue("Counter", (Object)l2);
    }

    public FrameBodyPOPM(String string2, long l2, long l3) {
        this.setObjectValue("Email", string2);
        this.setObjectValue("Rating", l2);
        this.setObjectValue("Counter", l3);
    }

    public FrameBodyPOPM(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyPOPM(FrameBodyPOPM frameBodyPOPM) {
        super(frameBodyPOPM);
    }

    public long getCounter() {
        return ((Number)this.getObjectValue("Counter")).longValue();
    }

    public String getEmailToUser() {
        return (String)this.getObjectValue("Email");
    }

    @Override
    public String getIdentifier() {
        return "POPM";
    }

    public long getRating() {
        return ((Number)this.getObjectValue("Rating")).longValue();
    }

    @Override
    public String getUserFriendlyValue() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getEmailToUser());
        stringBuilder.append(":");
        stringBuilder.append(this.getRating());
        stringBuilder.append(":");
        stringBuilder.append(this.getCounter());
        return stringBuilder.toString();
    }

    public void parseString(String string2) {
        try {
            this.setRating(Integer.parseInt((String)string2));
            this.setEmailToUser(MEDIA_MONKEY_NO_EMAIL);
        }
        catch (NumberFormatException numberFormatException) {}
    }

    public void setCounter(long l2) {
        this.setObjectValue("Counter", l2);
    }

    public void setEmailToUser(String string2) {
        this.setObjectValue("Email", string2);
    }

    public void setRating(long l2) {
        this.setObjectValue("Rating", l2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Email", this));
        this.objectList.add((Object)new NumberFixedLength("Rating", this, 1));
        this.objectList.add((Object)new NumberVariableLength("Counter", this, 0));
    }
}

