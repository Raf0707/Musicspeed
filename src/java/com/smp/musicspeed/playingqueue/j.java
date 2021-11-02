/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Albums
 *  android.util.Size
 *  com.bumptech.glide.g
 *  com.bumptech.glide.load.a
 *  com.bumptech.glide.load.n.d
 *  com.bumptech.glide.load.n.d$a
 *  f.g0.k
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package com.smp.musicspeed.playingqueue;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.util.Size;
import com.bumptech.glide.load.n.d;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.playingqueue.i;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.l;
import f.z.d.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

public final class j
implements d<InputStream> {
    private final Context f;
    private final i g;
    private InputStream h;

    public j(Context context, i i2) {
        k.g((Object)context, "context");
        k.g(i2, "model");
        this.f = context;
        this.g = i2;
    }

    @SuppressLint(value={"ResourceType"})
    private final InputStream c(String string) throws FileNotFoundException {
        InputStream inputStream = this.g.a().getResources().openRawResource(2131230872);
        k.f((Object)inputStream, "model.context.resources.openRawResource(R.drawable.defaultcover)");
        return inputStream;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private final InputStream g(MediaTrack mediaTrack) {
        Throwable throwable2222;
        String string = g.d(mediaTrack.getLocation());
        k.f(string, "getExtension(track.location)");
        if (!com.ipaulpro.afilechooser.g.a.e(f.g0.k.m((String)string, (String)".", (String)"", (boolean)false, (int)4, null))) return j.j(this, mediaTrack);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(mediaTrack.getLocation());
        byte[] arrby = mediaMetadataRetriever.getEmbeddedPicture();
        Object object = arrby != null ? new ByteArrayInputStream(arrby) : j.j(this, mediaTrack);
        mediaMetadataRetriever.release();
        return object;
        {
            InputStream inputStream;
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                inputStream = j.j(this, mediaTrack);
            }
            mediaMetadataRetriever.release();
            return inputStream;
        }
        mediaMetadataRetriever.release();
        throw throwable2222;
    }

    private final InputStream h(Album album) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return new FileInputStream(album.n());
            }
            Uri uri = ContentUris.withAppendedId((Uri)MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, (long)album.l());
            k.f((Object)uri, "withAppendedId(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, album.albumId)");
            Size size = new Size(l.c(), l.b());
            Bitmap bitmap = this.f.getContentResolver().loadThumbnail(uri, size, null);
            k.f((Object)bitmap, "context.contentResolver.loadThumbnail(uri, size, null)");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)byteArrayOutputStream);
            byte[] arrby = byteArrayOutputStream.toByteArray();
            k.f(arrby, "bos.toByteArray()");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
            return byteArrayInputStream;
        }
        catch (Exception exception) {
            return j.i(this, album);
        }
    }

    private static final InputStream i(j j2, Album album) {
        block6 : {
            List<MediaTrack> list = f.g(j2.f, album.l());
            if (true ^ list.isEmpty()) {
                MediaMetadataRetriever mediaMetadataRetriever;
                block5 : {
                    MediaTrack mediaTrack = (MediaTrack)list.get(0);
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(mediaTrack.getLocation());
                    byte[] arrby = mediaMetadataRetriever.getEmbeddedPicture();
                    if (arrby == null) break block5;
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
                    return byteArrayInputStream;
                }
                mediaMetadataRetriever.release();
                break block6;
                finally {
                    mediaMetadataRetriever.release();
                }
            }
        }
        throw new Exception("no art found");
    }

    private static final InputStream j(j j2, MediaTrack mediaTrack) {
        return j2.k(mediaTrack);
    }

    private final InputStream k(MediaTrack mediaTrack) {
        ByteArrayInputStream byteArrayInputStream;
        block13 : {
            byte[] arrby;
            block12 : {
                Artwork artwork;
                block11 : {
                    Tag tag;
                    block10 : {
                        tag = AudioFileIO.read(new File(mediaTrack.getLocation())).getTag();
                        if (tag != null) break block10;
                        byteArrayInputStream = null;
                    }
                    artwork = tag.getFirstArtwork();
                    if (artwork != null) break block11;
                    byteArrayInputStream = null;
                }
                arrby = artwork.getBinaryData();
                if (arrby != null) break block12;
                byteArrayInputStream = null;
            }
            try {
                ByteArrayInputStream byteArrayInputStream2;
                byteArrayInputStream = byteArrayInputStream2 = new ByteArrayInputStream(arrby);
            }
            catch (Throwable throwable) {
                boolean bl = throwable instanceof Exception;
                byteArrayInputStream = null;
                if (bl) break block13;
                if (throwable instanceof AssertionError) {
                    byteArrayInputStream = null;
                    break block13;
                }
                throw throwable;
            }
        }
        if (byteArrayInputStream == null) {
            I i2 = mediaTrack.getMediaType();
            int n2 = a.a[i2.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        return this.c(mediaTrack.getLocation());
                    }
                    throw new Exception("no art found");
                }
                throw new Exception("no art found");
            }
            throw new Exception("no art found");
        }
        return byteArrayInputStream;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    /*
     * Exception decompiling
     */
    public void b() {
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

    public void cancel() {
    }

    public com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.f;
    }

    public void e(com.bumptech.glide.g g2, d.a<? super InputStream> a2) {
        k.g((Object)g2, "priority");
        k.g(a2, "callback");
        try {
            InputStream inputStream;
            this.h = inputStream = this.f();
            a2.f((Object)inputStream);
            return;
        }
        catch (Exception exception) {
            a2.c(exception);
            return;
        }
    }

    public final InputStream f() throws Exception {
        e e2 = this.g.b();
        if (e2 instanceof MediaTrack) {
            return this.g((MediaTrack)e2);
        }
        if (e2 instanceof Album) {
            return this.h((Album)e2);
        }
        if (e2 instanceof com.smp.musicspeed.k0.i0.e) {
            return com.smp.musicspeed.j0.a.a((com.smp.musicspeed.k0.i0.e)e2);
        }
        throw new Exception("No AudioCover found");
    }

}

