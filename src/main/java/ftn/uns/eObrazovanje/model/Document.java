package ftn.uns.eObrazovanje.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id", unique = true, nullable = false)
	private Integer id;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
	private DocumentType documentType;

	@Column(name = "blocked", unique = false, nullable = false)
	private boolean blocked;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id", referencedColumnName = "file_id")
	private File file;

	public Document(String name, Student student, DocumentType documentType, File file, Boolean blocked) {
		super();
		this.name = name;
		this.student = student;
		this.documentType = documentType;
		this.file = file;
		this.blocked = blocked;
	}

	public Document() {
		super();
	}

	public Document(Integer id, String name, Student student, DocumentType documentType, File file, Boolean blocked) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
		this.documentType = documentType;
		this.file = file;
		this.blocked = blocked;
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

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", student=" + student + ", documentType=" + documentType
				+ ", file=" + file + "]";
	}

}
