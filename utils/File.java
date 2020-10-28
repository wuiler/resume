package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.io.BufferedReader;
import java.net.URL;
import java.io.InputStreamReader;;

public class File {

	public File() {		
	}

	public static String readAll(String fileName) {

		String content = null;
		try {

  		byte[] bytes = Files.readAllBytes(Paths.get(fileName));
      content = new String(bytes);


		} catch (IOException e) {
				System.err.format("IOException: %s%n", e);
		}

		return content;
		
	}

	public static String read(String fileName) throws IOException {

		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
				String line;
				while ((line = br.readLine()) != null) {
						sb.append(line).append("\n");
				}

		} catch (IOException e) {
				throw new IOException("IOException Occurred");
		}

		return sb.toString();

	}

	public static String readUrl(String url) throws IOException {

    StringBuilder response = new StringBuilder();
    String inputLine;

		try {
			URL loadUrl = new URL(url);

			InputStreamReader isr = new InputStreamReader(
			loadUrl.openStream(), StandardCharsets.UTF_8.toString());
			
			BufferedReader in = new BufferedReader(isr);

			while ((inputLine = in.readLine()) != null) 
				response.append(inputLine);

			in.close();

		} catch (IOException ioe) {
			throw new IOException("Exception occurred reading:" + url);
		}


    return response.toString();
	}

}