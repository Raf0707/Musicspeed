/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Hashtable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package org.jaudiotagger.audio.asf.data;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.io.WriteableChunk;
import org.jaudiotagger.audio.asf.util.Utils;

public class MetadataContainer
extends Chunk
implements WriteableChunk {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final ContainerType containerType;
    private final Map<DescriptorPointer, List<MetadataDescriptor>> descriptors = new Hashtable();
    private final DescriptorPointer perfPoint = new Object(new MetadataDescriptor("")){
        static final /* synthetic */ boolean $assertionsDisabled;
        private MetadataDescriptor desc;
        {
            this.setDescriptor(metadataDescriptor);
        }

        public boolean equals(Object object) {
            boolean bl = true;
            boolean bl2 = object == this;
            if (object instanceof DescriptorPointer && !bl2) {
                MetadataDescriptor metadataDescriptor = (object).desc;
                boolean bl3 = this.desc.getName().equals((Object)metadataDescriptor.getName());
                boolean bl4 = this.desc.getLanguageIndex() == metadataDescriptor.getLanguageIndex();
                boolean bl5 = bl3 & bl4;
                if (this.desc.getStreamNumber() != metadataDescriptor.getStreamNumber()) {
                    bl = false;
                }
                bl2 = bl5 & bl;
            }
            return bl2;
        }

        public int hashCode() {
            return 31 * (31 * this.desc.getName().hashCode() + this.desc.getLanguageIndex()) + this.desc.getStreamNumber();
        }

        protected DescriptorPointer setDescriptor(MetadataDescriptor metadataDescriptor) {
            this.desc = metadataDescriptor;
            return this;
        }
    };

    public MetadataContainer(ContainerType containerType) {
        this(containerType, 0L, BigInteger.ZERO);
    }

    public MetadataContainer(ContainerType containerType, long l2, BigInteger bigInteger) {
        super(containerType.getContainerGUID(), l2, bigInteger);
        this.containerType = containerType;
    }

    public MetadataContainer(GUID gUID, long l2, BigInteger bigInteger) {
        this(MetadataContainer.determineType(gUID), l2, bigInteger);
    }

    private static ContainerType determineType(GUID gUID) throws IllegalArgumentException {
        ContainerType containerType;
        ContainerType[] arrcontainerType = ContainerType.values();
        int n2 = arrcontainerType.length;
        int n3 = 0;
        do {
            containerType = null;
            if (n3 >= n2) break;
            ContainerType containerType2 = arrcontainerType[n3];
            if (containerType2.getContainerGUID().equals(gUID)) {
                containerType = containerType2;
                break;
            }
            ++n3;
        } while (true);
        if (containerType != null) {
            return containerType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown metadata container specified by GUID (");
        stringBuilder.append(gUID.toString());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void addDescriptor(MetadataDescriptor metadataDescriptor) throws IllegalArgumentException {
        DescriptorPointer descriptorPointer;
        this.containerType.assertConstraints(metadataDescriptor.getName(), metadataDescriptor.getRawData(), metadataDescriptor.getType(), metadataDescriptor.getStreamNumber(), metadataDescriptor.getLanguageIndex());
        if (!this.isAddSupported(metadataDescriptor)) throw new IllegalArgumentException("Descriptor cannot be added, see isAddSupported(...)");
        DescriptorPointer descriptorPointer2 = descriptorPointer = this.perfPoint;
        // MONITORENTER : descriptorPointer2
        List list = (List)this.descriptors.get((Object)this.perfPoint.setDescriptor(metadataDescriptor));
        // MONITOREXIT : descriptorPointer2
        if (list == null) {
            list = new ArrayList();
            this.descriptors.put(new /* invalid duplicate definition of identical inner class */, (Object)list);
        } else if (!list.isEmpty()) {
            if (!this.containerType.isMultiValued()) throw new IllegalArgumentException("Container does not allow multiple values of descriptors with same name, language index and stream number");
        }
        list.add((Object)metadataDescriptor);
    }

    protected final MetadataDescriptor assertDescriptor(String string2) {
        return this.assertDescriptor(string2, 0);
    }

    protected final MetadataDescriptor assertDescriptor(String string2, int n2) {
        List<MetadataDescriptor> list = this.getDescriptorsByName(string2);
        if (list != null && !list.isEmpty()) {
            return (MetadataDescriptor)list.get(0);
        }
        MetadataDescriptor metadataDescriptor = new MetadataDescriptor(this.getContainerType(), string2, n2);
        this.addDescriptor(metadataDescriptor);
        return metadataDescriptor;
    }

    public final boolean containsDescriptor(MetadataDescriptor metadataDescriptor) {
        return this.descriptors.containsKey((Object)this.perfPoint.setDescriptor(metadataDescriptor));
    }

    public final ContainerType getContainerType() {
        return this.containerType;
    }

    @Override
    public long getCurrentAsfChunkSize() {
        Iterator iterator = this.getDescriptors().iterator();
        long l2 = 26L;
        while (iterator.hasNext()) {
            l2 += (long)((MetadataDescriptor)iterator.next()).getCurrentAsfSize(this.containerType);
        }
        return l2;
    }

    public final int getDescriptorCount() {
        return this.getDescriptors().size();
    }

    public final List<MetadataDescriptor> getDescriptors() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.descriptors.values().iterator();
        while (iterator.hasNext()) {
            arrayList.addAll((Collection)((List)iterator.next()));
        }
        return arrayList;
    }

    public final List<MetadataDescriptor> getDescriptorsByName(String string2) {
        ArrayList arrayList = new ArrayList();
        for (List list : this.descriptors.values()) {
            if (list.isEmpty() || !((MetadataDescriptor)list.get(0)).getName().equals((Object)string2)) continue;
            arrayList.addAll((Collection)list);
        }
        return arrayList;
    }

    protected final String getValueFor(String string2) {
        List<MetadataDescriptor> list = this.getDescriptorsByName(string2);
        if (list != null && !list.isEmpty()) {
            return ((MetadataDescriptor)list.get(0)).getString();
        }
        return "";
    }

    public final boolean hasDescriptor(String string2) {
        return true ^ this.getDescriptorsByName(string2).isEmpty();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isAddSupported(MetadataDescriptor metadataDescriptor) {
        DescriptorPointer descriptorPointer;
        if (this.getContainerType().checkConstraints(metadataDescriptor.getName(), metadataDescriptor.getRawData(), metadataDescriptor.getType(), metadataDescriptor.getStreamNumber(), metadataDescriptor.getLanguageIndex()) != null) return false;
        boolean bl = true;
        if (!bl) return bl;
        if (this.getContainerType().isMultiValued()) return bl;
        DescriptorPointer descriptorPointer2 = descriptorPointer = this.perfPoint;
        synchronized (descriptorPointer2) {
            List list = (List)this.descriptors.get((Object)this.perfPoint.setDescriptor(metadataDescriptor));
            if (list == null) return bl;
            return list.isEmpty();
        }
    }

    @Override
    public final boolean isEmpty() {
        boolean bl;
        int n2 = this.getDescriptorCount();
        if (n2 != 0) {
            Iterator iterator = this.getDescriptors().iterator();
            for (bl = true; bl && iterator.hasNext(); bl &= ((MetadataDescriptor)iterator.next()).isEmpty()) {
            }
        }
        return bl;
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        for (MetadataDescriptor metadataDescriptor : this.getDescriptors()) {
            stringBuilder.append(string2);
            stringBuilder.append("  |-> ");
            stringBuilder.append((Object)metadataDescriptor);
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public final void removeDescriptorsByName(String string2) {
        Iterator iterator = this.descriptors.values().iterator();
        while (iterator.hasNext()) {
            List list = (List)iterator.next();
            if (list.isEmpty() || !((MetadataDescriptor)list.get(0)).getName().equals((Object)string2)) continue;
            iterator.remove();
        }
    }

    protected final void setStringValue(String string2, String string3) {
        this.assertDescriptor(string2).setStringValue(string3);
    }

    @Override
    public long writeInto(OutputStream outputStream) throws IOException {
        long l2 = this.getCurrentAsfChunkSize();
        List<MetadataDescriptor> list = this.getDescriptors();
        outputStream.write(this.getGuid().getBytes());
        Utils.writeUINT64(l2, outputStream);
        Utils.writeUINT16(list.size(), outputStream);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((MetadataDescriptor)iterator.next()).writeInto(outputStream, this.containerType);
        }
        return l2;
    }

}

