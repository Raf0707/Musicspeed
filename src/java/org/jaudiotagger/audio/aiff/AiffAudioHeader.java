/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 */
package org.jaudiotagger.audio.aiff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jaudiotagger.audio.aiff.AiffType;
import org.jaudiotagger.audio.generic.GenericAudioHeader;

public class AiffAudioHeader
extends GenericAudioHeader {
    private List<String> annotations = new ArrayList();
    private List<String> applicationIdentifiers = new ArrayList();
    private String audioEncoding;
    private String author;
    private List<String> comments = new ArrayList();
    private String copyright;
    private Endian endian = Endian.BIG_ENDIAN;
    private AiffType fileType;
    private String name;
    private Date timestamp;

    public void addAnnotation(String string2) {
        this.annotations.add((Object)string2);
    }

    public void addApplicationIdentifier(String string2) {
        this.applicationIdentifiers.add((Object)string2);
    }

    public void addComment(String string2) {
        this.comments.add((Object)string2);
    }

    public List<String> getAnnotations() {
        return this.annotations;
    }

    public List<String> getApplicationIdentifiers() {
        return this.applicationIdentifiers;
    }

    public String getAuthor() {
        return this.author;
    }

    public List<String> getComments() {
        return this.comments;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public Endian getEndian() {
        return this.endian;
    }

    public AiffType getFileType() {
        return this.fileType;
    }

    public String getName() {
        return this.name;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setAuthor(String string2) {
        this.author = string2;
    }

    public void setCopyright(String string2) {
        this.copyright = string2;
    }

    public void setEndian(Endian endian) {
        this.endian = endian;
    }

    public void setFileType(AiffType aiffType) {
        this.fileType = aiffType;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    @Override
    public String toString() {
        String string2;
        String string3;
        StringBuilder stringBuilder = new StringBuilder("\n");
        String string4 = this.name;
        if (string4 != null && !string4.isEmpty()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\tName:");
            stringBuilder2.append(this.name);
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        if ((string2 = this.author) != null && !string2.isEmpty()) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("\tAuthor:");
            stringBuilder3.append(this.author);
            stringBuilder3.append("\n");
            stringBuilder.append(stringBuilder3.toString());
        }
        if ((string3 = this.copyright) != null && !string3.isEmpty()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("\tCopyright:");
            stringBuilder4.append(this.copyright);
            stringBuilder4.append("\n");
            stringBuilder.append(stringBuilder4.toString());
        }
        if (this.comments.size() > 0) {
            stringBuilder.append("Comments:\n");
            for (String string5 : this.comments) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("\t");
                stringBuilder5.append(string5);
                stringBuilder5.append("\n");
                stringBuilder.append(stringBuilder5.toString());
            }
        }
        if (this.applicationIdentifiers.size() > 0) {
            stringBuilder.append("ApplicationIds:\n");
            for (String string6 : this.applicationIdentifiers) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("\t");
                stringBuilder6.append(string6);
                stringBuilder6.append("\n");
                stringBuilder.append(stringBuilder6.toString());
            }
        }
        if (this.annotations.size() > 0) {
            stringBuilder.append("Annotations:\n");
            for (String string7 : this.annotations) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append("\t");
                stringBuilder7.append(string7);
                stringBuilder7.append("\n");
                stringBuilder.append(stringBuilder7.toString());
            }
        }
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append(super.toString());
        stringBuilder8.append(stringBuilder.toString());
        return stringBuilder8.toString();
    }

}

