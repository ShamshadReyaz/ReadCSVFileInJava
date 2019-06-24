import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private static final String NEW_LINE_SEPARATOR = "\n";
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			readCSVFile();
			
			Friends friends2=new Friends("Shahshank", "673657365", "Ashok Nagar", "6");
			Friends friends3=new Friends("Vikas", "9876543210", "Bhaiya Bhabhi ke ghr", "7");
			Friends friends4=new Friends("Rounit", "673657365", "USA", "8");
			Friends friends5=new Friends("Namdev", "673657365", "Ashok Nagar", "9");
			Friends friends6=new Friends("Shabab", "673657365", "Okhla", "10");
			
			List<Friends> friends=new ArrayList<>();
			friends.add(friends2);friends.add(friends3);friends.add(friends4);friends.add(friends5);friends.add(friends6);
		
			writeToCSV(friends);
			
			readCSVFile();
	}
	
	
	private static void readCSVFile() {
		// TODO Auto-generated method stub
		
		Path pathFile =Paths.get("C:\\Users\\landshark\\Desktop\\friend.csv");
		
		try(BufferedReader br=Files.newBufferedReader(pathFile,StandardCharsets.US_ASCII))
		{
			List<Friends> friend=new ArrayList<>();
			String line =br.readLine();
			while (line!=null) {
				
				String[] data=line.split(",");
				Friends fri=new Friends(data[1], data[2], data[3], data[0]);
				friend.add(fri);
				line=br.readLine();
			}
			for(Friends f:friend)
			{
				System.out.println(f.getId()+" "+f.getName()+" "+f.getMobile()+" "+f.getAddress());
			}
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
	}


	private static void writeToCSV(List<Friends> friends)
	{
		FileWriter fileWriter=null;
		try {
			// true is used for existing file. For new file, don use true
			fileWriter=new FileWriter("C:\\Users\\landshark\\Desktop\\friend.csv",true);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for(Friends f:friends)
			{
				fileWriter.append(String.valueOf(f.getId()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(f.getName()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(f.getMobile()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(f.getAddress()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			fileWriter.flush();
			fileWriter.close();
			System.out.println("New Data Written To CSV File");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
