/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public class EncryptionChunk
extends Chunk {
    private String keyID = "";
    private String licenseURL = "";
    private String protectionType = "";
    private String secretData = "";
    private final ArrayList<String> strings = new ArrayList();

    public EncryptionChunk(BigInteger bigInteger) {
        super(GUID.GUID_CONTENT_ENCRYPTION, bigInteger);
    }

    public void addString(String string2) {
        this.strings.add((Object)string2);
    }

    public String getKeyID() {
        return this.keyID;
    }

    public String getLicenseURL() {
        return this.licenseURL;
    }

    public String getProtectionType() {
        return this.protectionType;
    }

    public String getSecretData() {
        return this.secretData;
    }

    public Collection<String> getStrings() {
        return new ArrayList(this.strings);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        StringBuilder stringBuilder2 = new StringBuilder();
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder2.append(string3);
        stringBuilder2.append(string2);
        stringBuilder2.append(" Encryption:");
        stringBuilder2.append(string3);
        stringBuilder.insert(0, stringBuilder2.toString());
        stringBuilder.append(string2);
        stringBuilder.append("\t|->keyID ");
        stringBuilder.append(this.keyID);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("\t|->secretData ");
        stringBuilder.append(this.secretData);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("\t|->protectionType ");
        stringBuilder.append(this.protectionType);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("\t|->licenseURL ");
        stringBuilder.append(this.licenseURL);
        stringBuilder.append(string3);
        this.strings.iterator();
        for (String string4 : this.strings) {
            stringBuilder.append(string2);
            stringBuilder.append("   |->");
            stringBuilder.append(string4);
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public void setKeyID(String string2) {
        this.keyID = string2;
    }

    public void setLicenseURL(String string2) {
        this.licenseURL = string2;
    }

    public void setProtectionType(String string2) {
        this.protectionType = string2;
    }

    public void setSecretData(String string2) {
        this.secretData = string2;
    }
}

