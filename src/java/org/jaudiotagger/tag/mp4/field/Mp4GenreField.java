/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField;
import org.jaudiotagger.tag.reference.GenreTypes;

public class Mp4GenreField
extends Mp4TagTextNumberField {
    public Mp4GenreField(String string2) {
        super(Mp4FieldKey.GENRE.getFieldName(), string2);
        try {
            ArrayList arrayList;
            short s2 = Short.parseShort((String)string2);
            if (s2 <= GenreTypes.getMaxStandardGenreId()) {
                ArrayList arrayList2;
                this.numbers = arrayList2 = new ArrayList();
                arrayList2.add((Object)((short)(s2 + 1)));
                return;
            }
            this.numbers = arrayList = new ArrayList();
            arrayList.add((Object)1);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            ArrayList arrayList;
            Integer n2 = GenreTypes.getInstanceOf().getIdForValue(string2);
            if (n2 != null && n2 <= GenreTypes.getMaxStandardGenreId()) {
                ArrayList arrayList3;
                this.numbers = arrayList3 = new ArrayList();
                arrayList3.add((Object)((short)(1 + n2)));
                return;
            }
            this.numbers = arrayList = new ArrayList();
            arrayList.add((Object)1);
            return;
        }
    }

    public Mp4GenreField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    /*
     * Exception decompiling
     */
    public static boolean isValidGenre(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13.1 : INVOKESTATIC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        Mp4DataBox mp4DataBox = new Mp4DataBox(mp4BoxHeader, byteBuffer);
        this.dataSize = mp4BoxHeader.getDataLength();
        List<Short> list = mp4DataBox.getNumbers();
        this.numbers = list;
        if (list.size() > 0) {
            String string2;
            short s2 = (Short)this.numbers.get(0);
            this.content = string2 = GenreTypes.getInstanceOf().getValueForId(s2 - 1);
            if (string2 == null) {
                Logger logger = Mp4TagField.logger;
                ErrorMessage errorMessage = ErrorMessage.MP4_GENRE_OUT_OF_RANGE;
                Object[] arrobject = new Object[]{(int)s2};
                logger.warning(errorMessage.getMsg(arrobject));
                return;
            }
        } else {
            Logger logger = Mp4TagField.logger;
            ErrorMessage errorMessage = ErrorMessage.MP4_NO_GENREID_FOR_GENRE;
            Object[] arrobject = new Object[]{mp4BoxHeader.getDataLength()};
            logger.warning(errorMessage.getMsg(arrobject));
        }
    }
}

