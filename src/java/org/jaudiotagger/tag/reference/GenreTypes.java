/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package org.jaudiotagger.tag.reference;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.tag.datatype.AbstractIntStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class GenreTypes
extends AbstractIntStringValuePair {
    private static final int MAX_GENRE_ID = 191;
    private static final int MAX_STANDARD_GENRE_ID = 125;
    private static GenreTypes genreTypes;
    private Map<String, Integer> nameToIdMap;

    private GenreTypes() {
        this.idToValue.put((Object)0, (Object)"Blues");
        this.idToValue.put((Object)1, (Object)"Classic Rock");
        this.idToValue.put((Object)2, (Object)"Country");
        this.idToValue.put((Object)3, (Object)"Dance");
        this.idToValue.put((Object)4, (Object)"Disco");
        this.idToValue.put((Object)5, (Object)"Funk");
        this.idToValue.put((Object)6, (Object)"Grunge");
        this.idToValue.put((Object)7, (Object)"Hip-Hop");
        this.idToValue.put((Object)8, (Object)"Jazz");
        this.idToValue.put((Object)9, (Object)"Metal");
        this.idToValue.put((Object)10, (Object)"New Age");
        this.idToValue.put((Object)11, (Object)"Oldies");
        this.idToValue.put((Object)12, (Object)"Other");
        this.idToValue.put((Object)13, (Object)"Pop");
        this.idToValue.put((Object)14, (Object)"R&B");
        this.idToValue.put((Object)15, (Object)"Rap");
        this.idToValue.put((Object)16, (Object)"Reggae");
        this.idToValue.put((Object)17, (Object)"Rock");
        this.idToValue.put((Object)18, (Object)"Techno");
        this.idToValue.put((Object)19, (Object)"Industrial");
        this.idToValue.put((Object)20, (Object)"Alternative");
        this.idToValue.put((Object)21, (Object)"Ska");
        this.idToValue.put((Object)22, (Object)"Death Metal");
        this.idToValue.put((Object)23, (Object)"Pranks");
        this.idToValue.put((Object)24, (Object)"Soundtrack");
        this.idToValue.put((Object)25, (Object)"Euro-Techno");
        this.idToValue.put((Object)26, (Object)"Ambient");
        this.idToValue.put((Object)27, (Object)"Trip-Hop");
        this.idToValue.put((Object)28, (Object)"Vocal");
        this.idToValue.put((Object)29, (Object)"Jazz+Funk");
        this.idToValue.put((Object)30, (Object)"Fusion");
        this.idToValue.put((Object)31, (Object)"Trance");
        this.idToValue.put((Object)32, (Object)"Classical");
        this.idToValue.put((Object)33, (Object)"Instrumental");
        this.idToValue.put((Object)34, (Object)"Acid");
        this.idToValue.put((Object)35, (Object)"House");
        this.idToValue.put((Object)36, (Object)"Game");
        this.idToValue.put((Object)37, (Object)"Sound Clip");
        this.idToValue.put((Object)38, (Object)"Gospel");
        this.idToValue.put((Object)39, (Object)"Noise");
        this.idToValue.put((Object)40, (Object)"AlternRock");
        this.idToValue.put((Object)41, (Object)"Bass");
        this.idToValue.put((Object)42, (Object)"Soul");
        this.idToValue.put((Object)43, (Object)"Punk");
        this.idToValue.put((Object)44, (Object)"Space");
        this.idToValue.put((Object)45, (Object)"Meditative");
        this.idToValue.put((Object)46, (Object)"Instrumental Pop");
        this.idToValue.put((Object)47, (Object)"Instrumental Rock");
        this.idToValue.put((Object)48, (Object)"Ethnic");
        this.idToValue.put((Object)49, (Object)"Gothic");
        this.idToValue.put((Object)50, (Object)"Darkwave");
        this.idToValue.put((Object)51, (Object)"Techno-Industrial");
        this.idToValue.put((Object)52, (Object)"Electronic");
        this.idToValue.put((Object)53, (Object)"Pop-Folk");
        this.idToValue.put((Object)54, (Object)"Eurodance");
        this.idToValue.put((Object)55, (Object)"Dream");
        this.idToValue.put((Object)56, (Object)"Southern Rock");
        this.idToValue.put((Object)57, (Object)"Comedy");
        this.idToValue.put((Object)58, (Object)"Cult");
        this.idToValue.put((Object)59, (Object)"Gangsta");
        this.idToValue.put((Object)60, (Object)"Top 40");
        this.idToValue.put((Object)61, (Object)"Christian Rap");
        this.idToValue.put((Object)62, (Object)"Pop/Funk");
        this.idToValue.put((Object)63, (Object)"Jungle");
        this.idToValue.put((Object)64, (Object)"Native American");
        this.idToValue.put((Object)65, (Object)"Cabaret");
        this.idToValue.put((Object)66, (Object)"New Wave");
        this.idToValue.put((Object)67, (Object)"Psychadelic");
        this.idToValue.put((Object)68, (Object)"Rave");
        this.idToValue.put((Object)69, (Object)"Showtunes");
        this.idToValue.put((Object)70, (Object)"Trailer");
        this.idToValue.put((Object)71, (Object)"Lo-Fi");
        this.idToValue.put((Object)72, (Object)"Tribal");
        this.idToValue.put((Object)73, (Object)"Acid Punk");
        this.idToValue.put((Object)74, (Object)"Acid Jazz");
        this.idToValue.put((Object)75, (Object)"Polka");
        this.idToValue.put((Object)76, (Object)"Retro");
        this.idToValue.put((Object)77, (Object)"Musical");
        this.idToValue.put((Object)78, (Object)"Rock & Roll");
        this.idToValue.put((Object)79, (Object)"Hard Rock");
        this.idToValue.put((Object)80, (Object)"Folk");
        this.idToValue.put((Object)81, (Object)"Folk-Rock");
        this.idToValue.put((Object)82, (Object)"National Folk");
        this.idToValue.put((Object)83, (Object)"Swing");
        this.idToValue.put((Object)84, (Object)"Fast Fusion");
        this.idToValue.put((Object)85, (Object)"Bebob");
        this.idToValue.put((Object)86, (Object)"Latin");
        this.idToValue.put((Object)87, (Object)"Revival");
        this.idToValue.put((Object)88, (Object)"Celtic");
        this.idToValue.put((Object)89, (Object)"Bluegrass");
        this.idToValue.put((Object)90, (Object)"Avantgarde");
        this.idToValue.put((Object)91, (Object)"Gothic Rock");
        this.idToValue.put((Object)92, (Object)"Progressive Rock");
        this.idToValue.put((Object)93, (Object)"Psychedelic Rock");
        this.idToValue.put((Object)94, (Object)"Symphonic Rock");
        this.idToValue.put((Object)95, (Object)"Slow Rock");
        this.idToValue.put((Object)96, (Object)"Big Band");
        this.idToValue.put((Object)97, (Object)"Chorus");
        this.idToValue.put((Object)98, (Object)"Easy Listening");
        this.idToValue.put((Object)99, (Object)"Acoustic");
        this.idToValue.put((Object)100, (Object)"Humour");
        this.idToValue.put((Object)101, (Object)"Speech");
        this.idToValue.put((Object)102, (Object)"Chanson");
        this.idToValue.put((Object)103, (Object)"Opera");
        this.idToValue.put((Object)104, (Object)"Chamber Music");
        this.idToValue.put((Object)105, (Object)"Sonata");
        this.idToValue.put((Object)106, (Object)"Symphony");
        this.idToValue.put((Object)107, (Object)"Booty Bass");
        this.idToValue.put((Object)108, (Object)"Primus");
        this.idToValue.put((Object)109, (Object)"Porn Groove");
        this.idToValue.put((Object)110, (Object)"Satire");
        this.idToValue.put((Object)111, (Object)"Slow Jam");
        this.idToValue.put((Object)112, (Object)"Club");
        this.idToValue.put((Object)113, (Object)"Tango");
        this.idToValue.put((Object)114, (Object)"Samba");
        this.idToValue.put((Object)115, (Object)"Folklore");
        this.idToValue.put((Object)116, (Object)"Ballad");
        this.idToValue.put((Object)117, (Object)"Power Ballad");
        this.idToValue.put((Object)118, (Object)"Rhythmic Soul");
        this.idToValue.put((Object)119, (Object)"Freestyle");
        this.idToValue.put((Object)120, (Object)"Duet");
        this.idToValue.put((Object)121, (Object)"Punk Rock");
        this.idToValue.put((Object)122, (Object)"Drum Solo");
        this.idToValue.put((Object)123, (Object)"Acapella");
        this.idToValue.put((Object)124, (Object)"Euro-House");
        this.idToValue.put((Object)125, (Object)"Dance Hall");
        this.idToValue.put((Object)126, (Object)"Goa");
        this.idToValue.put((Object)127, (Object)"Drum & Bass");
        this.idToValue.put((Object)128, (Object)"Club-House");
        this.idToValue.put((Object)129, (Object)"Hardcore");
        this.idToValue.put((Object)130, (Object)"Terror");
        this.idToValue.put((Object)131, (Object)"Indie");
        this.idToValue.put((Object)132, (Object)"BritPop");
        this.idToValue.put((Object)133, (Object)"Negerpunk");
        this.idToValue.put((Object)134, (Object)"Polsk Punk");
        this.idToValue.put((Object)135, (Object)"Beat");
        this.idToValue.put((Object)136, (Object)"Christian Gangsta Rap");
        this.idToValue.put((Object)137, (Object)"Heavy Metal");
        this.idToValue.put((Object)138, (Object)"Black Metal");
        this.idToValue.put((Object)139, (Object)"Crossover");
        this.idToValue.put((Object)140, (Object)"Contemporary Christian");
        this.idToValue.put((Object)141, (Object)"Christian Rock");
        this.idToValue.put((Object)142, (Object)"Merengue");
        this.idToValue.put((Object)143, (Object)"Salsa");
        this.idToValue.put((Object)144, (Object)"Thrash Metal");
        this.idToValue.put((Object)145, (Object)"Anime");
        this.idToValue.put((Object)146, (Object)"JPop");
        this.idToValue.put((Object)147, (Object)"SynthPop");
        this.idToValue.put((Object)148, (Object)"Abstract");
        this.idToValue.put((Object)149, (Object)"Art Rock");
        this.idToValue.put((Object)150, (Object)"Baroque");
        this.idToValue.put((Object)151, (Object)"Bhangra");
        this.idToValue.put((Object)152, (Object)"Big Beat");
        this.idToValue.put((Object)153, (Object)"Breakbeat");
        this.idToValue.put((Object)154, (Object)"Chillout");
        this.idToValue.put((Object)155, (Object)"Downtempo");
        this.idToValue.put((Object)156, (Object)"Dub");
        this.idToValue.put((Object)157, (Object)"EBM");
        this.idToValue.put((Object)158, (Object)"Eclectic");
        this.idToValue.put((Object)159, (Object)"Electro");
        this.idToValue.put((Object)160, (Object)"Electroclash");
        this.idToValue.put((Object)161, (Object)"Emo");
        this.idToValue.put((Object)162, (Object)"Experimental");
        this.idToValue.put((Object)163, (Object)"Garage");
        this.idToValue.put((Object)164, (Object)"Global");
        this.idToValue.put((Object)165, (Object)"IDM");
        this.idToValue.put((Object)166, (Object)"Illbient");
        this.idToValue.put((Object)167, (Object)"Industro-Goth");
        this.idToValue.put((Object)168, (Object)"Jam Band");
        this.idToValue.put((Object)169, (Object)"Krautrock");
        this.idToValue.put((Object)170, (Object)"Leftfield");
        this.idToValue.put((Object)171, (Object)"Lounge");
        this.idToValue.put((Object)172, (Object)"Math Rock");
        this.idToValue.put((Object)173, (Object)"New Romantic");
        this.idToValue.put((Object)174, (Object)"Nu-Breakz");
        this.idToValue.put((Object)175, (Object)"Post-Punk");
        this.idToValue.put((Object)176, (Object)"Post-Rock");
        this.idToValue.put((Object)177, (Object)"Psytrance");
        this.idToValue.put((Object)178, (Object)"Shoegaze");
        this.idToValue.put((Object)179, (Object)"Space Rock");
        this.idToValue.put((Object)180, (Object)"Trop Rock");
        this.idToValue.put((Object)181, (Object)"World Music");
        this.idToValue.put((Object)182, (Object)"Neoclassical");
        this.idToValue.put((Object)183, (Object)"Audiobook");
        this.idToValue.put((Object)184, (Object)"Audio Theatre");
        this.idToValue.put((Object)185, (Object)"Neue Deutsche Welle");
        this.idToValue.put((Object)186, (Object)"Podcast");
        this.idToValue.put((Object)187, (Object)"Indie Rock");
        this.idToValue.put((Object)188, (Object)"G-Funk");
        this.idToValue.put((Object)189, (Object)"Dubstep");
        this.idToValue.put((Object)190, (Object)"Garage Rock");
        this.idToValue.put((Object)191, (Object)"Psybient");
        this.createMaps();
        this.nameToIdMap = new LinkedHashMap(this.idToValue.size());
        for (Map.Entry entry : this.idToValue.entrySet()) {
            this.nameToIdMap.put((Object)((String)entry.getValue()).toLowerCase(), (Object)((Integer)entry.getKey()));
        }
    }

    public static GenreTypes getInstanceOf() {
        if (genreTypes == null) {
            genreTypes = new GenreTypes();
        }
        return genreTypes;
    }

    public static int getMaxGenreId() {
        return 191;
    }

    public static int getMaxStandardGenreId() {
        return 125;
    }

    public Integer getIdForName(String string2) {
        return (Integer)this.nameToIdMap.get((Object)string2.toLowerCase());
    }
}

