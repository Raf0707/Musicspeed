/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDAT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIME;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRDA;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTYER;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTDRC
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody {
    private static final int PRECISION_DAY = 3;
    private static final int PRECISION_HOUR = 2;
    private static final int PRECISION_MINUTE = 1;
    private static final int PRECISION_MONTH = 4;
    private static final int PRECISION_SECOND = 0;
    private static final int PRECISION_YEAR = 5;
    private static SimpleDateFormat formatDateIn;
    private static SimpleDateFormat formatDateOut;
    private static SimpleDateFormat formatHoursOut;
    private static SimpleDateFormat formatMonthOut;
    private static SimpleDateFormat formatTimeIn;
    private static SimpleDateFormat formatTimeOut;
    private static SimpleDateFormat formatYearIn;
    private static SimpleDateFormat formatYearOut;
    private static final List<SimpleDateFormat> formatters;
    private String date = "";
    private boolean hoursOnly = false;
    private boolean monthOnly = false;
    private String originalID;
    private String time = "";
    private String year = "";

    static {
        ArrayList arrayList;
        formatters = arrayList = new ArrayList();
        arrayList.add((Object)new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.UK));
        arrayList.add((Object)new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.UK));
        arrayList.add((Object)new SimpleDateFormat("yyyy-MM-dd'T'HH", Locale.UK));
        arrayList.add((Object)new SimpleDateFormat("yyyy-MM-dd", Locale.UK));
        arrayList.add((Object)new SimpleDateFormat("yyyy-MM", Locale.UK));
        arrayList.add((Object)new SimpleDateFormat("yyyy", Locale.UK));
        formatYearIn = new SimpleDateFormat("yyyy", Locale.UK);
        formatDateIn = new SimpleDateFormat("ddMM", Locale.UK);
        formatTimeIn = new SimpleDateFormat("HHmm", Locale.UK);
        formatYearOut = new SimpleDateFormat("yyyy", Locale.UK);
        formatDateOut = new SimpleDateFormat("-MM-dd", Locale.UK);
        formatMonthOut = new SimpleDateFormat("-MM", Locale.UK);
        formatTimeOut = new SimpleDateFormat("'T'HH:mm", Locale.UK);
        formatHoursOut = new SimpleDateFormat("'T'HH", Locale.UK);
    }

    public FrameBodyTDRC() {
    }

    public FrameBodyTDRC(byte by, String string2) {
        super(by, string2);
        this.findMatchingMaskAndExtractV3Values();
    }

    public FrameBodyTDRC(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
        this.findMatchingMaskAndExtractV3Values();
    }

    public FrameBodyTDRC(FrameBodyTDAT frameBodyTDAT) {
        this.originalID = "TDAT";
        this.date = frameBodyTDAT.getText();
        this.setMonthOnly(frameBodyTDAT.isMonthOnly());
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", this.getFormattedText());
    }

    public FrameBodyTDRC(FrameBodyTDRC frameBodyTDRC) {
        super(frameBodyTDRC);
    }

    public FrameBodyTDRC(FrameBodyTIME frameBodyTIME) {
        this.originalID = "TIME";
        this.time = frameBodyTIME.getText();
        this.setHoursOnly(frameBodyTIME.isHoursOnly());
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", this.getFormattedText());
    }

    public FrameBodyTDRC(FrameBodyTRDA frameBodyTRDA) {
        this.originalID = "TRDA";
        this.date = frameBodyTRDA.getText();
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", this.getFormattedText());
    }

    public FrameBodyTDRC(FrameBodyTYER frameBodyTYER) {
        this.originalID = "TYER";
        this.year = frameBodyTYER.getText();
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", this.getFormattedText());
    }

    private void extractID3v23Formats(Date date, int n2) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Precision is:");
        stringBuilder.append(n2);
        stringBuilder.append("for date:");
        stringBuilder.append(date.toString());
        logger.fine(stringBuilder.toString());
        if (n2 == 5) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            return;
        }
        if (n2 == 4) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            this.setDate(FrameBodyTDRC.formatDateAsDate(date));
            this.monthOnly = true;
            return;
        }
        if (n2 == 3) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            this.setDate(FrameBodyTDRC.formatDateAsDate(date));
            return;
        }
        if (n2 == 2) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            this.setDate(FrameBodyTDRC.formatDateAsDate(date));
            this.setTime(FrameBodyTDRC.formatDateAsTime(date));
            this.hoursOnly = true;
            return;
        }
        if (n2 == 1) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            this.setDate(FrameBodyTDRC.formatDateAsDate(date));
            this.setTime(FrameBodyTDRC.formatDateAsTime(date));
            return;
        }
        if (n2 == 0) {
            this.setYear(FrameBodyTDRC.formatDateAsYear(date));
            this.setDate(FrameBodyTDRC.formatDateAsDate(date));
            this.setTime(FrameBodyTDRC.formatDateAsTime(date));
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static String formatAndParse(SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2, String string2) {
        Class<FrameBodyTDRC> class_ = FrameBodyTDRC.class;
        // MONITORENTER : org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC.class
        String string3 = simpleDateFormat.format(simpleDateFormat2.parse(string2));
        // MONITOREXIT : class_
        return string3;
        catch (ParseException parseException) {
            Logger logger = AbstractTagItem.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to parse:");
            stringBuilder.append(string2);
            logger.warning(stringBuilder.toString());
            // MONITOREXIT : class_
            return "";
        }
    }

    private static String formatDateAsDate(Date date) {
        Class<FrameBodyTDRC> class_ = FrameBodyTDRC.class;
        synchronized (FrameBodyTDRC.class) {
            String string2 = formatDateIn.format(date);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return string2;
        }
    }

    private static String formatDateAsTime(Date date) {
        Class<FrameBodyTDRC> class_ = FrameBodyTDRC.class;
        synchronized (FrameBodyTDRC.class) {
            String string2 = formatTimeIn.format(date);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return string2;
        }
    }

    private static String formatDateAsYear(Date date) {
        Class<FrameBodyTDRC> class_ = FrameBodyTDRC.class;
        synchronized (FrameBodyTDRC.class) {
            String string2 = formatYearIn.format(date);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return string2;
        }
    }

    /*
     * Exception decompiling
     */
    public void findMatchingMaskAndExtractV3Values() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    public String getDate() {
        return this.date;
    }

    public String getFormattedText() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.originalID == null) {
            return this.getText();
        }
        String string2 = this.year;
        if (string2 != null && !string2.trim().isEmpty()) {
            stringBuffer.append(FrameBodyTDRC.formatAndParse(formatYearOut, formatYearIn, this.year));
        }
        if (!this.date.equals((Object)"")) {
            if (this.isMonthOnly()) {
                stringBuffer.append(FrameBodyTDRC.formatAndParse(formatMonthOut, formatDateIn, this.date));
            } else {
                stringBuffer.append(FrameBodyTDRC.formatAndParse(formatDateOut, formatDateIn, this.date));
            }
        }
        if (!this.time.equals((Object)"")) {
            if (this.isHoursOnly()) {
                stringBuffer.append(FrameBodyTDRC.formatAndParse(formatHoursOut, formatTimeIn, this.time));
            } else {
                stringBuffer.append(FrameBodyTDRC.formatAndParse(formatTimeOut, formatTimeIn, this.time));
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public String getIdentifier() {
        return "TDRC";
    }

    public String getOriginalID() {
        return this.originalID;
    }

    public String getTime() {
        return this.time;
    }

    public String getYear() {
        return this.year;
    }

    public boolean isHoursOnly() {
        return this.hoursOnly;
    }

    public boolean isMonthOnly() {
        return this.monthOnly;
    }

    public void setDate(String string2) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Setting date to:");
        stringBuilder.append(string2);
        logger.finest(stringBuilder.toString());
        this.date = string2;
    }

    public void setHoursOnly(boolean bl) {
        this.hoursOnly = bl;
    }

    public void setMonthOnly(boolean bl) {
        this.monthOnly = bl;
    }

    public void setTime(String string2) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Setting time to:");
        stringBuilder.append(string2);
        logger.finest(stringBuilder.toString());
        this.time = string2;
    }

    public void setYear(String string2) {
        Logger logger = AbstractTagItem.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Setting year to");
        stringBuilder.append(string2);
        logger.finest(stringBuilder.toString());
        this.year = string2;
    }
}

