package ecbverschluesselung;

import java.util.Scanner;

import exception.ProgrammInterruptException;
import interfaces.ECBVerschluesselungInterface;

public class ECBVerschluesselung implements ECBVerschluesselungInterface {

	private VorgabenVonHerrnGast vorgaben;
	
	/**
	 * Dies ist der Start, welcher uns von Herrn Gast übergeben wurde!
	 * @param args
	 */
	public String startECBVerschluesselung() {
		
		String content = "";
		
		System.out.println("Willkommen bei PlanetExpress!");
        System.out.println("Welchen Modus mÃ¶chten Sie nutzen?");
        System.out.println("1) VerschlÃ¼sselung einer Nachricht");
        System.out.println("2) EntschlÃ¼sselung einer Nachricht");
        
        Scanner sc = new Scanner(System.in); // anlegen von einem Scanner Objekt
        int userInput = sc.nextInt(); // Einlesen der Auswahl
        	
        // Verschluesselung einer Nachricht
        if (userInput == 1) {
            System.out.println("Geben Sie den zu verschlÃ¼sselnden Text ein:");
            String inputText = sc.next(); // Einlesen des Textes
            System.out.println("Geben Sie die LÃ¤nger der BlÃ¶cke (r) an:");
            int blockSize = sc.nextInt(); // Einlesen der laenge r

            content = this.encryption(inputText, blockSize); // Verschluesseln der Nachricht
            //System.out.println(encryptedText); // Ausgabe auf der Konsole
        }
        // Entschluesselung einer Nachricht
        if (userInput == 2) {
            System.out.println("Geben Sie den zu entschlÃ¼sselnden Text ein:");
            String inputText = sc.next(); // Einlesen des Textes
            System.out.println("Geben Sie die LÃ¤nger der BlÃ¶cke (r) an:");
            int blockSize = sc.nextInt(); // Einlesen der Laenge r

            content = this.decryption(inputText, blockSize); // Entschluesseln der Nachricht
            //System.out.println(decryptedText); // Ausgabe auf der Konsole
        }
        
        sc.close(); // schliessen des Scanner Objekts
        return content;
		
	}
	
	public ECBVerschluesselung() {
		
		this.vorgaben = new VorgabenVonHerrnGast();
		
	}
	
	/**
     * 
     * Diese Methode schaut in der HashMap "createEncryptionCodeMap" nach dem char, welches �bergeben
     * wurde und gibt den entsprechenden String an bits zur�ck. Dieser wird vor dem return noch zu einem
     * Array aus chars umgewandelt.
     * 
     * @param symbol
     * @return char[]
     */
	public char[] symbolToBits(char symbol) {

		String bits =  this.vorgaben.encryptionCodeMap().get(symbol); //Umwandeln von Char in String. 
        
        return bits.toCharArray(); //R�ckgabe eines CharArrays nach aufruf der Methode (toCharArray())
    
	}

	/**
     * 
     * Diese Methode erstellt ein neues Char, welches länger um die Länge von der Methode "symbolLenght()"
     * länger ist als der Text. Dies liegt daren, dass wir die Symbole in ein Bit-Char[] umwandeln lassen
     * welches die länge von "symbolLenght()" hat.
     * 
     * Anschließend werden die einzelnen Chars der Methode "symbolToBits(char symbol)" übergeben. Und der
     * Rückgabewert wird in bits gespeichert und zurück gegeben.
     * 
     * @param text
     * @return char[]
     */
	public char[] textToBits(String text) {

		char[] bits = new char[text.length()*this.vorgaben.symbolLength()]; //Das Array für die länge des Textes * "symbolLenght()"
    	char[] temp = null;//Der temporäre Speicher => Startwert ist Null!);
    	
    	int count = 0; //Ein seperater Counter, damit wir die Felder hoch zählen können im Array bits
    	
    	/*
    	 * 
    	 * Diese For-Schleife geht alle character (Zeichen) von Text durch.
    	 * 
    	 */
    	for(int i = 0; i < text.length(); i++) {
    		
    		temp = this.symbolToBits(text.charAt(i)); //Aufruf der Methode symbolToBits mit dem Char an der Stelle i
    		
    		/*
    		 * 
    		 * For Schleife geht alle felder in temp durch und speichert alle werte in bits an der aktuellen
    		 * stelle von Count 
    		 * 
    		 */
    		for(int a = 0; a < temp.length; a++) {
    			
    			bits[count++] = temp[a];
    			
    		}
    		
    	}
    	
 		return bits; //Rückgabe von bits
 		
	}

	//
    // Zerteilung in Bloecke der Laenge r
    //

    /**
     * 
     * Diese Methode gibt alle Felder bis zu einer n-ten stelle zurück.
     * 
     * @param bits
     * @param n
     * @return char[]
     */
	public char[] firstN(char[] bits, int n) {

		char [] first = new char[n]; //Neues Char-Array mit der größe n
    	
    	/*
    	 * 
    	 * Diese Methode feht das array bits solange durch, bis die länge von first erreicht wurde.
    	 * 
    	 */
    	for(int i = 0; i < first.length; i++) {
    		
    		first[i] = bits[i]; //Bits[i] wird in First[i] gespeichert
    		
    	}
    	
    	return first; //Rückgabe von dem Char-Array n
    	
	}
	
