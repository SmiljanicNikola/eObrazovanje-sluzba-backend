package ftn.uns.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pre_examination_obligation")
public class PreExaminationObligations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pre_examination_obligation_id", unique = true, nullable = false)
	private Integer pre_examination_obligation_id;

	@Column(name = "subject_id", nullable = false)
	private Subject subject_id;

	@Column(name = "mandatory", nullable = false)
	private Boolean mandatory;

	@Column(name = "points", nullable = false)
	private Float points;

    @OneToMany(mappedBy="pre_examination_oblications")
    private List<TypeOfRequirement> typeOfRequirements;
	
	@Column(name = "attending_courses_id", nullable = false)
	private AttendingCourses attending_courses_id;


	

}
