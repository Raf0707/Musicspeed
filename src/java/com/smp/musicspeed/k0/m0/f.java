/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.media.MediaScannerConnection
 *  android.net.Uri
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Albums
 *  android.provider.MediaStore$Audio$Artists
 *  android.provider.MediaStore$Audio$Artists$Albums
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Audio$Playlists
 *  android.provider.MediaStore$Audio$Playlists$Members
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  android.widget.Toast
 *  com.smp.musicspeed.dbrecord.InternalPlaylist
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.i0.e
 *  com.smp.musicspeed.k0.m0.f$b
 *  com.smp.musicspeed.k0.m0.f$c
 *  com.smp.musicspeed.k0.m0.f$d
 *  com.smp.musicspeed.k0.m0.f$e
 *  com.smp.musicspeed.k0.m0.f$f
 *  com.smp.musicspeed.k0.m0.g$a
 *  com.smp.musicspeed.library.album.Album
 *  com.smp.musicspeed.library.playlists.Playlist
 *  f.g0.k
 *  f.u.g0
 *  f.u.l
 *  f.v.a
 *  f.y.b
 *  f.z.c.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.Closeable
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package com.smp.musicspeed.k0.m0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.InternalPlaylist;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.InternalPlaylistItem;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.k0.i0.e;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.utils.FFMpegMetadataRetriever;
import com.smp.musicspeed.utils.t;
import f.l;
import f.p;
import f.u.g0;
import f.z.d.k;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Exception performing whole class analysis.
 */
public final class f {
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;
    private static final String[] f;
    private static final String[] g;
    private static final String[] h;
    private static final String[] i;

    static {
        a = new String[]{"title", "_id", "artist", "album", "duration", "_data", "year", "date_added", "album_id", "artist_id", "track", "date_modified", "is_alarm", "is_ringtone", "is_podcast", "is_notification", "is_music"};
        b = new String[]{"title", "_id", "artist", "album", "duration", "_data", "year", "date_added", "album_id", "artist_id", "track", "date_modified", "is_alarm", "is_ringtone", "is_podcast", "is_notification", "is_music", "owner_package_name", "mime_type"};
        c = new String[]{"_id", "artist", "number_of_albums", "number_of_tracks"};
        d = new String[]{"album_id", "album", "artist_id", "artist", "maxyear", "album_art"};
        e = new String[]{"_id", "album", "artist_id", "artist", "maxyear", "album_art"};
        f = new String[]{"title", "_id", "artist", "album", "duration", "_data", "date_modified", "is_alarm", "is_ringtone", "is_podcast", "is_notification", "is_music"};
        g = new String[]{"title", "audio_id", "_id", "artist", "album", "duration", "_data", "year", "date_added", "date_modified", "album_id", "artist_id", "track", "is_alarm", "is_ringtone", "is_podcast", "is_notification", "is_music"};
        h = new String[]{"title", "_id", "artist", "album", "duration", "_data", "date_modified"};
        i = new String[]{"_id", "name"};
    }

