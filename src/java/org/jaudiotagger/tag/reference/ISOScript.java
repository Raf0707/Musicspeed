/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.tag.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ISOScript {
    private static Map<String, Script> codeMap = new HashMap();
    private static Map<String, Script> descriptionMap;

    static {
        Script[] arrscript = Script.values();
        int n2 = arrscript.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Script script = arrscript[i2];
            codeMap.put((Object)script.code, (Object)script);
        }
        descriptionMap = new HashMap();
        Script[] arrscript2 = Script.values();
        int n4 = arrscript2.length;
        while (n3 < n4) {
            Script script = arrscript2[n3];
            descriptionMap.put((Object)script.description, (Object)script);
            ++n3;
        }
    }

    public static String[] getDescriptionsAsArray() {
        ArrayList arrayList = new ArrayList();
        Script[] arrscript = Script.values();
        int n2 = arrscript.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)arrscript[i2].description);
        }
        return (String[])arrayList.toArray((Object[])new String[0]);
    }

    public static Script getScriptByCode(String string2) {
        return (Script)((Object)codeMap.get((Object)string2));
    }

    public static Script getScriptByDescription(String string2) {
        return (Script)((Object)descriptionMap.get((Object)string2));
    }

    public static final class Script
    extends Enum<Script> {
        private static final /* synthetic */ Script[] $VALUES;
        public static final /* enum */ Script ARABIC = new Script("Arab", "Arabic");
        public static final /* enum */ Script ARMENIAN;
        public static final /* enum */ Script AVESTAN;
        public static final /* enum */ Script BALINESE;
        public static final /* enum */ Script BATAK;
        public static final /* enum */ Script BENGALI;
        public static final /* enum */ Script BLISSYMBOLS;
        public static final /* enum */ Script BOOK_PAHLAVI;
        public static final /* enum */ Script BOPOMOFO;
        public static final /* enum */ Script BRAHMI;
        public static final /* enum */ Script BRAILLE;
        public static final /* enum */ Script BUGINESE;
        public static final /* enum */ Script BUHID;
        public static final /* enum */ Script CANADIAN_SYLLABICS;
        public static final /* enum */ Script CARIAN;
        public static final /* enum */ Script CHAKMA;
        public static final /* enum */ Script CHAM;
        public static final /* enum */ Script CHEROKEE;
        public static final /* enum */ Script CIRTH;
        public static final /* enum */ Script COPTIC;
        public static final /* enum */ Script CUNEIFORM_SUMERO_AKKADIAN;
        public static final /* enum */ Script CYPRIOT;
        public static final /* enum */ Script CYRILLIC;
        public static final /* enum */ Script CYRILLIC_OLD_CHURCH_SLAVONIC_VARIANT;
        public static final /* enum */ Script DESERET;
        public static final /* enum */ Script DEVANAGARI;
        public static final /* enum */ Script EGYPTIAN_DEMOTIC;
        public static final /* enum */ Script EGYPTIAN_HIERATIC;
        public static final /* enum */ Script EGYPTIAN_HIEROGLYPHS;
        public static final /* enum */ Script ETHIOPIC;
        public static final /* enum */ Script GEORGIAN;
        public static final /* enum */ Script GLAGOLITIC;
        public static final /* enum */ Script GOTHIC;
        public static final /* enum */ Script GREEK;
        public static final /* enum */ Script GUJARATI;
        public static final /* enum */ Script GURMUKHI;
        public static final /* enum */ Script HANGUL;
        public static final /* enum */ Script HANUNOO;
        public static final /* enum */ Script HAN_HANJA;
        public static final /* enum */ Script HAN_SIMPLIFIED;
        public static final /* enum */ Script HAN_TRADITIONAL;
        public static final /* enum */ Script HEBREW;
        public static final /* enum */ Script HIRAGANA;
        public static final /* enum */ Script HIRAGANA_KATAKANA;
        public static final /* enum */ Script IMPERIAL_ARAMAIC;
        public static final /* enum */ Script INDUS;
        public static final /* enum */ Script INSCRIPTIONAL_PAHLAVI;
        public static final /* enum */ Script INSCRIPTIONAL_PARTHIAN;
        public static final /* enum */ Script JAPANESE;
        public static final /* enum */ Script JAVANESE;
        public static final /* enum */ Script KAITHI;
        public static final /* enum */ Script KANNADA;
        public static final /* enum */ Script KATAKANA;
        public static final /* enum */ Script KAYAH_LI;
        public static final /* enum */ Script KHAROSHTHI;
        public static final /* enum */ Script KHMER;
        public static final /* enum */ Script KHUTSURI;
        public static final /* enum */ Script KOREAN;
        public static final /* enum */ Script LANNA;
        public static final /* enum */ Script LAO;
        public static final /* enum */ Script LATIN;
        public static final /* enum */ Script LATIN_FRAKTUR_VARIANT;
        public static final /* enum */ Script LATIN_GAELIC_VARIANT;
        public static final /* enum */ Script LEPCHA;
        public static final /* enum */ Script LIMBU;
        public static final /* enum */ Script LINEAR_A;
        public static final /* enum */ Script LINEAR_B;
        public static final /* enum */ Script LYCIAN;
        public static final /* enum */ Script LYDIAN;
        public static final /* enum */ Script MALAYALAM;
        public static final /* enum */ Script MANDAEAN;
        public static final /* enum */ Script MANICHAEAN;
        public static final /* enum */ Script MATHEMATICAL_NOTATION;
        public static final /* enum */ Script MAYAN_HIEROGLYPHS;
        public static final /* enum */ Script MEITEI_MAYEK;
        public static final /* enum */ Script MEROITIC;
        public static final /* enum */ Script MONGOLIAN;
        public static final /* enum */ Script MOON;
        public static final /* enum */ Script MYANMAR;
        public static final /* enum */ Script NKO;
        public static final /* enum */ Script OGHAM;
        public static final /* enum */ Script OLD_HUNGARIAN;
        public static final /* enum */ Script OLD_ITALIC;
        public static final /* enum */ Script OLD_PERMIC;
        public static final /* enum */ Script OLD_PERSIAN;
        public static final /* enum */ Script OL_CHIKI;
        public static final /* enum */ Script ORIYA;
        public static final /* enum */ Script ORKHON;
        public static final /* enum */ Script OSMANYA;
        public static final /* enum */ Script PAHAWH_HMONG;
        public static final /* enum */ Script PHAGS_PA;
        public static final /* enum */ Script PHOENICIAN;
        public static final /* enum */ Script POLLARD_PHONETIC;
        public static final /* enum */ Script PSALTER_PAHLAVI;
        public static final /* enum */ Script REJANG;
        public static final /* enum */ Script RONGORONGO;
        public static final /* enum */ Script RUNIC;
        public static final /* enum */ Script SAMARITAN;
        public static final /* enum */ Script SARATI;
        public static final /* enum */ Script SAURASHTRA;
        public static final /* enum */ Script SHAVIAN;
        public static final /* enum */ Script SIGNWRITING;
        public static final /* enum */ Script SINHALA;
        public static final /* enum */ Script SUNDANESE;
        public static final /* enum */ Script SYLOTI_NAGRI;
        public static final /* enum */ Script SYMBOLS;
        public static final /* enum */ Script SYRIAC;
        public static final /* enum */ Script SYRIAC_EASTERN_VARIANT;
        public static final /* enum */ Script SYRIAC_ESTRANGELO_VARIANT;
        public static final /* enum */ Script SYRIAC_WESTERN_VARIANT;
        public static final /* enum */ Script TAGALOG;
        public static final /* enum */ Script TAGBANWA;
        public static final /* enum */ Script TAI_LE;
        public static final /* enum */ Script TAI_LUE;
        public static final /* enum */ Script TAI_VIET;
        public static final /* enum */ Script TAMIL;
        public static final /* enum */ Script TELUGU;
        public static final /* enum */ Script TENGWAR;
        public static final /* enum */ Script THAANA;
        public static final /* enum */ Script THAI;
        public static final /* enum */ Script TIBETAN;
        public static final /* enum */ Script TIFINAGH;
        public static final /* enum */ Script UGARITIC;
        public static final /* enum */ Script VAI;
        public static final /* enum */ Script VISIBLE_SPEECH;
        public static final /* enum */ Script YI;
        private String code;
        private String description;

        static {
            IMPERIAL_ARAMAIC = new Script("Armi", "Imperial Aramaic");
            ARMENIAN = new Script("Armn", "Armenian");
            AVESTAN = new Script("Avst", "Avestan");
            BALINESE = new Script("Bali", "Balinese");
            BATAK = new Script("Batk", "Batak");
            BENGALI = new Script("Beng", "Bengali");
            BLISSYMBOLS = new Script("Blis", "Blissymbols");
            BOPOMOFO = new Script("Bopo", "Bopomofo");
            BRAHMI = new Script("Brah", "Brahmi");
            BRAILLE = new Script("Brai", "Braille");
            BUGINESE = new Script("Bugi", "Buginese");
            BUHID = new Script("Buhd", "Buhid");
            CHAKMA = new Script("Cakm", "Chakma");
            CANADIAN_SYLLABICS = new Script("Cans", "Canadian Syllabics");
            CARIAN = new Script("Cari", "Carian");
            CHAM = new Script("Cham", "Cham");
            CHEROKEE = new Script("Cher", "Cherokee");
            CIRTH = new Script("Cirt", "Cirth");
            COPTIC = new Script("Copt", "Coptic");
            CYPRIOT = new Script("Cprt", "Cypriot");
            CYRILLIC = new Script("Cyrl", "Cyrillic");
            CYRILLIC_OLD_CHURCH_SLAVONIC_VARIANT = new Script("Cyrs", "Cyrillic (Old Church Slavonic variant)");
            DEVANAGARI = new Script("Deva", "Devanagari");
            DESERET = new Script("Dsrt", "Deseret");
            EGYPTIAN_DEMOTIC = new Script("Egyd", "Egyptian demotic");
            EGYPTIAN_HIERATIC = new Script("Egyh", "Egyptian hieratic");
            EGYPTIAN_HIEROGLYPHS = new Script("Egyp", "Egyptian hieroglyphs");
            ETHIOPIC = new Script("Ethi", "Ethiopic");
            KHUTSURI = new Script("Geok", "Khutsuri");
            GEORGIAN = new Script("Geor", "Georgian");
            GLAGOLITIC = new Script("Glag", "Glagolitic");
            GOTHIC = new Script("Goth", "Gothic");
            GREEK = new Script("Grek", "Greek");
            GUJARATI = new Script("Gujr", "Gujarati");
            GURMUKHI = new Script("Guru", "Gurmukhi");
            HANGUL = new Script("Hang", "Hangul");
            HAN_HANJA = new Script("Hani", "Han (Hanzi, Kanji, Hanja)");
            HANUNOO = new Script("Hano", "Hanunoo");
            HAN_SIMPLIFIED = new Script("Hans", "Han (Simplified variant)");
            HAN_TRADITIONAL = new Script("Hant", "Han (Traditional variant)");
            HEBREW = new Script("Hebr", "Hebrew");
            HIRAGANA = new Script("Hira", "Hiragana");
            PAHAWH_HMONG = new Script("Hmng", "Pahawh Hmong");
            HIRAGANA_KATAKANA = new Script("Hrkt", "Hiragana + Katakana");
            OLD_HUNGARIAN = new Script("Hung", "Old Hungarian");
            INDUS = new Script("Inds", "Indus");
            OLD_ITALIC = new Script("Ital", "Old Italic");
            JAVANESE = new Script("Java", "Javanese");
            JAPANESE = new Script("Jpan", "Japanese");
            KAYAH_LI = new Script("Kali", "Kayah Li");
            KATAKANA = new Script("Kana", "Katakana");
            KHAROSHTHI = new Script("Khar", "Kharoshthi");
            KHMER = new Script("Khmr", "Khmer");
            KANNADA = new Script("Knda", "Kannada");
            KOREAN = new Script("Kore", "Korean");
            KAITHI = new Script("Kthi", "Kaithi");
            LANNA = new Script("Lana", "Lanna");
            LAO = new Script("Laoo", "Lao");
            LATIN_FRAKTUR_VARIANT = new Script("Latf", "Latin (Fraktur variant)");
            LATIN_GAELIC_VARIANT = new Script("Latg", "Latin (Gaelic variant)");
            LATIN = new Script("Latn", "Latin");
            LEPCHA = new Script("Lepc", "Lepcha");
            LIMBU = new Script("Limb", "Limbu");
            LINEAR_A = new Script("Lina", "Linear A");
            LINEAR_B = new Script("Linb", "Linear B");
            LYCIAN = new Script("Lyci", "Lycian");
            LYDIAN = new Script("Lydi", "Lydian");
            MANDAEAN = new Script("Mand", "Mandaean");
            MANICHAEAN = new Script("Mani", "Manichaean");
            MAYAN_HIEROGLYPHS = new Script("Maya", "Mayan hieroglyphs");
            MEROITIC = new Script("Mero", "Meroitic");
            MALAYALAM = new Script("Mlym", "Malayalam");
            MONGOLIAN = new Script("Mong", "Mongolian");
            MOON = new Script("Moon", "Moon");
            MEITEI_MAYEK = new Script("Mtei", "Meitei Mayek");
            MYANMAR = new Script("Mymr", "Myanmar");
            NKO = new Script("Nkoo", "N'ko");
            OGHAM = new Script("Ogam", "Ogham");
            OL_CHIKI = new Script("Olck", "Ol Chiki");
            ORKHON = new Script("Orkh", "Orkhon");
            ORIYA = new Script("Orya", "Oriya");
            OSMANYA = new Script("Osma", "Osmanya");
            OLD_PERMIC = new Script("Perm", "Old Permic");
            PHAGS_PA = new Script("Phag", "Phags-pa");
            INSCRIPTIONAL_PAHLAVI = new Script("Phli", "Inscriptional Pahlavi");
            PSALTER_PAHLAVI = new Script("Phlp", "Psalter Pahlavi");
            BOOK_PAHLAVI = new Script("Phlv", "Book Pahlavi");
            PHOENICIAN = new Script("Phnx", "Phoenician");
            POLLARD_PHONETIC = new Script("Plrd", "Pollard Phonetic");
            INSCRIPTIONAL_PARTHIAN = new Script("Prti", "Inscriptional Parthian");
            REJANG = new Script("Rjng", "Rejang");
            RONGORONGO = new Script("Roro", "Rongorongo");
            RUNIC = new Script("Runr", "Runic");
            SAMARITAN = new Script("Samr", "Samaritan");
            SARATI = new Script("Sara", "Sarati");
            SAURASHTRA = new Script("Saur", "Saurashtra");
            SIGNWRITING = new Script("Sgnw", "SignWriting");
            SHAVIAN = new Script("Shaw", "Shavian");
            SINHALA = new Script("Sinh", "Sinhala");
            SUNDANESE = new Script("Sund", "Sundanese");
            SYLOTI_NAGRI = new Script("Sylo", "Syloti Nagri");
            SYRIAC = new Script("Syrc", "Syriac");
            SYRIAC_ESTRANGELO_VARIANT = new Script("Syre", "Syriac (Estrangelo variant)");
            SYRIAC_WESTERN_VARIANT = new Script("Syrj", "Syriac (Western variant)");
            SYRIAC_EASTERN_VARIANT = new Script("Syrn", "Syriac (Eastern variant)");
            TAGBANWA = new Script("Tagb", "Tagbanwa");
            TAI_LE = new Script("Tale", "Tai Le");
            TAI_LUE = new Script("Talu", "Tai Lue");
            TAMIL = new Script("Taml", "Tamil");
            TAI_VIET = new Script("Tavt", "Tai Viet");
            TELUGU = new Script("Telu", "Telugu");
            TENGWAR = new Script("Teng", "Tengwar");
            TIFINAGH = new Script("Tfng", "Tifinagh");
            TAGALOG = new Script("Tglg", "Tagalog");
            THAANA = new Script("Thaa", "Thaana");
            THAI = new Script("Thai", "Thai");
            TIBETAN = new Script("Tibt", "Tibetan");
            UGARITIC = new Script("Ugar", "Ugaritic");
            VAI = new Script("Vaii", "Vai");
            VISIBLE_SPEECH = new Script("Visp", "Visible Speech");
            OLD_PERSIAN = new Script("Xpeo", "Old Persian");
            CUNEIFORM_SUMERO_AKKADIAN = new Script("Xsux", "Cuneiform, Sumero-Akkadian");
            YI = new Script("Yiii", "Yi");
            MATHEMATICAL_NOTATION = new Script("Zmth", "Mathematical notation");
            SYMBOLS = new Script("Zsym", "Symbols");
            Script[] arrscript = new Script[]{ARABIC, IMPERIAL_ARAMAIC, ARMENIAN, AVESTAN, BALINESE, BATAK, BENGALI, BLISSYMBOLS, BOPOMOFO, BRAHMI, BRAILLE, BUGINESE, BUHID, CHAKMA, CANADIAN_SYLLABICS, CARIAN, CHAM, CHEROKEE, CIRTH, COPTIC, CYPRIOT, CYRILLIC, CYRILLIC_OLD_CHURCH_SLAVONIC_VARIANT, DEVANAGARI, DESERET, EGYPTIAN_DEMOTIC, EGYPTIAN_HIERATIC, EGYPTIAN_HIEROGLYPHS, ETHIOPIC, KHUTSURI, GEORGIAN, GLAGOLITIC, GOTHIC, GREEK, GUJARATI, GURMUKHI, HANGUL, HAN_HANJA, HANUNOO, HAN_SIMPLIFIED, HAN_TRADITIONAL, HEBREW, HIRAGANA, PAHAWH_HMONG, HIRAGANA_KATAKANA, OLD_HUNGARIAN, INDUS, OLD_ITALIC, JAVANESE, JAPANESE, KAYAH_LI, KATAKANA, KHAROSHTHI, KHMER, KANNADA, KOREAN, KAITHI, LANNA, LAO, LATIN_FRAKTUR_VARIANT, LATIN_GAELIC_VARIANT, LATIN, LEPCHA, LIMBU, LINEAR_A, LINEAR_B, LYCIAN, LYDIAN, MANDAEAN, MANICHAEAN, MAYAN_HIEROGLYPHS, MEROITIC, MALAYALAM, MONGOLIAN, MOON, MEITEI_MAYEK, MYANMAR, NKO, OGHAM, OL_CHIKI, ORKHON, ORIYA, OSMANYA, OLD_PERMIC, PHAGS_PA, INSCRIPTIONAL_PAHLAVI, PSALTER_PAHLAVI, BOOK_PAHLAVI, PHOENICIAN, POLLARD_PHONETIC, INSCRIPTIONAL_PARTHIAN, REJANG, RONGORONGO, RUNIC, SAMARITAN, SARATI, SAURASHTRA, SIGNWRITING, SHAVIAN, SINHALA, SUNDANESE, SYLOTI_NAGRI, SYRIAC, SYRIAC_ESTRANGELO_VARIANT, SYRIAC_WESTERN_VARIANT, SYRIAC_EASTERN_VARIANT, TAGBANWA, TAI_LE, TAI_LUE, TAMIL, TAI_VIET, TELUGU, TENGWAR, TIFINAGH, TAGALOG, THAANA, THAI, TIBETAN, UGARITIC, VAI, VISIBLE_SPEECH, OLD_PERSIAN, CUNEIFORM_SUMERO_AKKADIAN, YI, MATHEMATICAL_NOTATION, SYMBOLS};
            $VALUES = arrscript;
        }

        private Script(String string3, String string4) {
            this.code = string3;
            this.description = string4;
        }

        public static Script valueOf(String string2) {
            return (Script)Enum.valueOf(Script.class, (String)string2);
        }

        public static Script[] values() {
            return (Script[])$VALUES.clone();
        }

        public String getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }

        public String toString() {
            return this.getDescription();
        }
    }

}

