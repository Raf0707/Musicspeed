/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.List
 */
package org.jaudiotagger.tag.id3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ID3v23PreferredFrameOrderComparator
implements Comparator<String> {
    private static ID3v23PreferredFrameOrderComparator comparator;
    private static List frameIdsInPreferredOrder;

    static {
        ArrayList arrayList = new ArrayList();
        frameIdsInPreferredOrder = arrayList;
        arrayList.add((Object)"UFID");
        frameIdsInPreferredOrder.add((Object)"TIT2");
        frameIdsInPreferredOrder.add((Object)"TPE1");
        frameIdsInPreferredOrder.add((Object)"TALB");
        frameIdsInPreferredOrder.add((Object)"TORY");
        frameIdsInPreferredOrder.add((Object)"TCON");
        frameIdsInPreferredOrder.add((Object)"TCOM");
        frameIdsInPreferredOrder.add((Object)"TPE3");
        frameIdsInPreferredOrder.add((Object)"TIT1");
        frameIdsInPreferredOrder.add((Object)"TRCK");
        frameIdsInPreferredOrder.add((Object)"TYER");
        frameIdsInPreferredOrder.add((Object)"TDAT");
        frameIdsInPreferredOrder.add((Object)"TIME");
        frameIdsInPreferredOrder.add((Object)"TBPM");
        frameIdsInPreferredOrder.add((Object)"TSRC");
        frameIdsInPreferredOrder.add((Object)"TORY");
        frameIdsInPreferredOrder.add((Object)"TPE2");
        frameIdsInPreferredOrder.add((Object)"TIT3");
        frameIdsInPreferredOrder.add((Object)"USLT");
        frameIdsInPreferredOrder.add((Object)"TXXX");
        frameIdsInPreferredOrder.add((Object)"WXXX");
        frameIdsInPreferredOrder.add((Object)"WOAR");
        frameIdsInPreferredOrder.add((Object)"WCOM");
        frameIdsInPreferredOrder.add((Object)"WCOP");
        frameIdsInPreferredOrder.add((Object)"WOAF");
        frameIdsInPreferredOrder.add((Object)"WORS");
        frameIdsInPreferredOrder.add((Object)"WPAY");
        frameIdsInPreferredOrder.add((Object)"WPUB");
        frameIdsInPreferredOrder.add((Object)"WCOM");
        frameIdsInPreferredOrder.add((Object)"TEXT");
        frameIdsInPreferredOrder.add((Object)"TMED");
        frameIdsInPreferredOrder.add((Object)"IPLS");
        frameIdsInPreferredOrder.add((Object)"TLAN");
        frameIdsInPreferredOrder.add((Object)"TSOT");
        frameIdsInPreferredOrder.add((Object)"TDLY");
        frameIdsInPreferredOrder.add((Object)"PCNT");
        frameIdsInPreferredOrder.add((Object)"POPM");
        frameIdsInPreferredOrder.add((Object)"TPUB");
        frameIdsInPreferredOrder.add((Object)"TSO2");
        frameIdsInPreferredOrder.add((Object)"TSOC");
        frameIdsInPreferredOrder.add((Object)"TCMP");
        frameIdsInPreferredOrder.add((Object)"TSOT");
        frameIdsInPreferredOrder.add((Object)"TSOP");
        frameIdsInPreferredOrder.add((Object)"TSOA");
        frameIdsInPreferredOrder.add((Object)"XSOT");
        frameIdsInPreferredOrder.add((Object)"XSOP");
        frameIdsInPreferredOrder.add((Object)"XSOA");
        frameIdsInPreferredOrder.add((Object)"TSO2");
        frameIdsInPreferredOrder.add((Object)"TSOC");
        frameIdsInPreferredOrder.add((Object)"COMM");
        frameIdsInPreferredOrder.add((Object)"TRDA");
        frameIdsInPreferredOrder.add((Object)"COMR");
        frameIdsInPreferredOrder.add((Object)"TCOP");
        frameIdsInPreferredOrder.add((Object)"TENC");
        frameIdsInPreferredOrder.add((Object)"ENCR");
        frameIdsInPreferredOrder.add((Object)"EQUA");
        frameIdsInPreferredOrder.add((Object)"ETCO");
        frameIdsInPreferredOrder.add((Object)"TOWN");
        frameIdsInPreferredOrder.add((Object)"TFLT");
        frameIdsInPreferredOrder.add((Object)"GRID");
        frameIdsInPreferredOrder.add((Object)"TSSE");
        frameIdsInPreferredOrder.add((Object)"TKEY");
        frameIdsInPreferredOrder.add((Object)"TLEN");
        frameIdsInPreferredOrder.add((Object)"LINK");
        frameIdsInPreferredOrder.add((Object)"TSIZ");
        frameIdsInPreferredOrder.add((Object)"MLLT");
        frameIdsInPreferredOrder.add((Object)"TOPE");
        frameIdsInPreferredOrder.add((Object)"TOFN");
        frameIdsInPreferredOrder.add((Object)"TOLY");
        frameIdsInPreferredOrder.add((Object)"TOAL");
        frameIdsInPreferredOrder.add((Object)"OWNE");
        frameIdsInPreferredOrder.add((Object)"POSS");
        frameIdsInPreferredOrder.add((Object)"TRSN");
        frameIdsInPreferredOrder.add((Object)"TRSO");
        frameIdsInPreferredOrder.add((Object)"RBUF");
        frameIdsInPreferredOrder.add((Object)"TPE4");
        frameIdsInPreferredOrder.add((Object)"RVRB");
        frameIdsInPreferredOrder.add((Object)"TPOS");
        frameIdsInPreferredOrder.add((Object)"SYLT");
        frameIdsInPreferredOrder.add((Object)"SYTC");
        frameIdsInPreferredOrder.add((Object)"USER");
        frameIdsInPreferredOrder.add((Object)"APIC");
        frameIdsInPreferredOrder.add((Object)"PRIV");
        frameIdsInPreferredOrder.add((Object)"MCDI");
        frameIdsInPreferredOrder.add((Object)"AENC");
        frameIdsInPreferredOrder.add((Object)"GEOB");
    }

    private ID3v23PreferredFrameOrderComparator() {
    }

    public static ID3v23PreferredFrameOrderComparator getInstanceof() {
        if (comparator == null) {
            comparator = new ID3v23PreferredFrameOrderComparator();
        }
        return comparator;
    }

    public int compare(String string2, String string3) {
        int n2;
        int n3 = frameIdsInPreferredOrder.indexOf((Object)string2);
        int n4 = Integer.MAX_VALUE;
        if (n3 == -1) {
            n3 = Integer.MAX_VALUE;
        }
        if ((n2 = frameIdsInPreferredOrder.indexOf((Object)string3)) != -1) {
            n4 = n2;
        }
        if (n3 == n4) {
            return string2.compareTo(string3);
        }
        return n3 - n4;
    }

    public boolean equals(Object object) {
        return object instanceof ID3v23PreferredFrameOrderComparator;
    }
}

