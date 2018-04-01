package projekt1;
import javax.swing.*;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;
	private JMenu mAplikacja;
	private JMenuItem mZamknij;
	private JPanel mDane, mBadanie, mCalosc; // mLista;
	private JRadioButton mMan, mWoman;
	private JButton mZapisz, mAnuluj,mZapiszB,mAnulujB;
	private JTextField mImieTekst, mNazwiskoTekst, mPeselTekst, mAlbumina, mErytrocyty;
	private JComboBox mUbezpieczenieBox;
	private ButtonGroup bGroup=new ButtonGroup();
	private ArrayList<Pacjent> listaPacjentow=new ArrayList<>();
	private int liczbaPacjentow=0; 
	private JCheckBox mTorbiel;
	private int nrPacjenta=-1; //-1 jeœli nie wybrano ¿adnego pacjetna
	private JDateChooser mData;

	
	public Frame(){
		menuBar=new JMenuBar();
		mAplikacja=new JMenu("Aplikacja");
		mZamknij= new JMenuItem("Zamknij ALT+F4");
		
		this.setJMenuBar(menuBar);;
		menuBar.add(mAplikacja);
		mAplikacja.add(mZamknij);
		
		mZamknij.addActionListener(this);
		
		mDane=new JPanel();
		mDane.setBackground(Color.WHITE);
		mDane.setBorder(BorderFactory.createTitledBorder("Dane Pacjenta"));
		
		JLabel mImie= new JLabel("Imiê:");
		JLabel mNazwisko= new JLabel("Nazwisko:");
		JLabel mPesel= new JLabel("PESEL:");
		JLabel mPlec= new JLabel("P³eæ:");
		JLabel mUbezpieczenie= new JLabel("Ubezpieczenie:");
		
		mImieTekst= new JTextField();
		mNazwiskoTekst= new JTextField();
		mPeselTekst= new JTextField();
		
		mMan= new JRadioButton("Mê¿czyzna");
		mWoman= new JRadioButton("Kobieta");
		
		bGroup.add(mMan);
		bGroup.add(mWoman);
		
		mMan.addActionListener(this);
		mMan.setBackground(Color.WHITE);
		mWoman.addActionListener(this);
		mWoman.setBackground(Color.WHITE);
		
		String[] Ubezp= {"NFZ", "Prywatne", "Brak"};
		mUbezpieczenieBox= new JComboBox(Ubezp);
		mUbezpieczenieBox.setMaximumSize(new Dimension(1500,10));
		
		mZapisz= new JButton("Zapisz");
		mAnuluj= new JButton("Anuluj");
		
		mZapisz.addActionListener(this);
		mAnuluj.addActionListener(this);
		
		mDane.add(mImie);
		mDane.add(mNazwisko);
		mDane.add(mImieTekst);
		mDane.add(mNazwiskoTekst);
		mDane.add(mPesel);
		mDane.add(mPeselTekst);
		mDane.add(mMan);
		mDane.add(mWoman);
		mDane.add(mUbezpieczenie);
		mDane.add(mZapisz);
		mDane.add(mAnuluj);
		
		GroupLayout lDane= new GroupLayout(mDane);
		mDane.setLayout(lDane);
		
		lDane.setAutoCreateGaps(true);
		lDane.setAutoCreateContainerGaps(true);
		lDane.setHorizontalGroup(lDane.createSequentialGroup()
				.addGroup(lDane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mImie)
						.addComponent(mNazwisko)
						.addComponent(mPesel)
						.addComponent(mPlec)
						.addComponent(mUbezpieczenie)
						.addGroup(lDane.createSequentialGroup()
								.addComponent(mZapisz)
								.addComponent(mAnuluj)))
				.addGroup(lDane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mImieTekst)
						.addComponent(mNazwiskoTekst)
						.addComponent(mPeselTekst)
						.addGroup(lDane.createSequentialGroup()
										.addComponent(mWoman)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
										.addComponent(mMan))
						.addComponent(mUbezpieczenieBox)));
				
		lDane.setVerticalGroup(lDane.createSequentialGroup()
				.addGroup(lDane.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mImie)
						.addComponent(mImieTekst))
				.addGroup(lDane.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mNazwisko)
						.addComponent(mNazwiskoTekst))
				.addGroup(lDane.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mPesel)
						.addComponent(mPeselTekst))
				.addGroup(lDane.createParallelGroup()
						.addComponent(mPlec)
						.addComponent(mWoman)
						.addComponent(mMan))
				.addGroup(lDane.createParallelGroup()
						.addComponent(mUbezpieczenie)
						.addComponent(mUbezpieczenieBox))
				.addGroup(lDane.createParallelGroup()
						.addComponent(mZapisz)
						.addComponent(mAnuluj)));
		
	
		
		mBadanie=new JPanel();
		mBadanie.setBackground(Color.WHITE);
		mBadanie.setBorder(BorderFactory.createTitledBorder("Badanie"));
		mBadanie.setSize(new Dimension(300,300));
		
		JLabel mDat= new JLabel("Data:");
		JLabel mTorb= new JLabel("Torbiel:");
		JLabel mAlb= new JLabel("Albumina:");
		JLabel mEryt= new JLabel("Erytrocyty:");
		
		mZapiszB= new JButton("Zapisz");
		mAnulujB= new JButton("Anuluj");
		
		mZapiszB.addActionListener(this);
		mAnulujB.addActionListener(this);
		
		mTorbiel= new JCheckBox();
		
		mData= new JDateChooser();
		mErytrocyty= new JTextField();
		mAlbumina= new JTextField();
		mBadanie.add(mDat);
		mBadanie.add(mData);
		mBadanie.add(mTorb);
		mBadanie.add(mEryt);
		mBadanie.add(mAlb);
		mBadanie.add(mZapiszB);
		mBadanie.add(mAnulujB);
		
		
		
		GroupLayout	lBadanie= new GroupLayout(mBadanie);
		mBadanie.setLayout(lBadanie);
		
		lBadanie.setAutoCreateGaps(true);
		lBadanie.setAutoCreateContainerGaps(true);
		lBadanie.setHorizontalGroup(lBadanie.createSequentialGroup()
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mDat)
						.addComponent(mTorb)
						.addComponent(mEryt)
						.addComponent(mAlb)
						.addGroup(lBadanie.createSequentialGroup()
								.addComponent(mZapiszB)
								.addComponent(mAnulujB)))
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mData)
						.addComponent(mTorbiel)
						.addComponent(mErytrocyty)
						.addComponent(mAlbumina)));
		lBadanie.setVerticalGroup(lBadanie.createSequentialGroup()
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mDat)
						.addComponent(mData))
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mTorb)
						.addComponent(mTorbiel))
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mEryt)
						.addComponent(mErytrocyty))
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mAlb)
						.addComponent(mAlbumina))
				.addGroup(lBadanie.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mZapiszB)
						.addComponent(mAnulujB)));
				
		
		mCalosc= new JPanel();
		mCalosc.setLayout(new BoxLayout(mCalosc,BoxLayout.Y_AXIS));
		mCalosc.add(mDane);
		mCalosc.add(mBadanie);
		
		this.getContentPane().add(mCalosc);
		this.pack();
		this.setTitle("Rejestracja wyników badañ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setResizable(false);
	}
	
	
	public static void main(String[] args) {
		Runnable thread= new Runnable() {
			@Override
			public void run() {
				Frame app= new Frame();
				app.setVisible(true);
				
			}
		};
		SwingUtilities.invokeLater(thread);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object z= e.getSource();
		int blad=0;
		int plec,ubezp;
		String imie, nazwisko, pesel;
		if(z==this.mZamknij)
			dispose();
		else if(z==this.mAnuluj) 
		{
			this.mImieTekst.setText("");
			this.mNazwiskoTekst.setText("");
			this.mPeselTekst.setText("");
			bGroup.clearSelection();
			this.mUbezpieczenieBox.setSelectedIndex(0);
			this.mUbezpieczenieBox.updateUI();
		}
		
		else if(z==this.mZapisz)
		{
			if(this.mImieTekst.getText().isEmpty())
				blad=1;
			if(this.mNazwiskoTekst.getText().isEmpty())
				blad=2;
			if(!isInteger(this.mPeselTekst.getText()) || (this.mPeselTekst.getText().length()!=11))
				blad=3;
			if(!this.mMan.isSelected() && !this.mWoman.isSelected())
				blad=4;
			for (int n=0; n<this.liczbaPacjentow; n++) 
			{
				String pes=this.listaPacjentow.get(n).getPesel();
				String pe=this.mPeselTekst.getText();
				if(pes.equals(pe))
					blad=5;
			}
			if(blad!=0)
			{
				switch (blad) 
				{
				case 1:
					JOptionPane.showMessageDialog(this,"Brak podanego imienia","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(this,"Brak podanego nazwiska","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					JOptionPane.showMessageDialog(this,"B³êdny numer PESEL","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 4:
					JOptionPane.showMessageDialog(this,"Nie zosta³a wybrana ¿adna p³eæ","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 5:
					JOptionPane.showMessageDialog(this,"Pacjent o podanym numerze PESEL ju¿ istnieje","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
			else
			{
				if(this.mMan.isSelected())
					plec=1;
				else
					plec=0;
				ubezp=this.mUbezpieczenieBox.getSelectedIndex();
				imie=this.mImieTekst.getText();
				nazwisko=this.mNazwiskoTekst.getText();
				pesel=this.mPeselTekst.getText();
				this.listaPacjentow.add(new Pacjent(imie, nazwisko, pesel,plec,ubezp));
				this.liczbaPacjentow++;
				this.nrPacjenta=this.liczbaPacjentow-1;
				JOptionPane.showMessageDialog(this,"Zapisano pacjenta","Zapisano",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		if(z==this.mZapiszB)
		{
			int eryt=0;
			double alb=0;
			int blad1=0;
			Date data;
			boolean t= this.mTorbiel.isSelected();
			if(!isDouble(this.mAlbumina.getText()))
				blad1=1;
			else
			{
				alb= Double.parseDouble(this.mAlbumina.getText());
			}
			if(!isInteger(this.mErytrocyty.getText()))
				blad1=2;
			else
			{
				eryt=Integer.parseInt(this.mErytrocyty.getText());
			}
			data= this.mData.getDate();
			if (data==null)
				blad1=3;
			
			if(blad1==0 && !this.listaPacjentow.isEmpty() && this.nrPacjenta>=0) {
				Badanie b=new Badanie(t,alb,eryt,data);
				this.listaPacjentow.get(this.nrPacjenta).setmBadanie(b);
				JOptionPane.showMessageDialog(this,"Zapisano badnie","Zapisano",JOptionPane.INFORMATION_MESSAGE);
				this.mErytrocyty.setText("");
				this.mAlbumina.setText("");
				this.mTorbiel.setSelected(false);
				this.mTorbiel.updateUI();
				this.mImieTekst.setText("");
				this.mNazwiskoTekst.setText("");
				this.mPeselTekst.setText("");
				this.bGroup.clearSelection();
				this.mUbezpieczenieBox.setSelectedIndex(0);
				this.mUbezpieczenieBox.updateUI();
				this.nrPacjenta=-1;
				this.mData.setDate(null);
				
			}
			else if(blad1!=0)
			{
				switch(blad1) {
				case 1:
					JOptionPane.showMessageDialog(this,"Nieprawid³owa wartoœæ albuminy","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(this,"Nieprawid³owa wartoœæ erytrocytów","B³êdne dane",JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					JOptionPane.showMessageDialog(this,"Nie podano daty","B³êdne dane",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(this.listaPacjentow.isEmpty() || this.nrPacjenta<0)
				JOptionPane.showMessageDialog(this,"Nie wybrano ¿adnego pacjetna","B³êdne dane",JOptionPane.ERROR_MESSAGE);
			
		}
		if(z==this.mAnulujB) 
		{
			this.mErytrocyty.setText("");
			this.mAlbumina.setText("");
			this.mTorbiel.setSelected(false);
			this.mTorbiel.updateUI();
		}
		
		}
	
	public boolean isInteger(String s) {
		try {
			Long.parseLong(s);
			return true;
		}
		catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException ex) {
			return false;
		}
	}
}

	

