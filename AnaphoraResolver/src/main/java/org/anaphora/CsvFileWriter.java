package org.anaphora;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {

	private static final String NEW_LINE_SEPARATOR = "\n";

	/*// CSV file header
	private static final String FILE_HEADER = "Sno,url,Sentence,Sentence Present in post/title,Entity-reference pair";*/

	public static void writeCsvFile(List<String> results) {
		if(results.isEmpty()) {
			System.out.println("No Coreferences found... Returning");
			return;
		}
		String filePath = AnaphoraResolverMain.properties.getProperty("filePath");
		String fileHeader = AnaphoraResolverMain.properties.getProperty("fileHeader");
		
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(filePath);

			// Write the CSV file header
			fileWriter.append(fileHeader.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (String result : results) {
				fileWriter.append(result);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
	}
}
