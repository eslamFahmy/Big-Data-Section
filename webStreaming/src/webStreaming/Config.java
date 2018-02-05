package webStreaming;

public class Config {

	private String SEARCHWORDS;
	private String OPTMIZATIONWORDS;

	public String getSearch() {
		if (SEARCHWORDS != null)
			return SEARCHWORDS;

		return null;
	}

	public void setSearch(String search) {
		SEARCHWORDS = search;
	}

	public String getSearchOPtmization() {

		if (OPTMIZATIONWORDS != null)
			return OPTMIZATIONWORDS;

		return null;

	}

	public void setSearchOPtmization(String searchOPtmization) {
		OPTMIZATIONWORDS = searchOPtmization;
	}

}
