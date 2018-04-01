package projekt1;

import java.util.Date;

// zad 19
public class Badanie {
	private boolean mTorbiel;
	private double mAlbumina;
	private int mErytrocyty;
	private Date mData;
	Badanie(boolean t, double a, int e, Date d){
		this.setmAlbumina(a);
		this.setmErytrocyty(e);
		this.setmTorbiel(t);
		this.setmData(d);
	}

	public void setmData(Date mData) {
		this.mData = mData;
	}

	public Date getmData() {
		return mData;
	}

	public boolean ismTorbiel() {
		return mTorbiel;
	}

	public void setmTorbiel(boolean mTorbiel) {
		this.mTorbiel = mTorbiel;
	}

	public double getmAlbumina() {
		return mAlbumina;
	}

	public void setmAlbumina(double mAlbumina) {
		this.mAlbumina = mAlbumina;
	}

	public int getmErytrocyty() {
		return mErytrocyty;
	}

	public void setmErytrocyty(int mErytrocyty) {
		this.mErytrocyty = mErytrocyty;
	}
	
	
}
