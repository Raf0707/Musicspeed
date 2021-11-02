/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.michaelflisar.gdprdialog.m;

import android.content.Context;
import android.text.TextUtils;
import com.michaelflisar.gdprdialog.GDPRSubNetwork;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private com.michaelflisar.gdprdialog.h a = com.michaelflisar.gdprdialog.h.f;
    private List<GDPRSubNetwork> b = new ArrayList();
    private boolean c = false;

    private JSONObject e(Context context, ArrayList<String> arrayList, int n2, int n3) throws IOException, JSONException {
        String string;
        String string2 = TextUtils.join((CharSequence)",", arrayList);
        URL uRL = new URL(context.getString(l.q, new Object[]{string2}));
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setReadTimeout(n2);
        httpURLConnection.setConnectTimeout(n3);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(uRL.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while ((string = bufferedReader.readLine()) != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        bufferedReader.close();
        return new JSONObject(stringBuilder.toString());
    }

    private void g() {
        this.a = com.michaelflisar.gdprdialog.h.f;
        this.b.clear();
        this.c = false;
    }

    public com.michaelflisar.gdprdialog.h a() {
        return this.a;
    }

    public List<GDPRSubNetwork> b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void d(Context context, ArrayList<String> arrayList, int n2, int n3) {
        int n4;
        String string;
        String string2;
        JSONArray jSONArray;
        this.g();
        JSONObject jSONObject = this.e(context, arrayList, n2, n3);
        if (jSONObject == null) return;
        try {
            String string3 = context.getString(l.t);
            String string4 = context.getString(l.r);
            com.michaelflisar.gdprdialog.h h2 = jSONObject.getBoolean(string3) ? com.michaelflisar.gdprdialog.h.g : com.michaelflisar.gdprdialog.h.h;
            this.a = h2;
            if (!jSONObject.has(string4)) return;
            string2 = context.getString(l.s);
            string = context.getString(l.u);
            jSONArray = jSONObject.getJSONArray(string4);
            n4 = 0;
        }
        catch (Exception exception) {
            this.g();
            this.c = true;
            c.e().f().b("GDPRPreperationData::load", "Could not load location from network", exception);
        }
        do {
            if (n4 >= jSONArray.length()) return;
            this.b.add((Object)new GDPRSubNetwork(jSONArray.getJSONObject(n4).getString(string2), jSONArray.getJSONObject(n4).getString(string)));
            ++n4;
        } while (true);
    }

    public String f() {
        Object[] arrobject = new Object[]{this.a.name(), this.b.size(), this.c};
        return String.format((String)"{ Location: %s | SubNetworks: %d | Error: %b }", (Object[])arrobject);
    }

    public h h(Boolean bl) {
        this.g();
        if (bl != null) {
            com.michaelflisar.gdprdialog.h h2 = bl != false ? com.michaelflisar.gdprdialog.h.g : com.michaelflisar.gdprdialog.h.h;
            this.a = h2;
            return this;
        }
        this.c = true;
        return this;
    }

    public h i() {
        this.g();
        this.a = com.michaelflisar.gdprdialog.h.f;
        return this;
    }

    public void j(com.michaelflisar.gdprdialog.h h2) {
        this.a = h2;
    }
}

