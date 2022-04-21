package ftn.uns.eObrazovanje.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;



public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String [] HEADERs = {"name", "surname", "username", "password", "address", "jmbg"};
			
	 public static boolean hasCSVFormat(MultipartFile file) {
		    if (TYPE.equals(file.getContentType())
		    		|| file.getContentType().equals("application/vnd.ms-excel")) {
		      return true;
		    }
	
		    return false;
		  }
	 
	public static List<User> csvToUsers(InputStream is) throws Exception{
		try(BufferedReader fileReader = new BufferedReader (new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, 
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
			List<User> userList = new ArrayList<>();
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for(CSVRecord csvRecord : csvRecords) {
				User user = new User(
					csvRecord.get("name"),
					csvRecord.get("surname"),
					csvRecord.get("username"),
					csvRecord.get("password"),
					csvRecord.get("address"),
					csvRecord.get("jmbg")
						);
				userList.add(user);
			}
			return userList;
		}catch(IOException e) {
			throw new Exception("fail to parse CSV file: " + e.getMessage());
		}		
	}
	
	public static ByteArrayInputStream usersToCSV(List<User> userList) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (User user : userList) {
	        List<String> data = Arrays.asList(
	        	  String.valueOf(user.getName()),
	        	  String.valueOf(user.getSurname()),
	              String.valueOf(user.getUsername()),
	              String.valueOf(user.getPassword()),
	              String.valueOf(user.getAddress()),
	              String.valueOf(user.getJmbg())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
	

}
