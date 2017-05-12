package Tests;
import java.time.LocalDate;

public class LocalDateTests {
	
	public static void main(String[] args){
		
		String testString = "20170229";
		int year = Integer.parseInt(testString.substring(0, 4));
		int month = Integer.parseInt(testString.substring(5, 6));
		int date = Integer.parseInt(testString.substring(7, 8));
		
	
		LocalDate test = LocalDate.of(year, month, date);
		
		System.out.println(test);
		
	}
}
