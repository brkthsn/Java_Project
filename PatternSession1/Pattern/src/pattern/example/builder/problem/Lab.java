package pattern.example.builder.problem;

public class Lab {
	 private String labUniversiteIsmi;
	 private String labUniversiteBolumu;
	 private String labIsmi;
	 private int labSayisi;
	 private int labKontejyani;
	 private boolean labKullanilabilirMi;
	 private String labSorumlusu;

	 public Lab(String labUniversiteIsmi, String labUniversiteBolumu, String labIsmi, int labSayisi, int labKontejyani, boolean labKullanilabilirMi, String labSorumlusu) {
	 this.labUniversiteIsmi = labUniversiteIsmi;
	 this.labUniversiteBolumu = labUniversiteBolumu;
	 this.labIsmi = labIsmi;
	 this.labSayisi = labSayisi;
	 this.labKontejyani = labKontejyani;
	 this.labKullanilabilirMi = labKullanilabilirMi;
	 this.labSorumlusu = labSorumlusu;
	 }

	 public Lab(String labUniversiteIsmi, String labUniversiteBolumu, String labIsmi) {
	 this.labUniversiteIsmi = labUniversiteIsmi;
	 this.labUniversiteBolumu = labUniversiteBolumu;
	 this.labIsmi = labIsmi;
	 }
	 
	 
	 
	 public static void main (String arg[]) {
		 //Lab lab= new Lab();
		 Lab lab2 = new Lab("YTU","Bilgisayar Mühendisliği", "LABADI",1, 24, true,"Yasin Cakmak","a.yasin.cakmak@gmail.com");
	 }
}