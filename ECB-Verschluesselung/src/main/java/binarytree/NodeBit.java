package binarytree;

public class NodeBit {

	private String buchstabe;
	private String bit;
	
	private NodeBit right;
	private NodeBit left;
	
	public NodeBit(String buchstabe, String bit) {
		
		this.buchstabe = buchstabe;
		this.bit = bit;
		this.setLeft(null);
		this.setRight(null);
		
	}

	public NodeBit getLeft() {
		return left;
	}

	public void setLeft(NodeBit left) {
		this.left = left;
	}

	public NodeBit getRight() {
		return right;
	}

	public void setRight(NodeBit right) {
		this.right = right;
	}

	public String getBit() {
		return bit;
	}

	public String getBuchstabe() {
		return buchstabe;
	}
}
