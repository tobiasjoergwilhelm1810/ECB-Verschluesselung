package binarytree;

import exception.NodeAllreadyExistException;
import exception.NodeNotExistException;

public class BinaryTreeStart {

	private NodeBit rootBit;
	private NodeBuchstabe rootBuchstabe;
	
	public void addBuchstabe(String buchstabe, String bit) {
		
		try {
			this.rootBuchstabe = this.addRecursiveBuchstabe(this.rootBuchstabe, buchstabe, bit);
		} catch (NodeAllreadyExistException e) {
			System.out.println(e.getErrorMessage());
		}
		
	}
	
	public void addBit(String buchstabe, String bit) {
		try {
			this.rootBit = this.addRecursiveBit(this.rootBit, buchstabe, bit);
		} catch (NodeAllreadyExistException e) {
			System.out.println(e.getErrorMessage());
		}
		
	}
	
	private NodeBuchstabe addRecursiveBuchstabe(NodeBuchstabe current, String buchstabe, String bit) throws NodeAllreadyExistException {
		
		if (current == null) {

			return new NodeBuchstabe(buchstabe, bit);
			
		}
		
		if(buchstabe.charAt(0) > (int)current.getBuchstabe().charAt(0)) {
			
			current.setLeft(this.addRecursiveBuchstabe(current.getLeft(), buchstabe, bit));
			
		} else if (buchstabe.charAt(0) < (int)current.getBuchstabe().charAt(0)){
			
			current.setRight(this.addRecursiveBuchstabe(current.getRight(), buchstabe, bit));
			
		} else if (buchstabe.charAt(0) == (int)current.getBuchstabe().charAt(0)) {
			
			throw new NodeAllreadyExistException(current.getBuchstabe(), current.getBit());
			
		}
		
		return current;
	}
	
	private NodeBit addRecursiveBit(NodeBit current, String buchstabe, String bit) throws NodeAllreadyExistException {
		
		if (current == null) {
			
			return new NodeBit(buchstabe, bit);
			
		}
		
		if(this.stringToInt(bit) > this.stringToInt(current.getBit())) {
			
			current.setLeft(this.addRecursiveBit(current.getLeft(), buchstabe, bit));
			
		} else if (this.stringToInt(bit) < this.stringToInt(current.getBit())){
			
			current.setRight(this.addRecursiveBit(current.getRight(), buchstabe, bit));
			
		} else if (this.stringToInt(bit) == this.stringToInt(current.getBit())) {
			
			throw new NodeAllreadyExistException(current.getBuchstabe(), current.getBit());
			
		}
		
		return current;
	}
	
	public String findStringBitFromBuchstabe(String buchstabe) throws NodeNotExistException {
		
		return this.findeBuchstabeReturnBit(this.rootBuchstabe, buchstabe);
		
	}
	
	private String findeBuchstabeReturnBit(NodeBuchstabe current, String buchstabe) throws NodeNotExistException {
		
		String bit = "";
		
		if(current.getBuchstabe().charAt(0) == buchstabe.charAt(0)) {
			
			bit = current.getBit();
			
		}
		
		if(current.getLeft()== null && current.getRight() == null) {
			
			throw new NodeNotExistException(buchstabe, true);
			
		}
		
		if(current.getBuchstabe().charAt(0) > buchstabe.charAt(0)) {
			
			bit = this.findeBuchstabeReturnBit(current.getLeft(), buchstabe);
			
		}
		
		if(current.getBuchstabe().charAt(0) < buchstabe.charAt(0)) {
			
			bit = this.findeBuchstabeReturnBit(current.getRight(), buchstabe);
			
		}
		
		return bit;
		
	}
	
	private int stringToInt(String bit) {
		return Integer.parseInt(bit);
	}
	
}
