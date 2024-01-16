import java.util.*;
import java.io.*; 
import javax.swing.*;
public class ECabinetStomatologic{
	public TreeSet<Fisa> ts;
	private BufferedReader br;
	private PrintWriter pw;
	private String l;
	private Fisa fisa;
	private static ECabinetStomatologic instanta;


	private ECabinetStomatologic(){
	 File f=new File("fise.txt");
	 ts=new TreeSet<>();
	
	  String[] s, s1;
	  String ae; 
	 if (f.exists()){
	 	try{
	 		br=new BufferedReader(new FileReader(f));
	 		while ((l=br.readLine())!=null){
	             s=l.split("_");
	             s1=s[0].split(" ");
	             ae=s[3];
	             if(s.length>7) ae+="_"+s[10];
	 			 fisa=new Fisa(s1[0], s1[1], s[1], s[2], s[4], s[5], s[6], ae, "", "", "");
				 
	 			 ts.add(fisa);
				  
	    }
	 	}catch(IOException ioe){ioe.printStackTrace();}	
	
	} else System.out.println("Fisierul nu exista");
	}		
	


	public TreeSet<Fisa> GetFise(){
		return ts;
	}



  public int nrPacient() {

    int count = 0;

    try {

     File file = new File("fise.txt");
	if (file.exists()){
	 br=new BufferedReader(new FileReader(file));
	 		while ((l=br.readLine())!=null){
				 count++;}
    }
    } 
	catch (Exception e) {
      e.getStackTrace();
    }
	 return count;
  }


public void adaugaFisa(String nume, String prenume, String cnp, String varsta, String sex, String dn, String nt, String ae, String dgt, String trt, String mt ){
	fisa=new Fisa(nume, prenume, cnp, varsta, sex, dn, nt, ae, dgt, trt, mt);
	if (ts.contains(fisa)) {
		JOptionPane.showMessageDialog(null, "Fisa electronica exista deja in baza de date", "Alert", JOptionPane.ERROR_MESSAGE);
		return;
	}
	ts.add(fisa);
	JOptionPane.showMessageDialog(null, "A fost adaugata o noua fisa electronica", "Information", JOptionPane.INFORMATION_MESSAGE);

}



public String cautaFisa(String cnp){
		for(Fisa f: ts)	if(cnp.equals(f.getCNP())) return f.toString();
		return "nu exista nicio fisa cu CNP-ul "+ cnp;
	}

	
	
	
public void stergeFisa(String cnp){
	Iterator<Fisa> it=ts.iterator();
	while (it.hasNext())	{
	  if(cnp.equalsIgnoreCase(it.next().getCNP())) {
	    it.remove();
		File c= new File(cnp+".txt");
		if (c.exists() && c.delete()){
	    JOptionPane.showMessageDialog(null, "Fisa a fost stearsa din baza de date", "Information", JOptionPane.INFORMATION_MESSAGE);
	    salveaza();
		return;}
	  }
	}	
	JOptionPane.showMessageDialog(null, "Fisa nu se gaseste in baza de date", "Alert", JOptionPane.ERROR_MESSAGE);
}

public void salveaza(){
try{
  pw=new PrintWriter(new FileWriter("fise.txt"));
  for(Fisa f: ts) pw.println(f);
  pw.close();	
 }catch(IOException e){e.printStackTrace();}

}
	
public static  ECabinetStomatologic getInstanta(){
	if (instanta==null) instanta=new  ECabinetStomatologic();
	return instanta;
}	
	
	

}