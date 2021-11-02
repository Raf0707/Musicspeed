/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.aiff.AiffFileReader
 *  org.jaudiotagger.audio.aiff.AiffFileWriter
 *  org.jaudiotagger.audio.asf.AsfFileReader
 *  org.jaudiotagger.audio.asf.AsfFileWriter
 *  org.jaudiotagger.audio.dsf.DsfFileReader
 *  org.jaudiotagger.audio.dsf.DsfFileWriter
 *  org.jaudiotagger.audio.flac.FlacFileReader
 *  org.jaudiotagger.audio.flac.FlacFileWriter
 *  org.jaudiotagger.audio.generic.ModificationHandler
 *  org.jaudiotagger.audio.mp3.MP3FileReader
 *  org.jaudiotagger.audio.mp3.MP3FileWriter
 *  org.jaudiotagger.audio.mp4.Mp4FileReader
 *  org.jaudiotagger.audio.mp4.Mp4FileWriter
 *  org.jaudiotagger.audio.ogg.OggFileReader
 *  org.jaudiotagger.audio.ogg.OggFileWriter
 *  org.jaudiotagger.audio.real.RealFileReader
 *  org.jaudiotagger.audio.wav.WavFileReader
 *  org.jaudiotagger.audio.wav.WavFileWriter
 */
package org.jaudiotagger.audio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.SupportedFileFormat;
import org.jaudiotagger.audio.aiff.AiffFileReader;
import org.jaudiotagger.audio.aiff.AiffFileWriter;
import org.jaudiotagger.audio.asf.AsfFileReader;
import org.jaudiotagger.audio.asf.AsfFileWriter;
import org.jaudiotagger.audio.dsf.DsfFileReader;
import org.jaudiotagger.audio.dsf.DsfFileWriter;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.audio.flac.FlacFileWriter;
import org.jaudiotagger.audio.generic.AudioFileModificationListener;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.audio.generic.ModificationHandler;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp3.MP3FileReader;
import org.jaudiotagger.audio.mp3.MP3FileWriter;
import org.jaudiotagger.audio.mp4.Mp4FileReader;
import org.jaudiotagger.audio.mp4.Mp4FileWriter;
import org.jaudiotagger.audio.ogg.OggFileReader;
import org.jaudiotagger.audio.ogg.OggFileWriter;
import org.jaudiotagger.audio.real.RealFileReader;
import org.jaudiotagger.audio.wav.WavFileReader;
import org.jaudiotagger.audio.wav.WavFileWriter;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.TagException;

