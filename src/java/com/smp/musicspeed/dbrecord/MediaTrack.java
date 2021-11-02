/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.smp.musicspeed.dbrecord.MediaTrack$Companion$buildMediaTrackList$
 *  com.smp.musicspeed.dbrecord.MediaTrack$Companion$buildMediaTrackList$$inlined
 *  com.smp.musicspeed.dbrecord.MediaTrack$Companion$buildMediaTrackList$$inlined$compareBy
 *  com.smp.musicspeed.dbrecord.MediaTrack$Companion$buildMediaTrackList$$inlined$compareByDescending
 *  f.u.l
 *  java.io.File
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.dbrecord.MediaTrack$Companion$buildMediaTrackList$;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.e;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.io.File;
import java.util.Comparator;
import java.util.List;

public final class MediaTrack
implements e,
Parcelable {
    public static final Parcelable.Creator<MediaTrack> CREATOR;
    public static final Companion Companion;
    private long albumId;
    private String albumName;
    private long artistId;
    private String artistName;
    private long dateModified;
    private long duration;
    private long idInPlaylist;
    private boolean isInLibrary;
    private String location;
    private I mediaType;
    private long songId;
    private String trackName;
    private int trackNumber;
    private int year;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public static /* synthetic */ List buildMediaTrackList$default(Companion companion, Context context, Cursor cursor, Cursor cursor2, Resources resources, String string, int n2, Object object) {
                if ((n2 & 16) != 0) {
                    string = "title_key";
                }
                return companion.buildMediaTrackList(context, cursor, cursor2, resources, string);
            }

            /*
             * Exception decompiling
             */
            private final List<MediaTrack> buildVideoList(Cursor var1, Resources var2) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl137.1 : ILOAD : trying to set 1 previously set to 0
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

            /*
             * Exception decompiling
             */
            public final List<MediaTrack> buildAudioList(Context var1, Cursor var2, Resources var3) {
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

            /*
             * Enabled aggressive block sorting
             */
            public final List<MediaTrack> buildMediaTrackList(Context context, Cursor cursor, Cursor cursor2, Resources resources, String string) {
                void var7_11;
                k.g((Object)context, "context");
                k.g((Object)cursor, "audioCur");
                k.g((Object)cursor2, "videoCur");
                k.g((Object)resources, "res");
                k.g(string, "sortOrder");
                int n2 = string.hashCode();
                if (n2 != -2135424008) {
                    if (n2 != -825358278) {
                        if (n2 == -102326855 && string.equals((Object)"title_key DESC")) {
                            Comparator comparator = }
                    }
                }
            }
        }
        java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
        
        