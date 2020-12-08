package main;

import ecbverschlüsselung.*;

public class Konsole {

	public static void main(String[] args) {

		ECBVerschlüsselung ecb = new ECBVerschlüsselung();
		
		ecb.encryption("TEST", 1);

	}

}
