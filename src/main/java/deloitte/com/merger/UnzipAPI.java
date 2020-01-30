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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.zip.ZipInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UnzipAPI {

	/*
	 * This method contains Merging/Adding elements to destination xml.
	 * 
	 * */
	@PostMapping("/unzip")

	public List<ReturnData> unzipFiles(@RequestBody String compareContent) {
		ArrayList<ReturnData> readReturn = new ArrayList<ReturnData>();;
		try {			
			byte[] buffer = new byte[2048];
			byte[] base64decodedBytes = Base64.getDecoder().decode(compareContent);
			ByteArrayInputStream is = new ByteArrayInputStream(base64decodedBytes);
			ZipInputStream zis = new ZipInputStream(is);
			ZipEntry entry;
			FileSystem fileSystem = FileSystems.getDefault();
			while ((entry = zis.getNextEntry()) != null) {
				//Path uncompressedFilePath = fileSystem.getPath(entry.getName());
				if (entry.isDirectory()) 
				{
					//readReturn += entry.getName() + "\n";
					//Files.createDirectories(fileSystem.getPath(destDir + entry.getName()));
				} else {					
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					try (BufferedOutputStream bos = new BufferedOutputStream(outStream, buffer.length)) {
						int len;
						while ((len = zis.read(buffer)) > 0) {
							bos.write(buffer, 0, len);
						}	
					}
					String fileName = entry.getName();            	
            		fileName = test1.substring(test1.lastIndexOf(File.separator)+1,test1.length() );
					//readReturn.add(Base64.getEncoder().encodeToString(outStream.toByteArray())) ;
					ReturnData data = new ReturnData(fileName, Base64.getEncoder().encodeToString(outStream.toByteArray()));
					readReturn.add(data);
				}
			} 
		} catch(IOException e)
        {
            
        }		
		return readReturn;
	}

}