    public static final String[] A() {
        return a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static final Map<File, MediaTrack> B(Context var0, List<? extends File> var1_1) {
        block24 : {
            block23 : {
                block25 : {
                    k.g((Object)var0, (String)"context");
                    if (var1_1 != null) {
                        var2_2 = u.i(var1_1);
                        k.f((Object)var2_2, (String)"toPathArray(files)");
                        var3_3 = var1_1.size();
                        var4_4 = 0;
                        var5_5 = 1;
                        if (var5_5 > var3_3 || var3_3 > 998) {
                            var5_5 = 0;
                        }
                        if (var5_5 != 0) {
                            var6_6 = new StringBuilder();
                            var6_6.append("_data IN (");
                            var6_6.append((Object)u.f(var1_1.size()));
                            var6_6.append(')');
                            var10_7 = var6_6.toString();
                        } else {
                            var10_7 = null;
                        }
                        var11_8 = var0.getContentResolver();
                        var12_9 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        var13_10 = f.a;
                        var14_11 /* !! */  = var10_7 != null ? var2_2 : null;
                        var15_12 = var11_8.query(var12_9, var13_10, var10_7, var14_11 /* !! */ , "title_key");
                        if (var15_12 == null) {
                            var16_13 = new ArrayList(var2_2.length);
                            var17_14 = var2_2.length;
                            while (var4_4 < var17_14) {
                                var16_13.add(p.a(new File(var2_2[var4_4]), null));
                                ++var4_4;
                            }
                            return g0.n((Iterable)var16_13);
                        }
                        var19_15 = var0.getContentResolver();
                        var23_19 = var19_15.query(var20_16 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI, var21_17 = f.h, var10_7, var22_18 /* !! */  = var10_7 != null ? var2_2 : null, "title");
                        if (var23_19 == null) {
                            var24_20 = new ArrayList(var2_2.length);
                            var25_21 = var2_2.length;
                            while (var4_4 < var25_21) {
                                var24_20.add(p.a(new File(var2_2[var4_4]), null));
                                ++var4_4;
                            }
                            return g0.n((Iterable)var24_20);
                        }
                        try {
                            var31_22 = MediaTrack.Companion;
                            var32_23 = var0.getResources();
                            k.f((Object)var32_23, (String)"context.resources");
                            var33_24 = MediaTrack.Companion.buildMediaTrackList$default(var31_22, var0, var15_12, var23_19, var32_23, null, 16, null);
                            var34_25 = new ArrayList();
                            var35_26 = var2_2.length;
lbl48: // 2 sources:
                            do {
                                if (var4_4 < var35_26) {
                                    var36_27 = var2_2[var4_4];
                                    if (var36_27 == null) break block23;
                                    var37_28 = new File(var36_27);
                                    for (Object var39_30 : var33_24) {
                                        if (!k.c((Object)((MediaTrack)var39_30).getLocation(), (Object)var36_27)) continue;
lbl55: // 2 sources:
                                        do {
                                            var40_31 = (MediaTrack)var39_30;
                                            if (var40_31 == null) {
                                                var40_31 = f.F(var0, var36_27);
                                            }
                                            var41_32 = p.a(var37_28, var40_31);
lbl60: // 2 sources:
                                            while (var41_32 != null) {
                                                var34_25.add(var41_32);
                                                break block24;
                                            }
                                            break block24;
                                            break;
                                        } while (true);
                                    }
                                    break block25;
                                }
                                var43_33 = g0.n((Iterable)var34_25);
                                break;
                            } while (true);
                        }
                        catch (Throwable var27_34) {
                            try {
                                throw var27_34;
                            }
                            catch (Throwable var28_35) {
                                try {
                                    f.y.b.a((Closeable)var23_19, (Throwable)var27_34);
                                    throw var28_35;
                                }
                                catch (Throwable var29_36) {
                                    try {
                                        throw var29_36;
                                    }
                                    catch (Throwable var30_37) {
                                        f.y.b.a((Closeable)var15_12, (Throwable)var29_36);
                                        throw var30_37;
                                    }
                                }
                            }
                        }
                        {
                            f.y.b.a((Closeable)var23_19, null);
                            f.y.b.a((Closeable)var15_12, null);
                            return var43_33;
                        }
                    }
                    return g0.g();
                }
                var39_30 = null;
                ** while (true)
            }
            var41_32 = null;
            ** GOTO lbl60
        }
        ++var4_4;
        ** while (true)
    }

    /*
     * Exception decompiling
     */
    public static final List<MediaTrack> C(Context var0, String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public static final boolean D(Context context, long l2, int n2, int n3) {
        k.g((Object)context, (String)"context");
        return MediaStore.Audio.Playlists.Members.moveItem((ContentResolver)context.getContentResolver(), (long)l2, (int)n2, (int)n3);
    }

    public static final boolean E(long l2, int n2, int n3) {
        return AppDatabaseKt.getInternalPlaylistDao().moveItem(l2, n2, n3) > 0;
    }

    public static final MediaTrack F(Context context, String string2) {
        k.g((Object)context, (String)"context");
        k.g((Object)string2, (String)"path");
        String[] arrstring = FFMpegMetadataRetriever.retrieveMetadata(string2);
        if (arrstring != null) {
            MediaScannerConnection.scanFile((Context)context, (String[])new String[]{string2}, null, null);
            String string3 = arrstring[0];
            String string4 = arrstring[1];
            String string5 = !k.c((Object)arrstring[2], (Object)"") ? string3 : context.getString(2131821378);
            if (k.c((Object)string3, (Object)"")) {
                string3 = context.getString(2131821379);
            }
            String string6 = string3;
            if (k.c((Object)string4, (Object)"")) {
                string4 = new File(string2).getName();
            }
            String string7 = string4;
            String string8 = u.h(new File(string2));
            I i2 = I.i;
            long l2 = System.currentTimeMillis();
            k.f((Object)string7, (String)"trackName");
            k.f((Object)string6, (String)"artistName");
            k.f((Object)string8, (String)"safeGetCanonicalPath(File(path))");
            k.f((Object)string5, (String)"albumName");
            MediaTrack mediaTrack = new MediaTrack(string7, string6, 0L, string8, 0L, true, i2, 0L, string5, 0L, 0, 0, l2, 0L, 11924, null);
            return mediaTrack;
        }
        return null;
    }

    public static final void G(Context context, List<MediaTrack> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"songs");
        Uri uri = MediaStore.Audio.Playlists.Members.getContentUri((String)"external", (long)((com.smp.musicspeed.k0.m0.g)com.smp.musicspeed.k0.m0.g.a.a(context)).e());
        int n2 = list.size();
        String[] arrstring = new String[n2];
        int n3 = n2 - 1;
        if (n3 >= 0) {
            int n4 = 0;
            do {
                int n5 = n4 + 1;
                arrstring[n4] = String.valueOf((long)((MediaTrack)list.get(n4)).getIdInPlaylist());
                if (n5 > n3) break;
                n4 = n5;
            } while (true);
        }
        String string2 = "_id in (";
        for (int i2 = 0; i2 < n2; ++i2) {
            arrstring[i2];
            string2 = k.m((String)string2, (Object)"?, ");
        }
        String string3 = string2.substring(0, -2 + string2.length());
        k.f((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String string4 = k.m((String)string3, (Object)")");
        try {
            context.getContentResolver().delete(uri, string4, arrstring);
            com.smp.musicspeed.k0.m0.h.a(context);
        }
        catch (SecurityException securityException) {}
    }

    public static final void H(Context context, List<MediaTrack> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"tracks");
        long l2 = ((com.smp.musicspeed.k0.m0.g)com.smp.musicspeed.k0.m0.g.a.a(context)).e();
        AppDatabaseKt.getInternalPlaylistDao().removeTracksFromPlaylist(l2, list);
        com.smp.musicspeed.k0.m0.h.a(context);
    }

    private static final List<Playlist> I(List<? extends Playlist> list, String string2) {
        if (k.c((Object)string2, (Object)"name")) {
            return f.u.l.J(list, }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    