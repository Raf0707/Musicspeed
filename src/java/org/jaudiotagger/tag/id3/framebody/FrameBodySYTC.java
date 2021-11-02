/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.SynchronisedTempoCode;
import org.jaudiotagger.tag.datatype.SynchronisedTempoCodeList;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTimestampTypes;

public class FrameBodySYTC
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final int MILLISECONDS = 2;
    public static final int MPEG_FRAMES = 1;

    public FrameBodySYTC() {
        this.setObjectValue("TimeStampFormat", 2);
    }

    public FrameBodySYTC(int n2, byte[] arrby) {
        this.setObjectValue("TimeStampFormat", n2);
        this.setObjectValue("SynchronisedTempoList", arrby);
    }

    public FrameBodySYTC(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodySYTC(FrameBodySYTC frameBodySYTC) {
        super(frameBodySYTC);
    }

    public void addTempo(long l2, int n2) {
        this.removeTempo(l2);
        List list = (List)this.getObjectValue("SynchronisedTempoList");
        boolean bl = list.isEmpty();
        int n3 = 0;
        if (!bl) {
            long l3 = ((SynchronisedTempoCode)list.get(0)).getTimestamp() LCMP l2;
            n3 = 0;
            if (l3 <= 0) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext() && l2 >= ((SynchronisedTempoCode)iterator.next()).getTimestamp()) {
                    ++n3;
                }
            }
        }
        SynchronisedTempoCode synchronisedTempoCode = new SynchronisedTempoCode("SynchronisedTempo", this, n2, l2);
        list.add(n3, (Object)synchronisedTempoCode);
    }

    public void clearTempi() {
        ((List)this.getObjectValue("SynchronisedTempoList")).clear();
    }

    @Override
    public String getIdentifier() {
        return "SYTC";
    }

    public Map<Long, Integer> getTempi() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SynchronisedTempoCode synchronisedTempoCode : (List)this.getObjectValue("SynchronisedTempoList")) {
            linkedHashMap.put((Object)synchronisedTempoCode.getTimestamp(), (Object)synchronisedTempoCode.getTempo());
        }
        return Collections.unmodifiableMap((Map)linkedHashMap);
    }

    public int getTimestampFormat() {
        return ((Number)this.getObjectValue("TimeStampFormat")).intValue();
    }

    public List<Long> getTimestamps() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = ((List)this.getObjectValue("SynchronisedTempoList")).iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((SynchronisedTempoCode)iterator.next()).getTimestamp());
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        super.read(byteBuffer);
        Iterator iterator = ((List)this.getObjectValue("SynchronisedTempoList")).iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            SynchronisedTempoCode synchronisedTempoCode = (SynchronisedTempoCode)iterator.next();
            if (synchronisedTempoCode.getTimestamp() < l2) {
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Synchronised tempo codes are not in chronological order. ");
                stringBuilder.append(l2);
                stringBuilder.append(" is followed by ");
                stringBuilder.append(synchronisedTempoCode.getTimestamp());
                stringBuilder.append(".");
                logger.warning(stringBuilder.toString());
            }
            l2 = synchronisedTempoCode.getTimestamp();
        }
    }

    public boolean removeTempo(long l2) {
        ListIterator listIterator = ((List)this.getObjectValue("SynchronisedTempoList")).listIterator();
        boolean bl = false;
        while (listIterator.hasNext()) {
            SynchronisedTempoCode synchronisedTempoCode = (SynchronisedTempoCode)listIterator.next();
            if (l2 == synchronisedTempoCode.getTimestamp()) {
                listIterator.remove();
                bl = true;
            }
            if (l2 <= synchronisedTempoCode.getTimestamp()) continue;
        }
        return bl;
    }

    public void setTimestampFormat(int n2) {
        if (EventTimingTimestampTypes.getInstanceOf().getValueForId(n2) != null) {
            this.setObjectValue("TimeStampFormat", n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timestamp format must be 1 or 2 (ID3v2.4, 4.7): ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TimeStampFormat", this, 1));
        this.objectList.add((Object)new SynchronisedTempoCodeList(this));
    }
}

