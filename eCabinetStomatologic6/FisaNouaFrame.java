import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FisaNouaFrame extends JFrame{
	private GestorEvenimenteFNF ec;
	private JTextField ft, lt, ct, vt, st, dt, tt, aet, dgt, trt, mt;
	private JButton ok, cancel;
	
	public FisaNouaFrame(){
		super ("Adauga fisa unui nou pacient");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(6,2,10,10));
		p.setBackground(Color.lightGray);
		
		
    p.add(new JLabel("Nume"));
    lt=new JTextField(100);
    p.add(lt);
	
	p.add(new JLabel("Prenume"));
		ft=new JTextField(100);
		p.add(ft);
		
    p.add(new JLabel("CNP"));
    ct=new JTextField(100);
    p.add(ct);

    p.add(new JLabel("Varsta"));
    vt=new JTextField(100);
    p.add(vt);

    p.add(new JLabel("Sex"));
    st=new JTextField(100);
    p.add(st);

    p.add(new JLabel("Numar telefon"));
    tt=new JTextField(100);
    p.add(tt);

    p.add(new JLabel("Data Nasterii"));
    dt=new JTextField(100);
    p.add(dt);


 	p.add(new JLabel("Adresa e-mail"));
    aet=new JTextField(100);
    p.add(aet);
		add(p);
		
    p.add(new JLabel("Diagnostic"));
    dgt=new JTextField(100);
    p.add(dgt);

    p.add(new JLabel("Tratament"));
    trt=new JTextField(100);
    p.add(trt);

    p.add(new JLabel("Medic"));
    mt=new JTextField(100);
    p.add(mt);

	  ec=new GestorEvenimenteFNF();
		p=new JPanel();
		ok=new JButton("OK");
		ok.addActionListener(ec);
		p.add(ok);

    cancel=new JButton("Cancel");
    cancel.addActionListener(ec);
    p.add(cancel);
    add(p, BorderLayout.SOUTH);		
		
		setLocation(300,300);
		}
  
    private class GestorEvenimenteFNF implements ActionListener{
    private ECabinetStomatologic tnb;

    GestorEvenimenteFNF(){
    tnb= ECabinetStomatologic.getInstanta(); 	 
  }
 public void actionPerformed(ActionEvent e){
  if(e.getSource()==ok) {
    String nume=lt.getText(),prenume=ft.getText(),cnp=ct.getText(),varsta=vt.getText(),sex=st.getText(),data=dt.getText(),adresa=aet.getText(),tel=tt.getText(), diagnostic=dgt.getText(), tratament=trt.getText(), medic=mt.getText();

  	tnb.adaugaFisa(nume,prenume, cnp,varsta, sex, data, tel, adresa, diagnostic, tratament, medic);
    File p=new File(cnp+".txt");
    try{
      if (p.createNewFile()) {
        PrintWriter  pw=new PrintWriter(new FileWriter(p));
        pw.println("Nume: "+nume);
        pw.println("Prenume: "+prenume);
        pw.println("CNP: "+cnp);
        pw.println("Varsta: "+varsta);
        pw.println("Sex: "+sex);
        pw.println("Data Nasterii: "+data);
        pw.println("Nr. Telefon: "+tel);
        pw.println("Adresa E-mail: "+adresa);
        pw.println("Diagnostic: "+diagnostic);
        pw.println("Tratament: "+tratament);
        pw.println("Medic: "+medic);
        pw.close();
      }
     
    }catch(IOException i){i.printStackTrace();}

    FisaNouaFrame.this.dispose();
    }
  else FisaNouaFrame.this.dispose();
 
 }
	
	
  }
	
	}