package webStreaming;

import retrofit.Config;
import retrofit.api;

public class Main {

	public static void main(String[] args) {

		try {

			FileRead fileRead = new FileRead();

			webStreaming.Config config = fileRead.read();

			api api = new api();
			Config.search = config.getSearch();
			Config.setOptmizationSearch(config.getSearchOPtmization());
			api.Search();

			System.out.println("Done ");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Occured" + e);
		}

	}
}
