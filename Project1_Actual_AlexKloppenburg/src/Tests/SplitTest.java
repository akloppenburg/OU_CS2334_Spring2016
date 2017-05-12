package Tests;

import java.util.ArrayList;

public class SplitTest {
	
	public static void main(String[] args){
	
		String data = "20120110,1,1375,2,\"Gingrich, Newt\",\"Adelson, Sheldon\"";
		
		
		String[] parts = data.split(",");
		
		int year = Integer.parseInt(parts[0].substring(0, 4));
		int month = Integer.parseInt(parts[0].substring(4, 6));
		int day = Integer.parseInt(parts[0].substring(6, 8));
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		/*for(int i = 0; i < parts.length; ++i){
			System.out.println(parts[i]);
		}*/
		
		String[] finalParts = new String[6];
		
		if(parts.length == 8){
			parts[4] = parts[4].substring(1, parts[4].length());
			parts[5] = parts[5].substring(0, parts[5].length() - 1);
			
			parts[6] = parts[6].substring(1, parts[6].length());
			parts[7] = parts[7].substring(0, parts[7].length() - 1);
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4] + "," + parts[5]; 
			finalParts[5] = parts[6] + "," + parts[7];
		}
		else if(parts.length == 7){
			parts[5] = parts[5].substring(1, parts[5].length());
			parts[6] = parts[6].substring(0, parts[6].length() - 1);
			
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4]; 
			finalParts[5] = parts[5] + "," + parts[6];
		}
		else{
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4]; 
			finalParts[5] = parts[5];
		}
		
		for(int i = 0; i < finalParts.length; ++i){
			System.out.println(finalParts[i]);
		}
	}
}
