package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_requrement")
public class TypeOfRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_of_requrement_id", unique = true, nullable = false)
	private Integer type_of_requrement_id;

	@Column(name = "name", nullable = false)
	private String name;

	public TypeOfRequirement(Integer type_of_requrement_id, String name) {
		super();
		this.type_of_requrement_id = type_of_requrement_id;
		this.name = name;
	}

	public Integer getType_of_requrement_id() {
		return type_of_requrement_id;
	}

	public void setType_of_requrement_id(Integer type_of_requrement_id) {
		this.type_of_requrement_id = type_of_requrement_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
