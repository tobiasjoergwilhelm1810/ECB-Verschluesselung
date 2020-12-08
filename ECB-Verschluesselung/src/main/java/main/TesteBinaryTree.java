package main;

import binarytree.BinaryTreeStart;
import exception.NodeNotExistException;

public class TesteBinaryTree {

	private BinaryTreeStart bt;
	
	public TesteBinaryTree(BinaryTreeStart bts) {
		
		this.bt = bts;
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeStart bt = new BinaryTreeStart();
		TesteBinaryTree tbt = new TesteBinaryTree(bt);
		
		tbt.add();
		tbt.testSerchBit("A");
		
	}
	
	public void add() {
		
		System.out.println("\nBuchstabe\n");
		this.bt.addBuchstabe("F", "11001");
		this.bt.addBuchstabe("A", "01011");
		this.bt.addBuchstabe("B", "10111");
		this.bt.addBuchstabe("C", "11101");
		this.bt.addBuchstabe("D", "00000");
		this.bt.addBuchstabe("E", "10011");
		this.bt.addBuchstabe("A", "01011");
		this.bt.addBuchstabe("G", "00001");
		this.bt.addBuchstabe("H", "00010");
		this.bt.addBuchstabe("I", "00100");
		this.bt.addBuchstabe("J", "10000");
		
		System.out.println("\nBit\n");
		this.bt.addBit("F", "11001");
		this.bt.addBit("A", "01011");
		this.bt.addBit("B", "10111");
		this.bt.addBit("C", "11101");
		this.bt.addBit("D", "00000");
		this.bt.addBit("E", "10011");
		this.bt.addBit("A", "01011");
		this.bt.addBit("G", "00001");
		this.bt.addBit("H", "00010");
		this.bt.addBit("I", "00100");
		this.bt.addBit("J", "10000");
		
	}
	
	public void testSerchBit(String buchstabe) {
		
		try {
			System.out.println(buchstabe + " => " + this.bt.findStringBitFromBuchstabe(buchstabe));
			System.out.println("Teste");
		} catch (NodeNotExistException e) {
			// TODO Auto-generated catch block
			e.getErrorMessage();
		}
		
	}

}
