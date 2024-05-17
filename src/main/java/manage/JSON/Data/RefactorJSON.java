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

public class RefactorJSON {

	public static void main(String[] args) throws IOException {

		try {
			List<ClipboardRecord> clipRecords = ReadJsonFile();
			System.out.println("clipRecords: " + clipRecords.size());

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

//		List<ClipboardRecord> jsonDataList = objectMapper1.readValue(
//				new File("Data/Clipboard/test/history-05_13_24-12-15-08.json"),
//				objectMapper1.getTypeFactory().constructCollectionType(List.class, ClipboardRecord.class));
//
//		jsonDataList.forEach(data -> System.out.println(data.getContact().getName()));
//
//		for (ClipboardRecord cb : jsonDataList) {
//			System.out.println(cb.getText());
//			System.out.println(cb.getDateAdded());
//			System.out.println(cb.getLength());
//			System.out.println(cb.getContact().getName());
//			System.out.println(cb.getContact().getPhone());
//		}

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
//						System.out.println("Time added:\n" + clipRecordsTimeAdded);
					} else {
						System.out.println(
								"Duplicate record skipped: " + curRecord.getDateAdded() + " file: " + file.getPath());
					}

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
