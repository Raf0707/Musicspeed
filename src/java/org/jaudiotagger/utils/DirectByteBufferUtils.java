/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Method
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.utils.DirectByteBufferUtils$AndroidReleaseStrategy
 *  org.jaudiotagger.utils.DirectByteBufferUtils$OpenJdkReleaseStrategy
 *  org.jaudiotagger.utils.DirectByteBufferUtils$UnsupportedJvmReleaseStrategy
 */
package org.jaudiotagger.utils;

import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.utils.DirectByteBufferUtils;

/*
 * Exception performing whole class analysis ignored.
 */
public class DirectByteBufferUtils {
    public static final Logger LOGGER = Logger.getLogger((String)DirectByteBufferUtils.class.getName());
    private static ReleaseStrategy releaseStrategy = DirectByteBufferUtils.decideReleaseStrategy();

    static {
    }

    public DirectByteBufferUtils() {
    }

    static /* synthetic */ Method access$000(String string2, String string3) {
        return DirectByteBufferUtils.loadMethod(string2, string3);
    }

    private static ReleaseStrategy decideReleaseStrategy() {
        String string2 = System.getProperty((String)"java.vendor");
        if (!string2.equals((Object)"Sun Microsystems Inc.") && !string2.equals((Object)"Oracle Corporation")) {
            if (string2.equals((Object)"The Android Project")) {
                return AndroidReleaseStrategy.access$200();
            }
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Won't be able to release direct buffers as this JVM is unsupported: ");
            stringBuilder.append(string2);
            logger.log(level, stringBuilder.toString());
            return UnsupportedJvmReleaseStrategy.access$300();
        }
        return OpenJdkReleaseStrategy.access$100();
    }

    private static Method loadMethod(String string2, String string3) {
        try {
            Method method = Class.forName((String)string2).getMethod(string3, new Class[0]);
            method.setAccessible(true);
            return method;
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException throwable) {
            return null;
        }
    }

    public static void release(Buffer buffer) {
        if (buffer != null) {
            if (buffer.isDirect()) {
                releaseStrategy.release(buffer);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(buffer.getClass().getName());
            stringBuilder.append(" is not direct.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ByteBuffer.class.getSimpleName());
        stringBuilder.append(" should not be null");
        throw new NullPointerException(stringBuilder.toString());
    }

    private static interface ReleaseStrategy {
        public void release(Buffer var1);
    }

}

