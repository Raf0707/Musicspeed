/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTagField
 */
package org.jaudiotagger.tag.vorbiscomment;

import java.io.IOException;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTagField;

public class VorbisCommentReader {
    public static final int FIELD_COMMENT_LENGTH_LENGTH = 4;
    public static final int FIELD_USER_COMMENT_LIST_LENGTH = 4;
    public static final int FIELD_VENDOR_LENGTH_LENGTH = 4;
    public static final int FIELD_VENDOR_LENGTH_POS = 0;
    public static final int FIELD_VENDOR_STRING_POS = 4;
    private static final int JAUDIOTAGGER_MAX_COMMENT_LENGTH = 10000000;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.vorbiscomment.VorbisCommentReader");

    public VorbisCommentTag read(byte[] arrby, boolean bl) throws IOException, CannotReadException {
        VorbisCommentTag vorbisCommentTag = new VorbisCommentTag();
        byte[] arrby2 = new byte[4];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)4);
        int n2 = Utils.getIntLE(arrby2);
        byte[] arrby3 = new byte[n2];
        System.arraycopy((Object)arrby, (int)4, (Object)arrby3, (int)0, (int)n2);
        int n3 = n2 + 4;
        vorbisCommentTag.setVendor(new String(arrby3, "UTF-8"));
        Logger logger = VorbisCommentReader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vendor is:");
        stringBuilder.append(vorbisCommentTag.getVendor());
        logger.config(stringBuilder.toString());
        byte[] arrby4 = new byte[4];
        System.arraycopy((Object)arrby, (int)n3, (Object)arrby4, (int)0, (int)4);
        int n4 = n3 + 4;
        int n5 = Utils.getIntLE(arrby4);
        Logger logger2 = VorbisCommentReader.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Number of user comments:");
        stringBuilder2.append(n5);
        logger2.config(stringBuilder2.toString());
        for (int i2 = 0; i2 < n5; ++i2) {
            byte[] arrby5 = new byte[4];
            System.arraycopy((Object)arrby, (int)n4, (Object)arrby5, (int)0, (int)4);
            n4 += 4;
            int n6 = Utils.getIntLE(arrby5);
            Logger logger3 = VorbisCommentReader.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Next Comment Length:");
            stringBuilder3.append(n6);
            logger3.config(stringBuilder3.toString());
            if (n6 > 10000000) {
                Logger logger4 = VorbisCommentReader.logger;
                ErrorMessage errorMessage = ErrorMessage.VORBIS_COMMENT_LENGTH_TOO_LARGE;
                Object[] arrobject = new Object[]{n6};
                logger4.warning(errorMessage.getMsg(arrobject));
                break;
            }
            if (n6 > arrby.length) {
                Logger logger5 = VorbisCommentReader.logger;
                ErrorMessage errorMessage = ErrorMessage.VORBIS_COMMENT_LENGTH_LARGE_THAN_HEADER;
                Object[] arrobject = new Object[]{n6, arrby.length};
                logger5.warning(errorMessage.getMsg(arrobject));
                break;
            }
            byte[] arrby6 = new byte[n6];
            System.arraycopy((Object)arrby, (int)n4, (Object)arrby6, (int)0, (int)n6);
            n4 += n6;
            VorbisCommentTagField vorbisCommentTagField = new VorbisCommentTagField(arrby6);
            Logger logger6 = VorbisCommentReader.logger;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Adding:");
            stringBuilder4.append(vorbisCommentTagField.getId());
            logger6.config(stringBuilder4.toString());
            vorbisCommentTag.addField((TagField)vorbisCommentTagField);
        }
        if (bl) {
            if ((1 & arrby[n4]) == 1) {
                return vorbisCommentTag;
            }
            ErrorMessage errorMessage = ErrorMessage.OGG_VORBIS_NO_FRAMING_BIT;
            Object[] arrobject = new Object[]{1 & arrby[n4]};
            throw new CannotReadException(errorMessage.getMsg(arrobject));
        }
        return vorbisCommentTag;
    }
}

