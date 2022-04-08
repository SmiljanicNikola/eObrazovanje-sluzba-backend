package ftn.uns.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id", unique=true, nullable = false)
	private Integer file_id;
	
	@Column(name = "path", unique = false, nullable = false)
	private String path;
	
	@OneToMany(cascade= {ALL}, mappedBy= "file")
    private List<Document> documents = new ArrayList<Document>();

	public Integer getId() {
		return file_id;
	}

	public void setId(Integer file_id) {
		this.file_id = file_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File(String path) {
		super();
		this.path = path;
	}

	public File(String path, List<Document> documents) {
		super();
		this.path = path;
		this.documents = documents;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public File() {
		super();
	}

	@Override
	public String toString() {
		return "File [id=" + file_id + ", path=" + path + "]";
	}
	
	
	
}
