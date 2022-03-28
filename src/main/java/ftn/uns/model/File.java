package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "path", unique = false, nullable = false)
	private String path;
	
	@JoinColumn(name = "document_id", referencedColumnName = "document_id")
	private Document document;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public File(Integer id, String path, Document document) {
		super();
		this.id = id;
		this.path = path;
		this.document = document;
	}

	public File() {
		super();
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", path=" + path + "]";
	}
	
	
	
}
