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
import org.jaudiotagger.audio.generic.AudioFileModificationListener;

public class AudioFileModificationAdapter
implements AudioFileModificationListener {
    @Override
    public void fileModified(AudioFile audioFile, File file) throws ModifyVetoException {
    }

    @Override
    public void fileOperationFinished(File file) {
    }

    @Override
    public void fileWillBeModified(AudioFile audioFile, boolean bl) throws ModifyVetoException {
    }

    @Override
    public void vetoThrown(AudioFileModificationListener audioFileModificationListener, AudioFile audioFile, ModifyVetoException modifyVetoException) {
    }
}

