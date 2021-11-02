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

public class ID3v22PreferredFrameOrderComparator
implements Comparator<String> {
    private static ID3v22PreferredFrameOrderComparator comparator;
    private static List frameIdsInPreferredOrder;

    static {
        ArrayList arrayList = new ArrayList();
        frameIdsInPreferredOrder = arrayList;
        arrayList.add((Object)"UFI");
        frameIdsInPreferredOrder.add((Object)"TT2");
        frameIdsInPreferredOrder.add((Object)"TP1");
        frameIdsInPreferredOrder.add((Object)"TAL");
        frameIdsInPreferredOrder.add((Object)"TOR");
        frameIdsInPreferredOrder.add((Object)"TCO");
        frameIdsInPreferredOrder.add((Object)"TCM");
        frameIdsInPreferredOrder.add((Object)"TPE");
        frameIdsInPreferredOrder.add((Object)"TT1");
        frameIdsInPreferredOrder.add((Object)"TRK");
        frameIdsInPreferredOrder.add((Object)"TYE");
        frameIdsInPreferredOrder.add((Object)"TDA");
        frameIdsInPreferredOrder.add((Object)"TIM");
        frameIdsInPreferredOrder.add((Object)"TBP");
        frameIdsInPreferredOrder.add((Object)"TRC");
        frameIdsInPreferredOrder.add((Object)"TOR");
        frameIdsInPreferredOrder.add((Object)"TP2");
        frameIdsInPreferredOrder.add((Object)"TT3");
        frameIdsInPreferredOrder.add((Object)"ULT");
        frameIdsInPreferredOrder.add((Object)"TXX");
        frameIdsInPreferredOrder.add((Object)"WXX");
        frameIdsInPreferredOrder.add((Object)"WAR");
        frameIdsInPreferredOrder.add((Object)"WCM");
        frameIdsInPreferredOrder.add((Object)"WCP");
        frameIdsInPreferredOrder.add((Object)"WAF");
        frameIdsInPreferredOrder.add((Object)"WRS");
        frameIdsInPreferredOrder.add((Object)"WPAY");
        frameIdsInPreferredOrder.add((Object)"WPB");
        frameIdsInPreferredOrder.add((Object)"WCM");
        frameIdsInPreferredOrder.add((Object)"TXT");
        frameIdsInPreferredOrder.add((Object)"TMT");
        frameIdsInPreferredOrder.add((Object)"IPL");
        frameIdsInPreferredOrder.add((Object)"TLA");
        frameIdsInPreferredOrder.add((Object)"TST");
        frameIdsInPreferredOrder.add((Object)"TDY");
        frameIdsInPreferredOrder.add((Object)"CNT");
        frameIdsInPreferredOrder.add((Object)"POP");
        frameIdsInPreferredOrder.add((Object)"TPB");
        frameIdsInPreferredOrder.add((Object)"TS2");
        frameIdsInPreferredOrder.add((Object)"TSC");
        frameIdsInPreferredOrder.add((Object)"TCP");
        frameIdsInPreferredOrder.add((Object)"TST");
        frameIdsInPreferredOrder.add((Object)"TSP");
        frameIdsInPreferredOrder.add((Object)"TSA");
        frameIdsInPreferredOrder.add((Object)"TS2");
        frameIdsInPreferredOrder.add((Object)"TSC");
        frameIdsInPreferredOrder.add((Object)"COM");
        frameIdsInPreferredOrder.add((Object)"TRD");
        frameIdsInPreferredOrder.add((Object)"TCR");
        frameIdsInPreferredOrder.add((Object)"TEN");
        frameIdsInPreferredOrder.add((Object)"EQU");
        frameIdsInPreferredOrder.add((Object)"ETC");
        frameIdsInPreferredOrder.add((Object)"TFT");
        frameIdsInPreferredOrder.add((Object)"TSS");
        frameIdsInPreferredOrder.add((Object)"TKE");
        frameIdsInPreferredOrder.add((Object)"TLE");
        frameIdsInPreferredOrder.add((Object)"LNK");
        frameIdsInPreferredOrder.add((Object)"TSI");
        frameIdsInPreferredOrder.add((Object)"MLL");
        frameIdsInPreferredOrder.add((Object)"TOA");
        frameIdsInPreferredOrder.add((Object)"TOF");
        frameIdsInPreferredOrder.add((Object)"TOL");
        frameIdsInPreferredOrder.add((Object)"TOT");
        frameIdsInPreferredOrder.add((Object)"BUF");
        frameIdsInPreferredOrder.add((Object)"TP4");
        frameIdsInPreferredOrder.add((Object)"REV");
        frameIdsInPreferredOrder.add((Object)"TPA");
        frameIdsInPreferredOrder.add((Object)"SLT");
        frameIdsInPreferredOrder.add((Object)"STC");
        frameIdsInPreferredOrder.add((Object)"PIC");
        frameIdsInPreferredOrder.add((Object)"MCI");
        frameIdsInPreferredOrder.add((Object)"CRA");
        frameIdsInPreferredOrder.add((Object)"GEO");
    }

    private ID3v22PreferredFrameOrderComparator() {
    }

    public static ID3v22PreferredFrameOrderComparator getInstanceof() {
        if (comparator == null) {
            comparator = new ID3v22PreferredFrameOrderComparator();
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
        return object instanceof ID3v22PreferredFrameOrderComparator;
    }
}

