package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_requirement")
public class TypeOfRequirement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_of_requirement_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;
	
    /*@ManyToOne
    @JoinColumn(name="pre_examination_obligations_id", referencedColumnName = "pre_examination_obligation_id")
    private PreExaminationObligations preExaminationObligations;*/
	
	@OneToMany(mappedBy="typeOfRequirement")
    private List<PreExaminationObligations> typeOfRequirements = new ArrayList<PreExaminationObligations>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<PreExaminationObligations> getTypeOfRequirements() {
		return typeOfRequirements;
	}

	public void setTypeOfRequirements(List<PreExaminationObligations> typeOfRequirements) {
		this.typeOfRequirements = typeOfRequirements;
	}

	public TypeOfRequirement(Integer id, String name, List<PreExaminationObligations> typeOfRequirements) {
		super();
		this.id = id;
		this.name = name;
		this.typeOfRequirements = typeOfRequirements;
	}

	public TypeOfRequirement(String name, List<PreExaminationObligations> typeOfRequirements) {
		super();
		this.name = name;
		this.typeOfRequirements = typeOfRequirements;
	}

	public TypeOfRequirement() {
		super();
	}

	@Override
	public String toString() {
		return "TypeOfRequirement [id=" + id + ", name=" + name + ", typeOfRequirements=" + typeOfRequirements + "]";
	}
	
}
