/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.audio.flac;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class FlacStreamReader {
    public static final String FLAC_STREAM_IDENTIFIER = "fLaC";
    public static final int FLAC_STREAM_IDENTIFIER_LENGTH = 4;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");
    private FileChannel fc;
    private String loggingName;
    private int startOfFlacInFile;

    public FlacStreamReader(FileChannel fileChannel, String string2) {
        this.fc = fileChannel;
        this.loggingName = string2;
    }

    private boolean isFlacHeader() throws IOException {
        return Utils.readFourBytesAsChars(Utils.readFileDataIntoBufferBE(this.fc, 4)).equals((Object)FLAC_STREAM_IDENTIFIER);
    }

    private boolean isId3v2Tag() throws IOException {
        this.fc.position(0L);
        if (AbstractID3v2Tag.isId3Tag((FileChannel)this.fc)) {
            Logger logger = FlacStreamReader.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            ErrorMessage errorMessage = ErrorMessage.FLAC_CONTAINS_ID3TAG;
            Object[] arrobject = new Object[]{this.fc.position()};
            stringBuilder.append(errorMessage.getMsg(arrobject));
            logger.warning(stringBuilder.toString());
            if (this.isFlacHeader()) {
                return true;
            }
        }
        return false;
    }

    public void findStream() throws IOException, CannotReadException {
        if (this.fc.size() != 0L) {
            this.fc.position(0L);
            if (this.isFlacHeader()) {
                this.startOfFlacInFile = 0;
                return;
            }
            if (this.isId3v2Tag()) {
                this.startOfFlacInFile = (int)(this.fc.position() - 4L);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(ErrorMessage.FLAC_NO_FLAC_HEADER_FOUND.getMsg());
            throw new CannotReadException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error: File empty ");
        stringBuilder.append(this.loggingName);
        throw new CannotReadException(stringBuilder.toString());
    }

    public int getStartOfFlacInFile() {
        return this.startOfFlacInFile;
    }
}

