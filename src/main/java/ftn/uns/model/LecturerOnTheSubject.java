package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturersOnTheSubject")
public class LecturerOnTheSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lecturerOnTheSubject_Id", unique = true, nullable = false)
	private Integer lecturerOnTheSubject_Id;

	@Column(name = "lecturer_id", unique = false, nullable = false)
	private Lecturer lecturer_id;

}
