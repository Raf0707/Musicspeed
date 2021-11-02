/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Xml
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package d.a.a;

import android.util.Xml;
import d.a.a.a;
import d.a.a.g.l;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class d {
    public static Notices a(InputStream inputStream) throws Exception {
        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlPullParser.setInput(inputStream, null);
            xmlPullParser.nextTag();
            Notices notices = d.b(xmlPullParser);
            return notices;
        }
        finally {
            inputStream.close();
        }
    }

    private static Notices b(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        Notices notices = new Notices();
        xmlPullParser.require(2, null, "notices");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) continue;
            if ("notice".equals((Object)xmlPullParser.getName())) {
                notices.l(d.f(xmlPullParser));
                continue;
            }
            d.j(xmlPullParser);
        }
        return notices;
    }

    private static String c(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return d.g(xmlPullParser, "copyright");
    }

    private static l d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return a.a(d.g(xmlPullParser, "license"));
    }

    private static String e(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return d.g(xmlPullParser, "name");
    }

    private static Notice f(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String string2 = null;
        xmlPullParser.require(2, null, "notice");
        String string3 = null;
        String string4 = null;
        l l2 = null;
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) continue;
            String string5 = xmlPullParser.getName();
            if ("name".equals((Object)string5)) {
                string2 = d.e(xmlPullParser);
                continue;
            }
            if ("url".equals((Object)string5)) {
                string3 = d.i(xmlPullParser);
                continue;
            }
            if ("copyright".equals((Object)string5)) {
                string4 = d.c(xmlPullParser);
                continue;
            }
            if ("license".equals((Object)string5)) {
                l2 = d.d(xmlPullParser);
                continue;
            }
            d.j(xmlPullParser);
        }
        return new Notice(string2, string3, string4, l2);
    }

    private static String g(XmlPullParser xmlPullParser, String string2) throws IOException, XmlPullParserException {
        xmlPullParser.require(2, null, string2);
        String string3 = d.h(xmlPullParser);
        xmlPullParser.require(3, null, string2);
        return string3;
    }

    private static String h(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (xmlPullParser.next() == 4) {
            String string2 = xmlPullParser.getText();
            xmlPullParser.nextTag();
            return string2;
        }
        return "";
    }

    private static String i(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return d.g(xmlPullParser, "url");
    }

    private static void j(XmlPullParser xmlPullParser) {
    }
}

