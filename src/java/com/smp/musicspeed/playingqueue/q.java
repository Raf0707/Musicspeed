/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.playingqueue;

import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.h;
import com.smp.musicspeed.playingqueue.w;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.c;

public class q
extends h {
    private List<a> a;
    private a b;
    private int c = -1;

    public q() {
        this.f();
    }

    @Override
    public int a() {
        return this.a.size();
    }

    @Override
    public h.a b(int n2) {
        if (n2 >= 0 && n2 < this.a()) {
            return (h.a)this.a.get(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index = ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public void c(int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        a a2 = (a)this.a.remove(n2);
        this.a.add(n3, (Object)a2);
        this.c = -1;
        PlayingQueue.getDefault().move(n2, n3);
        c.d().m((Object)new w());
    }

    @Override
    public void d(int n2) {
        this.b = (a)this.a.remove(n2);
        this.c = n2;
        if (PlayingQueue.getDefault().getLength() > 0) {
            PlayingQueue.getDefault().removeItemAt(n2);
        }
    }

    @Override
    public int e() {
        if (this.b != null) {
            int n2 = this.c;
            int n3 = n2 >= 0 && n2 < this.a.size() ? this.c : this.a.size();
            this.a.add(n3, (Object)this.b);
            PlayingQueue.getDefault().addItemLastRemoved(this.b.c());
            this.b = null;
            this.c = -1;
            return n3;
        }
        return -1;
    }

    public void f() {
        this.a = new LinkedList();
        for (int i2 = 0; i2 < PlayingQueue.getDefault().getLength(); ++i2) {
            long l2 = this.a.size();
            MediaTrack mediaTrack = PlayingQueue.getDefault().getItemAt(i2);
            List<a> list = this.a;
            a a2 = new a(l2, 0, mediaTrack, 524416);
            list.add((Object)a2);
        }
    }

    public static final class a
    extends h.a {
        private final long a;
        private final MediaTrack b;
        private final int c;
        private boolean d;

        a(long l2, int n2, MediaTrack mediaTrack, int n3) {
            this.a = l2;
            this.c = n2;
            this.b = mediaTrack;
        }

        @Override
        public long a() {
            return this.a;
        }

        @Override
        public int b() {
            return this.c;
        }

        public MediaTrack c() {
            return this.b;
        }

        public boolean d() {
            return this.d;
        }

        public String toString() {
            return this.b.toString();
        }
    }

}

