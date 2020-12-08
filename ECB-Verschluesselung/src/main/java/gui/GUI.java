package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exception.InputException;
import externalstart.ExternalStart;

public class GUI implements ActionListener {

	private ExternalStart extstart = new ExternalStart();
	
	//Frame
	private JFrame jf;
	//Button jben => Encryption
	private JButton jben;
	//Button jbde => Decryption
	private JButton jbde;
	//Textfeld 1 => Text
	private JTextField jptext;
	//Textfeld 2 => Zahl
	private JTextField jpzahl;
 	//Lable => Ausgabe
	private JLabel jl;
	//Label => Info Zahl
	private JLabel infozahl;
	//Label => Info Text
	private JLabel infotext;
	
	public void handleGui() {
		
		this.initFrame();
		
	}
	
	public void initFrame() {
		
		Font f = new Font("SansSerif", Font.BOLD, 20);
		
		this.jf = new JFrame();
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf.setBounds(400, 100, 1200, 400);
		this.jf.setLayout(new GridLayout(4,2));
		
		this.infotext = new JLabel("Hier steht der Text");
		this.infotext.setFont(f);
		this.jf.add(this.infotext);
		
		this.infozahl = new JLabel("Hier steht die BlockSize");
		this.infozahl.setFont(f);
		this.jf.add(this.infozahl);
		
		this.jptext = new JTextField();
		this.jptext.setFont(f);
		this.jf.add(this.jptext);
		
		this.jpzahl = new JTextField();
		this.jpzahl.setFont(f);
		this.jf.add(this.jpzahl);
		
		this.jbde = new JButton();
		this.jbde.setText("Decrypt");
		this.jbde.addActionListener(this);
		this.jbde.setFont(f);
		this.jf.add(this.jbde);
		
		this.jben = new JButton();
		this.jben.setFont(f);
		this.jben.setText("Encrypt");
		this.jben.addActionListener(this);
		this.jf.add(this.jben);
		
		this.jl = new JLabel("Hier könnte Ihre Ausgabe stehen");
		this.jl.setFont(f);
		this.jf.add(this.jl);
		
		this.jf.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.jben){
            this.handleEncryptionPress();
        }
        
        if(e.getSource() == this.jbde){
            this.handleDecryptionPress();
        }
    }
	
	private void handleDecryptionPress() {
		
		String [] args = new String[3];
		
		args[0] = "-d";
		args[1] = this.jptext.getText();
		args[2] = this.jpzahl.getText();
		
		String content = "";
		
		try {
			content = this.extstart.handleStart(args);
			this.jl.setText("Decryption: " + content);
		} catch (InputException e) {
			System.out.println(e.getErrorMessageGui());
			this.jl.setText("Es ist ein Fehler Aufgerteten. Bitte erneut versuchen.");
		}
		
		this.resetTextFields();
		
	}
	
	private void handleEncryptionPress() {
		
		String [] args = new String[3];
		
		args[0] = "-e";
		args[1] = this.jptext.getText();
		args[2] = this.jpzahl.getText();
		
		String content = "";
		
		try {
			content = this.extstart.handleStart(args);
			System.out.println("Gescheit durchlaufen");
			this.jl.setText("Encryption: " + content);
			content = this.extstart.handleStart(args);
		} catch (InputException e) {
			System.out.println(e.getErrorMessageGui());
			this.jl.setText("Es ist ein Fehler Aufgerteten. Bitte erneut versuchen.");
		}
		
		this.resetTextFields();
		
	}
	
	private void resetTextFields() {
		
		this.jptext.setText("");
		this.jpzahl.setText("");
		
	}
	
}