	/**
     * 
     * Diese Methode gibt alle Felder ab einer Stelle n zurück
     * 
     * @param bits
     * @param n
     * @return char[]
     */
	public char[] restN(char[] bits, int n) {

		char [] rest = new char[bits.length - n]; //Erstellung eines neuen Char-Arrays mit der Größe bits.length - n
    	int count = 0; //Erstellung eines counters
    	
    	
    	/*
    	 * 
    	 * Diese for-Schleife geht ab der n-ten Stelle das Array bits durch bis es an der Stelle bits.length
    	 * angekommen ist.
    	 * 
    	 */
    	for(int i = n; i < bits.length; i++) {
    		
    		rest[count++] = bits[i]; //Speicherung von bits[i] in rest[count]
    		
    	}
    	
    	return rest; //Rückgabe von rest
    	
	}

	/**
     * 
     * Hier wird das Char-Array bits in Blöcke unterteilt mit der größe size.
     * Diese werden dann in ein 2 Dimensionales Array gespeichert.
     * 
     * @throws ProgrammInterruptException 
     * 
     * @param bits
     * @param size
     * @return char[][]
     * 
     */
	public char[][] bitsToBlocks(char[] bits, int size) throws ProgrammInterruptException {

		char [][] blocks = new char [bits.length/size][size]; //Erstellung des char-Arrays
    	
    	int count = 0; //Erstellung eines Counts
    	int next = 0; //Erstellung eines Next
    	
    	/*
    	 * 
    	 * Diese for-SHcleife geht durch jedes Feld von bits durch und speichert dies dan
    	 * seppariert in Blocks
    	 * 
    	 */
	   	for(int i = 0; i < bits.length; i++){
	   		
	   		/*
	   		 * 
	   		 * Diese Abfrage schaut ob next = size ist
	   		 * 
	   		 * Anschließend setzt er count + 1 und next auf 0
	   		 * 
	   		 */
	   		if(next == size) {
	   			
	   			count++;
	   			next = 0;
	   			
	   		}
	   		
	   		try {
	   			blocks[count][next++] = bits[i]; //Speicher bits[i] in blocks[count][next]
	   			
	   		} catch (ArrayIndexOutOfBoundsException e) {
	   			
	   			throw new ProgrammInterruptException();
	   		}
	   		
	    }
	   	
	   	return blocks; //Rückgabe von blocks
	   	
	}

	//
    // Verschluesselung von Bloecken
    //

    /**
     * 
     * Diese Methode gibt jeden Block in die Methode "shiftRight()" und gibt anschließend diesen Wieder zurück
     * 
     * @param blocks
     * @return char[]
     */
	public char[][] encryptBlocks(char[][] blocks) {
		
		/*
    	 * 
    	 * Diese for-Schleife geht durch jeden Block durch
    	 * 
    	 */
    	for(int i = 0; i < blocks.length; i++) {
    		
    		blocks[i] = this.vorgaben.shiftRight(blocks[i]); //Übergibt den Block an die Methode "shiftRight()"
    		
    	}
        return blocks; //Gibt die Blöcke wieder zurück
        
	}

	//
    // Zusammenfuegen von Bloecken
    //

    /**
     * 
     * Diese Methode schreibt die Blöcke wieder in Bits um.
     * 
     * @param blocks
     * @return char[]
     */
	public char[] blocksToBits(char[][] blocks) {

		int firstField = blocks.length; //Länge der 1. Dimension
    	int secondField = blocks[0].length; //Länge der 2. Dimension
    	
    	int size = firstField * secondField; //Größe des neunen Feldes
    	
    	char [] bits = new char[size]; //Erstellung des neuen Feldes mit der Größe size
    	
    	int count = 0; //Counter
    	
    	/*
    	 * 
    	 * Diese for-Schleife geht durch jedes Feld durch (1.Dimension)
    	 * 
    	 */
    	for(int i = 0; i < firstField; i++) {
    		
    		/*
    		 * 
    		 * Diese for-Scheleife geht durch jedes Feld durch (2.Dimension) und schreibt blocks[i][a] an
    		 * Stelle bits[count]
    		 * 
    		 */
    		for(int a = 0; a < secondField; a++) {
    		
    			bits[count++] = blocks[i][a]; //Schreibt blocks[i][a] in bits[i]
    			
    		}
    		
    	}
    	
    	return bits; //Gibt bits zurück
    	
	}

	//
    // Umwandlung eines Binaercodes als Text
    //

    /**
     * 
     * Diese Methode schaut sich die Bits an und gibt einen char zurück
     * 
     * @param bits
     * @return char
     */
	public char bitsToSymbol(char[] bits) {

		String temp = ""; //Erstellung einer Temp Variable
    	
    	/*
    	 * 
    	 * Diese for-Scheife schreibt das Array in einen String um
    	 * 
    	 */
    	for(int i = 0; i < bits.length; i++) {
    		
    		temp += bits[i]; //temp wird der char bits[i] hinzugefügt
    		
    	}
    	
    	char symbol = this.vorgaben.decryptionCodeMap().get(temp); //Hier wird der String an die Methode createDecryptionCodeMap().get(temp) gegeben und in symbol gespeichert 
    	
        return symbol; //Return Symbol
        
	}

