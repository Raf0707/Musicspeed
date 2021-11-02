/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 */
package org.jaudiotagger.audio.aiff;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jaudiotagger.audio.aiff.ExtDouble;

public class AiffUtil {
    private static final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static String formatDate(Date date) {
        return dateFmt.format(date);
    }

    public static double read80BitDouble(ByteBuffer byteBuffer) throws IOException {
        byte[] arrby = new byte[10];
        byteBuffer.get(arrby);
        return new ExtDouble(arrby).toDouble();
    }

    public static Date timestampToDate(long l2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1904, 0, 1, 0, 0, 0);
        int n2 = (int)(l2 / 3600L);
        int n3 = (int)(l2 - 3600L * (long)n2);
        calendar.add(11, n2);
        calendar.add(13, n3);
        return calendar.getTime();
    }
}

