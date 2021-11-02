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

public class ISOCountry {
    private static Map<String, Country> codeMap = new HashMap();
    private static Map<String, Country> descriptionMap;

    static {
        Country[] arrcountry = Country.values();
        int n2 = arrcountry.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Country country = arrcountry[i2];
            codeMap.put((Object)country.code, (Object)country);
        }
        descriptionMap = new HashMap();
        Country[] arrcountry2 = Country.values();
        int n4 = arrcountry2.length;
        while (n3 < n4) {
            Country country = arrcountry2[n3];
            descriptionMap.put((Object)country.description, (Object)country);
            ++n3;
        }
    }

    public static Country getCountryByCode(String string2) {
        return (Country)((Object)codeMap.get((Object)string2));
    }

    public static Country getCountryByDescription(String string2) {
        return (Country)((Object)descriptionMap.get((Object)string2));
    }

    public static String[] getDescriptionsAsArray() {
        ArrayList arrayList = new ArrayList();
        Country[] arrcountry = Country.values();
        int n2 = arrcountry.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)arrcountry[i2].description);
        }
        return (String[])arrayList.toArray((Object[])new String[0]);
    }

    public static final class Country
    extends Enum<Country> {
        private static final /* synthetic */ Country[] $VALUES;
        public static final /* enum */ Country AFGHANISTAN = new Country(" AF", "Afghanistan");
        public static final /* enum */ Country ALAND_ISLANDS = new Country("AX", "\u00c5land Islands");
        public static final /* enum */ Country ALBANIA = new Country("AL", "Albania");
        public static final /* enum */ Country ALGERIA = new Country("DZ", "Algeria");
        public static final /* enum */ Country AMERICAN_SAMOA = new Country("AS", "American Samoa");
        public static final /* enum */ Country ANDORRA = new Country("AD", "Andorra");
        public static final /* enum */ Country ANGOLA = new Country("AO", "Angola");
        public static final /* enum */ Country ANGUILLA = new Country("AI", "Anguilla");
        public static final /* enum */ Country ANTARCTICA = new Country("AQ", "Antarctica");
        public static final /* enum */ Country ANTIGUA_AND_BARBUDA = new Country("AG", "Antigua and Barbuda");
        public static final /* enum */ Country ARGENTINA = new Country("AR", "Argentina");
        public static final /* enum */ Country ARMENIA = new Country("AM", "Armenia");
        public static final /* enum */ Country ARUBA = new Country("AW", "Aruba");
        public static final /* enum */ Country AUSTRALIA = new Country("AU", "Australia");
        public static final /* enum */ Country AUSTRIA = new Country("AT", "Austria");
        public static final /* enum */ Country AZERBAIJAN = new Country("AZ", "Azerbaijan");
        public static final /* enum */ Country BAHAMAS = new Country("BS", "Bahamas");
        public static final /* enum */ Country BAHRAIN = new Country("BH", "Bahrain");
        public static final /* enum */ Country BANGLADESH = new Country("BD", "Bangladesh");
        public static final /* enum */ Country BARBADOS = new Country("BB", "Barbados");
        public static final /* enum */ Country BELARUS = new Country("BY", "Belarus");
        public static final /* enum */ Country BELGIUM = new Country("BE", "Belgium");
        public static final /* enum */ Country BELIZE = new Country("BZ", "Belize");
        public static final /* enum */ Country BENIN = new Country("BJ", "Benin");
        public static final /* enum */ Country BERMUDA = new Country("BM", "Bermuda");
        public static final /* enum */ Country BHUTAN = new Country("BT", "Bhutan");
        public static final /* enum */ Country BOLIVIA = new Country("BO", "Bolivia");
        public static final /* enum */ Country BOSNIA_AND_HERZEGOVINA = new Country("BA", "Bosnia and herzegovina");
        public static final /* enum */ Country BOTSWANA = new Country("BW", "Botswana");
        public static final /* enum */ Country BOUVET_ISLAND = new Country("BV", "Bouvet_Island");
        public static final /* enum */ Country BRAZIL = new Country("BR", "Brazil");
        public static final /* enum */ Country BRITISH_INDIAN_OCEAN_TERRITORY = new Country("IO", "British Indian Ocean Territory");
        public static final /* enum */ Country BRUNEI_DARUSSALAM = new Country("BN", "Brunei Darussalam");
        public static final /* enum */ Country BULGARIA = new Country("BG", "Bulgaria");
        public static final /* enum */ Country BURKINA_FASO = new Country("BF", "Burkina Faso");
        public static final /* enum */ Country BURUNDI = new Country("BI", "Burundi");
        public static final /* enum */ Country CAMBODIA = new Country("KH", "Cambodia");
        public static final /* enum */ Country CAMEROON = new Country("CM", "Cameroon");
        public static final /* enum */ Country CANADA = new Country("CA", "Canada");
        public static final /* enum */ Country CAPE_VERDE = new Country("CV", "Cape Verde");
        public static final /* enum */ Country CAYMAN_ISLANDS = new Country("KY", "Cayman Islands");
        public static final /* enum */ Country CENTRAL_AFRICAN_REPUBLIC = new Country("CF", "Central African Republic");
        public static final /* enum */ Country CHAD = new Country("TD", "Chad");
        public static final /* enum */ Country CHILE = new Country("CL", "Chile");
        public static final /* enum */ Country CHINA = new Country("CN", "China");
        public static final /* enum */ Country CHRISTMAS_ISLAND = new Country("CX", "Christmas Island");
        public static final /* enum */ Country COCOS_KEELING_ISLANDS = new Country("CC", "Cocos Keeling Islands");
        public static final /* enum */ Country COLOMBIA = new Country("CO", "Colombia");
        public static final /* enum */ Country COMOROS = new Country("KM", "Comoros");
        public static final /* enum */ Country CONGO = new Country("CG", "Congo");
        public static final /* enum */ Country COOK_ISLANDS;
        public static final /* enum */ Country COSTA_RICA;
        public static final /* enum */ Country COTE_D_IVOIRE;
        public static final /* enum */ Country CROATIA;
        public static final /* enum */ Country CUBA;
        public static final /* enum */ Country CYPRUS;
        public static final /* enum */ Country CZECH_REPUBLIC;
        public static final /* enum */ Country DENMARK;
        public static final /* enum */ Country DJIBOUTI;
        public static final /* enum */ Country DOMINICA;
        public static final /* enum */ Country DOMINICAN_REPUBLIC;
        public static final /* enum */ Country ECUADOR;
        public static final /* enum */ Country EGYPT;
        public static final /* enum */ Country EL_SALVADOR;
        public static final /* enum */ Country EQUATORIAL_GUINEA;
        public static final /* enum */ Country ERITREA;
        public static final /* enum */ Country ESTONIA;
        public static final /* enum */ Country ETHIOPIA;
        public static final /* enum */ Country FALKLAND_ISLANDS;
        public static final /* enum */ Country FAROE_ISLANDS;
        public static final /* enum */ Country FIJI;
        public static final /* enum */ Country FINLAND;
        public static final /* enum */ Country FRANCE;
        public static final /* enum */ Country FRENCH_GUIANA;
        public static final /* enum */ Country FRENCH_POLYNESIA;
        public static final /* enum */ Country FRENCH_SOUTHERN_TERRITORIES;
        public static final /* enum */ Country GABON;
        public static final /* enum */ Country GAMBIA;
        public static final /* enum */ Country GEORGIA;
        public static final /* enum */ Country GERMANY;
        public static final /* enum */ Country GHANA;
        public static final /* enum */ Country GIBRALTAR;
        public static final /* enum */ Country GREECE;
        public static final /* enum */ Country GREENLAND;
        public static final /* enum */ Country GRENADA;
        public static final /* enum */ Country GUADELOUPE;
        public static final /* enum */ Country GUAM;
        public static final /* enum */ Country GUATEMALA;
        public static final /* enum */ Country GUERNSEY;
        public static final /* enum */ Country GUINEA;
        public static final /* enum */ Country GUINEA_BISSAU;
        public static final /* enum */ Country GUYANA;
        public static final /* enum */ Country HAITI;
        public static final /* enum */ Country HEARD_ISLAND_AND_MCDONALD_ISLANDS;
        public static final /* enum */ Country HONDURAS;
        public static final /* enum */ Country HONG_KONG;
        public static final /* enum */ Country HUNGARY;
        public static final /* enum */ Country ICELAND;
        public static final /* enum */ Country INDIA;
        public static final /* enum */ Country INDONESIA;
        public static final /* enum */ Country IRAN;
        public static final /* enum */ Country IRAQ;
        public static final /* enum */ Country IRELAND;
        public static final /* enum */ Country ISLE_OF_MAN;
        public static final /* enum */ Country ISRAEL;
        public static final /* enum */ Country ITALY;
        public static final /* enum */ Country JAMAICA;
        public static final /* enum */ Country JAPAN;
        public static final /* enum */ Country JERSEY;
        public static final /* enum */ Country JORDAN;
        public static final /* enum */ Country KAZAKHSTAN;
        public static final /* enum */ Country KENYA;
        public static final /* enum */ Country KIRIBATI;
        public static final /* enum */ Country KOREA_NORTH;
        public static final /* enum */ Country KOREA_SOUTH;
        public static final /* enum */ Country KUWAIT;
        public static final /* enum */ Country KYRGYZSTAN;
        public static final /* enum */ Country LAO_PEOPLES_DEMOCRATIC_REPUBLIC;
        public static final /* enum */ Country LATVIA;
        public static final /* enum */ Country LEBANON;
        public static final /* enum */ Country LESOTHO;
        public static final /* enum */ Country LIBERIA;
        public static final /* enum */ Country LIBYAN_ARAB_JAMAHIRIYA;
        public static final /* enum */ Country LIECHTENSTEIN;
        public static final /* enum */ Country LITHUANIA;
        public static final /* enum */ Country LUXEMBOURG;
        public static final /* enum */ Country MACAO;
        public static final /* enum */ Country MACEDONIA;
        public static final /* enum */ Country MADAGASCAR;
        public static final /* enum */ Country MALAWI;
        public static final /* enum */ Country MALAYSIA;
        public static final /* enum */ Country MALDIVES;
        public static final /* enum */ Country MALI;
        public static final /* enum */ Country MALTA;
        public static final /* enum */ Country MARSHALL_ISLANDS;
        public static final /* enum */ Country MARTINIQUE;
        public static final /* enum */ Country MAURITANIA;
        public static final /* enum */ Country MAURITIUS;
        public static final /* enum */ Country MAYOTTE;
        public static final /* enum */ Country MEXICO;
        public static final /* enum */ Country MICRONESIA;
        public static final /* enum */ Country MOLDOVA;
        public static final /* enum */ Country MONACO;
        public static final /* enum */ Country MONGOLIA;
        public static final /* enum */ Country MONTENEGRO;
        public static final /* enum */ Country MONTSERRAT;
        public static final /* enum */ Country MOROCCO;
        public static final /* enum */ Country MOZAMBIQUE;
        public static final /* enum */ Country MYANMAR;
        public static final /* enum */ Country NAMIBIA;
        public static final /* enum */ Country NAURU;
        public static final /* enum */ Country NEPAL;
        public static final /* enum */ Country NETHERLANDS;
        public static final /* enum */ Country NETHERLANDS_ANTILLES;
        public static final /* enum */ Country NEW_CALEDONIA;
        public static final /* enum */ Country NEW_ZEALAND;
        public static final /* enum */ Country NICARAGUA;
        public static final /* enum */ Country NIGER;
        public static final /* enum */ Country NIGERIA;
        public static final /* enum */ Country NIUE;
        public static final /* enum */ Country NORFOLK_ISLAND;
        public static final /* enum */ Country NORTHERN_MARIANA_ISLANDS;
        public static final /* enum */ Country NORWAY;
        public static final /* enum */ Country OMAN;
        public static final /* enum */ Country PAKISTAN;
        public static final /* enum */ Country PALAU;
        public static final /* enum */ Country PALESTINIAN_TERRITORY_OCCUPIED;
        public static final /* enum */ Country PANAMA;
        public static final /* enum */ Country PAPUA_NEW_GUINEA;
        public static final /* enum */ Country PARAGUAY;
        public static final /* enum */ Country PERU;
        public static final /* enum */ Country PHILIPPINES;
        public static final /* enum */ Country PITCAIRN;
        public static final /* enum */ Country POLAND;
        public static final /* enum */ Country PORTUGAL;
        public static final /* enum */ Country PUERTO_RICO;
        public static final /* enum */ Country QATAR;
        public static final /* enum */ Country REUNION;
        public static final /* enum */ Country ROMANIA;
        public static final /* enum */ Country RUSSIAN_FEDERATION;
        public static final /* enum */ Country RWANDA;
        public static final /* enum */ Country SAINT_BARTHOLEMY;
        public static final /* enum */ Country SAINT_HELENA;
        public static final /* enum */ Country SAINT_KITTS_AND_NEVIS;
        public static final /* enum */ Country SAINT_LUCIA;
        public static final /* enum */ Country SAINT_MARTIN;
        public static final /* enum */ Country SAINT_PIERRE_AND_MIQUELON;
        public static final /* enum */ Country SAINT_VINCENT_AND_THE_GRENADINES;
        public static final /* enum */ Country SAMOA;
        public static final /* enum */ Country SAN_MARINO;
        public static final /* enum */ Country SAO_TOME_AND_PRINCIPE;
        public static final /* enum */ Country SAUDI_ARABIA;
        public static final /* enum */ Country SENEGAL;
        public static final /* enum */ Country SERBIA;
        public static final /* enum */ Country SEYCHELLES;
        public static final /* enum */ Country SIERRA_LEONE;
        public static final /* enum */ Country SINGAPORE;
        public static final /* enum */ Country SLOVAKIA;
        public static final /* enum */ Country SLOVENIA;
        public static final /* enum */ Country SOLOMON_ISLANDS;
        public static final /* enum */ Country SOMALIA;
        public static final /* enum */ Country SOUTH_AFRICA;
        public static final /* enum */ Country SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_Islands;
        public static final /* enum */ Country SPAIN;
        public static final /* enum */ Country SRI_LANKA;
        public static final /* enum */ Country SUDAN;
        public static final /* enum */ Country SURINAME;
        public static final /* enum */ Country SVALBARD_AND_JAN_MAYEN;
        public static final /* enum */ Country SWAZILAND;
        public static final /* enum */ Country SWEDEN;
        public static final /* enum */ Country SWITZERLAND;
        public static final /* enum */ Country SYRIA;
        public static final /* enum */ Country TAIWAN;
        public static final /* enum */ Country TAJIKISTAN;
        public static final /* enum */ Country TANZANIA;
        public static final /* enum */ Country THAILAND;
        public static final /* enum */ Country THE_DEMOCRATIC_REPUBLIC_OF_CONGO;
        public static final /* enum */ Country TIMOR_LESTE;
        public static final /* enum */ Country TOGO;
        public static final /* enum */ Country TOKELAU;
        public static final /* enum */ Country TONGA;
        public static final /* enum */ Country TRINIDAD_AND_TOBAGO;
        public static final /* enum */ Country TUNISIA;
        public static final /* enum */ Country TURKEY;
        public static final /* enum */ Country TURKMENISTAN;
        public static final /* enum */ Country TURKS_AND_CAICOS_ISLANDS;
        public static final /* enum */ Country TUVALU;
        public static final /* enum */ Country UGANDA;
        public static final /* enum */ Country UKRAINE;
        public static final /* enum */ Country UNITED_ARAB_EMIRATES;
        public static final /* enum */ Country UNITED_KINGDOM;
        public static final /* enum */ Country UNITED_STATES;
        public static final /* enum */ Country UNITED_STATES_MINOR_OUTLYING_ISLANDS;
        public static final /* enum */ Country URUGUAY;
        public static final /* enum */ Country UZBEKISTAN;
        public static final /* enum */ Country VANUATU;
        public static final /* enum */ Country VATICAN_CITY;
        public static final /* enum */ Country VENEZUELA;
        public static final /* enum */ Country VIETNAM;
        public static final /* enum */ Country VIRGIN_ISLANDS_BRITISH;
        public static final /* enum */ Country VIRGIN_ISLANDS_US;
        public static final /* enum */ Country WALLIS_AND_FUTUNA;
        public static final /* enum */ Country WESTERN_SAHARA;
        public static final /* enum */ Country YEMEN;
        public static final /* enum */ Country ZAMBIA;
        public static final /* enum */ Country ZIMBABWE;
        private String code;
        private String description;

        static {
            THE_DEMOCRATIC_REPUBLIC_OF_CONGO = new Country("CD", "The Democratic Republic Of Congo");
            COOK_ISLANDS = new Country("CK", "Cook Islands");
            COSTA_RICA = new Country("CR", "Costa Rica");
            COTE_D_IVOIRE = new Country("CI", "Ivory Coast");
            CROATIA = new Country("HR", "Croatia");
            CUBA = new Country("CU", "Cuba");
            CYPRUS = new Country("CY", "Cyprus");
            CZECH_REPUBLIC = new Country("CZ", "Czech Republic");
            DENMARK = new Country("DK", "Denmark");
            DJIBOUTI = new Country("DJ", "Djibouti");
            DOMINICA = new Country("DM", "Dominica");
            DOMINICAN_REPUBLIC = new Country("DO", "Dominican Republic");
            ECUADOR = new Country("EC", "Ecuador");
            EGYPT = new Country("EG", "Egypt");
            EL_SALVADOR = new Country("SV", "El Salvador");
            EQUATORIAL_GUINEA = new Country("GQ", "Equatorial Guinea");
            ERITREA = new Country("ER", "Eritrea");
            ESTONIA = new Country("EE", "Estonia");
            ETHIOPIA = new Country("ET", "Ethiopia");
            FALKLAND_ISLANDS = new Country("FK", "Falkland Islands");
            FAROE_ISLANDS = new Country("FO", "Faroe Islands");
            FIJI = new Country("FJ", "Fiji");
            FINLAND = new Country("FI", "Finland");
            FRANCE = new Country("FR", "France");
            FRENCH_GUIANA = new Country("GF", "French Guiana");
            FRENCH_POLYNESIA = new Country("PF", "French Polynesia");
            FRENCH_SOUTHERN_TERRITORIES = new Country("TF", "French Southern Territories");
            GABON = new Country("GA", "Gabon");
            GAMBIA = new Country("GM", "Gambia");
            GEORGIA = new Country("GE", "Georgia");
            GERMANY = new Country("DE", "Germany");
            GHANA = new Country("GH", "Ghana");
            GIBRALTAR = new Country("GI", "Gibraltar");
            GREECE = new Country("GR", "Greece");
            GREENLAND = new Country("GL", "Greenland");
            GRENADA = new Country("GD", "Grenada");
            GUADELOUPE = new Country("GP", "Guadeloupe");
            GUAM = new Country("GU", "Guam");
            GUATEMALA = new Country("GT", "Guatemala");
            GUERNSEY = new Country("GG", "Guernsey");
            GUINEA = new Country("GN", "Guinea");
            GUINEA_BISSAU = new Country("GW", "Guinea_Bissau");
            GUYANA = new Country("GY", "Guyana");
            HAITI = new Country("HT", "Haiti");
            HEARD_ISLAND_AND_MCDONALD_ISLANDS = new Country("HM", "Heard Island and Mcdonald Islands");
            HONDURAS = new Country("HN", "Honduras");
            HONG_KONG = new Country("HK", "Hong Kong");
            HUNGARY = new Country("HU", "Hungary");
            ICELAND = new Country("IS", "Iceland");
            INDIA = new Country("IN", "India");
            INDONESIA = new Country("ID", "Indonesia");
            IRAN = new Country("IR", "Iran");
            IRAQ = new Country("IQ", "Iraq");
            IRELAND = new Country("IE", "Ireland");
            ISLE_OF_MAN = new Country("IM", "Isle Of Man");
            ISRAEL = new Country("IL", "Israel");
            ITALY = new Country("IT", "Italy");
            JAMAICA = new Country("JM", "Jamaica");
            JAPAN = new Country("JP", "Japan");
            JERSEY = new Country("JE", "Jersey");
            JORDAN = new Country("JO", "Jordan");
            KAZAKHSTAN = new Country("KZ", "Kazakhstan");
            KENYA = new Country("KE", "Kenya");
            KIRIBATI = new Country("KI", "Kiribati");
            KOREA_NORTH = new Country("KP", "North Korea");
            KOREA_SOUTH = new Country("KR", "South Korea");
            KUWAIT = new Country("KW", "Kuwait");
            KYRGYZSTAN = new Country("KG", "Kyrgyzstan");
            LAO_PEOPLES_DEMOCRATIC_REPUBLIC = new Country("LA", "Lao");
            LATVIA = new Country("LV", "Latvia");
            LEBANON = new Country("LB", "Lebanon");
            LESOTHO = new Country("LS", "Lesotho");
            LIBERIA = new Country("LR", "Liberia");
            LIBYAN_ARAB_JAMAHIRIYA = new Country("LY", "Libyan Arab Jamahiriya");
            LIECHTENSTEIN = new Country("LI", "Liechtenstein");
            LITHUANIA = new Country("LT", "Lithuania");
            LUXEMBOURG = new Country("LU", "Luxembourg");
            MACAO = new Country("MO", "Macao");
            MACEDONIA = new Country("MK", "Macedonia");
            MADAGASCAR = new Country("MG", "Madagascar");
            MALAWI = new Country("MW", "Malawi");
            MALAYSIA = new Country("MY", "Malaysia");
            MALDIVES = new Country("MV", "Maldives");
            MALI = new Country("ML", "Mali");
            MALTA = new Country("MT", "Malta");
            MARSHALL_ISLANDS = new Country("MH", "Marshall Islands");
            MARTINIQUE = new Country("MQ", "Martinique");
            MAURITANIA = new Country("MR", "Mauritania");
            MAURITIUS = new Country("MU", "Mauritius");
            MAYOTTE = new Country("YT", "Mayotte");
            MEXICO = new Country("MX", "Mexico");
            MICRONESIA = new Country("FM", "Micronesia");
            MOLDOVA = new Country("MD", "Moldova");
            MONACO = new Country("MC", "Monaco");
            MONGOLIA = new Country("MN", "Mongolia");
            MONTENEGRO = new Country("ME", "Montenegro");
            MONTSERRAT = new Country("MS", "Montserrat");
            MOROCCO = new Country("MA", "Morocco");
            MOZAMBIQUE = new Country("MZ", "Mozambique");
            MYANMAR = new Country("MM", "Myanmar");
            NAMIBIA = new Country("NA", "Namibia");
            NAURU = new Country("NR", "Nauru");
            NEPAL = new Country("NP", "Nepal");
            NETHERLANDS = new Country("NL", "Netherlands");
            NETHERLANDS_ANTILLES = new Country("AN", "Netherlands Antilles");
            NEW_CALEDONIA = new Country("NC", "New Caledonia");
            NEW_ZEALAND = new Country("NZ", "New Zealand");
            NICARAGUA = new Country("NI", "Nicaragua");
            NIGER = new Country("NE", "Niger");
            NIGERIA = new Country("NG", "Nigeria");
            NIUE = new Country("NU", "Niue");
            NORFOLK_ISLAND = new Country("NF", "Norfolk Island");
            NORTHERN_MARIANA_ISLANDS = new Country("MP", "Northern Mariana Islands");
            NORWAY = new Country("NO", "Norway");
            OMAN = new Country("OM", "Oman");
            PAKISTAN = new Country("PK", "Pakistan");
            PALAU = new Country("PW", "Palau");
            PALESTINIAN_TERRITORY_OCCUPIED = new Country("PS", "Palestinian Territory Occupied");
            PANAMA = new Country("PA", "Panama");
            PAPUA_NEW_GUINEA = new Country("PG", "Papua New Guinea");
            PARAGUAY = new Country("PY", "Paraguay");
            PERU = new Country("PE", "Peru");
            PHILIPPINES = new Country("PH", "Philippines");
            PITCAIRN = new Country("PN", "Pitcairn");
            POLAND = new Country("PL", "Poland");
            PORTUGAL = new Country("PT", "Portugal");
            PUERTO_RICO = new Country("PR", "Puerto Rico");
            QATAR = new Country("QA", "Qatar");
            REUNION = new Country("RE", "Union");
            ROMANIA = new Country("RO", "Romania");
            RUSSIAN_FEDERATION = new Country("RU", "Russia");
            RWANDA = new Country("RW", "Rwanda");
            SAINT_BARTHOLEMY = new Country("BL", "Lemy");
            SAINT_HELENA = new Country("SH", "St Helena");
            SAINT_KITTS_AND_NEVIS = new Country("KN", "St Kitts and Nevis");
            SAINT_LUCIA = new Country("LC", "St Lucia");
            SAINT_MARTIN = new Country("MF", "St Martin");
            SAINT_PIERRE_AND_MIQUELON = new Country("PM", "St Pierre and Miquelon");
            SAINT_VINCENT_AND_THE_GRENADINES = new Country("VC", "St Vincent and the Grenadines");
            SAMOA = new Country("WS", "Samoa");
            SAN_MARINO = new Country("SM", "San_Marino");
            SAO_TOME_AND_PRINCIPE = new Country("ST", "Sao Tome and Principe");
            SAUDI_ARABIA = new Country("SA", "Saudi Arabia");
            SENEGAL = new Country("SN", "Senegal");
            SERBIA = new Country("RS", "Serbia");
            SEYCHELLES = new Country("SC", "Seychelles");
            SIERRA_LEONE = new Country("SL", "Sierra Leone");
            SINGAPORE = new Country("SG", "Singapore");
            SLOVAKIA = new Country("SK", "Slovakia");
            SLOVENIA = new Country("SI", "Slovenia");
            SOLOMON_ISLANDS = new Country("SB", "Solomon Islands");
            SOMALIA = new Country("SO", "Somalia");
            SOUTH_AFRICA = new Country("ZA", "South Africa");
            SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_Islands = new Country("GS", "South Georgia and the South Sandwich Islands");
            SPAIN = new Country("ES", "Spain");
            SRI_LANKA = new Country("LK", "Sri Lanka");
            SUDAN = new Country("SD", "Sudan");
            SURINAME = new Country("SR", "Suriname");
            SVALBARD_AND_JAN_MAYEN = new Country("SJ", "Svalbard and Jan Mayen");
            SWAZILAND = new Country("SZ", "Swaziland");
            SWEDEN = new Country("SE", "Sweden");
            SWITZERLAND = new Country("CH", "Switzerland");
            SYRIA = new Country("SY", "Syria");
            TAIWAN = new Country("TW", "Taiwan");
            TAJIKISTAN = new Country("TJ", "Tajikistan");
            TANZANIA = new Country("TZ", "Tanzania");
            THAILAND = new Country("TH", "Thailand");
            TIMOR_LESTE = new Country("TL", "Timor Leste");
            TOGO = new Country("TG", "Togo");
            TOKELAU = new Country("TK", "Tokelau");
            TONGA = new Country("TO", "Tonga");
            TRINIDAD_AND_TOBAGO = new Country("TT", "Trinidad and Tobago");
            TUNISIA = new Country("TN", "Tunisia");
            TURKEY = new Country("TR", "Turkey");
            TURKMENISTAN = new Country("TM", "Turkmenistan");
            TURKS_AND_CAICOS_ISLANDS = new Country("TC", "Turks and Caicos Islands");
            TUVALU = new Country("TV", "Tuvalu");
            UGANDA = new Country("UG", "Uganda");
            UKRAINE = new Country("UA", "Ukraine");
            UNITED_ARAB_EMIRATES = new Country("AE", "United Arab Emirates");
            UNITED_KINGDOM = new Country("GB", "United Kingdom");
            UNITED_STATES = new Country("US", "United States");
            UNITED_STATES_MINOR_OUTLYING_ISLANDS = new Country("UM", "United States Minor Outlying Islands");
            URUGUAY = new Country("UY", "Uruguay");
            UZBEKISTAN = new Country("UZ", "Uzbekistan");
            VANUATU = new Country("VU", "Vanuatu");
            VATICAN_CITY = new Country("VA", "Vatican City");
            VENEZUELA = new Country("VE", "Venezuela");
            VIETNAM = new Country("VN", "Vietnam");
            VIRGIN_ISLANDS_BRITISH = new Country("VG", "British Virgin Islands");
            VIRGIN_ISLANDS_US = new Country("VI", "US Virgin Islands");
            WALLIS_AND_FUTUNA = new Country("WF", "Wallis and Futuna");
            WESTERN_SAHARA = new Country("EH", "Western Sahara");
            YEMEN = new Country("YE", "Yemen");
            ZAMBIA = new Country("ZM", "Zambia");
            ZIMBABWE = new Country("ZW", "Zimbabwe");
            Country[] arrcountry = new Country[]{AFGHANISTAN, ALAND_ISLANDS, ALBANIA, ALGERIA, AMERICAN_SAMOA, ANDORRA, ANGOLA, ANGUILLA, ANTARCTICA, ANTIGUA_AND_BARBUDA, ARGENTINA, ARMENIA, ARUBA, AUSTRALIA, AUSTRIA, AZERBAIJAN, BAHAMAS, BAHRAIN, BANGLADESH, BARBADOS, BELARUS, BELGIUM, BELIZE, BENIN, BERMUDA, BHUTAN, BOLIVIA, BOSNIA_AND_HERZEGOVINA, BOTSWANA, BOUVET_ISLAND, BRAZIL, BRITISH_INDIAN_OCEAN_TERRITORY, BRUNEI_DARUSSALAM, BULGARIA, BURKINA_FASO, BURUNDI, CAMBODIA, CAMEROON, CANADA, CAPE_VERDE, CAYMAN_ISLANDS, CENTRAL_AFRICAN_REPUBLIC, CHAD, CHILE, CHINA, CHRISTMAS_ISLAND, COCOS_KEELING_ISLANDS, COLOMBIA, COMOROS, CONGO, THE_DEMOCRATIC_REPUBLIC_OF_CONGO, COOK_ISLANDS, COSTA_RICA, COTE_D_IVOIRE, CROATIA, CUBA, CYPRUS, CZECH_REPUBLIC, DENMARK, DJIBOUTI, DOMINICA, DOMINICAN_REPUBLIC, ECUADOR, EGYPT, EL_SALVADOR, EQUATORIAL_GUINEA, ERITREA, ESTONIA, ETHIOPIA, FALKLAND_ISLANDS, FAROE_ISLANDS, FIJI, FINLAND, FRANCE, FRENCH_GUIANA, FRENCH_POLYNESIA, FRENCH_SOUTHERN_TERRITORIES, GABON, GAMBIA, GEORGIA, GERMANY, GHANA, GIBRALTAR, GREECE, GREENLAND, GRENADA, GUADELOUPE, GUAM, GUATEMALA, GUERNSEY, GUINEA, GUINEA_BISSAU, GUYANA, HAITI, HEARD_ISLAND_AND_MCDONALD_ISLANDS, HONDURAS, HONG_KONG, HUNGARY, ICELAND, INDIA, INDONESIA, IRAN, IRAQ, IRELAND, ISLE_OF_MAN, ISRAEL, ITALY, JAMAICA, JAPAN, JERSEY, JORDAN, KAZAKHSTAN, KENYA, KIRIBATI, KOREA_NORTH, KOREA_SOUTH, KUWAIT, KYRGYZSTAN, LAO_PEOPLES_DEMOCRATIC_REPUBLIC, LATVIA, LEBANON, LESOTHO, LIBERIA, LIBYAN_ARAB_JAMAHIRIYA, LIECHTENSTEIN, LITHUANIA, LUXEMBOURG, MACAO, MACEDONIA, MADAGASCAR, MALAWI, MALAYSIA, MALDIVES, MALI, MALTA, MARSHALL_ISLANDS, MARTINIQUE, MAURITANIA, MAURITIUS, MAYOTTE, MEXICO, MICRONESIA, MOLDOVA, MONACO, MONGOLIA, MONTENEGRO, MONTSERRAT, MOROCCO, MOZAMBIQUE, MYANMAR, NAMIBIA, NAURU, NEPAL, NETHERLANDS, NETHERLANDS_ANTILLES, NEW_CALEDONIA, NEW_ZEALAND, NICARAGUA, NIGER, NIGERIA, NIUE, NORFOLK_ISLAND, NORTHERN_MARIANA_ISLANDS, NORWAY, OMAN, PAKISTAN, PALAU, PALESTINIAN_TERRITORY_OCCUPIED, PANAMA, PAPUA_NEW_GUINEA, PARAGUAY, PERU, PHILIPPINES, PITCAIRN, POLAND, PORTUGAL, PUERTO_RICO, QATAR, REUNION, ROMANIA, RUSSIAN_FEDERATION, RWANDA, SAINT_BARTHOLEMY, SAINT_HELENA, SAINT_KITTS_AND_NEVIS, SAINT_LUCIA, SAINT_MARTIN, SAINT_PIERRE_AND_MIQUELON, SAINT_VINCENT_AND_THE_GRENADINES, SAMOA, SAN_MARINO, SAO_TOME_AND_PRINCIPE, SAUDI_ARABIA, SENEGAL, SERBIA, SEYCHELLES, SIERRA_LEONE, SINGAPORE, SLOVAKIA, SLOVENIA, SOLOMON_ISLANDS, SOMALIA, SOUTH_AFRICA, SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_Islands, SPAIN, SRI_LANKA, SUDAN, SURINAME, SVALBARD_AND_JAN_MAYEN, SWAZILAND, SWEDEN, SWITZERLAND, SYRIA, TAIWAN, TAJIKISTAN, TANZANIA, THAILAND, TIMOR_LESTE, TOGO, TOKELAU, TONGA, TRINIDAD_AND_TOBAGO, TUNISIA, TURKEY, TURKMENISTAN, TURKS_AND_CAICOS_ISLANDS, TUVALU, UGANDA, UKRAINE, UNITED_ARAB_EMIRATES, UNITED_KINGDOM, UNITED_STATES, UNITED_STATES_MINOR_OUTLYING_ISLANDS, URUGUAY, UZBEKISTAN, VANUATU, VATICAN_CITY, VENEZUELA, VIETNAM, VIRGIN_ISLANDS_BRITISH, VIRGIN_ISLANDS_US, WALLIS_AND_FUTUNA, WESTERN_SAHARA, YEMEN, ZAMBIA, ZIMBABWE};
            $VALUES = arrcountry;
        }

        private Country(String string3, String string4) {
            this.code = string3;
            this.description = string4;
        }

        public static Country valueOf(String string2) {
            return (Country)Enum.valueOf(Country.class, (String)string2);
        }

        public static Country[] values() {
            return (Country[])$VALUES.clone();
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