	/**
     * 
     * Diese Methode gibt der Methode bitsToSymbol einen char-Array mit der Größe size
     * und gibt ein Array mit Symbolen zurück
     * 
     * @param bits
     * @param size
     * @return char[]
     */
	public char[] bitsToText(char[] bits, int size) {

		char [] temp = new char[size]; //Erstellen eines temp-Arrays mit der Größe size
    	char [] symbols = new char[bits.length/size]; //Erstellung eines cahr-Arrays mit der Größe bits.length/size
    	
    	int count = 0; //Erstellen eines Counters
    	
    	/*
    	 * 
    	 * Diese Methode geht durch alle Felder des Arrays symbol
    	 * 
    	 */
    	for(int i = 0; i < symbols.length; i++ ) {
    		
    		/**
    		 * 
    		 * 
    		 * Diese Methode geht durch alle Felder des Array temp und
    		 * speicher temp[a] = bits[count]
    		 * 
    		 */
    		for(int a = 0; a < temp.length; a++) {
    			
    			temp[a] = bits[count++]; //Speichert bits[count] in temp[a]
    			
    		}
    		
    		symbols[i] = bitsToSymbol(temp); //Ruft die Methode bitsToSymbol auf und Speichert den Rücgabewert in symbol[i]
    		
    	}
    	
    	return symbols; //Gibt Symbol zurück
    	
	}

	//
    // Verschluesselung eines Textes
    //

    /**
     * 
     * Diese Methode verarbeitet das Verschlüsseln
     * 
     * @param text
     * @param blockSize
     * @return String
     */
	public String encryption(String text, int blockSize) {

		char [] bits = null;
    	char[][] blocks = null;
    	
		try {
			bits = this.textToBits(text); //Aufruf der Methode terxtToBits()
			blocks = this.bitsToBlocks(bits, blockSize);
			blocks = this.encryptBlocks(blocks); //Aufruf der Methode encryptBlocks()
	    	bits = this.blocksToBits(blocks); //Aufruf der Methode blocksToBits
	    	bits = this.bitsToText(bits, this.vorgaben.symbolLength()); //Aufruf der Methode bitsToBlocks()
	    	text = this.charToString(bits); //Aufruf der Methode charToString();
		} catch (ProgrammInterruptException e) {
			text = e.getErrorMessage();
		}
    	
    	
    	return text;
	}

	//
    // Entschluesselung von Bloecken
    //

    /**
     * 
     * Diese Methode gibt jeden Block in die Methode "shiftRight()" und gibt anschließend diesen Wieder zurück
     * 
     * @param blocks
     * @return char[]
     */
	public char[][] decryptBlocks(char[][] blocks) {

		/*
    	 * 
    	 * Diese for-Schleife geht durch jeden Block durch
    	 * 
    	 */
    	for(int i = 0; i < blocks.length; i++) {
    		
    		blocks[i] = this.vorgaben.shiftLeft(blocks[i]); //Übergibt den Block an die Methode "shiftRight()"
    		
    	}
        return blocks; //Gibt die Blöcke wieder zurück
        
	}

	//
    // Entschluesselung eines Textes
    //
	
	/**
	 * 
	 * Diese Methode verarbeitet das Entschlüsseln
	 * 
	 * @param String text
	 * @param int blockSize
	 * @return text
	 */
	public String decryption(String text, int blockSize) {
		
		char[] bits = null;
    	char[][] blocks = null;
    	
		try {
			bits = this.textToBits(text); //Aufruf der Methode terxtToBits()
			blocks = this.bitsToBlocks(bits, blockSize);
			blocks = this.decryptBlocks(blocks); //Aufruf der Methode encryptBlocks()
	    	bits = this.blocksToBits(blocks); //Aufruf der Methode blocksToBits
	    	bits = this.bitsToText(bits, this.vorgaben.symbolLength()); //Aufruf der Methode bitsToBlocks()
	    	text = this.charToString(bits); //Aufruf der Methode charToString();
		} catch (ProgrammInterruptException e) {
			text = e.getErrorMessage();
		}
    	
    	
    	return text;
    	
	}

	/**
     * 
     * Diese Methode gibt ein char-Array in einen String um
     * 
     * @param bits
     * @return String
     * 
     */
	public String charToString(char[] bits) {

		String text = ""; //Erstellen einer Text Variablen
    	
    	/*
    	 * 
    	 * Diese for-Schleife geht durch jedes Feld von bits und speichert den Wert in text
    	 * 
    	 * 
    	 */
    	for(int i = 0; i < bits.length; i++) {
    		
    		text += bits[i]; //Speichern von bits[i] in text
    		
    	}
    	
    	return text; //Return text
    	
	}

	

}
