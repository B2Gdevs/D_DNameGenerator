package layout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;


import com.bensquared.epicnamegenerator.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Generate extends Fragment {

    Button genButton;
    Button savButton;
    Random randNumGen= new Random();
    private AdView mAdView;
    TextToSpeech genVoice;
    int errResultOfVoice;
    public SharedPreferences shared;
    String maleNameList = "maleNameList";
    String femaleNameList = "femaleNameList";
    String neitherNameList = "neitherNameList";
    int sharedPrefChooser = 0;


    String firstLastTemplate = "firstName lastName";

//    1<item>Aasimar</item>
//    2<item>Dragonborn</item>
//    3<item>Dwarf</item>
//    4<item>Elf</item>
//    5<item>Firbolg</item>
//    6<item>Genasi</item>
//    7<item>Gnome</item>
//    8<item>Goliath</item>
//    9<item>Halfling</item>
//    10<item>Half-Elf</item>
//    11<item>Half-Orc</item>
//    12<item>Human</item>
//    13<item>Kenku</item>
//    14<item>Lizardfolk</item>
//    15<item>Tiefling</item>
//    17<item>Aarakocra </item>
//    18<item>Changeling</item>
//    19<item>Goblin </item>
//    20<item>Kor</item>
//    21<item>Merfolk </item>
//    22<item>Minotaur</item>
//    24<item>Shifter</item>
//    25<item>Vampire</item>
//    26<item>Warforged</item>


/*1*/  String maleAasimarFirstNames[] =     {"Peaceblade", "Nemmonis", "Myastan", "Drachedandion", "Redmark", "Fenkenkabradon", "Bloodbane", "Moonscale", "Yarjerit", "Delmirev", "Spellscale", "Drakerider", "Flamebrow", "Kimbatuul", "Kerthylon", "Daardendrian", "Loremark", "Badhall", "Lorqull", "Saziros", "Bharoth", "Jarwarum", "Caertrin", "Vrakbroth", "Satrin", "Nesgrax", "Trouwunax"};
/*2*/  String maleDragonbornFirstNames[] =               {"Deamwen", "Calnun ","Zibunt", "Murwan", "Belman", "Zomwen",  "Iakuben", "Gramomlan", "Udubem", "Cirwen","Pakin ", "Wolral ", "Cronlur", "Aulnun",  "Zongym", "Ibaunt", "Ikwenun", "Cilmalwen","Olwumren","Cratan", "Cilmalwen","Olwumren","Cratan", "Kuban","Okont","Todunt", "Lamin","Waumor","Teamint","Carwonan","Saudedom","Crulmamwin"};
/*3*/  String maleDwarfFirstNames[] =               {"Drom ", "Kad ", "Old", "Kot", "Ford", "Okkord", "Rorbun", "Oruld", "Dremgok","Hamguursk","Bir","Srag ","Stun","Hog","Strols","Dogrol ","Srugdak ","Docryg","Stagaack","Grecmurg","Ut" ,"Mel" ,"Iod" ,"Brior" ,"Fyrd" ,"Udmon" ,"Zuurstaim" ,"Rulgum" ,"Danthor" ,"Trydak" ,"Tron" ,"Bord" ,"Udd" ,"Byld" ,"Strem" ,"Maderd" ,"Aildrur" ,"Biodgid" ,"Brudgam" ,"Voogmudd" ,"Un" ,"Kum" ,"Brild" ,"Arg" ,"Mam" ,"Bralgren" ,"Olkyrd" ,"Talduut" ,"Margrul" ,"Yzdol" ,"Dald" ,"Ut" ,"Von" ,"Add" ,"Gran" ,"Graadgodd" ,"Rendryk" ,"Aigdak" ,"Weddard" ,"Fucmaick" ,"Bran" ,"Ald" ,"Vorg" ,"Uuld" ,"Wuld" ,"Egdaard" ,"Grocnursk" ,"Jiocruc" ,"Boolbild" ,"Jorsteg" ,"Bran" ,"Ald" ,"Vorg" ,"Uuld" ,"Wuld" ,"Egdaard" ,"Grocnursk" ,"Jiocruc" ,"Boolbild" ,"Jorsteg"};
/*4*/  String maleElfFirstNames[] =              {"Den" ,"Lem" ,"Cur" ,"Andrior" ,"Nondraes" ,"Thivim" ,"Cadrur" ,"Olmomen" ,"Melnesthial" ,"Zuravayas" ,"Thal" ,"Sur" ,"Dar" ,"Setass" ,"Vidvuss" ,"Kedrar" ,"Mores" ,"Zogiltheass" ,"Egondrom" ,"Ievrusthonvess" ,"Sas" ,"Dan" ,"Fass" ,"Aerlur" ,"Kandem" ,"Krardam" ,"Caenlul" ,"Kreamardlal" ,"Surgrorus" ,"Umirlivar" ,"Thior" ,"Tun" ,"Kiem" ,"Nellel" ,"Geshal" ,"Kronan" ,"Einduss" ,"Soglundra" ,"Sojulnom" ,"Fashnovoldi" };
/*5*/  String maleFirbolgFirstNames[] =               {"Firebolg adopt elven names to communicate effectively with other races, but are normally without names."};
/*6*/  String maleGenasiFirstNames[] =               {"Alnata", "Buthcal", "Celbata", "Et'thar", "Gorfni", "Hal'gharn", "Indicus", "Kelva'rha", "Laspust", "Meirane", "Nekroh", "Ruini", "Saltaba", "Sontro'vhi", "Telbatra", "Toronir", "Umbaltis", "Vektro", "Walbin"};
/*7*/  String maleGnomeFirstNames[] =               {"Druost" ,"Dreex" ,"Kem" ,"Shmemi" ,"Pellon" ,"Dumziut" ,"Shmashtas" ,"Banzushte" ,"Kodwuamzot" ,"Tikqiuruodped" ,"Rerd" ,"Kod" ,"Grax" ,"Gisteerd" ,"Anqen" ,"Kingont" ,"Krubex" ,"Datieleerd" ,"Konnouckerd" ,"Itharzoznu" ,"Nix" ,"Tid" ,"Shmas" ,"Vute" ,"Krodpuom" ,"Ami" ,"Harzus" ,"Kazoman" ,"Qebistit" ,"Grietracrano" };
/*8*/  String maleGoliathFirstNames[] =               {"Trun Jumaddlong" ,"Thacks Puth" ,"Feck Sebbluh" ,"Freplotro Opus" ,"Delnen Madnozbih" ,"Thems Wasirzot" ,"Toblicublet Gibrims" ,"Bugolmuck Heck" ,"Vum Krovretra" ,"Qowi Qanut" ,"Snaimlot Shum" ,"Shaclogleh Uemankin" ,"Macitit Tolpettla" ,"Krienco Nut" ,"Hig Blobs" ,"Qralnulpuck Hioth" ,"Ihhiock Chirndawebs" ,"Rog Sublaim" ,"Yoluesoth Mast" ,"Rupalpems Fevazehiack"};
/*9*/  String maleHalflingFirstNames[] =               {"Alton" ,"Beau" ,"Cade" ,"Eldon" ,"Garret" ,"Lyle" ,"Milo" ,"Osborn" ,"Roscoe" ,"Wellby" };
/*10*/ String maleHalf_ElfFirstNames[] =               {"Godlisar" ,"Yorhomin" ,"Lanmar" ,"Rodrynnon" ,"Yengretor" ,"Percifaelor" ,"Nilhorn" ,"Tanlanann" ,"Emparin" ,"Galemer" ,"Jefellan" ,"Engrith" ,"Jaquluin" ,"Gaerthor" ,"Reyenas" ,"Malcudal" ,"Warlar" ,"Lanceindel" ,"Rawxiron" ,"Radellan" ,"Jaclather" ,"Dramer" ,"Jorreak" ,"Mikduil" ,"Garmer" ,"Pierlaeron" ,"Micosrin" ,"Nigindel" ,"Richverel" ,"Uanfaelor"};
/*11*/ String maleHalf_OrcFirstNames[] =               {"Noad" ,"Halm" ,"Gad" ,"Cuul" ,"Tisk" ,"Pidarm" ,"Kolgrax" ,"Mustuzhg" ,"Brakas" ,"Paigraaghi" ,"Brok" ,"Grot" ,"Crich" ,"Barm" ,"Zek" ,"Deda" ,"Cike" ,"Kaghuch" ,"Tidzarv" ,"Hrordranguk" ,"Tsisk" ,"Hriarv" ,"Tuch" ,"Nilm" ,"Tad" ,"Cruzvarm" ,"Brudiask" ,"Hroakazhg" ,"Kokdoad" ,"Aizzadhech" };
/*12*/ String maleHumanFirstNames[] =               {"Park" ,"Roland" ,"Conrad" ,"Bay" ,"Emery" ,"Federigo" ,"Neddy" ,"Bordan" ,"Linn" ,"Dixon" ,"Winimar" ,"Rahul" ,"Stanley" ,"Jerker" ,"Paget" ,"Coyan"};
/*13*/ String maleKenkuFirstNames[] =              {"Surkil" ,"Renkil" ,"Irtilk" ,"Eerik" ,"Ralkin" ,"Ack-chak" ,"Charbakk" ,"Chiko-chak" ,"Chi-choka" ,"Kelbik" };
/*14*/ String maleLizardfolkFirstNames[] =               {"Ssena" ,"Solasstas" ,"Gussh," ,"Hazorduss" ,"Vasculuss" ,"Lass" };
/*15*/ String maleTieflingFirstNames[] =               {"Kilakas" ,"Morlius" ,"Urixire" ,"Malrius" ,"Ozthor" ,"Urzer" ,"Mecius" ,"Hope" ,"Trouble" ,"Hatred" };
/*16*/ String maleAarakocraFirstNames[] =              {"Aera" ,"Aial" ,"Aur" ,"Deekek" ,"Errk" ,"Heehk" ,"Ikki" ,"Kleeck" ,"Oorr" ,"Ouss" ,"Quaf" ,"Quierk" ,"Salleek" ,"Urreek" ,"Zeed" };
/*17*/ String maleChangelingFirstNames[] =             {"Bin" ,"Dox" ,"Fie" ,"Hars" ,"Jin" ,"Lam" ,"Nit" ,"Ot" ,"Paik" ,"Ruz" ,"Sim" ,"Toox" ,"Yog" };
/*18*/ String maleGoblinFirstNames[] =              {"Rol" ,"Glong" ,"Lat" ,"Birt" ,"Brer" ,"Duissulb" ,"Griahboct" ,"Drianroikz" ,"Tiogrurx" ,"Ohbic" ,"Ohbic" };
/*19*/ String maleKorFirstNames[] =              {"Arthi" ,"Durnan" ,"Forkai" ,"Kurmo" ,"Munda" ,"Sorto" ,"Zujrat" };
/*20*/ String maleMerfolkFirstNames[] =              {"Drake" ,"Salas" ,"Aquis" ,"Sedor" ,"Agrata" ,"Typhon" ,"Nido" ,"Latus" };
/*21*/ String maleMinotaurFirstNames[] =              {"Jabur" ,"Podtaruk" ,"Aregur" ,"Jarrus" ,"Dataruk" ,"Jarraduk" ,"Kurrus" ,"Djarrak" ,"Hunrakar" ,"Krumtoron" };
/*22*/ String maleShifterFirstNames[] =               {"Ash" ,"Brook" ,"Claw" ,"Cliff" ,"Flint" ,"Frost" ,"River" ,"Rock" ,"Storm" ,"Thorn" ,"Torn" };
/*23*/ String maleVampireFirstNames[] =               {"Moldark" ,"Arthur" ,"Nostro" ,"Luther" ,"Brander" ,"Cassius" ,"Dreven" ,"Echo" ,"Wilfred" ,"Damien" };
/*24*/ String maleWarforgedFirstNames[] =                {"Warforged adopt a name from the race that built them. They also do not have gender."};


/**/   String maleAasimarLastNames[] =            {"Huvenkir", "Ponvul","Kripolmal","Omlo", "Bynmuhym","Buman","Krogralur","Lelman","Bymlakrur","Ibo", "Irwikre","Dalam","Drorvelly", "Pikur","Synmergy","Lulwo", "Lanvulgo","Toho","Mankavir", "Dega","Hollirgu","Irge", "Uldryrvu","Olsa","Nugolsem", "Sigem","Welakmen","Zikum", "Tilrulga","Wurvum","Tekepym", "Ikmu", "Dulselsim", "Uko", "Wydyrgur", "Duvun", "Ikrallon", "Imy", "Hadanvin", "Buko", "Mupekry", "Niry", "Broki", "Mylsalli", "Uka", "Pylrarve", "Bikmon", "Memlulmal", "Menger"};
/**/   String maleDragonbornLastNames[] =        {"Ravaran", "Grax", "Arjhan", "Armagan", "Arzan", "Sarax", "Balkris", "Sirizan", "Drafarn", "Torinn", "Axaran", "Draxan", "Kriv", "Mar", "Sarram", "Brevarr", "Donaar", "Inzul", "Medrash", "Drafarn", "Pandjed", "Shamash", "Tarhun", "Toxal", "Drabor"};
/**/   String maleDwarfLastNames[] =      {"Proudroar", "Tadar", "Wisemight", "Virg", "Flamebend", "Byhyb", "Wisepelt", "Zommys", "Hardbeam", "Lith", "Singlebrew", "Debbull", "Cragbluff", "Loc", "Steelmaul", "Strever", "Grandtrack", "Yukuk", "Boulderhelm", "Foh","Plainfell" ,"Fadmad" ,"Flatblaze" ,"Tah" ,"Coldscar" ,"Hakar" ,"Commonbrow" ,"Ghorgruk" ,"Titanridge" ,"Tug" ,"Cindergrip" ,"Fovyb" ,"Prideforge" ,"Srog" ,"Softgaze" ,"Jozdob" ,"Humblebrew" ,"Nodlold" ,"Stonesurge" ,"Drem" ,"Rumblesteam" ,"Lagdut" ,"Firebreath" ,"Dul" ,"Fusegleam" ,"Dendrudd" ,"Shieldshadow" ,"Strakerd" ,"Greatward" ,"Wimn" ,"Coldbend" ,"Ghydmal" ,"Grandward" ,"Tral" ,"Axeglow" ,"Yadnyh" ,"Fireforge" ,"Stygnid" ,"Winterroar" ,"Stum" ,"Fairbelly" ,"Ranngvob" ,"Solidbend" ,"Khild" ,"Blazestrength" ,"Srundres" ,"Lowpelt" ,"Derstold" ,"Bronzehair" ,"Stroth" ,"Fairbelly" ,"Ranngvob" ,"Solidbend" ,"Khild" ,"Blazestrength" ,"Srundres" ,"Lowpelt" ,"Derstold" ,"Bronzehair" ,"Stroth" };
/**/   String maleElfLastNames[] =        {"Onsellvih" ,"Grun" ,"Airerlal" ,"Jaclo" ,"Ikermar" ,"Gun" ,"Aiganthe" ,"Dos" ,"Vuldlirlai" ,"Fegho" ,"Javallmeer" ,"Yas" ,"Dishevur" ,"Grugal" ,"Jilhrinees" ,"Sim" ,"Fulnirron" ,"Zhon" ,"Shadodal" ,"Timio" ,"Cenagies" ,"Mah" ,"Olnida" ,"Tallvion" ,"Tuldlonu" ,"Har" ,"Vikeendle" ,"Gis" ,"Sinsisah" ,"Jerael" ,"Iokijol" ,"Mah" ,"Gehive" ,"Zensu" ,"Zaimmallvol" ,"Yem" ,"Tenremrim" ,"Groh" ,"Vienrodus" ,"Cehhum" };
/**/   String maleFirbolgLastNames[] =    {""};
/**/   String maleGenasiLastNames[] =   {""};
/**/   String maleGnomeLastNames[] =        {"Valfopplod" ,"Ness" ,"Blaprotlid" ,"Govrick" ,"Ibblagwams" ,"Thesp" ,"Qagwansaeb" ,"Fung" ,"Mocobleng" ,"Hithoth" ,"Namodlu" ,"Guth" ,"Ettlallud" ,"Shaerlong" ,"Goddlopplor" ,"Frood" ,"Tanongnost" ,"Tacks" ,"Hathidna" ,"Krubbluh" ,"Glepplalmug" ,"Qam" ,"Ulnozab" ,"Ozin" ,"Midfopswiss" ,"Gust" ,"Heelpappar" ,"Klick" ,"Thaeldrialfoosp" ,"Giddlag" };
/**/   String maleGoliathLastNames[] =      {"Sum" ,"Gruzlaabblacks" ,"Okut" ,"Jid" ,"Bedesush" ,"Chibridi" ,"Push" ,"Bobs" ,"Huem" ,"Jiovuaplom" ,"Zoxes" ,"Kuast" ,"Hatuthireck" ,"Subaattlen" ,"Snin" ,"Mogno" ,"Tinnus" ,"Gracapruath" ,"Snirlolig" ,"Krudrebs"};
/**/   String maleHalflingLastNames[] =     {"Brushgather" ,"Goodbarrel" ,"Greenbottle" ,"Highhill" ,"Hilltopple" ,"Leagallow" ,"Tealeaf" ,"Thorngage" ,"Tosscobble" ,"Underbough" };
/**/   String maleHalf_ElfLastNames[] =       {"Preskian" ,"Balqen" ,"Roharice" ,"Yelvalur" ,"Erfina" ,"Valran" ,"Zylzorwyn" ,"Xyrhorn" ,"Naexisys" ,"Valris" ,"Herthyra" ,"Inaneiros" ,"Reystina" ,"Aemoira" ,"Darora" ,"Jophyra" ,"Yinthyra" ,"Inaharice" ,"Pergeiros" ,"Leomyar" ,"Chaevalur" ,"Grewarin" ,"Joberos" ,"Xilsalor" ,"Omajyre" ,"Arahana" ,"Omaberos" ,"Grenorin" ,"Trisren" ,"Daharice"};
/**/   String maleHalf_OrcLastNames[] =        {"Retsky" ,"Ungech" ,"Shoch" ,"Gnaglulnutsky" ,"Nelm" ,"Vimi" ,"Mak" ,"Madke" ,"Gilm" ,"Hisruxli" ,"Riz" ,"Vinga" ,"Butsky" ,"Thudokrax" ,"Ditsky" ,"Gakashky" ,"Ban" ,"Urka" ,"Naz" ,"Thalgrinda" ,"Son" ,"Zugre" ,"Gashky" ,"Sirixleshky" ,"Gned" ,"Murgok" ,"Nen" ,"Wervek" ,"Tom" ,"Shetskonuv" };
/**/   String maleHumanLastNames[] =       {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow"};
/**/   String maleKenkuLastNames[] =        {"Black-feather" ,"Greytalon" ,"Pickle-feather" ,"Silverwing" };
/**/   String maleLizardfolkLastNames[] =          {""};
/**/   String maleTieflingLastNames[] =          {""};
/**/   String maleAarakocraLastNames[] =       {""};
/**/   String maleChangelingLastNames[] =          {""};
/**/   String maleGoblinLastNames[] =     {""};
/**/   String maleKorLastNames[] =   {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow"};
/**/   String maleMerfolkLastNames[] =     {""};
/**/   String maleMinotaurLastNames[] =   {"Nimblestep" ,"Singlehorn" ,"Ruggedhide" ,"Boldwarrior" ,"Swiftwalker" ,"Stoutheart" ,"Stonehide" ,"Steelhide" ,"Ironheart" ,"Bearfighter" };
/**/   String maleShifterLastNames[] =    {""};
/**/   String maleVampireLastNames[] =       {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow"};
/**/   String maleWarforgedLastNames[] =     {""};


/*1*/  String femaleAasimarFirstNames[] = {"Uazi", "Rhere", "Emro", "Ulel", "Bipu", "Dudyu", "Dingoegroh", "Noruve", "Apama", "Paltevi","Dezul", "Drunu", "Phenir", "Inkou", "Paltevi","Dezul", "Amlen", "Lugra", "Iyede", "Bruldrinyeh","Dronyouruh", "Anadra"};
/*2*/  String femaleDragonbornFirstNames[] =  {"Bloodbane" , "Kerthylon", "Norixius", "Drakerider", "Yarjerit", "Orithyra", "Malthyra", "Welsirina", "Aririna", "Jobis", "Akira", "Vyrafaeth", "Quilqwen", "Sobirith", "Kamyse", "Vyrazita", "Valsaadi", "Faegwen", "Hindalynn", "Phidrith", "Kavys", "Qigwen", "Hinkaryn", "Xisgwen", "Jesvyre"};
/*3*/  String femaleDwarfFirstNames[] = {"Si", "Gi", "Srol", "Dan", "Ge", "Fevro", "Imwut", "Ghotrut", "Ulbo", "Bhabbin ", "Ghotrut", "Ghotrut", "Ghotrut", "Ghotrut", "Ghotrut", "Ghotrut", "Ghotrut", "Ghotrut","Thra" ,"Dos" ,"Sra" ,"Vu" ,"Vim" ,"Bobnu" ,"Enwel" ,"Drigwu" ,"Sengro" ,"Havras" ,"Se" ,"Ho" ,"Khul" ,"Fumn" ,"Lu" ,"Dilwa" ,"Uza" ,"Yine" ,"Virlu" ,"Vunwo" ,"Gi" ,"Remn" ,"Sras" ,"Hu" ,"Thra" ,"Nake" ,"Lilba" ,"Sibnes" ,"Fanwo" ,"Fubne" };
/*4*/  String femaleElfFirstNames[] =    {"Vothi" ,"Soucno" ,"Ighan" ,"Inle" ,"Umeaemhis" ,"Issacle", "Camilla" ,"Ange" ,"Josefin" ,"Ava" ,"Pandora" ,"Dianna" ,"Sharon" ,"Lucilla" ,"Walburge" ,"Gabriella" ,"Karoline" ,"Susanna" ,"Nastasia"};
/*5*/  String femaleFirbolgFirstNames[] = {"Firebolg adopt elven names to communicate effectively with other races, but are normally without names."};
/*6*/  String femaleGenasiFirstNames[] =  {"Ainara", "Celtara", "Deshani", "El'karin", "Fra'nika", "Ilshara", "Kinshali", "Lo'hatra", "Nalhira", "Palkeiru", "Roshara", "Schi'vya", "Sultara", "Un'batra", "Vintrana", "Vul'shia"};
/*7*/  String femaleGnomeFirstNames[] = {"Trun" ,"Sum" ,"Puth" ,"Feck" ,"Okut" ,"Opus" ,"Delnen" ,"Bedesush" ,"Wasirzot" ,"Toblicublet" ,"Push" ,"Heck" ,"Vum" ,"Huem" ,"Qanut" ,"Snaimlot" ,"Zoxes" ,"Uemankin" ,"Macitit" ,"Hatuthireck" ,"Nut" ,"Hig" ,"Snin" ,"Hioth" ,"Ihhiock" ,"Tinnus" ,"Sublaim" ,"Yoluesoth" ,"Snirlolig" ,"Fevazehiack" };
/*8*/  String femaleGoliathFirstNames[] ={"Maalu Fearless" ,"Agerea Wildfinder" ,"Thami Lumberhauler" ,"Lenia Hidetanner" ,"Thanea Brightheart" ,"Orithia Wisewalker" ,"Veria Steadyhand" ,"Gegeo Goatwatcher" ,"Oneleo Keenwatcher" ,"Vevi Rocksmasher" ,"Paathia Mastercook" ,"Thegu Mountainclimber" ,"Vaapu Nightrunner" ,"Kuolo Minddrifter" ,"Manlai Rockbreaker" ,"Vaarea Swiftaid" ,"Thugeo Bearkiller" ,"Agenu Wildfinder" ,"Menia Deerchaser" ,"Keneo Swiftrunner" ,"Manvea Hidetanner" ,"Nane Bearvigor" ,"Methe Adeptweaver" ,"Kilo Frightheart" ,"Naneo Bearfinder" ,"Lane Horncarver" ,"Meri Deerhunter" ,"Thugea Lowlander" ,"Nilu Flowerpicker" ,"Maala Rocksmasher" };
/*9*/  String femaleHalflingFirstNames[] =             {"Amaryllis" ,"Charmaine" ,"Cora" ,"Euphemia" ,"Jillian" ,"Lavinia" ,"Lidda" ,"Merla" ,"Portia" ,"Seraphina" ,"Verna" };
/*10*/ String femaleHalf_ElfFirstNames[] =            {"Sephbellis" ,"Safhala" ,"Vicrunia" ,"Arlantha" ,"Xilledha" ,"Mahleth" ,"Ysalaerla" ,"Jenzenya" ,"Madlarue" ,"Alirolia" ,"Iblei" ,"Saflia" ,"Aridaerae" ,"Dardove" ,"Lilivara" ,"Nerisia" ,"Emleria" ,"Helrin" ,"Mansys" ,"Cedleth" ,"Evelrila" ,"Orirora" ,"Grelynna" ,"Hadlarue" ,"Harlatha" ,"Thefbwynn" ,"Nornastha" ,"Emelsala" ,"Selniya" ,"Harlyn"};
/*11*/ String femaleHalf_OrcFirstNames[] =          {"Orellana" ,"Nyjala" ,"Nenya" ,"Methena" ,"Merynda" ,"Linxia" ,"Lugena" ,"Lucenia" ,"Larala" ,"Kenia" ,"Kerela" ,"Kalevi"};
/*12*/ String femaleHumanFirstNames[] =            {"Marisa" ,"Hana" ,"Raelynn" ,"Sherlyn" ,"Brittany" ,"Kate" ,"Cristal" ,"Kaydence" ,"Aleena" ,"Janiyah" ,"Claire" ,"Mireya" };
/*13*/ String femaleKenkuFirstNames[] =         {"Krekie" ,"Arkri" ,"Erskin" ,"Kariin" ,"Ulkin","Chaki" ,"Chi-bi" ,"Falkai" ,"Khadri" ,"Wiki-chi"};
/*14*/ String femaleLizardfolkFirstNames[] =          {"Ssena" ,"Solasstas" ,"Gussh," ,"Hazorduss" ,"Vasculuss" ,"Lass" };
/*15*/ String femaleTieflingFirstNames[] =          {"Infaris" ,"Yapunith" ,"Natlypsis" ,"Quza" ,"Masolis" ,"Neki" ,"Naki" ,"Optimal" ,"Life" ,"Dread" };
/*16*/ String femaleAarakocraFirstNames[] =            {"Aera" ,"Aial" ,"Aur" ,"Deekek" ,"Errk" ,"Heehk" ,"Ikki" ,"Kleeck" ,"Oorr" ,"Ouss" ,"Quaf" ,"Quierk" ,"Salleek" ,"Urreek" ,"Zeed" };
/*17*/ String femaleChangelingFirstNames[] =        {"Bin" ,"Dox" ,"Fie" ,"Hars" ,"Jin" ,"Lam" ,"Nit" ,"Ot" ,"Paik" ,"Ruz" ,"Sim" ,"Toox" ,"Yog" };
/*18*/ String femaleGoblinFirstNames[] =            {"If" ,"Hox" ,"Yhx" ,"Swal" ,"Gas" ,"Khoimold" ,"Civlyrx" ,"Slureens" ,"Dubhoih" ,"Lardert" };
/*19*/ String femaleKorFirstNames[] =        {"Ayli" ,"Cartha" ,"Jurni" ,"Matra" ,"Nahiri" ,"Smara" ,"Virian" };
/*20*/ String femaleMerfolkFirstNames[] =            {"Jabur" ,"Podtaruk" ,"Aregur" ,"Jarrus" ,"Dataruk" ,"Jarraduk" ,"Kurrus" ,"Djarrak" ,"Hunrakar" ,"Krumtoron" };
/*21*/ String femaleMinotaurFirstNames[] =          {"Anosa" ,"Kella" ,"Atlise" ,"Morea" ,"Soreen" ,"Corselle" ,"Ulanda" ,"Ari" };
/*22*/ String femaleShifterFirstNames[] =           {"Iretred" ,"Tinanas" ,"Hinepe" ,"Asela" ,"Iasres" ,"Duukane" ,"Nuores" ,"Seeskea" ,"Tiakea" ,"Hesna" };
/*23*/ String femaleVampireFirstNames[] =        {"Aurora" ,"Autumn" ,"Dawn" ,"Hazel" ,"Iris" ,"Lily" ,"Rain" ,"Rose" ,"Summer" };
/*24*/ String femaleWarforgedFirstNames[] =         {"Warforged adopt a name from the race that built them. They also do not have gender."};

/**/ String femaleAasimarLastNames[] =               {"Tekepym", "Ikmu", "Dulselsim", "Uko", "Wydyrgur", "Duvun", "Ikrallon", "Imy", "Hadanvin", "Buko", "Mupekry", "Niry", "Broki", "Mylsalli", "Uka", "Pylrarve", "Bikmon", "Memlulmal", "Menger","Huvenkir", "Ponvul","Kripolmal","Omlo", "Bynmuhym","Buman","Krogralur","Lelman","Bymlakrur","Ibo", "Irwikre","Dalam","Drorvelly", "Pikur","Synmergy","Lulwo", "Lanvulgo","Toho","Mankavir", "Dega","Hollirgu","Irge", "Uldryrvu","Olsa","Nugolsem", "Sigem","Welakmen","Zikum", "Tilrulga","Wurvum"};
/**/ String femaleDragonbornLastNames[] =             {"Mishann" , "Dakira", "Nysoria", "Xynys", "Belsira", "Athyra", "Biri", "Dacoria", "Naya", "Sarcha", "Hameila", "Khagra", "Akra", "Cariel", "Kalas","Sora"};
/**/ String femaleDwarfLastNames[] =            {"Cragsnow","Bahgal","Softward","Sroh","Brightblaze","Zandrib","Truesky","Stergyck","Grandthorn","Zom","Rocksky","Jivlog","Strongstrength","Bom","Silentblaze","Fidam","Solidroar","Wudic","Rockmight" ,"Leldruld" ,"Grandgrip" ,"Grols" ,"Lowward" ,"Hunforg" ,"Coldthorn" ,"Thringreck" ,"Stormbrand" ,"Lord" ,"Silentforce" ,"Stredwild" ,"Fairgrip" ,"Doh" ,"Titanthorn" ,"Kuzwec" ,"Ironpelt" ,"Siglodd" ,"Lonesnow" ,"Mord" ,"Firesword" ,"Gredwull" ,"Axehair" ,"Ghys" ,"Thundermaul" ,"Jaldedd" ,"Flamebeam" ,"Brodmeth" ,"Lowtrack" ,"Job" };
/**/ String femaleElfLastNames[] =             {"Geenodaer" ,"Wes" ,"Esluses" ,"Juril" ,"Lunonlar" ,"Jon" ,"Yekiendril" ,"Deh" ,"Shunsalli" ,"Zhoki" ,"Ollivo" ,"Geh" ,"Ikolnas" ,"Wogle" ,"Temurri" ,"Nih" ,"Shillmemnain" ,"Lain" ,"Yononse" ,"Sainel" ,"Vasheldeh" ,"Cah" ,"Nolvreelhro" ,"Ferdar" ,"Miolage" ,"Zhem" ,"Oglirdloh" ,"Shoh" ,"Celaikel" ,"Cirmiol" };
/**/ String femaleFirbolgLastNames[] =             {""};
/**/ String femaleGenasiLastNames[] =              {""};
/**/ String femaleGnomeLastNames[] =             {"Jumaddlong" ,"Thacks" ,"Gruzlaabblacks" ,"Sebbluh" ,"Freplotro" ,"Jid" ,"Madnozbih" ,"Thems" ,"Chibridi" ,"Gibrims" ,"Bugolmuck" ,"Bobs" ,"Krovretra" ,"Qowi" ,"Jiovuaplom" ,"Shum" ,"Shaclogleh" ,"Kuast" ,"Tolpettla" ,"Krienco" ,"Subaattlen" ,"Blobs" ,"Qralnulpuck" ,"Mogno" ,"Chirndawebs" ,"Rog" ,"Gracapruath" ,"Mast" ,"Rupalpems" ,"Krudrebs" };
/**/ String femaleGoliathLastNames[] =             {"Vuma-Thithino" ,"Nulakiala" ,"Vaimei-Liaga" ,"Inulekali" ,"Thenalakane" ,"Malukalathi" ,"Kolakukane" ,"Nalakigala" ,"Malukiano" ,"Veomiala" ,"Nola-Kageane" ,"Thulukena" ,"Nulakigone" ,"Nugaliano" ,"Kalukeaku" ,"Agu-Ulelo" ,"Vunakukane" ,"Geanamune" ,"Gathakulane" ,"Agu-Vutha" ,"Vathunakanu" ,"Ovethiano" ,"Vaimei-Lakume" ,"Munakutha" ,"Vaimei-Liaga" ,"Kulumeaku" ,"Agu-Vakume" ,"Egena-Vatho" ,"Kolae-Gugate" ,"Vunakamune" };
/**/ String femaleHalflingLastNames[] =             {"Brushgather" ,"Goodbarrel" ,"Greenbottle" ,"Highhill" ,"Hilltopple" ,"Leagallow" ,"Tealeaf" ,"Thorngage" ,"Tosscobble" ,"Underbough" };
/**/ String femaleHalf_ElfLastNames[] =             {"Faero" ,"Liavaris" ,"Herlynn" ,"Yllacyne" ,"Yelzorwyn" ,"Valralei" ,"Sartoris" ,"Daehana" ,"Shabella" ,"Reyleth" ,"Shalamin" ,"Heihice" ,"Presdi" ,"Nerilee" ,"Mirazorwyn" ,"Morven" ,"Loracaryn" ,"Aralen" ,"Olororis" ,"Qinberos" ,"Loralamin" ,"Dagella" ,"Holaxalim" ,"Perphine" ,"Xyrfaren" ,"Liahana" ,"Shana" ,"Heledi" ,"Daenan" ,"Pawarin"};
/**/ String femaleHalf_OrcLastNames[] =             {"Steeloak" ,"Beartoe" ,"Mournfang" ,"Starridge" ,"Winterbend" ,"Sternspell" ,"Dirgeguard" ,"Duskdown" ,"Youngwoods" ,"Skypike" ,"Firebreaker" ,"Windkiller" ,"Dawnterror" ,"Bloodless" ,"Dragonbane" ,"Dragonbane"};
/**/ String femaleHumanLastNames[] =             {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow","Skystrength" ,"Spiritblossom" ,"Bonewhirl" ,"Windwoods" ,"Marblefury" ,"Regalwhisper" ,"Skullbrew" ,"Cloudcrag" ,"Battletrapper" ,"Hammershot" };
/**/ String femaleKenkuLastNames[] =             {"Black-feather" ,"Greytalon" ,"Pickle-feather" ,"Silverwing" };
/**/ String femaleLizardfolkLastNames[] =             {""};
/**/ String femaleTieflingLastNames[] =             {""};
/**/ String femaleAarakocraLastNames[] =             {""};
/**/ String femaleChangelingLastNames[] =             {""};
/**/ String femaleGoblinLastNames[] =             {""};
/**/ String femaleKorLastNames[] =             {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow"};
/**/ String femaleMerfolkLastNames[] =             {""};
/**/ String femaleMinotaurLastNames[] =             {"Nimblestep" ,"Singlehorn" ,"Ruggedhide" ,"Boldwarrior" ,"Swiftwalker" ,"Stoutheart" ,"Stonehide" ,"Steelhide" ,"Ironheart" ,"Bearfighter" };
/**/ String femaleShifterLastNames[] =             {"Goldbeard" ,"Elfmoon" ,"Stagwatcher" ,"Steelreaver" ,"Grassspirit" ,"Dayjumper" ,"Suntail" ,"Phoenixshot" ,"Blazeoak" ,"Firesnow"};
/**/ String femaleVampireLastNames[] =             {"Gloomwhisper" ,"Nicklehorn" ,"Axeward" ,"Chestflaw" ,"Liongrove" ,"Nosebreeze" ,"Hardthorn" ,"Fusebraid" ,"Forestroot" ,"Crystalmore" };
/**/ String femaleWarforgedLastNames[] =             {""};

//
//    String neitherFirstNames[][] = {
//            {"Aasimar have gender"},
//            {"Dragonborn have gender"},
//            {"Dwarves have gender"},
//            {"Elves have gender"},
//            {"Firebolg have gender"},
//            {"Genasi have gender"},
//            {"Gnomes have gender"},
//            {"Goliaths have gender"},
//            {"Halflings have gender"},
//            {"Half-Elves have gender"},
//            {"Half-Orcs have gender"},
//            {"Humans have gender"},
//            {"Kenkus have gender"},
//            {"Tiefling have gender also they don't really care about names"},
//            {"Aarakocra have gender they mainly use one word nickname since most people can't pronounce their real names"},
//            {"Changlings have gender also they only use one syllably names"},
//            {"Goblins have gender, their names suck"},
//            {"Kor have gender"},
//            {"Merfolk have gender"},
//            {"Minotaurs have gender"},
//            {"Shifters have gender"},
//            {"Vampires have gender"},
//
//    };
//
//    String neitherLastNames[][] = {
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {""},
//            {}


   // };


    String firstNameHolder;
    String lastNameHolder ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflates the layout or converts xml to java objects
        final View inflatedView = inflater.inflate(R.layout.fragment_generate, container, false);

        //Fashions new font
        final Typeface codeOTF = Typeface.createFromAsset(getActivity().getAssets(), "IMMORTAL.ttf");

        //Finds the views in the generate layout
        genButton = (Button) inflatedView.findViewById(R.id.generateButton);
        savButton = (Button) inflatedView.findViewById(R.id.saveButton);
        final Spinner raceSpinner = (Spinner) inflatedView.findViewById(R.id.Race);
        final Spinner genderSpinner = (Spinner) inflatedView.findViewById(R.id.Gender);
        final TextView generatedName = (TextView) inflatedView.findViewById(R.id.generatedName);
        final RadioButton radioVoice = (RadioButton) inflatedView.findViewById(R.id.radioVoiceOn);

        generatedName.setMovementMethod(new ScrollingMovementMethod());

        //creates a new text to speech object
        genVoice = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                   errResultOfVoice = genVoice.setLanguage(Locale.getDefault());
                else
                {
                    Toast.makeText(getContext(), "You may not have the UK language installed", Toast.LENGTH_LONG).show();
                }
            }
        });


                //Sets the buttons fonts
                genButton.setTypeface(codeOTF);
                savButton.setTypeface(codeOTF);
                generatedName.setTypeface(codeOTF);

                //Sets the adapters up with the custom textviews and then sets the spinners with the adapters
                ArrayAdapter<String> raceAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_dropdownlayout,
                        getResources().getStringArray(R.array.race));
                ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_dropdownlayout,
                        getResources().getStringArray(R.array.gender));
                raceSpinner.setAdapter(raceAdapter);
                genderSpinner.setAdapter(genderAdapter);

        //Generates the insult each time the button is clicked
        genButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int racePos = raceSpinner.getSelectedItemPosition();
                int genderPos = genderSpinner.getSelectedItemPosition();

                int randNum;

                if(genderSpinner.getSelectedItemPosition() == 0) {
                    switch (racePos)
                    {
                        case 0:randNum = randNumGen.nextInt(femaleAasimarFirstNames.length - 1);
                              firstNameHolder = femaleAasimarFirstNames[randNum];
                              randNum = randNumGen.nextInt(femaleAasimarLastNames.length -1);
                              lastNameHolder = femaleAasimarLastNames[randNum];
                            break;
                        case 1:randNum = randNumGen.nextInt(femaleDragonbornFirstNames.length - 1);
                            firstNameHolder = femaleDragonbornFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleDragonbornLastNames.length -1);
                            lastNameHolder = femaleDragonbornLastNames[randNum];
                            break;
                        case 2:randNum = randNumGen.nextInt(femaleDwarfFirstNames.length - 1);
                            firstNameHolder = femaleDwarfFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleDwarfLastNames.length -1);
                            lastNameHolder = femaleDwarfLastNames[randNum];
                            break;
                        case 3:randNum = randNumGen.nextInt(femaleElfFirstNames.length - 1);
                            firstNameHolder = femaleElfFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleElfLastNames.length -1);
                            lastNameHolder = femaleElfLastNames[randNum];
                            break;
                        case 4:randNum = randNumGen.nextInt(femaleFirbolgFirstNames.length);
                            firstNameHolder = femaleFirbolgFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleFirbolgLastNames.length);
                            lastNameHolder = femaleFirbolgLastNames[randNum];
                            break;
                        case 5:randNum = randNumGen.nextInt(femaleGenasiFirstNames.length - 1);
                            firstNameHolder = femaleGenasiFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleGenasiLastNames.length);
                            lastNameHolder = femaleGenasiLastNames[randNum];
                            break;
                        case 6:randNum = randNumGen.nextInt(femaleGnomeFirstNames.length - 1);
                            firstNameHolder = femaleGnomeFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleGnomeLastNames.length -1);
                            lastNameHolder = femaleGnomeLastNames[randNum];
                            break;
                        case 7:randNum = randNumGen.nextInt(femaleGoliathFirstNames.length - 1);
                            firstNameHolder = femaleGoliathFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleGoliathLastNames.length -1);
                            lastNameHolder = femaleGoliathLastNames[randNum];
                            break;
                        case 8:randNum = randNumGen.nextInt(femaleHalflingFirstNames.length - 1);
                            firstNameHolder = femaleHalflingFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleHalflingLastNames.length -1);
                            lastNameHolder = femaleHalflingLastNames[randNum];
                            break;
                        case 9:randNum = randNumGen.nextInt(femaleHalf_ElfFirstNames.length - 1);
                            firstNameHolder = femaleHalf_ElfFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleHalf_ElfLastNames.length -1);
                            lastNameHolder = femaleHalf_ElfLastNames[randNum];
                            break;
                        case 10:randNum = randNumGen.nextInt(femaleHalf_OrcFirstNames.length - 1);
                            firstNameHolder = femaleHalf_OrcFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleHalf_OrcLastNames.length -1);
                            lastNameHolder = femaleHalf_OrcLastNames[randNum];
                            break;
                        case 11:randNum = randNumGen.nextInt(femaleHumanFirstNames.length - 1);
                            firstNameHolder = femaleHumanFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleHumanLastNames.length -1);
                            lastNameHolder = femaleHumanLastNames[randNum];
                            break;
                        case 12:randNum = randNumGen.nextInt(femaleKenkuFirstNames.length - 1);
                            firstNameHolder = femaleKenkuFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleKenkuLastNames.length -1);
                            lastNameHolder = femaleKenkuLastNames[randNum];
                            break;
                        case 13:randNum = randNumGen.nextInt(femaleLizardfolkFirstNames.length - 1);
                            firstNameHolder = femaleLizardfolkFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleLizardfolkLastNames.length);
                            lastNameHolder = femaleLizardfolkLastNames[randNum];
                            break;
                        case 14:randNum = randNumGen.nextInt(femaleTieflingFirstNames.length - 1);
                            firstNameHolder = femaleTieflingFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleTieflingLastNames.length);
                            lastNameHolder = femaleTieflingLastNames[randNum];
                            break;
                        case 15:randNum = randNumGen.nextInt(femaleAarakocraFirstNames.length - 1);
                            firstNameHolder = femaleAarakocraFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleAarakocraLastNames.length);
                            lastNameHolder = femaleAarakocraLastNames[randNum];
                            break;
                        case 16:randNum = randNumGen.nextInt(femaleChangelingFirstNames.length - 1);
                            firstNameHolder = femaleChangelingFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleChangelingLastNames.length);
                            lastNameHolder = femaleChangelingLastNames[randNum];
                            break;
                        case 17:randNum = randNumGen.nextInt(femaleGoblinFirstNames.length - 1);
                            firstNameHolder = femaleGoblinFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleGoblinLastNames.length);
                            lastNameHolder = femaleGoblinLastNames[randNum];
                            break;
                        case 18:randNum = randNumGen.nextInt(femaleKorFirstNames.length - 1);
                            firstNameHolder = femaleKorFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleKorLastNames.length -1);
                            lastNameHolder = femaleKorLastNames[randNum];
                            break;
                        case 19:randNum = randNumGen.nextInt(femaleMerfolkFirstNames.length - 1);
                            firstNameHolder = femaleMerfolkFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleMerfolkLastNames.length);
                            lastNameHolder = femaleMerfolkLastNames[randNum];
                            break;
                        case 20:randNum = randNumGen.nextInt(femaleMinotaurFirstNames.length - 1);
                            firstNameHolder = femaleMinotaurFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleMinotaurLastNames.length -1);
                            lastNameHolder = femaleMinotaurLastNames[randNum];
                            break;
                        case 21:randNum = randNumGen.nextInt(femaleShifterFirstNames.length - 1);
                            firstNameHolder = femaleShifterFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleShifterLastNames.length -1);
                            lastNameHolder = femaleShifterLastNames[randNum];
                            break;
                        case 22:randNum = randNumGen.nextInt(femaleVampireFirstNames.length - 1);
                            firstNameHolder = femaleVampireFirstNames[randNum];
                            randNum = randNumGen.nextInt(femaleVampireLastNames.length -1);
                            lastNameHolder = femaleVampireLastNames[randNum];
                            break;
                        case 23:randNum = randNumGen.nextInt(femaleWarforgedFirstNames.length);
                            firstNameHolder = femaleWarforgedFirstNames[0];
                            randNum = randNumGen.nextInt(femaleWarforgedLastNames.length);
                            lastNameHolder = femaleWarforgedLastNames[randNum];
                            break;

                    }
                    sharedPrefChooser = 0;
                }
                else if(genderSpinner.getSelectedItemPosition() == 1){
                    switch (racePos) {

                        case 0:
                            randNum = randNumGen.nextInt(maleAasimarFirstNames.length - 1);
                            firstNameHolder = maleAasimarFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleAasimarLastNames.length - 1);
                            lastNameHolder = maleAasimarLastNames[randNum];
                            break;
                        case 1:
                            randNum = randNumGen.nextInt(maleDragonbornFirstNames.length - 1);
                            firstNameHolder = maleDragonbornFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleDragonbornLastNames.length - 1);
                            lastNameHolder = maleDragonbornLastNames[randNum];
                            break;
                        case 2:
                            randNum = randNumGen.nextInt(maleDwarfFirstNames.length - 1);
                            firstNameHolder = maleDwarfFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleDwarfLastNames.length - 1);
                            lastNameHolder = maleDwarfLastNames[randNum];
                            break;
                        case 3:
                            randNum = randNumGen.nextInt(maleElfFirstNames.length - 1);
                            firstNameHolder = maleElfFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleElfLastNames.length - 1);
                            lastNameHolder = maleElfLastNames[randNum];
                            break;
                        case 4:
                            randNum = randNumGen.nextInt(maleFirbolgFirstNames.length);
                            firstNameHolder = maleFirbolgFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleFirbolgLastNames.length);
                            lastNameHolder = maleFirbolgLastNames[randNum];
                            break;
                        case 5:
                            randNum = randNumGen.nextInt(maleGenasiFirstNames.length - 1);
                            firstNameHolder = maleGenasiFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleGenasiLastNames.length);
                            lastNameHolder = maleGenasiLastNames[randNum];
                            break;
                        case 6:
                            randNum = randNumGen.nextInt(maleGnomeFirstNames.length - 1);
                            firstNameHolder = maleGnomeFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleGnomeLastNames.length - 1);
                            lastNameHolder = maleGnomeLastNames[randNum];
                            break;
                        case 7:
                            randNum = randNumGen.nextInt(maleGoliathFirstNames.length - 1);
                            firstNameHolder = femaleGoliathFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleGoliathLastNames.length - 1);
                            lastNameHolder = maleGoliathLastNames[randNum];
                            break;
                        case 8:
                            randNum = randNumGen.nextInt(maleHalflingFirstNames.length - 1);
                            firstNameHolder = maleHalflingFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleHalflingLastNames.length - 1);
                            lastNameHolder = maleHalflingLastNames[randNum];
                            break;
                        case 9:
                            randNum = randNumGen.nextInt(maleHalf_ElfFirstNames.length - 1);
                            firstNameHolder = maleHalf_ElfFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleHalf_ElfLastNames.length - 1);
                            lastNameHolder = maleHalf_ElfLastNames[randNum];
                            break;
                        case 10:
                            randNum = randNumGen.nextInt(maleHalf_OrcFirstNames.length - 1);
                            firstNameHolder = maleHalf_OrcFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleHalf_OrcLastNames.length - 1);
                            lastNameHolder = maleHalf_OrcLastNames[randNum];
                            break;
                        case 11:
                            randNum = randNumGen.nextInt(maleHumanFirstNames.length - 1);
                            firstNameHolder = maleHumanFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleHumanLastNames.length - 1);
                            lastNameHolder = maleHumanLastNames[randNum];
                            break;
                        case 12:
                            randNum = randNumGen.nextInt(maleKenkuFirstNames.length - 1);
                            firstNameHolder = maleKenkuFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleKenkuLastNames.length - 1);
                            lastNameHolder = maleKenkuLastNames[randNum];
                            break;
                        case 13:
                            randNum = randNumGen.nextInt(maleLizardfolkFirstNames.length - 1);
                            firstNameHolder = maleLizardfolkFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleLizardfolkLastNames.length);
                            lastNameHolder = maleLizardfolkLastNames[randNum];
                            break;
                        case 14:
                            randNum = randNumGen.nextInt(maleTieflingFirstNames.length - 1);
                            firstNameHolder = maleTieflingFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleTieflingLastNames.length);
                            lastNameHolder = maleTieflingLastNames[randNum];
                            break;
                        case 15:
                            randNum = randNumGen.nextInt(maleAarakocraFirstNames.length - 1);
                            firstNameHolder = maleAarakocraFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleAarakocraLastNames.length);
                            lastNameHolder = maleAarakocraLastNames[randNum];
                            break;
                        case 16:
                            randNum = randNumGen.nextInt(maleChangelingFirstNames.length - 1);
                            firstNameHolder = maleChangelingFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleChangelingLastNames.length);
                            lastNameHolder = maleChangelingLastNames[randNum];
                            break;
                        case 17:
                            randNum = randNumGen.nextInt(maleGoblinFirstNames.length - 1);
                            firstNameHolder = maleGoblinFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleGoblinLastNames.length);
                            lastNameHolder = maleGoblinLastNames[randNum];
                            break;
                        case 18:
                            randNum = randNumGen.nextInt(maleKorFirstNames.length - 1);
                            firstNameHolder = maleKorFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleKorLastNames.length - 1);
                            lastNameHolder = maleKorLastNames[randNum];
                            break;
                        case 19:
                            randNum = randNumGen.nextInt(maleMerfolkFirstNames.length - 1);
                            firstNameHolder = maleMerfolkFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleMerfolkLastNames.length);
                            lastNameHolder = maleMerfolkLastNames[randNum];
                            break;
                        case 20:
                            randNum = randNumGen.nextInt(maleMinotaurFirstNames.length - 1);
                            firstNameHolder = maleMinotaurFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleMinotaurLastNames.length - 1);
                            lastNameHolder = maleMinotaurLastNames[randNum];
                            break;
                        case 21:
                            randNum = randNumGen.nextInt(maleShifterFirstNames.length - 1);
                            firstNameHolder = maleShifterFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleShifterLastNames.length - 1);
                            lastNameHolder = maleShifterLastNames[randNum];
                            break;
                        case 22:
                            randNum = randNumGen.nextInt(maleVampireFirstNames.length - 1);
                            firstNameHolder = maleVampireFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleVampireLastNames.length - 1);
                            lastNameHolder = maleVampireLastNames[randNum];
                            break;
                        case 23:
                            randNum = randNumGen.nextInt(maleWarforgedFirstNames.length);
                            firstNameHolder = maleWarforgedFirstNames[randNum];
                            randNum = randNumGen.nextInt(maleWarforgedLastNames.length);
                            lastNameHolder = maleWarforgedLastNames[randNum];
                            break;
                    }
                    sharedPrefChooser = 1;
                }
