/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImageFormats {
    public static final String MIME_TYPE_BMP = "image/bmp";
    public static final String MIME_TYPE_GIF = "image/gif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    public static final String MIME_TYPE_PDF = "image/pdf";
    public static final String MIME_TYPE_PICT = "image/x-pict";
    public static final String MIME_TYPE_PNG = "image/png";
    public static final String MIME_TYPE_TIFF = "image/tiff";
    public static final String V22_BMP_FORMAT = "BMP";
    public static final String V22_GIF_FORMAT = "GIF";
    public static final String V22_JPG_FORMAT = "JPG";
    public static final String V22_PDF_FORMAT = "PDF";
    public static final String V22_PIC_FORMAT = "PIC";
    public static final String V22_PNG_FORMAT = "PNG";
    public static final String V22_TIF_FORMAT = "TIF";
    private static Map<String, String> imageFormatsToMimeType = new HashMap();
    private static Map<String, String> imageMimeTypeToFormat = new HashMap();

    static {
        imageFormatsToMimeType.put((Object)V22_JPG_FORMAT, (Object)MIME_TYPE_JPEG);
        imageFormatsToMimeType.put((Object)V22_PNG_FORMAT, (Object)MIME_TYPE_PNG);
        imageFormatsToMimeType.put((Object)V22_GIF_FORMAT, (Object)MIME_TYPE_GIF);
        imageFormatsToMimeType.put((Object)V22_BMP_FORMAT, (Object)MIME_TYPE_BMP);
        imageFormatsToMimeType.put((Object)V22_TIF_FORMAT, (Object)MIME_TYPE_TIFF);
        imageFormatsToMimeType.put((Object)V22_PDF_FORMAT, (Object)MIME_TYPE_PDF);
        imageFormatsToMimeType.put((Object)V22_PIC_FORMAT, (Object)MIME_TYPE_PICT);
        for (String string2 : imageFormatsToMimeType.keySet()) {
            String string3 = (String)imageFormatsToMimeType.get((Object)string2);
            imageMimeTypeToFormat.put((Object)string3, (Object)string2);
        }
        imageMimeTypeToFormat.put((Object)MIME_TYPE_JPG, (Object)V22_JPG_FORMAT);
    }

    public static boolean binaryDataIsBmpFormat(byte[] arrby) {
        if (arrby.length < 2) {
            return false;
        }
        int n2 = 255 & arrby[0];
        boolean bl = false;
        if (66 == n2) {
            int n3 = 255 & arrby[1];
            bl = false;
            if (77 == n3) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean binaryDataIsGifFormat(byte[] arrby) {
        if (arrby.length < 3) {
            return false;
        }
        int n2 = 255 & arrby[0];
        boolean bl = false;
        if (71 == n2) {
            int n3 = 255 & arrby[1];
            bl = false;
            if (73 == n3) {
                int n4 = 255 & arrby[2];
                bl = false;
                if (70 == n4) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static boolean binaryDataIsJpgFormat(byte[] arrby) {
        if (arrby.length < 4) {
            return false;
        }
        int n2 = 255 & arrby[0];
        boolean bl = false;
        if (255 == n2) {
            int n3 = 255 & arrby[1];
            bl = false;
            if (216 == n3) {
                int n4 = 255 & arrby[2];
                bl = false;
                if (255 == n4) {
                    int n5 = 255 & arrby[3];
                    bl = false;
                    if (219 <= n5) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    public static boolean binaryDataIsPdfFormat(byte[] arrby) {
        if (arrby.length < 4) {
            return false;
        }
        int n2 = 255 & arrby[0];
        boolean bl = false;
        if (37 == n2) {
            int n3 = 255 & arrby[1];
            bl = false;
            if (80 == n3) {
                int n4 = 255 & arrby[2];
                bl = false;
                if (68 == n4) {
                    int n5 = 255 & arrby[3];
                    bl = false;
                    if (70 == n5) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    public static boolean binaryDataIsPngFormat(byte[] arrby) {
        if (arrby.length < 4) {
            return false;
        }
        int n2 = 255 & arrby[0];
        boolean bl = false;
        if (137 == n2) {
            int n3 = 255 & arrby[1];
            bl = false;
            if (80 == n3) {
                int n4 = 255 & arrby[2];
                bl = false;
                if (78 == n4) {
                    int n5 = 255 & arrby[3];
                    bl = false;
                    if (71 == n5) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    public static boolean binaryDataIsTiffFormat(byte[] arrby) {
        boolean bl;
        block5 : {
            block4 : {
                if (arrby.length < 4) {
                    return false;
                }
                if (73 == (255 & arrby[0]) && 73 == (255 & arrby[1]) && 42 == (255 & arrby[2]) && (255 & arrby[3]) == 0) break block4;
                int n2 = 255 & arrby[0];
                bl = false;
                if (77 != n2) break block5;
                int n3 = 255 & arrby[1];
                bl = false;
                if (77 != n3) break block5;
                int n4 = 255 & arrby[2];
                bl = false;
                if (n4 != 0) break block5;
                int n5 = 255 & arrby[3];
                bl = false;
                if (42 != n5) break block5;
            }
            bl = true;
        }
        return bl;
    }

    public static String getFormatForMimeType(String string2) {
        return (String)imageMimeTypeToFormat.get((Object)string2);
    }

    public static String getMimeTypeForBinarySignature(byte[] arrby) {
        if (ImageFormats.binaryDataIsPngFormat(arrby)) {
            return MIME_TYPE_PNG;
        }
        if (ImageFormats.binaryDataIsJpgFormat(arrby)) {
            return MIME_TYPE_JPEG;
        }
        if (ImageFormats.binaryDataIsGifFormat(arrby)) {
            return MIME_TYPE_GIF;
        }
        if (ImageFormats.binaryDataIsBmpFormat(arrby)) {
            return MIME_TYPE_BMP;
        }
        if (ImageFormats.binaryDataIsPdfFormat(arrby)) {
            return MIME_TYPE_PDF;
        }
        if (ImageFormats.binaryDataIsTiffFormat(arrby)) {
            return MIME_TYPE_TIFF;
        }
        return null;
    }

    public static String getMimeTypeForFormat(String string2) {
        return (String)imageFormatsToMimeType.get((Object)string2);
    }

    public static boolean isPortableFormat(byte[] arrby) {
        return ImageFormats.binaryDataIsPngFormat(arrby) || ImageFormats.binaryDataIsJpgFormat(arrby) || ImageFormats.binaryDataIsGifFormat(arrby);
        {
        }
    }
}

