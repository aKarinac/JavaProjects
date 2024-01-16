

public class Fisa implements Comparable<Fisa>{
		private String  nume, prenume, cnp, varsta, sex, dataNasterii, numarTelefon, adresaEmail, diagnostic, tratament, medic;
		
		
		public Fisa(String nume, String prenume, String cnp, String varsta, String sex, String dn, String nt, String ae, String dgt, String trt, String mt){
			this.nume=nume;
			this.prenume=prenume;
			this.cnp=cnp;		
			this.varsta=varsta;
			this.sex=sex;
			this.dataNasterii=dn;
			this.numarTelefon=nt;
			this.adresaEmail=ae;
			this.diagnostic=dgt;
			this.tratament=trt;
			this.medic=mt;
			

		}
	
	
	
	public String getCNP(){
		return cnp;
	}

	public String getButonNume(){
		return nume+" "+prenume+"_"+cnp;
	}

	public String toString(){
		return nume+" "+prenume+"_"+cnp+"_"+varsta+"_"+sex+"_"+dataNasterii+"_"+numarTelefon+"_"+adresaEmail;
	}

	
	
	public int compareTo(Fisa o){
	 return (cnp).compareTo(o.getCNP());
	}
	
}