import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CautaFisaFrame extends JFrame{
	private GestorEvenimenteCFF ec;
	private JTextField t;
	private JTextArea ta;
	
	public CautaFisaFrame(){
		super ("Cauta fisa unui pacient");
		JPanel p=new JPanel();
		
		p.add(new Label("Introduceti CNP-ul pacientului"));
    t=new JTextField(10);
    ec=new GestorEvenimenteCFF();
    t.addActionListener(ec);
		p.add(t);
		
    add(p, BorderLayout.NORTH);		
    ta=new JTextArea(20,50);

		add(ta);
		setSize(600,200);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
  
  private class GestorEvenimenteCFF implements ActionListener{
  private   ECabinetStomatologic ect;

  GestorEvenimenteCFF(){
 	ect= ECabinetStomatologic.getInstanta();
	 	 
  }
 public void actionPerformed(ActionEvent e){
 	if (e.getSource()==t){
  ta.setText(ect.cautaFisa(t.getText()));
 	t.setText("");
 	}	
 }
	
	
  }
	
	}