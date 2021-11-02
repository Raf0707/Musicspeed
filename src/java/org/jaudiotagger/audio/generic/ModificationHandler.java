/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Vector
 */
package org.jaudiotagger.audio.generic;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.ModifyVetoException;
import org.jaudiotagger.audio.generic.AudioFileModificationListener;

public class ModificationHandler
implements AudioFileModificationListener {
    private Vector<AudioFileModificationListener> listeners = new Vector();

    public void addAudioFileModificationListener(AudioFileModificationListener audioFileModificationListener) {
        if (!this.listeners.contains((Object)audioFileModificationListener)) {
            this.listeners.add((Object)audioFileModificationListener);
        }
    }

    @Override
    public void fileModified(AudioFile audioFile, File file) throws ModifyVetoException {
        for (AudioFileModificationListener audioFileModificationListener : this.listeners) {
            try {
                audioFileModificationListener.fileModified(audioFile, file);
            }
            catch (ModifyVetoException modifyVetoException) {
                this.vetoThrown(audioFileModificationListener, audioFile, modifyVetoException);
                throw modifyVetoException;
            }
        }
    }

    @Override
    public void fileOperationFinished(File file) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((AudioFileModificationListener)iterator.next()).fileOperationFinished(file);
        }
    }

    @Override
    public void fileWillBeModified(AudioFile audioFile, boolean bl) throws ModifyVetoException {
        for (AudioFileModificationListener audioFileModificationListener : this.listeners) {
            try {
                audioFileModificationListener.fileWillBeModified(audioFile, bl);
            }
            catch (ModifyVetoException modifyVetoException) {
                this.vetoThrown(audioFileModificationListener, audioFile, modifyVetoException);
                throw modifyVetoException;
            }
        }
    }

    public void removeAudioFileModificationListener(AudioFileModificationListener audioFileModificationListener) {
        if (this.listeners.contains((Object)audioFileModificationListener)) {
            this.listeners.remove((Object)audioFileModificationListener);
        }
    }

    @Override
    public void vetoThrown(AudioFileModificationListener audioFileModificationListener, AudioFile audioFile, ModifyVetoException modifyVetoException) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((AudioFileModificationListener)iterator.next()).vetoThrown(audioFileModificationListener, audioFile, modifyVetoException);
        }
    }
}

