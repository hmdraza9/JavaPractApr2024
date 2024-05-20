package manage.JSON.Data;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.pojo.ClipboardRecord;
import test.pojo.Contact;

public class CombineJSONs {

	public static int dupClips = 0;
	public static int totalClips = 0;

	public static void main(String[] args) throws IOException {

		try {
			List<ClipboardRecord> clipRecords = ReadJsonFile();
			System.out.println(
					"Total unique clip records: " + clipRecords.size() + " out of " + (totalClips) + " records");

			ObjectMapper objectMapper = new ObjectMapper();

			objectMapper.writeValue(new File("Data/Clipboard/JsonOutput/history-" + getTime() + ".json"), clipRecords);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<ClipboardRecord> ReadJsonFile() throws IOException {

		List<ClipboardRecord> clipRecords = new ArrayList<ClipboardRecord>();
		List<Long> clipRecordsTimeAdded = new ArrayList<Long>();

		ObjectMapper objectMapper1 = new ObjectMapper();

		File jsonReadFileDir = new File("Data/Clipboard");

		for (File file : jsonReadFileDir.listFiles()) {
			if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {

				System.out.println("Processing file: " + file.getAbsolutePath());
				List<ClipboardRecord> jsonDataList = objectMapper1.readValue(file,
						objectMapper1.getTypeFactory().constructCollectionType(List.class, ClipboardRecord.class));

				for (ClipboardRecord cb : jsonDataList) {

					String tempText = cb.getText();
					long tempdateAdded = cb.getDateAdded();
					String templength = cb.getLength();
					String Contact_name = null;
					String Contact_phone = null;
					if (cb.getContact() != null) {
						Contact_name = cb.getContact().getName();
						Contact_phone = cb.getContact().getPhone();
					}
					Contact contact = new Contact(Contact_name, Contact_phone);
					ClipboardRecord curRecord = new ClipboardRecord(tempText, tempdateAdded, templength, contact);
					if (!clipRecordsTimeAdded.contains(curRecord.getDateAdded())) {
						clipRecords.add(curRecord);
						clipRecordsTimeAdded.add(curRecord.getDateAdded());
						System.out.println(
								"Unique record added: " + curRecord.getDateAdded() + " file: " + file.getPath());
					} else {
						System.out.println(
								"Duplicate record skipped: " + curRecord.getDateAdded() + " file: " + file.getPath());
						dupClips++;
					}
					totalClips++;

				}
			}
		}

		return clipRecords;

	}

	public static String getTime() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yy-HH-mm-ss");
		return sdf.format(cal.getTime());
	}

}
