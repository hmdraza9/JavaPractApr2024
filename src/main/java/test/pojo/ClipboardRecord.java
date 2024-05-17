package test.pojo;

public class ClipboardRecord {

	private String text;
	private long dateAdded;
	private String length;
	private String dateLastCopied;
	private String sourceUrl;

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getDateLastCopied() {
		return dateLastCopied;
	}

	public void setDateLastCopied(String dateLastCopied) {
		this.dateLastCopied = dateLastCopied;
	}

	private Contact contact;

	public ClipboardRecord() {
	}

	public ClipboardRecord(String text, long tempdateAdded, String length, Contact contact) {
		this.text = text;
		this.dateAdded = tempdateAdded;
		this.length = length;
		this.contact = contact;
	}

	public String getText() {
		return text;
	}

	public long getDateAdded() {
		return dateAdded;
	}

	public String getLength() {
		return length;
	}

	public Contact getContact() {
		return contact;
	}

}
