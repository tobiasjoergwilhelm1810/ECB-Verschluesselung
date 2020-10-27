package programm;
import java.util.HashMap;
import java.util.Scanner;

import exception.ProgrammInterruptException;

/**
 * Quellcodevorlage fuer das Projekt
 * 
 * ECB Verschluesselung
 * 
 * KLASSE: 11IT1B
 * 
 * @author Covasala Gabriela, Wilhelm Tobias
 */
public class ECBEncryption {

    static HashMap<Character, String> encryptionCodeMap = createEncryptionCodeMap();
    static HashMap<String, Character> decryptionCodeMap = createDecryptionCodeMap();

    public static void main(String[] args) {
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

            String encryptedText = encryption(inputText, blockSize); // Verschluesseln der Nachricht
            System.out.println(encryptedText); // Ausgabe auf der Konsole
        }
        // Entschluesselung einer Nachricht
        if (userInput == 2) {
            System.out.println("Geben Sie den zu entschlÃ¼sselnden Text ein:");
            String inputText = sc.next(); // Einlesen des Textes
            System.out.println("Geben Sie die LÃ¤nger der BlÃ¶cke (r) an:");
            int blockSize = sc.nextInt(); // Einlesen der Laenge r

            String decryptedText = decryption(inputText, blockSize); // Entschluesseln der Nachricht
            System.out.println(decryptedText); // Ausgabe auf der Konsole
        }
        System.out.println("Danke fÃ¼r Ihre Nutzung und auf Wiedersehen!");
        sc.close(); // schliessen des Scanner Objekts
    }

    // ************************************************************
    //
    // AB HIER BEGINNT IHR QUELLCODE
    //
    // ************************************************************

    //
    // Darstellung eines Textes als Binaercode
    //

    /**
     * 
     * Diese Methode schaut in der HashMap "createEncryptionCodeMap" nach dem char, welches übergeben
     * wurde und gibt den entsprechenden String an bits zurück. Dieser wird vor dem return noch zu einem
     * Array aus chars umgewandelt.
     * 
     * @param symbol
     * @return char[]
     */
    public static char[] symbolToBits(char symbol) {
    	
        String bits =  createEncryptionCodeMap().get(symbol); //Umwandeln von Char in String. 
        
        return bits.toCharArray(); //Rückgabe eines CharArrays nach aufruf der Methode (toCharArray())
    
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
    public static char[] textToBits(String text) {
    	
    	char[] bits = new char[text.length()*symbolLenght()]; //Das Array für die länge des Textes * "symbolLenght()"
    	char[] temp = null;//Der temporäre Speicher => Startwert ist Null!
    	
    	int count = 0; //Ein seperater Counter, damit wir die Felder hoch zählen können im Array bits
    	
    	/*
    	 * 
    	 * Diese For-Schleife geht alle character (Zeichen) von Text durch.
    	 * 
    	 */
    	for(int i = 0; i < text.length(); i++) {
    		
    		temp = symbolToBits(text.charAt(i)); //Aufruf der Methode symbolToBits mit dem Char an der Stelle i
    		
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
    public static char[] firstN(char[] bits, int n) {

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
    public static char[] restN(char[] bits, int n) {

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
    public static char[][] bitsToBlocks(char[] bits, int size) throws ProgrammInterruptException {
    	
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
    public static char[][] encryptBlocks(char[][] blocks) {
    	
    	/*
    	 * 
    	 * Diese for-Schleife geht durch jeden Block durch
    	 * 
    	 */
    	for(int i = 0; i < blocks.length; i++) {
    		
    		blocks[i] = shiftRight(blocks[i]); //Übergibt den Block an die Methode "shiftRight()"
    		
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
    public static char[] blocksToBits(char[][] blocks) {
    	
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
    public static char bitsToSymbol(char[] bits) {
    	
    	String temp = ""; //Erstellung einer Temp Variable
    	
    	/*
    	 * 
    	 * Diese for-Scheife schreibt das Array in einen String um
    	 * 
    	 */
    	for(int i = 0; i < bits.length; i++) {
    		
    		temp += bits[i]; //temp wird der char bits[i] hinzugefügt
    		
    	}
    	
    	char symbol = createDecryptionCodeMap().get(temp); //Hier wird der String an die Methode createDecryptionCodeMap().get(temp) gegeben und in symbol gespeichert 
    	
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
    public static char[] bitsToText(char[] bits, int size) {

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
    public static String encryption(String text, int blockSize) {
        
    	char [] bits = null;
    	char[][] blocks = null;
    	
		try {
			bits = textToBits(text); //Aufruf der Methode terxtToBits()
			blocks = bitsToBlocks(bits, blockSize);
			blocks = encryptBlocks(blocks); //Aufruf der Methode encryptBlocks()
	    	bits = blocksToBits(blocks); //Aufruf der Methode blocksToBits
	    	bits = bitsToText(bits, symbolLenght()); //Aufruf der Methode bitsToBlocks()
	    	text = charToString(bits); //Aufruf der Methode charToString();
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
    public static char[][] decryptBlocks(char[][] blocks) {
    	
    	/*
    	 * 
    	 * Diese for-Schleife geht durch jeden Block durch
    	 * 
    	 */
    	for(int i = 0; i < blocks.length; i++) {
    		
    		blocks[i] = shiftLeft(blocks[i]); //Übergibt den Block an die Methode "shiftRight()"
    		
    	}
        return blocks; //Gibt die Blöcke wieder zurück
    }

    //
    // Entschluesselung eines Textes
    //

    public static String decryption(String text, int blockSize) {
    	
    	char [] bits = null;
    	char[][] blocks = null;
    	
		try {
			bits = textToBits(text); //Aufruf der Methode terxtToBits()
			blocks = bitsToBlocks(bits, blockSize);
			blocks = decryptBlocks(blocks); //Aufruf der Methode encryptBlocks()
	    	bits = blocksToBits(blocks); //Aufruf der Methode blocksToBits
	    	bits = bitsToText(bits, symbolLenght()); //Aufruf der Methode bitsToBlocks()
	    	text = charToString(bits); //Aufruf der Methode charToString();
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
    public static String charToString(char [] bits) {
    	
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

    // ************************************************************
    // HIER ENDET IHR QUELLCODE
    //
    // Quellcodevorlage
    //
    // BITTE NEHMEN SIE AB HIER KEINE AENDERUNGEN MEHR VOR!
    // ************************************************************

    /**
     * Gibt ein uebergebenes Character Array auf der Konsole aus.
     * @param text - a Character array
     */
    static void printCharArray(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }

    /**
     * Bekommt ein Array uebergeben und verschiebt den Inhalt um eine
     * Position nach rechts. Das letzte Element wird somit zum ersten.
     * Das verschobene Array wird zurueckgegeben.
     */
    static char[] shiftRight(char[] bits) {
        char[] shiftedBits = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            int targetPos = i + 1;
            if (targetPos >= bits.length) {
                targetPos = i - (bits.length - 1);
            }
            shiftedBits[targetPos] = bits[i];
        }
        return shiftedBits;
    }

    /**
     * Bekommt ein Array uebergeben und verschiebt den Inhalt um eine
     * Possition nach links im Array. Das erste Element wird somit zum letzten.
     * Das verschobene Array wird zurueckgegeben.
     */
    static char[] shiftLeft(char[] bits) {
        char[] shiftedBits = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            int targetPos = i - 1;
            if (targetPos < 0) {
                targetPos = i + (bits.length - 1);
            }
            shiftedBits[targetPos] = bits[i];
        }
        return shiftedBits;
    }

    static int symbolLenght() {
        return 5;
    }

    /**
     * Erstellung des Binaercode fuer die Verschluesselung
     */
    static HashMap<Character, String> createEncryptionCodeMap() {
        HashMap<Character, String> codeMap = new HashMap<>();
        codeMap.put('A', "00000");
        codeMap.put('C', "00001");
        codeMap.put('E', "00010");
        codeMap.put('G', "00011");
        codeMap.put('I', "00100");
        codeMap.put('K', "00101");
        codeMap.put('M', "00110");
        codeMap.put('O', "00111");
        codeMap.put('Q', "01000");
        codeMap.put('S', "01001");
        codeMap.put('U', "01010");
        codeMap.put('W', "01011");
        codeMap.put('Y', "01100");
        codeMap.put('!', "01101");
        codeMap.put('?', "01110");
        codeMap.put('Z', "01111");

        codeMap.put('X', "10000");
        codeMap.put('V', "10001");
        codeMap.put('T', "10010");
        codeMap.put('R', "10011");
        codeMap.put('P', "10100");
        codeMap.put('N', "10101");
        codeMap.put('L', "10110");
        codeMap.put('J', "10111");
        codeMap.put('H', "11000");
        codeMap.put('F', "11001");
        codeMap.put('D', "11010");
        codeMap.put('B', "11011");
        codeMap.put('_', "11100");
        codeMap.put('=', "11101");
        codeMap.put('+', "11110");
        codeMap.put('-', "11111");
        return codeMap;
    }

    /**
     * Erstellung des Binaercode fuer die Entschluesselung
     */
    static HashMap<String, Character> createDecryptionCodeMap() {
        HashMap<String, Character> codeMap = new HashMap<>();
        codeMap.put("00000", 'A');
        codeMap.put("00001", 'C');
        codeMap.put("00010", 'E');
        codeMap.put("00011", 'G');
        codeMap.put("00100", 'I');
        codeMap.put("00101", 'K');
        codeMap.put("00110", 'M');
        codeMap.put("00111", 'O');
        codeMap.put("01000", 'Q');
        codeMap.put("01001", 'S');
        codeMap.put("01010", 'U');
        codeMap.put("01011", 'W');
        codeMap.put("01100", 'Y');
        codeMap.put("01101", '!');
        codeMap.put("01110", '?');
        codeMap.put("01111", 'Z');

        codeMap.put("10000", 'X');
        codeMap.put("10001", 'V');
        codeMap.put("10010", 'T');
        codeMap.put("10011", 'R');
        codeMap.put("10100", 'P');
        codeMap.put("10101", 'N');
        codeMap.put("10110", 'L');
        codeMap.put("10111", 'J');
        codeMap.put("11000", 'H');
        codeMap.put("11001", 'F');
        codeMap.put("11010", 'D');
        codeMap.put("11011", 'B');
        codeMap.put("11100", '_');
        codeMap.put("11101", '=');
        codeMap.put("11110", '+');
        codeMap.put("11111", '-');
        return codeMap;
    }
}