import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class CatalogFrame extends JFrame{
	private GestorEvenimenteC ec;
  private JButton[] b; 
	private JButton t;
  public  String implant1;
  public  ImageIcon implant;
	
	
	public CatalogFrame(){
		super ("Catalog cu implanturi");
		JPanel p=new JPanel();
    p.setLayout(new GridLayout(6,2,10,10));
	  p.setBackground(Color.lightGray);	
     implant1="titlu.jpg";
     implant= new ImageIcon(implant1);
        t=new JButton(implant);
      
       
        p.add(t);
		
   		p.add(t);
b= new JButton[6];
    for (int i=1; i<=5; i++){
      implant1="implant"+i+".jpg";
      implant= new ImageIcon(implant1);
      b[i]=new JButton(implant);
      b[i].setSize(122,190);
      
      b[i].addActionListener(ec);
      p.add(b[i]);
    }

        add(p);
		
  	 ec=new GestorEvenimenteC();
    t.addActionListener(ec);

    JScrollPane scroller = new JScrollPane(p);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    add(scroller);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
		}
  
  private class GestorEvenimenteC implements ActionListener{
 

  GestorEvenimenteC(){
 	
	 	}
 
 public void actionPerformed(ActionEvent e){
  if (e.getSource()==t){
    implant1="titlu.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(CatalogFrame.this, implant, "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
  
  else if (e.getSource()==b[1]){
    implant1="implant1.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(CatalogFrame.this, "hdhdh", "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
  else if (e.getSource()==b[2]){
    implant1="implant2.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(CatalogFrame.this, implant, "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
  else if (e.getSource()==b[3]){
    implant1="implant3.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(null, implant, "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
 else if (e.getSource()==b[4]){
    implant1="implant4.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(null, implant, "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
  else  {
    implant1="implant5.jpg";
      implant= new ImageIcon(implant1);
    JOptionPane.showMessageDialog(null, implant, "Information", JOptionPane.INFORMATION_MESSAGE);
 
  }
 	}	
  
 }
	
	
  }
	
	


