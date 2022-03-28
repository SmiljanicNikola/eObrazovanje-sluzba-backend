package ftn.uns.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_date")
public class ExamDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_date_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "date", unique = false, nullable = false)
	private LocalDate date;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
    @ManyToOne
    @JoinColumn(name="taking_exam_id", nullable=false)
    private TakingExam taking_exam;
}
