package deloitte.com.merger;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@RestController
public class UnzipAPI {

	/*
	 * This method contains Merging/Adding elements to destination xml.
	 * 
	 * */
	@PostMapping("/unzip")

	public static String unzipFiles(@RequestBody String compareContent) {
		String readReturn = "";
		readReturn = unzip(compareContent, "test");
		return readReturn;

	}

	private static String unzip(String base64String, String destDir) throws IOException {
		String test = "";
    	byte[] buffer = new byte[2048];
    	byte[] base64decodedBytes = Base64.getDecoder().decode(base64String);
    	ByteArrayInputStream is = new ByteArrayInputStream(base64decodedBytes);
    	ZipInputStream zis = new ZipInputStream(is);
    	ZipEntry entry;
    	FileSystem fileSystem = FileSystems.getDefault();
    	while ((entry = zis.getNextEntry()) != null) {
    		//Path uncompressedFilePath = fileSystem.getPath(entry.getName());
    		if (entry.isDirectory()) 
            {
                test += entry.getName() + "\n";
				//Files.createDirectories(fileSystem.getPath(destDir + entry.getName()));
            } else {
            	/*String uncompressedFileName = destDir + entry.getName();
            	Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                try (FileOutputStream fos = new FileOutputStream(uncompressedFilePath.toFile());
                        BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {

                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                } */        	
            }
        }
		return test;       
    }
}

