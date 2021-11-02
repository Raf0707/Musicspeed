/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Handler
 *  android.os.Message
 *  e.b.f.b.b$a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 *  java.util.concurrent.TimeUnit
 */
package e.b.f.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import e.b.e;
import e.b.f.b.b;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
final class b
extends e {
    private final Handler b;
    private final boolean c;

    b(Handler handler, boolean bl) {
        this.b = handler;
        this.c = bl;
    }

    @Override
    public e.b a() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    @SuppressLint(value={"NewApi"})
    @Override
    public e.b.g.b c(Runnable runnable, long l2, TimeUnit timeUnit) {
        Objects.requireNonNull((Object)runnable, (String)"run == null");
        Objects.requireNonNull((Object)timeUnit, (String)"unit == null");
        Runnable runnable2 = e.b.k.a.l(runnable);
        b b2 = new b(this.b, runnable2);
        Message message = Message.obtain((Handler)this.b, (Runnable)b2);
        if (this.c) {
            message.setAsynchronous(true);
        }
        this.b.sendMessageDelayed(message, timeUnit.toMillis(l2));
        return b2;
    }

    private static final class b
    implements Runnable,
    e.b.g.b {
        private final Handler f;
        private final Runnable g;
        private volatile boolean h;

        b(Handler handler, Runnable runnable) {
            this.f = handler;
            this.g = runnable;
        }

        @Override
        public void a() {
            this.f.removeCallbacks((Runnable)this);
            this.h = true;
        }

        public void run() {
            try {
                this.g.run();
                return;
            }
            catch (Throwable throwable) {
                e.b.k.a.k(throwable);
                return;
            }
        }
    }

}

