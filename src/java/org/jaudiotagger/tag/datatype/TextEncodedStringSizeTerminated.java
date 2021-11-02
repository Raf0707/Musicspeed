/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.CharacterCodingException
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.nio.charset.CoderResult
 *  java.nio.charset.CodingErrorAction
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class TextEncodedStringSizeTerminated
extends AbstractString {
    public TextEncodedStringSizeTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public TextEncodedStringSizeTerminated(TextEncodedStringSizeTerminated textEncodedStringSizeTerminated) {
        super(textEncodedStringSizeTerminated);
    }

    public static List<String> splitByNullSeperator(String string2) {
        List list = Arrays.asList((Object[])string2.split("\\u0000"));
        if (list.size() == 0) {
            list = new ArrayList(1);
            list.add((Object)"");
        }
        return list;
    }

    public void addValue(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.value);
        stringBuilder.append("\u0000");
        stringBuilder.append(string2);
        this.setValue(stringBuilder.toString());
    }

    protected void checkTrailingNull(List<String> list, String string2) {
        if (!TagOptionSingleton.getInstance().isRemoveTrailingTerminatorOnWrite() && string2.length() > 0 && string2.charAt(-1 + string2.length()) == '\u0000') {
            String string3 = (String)list.get(-1 + list.size());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append('\u0000');
            String string4 = stringBuilder.toString();
            list.set(-1 + list.size(), (Object)string4);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof TextEncodedStringSizeTerminated && AbstractDataType.super.equals(object);
    }

    public int getNumberOfValues() {
        return TextEncodedStringSizeTerminated.splitByNullSeperator((String)this.value).size();
    }

    public String getValueAtIndex(int n2) {
        return (String)TextEncodedStringSizeTerminated.splitByNullSeperator((String)this.value).get(n2);
    }

    public String getValueWithoutTrailingNull() {
        List<String> list = TextEncodedStringSizeTerminated.splitByNullSeperator((String)this.value);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (i2 != 0) {
                stringBuffer.append("\u0000");
            }
            stringBuffer.append((String)list.get(i2));
        }
        return stringBuffer.toString();
    }

    public List<String> getValues() {
        return TextEncodedStringSizeTerminated.splitByNullSeperator((String)this.value);
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading from array from offset:");
        stringBuilder.append(n2);
        logger.finest(stringBuilder.toString());
        int n3 = arrby.length - n2;
        byte[] arrby2 = new byte[n3];
        System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)n3);
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby2);
        CharBuffer charBuffer = CharBuffer.allocate((int)(arrby.length - n2));
        CharsetDecoder charsetDecoder = this.getCorrectDecoder(byteBuffer);
        CoderResult coderResult = charsetDecoder.decode(byteBuffer, charBuffer, true);
        if (coderResult.isError()) {
            Logger logger2 = AbstractDataType.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Decoding error:");
            stringBuilder2.append(coderResult.toString());
            logger2.warning(stringBuilder2.toString());
        }
        charsetDecoder.flush(charBuffer);
        charBuffer.flip();
        this.value = StandardCharsets.UTF_16.equals((Object)this.getTextEncodingCharSet()) ? charBuffer.toString().replace((CharSequence)"\ufeff", (CharSequence)"").replace((CharSequence)"\ufffe", (CharSequence)"") : charBuffer.toString();
        this.setSize(arrby.length - n2);
        Logger logger3 = AbstractDataType.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Read SizeTerminatedString:");
        stringBuilder3.append(this.value);
        stringBuilder3.append(" size:");
        stringBuilder3.append(this.size);
        logger3.finest(stringBuilder3.toString());
    }

    protected void stripTrailingNull() {
        String string2;
        if (TagOptionSingleton.getInstance().isRemoveTrailingTerminatorOnWrite() && (string2 = (String)this.value).length() > 0 && string2.charAt(-1 + string2.length()) == '\u0000') {
            this.value = string2.substring(0, -1 + string2.length());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] writeByteArray() {
        ByteBuffer byteBuffer;
        Charset charset;
        int n2;
        List<String> list;
        Charset charset2 = this.getTextEncodingCharSet();
        try {
            this.stripTrailingNull();
            String string2 = (String)this.value;
            boolean bl = StandardCharsets.UTF_16.equals((Object)charset2);
            charset = null;
            if (bl) {
                charset = TagOptionSingleton.getInstance().isEncodeUTF16BomAsLittleEndian() ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
            }
            byteBuffer = ByteBuffer.allocate((int)(3 * (3 + string2.length())));
            list = TextEncodedStringSizeTerminated.splitByNullSeperator(string2);
            this.checkTrailingNull(list, string2);
            n2 = 0;
        }
        catch (CharacterCodingException characterCodingException) {
            Logger logger = AbstractDataType.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(characterCodingException.getMessage());
            stringBuilder.append(":");
            stringBuilder.append((Object)charset2);
            stringBuilder.append(":");
            stringBuilder.append(this.value);
            logger.severe(stringBuilder.toString());
            throw new RuntimeException((Throwable)characterCodingException);
        }
        do {
            if (n2 >= list.size()) {
                byteBuffer.flip();
                int n3 = byteBuffer.limit();
                byte[] arrby = new byte[n3];
                byteBuffer.rewind();
                byteBuffer.get(arrby, 0, byteBuffer.limit());
                this.setSize(n3);
                return arrby;
            }
            String string3 = (String)list.get(n2);
            if (StandardCharsets.UTF_16LE.equals((Object)charset)) {
                byteBuffer.put(this.writeStringUTF16LEBOM(string3, n2, list.size()));
            } else if (StandardCharsets.UTF_16BE.equals((Object)charset)) {
                byteBuffer.put(this.writeStringUTF16BEBOM(string3, n2, list.size()));
            } else {
                CharsetEncoder charsetEncoder = charset2.newEncoder();
                charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
                charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                byteBuffer.put(this.writeString(charsetEncoder, string3, n2, list.size()));
            }
            ++n2;
        } while (true);
    }

    protected ByteBuffer writeString(CharsetEncoder charsetEncoder, String string2, int n2, int n3) throws CharacterCodingException {
        ByteBuffer byteBuffer;
        if (n2 + 1 == n3) {
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)string2));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append('\u0000');
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
        }
        byteBuffer.rewind();
        return byteBuffer;
    }

    protected ByteBuffer writeStringUTF16BEBOM(String string2, int n2, int n3) throws CharacterCodingException {
        ByteBuffer byteBuffer;
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_16BE.newEncoder();
        charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
        charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
        if (n2 + 1 == n3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\ufeff');
            stringBuilder.append(string2);
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\ufeff');
            stringBuilder.append(string2);
            stringBuilder.append('\u0000');
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
        }
        byteBuffer.rewind();
        return byteBuffer;
    }

    protected ByteBuffer writeStringUTF16LEBOM(String string2, int n2, int n3) throws CharacterCodingException {
        ByteBuffer byteBuffer;
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_16LE.newEncoder();
        charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
        charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
        if (n2 + 1 == n3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\ufeff');
            stringBuilder.append(string2);
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\ufeff');
            stringBuilder.append(string2);
            stringBuilder.append('\u0000');
            byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
        }
        byteBuffer.rewind();
        return byteBuffer;
    }
}

