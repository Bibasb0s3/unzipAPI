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
import java.io.ByteArrayInputStream;
import java.io.File;
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

@RestController
public class UnzipAPI {

	/*
	 * This method contains Merging/Adding elements to destination xml.
	 * 
	 * */
	@PostMapping("/unzip")

	public static String unzipFiles(@RequestBody String compareContent) {
		try {
			String readReturn = "";
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
					readReturn += entry.getName() + "\n";
					//Files.createDirectories(fileSystem.getPath(destDir + entry.getName()));
				}
			} 
		} catch(IOException e)
        {
            
        }
		
		return readReturn;

	}
}

