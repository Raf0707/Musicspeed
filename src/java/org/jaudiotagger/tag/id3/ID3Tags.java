/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.Map
 *  java.util.Objects
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.ID3Frames
 *  org.jaudiotagger.tag.id3.ID3v22Frames
 *  org.jaudiotagger.tag.id3.ID3v23Frames
 *  org.jaudiotagger.tag.id3.ID3v24Frames
 */
package org.jaudiotagger.tag.id3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3Frames;
import org.jaudiotagger.tag.id3.ID3v22Frames;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v24Frames;

public class ID3Tags {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");

    private ID3Tags() {
    }

    public static String convertFrameID22To23(String string2) {
        if (string2.length() < 3) {
            return null;
        }
        return (String)ID3Frames.convertv22Tov23.get((Object)((String)string2.subSequence(0, 3)));
    }

    public static String convertFrameID22To24(String string2) {
        if (string2.length() < 3) {
            return null;
        }
        String string3 = (String)ID3Frames.convertv22Tov23.get((Object)string2.substring(0, 3));
        if (string3 != null) {
            String string4 = (String)ID3Frames.convertv23Tov24.get((Object)string3);
            if (string4 == null) {
                if (ID3v24Frames.getInstanceOf().getIdToValueMap().get((Object)string3) != null) {
                    return string3;
                }
                return null;
            }
            return string4;
        }
        return null;
    }

    public static String convertFrameID23To22(String string2) {
        if (string2.length() < 4) {
            return null;
        }
        if (ID3v23Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2)) {
            return (String)ID3Frames.convertv23Tov22.get((Object)string2.substring(0, 4));
        }
        return null;
    }

    public static String convertFrameID23To24(String string2) {
        if (string2.length() < 4) {
            return null;
        }
        if (ID3v23Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2)) {
            if (ID3v24Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2)) {
                return string2;
            }
            return (String)ID3Frames.convertv23Tov24.get((Object)string2.substring(0, 4));
        }
        return null;
    }

    public static String convertFrameID24To23(String string2) {
        if (string2.length() < 4) {
            return null;
        }
        String string3 = (String)ID3Frames.convertv24Tov23.get((Object)string2);
        if (string3 == null && ID3v23Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2)) {
            return string2;
        }
        return string3;
    }

    public static Object copyObject(Object object) {
        if (object == null) {
            return null;
        }
        try {
            Class[] arrclass = new Class[]{object.getClass()};
            Object object2 = object.getClass().getConstructor(arrclass).newInstance(new Object[]{object});
            return object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (!(invocationTargetException.getCause() instanceof Error)) {
                if (invocationTargetException.getCause() instanceof RuntimeException) {
                    throw (RuntimeException)invocationTargetException.getCause();
                }
                throw new IllegalArgumentException("InvocationTargetException: Unable to invoke constructor to create copy");
            }
            throw (Error)invocationTargetException.getCause();
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("InstantiationException: Unable to instantiate constructor to copy");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IllegalAccessException: No access to run constructor to create copy");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        catch (NoSuchMethodException noSuchMethodException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NoSuchMethodException: Error finding constructor to create copy:");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static long findNumber(String string2) throws TagException {
        return ID3Tags.findNumber(string2, 0);
    }

    public static long findNumber(String string2, int n2) throws TagException {
        Objects.requireNonNull((Object)string2, (String)"String is null");
        if (n2 >= 0 && n2 < string2.length()) {
            int n3;
            while (n2 < string2.length() && (string2.charAt(n2) < '0' || string2.charAt(n2) > '9') && string2.charAt(n2) != '-') {
                ++n2;
            }
            for (n3 = n2 + 1; n3 < string2.length() && string2.charAt(n3) >= '0' && string2.charAt(n3) <= '9'; ++n3) {
            }
            if (n3 <= string2.length() && n3 > n2) {
                String string3 = string2.substring(n2, n3);
                if (!string3.equals((Object)"-")) {
                    return Long.parseLong((String)string3);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to find integer in string: ");
                stringBuilder.append(string2);
                throw new TagException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to find integer in string: ");
            stringBuilder.append(string2);
            throw new TagException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to image string is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", string.length()");
        stringBuilder.append(string2.length());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static String forceFrameID22To23(String string2) {
        return (String)ID3Frames.forcev22Tov23.get((Object)string2);
    }

    public static String forceFrameID23To22(String string2) {
        return (String)ID3Frames.forcev23Tov22.get((Object)string2);
    }

    public static String forceFrameID23To24(String string2) {
        return (String)ID3Frames.forcev23Tov24.get((Object)string2);
    }

    public static String forceFrameID24To23(String string2) {
        return (String)ID3Frames.forcev24Tov23.get((Object)string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long getWholeNumber(Object object) {
        int n2;
        if (object instanceof String) {
            return Long.parseLong((String)((String)object));
        }
        if (object instanceof Byte) {
            n2 = ((Byte)object).byteValue();
            do {
                return n2;
                break;
            } while (true);
        }
        if (object instanceof Short) {
            n2 = ((Short)object).shortValue();
            return n2;
        }
        if (object instanceof Integer) {
            n2 = (Integer)object;
            return n2;
        }
        if (object instanceof Long) {
            return (Long)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported value class: ");
        stringBuilder.append(object.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static boolean isID3v22FrameIdentifier(String string2) {
        if (string2.length() < 3) {
            return false;
        }
        int n2 = string2.length();
        boolean bl = false;
        if (n2 == 3) {
            boolean bl2 = ID3v22Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean isID3v23FrameIdentifier(String string2) {
        int n2 = string2.length();
        boolean bl = false;
        if (n2 >= 4) {
            boolean bl2 = ID3v23Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2.substring(0, 4));
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean isID3v24FrameIdentifier(String string2) {
        int n2 = string2.length();
        boolean bl = false;
        if (n2 >= 4) {
            boolean bl2 = ID3v24Frames.getInstanceOf().getIdToValueMap().containsKey((Object)string2.substring(0, 4));
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public static String stripChar(String string2, char c2) {
        if (string2 != null) {
            char[] arrc = new char[string2.length()];
            int n2 = 0;
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                if (string2.charAt(i2) == c2) continue;
                int n3 = n2 + 1;
                arrc[n2] = string2.charAt(i2);
                n2 = n3;
            }
            return new String(arrc, 0, n2);
        }
        return null;
    }

    public static String truncate(String string2, int n2) {
        if (string2 == null) {
            return null;
        }
        if (n2 < 0) {
            return null;
        }
        if (string2.length() > n2) {
            string2 = string2.substring(0, n2);
        }
        return string2;
    }
}

