import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeFileProcessor {
	
	private static Map<String, String> codeMap = new HashMap<String, String>();
	
	public static Map<String, String> readCodeFile(String filename) throws FileNotFoundException, IOException{
		
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String[] parts = null;
		codeMap.clear();
		String nextLine = br.readLine(); //Reads in first relevant line to start loop
		while (nextLine != null) {
			parts = nextLine.split(",");
			codeMap.put(parts[0], parts[1]);
			nextLine = br.readLine();
		}
		br.close();
		return codeMap;
	}

}
