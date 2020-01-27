package deloitte.com.merger;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UnzipAPI {

	/*
	 * This method contains Merging/Adding elements to destination xml.
	 * 
	 * */
	@PostMapping("/unzip")

	public static String unzipFiles(@RequestBody String compareContent) {
		String readReturn = "";
		/*Profile profileSource = new Profile();
		Profile profileDest= new Profile();
		final String seperator = new String("\\*SEPARATOR\\*");
		String[] compareContentStr;

		try { 

			if( !compareContent.isEmpty() && compareContent != null) {
				compareContentStr = compareContent.split(seperator);
				System.out.println("Length " + compareContentStr.length);

				if(compareContentStr.length >0) {

					if(compareContentStr[0] != null && !compareContentStr[0].isEmpty()) {

						ObjectMapper objectMapper = new XmlMapper();
						profileSource = objectMapper.readValue(compareContentStr[0], Profile.class);

					}
					if(compareContentStr[1] != null && !compareContentStr[1].isEmpty()) {

						ObjectMapper objectMapperDest = new XmlMapper();
						profileDest = objectMapperDest.readValue(compareContentStr[1].trim(), Profile.class);

					}
				}
				System.out.println("profileDest " + profileDest.toString());
				readReturn = compareTags(profileSource ,profileDest, true);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception when deseralization";
		}*/
		System.out.println("Return");
		return readReturn;

	}
}

