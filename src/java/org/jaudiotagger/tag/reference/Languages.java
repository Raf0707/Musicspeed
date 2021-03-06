/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package org.jaudiotagger.tag.reference;

import java.util.Map;
import org.jaudiotagger.tag.datatype.AbstractStringStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class Languages
extends AbstractStringStringValuePair {
    public static final String DEFAULT_ID = "eng";
    public static final String DEFAULT_VALUE = "English";
    public static final int LANGUAGE_FIELD_SIZE = 3;
    public static final String MEDIA_MONKEY_ID = "XXX";
    public static final String WINAMP_ID = "\u0000\u0000\u0000";
    private static Languages languageTypes;

    private Languages() {
        this.idToValue.put((Object)"aar", (Object)"Afar");
        this.idToValue.put((Object)"abk", (Object)"Abkhazian");
        this.idToValue.put((Object)"ace", (Object)"Achinese");
        this.idToValue.put((Object)"ach", (Object)"Acoli");
        this.idToValue.put((Object)"ada", (Object)"Adangme");
        this.idToValue.put((Object)"afa", (Object)"Afro-Asiatic");
        this.idToValue.put((Object)"afh", (Object)"Afrihili");
        this.idToValue.put((Object)"afr", (Object)"Afrikaans");
        this.idToValue.put((Object)"aka", (Object)"Akan");
        this.idToValue.put((Object)"akk", (Object)"Akkadian");
        this.idToValue.put((Object)"alb", (Object)"Albanian");
        this.idToValue.put((Object)"ale", (Object)"Aleut");
        this.idToValue.put((Object)"alg", (Object)"Algonquian languages");
        this.idToValue.put((Object)"amh", (Object)"Amharic");
        this.idToValue.put((Object)"ang", (Object)"Old English,(ca.450-1100)");
        this.idToValue.put((Object)"apa", (Object)"Apache languages");
        this.idToValue.put((Object)"ara", (Object)"Arabic");
        this.idToValue.put((Object)"arc", (Object)"Aramaic");
        this.idToValue.put((Object)"arm", (Object)"Armenian");
        this.idToValue.put((Object)"arn", (Object)"Araucanian");
        this.idToValue.put((Object)"arp", (Object)"Arapaho");
        this.idToValue.put((Object)"art", (Object)"Artificial");
        this.idToValue.put((Object)"arw", (Object)"Arawak");
        this.idToValue.put((Object)"asm", (Object)"Assamese");
        this.idToValue.put((Object)"ast", (Object)"Asturian; Bable");
        this.idToValue.put((Object)"ath", (Object)"Athapascan languages");
        this.idToValue.put((Object)"aus", (Object)"Australian languages");
        this.idToValue.put((Object)"ava", (Object)"Avaric");
        this.idToValue.put((Object)"ave", (Object)"Avestan");
        this.idToValue.put((Object)"awa", (Object)"Awadhi");
        this.idToValue.put((Object)"aym", (Object)"Aymara");
        this.idToValue.put((Object)"aze", (Object)"Azerbaijani");
        this.idToValue.put((Object)"bad", (Object)"Banda");
        this.idToValue.put((Object)"bai", (Object)"Bamileke languages");
        this.idToValue.put((Object)"bak", (Object)"Bashkir");
        this.idToValue.put((Object)"bal", (Object)"Baluchi");
        this.idToValue.put((Object)"bam", (Object)"Bambara");
        this.idToValue.put((Object)"ban", (Object)"Balinese");
        this.idToValue.put((Object)"baq", (Object)"Basque");
        this.idToValue.put((Object)"bas", (Object)"Basa");
        this.idToValue.put((Object)"bat", (Object)"Baltic");
        this.idToValue.put((Object)"bej", (Object)"Beja");
        this.idToValue.put((Object)"bel", (Object)"Belarusian");
        this.idToValue.put((Object)"bem", (Object)"Bemba");
        this.idToValue.put((Object)"ben", (Object)"Bengali");
        this.idToValue.put((Object)"ber", (Object)"Berber");
        this.idToValue.put((Object)"bho", (Object)"Bhojpuri");
        this.idToValue.put((Object)"bih", (Object)"Bihari");
        this.idToValue.put((Object)"bik", (Object)"Bikol");
        this.idToValue.put((Object)"bin", (Object)"Bini");
        this.idToValue.put((Object)"bis", (Object)"Bislama");
        this.idToValue.put((Object)"bla", (Object)"Siksika");
        this.idToValue.put((Object)"bnt", (Object)"Bantu");
        this.idToValue.put((Object)"bod", (Object)"Tibetan");
        this.idToValue.put((Object)"bos", (Object)"Bosnian");
        this.idToValue.put((Object)"bra", (Object)"Braj");
        this.idToValue.put((Object)"bre", (Object)"Breton");
        this.idToValue.put((Object)"btk", (Object)"Batak (Indonesia)");
        this.idToValue.put((Object)"bua", (Object)"Buriat");
        this.idToValue.put((Object)"bug", (Object)"Buginese");
        this.idToValue.put((Object)"bul", (Object)"Bulgarian");
        this.idToValue.put((Object)"bur", (Object)"Burmese");
        this.idToValue.put((Object)"cad", (Object)"Caddo");
        this.idToValue.put((Object)"cai", (Object)"Central American Indian");
        this.idToValue.put((Object)"car", (Object)"Carib");
        this.idToValue.put((Object)"cat", (Object)"Catalan");
        this.idToValue.put((Object)"cau", (Object)"Caucasian");
        this.idToValue.put((Object)"ceb", (Object)"Cebuano");
        this.idToValue.put((Object)"cel", (Object)"Celtic");
        this.idToValue.put((Object)"ces", (Object)"Czech");
        this.idToValue.put((Object)"cha", (Object)"Chamorro");
        this.idToValue.put((Object)"chb", (Object)"Chibcha");
        this.idToValue.put((Object)"che", (Object)"Chechen");
        this.idToValue.put((Object)"chg", (Object)"Chagatai");
        this.idToValue.put((Object)"chi", (Object)"Chinese");
        this.idToValue.put((Object)"chk", (Object)"Chuukese");
        this.idToValue.put((Object)"chm", (Object)"Mari");
        this.idToValue.put((Object)"chn", (Object)"Chinook jargon");
        this.idToValue.put((Object)"cho", (Object)"Choctaw");
        this.idToValue.put((Object)"chp", (Object)"Chipewyan");
        this.idToValue.put((Object)"chr", (Object)"Cherokee");
        this.idToValue.put((Object)"chu", (Object)"Church Slavic");
        this.idToValue.put((Object)"chv", (Object)"Chuvash");
        this.idToValue.put((Object)"chy", (Object)"Cheyenne");
        this.idToValue.put((Object)"cmc", (Object)"Chamic languages");
        this.idToValue.put((Object)"cop", (Object)"Coptic");
        this.idToValue.put((Object)"cor", (Object)"Cornish");
        this.idToValue.put((Object)"cos", (Object)"Corsican");
        this.idToValue.put((Object)"cpe", (Object)"Creoles and pidgins, English based");
        this.idToValue.put((Object)"cpf", (Object)"Creoles and pidgins, French based");
        this.idToValue.put((Object)"cpp", (Object)"Creoles and pidgins");
        this.idToValue.put((Object)"cre", (Object)"Cree");
        this.idToValue.put((Object)"crp", (Object)"Creoles and pidgins");
        this.idToValue.put((Object)"cus", (Object)"Cushitic");
        this.idToValue.put((Object)"cym", (Object)"Welsh");
        this.idToValue.put((Object)"cze", (Object)"Czech");
        this.idToValue.put((Object)"dak", (Object)"Dakota");
        this.idToValue.put((Object)"dan", (Object)"Danish");
        this.idToValue.put((Object)"day", (Object)"Dayak");
        this.idToValue.put((Object)"del", (Object)"Delaware");
        this.idToValue.put((Object)"den", (Object)"Slave (Athapascan)");
        this.idToValue.put((Object)"deu", (Object)"German");
        this.idToValue.put((Object)"dgr", (Object)"Dogrib");
        this.idToValue.put((Object)"din", (Object)"Dinka");
        this.idToValue.put((Object)"div", (Object)"Divehi");
        this.idToValue.put((Object)"doi", (Object)"Dogri");
        this.idToValue.put((Object)"dra", (Object)"Dravidian");
        this.idToValue.put((Object)"dua", (Object)"Duala");
        this.idToValue.put((Object)"dum", (Object)"Dutch, Middle (ca.1050-1350)");
        this.idToValue.put((Object)"dut", (Object)"Dutch");
        this.idToValue.put((Object)"dyu", (Object)"Dyula");
        this.idToValue.put((Object)"dzo", (Object)"Dzongkha");
        this.idToValue.put((Object)"efi", (Object)"Efik");
        this.idToValue.put((Object)"egy", (Object)"Egyptian (Ancient)");
        this.idToValue.put((Object)"eka", (Object)"Ekajuk");
        this.idToValue.put((Object)"ell", (Object)"Greek, Modern (1453-)");
        this.idToValue.put((Object)"elx", (Object)"Elamite");
        this.idToValue.put((Object)DEFAULT_ID, (Object)DEFAULT_VALUE);
        this.idToValue.put((Object)"enm", (Object)"English, Middle (1100-1500)");
        this.idToValue.put((Object)"epo", (Object)"Esperanto");
        this.idToValue.put((Object)"est", (Object)"Estonian");
        this.idToValue.put((Object)"eus", (Object)"Basque");
        this.idToValue.put((Object)"ewe", (Object)"Ewe");
        this.idToValue.put((Object)"ewo", (Object)"Ewondo");
        this.idToValue.put((Object)"fan", (Object)"Fang");
        this.idToValue.put((Object)"fao", (Object)"Faroese");
        this.idToValue.put((Object)"fas", (Object)"Persian");
        this.idToValue.put((Object)"fat", (Object)"Fanti");
        this.idToValue.put((Object)"fij", (Object)"Fijian");
        this.idToValue.put((Object)"fin", (Object)"Finnish");
        this.idToValue.put((Object)"fiu", (Object)"Finno-Ugrian");
        this.idToValue.put((Object)"fon", (Object)"Fon");
        this.idToValue.put((Object)"fra", (Object)"French");
        this.idToValue.put((Object)"frm", (Object)"French, Middle (ca.1400-1800)");
        this.idToValue.put((Object)"fro", (Object)"French, Old (842-ca.1400)");
        this.idToValue.put((Object)"fry", (Object)"Frisian");
        this.idToValue.put((Object)"ful", (Object)"Fulah");
        this.idToValue.put((Object)"fur", (Object)"Friulian");
        this.idToValue.put((Object)"gaa", (Object)"Ga");
        this.idToValue.put((Object)"gay", (Object)"Gayo");
        this.idToValue.put((Object)"gba", (Object)"Gbaya");
        this.idToValue.put((Object)"gem", (Object)"Germanic");
        this.idToValue.put((Object)"geo", (Object)"Georgian");
        this.idToValue.put((Object)"ger", (Object)"German");
        this.idToValue.put((Object)"gez", (Object)"Geez");
        this.idToValue.put((Object)"gil", (Object)"Gilbertese");
        this.idToValue.put((Object)"gla", (Object)"Gaelic; Scottish Gaelic");
        this.idToValue.put((Object)"gle", (Object)"Irish");
        this.idToValue.put((Object)"glg", (Object)"Gallegan");
        this.idToValue.put((Object)"glv", (Object)"Manx");
        this.idToValue.put((Object)"gmh", (Object)"German, Middle High (ca.1050-1500)");
        this.idToValue.put((Object)"goh", (Object)"German, Old High (ca.750-1050)");
        this.idToValue.put((Object)"gon", (Object)"Gondi");
        this.idToValue.put((Object)"gor", (Object)"Gorontalo");
        this.idToValue.put((Object)"got", (Object)"Gothic");
        this.idToValue.put((Object)"grb", (Object)"Grebo");
        this.idToValue.put((Object)"grc", (Object)"Greek, Ancient (to 1453)");
        this.idToValue.put((Object)"gre", (Object)"Greek, Modern (1453-)");
        this.idToValue.put((Object)"grn", (Object)"Guarani");
        this.idToValue.put((Object)"guj", (Object)"Gujarati");
        this.idToValue.put((Object)"gwi", (Object)"Gwich\u00b4in");
        this.idToValue.put((Object)"hai", (Object)"Haida");
        this.idToValue.put((Object)"hau", (Object)"Hausa");
        this.idToValue.put((Object)"haw", (Object)"Hawaiian");
        this.idToValue.put((Object)"heb", (Object)"Hebrew");
        this.idToValue.put((Object)"her", (Object)"Herero");
        this.idToValue.put((Object)"hil", (Object)"Hiligaynon");
        this.idToValue.put((Object)"him", (Object)"Himachali");
        this.idToValue.put((Object)"hin", (Object)"Hindi");
        this.idToValue.put((Object)"hit", (Object)"Hittite");
        this.idToValue.put((Object)"hmn", (Object)"Hmong");
        this.idToValue.put((Object)"hmo", (Object)"Hiri Motu");
        this.idToValue.put((Object)"hrv", (Object)"Croatian");
        this.idToValue.put((Object)"hun", (Object)"Hungarian");
        this.idToValue.put((Object)"hup", (Object)"Hupa");
        this.idToValue.put((Object)"hye", (Object)"Armenian");
        this.idToValue.put((Object)"iba", (Object)"Iban");
        this.idToValue.put((Object)"ibo", (Object)"Igbo");
        this.idToValue.put((Object)"ice", (Object)"Icelandic");
        this.idToValue.put((Object)"ido", (Object)"Ido");
        this.idToValue.put((Object)"ijo", (Object)"Ijo");
        this.idToValue.put((Object)"iku", (Object)"Inuktitut");
        this.idToValue.put((Object)"ile", (Object)"Interlingue");
        this.idToValue.put((Object)"ilo", (Object)"Iloko");
        this.idToValue.put((Object)"ina", (Object)"Interlingua");
        this.idToValue.put((Object)"inc", (Object)"Indic");
        this.idToValue.put((Object)"ind", (Object)"Indonesian");
        this.idToValue.put((Object)"ine", (Object)"Indo-European");
        this.idToValue.put((Object)"ipk", (Object)"Inupiaq");
        this.idToValue.put((Object)"ira", (Object)"Iranian (Other)");
        this.idToValue.put((Object)"iro", (Object)"Iroquoian languages");
        this.idToValue.put((Object)"isl", (Object)"Icelandic");
        this.idToValue.put((Object)"ita", (Object)"Italian");
        this.idToValue.put((Object)"jav", (Object)"Javanese");
        this.idToValue.put((Object)"jpn", (Object)"Japanese");
        this.idToValue.put((Object)"jpr", (Object)"Judeo-Persian");
        this.idToValue.put((Object)"jrb", (Object)"Judeo-Arabic");
        this.idToValue.put((Object)"kaa", (Object)"Kara-Kalpak");
        this.idToValue.put((Object)"kab", (Object)"Kabyle");
        this.idToValue.put((Object)"kac", (Object)"Kachin");
        this.idToValue.put((Object)"kal", (Object)"Kalaallisut");
        this.idToValue.put((Object)"kam", (Object)"Kamba");
        this.idToValue.put((Object)"kan", (Object)"Kannada");
        this.idToValue.put((Object)"kar", (Object)"Karen");
        this.idToValue.put((Object)"kas", (Object)"Kashmiri");
        this.idToValue.put((Object)"kat", (Object)"Georgian");
        this.idToValue.put((Object)"kau", (Object)"Kanuri");
        this.idToValue.put((Object)"kaw", (Object)"Kawi");
        this.idToValue.put((Object)"kaz", (Object)"Kazakh");
        this.idToValue.put((Object)"kha", (Object)"Khasi");
        this.idToValue.put((Object)"khi", (Object)"Khoisan");
        this.idToValue.put((Object)"khm", (Object)"Khmer");
        this.idToValue.put((Object)"kho", (Object)"Khotanese");
        this.idToValue.put((Object)"kik", (Object)"Kikuyu; Gikuyu");
        this.idToValue.put((Object)"kin", (Object)"Kinyarwanda");
        this.idToValue.put((Object)"kir", (Object)"Kirghiz");
        this.idToValue.put((Object)"kmb", (Object)"Kimbundu");
        this.idToValue.put((Object)"kok", (Object)"Konkani");
        this.idToValue.put((Object)"kom", (Object)"Komi");
        this.idToValue.put((Object)"kon", (Object)"Kongo");
        this.idToValue.put((Object)"kor", (Object)"Korean");
        this.idToValue.put((Object)"kos", (Object)"Kosraean");
        this.idToValue.put((Object)"kpe", (Object)"Kpelle");
        this.idToValue.put((Object)"kro", (Object)"Kru");
        this.idToValue.put((Object)"kru", (Object)"Kurukh");
        this.idToValue.put((Object)"kua", (Object)"Kuanyama; Kwanyama");
        this.idToValue.put((Object)"kum", (Object)"Kumyk");
        this.idToValue.put((Object)"kur", (Object)"Kurdish");
        this.idToValue.put((Object)"kut", (Object)"Kutenai");
        this.idToValue.put((Object)"lad", (Object)"Ladino");
        this.idToValue.put((Object)"lah", (Object)"Lahnda");
        this.idToValue.put((Object)"lam", (Object)"Lamba");
        this.idToValue.put((Object)"lao", (Object)"Lao");
        this.idToValue.put((Object)"lat", (Object)"Latin");
        this.idToValue.put((Object)"lav", (Object)"Latvian");
        this.idToValue.put((Object)"lez", (Object)"Lezghian");
        this.idToValue.put((Object)"lin", (Object)"Lingala");
        this.idToValue.put((Object)"lit", (Object)"Lithuanian");
        this.idToValue.put((Object)"lol", (Object)"Mongo");
        this.idToValue.put((Object)"loz", (Object)"Lozi");
        this.idToValue.put((Object)"ltz", (Object)"Luxembourgish; Letzeburgesch");
        this.idToValue.put((Object)"lua", (Object)"Luba-Lulua");
        this.idToValue.put((Object)"lub", (Object)"Luba-Katanga");
        this.idToValue.put((Object)"lug", (Object)"Ganda");
        this.idToValue.put((Object)"lui", (Object)"Luiseno");
        this.idToValue.put((Object)"lun", (Object)"Lunda");
        this.idToValue.put((Object)"luo", (Object)"Luo (Kenya and Tanzania)");
        this.idToValue.put((Object)"lus", (Object)"lushai");
        this.idToValue.put((Object)"mac", (Object)"Macedonian");
        this.idToValue.put((Object)"mad", (Object)"Madurese");
        this.idToValue.put((Object)"mag", (Object)"Magahi");
        this.idToValue.put((Object)"mah", (Object)"Marshallese");
        this.idToValue.put((Object)"mai", (Object)"Maithili");
        this.idToValue.put((Object)"mak", (Object)"Makasar");
        this.idToValue.put((Object)"mal", (Object)"Malayalam");
        this.idToValue.put((Object)"man", (Object)"Mandingo");
        this.idToValue.put((Object)"mao", (Object)"Maori");
        this.idToValue.put((Object)"map", (Object)"Austronesian");
        this.idToValue.put((Object)"mar", (Object)"Marathi");
        this.idToValue.put((Object)"mas", (Object)"Masai");
        this.idToValue.put((Object)"may", (Object)"Malay");
        this.idToValue.put((Object)"mdr", (Object)"Mandar");
        this.idToValue.put((Object)"men", (Object)"Mende");
        this.idToValue.put((Object)"mga", (Object)"Irish, Middle (900-1200)");
        this.idToValue.put((Object)"mic", (Object)"Micmac");
        this.idToValue.put((Object)"min", (Object)"Minangkabau");
        this.idToValue.put((Object)"mis", (Object)"Miscellaneous languages");
        this.idToValue.put((Object)"mkd", (Object)"Macedonian");
        this.idToValue.put((Object)"mkh", (Object)"Mon-Khmer");
        this.idToValue.put((Object)"mlg", (Object)"Malagasy");
        this.idToValue.put((Object)"mlt", (Object)"Maltese");
        this.idToValue.put((Object)"mnc", (Object)"Manchu");
        this.idToValue.put((Object)"mni", (Object)"Manipuri");
        this.idToValue.put((Object)"mno", (Object)"Manobo languages");
        this.idToValue.put((Object)"moh", (Object)"Mohawk");
        this.idToValue.put((Object)"mol", (Object)"Moldavian");
        this.idToValue.put((Object)"mon", (Object)"Mongolian");
        this.idToValue.put((Object)"mos", (Object)"Mossi");
        this.idToValue.put((Object)"mri", (Object)"Maori");
        this.idToValue.put((Object)"msa", (Object)"Malay");
        this.idToValue.put((Object)"mul", (Object)"Multiple languages");
        this.idToValue.put((Object)"mun", (Object)"Munda languages");
        this.idToValue.put((Object)"mus", (Object)"Creek");
        this.idToValue.put((Object)"mwr", (Object)"Marwari");
        this.idToValue.put((Object)"mya", (Object)"Burmese");
        this.idToValue.put((Object)"myn", (Object)"Mayan languages");
        this.idToValue.put((Object)"nah", (Object)"Nahuatl");
        this.idToValue.put((Object)"nai", (Object)"North American Indian");
        this.idToValue.put((Object)"nau", (Object)"Nauru");
        this.idToValue.put((Object)"nav", (Object)"Navajo; Navaho");
        this.idToValue.put((Object)"nbl", (Object)"South Ndebele");
        this.idToValue.put((Object)"nde", (Object)"North Ndebele");
        this.idToValue.put((Object)"ndo", (Object)"Ndonga");
        this.idToValue.put((Object)"nds", (Object)"Low German; Low Saxon");
        this.idToValue.put((Object)"nep", (Object)"Nepali");
        this.idToValue.put((Object)"new", (Object)"Newari");
        this.idToValue.put((Object)"nia", (Object)"Nias");
        this.idToValue.put((Object)"nic", (Object)"Niger-Kordofanian");
        this.idToValue.put((Object)"niu", (Object)"Niuean");
        this.idToValue.put((Object)"nld", (Object)"Dutch");
        this.idToValue.put((Object)"nno", (Object)"Norwegian Nynorsk");
        this.idToValue.put((Object)"nob", (Object)"Norwegian Bokm\u00e5l");
        this.idToValue.put((Object)"non", (Object)"Norse, Old");
        this.idToValue.put((Object)"nor", (Object)"Norwegian");
        this.idToValue.put((Object)"nso", (Object)"Sotho, Northern");
        this.idToValue.put((Object)"nub", (Object)"Nubian languages");
        this.idToValue.put((Object)"nya", (Object)"Chichewa; Chewa; Nyanja");
        this.idToValue.put((Object)"nym", (Object)"Nyamwezi");
        this.idToValue.put((Object)"nyn", (Object)"Nyankole");
        this.idToValue.put((Object)"nyo", (Object)"Nyoro");
        this.idToValue.put((Object)"nzi", (Object)"Nzima");
        this.idToValue.put((Object)"oci", (Object)"Occitan (post 1500); Proven\u00e7al");
        this.idToValue.put((Object)"oji", (Object)"Ojibwa");
        this.idToValue.put((Object)"ori", (Object)"Oriya");
        this.idToValue.put((Object)"orm", (Object)"Oromo");
        this.idToValue.put((Object)"osa", (Object)"Osage");
        this.idToValue.put((Object)"oss", (Object)"Ossetian; Ossetic");
        this.idToValue.put((Object)"ota", (Object)"Turkish, Ottoman (1500-1928)");
        this.idToValue.put((Object)"oto", (Object)"Otomian languages");
        this.idToValue.put((Object)"paa", (Object)"Papuan");
        this.idToValue.put((Object)"pag", (Object)"Pangasinan");
        this.idToValue.put((Object)"pal", (Object)"Pahlavi");
        this.idToValue.put((Object)"pam", (Object)"Pampanga");
        this.idToValue.put((Object)"pan", (Object)"Panjabi");
        this.idToValue.put((Object)"pap", (Object)"Papiamento");
        this.idToValue.put((Object)"pau", (Object)"Palauan");
        this.idToValue.put((Object)"peo", (Object)"Persian, Old (ca.600-400 B.C.)");
        this.idToValue.put((Object)"per", (Object)"Persian");
        this.idToValue.put((Object)"per", (Object)"Persian");
        this.idToValue.put((Object)"phi", (Object)"Philippine");
        this.idToValue.put((Object)"phn", (Object)"Phoenician");
        this.idToValue.put((Object)"pli", (Object)"Pali");
        this.idToValue.put((Object)"pol", (Object)"Polish");
        this.idToValue.put((Object)"pon", (Object)"Pohnpeian");
        this.idToValue.put((Object)"por", (Object)"Portuguese");
        this.idToValue.put((Object)"pra", (Object)"Prakrit languages");
        this.idToValue.put((Object)"pro", (Object)"Proven\u00e7al, Old (to 1500)");
        this.idToValue.put((Object)"pus", (Object)"Pushto");
        this.idToValue.put((Object)"que", (Object)"Quechua");
        this.idToValue.put((Object)"raj", (Object)"Rajasthani");
        this.idToValue.put((Object)"rap", (Object)"Rapanui");
        this.idToValue.put((Object)"rar", (Object)"Rarotongan");
        this.idToValue.put((Object)"roa", (Object)"Romance");
        this.idToValue.put((Object)"roh", (Object)"Raeto-Romance");
        this.idToValue.put((Object)"rom", (Object)"Romany");
        this.idToValue.put((Object)"ron", (Object)"Romanian");
        this.idToValue.put((Object)"rum", (Object)"Romanian");
        this.idToValue.put((Object)"run", (Object)"Rundi");
        this.idToValue.put((Object)"rus", (Object)"Russian");
        this.idToValue.put((Object)"sad", (Object)"Sandawe");
        this.idToValue.put((Object)"sag", (Object)"Sango");
        this.idToValue.put((Object)"sah", (Object)"Yakut");
        this.idToValue.put((Object)"sai", (Object)"South American Indian");
        this.idToValue.put((Object)"sal", (Object)"Salishan languages");
        this.idToValue.put((Object)"sam", (Object)"Samaritan Aramaic");
        this.idToValue.put((Object)"san", (Object)"Sanskrit");
        this.idToValue.put((Object)"sas", (Object)"Sasak");
        this.idToValue.put((Object)"sat", (Object)"Santali");
        this.idToValue.put((Object)"scc", (Object)"Serbian");
        this.idToValue.put((Object)"sco", (Object)"Scots");
        this.idToValue.put((Object)"scr", (Object)"Croatian");
        this.idToValue.put((Object)"sel", (Object)"Selkup");
        this.idToValue.put((Object)"sem", (Object)"Semitic");
        this.idToValue.put((Object)"sga", (Object)"Irish, Old (to 900)");
        this.idToValue.put((Object)"sgn", (Object)"Sign languages");
        this.idToValue.put((Object)"shn", (Object)"Shan");
        this.idToValue.put((Object)"sid", (Object)"Sidamo");
        this.idToValue.put((Object)"sin", (Object)"Sinhales");
        this.idToValue.put((Object)"sio", (Object)"Siouan languages");
        this.idToValue.put((Object)"sit", (Object)"Sino-Tibetan");
        this.idToValue.put((Object)"sla", (Object)"Slavic");
        this.idToValue.put((Object)"slk", (Object)"Slovak");
        this.idToValue.put((Object)"slo", (Object)"Slovak");
        this.idToValue.put((Object)"slv", (Object)"Slovenian");
        this.idToValue.put((Object)"sma", (Object)"Southern Sami");
        this.idToValue.put((Object)"sme", (Object)"Northern Sami");
        this.idToValue.put((Object)"smi", (Object)"Sami languages");
        this.idToValue.put((Object)"smj", (Object)"Lule Sami");
        this.idToValue.put((Object)"smn", (Object)"Inari Sami");
        this.idToValue.put((Object)"smo", (Object)"Samoan");
        this.idToValue.put((Object)"sms", (Object)"Skolt Sami");
        this.idToValue.put((Object)"sna", (Object)"Shona");
        this.idToValue.put((Object)"snd", (Object)"Sindhi");
        this.idToValue.put((Object)"snk", (Object)"Soninke");
        this.idToValue.put((Object)"sog", (Object)"Sogdian");
        this.idToValue.put((Object)"som", (Object)"Somali");
        this.idToValue.put((Object)"son", (Object)"Songhai");
        this.idToValue.put((Object)"sot", (Object)"Sotho, Southern");
        this.idToValue.put((Object)"spa", (Object)"Spanish; Castilia");
        this.idToValue.put((Object)"sqi", (Object)"Albanian");
        this.idToValue.put((Object)"srd", (Object)"Sardinian");
        this.idToValue.put((Object)"srp", (Object)"Serbian");
        this.idToValue.put((Object)"srr", (Object)"Serer");
        this.idToValue.put((Object)"ssa", (Object)"Nilo-Saharan");
        this.idToValue.put((Object)"sus", (Object)"Susu");
        this.idToValue.put((Object)"sux", (Object)"Sumerian");
        this.idToValue.put((Object)"swa", (Object)"Swahili");
        this.idToValue.put((Object)"swe", (Object)"Swedish");
        this.idToValue.put((Object)"syr", (Object)"Syriac");
        this.idToValue.put((Object)"tah", (Object)"Tahitian");
        this.idToValue.put((Object)"tai", (Object)"Tai");
        this.idToValue.put((Object)"tam", (Object)"Tamil");
        this.idToValue.put((Object)"tat", (Object)"Tatar");
        this.idToValue.put((Object)"tel", (Object)"Telugu");
        this.idToValue.put((Object)"tem", (Object)"Timne");
        this.idToValue.put((Object)"ter", (Object)"Tereno");
        this.idToValue.put((Object)"tet", (Object)"Tetum");
        this.idToValue.put((Object)"tgk", (Object)"Tajik");
        this.idToValue.put((Object)"tgl", (Object)"Tagalog");
        this.idToValue.put((Object)"tha", (Object)"Thai");
        this.idToValue.put((Object)"tib", (Object)"Tibetan");
        this.idToValue.put((Object)"tig", (Object)"Tigre");
        this.idToValue.put((Object)"tir", (Object)"Tigrinya");
        this.idToValue.put((Object)"tiv", (Object)"Tiv");
        this.idToValue.put((Object)"tkl", (Object)"Tokelau");
        this.idToValue.put((Object)"tli", (Object)"Tlingit");
        this.idToValue.put((Object)"tmh", (Object)"Tamashek");
        this.idToValue.put((Object)"tog", (Object)"Tonga (Nyasa)");
        this.idToValue.put((Object)"ton", (Object)"Tonga (Tonga Islands)");
        this.idToValue.put((Object)"tpi", (Object)"Tok Pisin");
        this.idToValue.put((Object)"tsi", (Object)"Tsimshian");
        this.idToValue.put((Object)"tsn", (Object)"Tswana");
        this.idToValue.put((Object)"tso", (Object)"Tsonga");
        this.idToValue.put((Object)"tuk", (Object)"Turkmen");
        this.idToValue.put((Object)"tum", (Object)"Tumbuka");
        this.idToValue.put((Object)"tup", (Object)"Tupi");
        this.idToValue.put((Object)"tur", (Object)"Turkish");
        this.idToValue.put((Object)"tut", (Object)"Altaic");
        this.idToValue.put((Object)"tvl", (Object)"Tuvalu");
        this.idToValue.put((Object)"twi", (Object)"Twi");
        this.idToValue.put((Object)"tyv", (Object)"Tuvinian");
        this.idToValue.put((Object)"uga", (Object)"Ugaritic");
        this.idToValue.put((Object)"uig", (Object)"Uighur");
        this.idToValue.put((Object)"ukr", (Object)"Ukrainian");
        this.idToValue.put((Object)"umb", (Object)"Umbundu");
        this.idToValue.put((Object)"und", (Object)"Undetermined");
        this.idToValue.put((Object)"urd", (Object)"Urdu");
        this.idToValue.put((Object)"uzb", (Object)"Uzbek");
        this.idToValue.put((Object)"vai", (Object)"Vai");
        this.idToValue.put((Object)"ven", (Object)"Venda");
        this.idToValue.put((Object)"vie", (Object)"Vietnamese");
        this.idToValue.put((Object)"vol", (Object)"Volap\u00fck");
        this.idToValue.put((Object)"vot", (Object)"Votic");
        this.idToValue.put((Object)"wak", (Object)"Wakashan languages");
        this.idToValue.put((Object)"wal", (Object)"Walamo");
        this.idToValue.put((Object)"war", (Object)"Waray");
        this.idToValue.put((Object)"was", (Object)"Washo");
        this.idToValue.put((Object)"wel", (Object)"Welsh");
        this.idToValue.put((Object)"wen", (Object)"Sorbian languages");
        this.idToValue.put((Object)"wln", (Object)"Walloon");
        this.idToValue.put((Object)"wol", (Object)"Wolof");
        this.idToValue.put((Object)"xho", (Object)"Xhosa");
        this.idToValue.put((Object)"yao", (Object)"Yao");
        this.idToValue.put((Object)"yap", (Object)"Yapese");
        this.idToValue.put((Object)"yid", (Object)"Yiddish");
        this.idToValue.put((Object)"yor", (Object)"Yoruba");
        this.idToValue.put((Object)"ypk", (Object)"Yupik languages");
        this.idToValue.put((Object)"zap", (Object)"Zapotec");
        this.idToValue.put((Object)"zen", (Object)"Zenaga");
        this.idToValue.put((Object)"zha", (Object)"Zhuang; Chuang");
        this.idToValue.put((Object)"zho", (Object)"Chinese");
        this.idToValue.put((Object)"znd", (Object)"Zande");
        this.idToValue.put((Object)"zul", (Object)"Zulu");
        this.idToValue.put((Object)"zun", (Object)"Zuni");
        this.idToValue.put((Object)WINAMP_ID, (Object)"Winamp Format");
        this.idToValue.put((Object)MEDIA_MONKEY_ID, (Object)"Media Monkey Format");
        this.createMaps();
    }

    public static Languages getInstanceOf() {
        if (languageTypes == null) {
            languageTypes = new Languages();
        }
        return languageTypes;
    }
}

