/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.mp3;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.mp3.LameFrame;
import org.jaudiotagger.audio.mp3.MPEGFrameHeader;
import org.jaudiotagger.audio.mp3.VbriFrame;
import org.jaudiotagger.audio.mp3.XingFrame;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.logging.Hex;

public class MP3AudioHeader
implements AudioHeader {
    private static final int CONVERTS_BYTE_TO_BITS = 8;
    private static final int CONVERT_TO_KILOBITS = 1000;
    private static final int FILE_BUFFER_SIZE = 5000;
    private static final int MIN_BUFFER_REMAINING_REQUIRED = 196;
    private static final int NO_SECONDS_IN_HOUR = 3600;
    private static final String TYPE_MP3 = "mp3";
    private static final char isVbrIdentifier = '~';
    public static Logger logger;
    private static final SimpleDateFormat timeInFormat;
    private static final SimpleDateFormat timeOutFormat;
    private static final SimpleDateFormat timeOutOverAnHourFormat;
    private Long audioDataEndPosition;
    private Long audioDataStartPosition;
    private long bitrate;
    private String encoder = "";
    private long fileSize;
    protected MPEGFrameHeader mp3FrameHeader;
    protected VbriFrame mp3VbriFrame;
    protected XingFrame mp3XingFrame;
    private long numberOfFrames;
    private long numberOfFramesEstimate;
    private long startByte;
    private double timePerFrame;
    private double trackLength;

    static {
        timeInFormat = new SimpleDateFormat("ss", Locale.UK);
        timeOutFormat = new SimpleDateFormat("mm:ss", Locale.UK);
        timeOutOverAnHourFormat = new SimpleDateFormat("kk:mm:ss", Locale.UK);
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.mp3");
    }

    public MP3AudioHeader() {
    }

    public MP3AudioHeader(File file) throws IOException, InvalidAudioFrameException {
        if (this.seek(file, 0L)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No audio header found within");
        stringBuilder.append(file.getName());
        throw new InvalidAudioFrameException(stringBuilder.toString());
    }

    public MP3AudioHeader(File file, long l2) throws IOException, InvalidAudioFrameException {
        if (this.seek(file, l2)) {
            return;
        }
        ErrorMessage errorMessage = ErrorMessage.NO_AUDIO_HEADER_FOUND;
        Object[] arrobject = new Object[]{file.getName()};
        throw new InvalidAudioFrameException(errorMessage.getMsg(arrobject));
    }

    private double getTimePerFrame() {
        return this.timePerFrame;
    }

    /*
     * Exception decompiling
     */
    private boolean isNextFrameValid(File var1, long var2, ByteBuffer var4, FileChannel var5) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl176 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    @Override
    public Long getAudioDataEndPosition() {
        return this.audioDataEndPosition;
    }

    @Override
    public Long getAudioDataLength() {
        return 0L;
    }

    @Override
    public Long getAudioDataStartPosition() {
        return this.audioDataStartPosition;
    }

    @Override
    public String getBitRate() {
        XingFrame xingFrame = this.mp3XingFrame;
        if (xingFrame != null && xingFrame.isVbr()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('~');
            stringBuilder.append(String.valueOf((long)this.bitrate));
            return stringBuilder.toString();
        }
        if (this.mp3VbriFrame != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('~');
            stringBuilder.append(String.valueOf((long)this.bitrate));
            return stringBuilder.toString();
        }
        return String.valueOf((long)this.bitrate);
    }

    @Override
    public long getBitRateAsNumber() {
        return this.bitrate;
    }

    @Override
    public int getBitsPerSample() {
        return 16;
    }

    @Override
    public Integer getByteRate() {
        return null;
    }

    @Override
    public String getChannels() {
        return this.mp3FrameHeader.getChannelModeAsString();
    }

    public String getEmphasis() {
        return this.mp3FrameHeader.getEmphasisAsString();
    }

    public String getEncoder() {
        return this.encoder;
    }

    @Override
    public String getEncodingType() {
        return TYPE_MP3;
    }

    @Override
    public String getFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mp3FrameHeader.getVersionAsString());
        stringBuilder.append(" ");
        stringBuilder.append(this.mp3FrameHeader.getLayerAsString());
        return stringBuilder.toString();
    }

    public long getMp3StartByte() {
        return this.startByte;
    }

    public String getMpegLayer() {
        return this.mp3FrameHeader.getLayerAsString();
    }

    public String getMpegVersion() {
        return this.mp3FrameHeader.getVersionAsString();
    }

    @Override
    public Long getNoOfSamples() {
        return this.numberOfFrames;
    }

    public long getNumberOfFrames() {
        return this.numberOfFrames;
    }

    public long getNumberOfFramesEstimate() {
        return this.numberOfFramesEstimate;
    }

    @Override
    public double getPreciseTrackLength() {
        return this.trackLength;
    }

    @Override
    public String getSampleRate() {
        return String.valueOf((Object)this.mp3FrameHeader.getSamplingRate());
    }

    @Override
    public int getSampleRateAsNumber() {
        return this.mp3FrameHeader.getSamplingRate();
    }

    @Override
    public int getTrackLength() {
        return (int)this.getPreciseTrackLength();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public String getTrackLengthAsString() {
        try {
            var8_1 = this.getTrackLength();
            var19_3 = var10_2 = MP3AudioHeader.timeInFormat;
            // MONITORENTER : var19_3
        }
        catch (ParseException var1_11) {
            var2_12 = MP3AudioHeader.logger;
            var3_13 = new StringBuilder();
            var3_13.append("Unable to parse:");
            var3_13.append(this.getPreciseTrackLength());
            var3_13.append(" failed with ParseException:");
            var3_13.append(var1_11.getMessage());
            var2_12.warning(var3_13.toString());
            return "";
        }
        var12_4 = var10_2.parse(String.valueOf((long)var8_1));
        // MONITOREXIT : var19_3
        if (var8_1 >= 3600L) ** GOTO lbl-1000
        var20_6 = var16_5 = MP3AudioHeader.timeOutFormat;
        // MONITORENTER : var20_6
        var18_7 = var16_5.format(var12_4);
        // MONITOREXIT : var20_6
        return var18_7;
lbl-1000: // 1 sources:
        {
            var21_9 = var13_8 = MP3AudioHeader.timeOutOverAnHourFormat;
            // MONITORENTER : var21_9
        }
        var15_10 = var13_8.format(var12_4);
        // MONITOREXIT : var21_9
        return var15_10;
    }

    public boolean isCopyrighted() {
        return this.mp3FrameHeader.isCopyrighted();
    }

    @Override
    public boolean isLossless() {
        return false;
    }

    public boolean isOriginal() {
        return this.mp3FrameHeader.isOriginal();
    }

    public boolean isPadding() {
        return this.mp3FrameHeader.isPadding();
    }

    public boolean isPrivate() {
        return this.mp3FrameHeader.isPrivate();
    }

    public boolean isProtected() {
        return this.mp3FrameHeader.isProtected();
    }

    @Override
    public boolean isVariableBitRate() {
        XingFrame xingFrame = this.mp3XingFrame;
        if (xingFrame != null) {
            return xingFrame.isVbr();
        }
        VbriFrame vbriFrame = this.mp3VbriFrame;
        if (vbriFrame != null) {
            return vbriFrame.isVbr();
        }
        return this.mp3FrameHeader.isVariableBitRate();
    }

    /*
     * Exception decompiling
     */
    public boolean seek(File var1, long var2) throws IOException {
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

    public void setAudioDataEndPosition(Long l2) {
        this.audioDataEndPosition = l2;
    }

    public void setAudioDataStartPosition(Long l2) {
        this.audioDataStartPosition = l2;
    }

    protected void setBitRate() {
        XingFrame xingFrame = this.mp3XingFrame;
        if (xingFrame != null && xingFrame.isVbr()) {
            if (this.mp3XingFrame.isAudioSizeEnabled() && this.mp3XingFrame.getAudioSize() > 0) {
                this.bitrate = (long)((double)(8 * this.mp3XingFrame.getAudioSize()) / (1000.0 * (this.timePerFrame * (double)this.getNumberOfFrames())));
                return;
            }
            this.bitrate = (long)((double)(8L * (this.fileSize - this.startByte)) / (1000.0 * (this.timePerFrame * (double)this.getNumberOfFrames())));
            return;
        }
        VbriFrame vbriFrame = this.mp3VbriFrame;
        if (vbriFrame != null) {
            if (vbriFrame.getAudioSize() > 0) {
                this.bitrate = (long)((double)(8 * this.mp3VbriFrame.getAudioSize()) / (1000.0 * (this.timePerFrame * (double)this.getNumberOfFrames())));
                return;
            }
            this.bitrate = (long)((double)(8L * (this.fileSize - this.startByte)) / (1000.0 * (this.timePerFrame * (double)this.getNumberOfFrames())));
            return;
        }
        this.bitrate = this.mp3FrameHeader.getBitRate().intValue();
    }

    protected void setEncoder() {
        XingFrame xingFrame = this.mp3XingFrame;
        if (xingFrame != null) {
            if (xingFrame.getLameFrame() != null) {
                this.encoder = this.mp3XingFrame.getLameFrame().getEncoder();
                return;
            }
        } else {
            VbriFrame vbriFrame = this.mp3VbriFrame;
            if (vbriFrame != null) {
                this.encoder = vbriFrame.getEncoder();
            }
        }
    }

    protected void setFileSize(long l2) {
        this.fileSize = l2;
    }

    protected void setMp3StartByte(long l2) {
        this.startByte = l2;
    }

    protected void setNumberOfFrames() {
        this.numberOfFramesEstimate = (this.fileSize - this.startByte) / (long)this.mp3FrameHeader.getFrameLength();
        XingFrame xingFrame = this.mp3XingFrame;
        if (xingFrame != null && xingFrame.isFrameCountEnabled()) {
            this.numberOfFrames = this.mp3XingFrame.getFrameCount();
            return;
        }
        VbriFrame vbriFrame = this.mp3VbriFrame;
        if (vbriFrame != null) {
            this.numberOfFrames = vbriFrame.getFrameCount();
            return;
        }
        this.numberOfFrames = this.numberOfFramesEstimate;
    }

    protected void setTimePerFrame() {
        this.timePerFrame = (double)this.mp3FrameHeader.getNoOfSamples() / this.mp3FrameHeader.getSamplingRate().doubleValue();
        if (!(this.mp3FrameHeader.getVersion() != 2 && this.mp3FrameHeader.getVersion() != 0 || this.mp3FrameHeader.getLayer() != 2 && this.mp3FrameHeader.getLayer() != 1 || this.mp3FrameHeader.getNumberOfChannels() != 1)) {
            this.timePerFrame /= 2.0;
        }
    }

    protected void setTrackLength() {
        this.trackLength = (double)this.numberOfFrames * this.getTimePerFrame();
    }

    public String toString() {
        String string2;
        String string3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fileSize:");
        stringBuilder.append(this.fileSize);
        stringBuilder.append(" encoder:");
        stringBuilder.append(this.encoder);
        stringBuilder.append(" startByte:");
        stringBuilder.append(Hex.asHex(this.startByte));
        stringBuilder.append(" numberOfFrames:");
        stringBuilder.append(this.numberOfFrames);
        stringBuilder.append(" numberOfFramesEst:");
        stringBuilder.append(this.numberOfFramesEstimate);
        stringBuilder.append(" timePerFrame:");
        stringBuilder.append(this.timePerFrame);
        stringBuilder.append(" bitrate:");
        stringBuilder.append(this.bitrate);
        stringBuilder.append(" trackLength:");
        stringBuilder.append(this.getTrackLengthAsString());
        String string4 = stringBuilder.toString();
        if (this.mp3FrameHeader != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string4);
            stringBuilder2.append(this.mp3FrameHeader.toString());
            string2 = stringBuilder2.toString();
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string4);
            stringBuilder3.append(" mpegframeheader:false");
            string2 = stringBuilder3.toString();
        }
        if (this.mp3XingFrame != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string2);
            stringBuilder4.append(this.mp3XingFrame.toString());
            string3 = stringBuilder4.toString();
        } else {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(string2);
            stringBuilder5.append(" mp3XingFrame:false");
            string3 = stringBuilder5.toString();
        }
        if (this.mp3VbriFrame != null) {
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(string3);
            stringBuilder6.append(this.mp3VbriFrame.toString());
            return stringBuilder6.toString();
        }
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(string3);
        stringBuilder7.append(" mp3VbriFrame:false");
        return stringBuilder7.toString();
    }
}