public class AudioFileIO {
    private static AudioFileIO defaultInstance;
    public static Logger logger;
    private final ModificationHandler modificationHandler = new ModificationHandler();
    public Map<String, AudioFileReader> readers = new HashMap();
    public Map<String, AudioFileWriter> writers = new HashMap();

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio");
    }

    public AudioFileIO() {
        this.prepareReadersAndWriters();
    }

    /*
     * Exception decompiling
     */
    public static /* varargs */ void closeQuietly(Closeable ... var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static void delete(AudioFile audioFile) throws CannotReadException, CannotWriteException {
        AudioFileIO.getDefaultAudioFileIO().deleteTag(audioFile);
    }

    public static AudioFileIO getDefaultAudioFileIO() {
        if (defaultInstance == null) {
            defaultInstance = new AudioFileIO();
        }
        return defaultInstance;
    }

    private void prepareReadersAndWriters() {
        Map<String, AudioFileReader> map = this.readers;
        SupportedFileFormat supportedFileFormat = SupportedFileFormat.OGG;
        map.put((Object)supportedFileFormat.getFilesuffix(), (Object)new OggFileReader());
        Map<String, AudioFileReader> map2 = this.readers;
        SupportedFileFormat supportedFileFormat2 = SupportedFileFormat.FLAC;
        map2.put((Object)supportedFileFormat2.getFilesuffix(), (Object)new FlacFileReader());
        Map<String, AudioFileReader> map3 = this.readers;
        SupportedFileFormat supportedFileFormat3 = SupportedFileFormat.MP3;
        map3.put((Object)supportedFileFormat3.getFilesuffix(), (Object)new MP3FileReader());
        Map<String, AudioFileReader> map4 = this.readers;
        SupportedFileFormat supportedFileFormat4 = SupportedFileFormat.MP4;
        map4.put((Object)supportedFileFormat4.getFilesuffix(), (Object)new Mp4FileReader());
        Map<String, AudioFileReader> map5 = this.readers;
        SupportedFileFormat supportedFileFormat5 = SupportedFileFormat.M4A;
        map5.put((Object)supportedFileFormat5.getFilesuffix(), (Object)new Mp4FileReader());
        Map<String, AudioFileReader> map6 = this.readers;
        SupportedFileFormat supportedFileFormat6 = SupportedFileFormat.M4P;
        map6.put((Object)supportedFileFormat6.getFilesuffix(), (Object)new Mp4FileReader());
        Map<String, AudioFileReader> map7 = this.readers;
        SupportedFileFormat supportedFileFormat7 = SupportedFileFormat.M4B;
        map7.put((Object)supportedFileFormat7.getFilesuffix(), (Object)new Mp4FileReader());
        Map<String, AudioFileReader> map8 = this.readers;
        SupportedFileFormat supportedFileFormat8 = SupportedFileFormat.WAV;
        map8.put((Object)supportedFileFormat8.getFilesuffix(), (Object)new WavFileReader());
        Map<String, AudioFileReader> map9 = this.readers;
        SupportedFileFormat supportedFileFormat9 = SupportedFileFormat.WMA;
        map9.put((Object)supportedFileFormat9.getFilesuffix(), (Object)new AsfFileReader());
        Map<String, AudioFileReader> map10 = this.readers;
        SupportedFileFormat supportedFileFormat10 = SupportedFileFormat.AIF;
        map10.put((Object)supportedFileFormat10.getFilesuffix(), (Object)new AiffFileReader());
        Map<String, AudioFileReader> map11 = this.readers;
        SupportedFileFormat supportedFileFormat11 = SupportedFileFormat.AIFC;
        map11.put((Object)supportedFileFormat11.getFilesuffix(), (Object)new AiffFileReader());
        Map<String, AudioFileReader> map12 = this.readers;
        SupportedFileFormat supportedFileFormat12 = SupportedFileFormat.AIFF;
        map12.put((Object)supportedFileFormat12.getFilesuffix(), (Object)new AiffFileReader());
        Map<String, AudioFileReader> map13 = this.readers;
        SupportedFileFormat supportedFileFormat13 = SupportedFileFormat.DSF;
        map13.put((Object)supportedFileFormat13.getFilesuffix(), (Object)new DsfFileReader());
        RealFileReader realFileReader = new RealFileReader();
        this.readers.put((Object)SupportedFileFormat.RA.getFilesuffix(), (Object)realFileReader);
        this.readers.put((Object)SupportedFileFormat.RM.getFilesuffix(), (Object)realFileReader);
        this.writers.put((Object)supportedFileFormat.getFilesuffix(), (Object)new OggFileWriter());
        this.writers.put((Object)supportedFileFormat2.getFilesuffix(), (Object)new FlacFileWriter());
        this.writers.put((Object)supportedFileFormat3.getFilesuffix(), (Object)new MP3FileWriter());
        this.writers.put((Object)supportedFileFormat4.getFilesuffix(), (Object)new Mp4FileWriter());
        this.writers.put((Object)supportedFileFormat5.getFilesuffix(), (Object)new Mp4FileWriter());
        this.writers.put((Object)supportedFileFormat6.getFilesuffix(), (Object)new Mp4FileWriter());
        this.writers.put((Object)supportedFileFormat7.getFilesuffix(), (Object)new Mp4FileWriter());
        this.writers.put((Object)supportedFileFormat8.getFilesuffix(), (Object)new WavFileWriter());
        this.writers.put((Object)supportedFileFormat9.getFilesuffix(), (Object)new AsfFileWriter());
        this.writers.put((Object)supportedFileFormat10.getFilesuffix(), (Object)new AiffFileWriter());
        this.writers.put((Object)supportedFileFormat11.getFilesuffix(), (Object)new AiffFileWriter());
        this.writers.put((Object)supportedFileFormat12.getFilesuffix(), (Object)new AiffFileWriter());
        this.writers.put((Object)supportedFileFormat13.getFilesuffix(), (Object)new DsfFileWriter());
        this.writers.values().iterator();
        Iterator iterator = this.writers.values().iterator();
        while (iterator.hasNext()) {
            ((AudioFileWriter)iterator.next()).setAudioFileModificationListener((AudioFileModificationListener)this.modificationHandler);
        }
    }

    public static AudioFile read(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        return AudioFileIO.getDefaultAudioFileIO().readFile(file);
    }

    public static AudioFile readAs(File file, String string2) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        return AudioFileIO.getDefaultAudioFileIO().readFileAs(file, string2);
    }

    public static AudioFile readMagic(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        return AudioFileIO.getDefaultAudioFileIO().readFileMagic(file);
    }

    public static void write(AudioFile audioFile) throws CannotWriteException {
        AudioFileIO.getDefaultAudioFileIO().writeFile(audioFile, null);
    }

    public static void writeAs(AudioFile audioFile, String string2) throws CannotWriteException {
        if (string2 != null && !string2.isEmpty()) {
            AudioFileIO.getDefaultAudioFileIO().writeFile(audioFile, string2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a valid target path: ");
        stringBuilder.append(string2);
        throw new CannotWriteException(stringBuilder.toString());
    }

    public void addAudioFileModificationListener(AudioFileModificationListener audioFileModificationListener) {
        this.modificationHandler.addAudioFileModificationListener(audioFileModificationListener);
    }

    public void checkFileExists(File file) throws FileNotFoundException {
        Logger logger = AudioFileIO.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading file:path");
        stringBuilder.append(file.getPath());
        stringBuilder.append(":abs:");
        stringBuilder.append(file.getAbsolutePath());
        logger.config(stringBuilder.toString());
        if (file.exists()) {
            return;
        }
        Logger logger2 = AudioFileIO.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unable to find:");
        stringBuilder2.append(file.getPath());
        logger2.severe(stringBuilder2.toString());
        ErrorMessage errorMessage = ErrorMessage.UNABLE_TO_FIND_FILE;
        Object[] arrobject = new Object[]{file.getPath()};
        throw new FileNotFoundException(errorMessage.getMsg(arrobject));
    }

    public void deleteTag(AudioFile audioFile) throws CannotReadException, CannotWriteException {
        String string2 = Utils.getExtension(audioFile.getFile());
        Object object = this.writers.get((Object)string2);
        if (object != null) {
            ((AudioFileWriter)object).delete(audioFile);
            return;
        }
        throw new CannotWriteException(ErrorMessage.NO_DELETER_FOR_THIS_FORMAT.getMsg(string2));
    }

    public AudioFile readFile(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        this.checkFileExists(file);
        String string2 = Utils.getExtension(file);
        AudioFileReader audioFileReader = (AudioFileReader)this.readers.get((Object)string2);
        if (audioFileReader != null) {
            AudioFile audioFile = audioFileReader.read(file);
            audioFile.setExt(string2);
            return audioFile;
        }
        throw new CannotReadException(ErrorMessage.NO_READER_FOR_THIS_FORMAT.getMsg(string2));
    }

    public AudioFile readFileAs(File file, String string2) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        this.checkFileExists(file);
        AudioFileReader audioFileReader = (AudioFileReader)this.readers.get((Object)string2);
        if (audioFileReader != null) {
            AudioFile audioFile = audioFileReader.read(file);
            audioFile.setExt(string2);
            return audioFile;
        }
        throw new CannotReadException(ErrorMessage.NO_READER_FOR_THIS_FORMAT.getMsg(string2));
    }

    public AudioFile readFileMagic(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        this.checkFileExists(file);
        String string2 = Utils.getMagicExtension(file);
        AudioFileReader audioFileReader = (AudioFileReader)this.readers.get((Object)string2);
        if (audioFileReader != null) {
            AudioFile audioFile = audioFileReader.read(file);
            audioFile.setExt(string2);
            return audioFile;
        }
        throw new CannotReadException(ErrorMessage.NO_READER_FOR_THIS_FORMAT.getMsg(string2));
    }

    public void removeAudioFileModificationListener(AudioFileModificationListener audioFileModificationListener) {
        this.modificationHandler.removeAudioFileModificationListener(audioFileModificationListener);
    }

    public void writeFile(AudioFile audioFile, String string2) throws CannotWriteException {
        AudioFileWriter audioFileWriter;
        String string3 = audioFile.getExt();
        if (string2 != null && !string2.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(".");
            stringBuilder.append(string3);
            File file = new File(stringBuilder.toString());
            try {
                Utils.copyThrowsOnException(audioFile.getFile(), file);
                audioFile.setFile(file);
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error While Copying");
                stringBuilder2.append(iOException.getMessage());
                throw new CannotWriteException(stringBuilder2.toString());
            }
        }
        if ((audioFileWriter = (AudioFileWriter)this.writers.get((Object)string3)) != null) {
            audioFileWriter.write(audioFile);
            return;
        }
        throw new CannotWriteException(ErrorMessage.NO_WRITER_FOR_THIS_FORMAT.getMsg(string3));
    }
}

