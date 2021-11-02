/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.List
 *  org.jaudiotagger.tag.FieldDataInvalidException
 */
package org.jaudiotagger.tag;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.images.Artwork;

public interface Tag {
    public /* varargs */ void addField(FieldKey var1, String ... var2) throws KeyNotFoundException, FieldDataInvalidException;

    public void addField(TagField var1) throws FieldDataInvalidException;

    public void addField(Artwork var1) throws FieldDataInvalidException;

    public TagField createCompilationField(boolean var1) throws KeyNotFoundException, FieldDataInvalidException;

    public /* varargs */ TagField createField(FieldKey var1, String ... var2) throws KeyNotFoundException, FieldDataInvalidException;

    public TagField createField(Artwork var1) throws FieldDataInvalidException;

    public void deleteArtworkField() throws KeyNotFoundException;

    public void deleteField(String var1) throws KeyNotFoundException;

    public void deleteField(FieldKey var1) throws KeyNotFoundException;

    public List<String> getAll(FieldKey var1) throws KeyNotFoundException;

    public List<Artwork> getArtworkList();

    public int getFieldCount();

    public int getFieldCountIncludingSubValues();

    public Iterator<TagField> getFields();

    public List<TagField> getFields(String var1);

    public List<TagField> getFields(FieldKey var1) throws KeyNotFoundException;

    public String getFirst(String var1);

    public String getFirst(FieldKey var1) throws KeyNotFoundException;

    public Artwork getFirstArtwork();

    public TagField getFirstField(String var1);

    public TagField getFirstField(FieldKey var1);

    public String getValue(FieldKey var1, int var2);

    public boolean hasCommonFields();

    public boolean hasField(String var1);

    public boolean hasField(FieldKey var1);

    public boolean isEmpty();

    public boolean setEncoding(Charset var1) throws FieldDataInvalidException;

    public /* varargs */ void setField(FieldKey var1, String ... var2) throws KeyNotFoundException, FieldDataInvalidException;

    public void setField(TagField var1) throws FieldDataInvalidException;

    public void setField(Artwork var1) throws FieldDataInvalidException;

    public String toString();
}

