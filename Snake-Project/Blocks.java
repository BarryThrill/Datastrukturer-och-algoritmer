package Snake;

/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class Blocks {
	private boolean inne;
	private boolean omInne;
	
	/**
	 * Konstruktior f�r Blocks
	 */
	public Blocks(){
		inne = false;
		omInne = true;
		
	}
	
	/**
	 * s�tter v�rden inne till true
	 */
	
	public void setInne(){
		inne = true;
	}
	
	/**
	 * returnerar v�rden inne
	 * @return
	 */
	
	public boolean getInne(){
		return inne;
	}
	
	/**
	 * Returnerar v�rden omInne
	 * @return
	 */
	
	public boolean getVisitable(){
		return omInne;
	}
	
	/**
	 * S�tter in v�rden OmInne fr�n in
	 * @param in
	 */
	public void setOmInne(boolean in){
		omInne = in;
	}

}
