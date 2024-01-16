import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;

public class Panou extends JFrame{
    private GestorEvenimentePP ec;
    private  ECabinetStomatologic ecs;
    private JButton[] c;
	public JPanel panel;
	public Panou(){
		super ("Baza de Date");
		add(new Label("Baza de Date"), BorderLayout.NORTH);
    ecs= ECabinetStomatologic.getInstanta();
        panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        panel.setBackground(Color.lightGray); 
        panel.setLayout(new GridLayout(ecs.nrPacient(),1,10,10));
        add(panel);  
		
        ec=new GestorEvenimentePP();
        c=new JButton[100];
        
        int n=0; 
       for(Fisa f: ecs.GetFise())	
       {    
       c[n]=new JButton(f.getButonNume());
       c[n].setPreferredSize(new Dimension(150, 40));
       c[n].addActionListener(ec);
       panel.add(c[n]);
       n++;
       
    }
 
    JScrollPane panelPane = new JScrollPane(panel);
  	panelPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    panelPane.setViewportView(panel);
    setContentPane(panelPane);
  
    
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


  
    public class GestorEvenimentePP implements ActionListener{
        private   Frame f;
    
       
          public void actionPerformed(ActionEvent e){	
           for(int i=0;i<c.length;i++)
       {    
           if(e.getSource()==c[i]) {
             String textButon=c[i].getText();
            f=new FiseFrame(textButon);
            f.setSize(400, 300);
            f.setVisible(true);
           }
           
          
              
              }
    }}

	}