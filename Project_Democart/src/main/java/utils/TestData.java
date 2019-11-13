package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
	public Properties property = new Properties();
	File file = new File("testData.properties");
	
	public TestData() throws IOException {
		FileInputStream file2 = new FileInputStream(file);
		property.load(file2);
		file2.close();
	}

}
