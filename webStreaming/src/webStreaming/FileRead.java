package webStreaming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.io.Writer;

public class FileRead {

	private String fileName = "web_Streaming.conf";
	private Config config = new Config();
	private BufferedReader br = null;
	private FileReader fr = null;

	public Config read() {

		Writer writer = null;

		try {

			File myFile = new File(fileName);
			if (!myFile.exists()) {

				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
				writer.write("SEARCHWORDS : write here");
				((BufferedWriter) writer).newLine();
				writer.write("OPTMIZATIONWORDS : write here");
				writer.close();
			}

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {

				String[] temp = sCurrentLine.split(":");

				if (temp[0].contains("SEARCHWORDS")) {

					config.setSearch(temp[1]);
				} else if (temp[0].contains("OPTMIZATIONWORDS")) {
					config.setSearchOPtmization(temp[1]);
				}

			}
			return config;

		} catch (IOException ex) {
			// report

		}
		return null;

	}

	public void writeData(String fileName, String Data) {

		String directoryName = "Data";

		fileName = fileName.hashCode() + "";

		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}

		File file = new File(directoryName + "/" + fileName);
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}