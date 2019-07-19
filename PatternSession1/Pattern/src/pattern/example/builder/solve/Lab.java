package pattern.example.builder.solve;

public class Lab {
	private final String labUniversiteIsmi;
	private final String labUniversiteBolumu;
	private final String labIsmi;
	private final int labSayisi;
	private final int labKontejyani;
	private final boolean labKullanilabilirMi;
	private final String labSorumlusu;

	public Lab(LabBuilder labBuilder) {
		this.labUniversiteIsmi = labBuilder.labUniversiteIsmi;
		this.labUniversiteBolumu = labBuilder.labUniversiteBolumu;
		this.labIsmi = labBuilder.labIsmi;
		this.labSayisi = labBuilder.labSayisi;
		this.labKontejyani = labBuilder.labKontejyani;
		this.labKullanilabilirMi = labBuilder.labKullanilabilirMi;
		this.labSorumlusu = labBuilder.labSorumlusu;
	}

	public String getLabUniversiteIsmi() {
		return labUniversiteIsmi;
	}

	public String getLabUniversiteBolumu() {
		return labUniversiteBolumu;
	}

	public String getLabIsmi() {
		return labIsmi;
	}

	public int getLabSayisi() {
		return labSayisi;
	}

	public int getLabKontejyani() {
		return labKontejyani;
	}

	public boolean isLabKullanilabilirMi() {
		return labKullanilabilirMi;
	}

	public String getLabSorumlusu() {
		return labSorumlusu;
	}

	@Override
	public String toString() {
		return "Lab{" + "labUniversiteIsmi=" + labUniversiteIsmi + ", labUniversiteBolumu=" + labUniversiteBolumu + ", labIsmi=" + labIsmi + ", labSayisi=" + labSayisi + ", labKontejyani=" + labKontejyani + ", labKullanilabilirMi=" + labKullanilabilirMi + ", labSorumlusu=" + labSorumlusu + '}';
	}

	public static class LabBuilder {

		private final String labUniversiteIsmi;
		private final String labUniversiteBolumu;
		private final String labIsmi;
		private int labSayisi;
		private int labKontejyani;
		private boolean labKullanilabilirMi;
		private String labSorumlusu;

		public LabBuilder(String labUniversiteIsmi, String labUniversiteBolumu, String labIsmi) {
			this.labUniversiteIsmi = labUniversiteIsmi;
			this.labUniversiteBolumu = labUniversiteBolumu;
			this.labIsmi = labIsmi;
		}

		public LabBuilder labSayisi(int labSayisi) {
			this.labSayisi = labSayisi;
			return this;
		}

		public LabBuilder labKontejyani(int labKontejyani) {
			this.labKontejyani = labKontejyani;
			return this;
		}

		public LabBuilder labKullanilabilirMi(boolean labKullanilabilirMi) {
			this.labKullanilabilirMi = labKullanilabilirMi;
			return this;
		}

		public LabBuilder labSorumlusu(String labSorumlusu) {
			this.labSorumlusu = labSorumlusu;
			return this;
		}

		public Lab build() {
			Lab lab = new Lab(this);
			return lab;
		}
	}

}