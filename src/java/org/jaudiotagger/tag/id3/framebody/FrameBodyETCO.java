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
 *  java.lang.System
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 *  java.util.Set
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.EventTimingCode;
import org.jaudiotagger.tag.datatype.EventTimingCodeList;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTimestampTypes;

public class FrameBodyETCO
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final int MILLISECONDS = 2;
    public static final int MPEG_FRAMES = 1;

    public FrameBodyETCO() {
        this.setObjectValue("TimeStampFormat", 2);
    }

    public FrameBodyETCO(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyETCO(FrameBodyETCO frameBodyETCO) {
        super(frameBodyETCO);
    }

    private void resolveRelativeTimestamps() {
        Iterator iterator = ((List)this.getObjectValue("TimedEventList")).iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            EventTimingCode eventTimingCode = (EventTimingCode)iterator.next();
            if (eventTimingCode.getTimestamp() != 0L) {
                l2 = eventTimingCode.getTimestamp();
            }
            eventTimingCode.setTimestamp(l2);
        }
    }

    private static /* varargs */ Set<Integer> toSet(int ... arrn) {
        HashSet hashSet = new HashSet();
        int n2 = arrn.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            hashSet.add((Object)arrn[i2]);
        }
        return hashSet;
    }

    public /* varargs */ void addTimingCode(long l2, int ... arrn) {
        List list;
        int n2;
        list = (List)this.getObjectValue("TimedEventList");
        if (!list.isEmpty() && ((EventTimingCode)list.get(0)).getTimestamp() <= l2) {
            Iterator iterator = list.iterator();
            long l3 = 0L;
            n2 = 0;
            while (iterator.hasNext()) {
                EventTimingCode eventTimingCode = (EventTimingCode)iterator.next();
                if (eventTimingCode.getTimestamp() != 0L) {
                    l3 = eventTimingCode.getTimestamp();
                }
                if (l2 >= l3) {
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            n2 = 0;
        }
        int n3 = arrn.length;
        int n4 = n2;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5 = arrn[i2];
            EventTimingCode eventTimingCode = new EventTimingCode("TimedEvent", this, n5, l2);
            list.add(n4, (Object)eventTimingCode);
            ++n4;
        }
    }

    public void clearTimingCodes() {
        ((List)this.getObjectValue("TimedEventList")).clear();
    }

    @Override
    public String getIdentifier() {
        return "ETCO";
    }

    public int getTimestampFormat() {
        return ((Number)this.getObjectValue("TimeStampFormat")).intValue();
    }

    public /* varargs */ List<Long> getTimestamps(int ... arrn) {
        Set<Integer> set = FrameBodyETCO.toSet(arrn);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = ((List)this.getObjectValue("TimedEventList")).iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            EventTimingCode eventTimingCode = (EventTimingCode)iterator.next();
            if (eventTimingCode.getTimestamp() != 0L) {
                l2 = eventTimingCode.getTimestamp();
            }
            if (!set.contains((Object)eventTimingCode.getType())) continue;
            arrayList.add((Object)l2);
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public Map<Long, int[]> getTimingCodes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = ((List)this.getObjectValue("TimedEventList")).iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            EventTimingCode eventTimingCode = (EventTimingCode)iterator.next();
            if (eventTimingCode.getTimestamp() != 0L) {
                l2 = eventTimingCode.getTimestamp();
            }
            int[] arrn = (int[])linkedHashMap.get((Object)l2);
            if (arrn == null) {
                Long l3 = l2;
                int[] arrn2 = new int[]{eventTimingCode.getType()};
                linkedHashMap.put((Object)l3, (Object)arrn2);
                continue;
            }
            int n2 = 1 + arrn.length;
            int[] arrn3 = new int[n2];
            System.arraycopy((Object)arrn, (int)0, (Object)arrn3, (int)0, (int)arrn.length);
            arrn3[n2 - 1] = eventTimingCode.getType();
            linkedHashMap.put((Object)l2, (Object)arrn3);
        }
        return Collections.unmodifiableMap((Map)linkedHashMap);
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        super.read(byteBuffer);
        Iterator iterator = ((List)this.getObjectValue("TimedEventList")).iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            EventTimingCode eventTimingCode = (EventTimingCode)iterator.next();
            long l3 = eventTimingCode.getTimestamp() == 0L ? l2 : eventTimingCode.getTimestamp();
            if (eventTimingCode.getTimestamp() < l2) {
                Logger logger = AbstractTagItem.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Event codes are not in chronological order. ");
                stringBuilder.append(l2);
                stringBuilder.append(" is followed by ");
                stringBuilder.append(eventTimingCode.getTimestamp());
                stringBuilder.append(".");
                logger.warning(stringBuilder.toString());
            }
            l2 = l3;
        }
    }

    public /* varargs */ boolean removeTimingCode(long l2, int ... arrn) {
        this.resolveRelativeTimestamps();
        Set<Integer> set = FrameBodyETCO.toSet(arrn);
        ListIterator listIterator = ((List)this.getObjectValue("TimedEventList")).listIterator();
        boolean bl = false;
        while (listIterator.hasNext()) {
            EventTimingCode eventTimingCode = (EventTimingCode)listIterator.next();
            if (l2 == eventTimingCode.getTimestamp() && set.contains((Object)eventTimingCode.getType())) {
                listIterator.remove();
                bl = true;
            }
            if (l2 <= eventTimingCode.getTimestamp()) continue;
        }
        return bl;
    }

    public void setTimestampFormat(int n2) {
        if (EventTimingTimestampTypes.getInstanceOf().getValueForId(n2) != null) {
            this.setObjectValue("TimeStampFormat", n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timestamp format must be 1 or 2 (ID3v2.4, 4.5): ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TimeStampFormat", this, 1));
        this.objectList.add((Object)new EventTimingCodeList(this));
    }
}

