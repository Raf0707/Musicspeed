/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileTypeUtil {
    private static final int BUFFER_SIZE = 4096;
    private static final int MAX_SIGNATURE_SIZE = 8;
    private static Map<String, String> extensionMap;
    private static final Integer[] mp3v1Sig_1;
    private static final Integer[] mp3v1Sig_2;
    private static final Integer[] mp3v1Sig_3;
    private static final Integer[] mp3v1Sig_4;
    private static final Integer[] mp3v2Sig;
    private static final Integer[] mp4Sig;
    private static Map<String, Integer[]> signatureMap;

    static {
        HashMap hashMap;
        HashMap hashMap2;
        Integer[] arrinteger = new Integer[3];
        Integer n2 = 73;
        Integer n3 = 0;
        arrinteger[0] = n2;
        arrinteger[1] = 68;
        arrinteger[2] = 51;
        mp3v2Sig = arrinteger;
        Integer n4 = 255;
        Integer[] arrinteger2 = new Integer[]{n4, 243};
        mp3v1Sig_1 = arrinteger2;
        Integer[] arrinteger3 = new Integer[]{n4, 250};
        mp3v1Sig_2 = arrinteger3;
        Integer[] arrinteger4 = new Integer[]{n4, 242};
        mp3v1Sig_3 = arrinteger4;
        Integer[] arrinteger5 = new Integer[]{n4, 251};
        mp3v1Sig_4 = arrinteger5;
        Integer[] arrinteger6 = new Integer[]{n3, n3, n3, null, 102, 116, 121, 112};
        mp4Sig = arrinteger6;
        signatureMap = hashMap2 = new HashMap();
        hashMap2.put((Object)"MP3IDv2", (Object)arrinteger);
        signatureMap.put((Object)"MP3IDv1_1", (Object)arrinteger2);
        signatureMap.put((Object)"MP3IDv1_2", (Object)arrinteger3);
        signatureMap.put((Object)"MP3IDv1_3", (Object)arrinteger4);
        signatureMap.put((Object)"MP3IDv1_4", (Object)arrinteger5);
        signatureMap.put((Object)"MP4", (Object)arrinteger6);
        extensionMap = hashMap = new HashMap();
        hashMap.put((Object)"MP3IDv2", (Object)"mp3");
        extensionMap.put((Object)"MP3IDv1_1", (Object)"mp3");
        extensionMap.put((Object)"MP3IDv1_2", (Object)"mp3");
        extensionMap.put((Object)"MP3IDv1_3", (Object)"mp3");
        extensionMap.put((Object)"MP3IDv1_4", (Object)"mp3");
        extensionMap.put((Object)"MP4", (Object)"m4a");
        extensionMap.put((Object)"UNKNOWN", (Object)"");
    }

    public static String getMagicExt(String string2) {
        return (String)extensionMap.get((Object)string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getMagicFileType(File file) throws IOException {
        byte[] arrby = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int n2;
            int n3 = n2 = fileInputStream.read(arrby, 0, 4096);
            while (n2 < 8 && n3 > 0) {
                n3 = fileInputStream.read(arrby, n2, 4096 - n2);
                n2 += n3;
            }
            String string2 = "UNKNOWN";
            for (String string3 : signatureMap.keySet()) {
                boolean bl = FileTypeUtil.matchesSignature((Integer[])signatureMap.get((Object)string3), arrby, n2);
                if (!bl) continue;
                string2 = string3;
                return string2;
            }
            return string2;
        }
        finally {
            fileInputStream.close();
        }
    }

    public static void main(String[] arrstring) throws IOException {
        String string2 = FileTypeUtil.getMagicFileType(new File("C:/Users/keerthi/Dropbox/Works/Java/github/GaanaExtractor/workspace/jaudiotagger/testm4a"));
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File type: ");
        stringBuilder.append(string2);
        printStream.println(stringBuilder.toString());
        PrintStream printStream2 = System.out;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("File Extension: ");
        stringBuilder2.append(FileTypeUtil.getMagicExt(string2));
        printStream2.println(stringBuilder2.toString());
    }

    private static boolean matchesSignature(Integer[] arrinteger, byte[] arrby, int n2) {
        if (n2 < arrinteger.length) {
            return false;
        }
        for (int i2 = 0; i2 < arrinteger.length; ++i2) {
            if (arrinteger[i2] == null || arrinteger[i2] == (255 & arrby[i2])) continue;
            return false;
        }
        return true;
    }
}

