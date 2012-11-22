package mx.gob.tabasco.saf.siafe.presupuesto.controladores.menu;

import java.util.ArrayList;
import java.util.List;

public class BasicTree implements Tree {

	private List<Node> children;
	private boolean expanded;
	
	public BasicTree() {
		
	}
	
	public BasicTree(boolean expanded) {
		this.setExpanded(expanded);
	}
	
	public List<Node> getChildren() {
		return this.children;
	}

	public void addChildren(Node node) {
		if (this.getChildren() == null) {
			this.children = new ArrayList<Node>();
		}
		
		this.children.add(node);
	}

	public boolean getExpanded() {
		return this.expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

}
