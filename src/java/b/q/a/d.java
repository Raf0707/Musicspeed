/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaFormat
 *  b.q.a.d$a
 *  b.q.a.d$b
 *  b.q.a.v
 *  b.q.a.v$f
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.q.a;

import android.content.Context;
import android.media.MediaFormat;
import b.q.a.d;
import b.q.a.v;
import b.q.a.w;

/*
 * Exception performing whole class analysis.
 */
class d
extends v.f {
    private final Context a;
    private a b;

    d(Context context) {
        this.a = context;
    }

    public w a(MediaFormat mediaFormat) {
        if ("text/cea-608".equals((Object)mediaFormat.getString("mime"))) {
            if (this.b == null) {
                this.b = new /* Unavailable Anonymous Inner Class!! */;
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No matching format: ");
        stringBuilder.append(mediaFormat.toString());
        throw new RuntimeException(stringBuilder.toString());
    }

    public boolean b(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("mime")) {
            return "text/cea-608".equals((Object)mediaFormat.getString("mime"));
        }
        return false;
    }
}

