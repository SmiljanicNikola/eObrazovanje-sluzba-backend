package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", unique = true, nullable = false)
	private Integer id;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "student_id", nullable = false)
    private Student studentId;

    @Column(name = "document_type_id", nullable = false)
    private DocumentType document_type_id;

	public Document(Integer id, String name, Student studentId, DocumentType document_type_id) {
		super();
		this.id = id;
		this.name = name;
		this.studentId = studentId;
		this.document_type_id = document_type_id;
	}

	public Document(String name, Student studentId, DocumentType document_type_id) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.document_type_id = document_type_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public DocumentType getDocument_type_id() {
		return document_type_id;
	}

	public void setDocument_type_id(DocumentType document_type_id) {
		this.document_type_id = document_type_id;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", studentId=" + studentId + ", document_type_id="
				+ document_type_id + "]";
	}
    
    

}
