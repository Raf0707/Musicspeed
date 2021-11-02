/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.f0
 *  com.smp.musicspeed.tag_editor.d$a
 *  f.u.g0
 *  f.u.l
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlinx.coroutines.b3.y
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 */
package com.smp.musicspeed.tag_editor;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.tag_editor.d;
import com.smp.musicspeed.tag_editor.g;
import com.smp.musicspeed.tag_editor.h;
import com.smp.musicspeed.tag_editor.j;
import f.l;
import f.t;
import f.u.a0;
import f.u.b0;
import f.u.g0;
import f.z.c.p;
import f.z.d.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.b3.y;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public final class d
extends g {
    private final Album k;
    private final Map<FieldKey, String> l;
    private final Map<FieldKey, String> m;
    private final List<MediaTrack> n;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public d(Context context, Album album) {
        k.g((Object)context, "context");
        k.g(album, "album");
        super(context);
        this.k = album;
        l[] arrl = new l[]{f.p.a(FieldKey.ALBUM, album.m()), f.p.a(FieldKey.ARTIST, album.p()), f.p.a(FieldKey.GENRE, null), f.p.a(FieldKey.YEAR, String.valueOf((int)album.r()))};
        this.l = g0.j((l[])arrl);
        this.m = g0.p(this.u());
        List<MediaTrack> list = f.g(context, album.l());
        this.n = list;
        try {
            if (list.isEmpty()) {
                throw new IllegalArgumentException();
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            do {
                Object object;
                FieldKey fieldKey;
                block8 : {
                    if (!iterator.hasNext()) break block8;
                }
                Iterator iterator2 = b0.a(new a0<String, String>((Iterable)arrayList){
                    final /* synthetic */ Iterable a;
                    {
                        this.a = iterable;
                    }

                    public String a(String string) {
                        return string;
                    }

                    public Iterator<String> b() {
                        return this.a.iterator();
                    }
                }).entrySet().iterator();
                if (!iterator2.hasNext()) {
                    object = null;
                } else {
                    object = iterator2.next();
                    if (iterator2.hasNext()) {
                        int n2 = ((Number)((Map.Entry)object).getValue()).intValue();
                        do {
                            int n3;
                            Object object2;
                            if (n2 >= (n3 = ((Number)((Map.Entry)(object2 = iterator2.next())).getValue()).intValue())) continue;
                            object = object2;
                            n2 = n3;
                        } while (iterator2.hasNext());
                    }
                }
                Map.Entry entry = (Map.Entry)object;
                String string = entry == null ? null : (String)entry.getKey();
                this.u().put((Object)FieldKey.GENRE, (Object)string);
                this.k().offer((Object)new h());
                return;
                Tag tag = AudioFileIO.read(new File(((MediaTrack)iterator.next()).getLocation())).getTag();
                String string2 = tag != null && tag.hasField(fieldKey = FieldKey.GENRE) ? tag.getFirst(fieldKey) : null;
                if (string2 == null) continue;
                arrayList.add(string2);
            } while (true);
        }
        catch (Exception exception) {
            e.d((k0)f0.a((e0)this), null, null, (p)new a(this, null), (int)3, null);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private static final void C(d var0, File var1, byte[] var2) {
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

    public final Album B() {
        return this.k;
    }

    /*
     * Exception decompiling
     */
    @Override
    protected Uri i() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl73.1 : ACONST_NULL : trying to set 1 previously set to 0
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
    public List<Uri> j() {
        List<MediaTrack> list = this.n;
        ArrayList arrayList = new ArrayList(f.u.l.j(list, (int)10));
        for (MediaTrack mediaTrack : list) {
            arrayList.add((Object)ContentUris.withAppendedId((Uri)MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long)mediaTrack.getSongId()));
        }
        return arrayList;
    }

    @Override
    public Map<FieldKey, String> p() {
        return this.m;
    }

    @Override
    protected Map<FieldKey, String> u() {
        return this.l;
    }

    /*
     * Exception decompiling
     */
    @Override
    protected Object z(f.w.d<? super t> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl680 : ALOAD : trying to set 1 previously set to 0
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
}

