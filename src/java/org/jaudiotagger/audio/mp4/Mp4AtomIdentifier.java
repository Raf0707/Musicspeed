/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.mp4;

public final class Mp4AtomIdentifier
extends Enum<Mp4AtomIdentifier> {
    private static final /* synthetic */ Mp4AtomIdentifier[] $VALUES;
    public static final /* enum */ Mp4AtomIdentifier ALAC = new Mp4AtomIdentifier("alac", "Apple Lossless File");
    public static final /* enum */ Mp4AtomIdentifier ALBM = new Mp4AtomIdentifier("albm", "Album title and track number (user-data)");
    public static final /* enum */ Mp4AtomIdentifier AUTH = new Mp4AtomIdentifier("auth", "Media author name (user-data)");
    public static final /* enum */ Mp4AtomIdentifier BPCC = new Mp4AtomIdentifier("bpcc", "Bits per component");
    public static final /* enum */ Mp4AtomIdentifier BUFF = new Mp4AtomIdentifier("buff", "Buffering information");
    public static final /* enum */ Mp4AtomIdentifier BXML = new Mp4AtomIdentifier("bxml", "Binary XML container");
    public static final /* enum */ Mp4AtomIdentifier CCID = new Mp4AtomIdentifier("ccid", "OMA DRM Content ID");
    public static final /* enum */ Mp4AtomIdentifier CDEF = new Mp4AtomIdentifier("cdef", "Type and ordering of the components within the codestream");
    public static final /* enum */ Mp4AtomIdentifier CLSF = new Mp4AtomIdentifier("clsf", "Media classification (user-data)");
    public static final /* enum */ Mp4AtomIdentifier CMAP = new Mp4AtomIdentifier("cmap", "Mapping between a palette and codestream components");
    public static final /* enum */ Mp4AtomIdentifier CO64 = new Mp4AtomIdentifier("co64", "64-bit chunk offset");
    public static final /* enum */ Mp4AtomIdentifier COLR = new Mp4AtomIdentifier("colr", "Specifies the colourspace of the image");
    public static final /* enum */ Mp4AtomIdentifier CPRT = new Mp4AtomIdentifier("cprt", "Copyright etc. (user-data)");
    public static final /* enum */ Mp4AtomIdentifier CRHD = new Mp4AtomIdentifier("crhd", "Reserved for ClockReferenceStream header");
    public static final /* enum */ Mp4AtomIdentifier CSLG = new Mp4AtomIdentifier("cslg", "Composition to decode timeline mapping");
    public static final /* enum */ Mp4AtomIdentifier CTTS = new Mp4AtomIdentifier("ctts", "(composition) time to sample");
    public static final /* enum */ Mp4AtomIdentifier CVRU = new Mp4AtomIdentifier("cvru", "OMA DRM Cover URI");
    public static final /* enum */ Mp4AtomIdentifier DCFD = new Mp4AtomIdentifier("dcfD", "Marlin DCF Duration, user-data atom type");
    public static final /* enum */ Mp4AtomIdentifier DINF = new Mp4AtomIdentifier("dinf", "Data information box, container");
    public static final /* enum */ Mp4AtomIdentifier DREF = new Mp4AtomIdentifier("dref", "Data reference box, declares source(s) of media data in track");
    public static final /* enum */ Mp4AtomIdentifier DRMS = new Mp4AtomIdentifier("drms", "DRM protected File");
    public static final /* enum */ Mp4AtomIdentifier DSCP = new Mp4AtomIdentifier("dscp", "Media description (user-data)");
    public static final /* enum */ Mp4AtomIdentifier DSGD = new Mp4AtomIdentifier("dsgd", "DVB Sample Group Description Box");
    public static final /* enum */ Mp4AtomIdentifier DSTG = new Mp4AtomIdentifier("dstg", "DVB Sample to Group Box");
    public static final /* enum */ Mp4AtomIdentifier EDTS = new Mp4AtomIdentifier("edts", "Edit list container");
    public static final /* enum */ Mp4AtomIdentifier ELST = new Mp4AtomIdentifier("elst", "An edit list");
    public static final /* enum */ Mp4AtomIdentifier ESDS = new Mp4AtomIdentifier("esds", "Track codec specific information");
    public static final /* enum */ Mp4AtomIdentifier FECI = new Mp4AtomIdentifier("feci", "FEC Informatiom");
    public static final /* enum */ Mp4AtomIdentifier FECR = new Mp4AtomIdentifier("fecr", "FEC Reservoir");
    public static final /* enum */ Mp4AtomIdentifier FIIN = new Mp4AtomIdentifier("fiin", "FD Item Information");
    public static final /* enum */ Mp4AtomIdentifier FIRE = new Mp4AtomIdentifier("fire", "File Reservoir");
    public static final /* enum */ Mp4AtomIdentifier FPAR = new Mp4AtomIdentifier("fpar", "File Partition");
    public static final /* enum */ Mp4AtomIdentifier FREE = new Mp4AtomIdentifier("free", "Padding");
    public static final /* enum */ Mp4AtomIdentifier FRMA = new Mp4AtomIdentifier("frma", "Original format box");
    public static final /* enum */ Mp4AtomIdentifier FTYP = new Mp4AtomIdentifier("ftyp", "File type Identification");
    public static final /* enum */ Mp4AtomIdentifier GITN = new Mp4AtomIdentifier("gitn", "Group ID to name");
    public static final /* enum */ Mp4AtomIdentifier GNRE = new Mp4AtomIdentifier("gnre", "Media genre (user-data)");
    public static final /* enum */ Mp4AtomIdentifier GRPI = new Mp4AtomIdentifier("grpi", "OMA DRM Group ID");
    public static final /* enum */ Mp4AtomIdentifier HDLR = new Mp4AtomIdentifier("hdlr", "Metadata Handler");
    public static final /* enum */ Mp4AtomIdentifier HMHD = new Mp4AtomIdentifier("hmhd", "Hint media header, overall information (hint track only)");
    public static final /* enum */ Mp4AtomIdentifier HNTI = new Mp4AtomIdentifier("hnti", "Hint tracks to aid a streaming server in remuxing the M4A file to an RTP stream.");
    public static final /* enum */ Mp4AtomIdentifier ICNU = new Mp4AtomIdentifier("icnu", "OMA DRM Icon URI");
    public static final /* enum */ Mp4AtomIdentifier ID32 = new Mp4AtomIdentifier("ID32", "ID3 version 2 container");
    public static final /* enum */ Mp4AtomIdentifier IDAT = new Mp4AtomIdentifier("idat", "Item data");
    public static final /* enum */ Mp4AtomIdentifier IHDR = new Mp4AtomIdentifier("ihdr", "Image Header");
    public static final /* enum */ Mp4AtomIdentifier IINF = new Mp4AtomIdentifier("iinf", "item information");
    public static final /* enum */ Mp4AtomIdentifier ILOC = new Mp4AtomIdentifier("iloc", "item location");
    public static final /* enum */ Mp4AtomIdentifier ILST = new Mp4AtomIdentifier("ilst", "MetaInformation Optional");
    public static final /* enum */ Mp4AtomIdentifier IMIF = new Mp4AtomIdentifier("imif", "IPMP Information box");
    public static final /* enum */ Mp4AtomIdentifier INFU = new Mp4AtomIdentifier("infu", "OMA DRM Info URL");
    public static final /* enum */ Mp4AtomIdentifier IODS = new Mp4AtomIdentifier("iods", "Object Descriptor container box");
    public static final /* enum */ Mp4AtomIdentifier IPHD = new Mp4AtomIdentifier("iphd", "reserved for IPMP Stream header");
    public static final /* enum */ Mp4AtomIdentifier IPMC = new Mp4AtomIdentifier("ipmc", "IPMP Control Box");
    public static final /* enum */ Mp4AtomIdentifier IPRO = new Mp4AtomIdentifier("ipro", "Item protection");
    public static final /* enum */ Mp4AtomIdentifier IREF = new Mp4AtomIdentifier("iref", "Item reference");
    public static final /* enum */ Mp4AtomIdentifier JP2C = new Mp4AtomIdentifier("jp2c", "JPEG 2000 contiguous codestream");
    public static final /* enum */ Mp4AtomIdentifier JP2H = new Mp4AtomIdentifier("jp2h", "Header");
    public static final /* enum */ Mp4AtomIdentifier JP2I = new Mp4AtomIdentifier("jp2i", "Intellectual property information");
    public static final /* enum */ Mp4AtomIdentifier KYWD = new Mp4AtomIdentifier("kywd", "Media keywords (user-data)");
    public static final /* enum */ Mp4AtomIdentifier LOCI = new Mp4AtomIdentifier("loci", "Media location information (user-data)");
    public static final /* enum */ Mp4AtomIdentifier LRCU = new Mp4AtomIdentifier("lrcu", "OMA DRM Lyrics URI");
    public static final /* enum */ Mp4AtomIdentifier M7HD = new Mp4AtomIdentifier("m7hd", "Reserved for MPEG7Stream header");
    public static final /* enum */ Mp4AtomIdentifier MDAT = new Mp4AtomIdentifier("mdat", "Audio Data");
    public static final /* enum */ Mp4AtomIdentifier MDHD = new Mp4AtomIdentifier("mdhd", "Media Header");
    public static final /* enum */ Mp4AtomIdentifier MDIA = new Mp4AtomIdentifier("mdia", "Container for the media information in a track");
    public static final /* enum */ Mp4AtomIdentifier MDRI = new Mp4AtomIdentifier("mdri", "Mutable DRM information");
    public static final /* enum */ Mp4AtomIdentifier MECO = new Mp4AtomIdentifier("meco", "Additional metadata container");
    public static final /* enum */ Mp4AtomIdentifier MEHD = new Mp4AtomIdentifier("mehd", "Movie extends header box");
    public static final /* enum */ Mp4AtomIdentifier MERE = new Mp4AtomIdentifier("mere", "Metabox relation");
    public static final /* enum */ Mp4AtomIdentifier META = new Mp4AtomIdentifier("meta", "MetaInformation");
    public static final /* enum */ Mp4AtomIdentifier MFHD = new Mp4AtomIdentifier("mfhd", "Movie fragment header");
    public static final /* enum */ Mp4AtomIdentifier MFRA = new Mp4AtomIdentifier("mfra", "Movie fragment random access ");
    public static final /* enum */ Mp4AtomIdentifier MFRO = new Mp4AtomIdentifier("mfro", "Movie fragment random access offset");
    public static final /* enum */ Mp4AtomIdentifier MINF = new Mp4AtomIdentifier("minf", "Media information container");
    public static final /* enum */ Mp4AtomIdentifier MJHD = new Mp4AtomIdentifier("mjhd", "Reserved for MPEG-J Stream header");
    public static final /* enum */ Mp4AtomIdentifier MOOF = new Mp4AtomIdentifier("moof", "Movie fragment");
    public static final /* enum */ Mp4AtomIdentifier MOOV = new Mp4AtomIdentifier("moov", "Container for all the meta-data");
    public static final /* enum */ Mp4AtomIdentifier MP4A = new Mp4AtomIdentifier("mp4a", "AAC Audio");
    public static final /* enum */ Mp4AtomIdentifier MVCG = new Mp4AtomIdentifier("mvcg", "Multiview group");
    public static final /* enum */ Mp4AtomIdentifier MVCI = new Mp4AtomIdentifier("mvci", "Multiview Information");
    public static final /* enum */ Mp4AtomIdentifier MVEX = new Mp4AtomIdentifier("mvex", "Movie extends box");
    public static final /* enum */ Mp4AtomIdentifier MVHD = new Mp4AtomIdentifier("mvhd", "Movie Header");
    public static final /* enum */ Mp4AtomIdentifier MVRA = new Mp4AtomIdentifier("mvra", "Multiview Relation Attribute");
    public static final /* enum */ Mp4AtomIdentifier NMHD = new Mp4AtomIdentifier("nmhd", "Null media header, overall information (some tracks only)");
    public static final /* enum */ Mp4AtomIdentifier OCHD = new Mp4AtomIdentifier("ochd", "Reserved for ObjectContentInfoStream header");
    public static final /* enum */ Mp4AtomIdentifier ODAF = new Mp4AtomIdentifier("odaf", "OMA DRM Access Unit Format");
    public static final /* enum */ Mp4AtomIdentifier ODDA = new Mp4AtomIdentifier("odda", "OMA DRM Content Object");
    public static final /* enum */ Mp4AtomIdentifier ODHD = new Mp4AtomIdentifier("odhd", "Reserved for ObjectDescriptorStream header");
    public static final /* enum */ Mp4AtomIdentifier ODHE = new Mp4AtomIdentifier("odhe", "OMA DRM Discrete Media Headers");
    public static final /* enum */ Mp4AtomIdentifier ODRB = new Mp4AtomIdentifier("odrb", "OMA DRM Rights Object");
    public static final /* enum */ Mp4AtomIdentifier ODRM = new Mp4AtomIdentifier("odrm", "OMA DRM Container");
    public static final /* enum */ Mp4AtomIdentifier ODTT = new Mp4AtomIdentifier("odtt", "OMA DRM Transaction Tracking");
    public static final /* enum */ Mp4AtomIdentifier OHDR = new Mp4AtomIdentifier("ohdr", "OMA DRM Common headers");
    public static final /* enum */ Mp4AtomIdentifier PADB = new Mp4AtomIdentifier("padb", "Sample padding bits");
    public static final /* enum */ Mp4AtomIdentifier PAEN = new Mp4AtomIdentifier("paen", "Partition Entry");
    public static final /* enum */ Mp4AtomIdentifier PCLR = new Mp4AtomIdentifier("pclr", "palette which maps a single component in index space to a multiple- component image");
    public static final /* enum */ Mp4AtomIdentifier PDIN = new Mp4AtomIdentifier("pdin", "Progressive download information");
    public static final /* enum */ Mp4AtomIdentifier PERF = new Mp4AtomIdentifier("perf", "Media performer name (user-data)");
    public static final /* enum */ Mp4AtomIdentifier PITM = new Mp4AtomIdentifier("pitm", "Primary item reference");
    public static final /* enum */ Mp4AtomIdentifier RESC = new Mp4AtomIdentifier("resc", "Grid resolution at which the image was captured");
    public static final /* enum */ Mp4AtomIdentifier RESD = new Mp4AtomIdentifier("resd", "Default grid resolution at which the image should be displayed");
    public static final /* enum */ Mp4AtomIdentifier RTNG = new Mp4AtomIdentifier("rtng", "Media rating (user-data)");
    public static final /* enum */ Mp4AtomIdentifier SBGP = new Mp4AtomIdentifier("sbgp", "Sample to Group box");
    public static final /* enum */ Mp4AtomIdentifier SCHI = new Mp4AtomIdentifier("schi", "Scheme information box");
    public static final /* enum */ Mp4AtomIdentifier SCHM = new Mp4AtomIdentifier("schm", "Scheme type box");
    public static final /* enum */ Mp4AtomIdentifier SDEP = new Mp4AtomIdentifier("sdep", "Sample dependency");
    public static final /* enum */ Mp4AtomIdentifier SDHD = new Mp4AtomIdentifier("sdhd", "Reserved for SceneDescriptionStream header");
    public static final /* enum */ Mp4AtomIdentifier SDTP = new Mp4AtomIdentifier("sdtp", "Independent and Disposable Samples Box");
    public static final /* enum */ Mp4AtomIdentifier SDVP = new Mp4AtomIdentifier("sdvp", "SD Profile Box");
    public static final /* enum */ Mp4AtomIdentifier SEGR = new Mp4AtomIdentifier("segr", "File delivery session group");
    public static final /* enum */ Mp4AtomIdentifier SGPD = new Mp4AtomIdentifier("sgpd", "Sample group definition box");
    public static final /* enum */ Mp4AtomIdentifier SIDX = new Mp4AtomIdentifier("sidx", "Segment Index Box");
    public static final /* enum */ Mp4AtomIdentifier SINF = new Mp4AtomIdentifier("sinf", "Protection scheme information box");
    public static final /* enum */ Mp4AtomIdentifier SKIP = new Mp4AtomIdentifier("skip", "Free space");
    public static final /* enum */ Mp4AtomIdentifier SMHD = new Mp4AtomIdentifier("smhd", "Sound media header, overall information (sound track only)");
    public static final /* enum */ Mp4AtomIdentifier SRMB = new Mp4AtomIdentifier("srmb", "System Renewability Message");
    public static final /* enum */ Mp4AtomIdentifier SRMC = new Mp4AtomIdentifier("srmc", "System Renewability Message container");
    public static final /* enum */ Mp4AtomIdentifier SRPP = new Mp4AtomIdentifier("srpp", "STRP Process");
    public static final /* enum */ Mp4AtomIdentifier STBL = new Mp4AtomIdentifier("stbl", "Sample table box, container for the time/space map");
    public static final /* enum */ Mp4AtomIdentifier STCO = new Mp4AtomIdentifier("stco", "Offsets into Audio Data");
    public static final /* enum */ Mp4AtomIdentifier STDP = new Mp4AtomIdentifier("stdp", "Sample degradation priority");
    public static final /* enum */ Mp4AtomIdentifier STSC = new Mp4AtomIdentifier("stsc", "Sample-to-chunk, partial data-offset information");
    public static final /* enum */ Mp4AtomIdentifier STSD = new Mp4AtomIdentifier("stsd", "Sample descriptions (codec types, initialization etc.)");
    public static final /* enum */ Mp4AtomIdentifier STSH = new Mp4AtomIdentifier("stsh", "Shadow sync sample table");
    public static final /* enum */ Mp4AtomIdentifier STSS = new Mp4AtomIdentifier("stss", "Sync sample table (random access points)");
    public static final /* enum */ Mp4AtomIdentifier STSZ = new Mp4AtomIdentifier("stsz", "Sample sizes (framing)");
    public static final /* enum */ Mp4AtomIdentifier STTS = new Mp4AtomIdentifier("stts", "(decoding) time-to-sample");
    public static final /* enum */ Mp4AtomIdentifier STYP = new Mp4AtomIdentifier("styp", "Segment Type Box");
    public static final /* enum */ Mp4AtomIdentifier STZ2 = new Mp4AtomIdentifier("stz2", "Compact sample sizes (framing)");
    public static final /* enum */ Mp4AtomIdentifier SUBS = new Mp4AtomIdentifier("subs", "Sub-sample information");
    public static final /* enum */ Mp4AtomIdentifier SWTC = new Mp4AtomIdentifier("swtc", "Multiview Group Relation");
    public static final /* enum */ Mp4AtomIdentifier TAGS = new Mp4AtomIdentifier("tags", "Nero Encoder Tags");
    public static final /* enum */ Mp4AtomIdentifier TFAD = new Mp4AtomIdentifier("tfad", "Track fragment adjustment box");
    public static final /* enum */ Mp4AtomIdentifier TFHD = new Mp4AtomIdentifier("tfhd", "Track fragment header");
    public static final /* enum */ Mp4AtomIdentifier TFMA = new Mp4AtomIdentifier("tfma", "Track fragment media adjustment box");
    public static final /* enum */ Mp4AtomIdentifier TFRA = new Mp4AtomIdentifier("tfra", "Track fragment radom access");
    public static final /* enum */ Mp4AtomIdentifier TIBR = new Mp4AtomIdentifier("tibr", "Tier Bit rate");
    public static final /* enum */ Mp4AtomIdentifier TIRI = new Mp4AtomIdentifier("tiri", "Tier Information");
    public static final /* enum */ Mp4AtomIdentifier TITL = new Mp4AtomIdentifier("titl", "Media title (user-data)");
    public static final /* enum */ Mp4AtomIdentifier TKHD = new Mp4AtomIdentifier("tkhd", "Track header, overall information about the track");
    public static final /* enum */ Mp4AtomIdentifier TRAF = new Mp4AtomIdentifier("traf", "Track fragment");
    public static final /* enum */ Mp4AtomIdentifier TRAK = new Mp4AtomIdentifier("trak", "Track");
    public static final /* enum */ Mp4AtomIdentifier TREF = new Mp4AtomIdentifier("tref", "Track reference container");
    public static final /* enum */ Mp4AtomIdentifier TREX = new Mp4AtomIdentifier("trex", "Track extends defaults");
    public static final /* enum */ Mp4AtomIdentifier TRGR = new Mp4AtomIdentifier("trgr", "Track grouping information");
    public static final /* enum */ Mp4AtomIdentifier TRUN = new Mp4AtomIdentifier("trun", "Track fragment run");
    public static final /* enum */ Mp4AtomIdentifier TSEL = new Mp4AtomIdentifier("tsel", "Track selection (user-data)");
    public static final /* enum */ Mp4AtomIdentifier UDTA = new Mp4AtomIdentifier("udta", "User Data");
    public static final /* enum */ Mp4AtomIdentifier UINF = new Mp4AtomIdentifier("uinf", "A tool by which a vendor may provide access to additional information associated with a UUID");
    public static final /* enum */ Mp4AtomIdentifier ULST = new Mp4AtomIdentifier("ulst", "A list of UUID\u2019s");
    public static final /* enum */ Mp4AtomIdentifier URL$20 = new Mp4AtomIdentifier("url$20", "a URL");
    public static final /* enum */ Mp4AtomIdentifier UUID = new Mp4AtomIdentifier("uuid", "User-extension box");
    public static final /* enum */ Mp4AtomIdentifier VMHD = new Mp4AtomIdentifier("vmhd", "video media header, overall information (video track only)");
    public static final /* enum */ Mp4AtomIdentifier VWDI = new Mp4AtomIdentifier("vwdi", "Multiview Scene Information");
    public static final /* enum */ Mp4AtomIdentifier XML$20 = new Mp4AtomIdentifier("xml$20", "a tool by which vendors can add XML formatted information");
    public static final /* enum */ Mp4AtomIdentifier YRRC = new Mp4AtomIdentifier("yrrc", "Year when media was recorded (user-data)");
    private String description;
    private String fieldName;

    static {
        Mp4AtomIdentifier[] arrmp4AtomIdentifier = new Mp4AtomIdentifier[]{ALAC, ALBM, AUTH, BPCC, BUFF, BXML, CCID, CDEF, CLSF, CMAP, CO64, COLR, CPRT, CRHD, CSLG, CTTS, CVRU, DCFD, DINF, DREF, DRMS, DSCP, DSGD, DSTG, EDTS, ELST, ESDS, FECI, FECR, FIIN, FIRE, FPAR, FREE, FRMA, FTYP, GITN, GNRE, GRPI, HDLR, HMHD, HNTI, ICNU, ID32, IDAT, IHDR, IINF, ILOC, ILST, IMIF, INFU, IODS, IPHD, IPMC, IPRO, IREF, JP2C, JP2H, JP2I, KYWD, LOCI, LRCU, M7HD, MDAT, MDHD, MDIA, MDRI, MECO, MEHD, MERE, META, MFHD, MFRA, MFRO, MINF, MJHD, MOOF, MOOV, MP4A, MVCG, MVCI, MVEX, MVHD, MVRA, NMHD, OCHD, ODAF, ODDA, ODHD, ODHE, ODRB, ODRM, ODTT, OHDR, PADB, PAEN, PCLR, PDIN, PERF, PITM, RESC, RESD, RTNG, SBGP, SCHI, SCHM, SDEP, SDHD, SDTP, SDVP, SEGR, SGPD, SIDX, SINF, SKIP, SMHD, SRMB, SRMC, SRPP, STBL, STCO, STDP, STSC, STSD, STSH, STSS, STSZ, STTS, STYP, STZ2, SUBS, SWTC, TAGS, TFAD, TFHD, TFMA, TFRA, TIBR, TIRI, TITL, TKHD, TRAF, TRAK, TREF, TREX, TRGR, TRUN, TSEL, UDTA, UINF, ULST, URL$20, UUID, VMHD, VWDI, XML$20, YRRC};
        $VALUES = arrmp4AtomIdentifier;
    }

    private Mp4AtomIdentifier(String string3, String string4) {
        this.fieldName = string3;
        this.description = string4;
    }

    public static Mp4AtomIdentifier valueOf(String string2) {
        return (Mp4AtomIdentifier)Enum.valueOf(Mp4AtomIdentifier.class, (String)string2);
    }

    public static Mp4AtomIdentifier[] values() {
        return (Mp4AtomIdentifier[])$VALUES.clone();
    }

    public String getDescription() {
        return this.description;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}

