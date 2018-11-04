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
	 * Konstruktionen här läsaer in filen, sedan skapar mappen och lägger till alla block man inte kan besöka
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
		    
		    //Sätter ut utgångspunkt som är inne
		    mappen[0][0].setInne();
		    move(0,0);
		    
		
	}
	/**
	 * Användaren rekursion för att flytta ormen genom "gallret". Det prioriterar rörelsen i följande ordning:
	 * Ner 
	 * Höger 
	 * Upp 
	 * Vänster
	 */
	public void move(int q,int w){
		System.out.println(q+","+w);
		
		
		//Gå ner om möjligt
		if(w+1<mappen.length && mappen[q][w+1].getVisitable()==true && mappen[q][w+1].getInne()==false){
			mappen[q][w+1].setInne();
			move(q,w+1);
		}
		//Gå till höger om möjligt
		else if(q+1<mappen.length && mappen[q+1][w].getVisitable()==true && mappen[q+1][w].getInne()==false){
			mappen[q+1][w].setInne();
			move(q+1,w);
		}
		//Gå upp om möjligt
		else if(w-1>=0 && mappen[q][w-1].getVisitable()==true && mappen[q][w-1].getInne()==false){
			mappen[q][w-1].setInne();
			move(q,w-1);
		}
		//Gå till vänster om möjligt
		else if(q-1>=0 && mappen[q-1][w].getVisitable()==true && mappen[q-1][w].getInne()==false){
			mappen[q-1][w].setInne();
			move(q-1,w);
		}
		
		//Skriv ut väg och ränka
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
