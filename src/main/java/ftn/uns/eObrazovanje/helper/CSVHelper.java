package ftn.uns.eObrazovanje.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.model.Role;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.StudentHistory;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.repository.AccountRepo;
import ftn.uns.eObrazovanje.repository.RoleMainRepo;
import ftn.uns.eObrazovanje.repository.StudentHistoryRepo;
import ftn.uns.eObrazovanje.repository.UserRepo;

@Service
public class CSVHelper {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleMainRepo roleRepo;
	
	@Autowired
	private AccountRepo accRepo;
	
	@Autowired
	private StudentHistoryRepo historyRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "username", "firstname", "lastname", "password", "jmbg", "adress", "indexNumber" };
  
  public static boolean hasCSVFormat(MultipartFile file) {
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }
  
  public List<Student> csvToStudents(InputStream is) {

	  
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    		
      CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
      List<Student> students = new ArrayList<Student>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      
		Account account = new Account((float) 0,false);
		
		accRepo.save(account);
		
		
		StudentHistory history = new StudentHistory(LocalDate.now(),1);
		
		historyRepo.save(history);
		
      for (CSVRecord csvRecord : csvRecords) {
    	  System.out.println("VBLA");
    	  System.out.println(encoder.encode(csvRecord.get("password")));
    	  Student student = new Student(
              csvRecord.get("username"),
              csvRecord.get("firstname"),
              csvRecord.get("lastname"),
              encoder.encode(csvRecord.get("password")),
              csvRecord.get("jmbg"),
              csvRecord.get("adress"),
              csvRecord.get("indexNumber"),
              account,
              history,
              false
          );
    	  students.add(student);
    	  
		  User user = new User(student.getFirstname(), student.getLastname(), student.getUsername(), student.getPassword(),student.getAdress(), student.getJmbg(),false);
		  Set<Role> role = new HashSet<>();
		  Role role1 = roleRepo.findByName("STUDENT");
		  role.add(role1);
		  user.setRoles(role);
		
		  userRepo.save(user);
      }
      
      return students;
      
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }
}
