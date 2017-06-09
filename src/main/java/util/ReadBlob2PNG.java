package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadBlob2PNG {
	
	final String ImagePath = "";
	
	String URL = "";
	
	public String readBlob2PNG(byte[] blob, String tag, int index) {
		URL = ImagePath+tag+index+".png";
		File file=new File(URL);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(blob,0,blob.length);

			fos.flush();

			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

		
		
		return URL;
		
	}
}
