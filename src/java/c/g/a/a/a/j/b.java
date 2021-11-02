/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package c.g.a.a.a.j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import c.g.a.a.a.e.g;
import c.g.a.a.a.j.c;
import c.g.a.a.a.m.b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static WindowManager a;
    private static String[] b;
    static float c;

    static {
        b = new String[]{"x", "y", "width", "height"};
        c = Resources.getSystem().getDisplayMetrics().density;
    }

    static float a(int n2) {
        return (float)n2 / c;
    }

    public static JSONObject b(int n2, int n3, int n4, int n5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double)b.a(n2));
            jSONObject.put("y", (double)b.a(n3));
            jSONObject.put("width", (double)b.a(n4));
            jSONObject.put("height", (double)b.a(n5));
            return jSONObject;
        }
        catch (JSONException jSONException) {
            c.b("Error with creating viewStateObject", (Exception)((Object)jSONException));
            return jSONObject;
        }
    }

    public static void c(Context context) {
        if (context != null) {
            c = context.getResources().getDisplayMetrics().density;
            a = (WindowManager)context.getSystemService("window");
        }
    }

    public static void d(JSONObject jSONObject) {
        a a2 = b.j(jSONObject);
        try {
            jSONObject.put("width", (double)a2.a);
            jSONObject.put("height", (double)a2.b);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public static void e(JSONObject jSONObject, b.a a2) {
        c.g.a.a.a.f.c c2 = a2.a();
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = a2.c().iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)((String)iterator.next()));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", (Object)jSONArray);
            jSONObject.put("friendlyObstructionClass", (Object)c2.b());
            jSONObject.put("friendlyObstructionPurpose", (Object)c2.c());
            jSONObject.put("friendlyObstructionReason", (Object)c2.d());
            return;
        }
        catch (JSONException jSONException) {
            c.b("Error with setting friendly obstruction", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void f(JSONObject jSONObject, String string) {
        try {
            jSONObject.put("adSessionId", (Object)string);
            return;
        }
        catch (JSONException jSONException) {
            c.b("Error with setting ad session id", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void g(JSONObject jSONObject, String string, Object object) {
        try {
            jSONObject.put(string, object);
            return;
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSONException during JSONObject.put for name [");
            stringBuilder.append(string);
            stringBuilder.append("]");
            c.b(stringBuilder.toString(), (Exception)((Object)jSONException));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                jSONObject.put("childViews", (Object)jSONArray);
            }
            jSONArray.put((Object)jSONObject2);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    private static boolean i(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray != null) {
            if (jSONArray2 == null) {
                return false;
            }
            return jSONArray.length() == jSONArray2.length();
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static a j(JSONObject jSONObject) {
        float f2;
        int n2 = Build.VERSION.SDK_INT;
        float f3 = 0.0f;
        if (n2 >= 17) {
            if (a != null) {
                Point point = new Point(0, 0);
                a.getDefaultDisplay().getRealSize(point);
                f3 = b.a(point.x);
                f2 = b.a(point.y);
                return new a(f3, f2);
            }
        } else {
            JSONArray jSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArray != null) {
                int n3 = jSONArray.length();
                float f4 = 0.0f;
                int n4 = 0;
                do {
                    if (n4 >= n3) {
                        f2 = f4;
                        return new a(f3, f2);
                    }
                    JSONObject jSONObject2 = jSONArray.optJSONObject(n4);
                    if (jSONObject2 != null) {
                        double d2 = jSONObject2.optDouble("x");
                        double d3 = jSONObject2.optDouble("y");
                        double d4 = jSONObject2.optDouble("width");
                        double d5 = jSONObject2.optDouble("height");
                        f3 = Math.max((float)f3, (float)((float)(d2 + d4)));
                        f4 = Math.max((float)f4, (float)((float)(d3 + d5)));
                    }
                    ++n4;
                } while (true);
            }
        }
        f2 = 0.0f;
        return new a(f3, f2);
    }

    public static void k(JSONObject jSONObject, String string) {
        try {
            jSONObject.put("notVisibleReason", (Object)string);
            return;
        }
        catch (JSONException jSONException) {
            c.b("Error with setting not visible reason", (Exception)((Object)jSONException));
            return;
        }
    }

    public static boolean l(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null) {
            if (jSONObject2 == null) {
                return false;
            }
            return b.m(jSONObject, jSONObject2) && b.n(jSONObject, jSONObject2) && b.o(jSONObject, jSONObject2) && b.p(jSONObject, jSONObject2);
        }
        return false;
    }

    private static boolean m(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String string : b) {
            if (jSONObject.optDouble(string) == jSONObject2.optDouble(string)) continue;
            return false;
        }
        return true;
    }

    private static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals((Object)jSONObject2.optString("adSessionId", ""));
    }

    private static boolean o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray jSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (!b.i(jSONArray, jSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (jSONArray.optString(i2, "").equals((Object)jSONArray2.optString(i2, ""))) continue;
            return false;
        }
        return true;
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = jSONObject.optJSONArray("childViews");
        JSONArray jSONArray2 = jSONObject2.optJSONArray("childViews");
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (!b.i(jSONArray, jSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (b.l(jSONArray.optJSONObject(i2), jSONArray2.optJSONObject(i2))) continue;
            return false;
        }
        return true;
    }

    private static class a {
        final float a;
        final float b;

        a(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }
    }

}

