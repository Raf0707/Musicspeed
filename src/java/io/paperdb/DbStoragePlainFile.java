/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Kryo$DefaultInstantiatorStrategy
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer
 *  com.esotericsoftware.kryo.serializers.FieldSerializerConfig
 *  com.esotericsoftware.minlog.Log
 *  de.javakaffee.kryoserializers.ArraysAsListSerializer
 *  de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer
 *  de.javakaffee.kryoserializers.UUIDSerializer
 *  de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer
 *  h.c.c.d
 *  io.paperdb.serializer.NoArgCollectionSerializer
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  java.util.UUID
 */
package io.paperdb;

import android.content.Context;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.minlog.Log;
import de.javakaffee.kryoserializers.ArraysAsListSerializer;
import de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer;
import de.javakaffee.kryoserializers.UUIDSerializer;
import de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer;
import h.c.c.b;
import h.c.c.d;
import io.paperdb.KeyLocker;
import io.paperdb.PaperDbException;
import io.paperdb.PaperTable;
import io.paperdb.serializer.NoArgCollectionSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class DbStoragePlainFile {
    private KeyLocker keyLocker = new KeyLocker();
    private final HashMap<Class, Serializer> mCustomSerializers;
    private final String mDbPath;
    private final ThreadLocal<Kryo> mKryo = new ThreadLocal<Kryo>(){

        protected Kryo initialValue() {
            return DbStoragePlainFile.this.createKryoInstance(false);
        }
    };
    private volatile boolean mPaperDirIsCreated;

    DbStoragePlainFile(Context context, String string2, HashMap<Class, Serializer> hashMap) {
        this.mCustomSerializers = hashMap;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)context.getFilesDir());
        stringBuilder.append(File.separator);
        stringBuilder.append(string2);
        this.mDbPath = stringBuilder.toString();
    }

    DbStoragePlainFile(String string2, String string3, HashMap<Class, Serializer> hashMap) {
        this.mCustomSerializers = hashMap;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(File.separator);
        stringBuilder.append(string3);
        this.mDbPath = stringBuilder.toString();
    }

    private void assertInit() {
        if (!this.mPaperDirIsCreated) {
            this.createPaperDir();
            this.mPaperDirIsCreated = true;
        }
    }

    private Kryo createKryoInstance(boolean bl) {
        Kryo kryo = new Kryo();
        if (bl) {
            kryo.getFieldSerializerConfig().setOptimizedGenerics(true);
        }
        kryo.register(PaperTable.class);
        kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
        kryo.setReferences(false);
        kryo.register(Arrays.asList((Object[])new String[]{""}).getClass(), (Serializer)new ArraysAsListSerializer());
        UnmodifiableCollectionsSerializer.registerSerializers((Kryo)kryo);
        SynchronizedCollectionsSerializer.registerSerializers((Kryo)kryo);
        kryo.addDefaultSerializer(new ArrayList().subList(0, 0).getClass(), (Serializer)new NoArgCollectionSerializer());
        kryo.addDefaultSerializer(new LinkedList().subList(0, 0).getClass(), (Serializer)new NoArgCollectionSerializer());
        kryo.register(UUID.class, (Serializer)new UUIDSerializer());
        for (Class class_ : this.mCustomSerializers.keySet()) {
            kryo.register(class_, (Serializer)this.mCustomSerializers.get((Object)class_));
        }
        kryo.setInstantiatorStrategy((b)new Kryo.DefaultInstantiatorStrategy((b)new d()));
        return kryo;
    }

    private void createPaperDir() {
        if (!new File(this.mDbPath).exists()) {
            if (new File(this.mDbPath).mkdirs()) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't create Paper dir: ");
            stringBuilder.append(this.mDbPath);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private static boolean deleteDirectory(String string2) {
        File[] arrfile;
        File file = new File(string2);
        if (file.exists() && (arrfile = file.listFiles()) != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory()) {
                    DbStoragePlainFile.deleteDirectory(file2.toString());
                    continue;
                }
                file2.delete();
            }
        }
        return file.delete();
    }

    private boolean existsInternal(String string2) {
        this.assertInit();
        return this.getOriginalFile(string2).exists();
    }

    private Kryo getKryo() {
        return (Kryo)this.mKryo.get();
    }

    private File getOriginalFile(String string2) {
        return new File(this.getOriginalFilePath(string2));
    }

    private File makeBackupFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        return new File(stringBuilder.toString());
    }

    private <E> E readContent(File file, Kryo kryo) throws FileNotFoundException, KryoException {
        Input input = new Input((InputStream)new FileInputStream(file));
        try {
            Object t2 = ((PaperTable)kryo.readObject((Input)input, PaperTable.class)).mContent;
            return (E)t2;
        }
        finally {
            input.close();
        }
    }

    private <E> E readTableFile(String string2, File file) {
        void var3_7;
        E e2;
        try {
            e2 = this.readContent(file, this.getKryo());
        }
        catch (ClassCastException classCastException) {
        }
        catch (KryoException kryoException) {
        }
        catch (FileNotFoundException fileNotFoundException) {
            // empty catch block
        }
        return e2;
        if (var3_7 instanceof KryoException) {
            E e3;
            try {
                e3 = this.readContent(file, this.createKryoInstance(true));
            }
            catch (ClassCastException classCastException) {
            }
            catch (KryoException kryoException) {
            }
            catch (FileNotFoundException fileNotFoundException) {
                // empty catch block
            }
            return e3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't read/deserialize file ");
        stringBuilder.append((Object)file);
        stringBuilder.append(" for table ");
        stringBuilder.append(string2);
        throw new PaperDbException(stringBuilder.toString(), (Throwable)var3_7);
    }

    /*
     * Exception decompiling
     */
    private static void sync(FileOutputStream var0) {
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

    private <E> void writeTableFile(String string2, PaperTable<E> paperTable, File file, File file2) {
        void var7_9;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Output output = new Output((OutputStream)fileOutputStream);
            this.getKryo().writeObject(output, paperTable);
            output.flush();
            fileOutputStream.flush();
            DbStoragePlainFile.sync(fileOutputStream);
            output.close();
            file2.delete();
            return;
        }
        catch (KryoException kryoException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (file.exists() && !file.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't clean up partially-written file ");
            stringBuilder.append((Object)file);
            throw new PaperDbException(stringBuilder.toString(), (Throwable)var7_9);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't save table: ");
        stringBuilder.append(string2);
        stringBuilder.append(". Backed up table will be used on next read attempt");
        throw new PaperDbException(stringBuilder.toString(), (Throwable)var7_9);
    }

    void deleteIfExists(String string2) {
        File file;
        block5 : {
            block4 : {
                try {
                    this.keyLocker.acquire(string2);
                    this.assertInit();
                    file = this.getOriginalFile(string2);
                    boolean bl = file.exists();
                    if (bl) break block4;
                }
                catch (Throwable throwable) {
                    this.keyLocker.release(string2);
                    throw throwable;
                }
                this.keyLocker.release(string2);
                return;
            }
            boolean bl = file.delete();
            if (!bl) break block5;
            this.keyLocker.release(string2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't delete file ");
        stringBuilder.append((Object)file);
        stringBuilder.append(" for table ");
        stringBuilder.append(string2);
        throw new PaperDbException(stringBuilder.toString());
    }

    public void destroy() {
        DbStoragePlainFile dbStoragePlainFile = this;
        synchronized (dbStoragePlainFile) {
            this.assertInit();
            if (!DbStoragePlainFile.deleteDirectory(this.mDbPath)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't delete Paper dir ");
                stringBuilder.append(this.mDbPath);
                android.util.Log.e((String)"paperdb", (String)stringBuilder.toString());
            }
            this.mPaperDirIsCreated = false;
            return;
        }
    }

    boolean exists(String string2) {
        try {
            this.keyLocker.acquire(string2);
            boolean bl = this.existsInternal(string2);
            return bl;
        }
        finally {
            this.keyLocker.release(string2);
        }
    }

    List<String> getAllKeys() {
        DbStoragePlainFile dbStoragePlainFile = this;
        synchronized (dbStoragePlainFile) {
            block7 : {
                this.assertInit();
                Object[] arrobject = new File(this.mDbPath).list();
                if (arrobject == null) break block7;
                int n2 = 0;
                do {
                    if (n2 >= arrobject.length) break;
                    arrobject[n2] = arrobject[n2].replace((CharSequence)".pt", (CharSequence)"");
                    ++n2;
                } while (true);
                List list = Arrays.asList((Object[])arrobject);
                return list;
            }
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
    }

    String getOriginalFilePath(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mDbPath);
        stringBuilder.append(File.separator);
        stringBuilder.append(string2);
        stringBuilder.append(".pt");
        return stringBuilder.toString();
    }

    String getRootFolderPath() {
        return this.mDbPath;
    }

    <E> void insert(String string2, E e2) {
        try {
            this.keyLocker.acquire(string2);
            this.assertInit();
            PaperTable<E> paperTable = new PaperTable<E>(e2);
            File file = this.getOriginalFile(string2);
            File file2 = this.makeBackupFile(file);
            if (file.exists()) {
                if (!file2.exists()) {
                    if (!file.renameTo(file2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Couldn't rename file ");
                        stringBuilder.append((Object)file);
                        stringBuilder.append(" to backup file ");
                        stringBuilder.append((Object)file2);
                        throw new PaperDbException(stringBuilder.toString());
                    }
                } else {
                    file.delete();
                }
            }
            this.writeTableFile(string2, paperTable, file, file2);
            return;
        }
        finally {
            this.keyLocker.release(string2);
        }
    }

    long lastModified(String string2) {
        long l2;
        try {
            this.keyLocker.acquire(string2);
            this.assertInit();
            File file = this.getOriginalFile(string2);
            l2 = file.exists() ? file.lastModified() : -1L;
        }
        catch (Throwable throwable) {
            this.keyLocker.release(string2);
            throw throwable;
        }
        this.keyLocker.release(string2);
        return l2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    <E> E select(String string2) {
        File file;
        E e2;
        block6 : {
            boolean bl;
            this.keyLocker.acquire(string2);
            this.assertInit();
            file = this.getOriginalFile(string2);
            File file2 = this.makeBackupFile(file);
            if (file2.exists()) {
                file.delete();
                file2.renameTo(file);
            }
            if (bl = this.existsInternal(string2)) break block6;
            e2 = null;
            do {
                return e2;
                break;
            } while (true);
        }
        try {
            e2 = this.readTableFile(string2, file);
            return e2;
        }
        finally {
            this.keyLocker.release(string2);
        }
    }

    void setLogLevel(int n2) {
        Log.set((int)n2);
    }

}

