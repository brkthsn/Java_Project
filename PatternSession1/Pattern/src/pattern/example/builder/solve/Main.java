package pattern.example.builder.solve;

public class Main {

	public static void main(String[] args) {

		Lab bilMuh = new Lab.LabBuilder("YTU", "Bilgisayar Mühendisliği", "Yasin Cakmak").build();
		System.out.println(bilMuh);

		Lab kimyaLab = new Lab.LabBuilder("YTU", "Bilgisayar Mühendisliği", "Yasin Cakmak").labKullanilabilirMi(true).labSayisi(1).build();
		Lab kimyaLab2 = new Lab.LabBuilder("YTU", "Bilgisayar Mühendisliği", "Yasin Cakmak").labSayisi(2).labKullanilabilirMi(true).build();
		System.out.println(kimyaLab);
	}
}
