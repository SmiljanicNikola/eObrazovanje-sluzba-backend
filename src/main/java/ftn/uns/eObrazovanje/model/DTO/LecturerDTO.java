package ftn.uns.eObrazovanje.model.DTO;

public class LecturerDTO {
	
	private Integer id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String jmbg;
	private String adress;
	private Integer pay;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public LecturerDTO(String username, String firstname, String lastname, String password, String jmbg, String adress,
			Integer pay) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.adress = adress;
		this.pay = pay;
	}
	public LecturerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "LecturerDTO [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", password=" + password + ", jmbg=" + jmbg + ", adress=" + adress + ", pay=" + pay + "]";
	}
	
	

}
