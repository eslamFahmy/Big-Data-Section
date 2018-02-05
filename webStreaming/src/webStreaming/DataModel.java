package webStreaming;

public class DataModel {

	private String title;
	private String data;

	public DataModel() {

		title = null;
		data = null;
	}

	public void setTitle(String title) {
		this.title = title;

	}

	public void setData(String data) {
		this.data = data;

	}

	public String getTitle() {
		if (title == null)
			return "";
		return title;

	}

	public String getData() {
		if (data == null)
			return "";
		return data;

	}
}
