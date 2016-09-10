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

    public Game(String cards, String board, int numplayers){

        cardfile = cards;
        boardfile = board;

        currentposition = new int[numplayers];

        draw();
        shuffle();
        setBoard();

        play();
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

                if(line.length() > 1){
                    if(Character.isUpperCase(c)) deck.add(new Card(String.valueOf(Character.toLowerCase(c)), 2));
                    else deck.add(new Card(String.valueOf(c), 1));
                }
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

    public void play(){

    }

    private int getNext(int playernumber, Card currentcard){

        int n = playernumber;
        String currentColor = board.get(n)[0];
        n++;
        while(board.get(n)[1] != currentColor){

            if()
        }
        return n;
    }
}
