package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class NodoF2B {

	private String text;
	private Long id;
	private Boolean checked;
	private Boolean expanded;
	private Boolean leaf;
	private List<NodoF2B> children;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public List<NodoF2B> getChildren() {
		return children;
	}

	public void setChildren(List<NodoF2B> children) {
		this.children = children;
	}

}