//                else{
//                    randNum = randNumGen.nextInt(8);
//                    firstNameHolder = neitherFirstNames[genderPos][randNum];
//                    randNum = randNumGen.nextInt(7);
//                    lastNameHolder = neitherLastNames[racePos][randNum];
//                    sharedPrefChooser = 2;
                //}

                firstLastTemplate = firstLastTemplate.replace("firstName", firstNameHolder);
                firstLastTemplate = firstLastTemplate.replace("lastName", lastNameHolder);

                generatedName.setText(firstLastTemplate);

                firstLastTemplate = "firstName lastName";


                //generates the speech of the text. if the button is checked
                if(radioVoice.isChecked())
                    if(errResultOfVoice == TextToSpeech.LANG_MISSING_DATA || errResultOfVoice == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Toast.makeText(getContext(), "You may not have the UK language installed or do not have text to speech supported on your device.", Toast.LENGTH_LONG).show();
                    }
                else{
                        genVoice.speak(generatedName.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, "voice");
                    }

            }
        });

        savButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int counter;
                    String counterTypeCast;

                Toast.makeText(getContext(), "Saved Name", Toast.LENGTH_SHORT).show();
                    //Makes 2 sharedPreferences files one for males and one for females.  It stores the name depending on what
                    //was set when they clicked generate.  0 is for male list, 1 is for female, but we use else
                    if(sharedPrefChooser == 0)
                    shared = getContext().getSharedPreferences(femaleNameList, Context.MODE_PRIVATE);
                    else if (sharedPrefChooser == 1)
                    shared = getContext().getSharedPreferences(maleNameList, Context.MODE_PRIVATE);
//                    else
//                        shared = getContext().getSharedPreferences(neitherNameList, Context.MODE_PRIVATE);


                    Map<String,?> keys = shared.getAll();

                    counter = keys.size();
                    counterTypeCast = Integer.toString(counter);

                    String insultGeneratedToBeStored = generatedName.getText().toString();
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString(counterTypeCast, insultGeneratedToBeStored);
                    editor.apply();

                }


        });

        mAdView = (AdView) inflatedView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        return inflatedView;

    }



}


