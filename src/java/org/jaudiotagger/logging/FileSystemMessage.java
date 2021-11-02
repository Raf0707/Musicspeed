/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.logging;

public final class FileSystemMessage
extends Enum<FileSystemMessage> {
    private static final /* synthetic */ FileSystemMessage[] $VALUES;
    public static final /* enum */ FileSystemMessage ACCESS_IS_DENIED;
    public static final /* enum */ FileSystemMessage PERMISSION_DENIED;
    String msg;

    static {
        FileSystemMessage fileSystemMessage;
        FileSystemMessage fileSystemMessage2;
        ACCESS_IS_DENIED = fileSystemMessage2 = new FileSystemMessage("Access is denied");
        PERMISSION_DENIED = fileSystemMessage = new FileSystemMessage("Permission denied");
        $VALUES = new FileSystemMessage[]{fileSystemMessage2, fileSystemMessage};
    }

    private FileSystemMessage(String string3) {
        this.msg = string3;
    }

    public static FileSystemMessage valueOf(String string2) {
        return (FileSystemMessage)Enum.valueOf(FileSystemMessage.class, (String)string2);
    }

    public static FileSystemMessage[] values() {
        return (FileSystemMessage[])$VALUES.clone();
    }

    public String getMsg() {
        return this.msg;
    }
}

