package sweetworld.landycand.logic;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Alex on 9/10/16.
 */
public class Game {

    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<String[]> board;
    private String cardfile, boardfile;

    private int[] currentposition;
    private boolean[] is_stuck;
    private String[] stuck_color;

    public Game(String cards, String board, int numplayers){

        cardfile = cards;
        boardfile = board;

        currentposition = new int[numplayers];
        is_stuck = new boolean[numplayers];

        Arrays.fill(currentposition, 0);
        Arrays.fill(is_stuck, false);
        Arrays.fill(stuck_color, 'z');

        draw();
        shuffle();
        setBoard();

        play(numplayers);
    }

    /**
     * Fills up the arraylist of cards from the config file
     */
    private void draw(){
        String line;
        try{
            InputStream fis = new FileInputStream("the_file_name");
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            while((line = br.readLine()) != null){

                char c = line.charAt(0);

                if(line.length() == 1){
                    if(Character.isUpperCase(c)) deck.add(new Card(String.valueOf(c), 2));
                    else deck.add(new Card(String.valueOf(c).toUpperCase().concat(String.valueOf(c).toUpperCase()), 1));
                }
                else deck.add(new Card(line, 3));
            }

            Log.i("CALC", deck.toString());
        }

        catch(FileNotFoundException fnfe) {fnfe.printStackTrace();}
        catch(IOException ioe) {ioe.printStackTrace();}
    }

    /**
     * Randomizes the order of the cards in the deck
     */
    private void shuffle(){

        Collections.shuffle(deck);
        Log.i("CALC", deck.toString());
    }

    /**
     * Reads in the board config file into an ArrayList
     */
    private void setBoard(){

        String line;
        try{
            InputStream fis = new FileInputStream("the_file_name");
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            while((line = br.readLine()) != null) board.add(line.split(" "));
        }

        catch(FileNotFoundException fnfe) {fnfe.printStackTrace();}
        catch(IOException ioe) {ioe.printStackTrace();}
    }

    public void play(int n){
        for(int i=0; i<n; i++){
//            if(getNext(i, drawCard()) == 1000)  //someone won!;
        }
    }

    private int getNext(int playernumber, Card currentcard){

        int playerposition = currentposition[playernumber];

        if(is_stuck[playernumber] && (currentcard.color != stuck_color[playernumber]))
            return playerposition;

        int n = playerposition + 1;
        while(board.get(n)[0] != currentcard.color){        // TODO use .equals() not !=

            if(board.get(n).length > 2){
                //stuck logic
                is_stuck[playernumber] = true;
                stuck_color[playernumber] = (board.get(n)[0]);
                break;
            }
            if(n > 132) return 1000;
            n++;
        }
        return n;
    }

    private Card drawCard(){
        return deck.remove(0);
    }
}
