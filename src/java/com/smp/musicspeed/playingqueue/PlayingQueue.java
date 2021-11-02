/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Handler
 *  android.os.Looper
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.dbrecord.PlayingQueueInfo;
import com.smp.musicspeed.playingqueue.a;
import com.smp.musicspeed.playingqueue.a0;
import com.smp.musicspeed.playingqueue.b;
import com.smp.musicspeed.playingqueue.c;
import com.smp.musicspeed.playingqueue.c0;
import com.smp.musicspeed.playingqueue.d;
import com.smp.musicspeed.playingqueue.t;
import com.smp.musicspeed.playingqueue.y;
import com.smp.musicspeed.playingqueue.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlayingQueue {
    private static ExecutorService exec = Executors.newSingleThreadExecutor();
    public static volatile boolean hasLoaded;
    private static final Object loadAccessLock;
    private static final Object saveAccessLock;
    private static volatile PlayingQueue theQueue;
    private volatile List<MediaTrack> currentList = new ArrayList();
    private volatile int currentlyPlaying = -1;
    private volatile int lastRemovedPositionShuffled;
    private volatile int lastRemovedPositionUnshuffled;
    private volatile List<Integer> shuffleMap = new ArrayList();
    private volatile boolean shuffled;

    static {
        loadAccessLock = new Object();
        saveAccessLock = new Object();
    }

    private PlayingQueue() {
    }

    private void checkEmpty() {
        if (this.currentList.size() == 0) {
            this.currentlyPlaying = -1;
        }
    }

    private void doShuffle() {
        this.shuffleMap.clear();
        Iterator iterator = this.currentList.iterator();
        while (iterator.hasNext()) {
            (MediaTrack)iterator.next();
            this.shuffleMap.add((Object)this.shuffleMap.size());
        }
        Collections.shuffle(this.shuffleMap);
        this.currentlyPlaying = this.shuffleMap.indexOf((Object)this.currentlyPlaying);
    }

    public static PlayingQueue getDefault() {
        Class<PlayingQueue> class_ = PlayingQueue.class;
        synchronized (PlayingQueue.class) {
            if (theQueue == null) {
                theQueue = new PlayingQueue();
            }
            PlayingQueue playingQueue = theQueue;
            // ** MonitorExit[var2] (shouldn't be in output)
            return playingQueue;
        }
    }

    private List<MediaTrack> getShuffledList() {
        return com.smp.musicspeed.k0.z.k(this.currentList, this.shuffleMap);
    }

    private static boolean isQueueSane(PlayingQueue playingQueue) {
        if (!playingQueue.shuffled) {
            return true;
        }
        if (playingQueue.currentList.size() != playingQueue.shuffleMap.size()) {
            return false;
        }
        for (int i2 = 0; i2 < playingQueue.shuffleMap.size(); ++i2) {
            if ((Integer)playingQueue.shuffleMap.get(i2) >= 0) {
                if ((Integer)playingQueue.shuffleMap.get(i2) <= playingQueue.currentList.size() - 1) continue;
                return false;
            }
            return false;
        }
        return true;
    }

    static /* synthetic */ void lambda$loadAsync$2(Context context) {
        PlayingQueue.load(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void lambda$saveAsync$3() {
        Object object;
        Object object2 = object = saveAccessLock;
        synchronized (object2) {
            PlayingQueue playingQueue = PlayingQueue.getDefault();
            AppDatabaseKt.getPlayingQueueDao().savePlayingQueue(new PlayingQueueInfo(playingQueue.currentList, playingQueue.shuffleMap, playingQueue.currentlyPlaying));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void lambda$updateMetadataFromMediaStoreAsync$0(List list, List list2) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                if (this.currentList.equals((Object)list)) {
                    this.currentList = list2;
                    org.greenrobot.eventbus.c.d().p((Object)new z());
                }
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void lambda$updateMetadataFromMediaStoreAsync$1(Context context) {
        Object object;
        ArrayList arrayList;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                arrayList = new ArrayList(this.currentList);
            }
        }
        List<MediaTrack> list = t.b(context, (List<MediaTrack>)arrayList);
        if (!list.equals((Object)arrayList)) {
            new Handler(context.getMainLooper()).post((Runnable)new b(this, (List)arrayList, list));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void load(Context context) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                PlayingQueue playingQueue = PlayingQueue.getDefault();
                if (!PlayingQueue.tryOldLoad(context, playingQueue)) {
                    PlayingQueueInfo playingQueueInfo = AppDatabaseKt.getPlayingQueueDao().loadPlayingQueue();
                    playingQueue.currentList = playingQueueInfo.getItems();
                    playingQueue.shuffleMap = playingQueueInfo.getShuffleMap();
                    playingQueue.currentlyPlaying = playingQueueInfo.getCurrentlyPlaying();
                }
                playingQueue.shuffled = com.smp.musicspeed.utils.t.G(context);
                if (!PlayingQueue.isQueueSane(playingQueue)) {
                    playingQueue.clear();
                }
                playingQueue.currentList = t.b(context, playingQueue.currentList);
                org.greenrobot.eventbus.c.d().p((Object)new y());
                org.greenrobot.eventbus.c.d().p((Object)new c0());
                a0 a02 = new a0();
                a02.a = true;
                org.greenrobot.eventbus.c.d().m((Object)a02);
                return;
            }
        }
    }

    public static void loadAsync(Context context) {
        hasLoaded = true;
        exec.execute((Runnable)new c(context));
    }

    private static int loadCurrentlyPlaying(Context context) {
        return com.smp.musicspeed.utils.t.o(context).getInt("preferences_currently_playing_queue", -1);
    }

    /*
     * Exception decompiling
     */
    private static PlayingQueueInfo oldLoad(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl122 : IINC : trying to set 1 previously set to 0
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

    public static void saveAsync() {
        if (!hasLoaded) {
            return;
        }
        exec.execute((Runnable)d.f);
    }

    private static boolean tryOldLoad(Context context, PlayingQueue playingQueue) {
        boolean bl = com.smp.musicspeed.utils.t.o(context).getBoolean("PaperDb Q", false);
        if (!bl) {
            PlayingQueueInfo playingQueueInfo = PlayingQueue.oldLoad(context);
            playingQueue.currentlyPlaying = playingQueueInfo.getCurrentlyPlaying();
            playingQueue.currentList = playingQueueInfo.getItems();
            playingQueue.shuffleMap = playingQueueInfo.getShuffleMap();
        }
        com.smp.musicspeed.utils.t.p(context).putBoolean("PaperDb Q", true).apply();
        return bl ^ true;
    }

    public /* synthetic */ void a(List list, List list2) {
        this.lambda$updateMetadataFromMediaStoreAsync$0(list, list2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void addItemLastRemoved(MediaTrack var1_1) {
        var10_3 = var2_2 = PlayingQueue.loadAccessLock;
        // MONITORENTER : var10_3
        var11_5 = var4_4 = PlayingQueue.saveAccessLock;
        // MONITORENTER : var11_5
        this.currentList.add(this.lastRemovedPositionUnshuffled, (Object)var1_1);
        if (!this.shuffled) ** GOTO lbl14
        var6_6 = 0;
        do {
            if (var6_6 < this.shuffleMap.size()) {
                if ((Integer)this.shuffleMap.get(var6_6) >= this.lastRemovedPositionUnshuffled) {
                    this.shuffleMap.set(var6_6, (Object)(1 + (Integer)this.shuffleMap.get(var6_6)));
                }
            } else {
                this.shuffleMap.add(this.lastRemovedPositionShuffled, (Object)this.lastRemovedPositionUnshuffled);
lbl14: // 2 sources:
                if ((var7_7 = this.currentlyPlaying) >= (var8_8 = this.shuffled != false ? this.lastRemovedPositionShuffled : this.lastRemovedPositionUnshuffled)) {
                    this.currentlyPlaying = 1 + this.currentlyPlaying;
                }
                PlayingQueue.saveAsync();
                // MONITOREXIT : var11_5
                // MONITOREXIT : var10_3
                return;
            }
            ++var6_6;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addItems(Context context, List<MediaTrack> list) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentList.addAll(list);
                if (this.shuffled) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        (MediaTrack)iterator.next();
                        this.shuffleMap.add((Object)this.shuffleMap.size());
                    }
                }
                org.greenrobot.eventbus.c.d().p((Object)new c0());
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addItemsNext(Context context, List<MediaTrack> list) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                int n2 = this.currentlyPlaying;
                int n3 = n2 >= 0 ? 1 + this.currentlyPlaying : 0;
                if (!this.shuffled) {
                    this.currentList.addAll(n3, list);
                } else {
                    int n4 = this.currentlyPlaying >= 0 ? (Integer)this.shuffleMap.get(this.currentlyPlaying) : 0;
                    int n5 = this.currentList.size() > 0 ? n4 + 1 : 0;
                    this.currentList.addAll(n5, list);
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i2 = 0; i2 < this.shuffleMap.size(); ++i2) {
                        if ((Integer)this.shuffleMap.get(i2) < n5) continue;
                        this.shuffleMap.set(i2, (Object)((Integer)this.shuffleMap.get(i2) + list.size()));
                    }
                    for (int i3 = n5; i3 < n5 + list.size(); ++i3) {
                        arrayList.add((Object)i3);
                    }
                    this.shuffleMap.addAll(n3, (Collection)arrayList);
                }
                org.greenrobot.eventbus.c.d().p((Object)new c0());
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    public /* synthetic */ void b(Context context) {
        this.lambda$updateMetadataFromMediaStoreAsync$1(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentList.clear();
                this.shuffleMap.clear();
                this.checkEmpty();
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearAllButPlaying() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                if (this.currentlyPlaying < 0) {
                    return;
                }
                this.currentList = t.a(this.currentList, this.currentlyPlaying);
                this.shuffleMap = t.a(this.shuffleMap, this.currentlyPlaying);
                this.currentlyPlaying = 0;
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<MediaTrack> getCurrentList() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            if (this.shuffled) return this.getShuffledList();
            return this.currentList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getCurrentlyPlaying() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            return this.currentlyPlaying;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaTrack getItemAt(int n2) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            if (n2 >= 0 && n2 <= -1 + this.currentList.size()) {
                if (this.shuffled) return (MediaTrack)this.currentList.get(((Integer)this.shuffleMap.get(n2)).intValue());
                return (MediaTrack)this.currentList.get(n2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getLength() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            return this.currentList.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaTrack goToTrack(int n2) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentlyPlaying = n2;
                PlayingQueue.saveAsync();
                if (this.shuffled) return (MediaTrack)this.currentList.get(((Integer)this.shuffleMap.get(n2)).intValue());
                return (MediaTrack)this.currentList.get(n2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void move(int n2, int n3) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                if (this.getCurrentlyPlaying() == n2) {
                    this.currentlyPlaying = n3;
                } else if (n2 > this.currentlyPlaying && n3 <= this.currentlyPlaying) {
                    this.currentlyPlaying = 1 + this.currentlyPlaying;
                } else if (n2 < this.currentlyPlaying && n3 >= this.currentlyPlaying) {
                    this.currentlyPlaying = -1 + this.currentlyPlaying;
                }
                if (!this.shuffled) {
                    MediaTrack mediaTrack = (MediaTrack)this.currentList.remove(n2);
                    this.currentList.add(n3, (Object)mediaTrack);
                } else {
                    Integer n4 = (Integer)this.shuffleMap.remove(n2);
                    this.shuffleMap.add(n3, (Object)n4);
                }
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void newQueueFromMediaTrackList(Context context, List<MediaTrack> list, int n2) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentList.clear();
                this.shuffleMap.clear();
                this.currentList.addAll(list);
                this.currentlyPlaying = n2;
                if (this.shuffled) {
                    this.doShuffle();
                }
                this.setShuffle(com.smp.musicspeed.utils.t.G(context));
                this.checkEmpty();
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaTrack nextTrack() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentlyPlaying = 1 + this.currentlyPlaying;
                if (this.currentlyPlaying == this.getLength()) {
                    this.currentlyPlaying = 0;
                }
                PlayingQueue.saveAsync();
                if (!this.shuffled) {
                    return (MediaTrack)this.currentList.get(this.currentlyPlaying);
                }
                int n2 = (Integer)this.shuffleMap.get(this.currentlyPlaying);
                return (MediaTrack)this.currentList.get(n2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaTrack previousTrack() {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                this.currentlyPlaying = -1 + this.currentlyPlaying;
                if (this.currentlyPlaying < 0) {
                    this.currentlyPlaying = -1 + this.getLength();
                }
                PlayingQueue.saveAsync();
                if (!this.shuffled) {
                    return (MediaTrack)this.currentList.get(this.currentlyPlaying);
                }
                int n2 = (Integer)this.shuffleMap.get(this.currentlyPlaying);
                return (MediaTrack)this.currentList.get(n2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeItemAt(int n2) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                if (!this.shuffled) {
                    this.currentList.remove(n2);
                    this.lastRemovedPositionUnshuffled = n2;
                } else {
                    int n3;
                    this.lastRemovedPositionUnshuffled = n3 = ((Integer)this.shuffleMap.get(n2)).intValue();
                    this.lastRemovedPositionShuffled = n2;
                    this.currentList.remove(n3);
                    this.shuffleMap.remove(n2);
                    for (int i2 = 0; i2 < this.shuffleMap.size(); ++i2) {
                        if ((Integer)this.shuffleMap.get(i2) <= n3) continue;
                        this.shuffleMap.set(i2, (Object)(-1 + (Integer)this.shuffleMap.get(i2)));
                    }
                }
                if (n2 < this.currentlyPlaying) {
                    this.currentlyPlaying = -1 + this.currentlyPlaying;
                }
                this.checkEmpty();
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setShuffle(boolean bl) {
        Object object;
        Object object2 = object = loadAccessLock;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = saveAccessLock;
            synchronized (object4) {
                if (bl != this.shuffled) {
                    if (this.currentlyPlaying != -1 && this.currentList.size() != 0) {
                        if (bl) {
                            this.doShuffle();
                        } else if (this.shuffleMap.size() > 0) {
                            this.currentlyPlaying = (Integer)this.shuffleMap.get(this.currentlyPlaying);
                        }
                        this.shuffled = bl;
                    } else {
                        return;
                    }
                }
                org.greenrobot.eventbus.c.d().p((Object)new c0());
                PlayingQueue.saveAsync();
                return;
            }
        }
    }

    public void updateMetadataFromMediaStoreAsync(Context context) {
        exec.submit((Runnable)new a(this, context));
    }
}

