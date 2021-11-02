/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.util.TypedValue
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.i.h.d;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import b.i.h.d.c;
import b.i.i.d;
import b.i.p.h;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class f {
    public static int a(Resources resources, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(n2, theme);
        }
        return resources.getColor(n2);
    }

    public static Drawable b(Resources resources, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(n2, theme);
        }
        return resources.getDrawable(n2);
    }

    public static Typeface c(Context context, int n2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return f.f(context, n2, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface d(Context context, int n2, TypedValue typedValue, int n3, a a2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return f.f(context, n2, typedValue, n3, a2, null, true, false);
    }

    public static void e(Context context, int n2, a a2, Handler handler) throws Resources.NotFoundException {
        h.d(a2);
        if (context.isRestricted()) {
            a2.a(-4, handler);
            return;
        }
        f.f(context, n2, new TypedValue(), 0, a2, handler, false, false);
    }

    private static Typeface f(Context context, int n2, TypedValue typedValue, int n3, a a2, Handler handler, boolean bl, boolean bl2) {
        Resources resources = context.getResources();
        resources.getValue(n2, typedValue, true);
        Typeface typeface = f.g(context, resources, typedValue, n2, n3, a2, handler, bl, bl2);
        if (typeface == null && a2 == null) {
            if (bl2) {
                return typeface;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Font resource ID #0x");
            stringBuilder.append(Integer.toHexString((int)n2));
            stringBuilder.append(" could not be retrieved.");
            throw new Resources.NotFoundException(stringBuilder.toString());
        }
        return typeface;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Typeface g(Context context, Resources resources, TypedValue typedValue, int n2, int n3, a a2, Handler handler, boolean bl, boolean bl2) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resource \"");
            stringBuilder.append(resources.getResourceName(n2));
            stringBuilder.append("\" (");
            stringBuilder.append(Integer.toHexString((int)n2));
            stringBuilder.append(") is not a Font: ");
            stringBuilder.append((Object)typedValue);
            throw new Resources.NotFoundException(stringBuilder.toString());
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (a2 == null) return null;
            {
                a2.a(-3, handler);
            }
            return null;
        }
        Typeface typeface = d.f(resources, n2, n3);
        if (typeface != null) {
            if (a2 == null) return typeface;
            {
                a2.b(typeface, handler);
            }
            return typeface;
        }
        if (bl2) {
            return null;
        }
        try {
            if (string.toLowerCase().endsWith(".xml")) {
                c.a a3 = c.b((XmlPullParser)resources.getXml(n2), resources);
                if (a3 != null) {
                    return d.c(context, a3, resources, n2, n3, a2, handler, bl);
                }
                Log.e((String)"ResourcesCompat", (String)"Failed to find font-family tag");
                if (a2 == null) return null;
                {
                    a2.a(-3, handler);
                    return null;
                }
            }
            Typeface typeface2 = d.d(context, resources, n2, string, n3);
            if (a2 == null) return typeface2;
            {
                if (typeface2 != null) {
                    a2.b(typeface2, handler);
                    return typeface2;
                }
                a2.a(-3, handler);
            }
            return typeface2;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read xml resource ");
            stringBuilder.append(string);
            Log.e((String)"ResourcesCompat", (String)stringBuilder.toString(), (Throwable)iOException);
        }
        catch (XmlPullParserException xmlPullParserException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse xml resource ");
            stringBuilder.append(string);
            Log.e((String)"ResourcesCompat", (String)stringBuilder.toString(), (Throwable)xmlPullParserException);
        }
        if (a2 == null) return null;
        {
            a2.a(-3, handler);
        }
        return null;
    }

    public static abstract class b.i.h.d.f$a {
        public static Handler c(Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void a(final int n2, Handler handler) {
            b.i.h.d.f$a.c(handler).post(new Runnable(){

                public void run() {
                    a.this.d(n2);
                }
            });
        }

        public final void b(final Typeface typeface, Handler handler) {
            b.i.h.d.f$a.c(handler).post(new Runnable(){

                public void run() {
                    a.this.e(typeface);
                }
            });
        }

        public abstract void d(int var1);

        public abstract void e(Typeface var1);

    }

    public static final class b.i.h.d.f$b {
        public static void a(Resources.Theme theme) {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 29) {
                b.a(theme);
                return;
            }
            if (n2 >= 23) {
                a.a(theme);
            }
        }

        static class a {
            private static final Object a = new Object();
            private static Method b;
            private static boolean c;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            static void a(Resources.Theme theme) {
                Object object;
                Object object2 = object = a;
                synchronized (object2) {
                    block9 : {
                        Method method;
                        boolean bl = c;
                        if (!bl) {
                            try {
                                Method method2;
                                b = method2 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                method2.setAccessible(true);
                            }
                            catch (NoSuchMethodException noSuchMethodException) {
                                Log.i((String)"ResourcesCompat", (String)"Failed to retrieve rebase() method", (Throwable)noSuchMethodException);
                            }
                            c = true;
                        }
                        if ((method = b) != null) {
                            void var5_9;
                            try {
                                method.invoke((Object)theme, new Object[0]);
                                break block9;
                            }
                            catch (InvocationTargetException invocationTargetException) {
                            }
                            catch (IllegalAccessException illegalAccessException) {
                                // empty catch block
                            }
                            Log.i((String)"ResourcesCompat", (String)"Failed to invoke rebase() method via reflection", (Throwable)var5_9);
                            b = null;
                        }
                    }
                    return;
                }
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

    }

}

