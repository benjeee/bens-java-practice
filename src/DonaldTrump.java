import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DonaldTrump {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		double total = 0;
		int lines = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("resources/scan.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       int i = line.indexOf('$');
		       if(i!=-1){
		    	   lines++;
		    	   String z = line.substring(i+1);
		    	   int j = z.indexOf(' ');
		    	   if(j>=0){
		    		   total += Double.parseDouble(removeCommas(line.substring(i+1,i+j+1)));
		    	   }
		    	   else{
		    		   total += Double.parseDouble(removeCommas(z));

		    	   }
		       }
		    }
		}
		   System.out.println(total);
		   System.out.println(lines);
	}
	public static String removeCommas(String s){
		String finalStr = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != ',') finalStr+=s.charAt(i);
		}
		return finalStr;
	}
}
