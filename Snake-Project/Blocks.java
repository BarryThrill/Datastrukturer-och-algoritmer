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
	 * Konstruktior för Blocks
	 */
	public Blocks(){
		inne = false;
		omInne = true;
		
	}
	
	/**
	 * sätter värden inne till true
	 */
	
	public void setInne(){
		inne = true;
	}
	
	/**
	 * returnerar värden inne
	 * @return
	 */
	
	public boolean getInne(){
		return inne;
	}
	
	/**
	 * Returnerar värden omInne
	 * @return
	 */
	
	public boolean getVisitable(){
		return omInne;
	}
	
	/**
	 * Sätter in värden OmInne från in
	 * @param in
	 */
	public void setOmInne(boolean in){
		omInne = in;
	}

}
