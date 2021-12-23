package TestingAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RestAPITesting {
	
	
	public static void get() throws IOException {
		 URL url = new URL("https://reqres.in/api/users?page=2");
		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
		  con.setRequestMethod("GET");
		  int responseCode = con.getResponseCode();
		  System.out.println("GET Response Code " + responseCode);
		  if (responseCode == HttpURLConnection.HTTP_OK) { 
			  BufferedReader in = new BufferedReader
					  (new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println(response.toString());
			} else {
				System.out.println("GET request not worked");
			}

	}
	
	public static final String POST_PARAMS = "name=morpheus&job=leader";
	public static void POST() throws IOException {
		
		URL obj = new URL("https://reqres.in/api/users");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes(StandardCharsets.UTF_8));
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}


	
	
	public static void main(String[] args) throws IOException {
	
		get();
		POST();
	
	}

}



