package Snake;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class Snake {

	private Blocks[][] mappen;
	private Scanner in;
	
	/**
	 * Konstruktionen h�r l�saer in filen, sedan skapar mappen och l�gger till alla block man inte kan bes�ka
	 */
	
	public Snake() throws IOException{
		
		in = new Scanner(new FileReader("C:/Users/Barry/Desktop/snaketest.txt"));
		String line = in.nextLine();
		    String[] parts = line.split(",");
		    int a = Integer.parseInt(parts[0]);
		    int b = Integer.parseInt(parts[1]);
		    
		    
		    mappen = new Blocks[a][b];
		    for(int i = 0; i <mappen.length; i++){
		    	 for(int j = 0; j <mappen.length; j++){
		    		 mappen[i][j] = new Blocks();
				    }
		    }
		    while (in.hasNext()) {
		    	String rad = in.nextLine();
		    	String[] blocks = rad.split(",");
		        mappen[Integer.parseInt(blocks[0])][Integer.parseInt(blocks[1])].setOmInne(false);
		    }
		    
		    //S�tter ut utg�ngspunkt som �r inne
		    mappen[0][0].setInne();
		    move(0,0);
		    
		
	}
	/**
	 * Anv�ndaren rekursion f�r att flytta ormen genom "gallret". Det prioriterar r�relsen i f�ljande ordning:
	 * Ner 
	 * H�ger 
	 * Upp 
	 * V�nster
	 */
	public void move(int q,int w){
		System.out.println(q+","+w);
		
		
		//G� ner om m�jligt
		if(w+1<mappen.length && mappen[q][w+1].getVisitable()==true && mappen[q][w+1].getInne()==false){
			mappen[q][w+1].setInne();
			move(q,w+1);
		}
		//G� till h�ger om m�jligt
		else if(q+1<mappen.length && mappen[q+1][w].getVisitable()==true && mappen[q+1][w].getInne()==false){
			mappen[q+1][w].setInne();
			move(q+1,w);
		}
		//G� upp om m�jligt
		else if(w-1>=0 && mappen[q][w-1].getVisitable()==true && mappen[q][w-1].getInne()==false){
			mappen[q][w-1].setInne();
			move(q,w-1);
		}
		//G� till v�nster om m�jligt
		else if(q-1>=0 && mappen[q-1][w].getVisitable()==true && mappen[q-1][w].getInne()==false){
			mappen[q-1][w].setInne();
			move(q-1,w);
		}
		
		//Skriv ut v�g och r�nka
		else{
			int hit = 0;
			for(int i = 0; i <mappen.length; i++){
		    	 for(int u = 0; u <mappen.length; u++){
		    		 if(mappen[i][u].getInne()==true){
		    			 hit++;
		    		 }
				    }
		    }
			System.out.println(hit);
		}
	}
	
	public static void main(String[] args) throws IOException{
		new Snake();
	}
}
