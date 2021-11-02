/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 */
package org.jaudiotagger.audio.generic;

import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.ModifyVetoException;

public interface AudioFileModificationListener {
    public void fileModified(AudioFile var1, File var2) throws ModifyVetoException;

    public void fileOperationFinished(File var1);

    public void fileWillBeModified(AudioFile var1, boolean var2) throws ModifyVetoException;

    public void vetoThrown(AudioFileModificationListener var1, AudioFile var2, ModifyVetoException var3);
}

