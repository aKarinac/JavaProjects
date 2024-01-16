import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList; 
 
public class FiseFrame extends JFrame{
	private JTextArea ta;
	private BufferedReader br;
	private String l;
	private JPanel imgpanel;
	private String cnp;
	private ArrayList<String> imgPaths;
	
	public FiseFrame(String numecnp){
		super ("Fisa Pacient");
		
		setLayout(new GridLayout(1,2));
		
	     cnp = numecnp.substring(numecnp.lastIndexOf("_") + 1);
		File c= new File(cnp+".txt");
		StringBuilder builder = new StringBuilder();
		imgPaths = new ArrayList<String>();
		imgpanel = new JPanel();
		try{
        if(c.exists()){
			br=new BufferedReader(new FileReader(c));
			while ((l=br.readLine())!=null)
			{
				if(l.startsWith("Img:"))
				{
					String path = l.substring(4);
					JLabel lblPic = new JLabel(new ImageIcon(path));
					imgpanel.add(lblPic);
					imgPaths.add("Img:"+path);
				}
				else
				{
					builder.append(l).append(System.lineSeparator());
				}
			}
			br.close();
			}}
			catch(IOException e){e.printStackTrace();}
			BigFrame(builder);
			imgFrame();
    }

	private void BigFrame(StringBuilder builder)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(true);
		ta = new JTextArea(15, 50);
		ta.setWrapStyleWord(true);
		ta.setEditable(true);
		ta.setText(builder.toString());
		JScrollPane scroller = new JScrollPane(ta);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		JButton button = new JButton("Salveaza");
		button.addActionListener(new SaveHandler());
		JButton butonimg = new JButton("Imagine");
		butonimg.addActionListener(new ImgHandler());
		panel.add(scroller);
		inputpanel.add(button);
		inputpanel.add(butonimg);
		panel.add(inputpanel);
		getContentPane().add(BorderLayout.CENTER, panel);
		pack();
		setLocationByPlatform(true);
		setVisible(true);
		setResizable(false);
	
	}

	public class SaveHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			try{
			StringBuilder sb = new StringBuilder(ta.getText());
			if(imgPaths.size() > 0)
			{
				for(String img: imgPaths)
				{
					sb.append(img);
					sb.append("\n");
				}
			}
			BufferedWriter bf = new BufferedWriter(new FileWriter(cnp+".txt"));
            bf.write(sb.toString());
            bf.flush();
            bf.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			System.out.println("Save successful");
		}
	}

	public class ImgHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			JFileChooser jc = new JFileChooser();
			jc.setDialogTitle("Selectati imaginea");
			jc.setMultiSelectionEnabled(false);
			if(jc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File picture = jc.getSelectedFile(); 
				String caleImg = picture.getAbsolutePath();
				JLabel labelPic = new JLabel(new ImageIcon(caleImg));
				labelPic.setSize(50, 50);
				imgpanel.add(labelPic);
				imgPaths.add("Img:"+caleImg);
				revalidate();
                repaint();
		    }
		}
		
	}
	
	public void imgFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		imgpanel.setLayout(new BoxLayout(imgpanel, BoxLayout.Y_AXIS));
		imgpanel.setOpaque(true);
		getContentPane().add(BorderLayout.CENTER, imgpanel);
		pack();
		setVisible(true);
		setResizable(true);
		
	}

}