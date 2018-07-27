import java.io.*;
import java.util.*;
import java.lang.Math.*;

// Solution to http://codekata.com/kata/kata04-data-munging/

class TemperatureSpread {

	public String[] readFile(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		String  line;
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
		
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return lines.toArray(new String[lines.size()]);
	}
	
	public boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException n) {
			return false;
		}
		return true;
	}
	
	double findSpread(String[] colValues, int highCol, int lowCol) {
		double d;
		try {
			d = Double.parseDouble(colValues[highCol]) - Double.parseDouble(colValues[lowCol]);
		} catch (NumberFormatException n) {
			return Double.MAX_VALUE;
		}
		return Math.abs(d);
		
	}
	
	public String processLines(String[] lines, int resultCol, int highCol, int lowCol) {
		double min = Double.MAX_VALUE; 
		String result = "-1";
		for (String line: lines) {
			String[] lineParts = line.trim().split("\\s+");
			if(lineParts.length > lowCol && isNumeric(lineParts[highCol]) && isNumeric(lineParts[lowCol])) {
				double spread = findSpread(lineParts, highCol, lowCol);
			 	if (spread < min)  {
			 		min = spread;
			 		result = lineParts[resultCol];
			 	}
			}
		}
		return result; 
	}
	
	public static void main(String[] args) {
		TemperatureSpread TSpread = new TemperatureSpread();
		//String[] lines = TSpread.readFile("weather.dat");
		//System.out.printf("%s\n", TSpread.processLines(lines, 0, 1, 2));
		String[] lines = TSpread.readFile("football.dat");
		System.out.printf("%s\n", TSpread.processLines(lines, 1, 6, 8));
	}
}