/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeSet
 */
package org.jaudiotagger.tag.id3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.jaudiotagger.tag.datatype.AbstractStringStringValuePair;

public abstract class ID3Frames
extends AbstractStringStringValuePair {
    public static final Map<String, String> convertv22Tov23 = new LinkedHashMap();
    public static final Map<String, String> convertv23Tov22 = new LinkedHashMap();
    public static final Map<String, String> convertv23Tov24;
    public static final Map<String, String> convertv24Tov23;
    public static final Map<String, String> forcev22Tov23;
    public static final Map<String, String> forcev23Tov22;
    public static final Map<String, String> forcev23Tov24;
    public static final Map<String, String> forcev24Tov23;
    protected TreeSet<String> binaryFrames = new TreeSet();
    protected TreeSet<String> commonFrames = new TreeSet();
    protected TreeSet<String> discardIfFileAlteredFrames = new TreeSet();
    protected TreeSet<String> extensionFrames = new TreeSet();
    protected TreeSet<String> multipleFrames = new TreeSet();
    protected TreeSet<String> supportedFrames = new TreeSet();

    static {
        forcev22Tov23 = new LinkedHashMap();
        forcev23Tov22 = new LinkedHashMap();
        convertv23Tov24 = new LinkedHashMap();
        convertv24Tov23 = new LinkedHashMap();
        forcev23Tov24 = new LinkedHashMap();
        forcev24Tov23 = new LinkedHashMap();
        ID3Frames.loadID3v22ID3v23Mapping();
        ID3Frames.loadID3v23ID3v24Mapping();
    }

    private static void loadID3v22ID3v23Mapping() {
        Map<String, String> map = convertv22Tov23;
        map.put((Object)"TP2", (Object)"TPE2");
        map.put((Object)"TAL", (Object)"TALB");
        map.put((Object)"TP1", (Object)"TPE1");
        map.put((Object)"CRA", (Object)"AENC");
        map.put((Object)"TBP", (Object)"TBPM");
        map.put((Object)"COM", (Object)"COMM");
        map.put((Object)"COM", (Object)"COMM");
        map.put((Object)"TCM", (Object)"TCOM");
        map.put((Object)"TPE", (Object)"TPE3");
        map.put((Object)"TT1", (Object)"TIT1");
        map.put((Object)"TCR", (Object)"TCOP");
        map.put((Object)"TEN", (Object)"TENC");
        map.put((Object)"EQU", (Object)"EQUA");
        map.put((Object)"ETC", (Object)"ETCO");
        map.put((Object)"TFT", (Object)"TFLT");
        map.put((Object)"GEO", (Object)"GEOB");
        map.put((Object)"TCO", (Object)"TCON");
        map.put((Object)"TSS", (Object)"TSSE");
        map.put((Object)"TKE", (Object)"TKEY");
        map.put((Object)"IPL", (Object)"IPLS");
        map.put((Object)"TRC", (Object)"TSRC");
        map.put((Object)"GP1", (Object)"GRP1");
        map.put((Object)"TLA", (Object)"TLAN");
        map.put((Object)"TLE", (Object)"TLEN");
        map.put((Object)"LNK", (Object)"LINK");
        map.put((Object)"TXT", (Object)"TEXT");
        map.put((Object)"TMT", (Object)"TMED");
        map.put((Object)"MVN", (Object)"MVNM");
        map.put((Object)"MVI", (Object)"MVIN");
        map.put((Object)"MLL", (Object)"MLLT");
        map.put((Object)"MCI", (Object)"MCDI");
        map.put((Object)"TOA", (Object)"TOPE");
        map.put((Object)"TOF", (Object)"TOFN");
        map.put((Object)"TOL", (Object)"TOLY");
        map.put((Object)"TOT", (Object)"TOAL");
        map.put((Object)"TDY", (Object)"TDLY");
        map.put((Object)"CNT", (Object)"PCNT");
        map.put((Object)"CNT", (Object)"PCNT");
        map.put((Object)"POP", (Object)"POPM");
        map.put((Object)"TPB", (Object)"TPUB");
        map.put((Object)"BUF", (Object)"RBUF");
        map.put((Object)"BUF", (Object)"RBUF");
        map.put((Object)"RVA", (Object)"RVAD");
        map.put((Object)"TP4", (Object)"TPE4");
        map.put((Object)"REV", (Object)"RVRB");
        map.put((Object)"TPA", (Object)"TPOS");
        map.put((Object)"TPS", (Object)"TSST");
        map.put((Object)"SLT", (Object)"SYLT");
        map.put((Object)"STC", (Object)"SYTC");
        map.put((Object)"TDA", (Object)"TDAT");
        map.put((Object)"TIM", (Object)"TIME");
        map.put((Object)"TT3", (Object)"TIT3");
        map.put((Object)"TOR", (Object)"TORY");
        map.put((Object)"TRK", (Object)"TRCK");
        map.put((Object)"TRD", (Object)"TRDA");
        map.put((Object)"TSI", (Object)"TSIZ");
        map.put((Object)"TYE", (Object)"TYER");
        map.put((Object)"UFI", (Object)"UFID");
        map.put((Object)"UFI", (Object)"UFID");
        map.put((Object)"ULT", (Object)"USLT");
        map.put((Object)"WAR", (Object)"WOAR");
        map.put((Object)"WCM", (Object)"WCOM");
        map.put((Object)"WCP", (Object)"WCOP");
        map.put((Object)"WAF", (Object)"WOAF");
        map.put((Object)"WRS", (Object)"WORS");
        map.put((Object)"WPAY", (Object)"WPAY");
        map.put((Object)"WPB", (Object)"WPUB");
        map.put((Object)"WAS", (Object)"WOAS");
        map.put((Object)"TXX", (Object)"TXXX");
        map.put((Object)"WXX", (Object)"WXXX");
        map.put((Object)"TT2", (Object)"TIT2");
        map.put((Object)"TCP", (Object)"TCMP");
        map.put((Object)"TST", (Object)"TSOT");
        map.put((Object)"TSP", (Object)"TSOP");
        map.put((Object)"TSA", (Object)"TSOA");
        map.put((Object)"TS2", (Object)"TSO2");
        map.put((Object)"TSC", (Object)"TSOC");
        for (String string2 : map.keySet()) {
            String string3 = (String)convertv22Tov23.get((Object)string2);
            convertv23Tov22.put((Object)string3, (Object)string2);
        }
        Map<String, String> map2 = convertv23Tov22;
        map2.put((Object)"XSOT", (Object)"TST");
        map2.put((Object)"XSOP", (Object)"TSP");
        map2.put((Object)"XSOA", (Object)"TSA");
        forcev22Tov23.put((Object)"PIC", (Object)"APIC");
        forcev23Tov22.put((Object)"APIC", (Object)"PIC");
    }

    private static void loadID3v23ID3v24Mapping() {
        Map<String, String> map = convertv23Tov24;
        map.put((Object)"XSOT", (Object)"TSOT");
        map.put((Object)"XSOP", (Object)"TSOP");
        map.put((Object)"XSOA", (Object)"TSOA");
        Map<String, String> map2 = forcev23Tov24;
        map2.put((Object)"RVAD", (Object)"RVA2");
        map2.put((Object)"EQUA", (Object)"EQU2");
        map2.put((Object)"IPLS", (Object)"TIPL");
        map2.put((Object)"TDAT", (Object)"TDRC");
        map2.put((Object)"TIME", (Object)"TDRC");
        map2.put((Object)"TORY", (Object)"TDOR");
        map2.put((Object)"TRDA", (Object)"TDRC");
        map2.put((Object)"TYER", (Object)"TDRC");
        Map<String, String> map3 = forcev24Tov23;
        map3.put((Object)"RVA2", (Object)"RVAD");
        map3.put((Object)"TIPL", (Object)"IPLS");
        map3.put((Object)"TMOO", (Object)"TXXX");
        map3.put((Object)"TDOR", (Object)"TORY");
    }

    public TreeSet<String> getSupportedFrames() {
        return this.supportedFrames;
    }

    public boolean isBinary(String string2) {
        return this.binaryFrames.contains((Object)string2);
    }

    public boolean isCommon(String string2) {
        return this.commonFrames.contains((Object)string2);
    }

    public boolean isDiscardIfFileAltered(String string2) {
        return this.discardIfFileAlteredFrames.contains((Object)string2);
    }

    public boolean isExtensionFrames(String string2) {
        return this.extensionFrames.contains((Object)string2);
    }

    public boolean isMultipleAllowed(String string2) {
        return this.multipleFrames.contains((Object)string2);
    }

    public boolean isSupportedFrames(String string2) {
        return this.supportedFrames.contains((Object)string2);
    }
}

