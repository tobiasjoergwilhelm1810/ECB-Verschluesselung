package binarytree;

public class NodeBuchstabe {

	private String buchstabe;
	private String bit;
	
	private NodeBuchstabe right;
	private NodeBuchstabe left;
	
	public NodeBuchstabe(String buchstabe, String bit) {
		
		this.buchstabe = buchstabe;
		this.bit = bit;
		this.setLeft(null);
		this.setRight(null);
		
	}

	public NodeBuchstabe getLeft() {
		return left;
	}

	public void setLeft(NodeBuchstabe left) {
		this.left = left;
	}

	public NodeBuchstabe getRight() {
		return right;
	}

	public void setRight(NodeBuchstabe right) {
		this.right = right;
	}

	public String getBit() {
		return bit;
	}

	public String getBuchstabe() {
		return buchstabe;
	}
}
