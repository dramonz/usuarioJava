package mx.gob.tabasco.saf.siafe.presupuesto.controladores.menu;

import java.util.ArrayList;
import java.util.List;

public class BasicNode implements Node {

	private String text;
	private String href;
	private String hrefTarget;
	private boolean leaf;
	private boolean expanded;
	private List<Node> children;
	
	public BasicNode(String text, String href, String hrefTarget,
			boolean isLeaf, boolean isOpean) {
		this.setText(text);
		this.setHref(href);
		this.setHrefTarget(hrefTarget);
		this.setLeaf(isLeaf);
		this.setExpanded(isOpean);
	}
	
	public BasicNode(String text, boolean isLeaf, boolean isOpen) {
		this.setText(text);
		this.setLeaf(isLeaf);
		this.setExpanded(isOpen);
	}
	
	public BasicNode(String text, String href, String hrefTarget, boolean isLeaf) {
		this.setText(text);
		this.setHref(href);
		this.setHrefTarget(hrefTarget);
		this.setLeaf(isLeaf);
	}
	
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean getLeaf() {
		return this.leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getHrefTarget() {
		return this.hrefTarget;
	}

	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}

	public boolean getExpanded() {
		return this.expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public void addChild(Node child) {
		if (this.getChildren() == null) {
			this.children = new ArrayList<Node>();
		}
		
		this.children.add(child);
	}

	public List<Node> getChildren() {
		return this.children;
	}

}
