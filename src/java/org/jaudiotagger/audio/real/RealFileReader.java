/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.DataInput
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  org.jaudiotagger.audio.real.RealTag
 */
package org.jaudiotagger.audio.real;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.real.RealChunk;
import org.jaudiotagger.audio.real.RealTag;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class RealFileReader
extends AudioFileReader {
    private RealChunk findContChunk(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        RealChunk.readChunk(randomAccessFile);
        RealChunk.readChunk(randomAccessFile);
        RealChunk realChunk = RealChunk.readChunk(randomAccessFile);
        while (!realChunk.isCONT()) {
            realChunk = RealChunk.readChunk(randomAccessFile);
        }
        return realChunk;
    }

    private RealChunk findPropChunk(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        RealChunk.readChunk(randomAccessFile);
        return RealChunk.readChunk(randomAccessFile);
    }

    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        GenericAudioHeader genericAudioHeader = new GenericAudioHeader();
        DataInputStream dataInputStream = this.findPropChunk(randomAccessFile).getDataInputStream();
        if (Utils.readUint16((DataInput)dataInputStream) == 0) {
            long l2 = Utils.readUint32((DataInput)dataInputStream) / 1000L;
            long l3 = Utils.readUint32((DataInput)dataInputStream) / 1000L;
            Utils.readUint32((DataInput)dataInputStream);
            Utils.readUint32((DataInput)dataInputStream);
            Utils.readUint32((DataInput)dataInputStream);
            int n2 = (int)Utils.readUint32((DataInput)dataInputStream) / 1000;
            Utils.readUint32((DataInput)dataInputStream);
            Utils.readUint32((DataInput)dataInputStream);
            Utils.readUint32((DataInput)dataInputStream);
            Utils.readUint16((DataInput)dataInputStream);
            Utils.readUint16((DataInput)dataInputStream);
            genericAudioHeader.setBitRate((int)l3);
            genericAudioHeader.setPreciseLength(n2);
            boolean bl = l2 != l3;
            genericAudioHeader.setVariableBitRate(bl);
        }
        return genericAudioHeader;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected Tag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        DataInputStream dataInputStream = this.findContChunk(randomAccessFile).getDataInputStream();
        String string2 = Utils.readString((DataInput)dataInputStream, Utils.readUint16((DataInput)dataInputStream));
        String string3 = Utils.readString((DataInput)dataInputStream, Utils.readUint16((DataInput)dataInputStream));
        String string4 = Utils.readString((DataInput)dataInputStream, Utils.readUint16((DataInput)dataInputStream));
        String string5 = Utils.readString((DataInput)dataInputStream, Utils.readUint16((DataInput)dataInputStream));
        RealTag realTag = new RealTag();
        try {
            FieldKey fieldKey = FieldKey.TITLE;
            String[] arrstring = new String[1];
            String string6 = string2.length() == 0 ? string3 : string2;
            arrstring[0] = string6;
            realTag.addField(fieldKey, arrstring);
            FieldKey fieldKey2 = FieldKey.ARTIST;
            String[] arrstring2 = new String[1];
            if (string2.length() == 0) {
                string3 = string4;
            }
            arrstring2[0] = string3;
            realTag.addField(fieldKey2, arrstring2);
            realTag.addField(FieldKey.COMMENT, string5);
            return realTag;
        }
        catch (FieldDataInvalidException fieldDataInvalidException) {
            throw new RuntimeException((Throwable)fieldDataInvalidException);
        }
    }
}

