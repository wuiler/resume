
public class Award {
	private String title;
	private String awarder;
	private String date;
	private String summary;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAwarder() {
		return this.awarder;
	}

	public void setAwarder(String awarder) {
		this.awarder = awarder;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Awards {")
		.append("title='").append(title).append('\',')
		.append("awarder='").append(awarder).append('\',')
		.append("date='").append(date).append('\',')
		.append("summary='").append(summary).append('\'')
		.append('}');
	
		return sb.toString();
	}

}
