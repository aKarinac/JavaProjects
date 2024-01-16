import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FereastraPrincipala extends JFrame{
	private GestorEvenimenteFP ec;
	private JButton[] b;
	
	
	public FereastraPrincipala(){
	 super ("Bine ati venit!");
	  JPanel p=new JPanel();	
	  p.setLayout(new GridLayout(3,2,10,10));
	  p.setBackground(Color.lightGray);	
	  String[] s=new String[]{"Adauga fisa unui nou pacient", "Cauta fisa pacientului", "Sterge fisa pacientului", "Arata/Modifica continut baza de date","Catalog implanturi dentare", "Salveaza toate fisele"};
	  ec=new GestorEvenimenteFP();	
	 b=new JButton[6];	
	  for (int i=0; i<b.length; i++){
		b[i]=new JButton(s[i]);
		b[i].addActionListener(ec);
		p.add(b[i]);
 	   }
	add(p);	
	}
	
	private class GestorEvenimenteFP implements ActionListener{
		private Frame f;
		
	 public void actionPerformed(ActionEvent e){
	 
	  if(e.getSource()==b[0]){
	    f=new FisaNouaFrame();
	  	f.setSize(400, 300);
	  	f.setVisible(true);
	  	  
	  }
	 else if(e.getSource()==b[1]){
	   f=new CautaFisaFrame();
         f.setVisible(true);
	 }
	 	
	 else if(e.getSource()==b[2]){
	   f=new StergeFisaFrame();
	   f.setSize(300, 300);
         f.setVisible(true);
       }
	 else if(e.getSource()==b[3]){
	   f=new Panou();
	   f.setSize(400, 300);
         f.setVisible(true);
	  	  
	  }	
	  else if(e.getSource()==b[4]){
		f=new CatalogFrame();
		f.setSize(400, 300);
		  f.setVisible(true);
			 
	   }	
	 else {
		ECabinetStomatologic at= ECabinetStomatologic.getInstanta();
	 	at.salveaza();
	 }
	 	
	 }	
 }
public static void main(String[] args){
 JFrame w=new FereastraPrincipala();
 w.setSize(600, 200);
 w.setLocation(300,300);	
 w.setVisible(true); 	
 w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}	

}