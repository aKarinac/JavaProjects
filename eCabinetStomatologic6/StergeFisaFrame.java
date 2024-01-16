import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StergeFisaFrame extends JFrame{
	private GestorEvenimenteSFF ec;
	private JTextField t;
	private JButton ok, c;
	
	public StergeFisaFrame(){
		super ("Sterge fisa unui pacient");
		JPanel p=new JPanel();
		p.setBackground(Color.lightGray);	
		p.add(new Label("Introduceti CNP: "));
		t=new JTextField(10);
		p.add(t);
		add(p);		
		
		p=new JPanel();
		ec=new GestorEvenimenteSFF();
		ok=new JButton("OK");
		ok.addActionListener(ec);
		p.add(ok);
		
    c=new JButton("Cancel");
    c.addActionListener(ec);
    p.add(c);

    add(p, BorderLayout.SOUTH);
		setSize(300,100);
		setLocation(300,300);	
		}
  
  private class GestorEvenimenteSFF implements ActionListener{
  private ECabinetStomatologic ecs;

  GestorEvenimenteSFF(){
 	ecs= ECabinetStomatologic.getInstanta();
	 	 
  }
 public void actionPerformed(ActionEvent e){
 	if (e.getSource()==ok) {
 		ecs.stergeFisa(t.getText());
 		t.setText("");
 	 }
 	else StergeFisaFrame.this.dispose();
 }
	
	
  }
	
	}