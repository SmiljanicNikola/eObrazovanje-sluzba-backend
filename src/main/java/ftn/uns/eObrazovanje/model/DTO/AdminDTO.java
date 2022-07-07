package ftn.uns.eObrazovanje.model.DTO;

public class AdminDTO {
	private Integer id;
	private String username;
	private String name;
	private String surname;
	private String password;
	private String jmbg;
	private String address;
	public AdminDTO() {
		super();
	}
	public AdminDTO(String username, String firstname, String lastname, String password, String jmbg, String adress) {
		super();
		this.username = username;
		this.name = firstname;
		this.surname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.address = adress;
	}
	public AdminDTO(Integer id, String username, String firstname, String lastname, String password,
			String jmbg, String adress) {
		super();
		this.id = id;
		this.username = username;
		this.name = firstname;
		this.surname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.address = adress;
	}
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	
}
