package fr.loria.score.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 24 March 2010
 */
@Entity
@NamedQueries( value={
		@NamedQuery(name="findAllNames", query="SELECT n FROM Name n"),
		@NamedQuery(name="findNameByMetadata", query="SELECT n FROM Name n WHERE :metadata IN (SELECT m FROM n.metadata m)")
})
public class Name implements Serializable {

	private Long id;
	private String name;
	private List<String> metadata; 
	
	public Name() {
		metadata = new Vector<String>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		id = long1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ElementCollection  
	@CollectionTable(name = "name_metadata")  
	@Column(name = "value")  
	public List<String> getMetadata() {
		 return metadata;
	}
	
	public void setMetadata(List<String> metadata) {
		this.metadata = metadata;
	}
	
	public void addMetadata(String metadata) {
		this.metadata.add(metadata);
	}
	
}
