/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.TreeSet
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Logger;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.HashMapInterface;
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.ChannelTypes;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTimestampTypes;
import org.jaudiotagger.tag.id3.valuepair.EventTimingTypes;
import org.jaudiotagger.tag.id3.valuepair.InterpolationTypes;
import org.jaudiotagger.tag.id3.valuepair.ReceivedAsTypes;
import org.jaudiotagger.tag.id3.valuepair.SynchronisedLyricsContentType;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;
import org.jaudiotagger.tag.reference.GenreTypes;
import org.jaudiotagger.tag.reference.PictureTypes;
import org.jaudiotagger.utils.EqualsUtil;

public class NumberHashMap
extends NumberFixedLength
implements HashMapInterface<Integer, String> {
    private boolean hasEmptyValue = false;
    private Map<Integer, String> keyToValue = null;
    private Map<String, Integer> valueToKey = null;

    public NumberHashMap(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody, n2);
        if (string2.equals((Object)"Genre")) {
            this.valueToKey = GenreTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = GenreTypes.getInstanceOf().getIdToValueMap();
            this.hasEmptyValue = true;
            return;
        }
        if (string2.equals((Object)"TextEncoding")) {
            this.valueToKey = TextEncoding.getInstanceOf().getValueToIdMap();
            this.keyToValue = TextEncoding.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"InterpolationMethod")) {
            this.valueToKey = InterpolationTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = InterpolationTypes.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"PictureType")) {
            this.valueToKey = PictureTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = PictureTypes.getInstanceOf().getIdToValueMap();
            this.hasEmptyValue = true;
            return;
        }
        if (string2.equals((Object)"TypeOfEvent")) {
            this.valueToKey = EventTimingTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = EventTimingTypes.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"TimeStampFormat")) {
            this.valueToKey = EventTimingTimestampTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = EventTimingTimestampTypes.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"TypeOfChannel")) {
            this.valueToKey = ChannelTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = ChannelTypes.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"RecievedAs")) {
            this.valueToKey = ReceivedAsTypes.getInstanceOf().getValueToIdMap();
            this.keyToValue = ReceivedAsTypes.getInstanceOf().getIdToValueMap();
            return;
        }
        if (string2.equals((Object)"contentType")) {
            this.valueToKey = SynchronisedLyricsContentType.getInstanceOf().getValueToIdMap();
            this.keyToValue = SynchronisedLyricsContentType.getInstanceOf().getIdToValueMap();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hashmap identifier not defined in this class: ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public NumberHashMap(NumberHashMap numberHashMap) {
        super(numberHashMap);
        this.hasEmptyValue = numberHashMap.hasEmptyValue;
        this.keyToValue = numberHashMap.keyToValue;
        this.valueToKey = numberHashMap.valueToKey;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NumberHashMap)) {
            return false;
        }
        NumberHashMap numberHashMap = (NumberHashMap)object;
        return EqualsUtil.areEqual(this.hasEmptyValue, numberHashMap.hasEmptyValue) && EqualsUtil.areEqual(this.keyToValue, numberHashMap.keyToValue) && EqualsUtil.areEqual(this.valueToKey, numberHashMap.valueToKey) && super.equals(numberHashMap);
    }

    @Override
    public Map<Integer, String> getKeyToValue() {
        return this.keyToValue;
    }

    @Override
    public Map<String, Integer> getValueToKey() {
        return this.valueToKey;
    }

    @Override
    public Iterator<String> iterator() {
        if (this.keyToValue == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet(this.keyToValue.values());
        if (this.hasEmptyValue) {
            treeSet.add((Object)"");
        }
        return treeSet.iterator();
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        super.readByteArray(arrby, n2);
        Integer n3 = ((Long)this.value).intValue();
        if (!this.keyToValue.containsKey((Object)n3)) {
            if (this.hasEmptyValue) {
                if (this.identifier.equals((Object)"PictureType")) {
                    Logger logger = AbstractDataType.logger;
                    ErrorMessage errorMessage = ErrorMessage.MP3_PICTURE_TYPE_INVALID;
                    Object[] arrobject = new Object[]{this.value};
                    logger.warning(errorMessage.getMsg(arrobject));
                    return;
                }
            } else {
                ErrorMessage errorMessage = ErrorMessage.MP3_REFERENCE_KEY_INVALID;
                Object[] arrobject = new Object[]{this.identifier, n3};
                throw new InvalidDataTypeException(errorMessage.getMsg(arrobject));
            }
        }
    }

    @Override
    public void setValue(Object object) {
        if (object instanceof Byte) {
            this.value = (long)((Byte)object).byteValue();
            return;
        }
        if (object instanceof Short) {
            this.value = (long)((Short)object).shortValue();
            return;
        }
        if (object instanceof Integer) {
            this.value = (long)((Integer)object).intValue();
            return;
        }
        this.value = object;
    }

    @Override
    public String toString() {
        Object object = this.value;
        if (object == null) {
            return "";
        }
        if (this.keyToValue.get(object) == null) {
            return "";
        }
        return (String)this.keyToValue.get(this.value);
    }
}

