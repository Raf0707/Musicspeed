/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
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
 *  java.util.logging.Logger
 *  java.util.regex.Pattern
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
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.tag.options.PadNumberOption;
import org.jaudiotagger.utils.EqualsUtil;

public class PartOfSet
extends AbstractString {
    public PartOfSet(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public PartOfSet(PartOfSet partOfSet) {
        super(partOfSet);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PartOfSet)) {
            return false;
        }
        PartOfSet partOfSet = (PartOfSet)object;
        return EqualsUtil.areEqual(this.value, partOfSet.value);
    }

    @Override
    protected Charset getTextEncodingCharSet() {
        byte by = this.getBody().getTextEncoding();
        Charset charset = TextEncoding.getInstanceOf().getCharsetForId(by);
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("text encoding:");
        stringBuilder.append((int)by);
        stringBuilder.append(" charset:");
        stringBuilder.append(charset.name());
        logger.finest(stringBuilder.toString());
        return charset;
    }

    @Override
    public PartOfSetValue getValue() {
        return this.value;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading from array from offset:");
        stringBuilder.append(n2);
        logger.finest(stringBuilder.toString());
        CharsetDecoder charsetDecoder = this.getTextEncodingCharSet().newDecoder();
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby, (int)n2, (int)(arrby.length - n2)).slice();
        CharBuffer charBuffer = CharBuffer.allocate((int)(arrby.length - n2));
        charsetDecoder.reset();
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
        this.value = new Object(charBuffer.toString()){
            private static final String SEPARATOR = "/";
            private static final Pattern trackNoPattern;
            private static final Pattern trackNoPatternWithTotalCount;
            private Integer count;
            private String extra;
            private String rawCount;
            private String rawText;
            private String rawTotal;
            private Integer total;

            static {
                trackNoPatternWithTotalCount = Pattern.compile((String)"([0-9]+)/([0-9]+)(.*)", (int)2);
                trackNoPattern = Pattern.compile((String)"([0-9]+)(.*)", (int)2);
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
            private void initFromValue(String var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : RETURN : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:923)
                throw new IllegalStateException("Decompilation failed");
            }

            private void padNumber(StringBuffer stringBuffer, Integer n2, PadNumberOption padNumberOption) {
                if (n2 != null) {
                    if (padNumberOption == PadNumberOption.PAD_ONE_ZERO) {
                        if (n2 > 0 && n2 < 10) {
                            stringBuffer.append("0");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        stringBuffer.append(n2.intValue());
                        return;
                    }
                    if (padNumberOption == PadNumberOption.PAD_TWO_ZERO) {
                        if (n2 > 0 && n2 < 10) {
                            stringBuffer.append("00");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        if (n2 > 9 && n2 < 100) {
                            stringBuffer.append("0");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        stringBuffer.append(n2.intValue());
                        return;
                    }
                    if (padNumberOption == PadNumberOption.PAD_THREE_ZERO) {
                        if (n2 > 0 && n2 < 10) {
                            stringBuffer.append("000");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        if (n2 > 9 && n2 < 100) {
                            stringBuffer.append("00");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        if (n2 > 99 && n2 < 1000) {
                            stringBuffer.append("0");
                            stringBuffer.append((Object)n2);
                            return;
                        }
                        stringBuffer.append(n2.intValue());
                    }
                }
            }

            private void resetValueFromCounts() {
                String string2;
                StringBuffer stringBuffer = new StringBuffer();
                String string3 = this.rawCount;
                if (string3 != null) {
                    stringBuffer.append(string3);
                } else {
                    stringBuffer.append("0");
                }
                if (this.rawTotal != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(SEPARATOR);
                    stringBuilder.append(this.rawTotal);
                    stringBuffer.append(stringBuilder.toString());
                }
                if ((string2 = this.extra) != null) {
                    stringBuffer.append(string2);
                }
                this.rawText = stringBuffer.toString();
            }

            public boolean equals(Object object) {
                if (object == this) {
                    return true;
                }
                if (!(object instanceof PartOfSetValue)) {
                    return false;
                }
                PartOfSetValue partOfSetValue = object;
                return EqualsUtil.areEqual((Object)this.getCount(), (Object)partOfSetValue.getCount()) && EqualsUtil.areEqual((Object)this.getTotal(), (Object)partOfSetValue.getTotal());
            }

            public Integer getCount() {
                return this.count;
            }

            public String getCountAsText() {
                StringBuffer stringBuffer = new StringBuffer();
                if (!TagOptionSingleton.getInstance().isPadNumbers()) {
                    return this.rawCount;
                }
                this.padNumber(stringBuffer, this.count, TagOptionSingleton.getInstance().getPadNumberTotalLength());
                return stringBuffer.toString();
            }

            public String getRawValue() {
                return this.rawText;
            }

            public Integer getTotal() {
                return this.total;
            }

            public String getTotalAsText() {
                StringBuffer stringBuffer = new StringBuffer();
                if (!TagOptionSingleton.getInstance().isPadNumbers()) {
                    return this.rawTotal;
                }
                this.padNumber(stringBuffer, this.total, TagOptionSingleton.getInstance().getPadNumberTotalLength());
                return stringBuffer.toString();
            }

            public void setCount(Integer n2) {
                this.count = n2;
                this.rawCount = n2.toString();
                this.resetValueFromCounts();
            }

            public void setCount(String string2) {
                try {
                    this.count = Integer.parseInt((String)string2);
                    this.rawCount = string2;
                    this.resetValueFromCounts();
                }
                catch (NumberFormatException numberFormatException) {}
            }

            public void setRawValue(String string2) {
                this.rawText = string2;
                this.initFromValue(string2);
            }

            public void setTotal(Integer n2) {
                this.total = n2;
                this.rawTotal = n2.toString();
                this.resetValueFromCounts();
            }

            public void setTotal(String string2) {
                try {
                    this.total = Integer.parseInt((String)string2);
                    this.rawTotal = string2;
                    this.resetValueFromCounts();
                }
                catch (NumberFormatException numberFormatException) {}
            }

            public String toString() {
                String string2;
                StringBuffer stringBuffer = new StringBuffer();
                if (!TagOptionSingleton.getInstance().isPadNumbers()) {
                    return this.rawText;
                }
                Integer n2 = this.count;
                if (n2 != null) {
                    this.padNumber(stringBuffer, n2, TagOptionSingleton.getInstance().getPadNumberTotalLength());
                } else if (this.total != null) {
                    this.padNumber(stringBuffer, 0, TagOptionSingleton.getInstance().getPadNumberTotalLength());
                }
                if (this.total != null) {
                    stringBuffer.append(SEPARATOR);
                    this.padNumber(stringBuffer, this.total, TagOptionSingleton.getInstance().getPadNumberTotalLength());
                }
                if ((string2 = this.extra) != null) {
                    stringBuffer.append(string2);
                }
                return stringBuffer.toString();
            }
        };
        this.setSize(arrby.length - n2);
        Logger logger3 = AbstractDataType.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Read SizeTerminatedString:");
        stringBuilder3.append(this.value);
        stringBuilder3.append(" size:");
        stringBuilder3.append(this.size);
        logger3.config(stringBuilder3.toString());
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby;
        int n2;
        String string2 = this.getValue().toString();
        try {
            CharsetEncoder charsetEncoder;
            Charset charset;
            if (TagOptionSingleton.getInstance().isRemoveTrailingTerminatorOnWrite() && string2.length() > 0 && string2.charAt(-1 + string2.length()) == '\u0000') {
                string2 = string2.substring(0, -1 + string2.length());
            }
            if (StandardCharsets.UTF_16.equals((Object)(charset = this.getTextEncodingCharSet()))) {
                charsetEncoder = StandardCharsets.UTF_16LE.newEncoder();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('\ufeff');
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            } else {
                charsetEncoder = charset.newEncoder();
            }
            charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
            charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
            ByteBuffer byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)string2));
            n2 = byteBuffer.limit();
            arrby = new byte[n2];
            byteBuffer.get(arrby, 0, byteBuffer.limit());
        }
        catch (CharacterCodingException characterCodingException) {
            AbstractDataType.logger.severe(characterCodingException.getMessage());
            throw new RuntimeException((Throwable)characterCodingException);
        }
        this.setSize(n2);
        return arrby;
    }

}

