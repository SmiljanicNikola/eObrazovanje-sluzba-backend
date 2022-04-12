package ftn.uns.eObrazovanje.model.DTO;

public class AdminDTO {
	private Integer student_id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String jmbg;
	private String adress;
	private String indexNumber;
	public AdminDTO() {
		super();
	}
	public AdminDTO(String username, String firstname, String lastname, String password, String jmbg, String adress,
			String indexNumber) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.adress = adress;
		this.indexNumber = indexNumber;
	}
	public AdminDTO(Integer student_id, String username, String firstname, String lastname, String password,
			String jmbg, String adress, String indexNumber) {
		super();
		this.student_id = student_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.adress = adress;
		this.indexNumber = indexNumber;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIndexNumber() {
		return indexNumber;
	}
	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
	
	
}
