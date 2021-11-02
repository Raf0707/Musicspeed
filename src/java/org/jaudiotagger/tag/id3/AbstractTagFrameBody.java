/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.ListIterator
 */
package org.jaudiotagger.tag.id3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3Tags;

public abstract class AbstractTagFrameBody
extends AbstractTagItem {
    private AbstractTagFrame header;
    protected ArrayList<AbstractDataType> objectList = new ArrayList();

    protected AbstractTagFrameBody() {
        this.setupObjectList();
    }

    protected AbstractTagFrameBody(AbstractTagFrameBody abstractTagFrameBody) {
        for (int i2 = 0; i2 < abstractTagFrameBody.objectList.size(); ++i2) {
            AbstractDataType abstractDataType = (AbstractDataType)ID3Tags.copyObject(abstractTagFrameBody.objectList.get(i2));
            abstractDataType.setBody(this);
            this.objectList.add((Object)abstractDataType);
        }
    }

    public void createStructure() {
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AbstractTagFrameBody)) {
            return false;
        }
        AbstractTagFrameBody abstractTagFrameBody = (AbstractTagFrameBody)object;
        boolean bl = this.objectList.equals(abstractTagFrameBody.objectList);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public String getBriefDescription() {
        Iterator iterator = this.objectList.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            AbstractDataType abstractDataType = (AbstractDataType)iterator.next();
            if (abstractDataType.toString() == null || abstractDataType.toString().length() <= 0) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(abstractDataType.getIdentifier());
            stringBuilder.append("=\"");
            stringBuilder.append(abstractDataType.toString());
            stringBuilder.append("\"; ");
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public AbstractTagFrame getHeader() {
        return this.header;
    }

    public final String getLongDescription() {
        Iterator iterator = this.objectList.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            AbstractDataType abstractDataType = (AbstractDataType)iterator.next();
            if (abstractDataType.toString() == null || abstractDataType.toString().length() <= 0) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(abstractDataType.getIdentifier());
            stringBuilder.append(" = ");
            stringBuilder.append(abstractDataType.toString());
            stringBuilder.append("\n");
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public final AbstractDataType getObject(String string2) {
        ListIterator listIterator = this.objectList.listIterator();
        while (listIterator.hasNext()) {
            AbstractDataType abstractDataType = (AbstractDataType)listIterator.next();
            if (!abstractDataType.getIdentifier().equals((Object)string2)) continue;
            return abstractDataType;
        }
        return null;
    }

    public final Object getObjectValue(String string2) {
        return this.getObject(string2).getValue();
    }

    @Override
    public int getSize() {
        ListIterator listIterator = this.objectList.listIterator();
        int n2 = 0;
        while (listIterator.hasNext()) {
            n2 += ((AbstractDataType)listIterator.next()).getSize();
        }
        return n2;
    }

    public final byte getTextEncoding() {
        AbstractDataType abstractDataType = this.getObject("TextEncoding");
        if (abstractDataType != null) {
            return ((Long)abstractDataType.getValue()).byteValue();
        }
        return 0;
    }

    public String getUserFriendlyValue() {
        return this.toString();
    }

    @Override
    public boolean isSubsetOf(Object object) {
        if (!(object instanceof AbstractTagFrameBody)) {
            return false;
        }
        ArrayList<AbstractDataType> arrayList = ((AbstractTagFrameBody)object).objectList;
        for (AbstractDataType abstractDataType : this.objectList) {
            if (abstractDataType.getValue() == null || arrayList.contains((Object)abstractDataType)) continue;
            return false;
        }
        return true;
    }

    public Iterator iterator() {
        return this.objectList.iterator();
    }

    public void setHeader(AbstractTagFrame abstractTagFrame) {
        this.header = abstractTagFrame;
    }

    public final void setObjectValue(String string2, Object object) {
        ListIterator listIterator = this.objectList.listIterator();
        while (listIterator.hasNext()) {
            AbstractDataType abstractDataType = (AbstractDataType)listIterator.next();
            if (!abstractDataType.getIdentifier().equals((Object)string2)) continue;
            abstractDataType.setValue(object);
        }
    }

    public final void setTextEncoding(byte by) {
        this.setObjectValue("TextEncoding", by);
    }

    protected abstract void setupObjectList();

    public String toString() {
        return this.getBriefDescription();
    }
}

