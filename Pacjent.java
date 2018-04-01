package projekt1;

public class Pacjent {
	private String mImie;
	private String mNazwisko;
	private String mPesel;
	private int mPlec;	// 0- kobieta 1- mê¿czyzna
	private int mUbezpieczenie;	//0- NFZ 1- prywatne 2-brak
	private Badanie mBadanie;
	
	Pacjent(String I, String N, String PESEL, int p, int u){ //, Badanie b
		mImie=I;
		mNazwisko=N;
		mPesel=PESEL;
		mPlec=p;
		mUbezpieczenie=u;
		//mBadanie=b;
	}
	

	public Badanie getmBadanie() {
		return mBadanie;
	}


	public void setmBadanie(Badanie b) {
		this.mBadanie = b;
	}


	public String getImie() {
		return mImie;
	}

	public String getNazwisko() {
		return mNazwisko;
	}

	public String getPesel() {
		return mPesel;
	}

	public int getPlec() {
		return mPlec;
	}

	public int getUbezpieczenie() {
		return mUbezpieczenie;
	}

	public void setImie(String imie) {
		mImie = imie;
	}

	public void setNazwisko(String nazwisko) {
		mNazwisko = nazwisko;
	}

	public void setPesel(String pesel) {
		mPesel = pesel;
	}

	public void setPlec(int plec) {
		mPlec = plec;
	}

	public void setUbezpieczenie(int ubezpieczenie) {
		mUbezpieczenie = ubezpieczenie;
	}
	
	
}
