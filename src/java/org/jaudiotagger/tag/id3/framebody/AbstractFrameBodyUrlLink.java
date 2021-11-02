/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.net.URLEncoder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetEncoder
 *  java.util.ArrayList
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.StringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;

public abstract class AbstractFrameBodyUrlLink
extends AbstractID3v2FrameBody {
    protected AbstractFrameBodyUrlLink() {
    }

    public AbstractFrameBodyUrlLink(String string2) {
        this.setObjectValue("URLLink", string2);
    }

    protected AbstractFrameBodyUrlLink(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    protected AbstractFrameBodyUrlLink(AbstractFrameBodyUrlLink abstractFrameBodyUrlLink) {
        super(abstractFrameBodyUrlLink);
    }

    private String encodeURL(String string2) {
        String[] arrstring = string2.split("(?<!/)/(?!/)", -1);
        StringBuffer stringBuffer = new StringBuffer(arrstring[0]);
        int n2 = 1;
        do {
            if (n2 >= arrstring.length) break;
            stringBuffer.append("/");
            stringBuffer.append(URLEncoder.encode((String)arrstring[n2], (String)"utf-8"));
            ++n2;
        } while (true);
        try {
            String string3 = stringBuffer.toString();
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Uable to url encode because utf-8 charset not available:");
            stringBuilder.append(unsupportedEncodingException.getMessage());
            logger.warning(stringBuilder.toString());
            return string2;
        }
    }

    public String getUrlLink() {
        return (String)this.getObjectValue("URLLink");
    }

    @Override
    public String getUserFriendlyValue() {
        return this.getUrlLink();
    }

    public void setUrlLink(String string2) {
        if (string2 != null) {
            this.setObjectValue("URLLink", string2);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("URLLink", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        String string2;
        CharsetEncoder charsetEncoder = StandardCharsets.ISO_8859_1.newEncoder();
        if (!charsetEncoder.canEncode((CharSequence)(string2 = this.getUrlLink()))) {
            this.setUrlLink(this.encodeURL(string2));
            if (!charsetEncoder.canEncode((CharSequence)this.getUrlLink())) {
                AbstractTagItem.logger.warning(ErrorMessage.MP3_UNABLE_TO_ENCODE_URL.getMsg(string2));
                this.setUrlLink("");
            } else {
                Logger logger = AbstractTagItem.logger;
                ErrorMessage errorMessage = ErrorMessage.MP3_URL_SAVED_ENCODED;
                Object[] arrobject = new Object[]{string2, this.getUrlLink()};
                logger.warning(errorMessage.getMsg(arrobject));
            }
        }
        super.write(byteArrayOutputStream);
    }
}

