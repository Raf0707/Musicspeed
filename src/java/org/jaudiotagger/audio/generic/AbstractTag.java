/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.audio.generic;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.audio.generic.AbstractTag;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.images.Artwork;

public abstract class AbstractTag
implements Tag {
    protected int commonNumber = 0;
    protected Map<String, List<TagField>> fields = new LinkedHashMap();

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.addField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void addField(TagField tagField) {
        if (tagField == null) {
            return;
        }
        List list = (List)this.fields.get((Object)tagField.getId());
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)tagField);
            this.fields.put((Object)tagField.getId(), (Object)arrayList);
            if (tagField.isCommon()) {
                this.commonNumber = 1 + this.commonNumber;
                return;
            }
        } else {
            list.add((Object)tagField);
        }
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        this.addField(this.createField(artwork));
    }

    @Override
    public /* varargs */ abstract TagField createField(FieldKey var1, String ... var2) throws KeyNotFoundException, FieldDataInvalidException;

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.deleteField(FieldKey.COVER_ART);
    }

    @Override
    public void deleteField(String string2) {
        this.fields.remove((Object)string2);
    }

    @Override
    public abstract void deleteField(FieldKey var1) throws KeyNotFoundException;

    public List<TagField> getAll() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.fields.values().iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = ((List)iterator.next()).iterator();
            while (iterator2.hasNext()) {
                arrayList.add((Object)((TagField)iterator2.next()));
            }
        }
        return arrayList;
    }

    public List<String> getAll(String string2) throws KeyNotFoundException {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getFields(string2).iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((TagField)iterator.next()).toString());
        }
        return arrayList;
    }

    @Override
    public int getFieldCount() {
        Iterator<TagField> iterator = this.getFields();
        int n2 = 0;
        while (iterator.hasNext()) {
            ++n2;
            iterator.next();
        }
        return n2;
    }

    @Override
    public int getFieldCountIncludingSubValues() {
        return this.getFieldCount();
    }

    @Override
    public Iterator<TagField> getFields() {
        return new Iterator<TagField>(this, this.fields.entrySet().iterator()){
            private Iterator<TagField> fieldsIt;
            final /* synthetic */ AbstractTag this$0;
            final /* synthetic */ Iterator val$it;
            {
                this.this$0 = abstractTag;
                this.val$it = iterator;
            }

            private void changeIt() {
                if (!this.val$it.hasNext()) {
                    return;
                }
                this.fieldsIt = ((List)((java.util.Map$Entry)this.val$it.next()).getValue()).iterator();
            }

            public boolean hasNext() {
                Iterator<TagField> iterator;
                if (this.fieldsIt == null) {
                    this.changeIt();
                }
                return this.val$it.hasNext() || (iterator = this.fieldsIt) != null && iterator.hasNext();
                {
                }
            }

            public TagField next() {
                if (!this.fieldsIt.hasNext()) {
                    this.changeIt();
                }
                return (TagField)this.fieldsIt.next();
            }

            public void remove() {
                this.fieldsIt.remove();
            }
        };
    }

    @Override
    public List<TagField> getFields(String string2) {
        List list = (List)this.fields.get((Object)string2);
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    @Override
    public String getFirst(String string2) {
        List<TagField> list = this.getFields(string2);
        if (list.size() != 0) {
            return ((TagField)list.get(0)).toString();
        }
        return "";
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public Artwork getFirstArtwork() {
        List<Artwork> list = this.getArtworkList();
        if (list.size() > 0) {
            return (Artwork)list.get(0);
        }
        return null;
    }

    @Override
    public TagField getFirstField(String string2) {
        List<TagField> list = this.getFields(string2);
        if (list.size() != 0) {
            return (TagField)list.get(0);
        }
        return null;
    }

    @Override
    public abstract TagField getFirstField(FieldKey var1) throws KeyNotFoundException;

    public String getItem(String string2, int n2) {
        List<TagField> list = this.getFields(string2);
        if (list.size() > n2) {
            return ((TagField)list.get(n2)).toString();
        }
        return "";
    }

    @Override
    public boolean hasCommonFields() {
        return this.commonNumber != 0;
    }

    @Override
    public boolean hasField(String string2) {
        return this.getFields(string2).size() != 0;
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        return this.hasField(fieldKey.name());
    }

    protected abstract boolean isAllowedEncoding(Charset var1);

    @Override
    public boolean isEmpty() {
        return this.fields.size() == 0;
    }

    @Override
    public boolean setEncoding(Charset charset) {
        if (!this.isAllowedEncoding(charset)) {
            return false;
        }
        Iterator<TagField> iterator = this.getFields();
        while (iterator.hasNext()) {
            TagField tagField = (TagField)iterator.next();
            if (!(tagField instanceof TagTextField)) continue;
            ((TagTextField)tagField).setEncoding(charset);
        }
        return true;
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void setField(TagField tagField) {
        if (tagField == null) {
            return;
        }
        List list = (List)this.fields.get((Object)tagField.getId());
        if (list != null) {
            list.set(0, (Object)tagField);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)tagField);
        this.fields.put((Object)tagField.getId(), (Object)arrayList);
        if (tagField.isCommon()) {
            this.commonNumber = 1 + this.commonNumber;
        }
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.setField(this.createField(artwork));
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Tag content:\n");
        Iterator<TagField> iterator = this.getFields();
        while (iterator.hasNext()) {
            TagField tagField = (TagField)iterator.next();
            stringBuffer.append("\t");
            stringBuffer.append(tagField.getId());
            stringBuffer.append(":");
            stringBuffer.append(tagField.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString().substring(0, -1 + stringBuffer.length());
    }
}

