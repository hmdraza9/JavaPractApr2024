package test.java.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class RenameBulkFile {

	public static final String baseURL = "https://podcasts.qurancentral.com/urdu-translation-only/";

	public static final int dlProgressDivisor = 10;
	static SortedMap<Long, String> fileDatum = new TreeMap<Long, String>();
	static SortedMap<Long, String> fileDatumCheck = new TreeMap<Long, String>();
	static Iterator<String> it;

	public static final String dlFolder = "Quran_Urdu_Audio_dl/";

	public static final String dataFolder = "Quran_Urdu_Audio/";

	static long totalSize;

	public static void main(String[] args) throws IOException, URISyntaxException {
		fileDownloadManager(3, 3);
//		renameFiles();
		System.out.println("Total files size: " + getUnit(totalSize));
	}

	public static void renameFiles1() {
		File file = new File("Quran_Urdu_Audio_dl/001.mp3");
		File file2 = new File("Quran_Urdu_Audio_dl/");
		System.out.println("file2.isDirectory(): " + file2.isDirectory());
		System.out.println("file2.listFiles(): " + file2.listFiles());
		for (File f : file2.listFiles())
			System.out.println(f.getName());
//		System.out.println(file.renameTo(new File("Quran_Urdu_Audio/001_.mp3")));
	}

	public static void renameFiles() throws IOException {

//		String nameBefore = "001;002;003;004;005;006;007;008;009;010;011;012;013;014;015;016;017;018;019;020;021;022;023;024;025;026;027;028;029;030;031;032;033;034;035;036;037;038;039;040;041;042;043;044;045;046;047;048;049;050;051;052;053;054;055;056;057;058;059;060;061;062;063;064;065;066;067;068;069;070;071;072;073;074;075;076;077;078;079;080;081;082;083;084;085;086;087;088;089;090;091;092;093;094;095;096;097;098;099;100;101;102;103;104;105;106;107;108;109;110;111;112;113;114";

		String nameAfter = "001 - Al-Fatiha - The Opening - खुला (खुलना);002 - Al-Baqarah - The Cow - गाय (गाय);003 - Aal-E-Imran - The Family of Imran - ईमरान का परिवार (ईमरान का परिवार);004 - An-Nisa - The Women - महिलाएँ (महिलाएँ);005 - Al-Ma'idah - The Table Spread_ The Feast - मेज़ पर बिछाना (खाना);006 - Al-An'am - The Cattle - चौपाया (चौपाया);007 - Al-A'raf - The Heights_ The Elevated Places - उच्च स्थान (उच्च स्थान);008 - Al-Anfal - The Spoils of War_ The Booty - लूट (लूट);009 - At-Tawba - The Repentance_ The Immunity - पश्चाताप (पश्चाताप);010 - Yunus - Jonah - यूनुस (यूनुस);011 - Hud - Hud - हुद (हुद);012 - Yusuf - Joseph - यूसुफ (यूसुफ);013 - Ar-Ra'd - The Thunder - गरज (गरज);014 - Ibrahim - Abraham - इब्राहीम (इब्राहीम);015 - Al-Hijr - The Rocky Tract_ The Stoneland - पत्थरी इलाका (पत्थरी इलाका);016 - An-Nahl - The Bee - मधुमक्खी (मधुमक्खी);017 - Al-Isra - The Night Journey_ The Journey by Night - रात की यात्रा (रात की यात्रा);018 - Al-Kahf - The Cave - गुफा (गुफा);019 - Maryam - Mary - मरियम (मरियम);020 - Ta-Ha - Ta-Ha - ता हा (ता हा);021 - Al-Anbiya - The Prophets - पैगंबरों (पैगंबर);022 - Al-Hajj - The Pilgrimage - हज (हज);023 - Al-Muminoon - The Believers - मुमिनों (मुमिन);024 - An-Noor - The Light - रोशनी (रोशनी);025 - Al-Furqan - The Criterion_ The Standard - मानक (मानक);026 - Ash-Shu'ara - The Poets - कवियों (कवि);027 - An-Naml - The Ant - चींटी (चींटी);028 - Al-Qasas - The Stories_ The Narratives - किस्से (किस्से);029 - Al-Ankaboot - The Spider - मकड़ा (मकड़ा);030 - Ar-Rum - The Romans - रोमी (रोमी);031 - Luqman - Luqman - लुकमान (लुकमान);032 - As-Sajda - The Prostration_ The Adoration - सजदा (सजदा);033 - Al-Ahzab - The Confederates_ The Combined Forces - अहज़ाब (अहज़ाब);034 - Saba - Sheba - सबा (सबा);035 - Fatir - The Originator_ The Creator - पैदा करनेवाला (बनानेवाला);036 - Ya-Sin - Ya-Sin - या-सीन (या-सीन);037 - As-Saffat - Those Who Set the Ranks_ Those Ranged in Ranks - पंक्तियाँ (सेना की तैयारी);038 - Sad - Sad - साद (साद);039 - Az-Zumar - The Groups_ The Troops - गुट (ट्रूप);040 - Ghafir - The Forgiver_ The Believer - क्षमा करनेवाला (विश्वासी);041 - Fussilat - Explained in Detail_ Expounded - विस्तार से समझाया गया (स्पष्ट);042 - Ash-Shura - The Consultation - मशवरा (मशवरा);043 - Az-Zukhruf - The Gold Adornments_ The Ornaments of Gold - सोने की आभूषण (सोने के आभूषण);044 - Ad-Dukhan - The Smoke - धुआँ (धुआँ);045 - Al-Jathiya - The Crouching_ The Kneeling - चुपा हुआ (नीचे झुका हुआ);046 - Al-Ahqaf - The Sand Dunes_ The Wind-Curved Sand-Hills - बालू की डून (हवा से मोड़ी हुई बालू की पहाड़ियाँ);047 - Muhammad - Muhammad - मुहम्मद (मुहम्मद);048 - Al-Fath - The Victory - जीत (जीत);049 - Al-Hujurat - The Rooms_ The Chambers - कमरे (कमरे);050 - Qaf - Qaf - क़ाफ़ (क़ाफ़);051 - Adh-Dhariyat - The Winnowing Winds_ The Scatterers - हवाओं को बाटने वाला हवा (विस्तारक);052 - At-Tur - The Mount - पहाड़ (पहाड़);053 - An-Najm - The Star - तारा (तारा);054 - Al-Qamar - The Moon - चाँद (चाँद);055 - Ar-Rahman - The Most Gracious_ The Beneficent - सर्वोत्तम करुणामय (लाभकारी);056 - Al-Waqi'a - The Inevitable_ The Event - वाकई (वाकई);057 - Al-Hadid - The Iron - लोहा (लोहा);058 - Al-Mujadila - The Pleading Woman_ She Who Disputes - मुज़ादा करने वाली औरत (वह महिला जो विवाद करती है);059 - Al-Hashr - The Exile_ The Banishment - बेहद (निर्वास);060 - Al-Mumtahina - She Who Is Tested_ The Examined One - जिसका परीक्षण किया गया है (परीक्षित वस्त्र);061 - As-Saff - The Ranks_ The Battle Array - पंक्तियाँ (सेना की तैयारी);062 - Al-Jumua - Friday_ The Day of Congregation - शुक्रवार (संगठन का दिन);063 - Al-Munafiqoon - The Hypocrites - मुनाफ़िकों (मुनाफ़िक);064 - At-Taghabun - The Mutual Disillusion_ The Cheating - आपस में धोखा (धोखा);065 - At-Talaq - The Divorce - तलाक (तलाक);066 - At-Tahrim - The Prohibition_ Banning - प्रतिबंध (मनाही);067 - Al-Mulk - The Sovereignty_ The Kingdom - राज्य (राज्य);068 - Al-Qalam - The Pen - कलम (कलम);069 - Al-Haaqqa - The Reality_ The Inevitable - सच्चाई (वास्तविकता);070 - Al-Maarij - The Ascending Stairways_ The Ladders - उत्तर चढ़ने के सीढ़ीयाँ (सीढ़ियाँ);071 - Nooh - Noah - नूह (नूह);072 - Al-Jinn - The Jinn - जिन्न (जिन्न);073 - Al-Muzzammil - The Enshrouded One_ The Enfolded - मुफ़ल्लिल (ढ़ाका हुआ व्यक्ति);074 - Al-Muddaththir - The Cloaked One_ The Man Wearing a Cloak - मुद्धत्थिर (एक चादर पहने हुए आदमी);075 - Al-Qiyama - The Resurrection - क़यामत (क़यामत);076 - Al-Insan - Man_ Human - इंसान (मनुष्य);077 - Al-Mursalat - The Emissaries_ Winds Sent Forth - रसूलों (पवन);078 - An-Naba - The Tidings_ The Announcement - खबर (सूचना);079 - An-Naziat - Those Who Drag Forth_ Soul-snatchers - उन लोगों (उनको बाहर खींचनेवाले);080 - Abasa - He Frowned - उसने आँखें फाड़ीं (उसने आँखें फाड़ीं);081 - At-Takwir - The Overthrowing_ The Eclipse - ध्वस्त (सूर्यग्रहण);082 - Al-Infitar - The Cleaving Asunder_ The Splitting Open - टूट जाना (विघटन);083 - Al-Mutaffifin - The Defrauding_ The Cheats - धोखा देने वाले (ठग);084 - Al-Inshiqaq - The Splitting Open_ The Splitting Open - फट जाना (फट जाना);085 - Al-Burooj - The Mansions of the Stars_ The Constellations - तारों के महल (सितारे);086 - At-Tariq - The Morning Star_ The Nightcomer - सुबह का तारा (रात का आनेवाला);087 - Al-Ala - The Most High_ The All-High - सर्वोच्च (सर्वोच्च);088 - Al-Ghashiya - The Overwhelming Event_ The Pall - गढ़बड़ (बारिश);089 - Al-Fajr - The Dawn_ The Daybreak - भोर (भोर);090 - Al-Balad - The City_ This Countryside - शहर (गाँव);091 - Ash-Shams - The Sun - सूरज (सूरज);092 - Al-Lail - The Night - रात (रात);093 - Ad-Dhuha - The Morning Hours_ Morning Bright - सुबह का समय (सुबह);094 - Al-Inshirah - The Relief_ The Opening Forth - राहत (उल्लास);095 - At-Tin - The Fig - अंजीर (अंजीर);096 - Al-Alaq - The Clot_ The Clinging Clot - लिहाज (जमा हुआ खून);097 - Al-Qadr - The Night of Decree_ Power - ताक़द (ताक़द);098 - Al-Bayyina - The Clear Proof_ Evidence - साफ साबित (साबित);099 - Az-Zalzala - The Earthquake - भूकंप (भूकंप);100 - Al-Adiyat - The Courser_ The Chargers - तारद (चालू);101 - Al-Qaria - The Calamity_ The Stunning Blow - मुश्किल (आघात);102 - At-Takathur - The Rivalry in World Increase_ Competition - धन की भागीदारी (प्रतिस्पर्धा);103 - Al-Asr - The Declining Day_ The Epoch - वक़्त (अध्याय);104 - Al-Humaza - The Traducer_ The Gossipmonger - बदनाम (बाजार);105 - Al-Fil - The Elephant - हाथी (हाथी);106 - Quraish - Quraish - कुरैश (कुरैश);107 - Al-Maun - The Small Kindnesses_ Almsgiving_ Have You Seen? - नेक़ी (नेक़ई);108 - Al-Kauther - Abundance_ Plenty - प्रचुरता (अधिकता);109 - Al-Kafiroon - The Disbelievers_ The Kafirs - नास्तिकों (काफ़िरों);110 - An-Nasr - The Divine Support_ Victory - विजय (सहारा);111 - Al-Masadd - The Palm Fiber_ The Flame - खल (आग);112 - Al-Ikhlas - The Sincerity - ईमान (ईमान);113 - Al-Falaq - The Daybreak_ The Dawn - सवेरा (अब्वाब);114 - An-Nas - The Mankind - मनुष्यता (मनुष्य)"
				.replace("?", "");

		Map<String, String> nameMap = new HashMap<String, String>();

		for (String str : nameAfter.split(";")) {
			nameMap.put(str.substring(0, 3), str.substring(6));
		}

		List<String> downloadedFileList = Arrays.asList(new File(dlFolder).list());

		for (String dlFileName : downloadedFileList) {
			System.out.println("dlFileName: " + dlFileName);
			System.out.println("Length: " + dlFileName.split("[.]").length);

			String headerFileName = dlFileName.split("[.]")[0];

			String dlFileReName = headerFileName + " - " + nameMap.get(headerFileName) + ".mp3";

			File file = new File(dlFolder + dlFileName);

			File newFile = new File(dataFolder + dlFileReName);

			if (newFile.exists()) {
				System.out.println("File already present, rename skipped! " + newFile.getName());
			} else
				FileUtils.moveFile(file, newFile);

			System.out.println("File renamed successfully? " + newFile.exists());
		}
	}

	public static void fileDownloadManager(int startNum, int endNum) throws IOException, URISyntaxException {
		for (int i = startNum; i <= endNum; i++) {
			String tempURL = "00" + i;
			String substring = tempURL.substring(tempURL.length() - 3);
			String FILE_NAME = "Quran_Urdu_Audio_dl/" + substring + ".mp3";

			File fileCheckForNew = new File(FILE_NAME);

			boolean isFileNew = !fileCheckForNew.exists();

			String FILE_URL = baseURL + substring + ".mp3";
			URL ip = new URL(FILE_URL);
			long fileSize = ip.openConnection().getContentLength();
			System.out.println("******************** File: '"
					+ ip.getFile().split("/")[ip.getFile().split("/").length - 1] + "' Size: " + getUnit(fileSize)
					+ ", Total size: " + getUnit(totalSize) + ", File name: " + FILE_NAME + " ********************");

			fileSizeFetcher(FILE_URL, FILE_NAME);

			// Now download files in order of their size, ascending
			String fileURL = baseURL + FILE_NAME.split("/")[FILE_NAME.split("/").length - 1];
			fileDownloader(fileURL, FILE_NAME, isFileNew);
		}

	}

	public static void fileDownloader(String FILE_URL, String folderFILE_NAME, boolean isFileNew)
			throws IOException, URISyntaxException {
		if (isFileNew) {
			System.out.println("File doesn't exist, downloading... '" + folderFILE_NAME + "'");
			long totalBytesRead = 0;
			URL ip = new URL(FILE_URL);
			long fileSize = ip.openConnection().getContentLength();
			totalSize = totalSize + fileSize;
			fileDatum.put(fileSize, ip.toURI().toString());
			String FILE_NAME = folderFILE_NAME.split("/")[1];
			String folderFILE_NAMESagregated = folderFILE_NAME.split("/")[0] + "/" + getFolderSagregated() + FILE_NAME;

			try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
					FileOutputStream fileOutputStream = new FileOutputStream(folderFILE_NAME);
					FileOutputStream fileOutputStreamSagregated = new FileOutputStream(folderFILE_NAMESagregated)) {
				byte[] dataBuffer = new byte[1024];
				int bytesRead;
				double tempInt = 0;
				System.out.println("Download started for file: " + FILE_NAME + ", size: " + getUnit(fileSize));

				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					double fileDlProgress;
					totalBytesRead = (totalBytesRead + bytesRead);
					fileDlProgress = (double) ((totalBytesRead * 100) / fileSize);

					if ((tempInt != fileDlProgress) && fileDlProgress % dlProgressDivisor == 0) {
						System.out.println("Download progress for file: - '" + FILE_NAME + "' - "
								+ String.format("%.0f", fileDlProgress) + "%" + " - "
								+ (getUnit(totalBytesRead).replaceAll(" ", "") + " / "
										+ getUnit(fileSize).replaceAll(" ", "")));
						tempInt = (int) fileDlProgress;
					}
					if (fileSize == totalBytesRead) {
						System.out.println("Downloaded successfully - '" + FILE_NAME + "', file size: "
								+ getUnit(fileSize) + "\n");
					}
//					fileOutputStream.write(dataBuffer, 0, bytesRead);
					fileOutputStreamSagregated.write(dataBuffer, 0, bytesRead);
				}
				fileOutputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("File exists, download SKIPPED for " + folderFILE_NAME);

	}

	public static String getFolderSagregated() {
		String sagrFolder = "";
		long tempSize = totalSize;
		if (tempSize > 0) {
			sagrFolder = "VerySmall/";
			tempSize = tempSize / 1024;
		}
		if (tempSize > 0) {
			sagrFolder = "Small/";
			tempSize = tempSize / 1024;
		}
		if (tempSize >= 1) {
			sagrFolder = "Medium/";
		}
		if (tempSize > 20) {
			sagrFolder = "Large/";
		}
		if (tempSize > 34) {
			sagrFolder = "Huge/";
		}
		return sagrFolder;
	}

	public static void fileSizeFetcher(String FILE_URL, String FILE_NAME) throws IOException, URISyntaxException {
		URL ip = new URL(FILE_URL);
		long fileSize = ip.openConnection().getContentLength();
		fileDatumCheck.put(fileSize, ip.toURI().toString());

		try (BufferedInputStream in = new BufferedInputStream(null);
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
			fileOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getUnit(long fileSize) {

		String unit = "";

		if (fileSize > 1024) {
			fileSize = fileSize / 1024;
			unit = String.valueOf(fileSize) + " KB";
		}
		if (fileSize > 1024) {
			fileSize = fileSize / 1024;
			unit = String.valueOf(fileSize) + " MB";
		}
		if (fileSize > 1024) {
			fileSize = fileSize / 1024;
			unit = String.valueOf(fileSize) + " GB";
		}

		return unit;
	}
}
