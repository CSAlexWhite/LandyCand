package sweetworld.landycand;

import android.content.Context;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by alexw on 9/11/2016.
 */
public class Game implements Runnable {

    private Context thiscontext;

    private ArrayList<Card> deck;
    private ArrayList<String[]> board;
    private String cardfile, boardfile;
    private HashMap<String, Integer> specialCards;
    private HashMap<String, String> colors;
    private HashMap<Integer, String> names;
    //TODO add hashmap for player names

    public StringBuilder consoleout;

    private int[] currentposition;
    private boolean[] is_stuck;
    private String[] stuck_color;

    TextView console;

    public Game(TextView sv, Context c, String cname, String bname, int numplayers){

        console = sv;
        consoleout = new StringBuilder("");

        thiscontext = c;

        deck = new ArrayList<>();
        board = new ArrayList<>();
        specialCards = new HashMap<>();
        colors = new HashMap<>();
        names = new HashMap<>();

        setSpecials();
        setColors();
        setNames();

        cardfile = cname;
        boardfile = bname;

        currentposition = new int[numplayers];
        is_stuck = new boolean[numplayers];
        stuck_color = new String[numplayers];

        Arrays.fill(currentposition, 0);
        Arrays.fill(is_stuck, false);
        Arrays.fill(stuck_color, "z");

        draw();
        Log.i("", "");
        shuffle();
        setBoard();

        play(numplayers);
    }

    private void setSpecials(){
        specialCards.put("PLUMPY", 8);
        specialCards.put("MINT", 17);
        specialCards.put("JOLLY", 42);
        specialCards.put("NUT", 74);
        specialCards.put("LOLLY", 95);
        specialCards.put("FROSTINE", 103);
    }

    private void setColors(){
        colors.put("R", "Red");
        colors.put("G", "Green");
        colors.put("O", "Orange");
        colors.put("P", "Purple");
        colors.put("Y", "Yellow");
        colors.put("B", "Blue");
        colors.put("PLUMPY", "Trip to Plumpy's World");
        colors.put("MINT", "Trip to Mint's World");
        colors.put("JOLLY", "Trip to Jolly's World");
        colors.put("NUT", "Trip to Nut's World");
        colors.put("LOLLY", "Trip to Lolly's World");
        colors.put("FROSTINE", "Trip to Frostine's World");
    }

    private void setNames(){
        names.put(0, "Nate");
        names.put(1, "Alex");
        names.put(2, "Kathy");
        names.put(3, "Wanda");
    }

    /**
     * Fills up the arraylist of cards from the config file
     */
    private void draw(){
        Log.i("", "**Initializing Cards**");
        String line;
        try{
            //InputStream fis = new FileInputStream(cardfile);
//            Log.e("AHH", "HERE, yo");
//            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));

            BufferedReader br = new BufferedReader(new InputStreamReader(thiscontext.getAssets().open(cardfile)));


//            BufferedReader br = new BufferedReader(isr);

            while((line = br.readLine()) != null){

                char c = line.charAt(0);

                if(line.length() == 1){
                    if(Character.isUpperCase(c)) deck.add(new Card(String.valueOf(c), 2));
                    else deck.add(new Card(String.valueOf(c).toUpperCase(), 1));
                }
                else{
                    deck.add(new Card(line, 3));
                }
            }
        }

        catch(FileNotFoundException fnfe) {fnfe.printStackTrace();}
        catch(IOException ioe) {ioe.printStackTrace();}
    }

    /**
     * Randomizes the order of the cards in the deck
     */
    private void shuffle(){
        /*LOG*/    Log.i("", "**Shuffling**");
        Collections.shuffle(deck);
    }

    /**
     * Reads in the board config file into an ArrayList
     */
    private void setBoard(){

        String line;
        try{
//            InputStream fis = new FileInputStream(boardfile);
//            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
//            BufferedReader br = new BufferedReader(isr);

            BufferedReader br = new BufferedReader(new InputStreamReader(thiscontext.getAssets().open(boardfile)));

            while((line = br.readLine()) != null) board.add(line.split(" "));
        }

        catch(FileNotFoundException fnfe) {fnfe.printStackTrace();}
        catch(IOException ioe) {ioe.printStackTrace();}
    }

    @Override
    public void run(){
        play(2);
    }

    public void play(int n){

        int turn = 0;

        while(true) {

            Log.i("", "\n******************\n\nTURN " + turn++);

            for (int i = 0; i < n; i++) {

                Log.i("", "\nIt is now " + names.get(i) + "'s turn");

                if(board.get(currentposition[i])[0].length() > 1) {
                    Log.i("", names.get(i) + " is starting at " + colors.get(board.get(currentposition[i])[0]).substring(8));
                    consoleout.append(names.get(i) + " is starting at " + colors.get(board.get(currentposition[i])[0]).substring(8));
                }

                else {
                    Log.i("", names.get(i) + " is starting at position " + colors.get(board.get(currentposition[i])[0]) + "#" + currentposition[i]);
                    if(is_stuck[i])  Log.i("", names.get(i) + " is currently stuck.");
                }

                Card currentCard = drawCard();
                /*LOG*/ Log.i("", names.get(i) + " drew a " + colors.get(currentCard.color));

                if (getNext(i, currentCard) == 1000){
                    /*LOG*/    Log.i("", names.get(i) + " is the WINNER"); //someone won!;
                    System.exit(0);
                }
            }
        }
    }

    private int getNext(int playernumber, Card currentcard){

        if(currentcard.color.length() > 1){
            Log.i("", names.get(playernumber) + " moved " + (specialCards.get(currentcard.color) - currentposition[playernumber]) + " spaces");
            currentposition[playernumber] = specialCards.get(currentcard.color);
/*LOG*/    Log.i("", names.get(playernumber) + " is now at position " + currentposition[playernumber] + ", " + colors.get(board.get(currentposition[playernumber])[0]).substring(8));

            return specialCards.get(currentcard.color);
        }

        int playerposition = currentposition[playernumber];

        ///*LOG*/    System.out.println(names.get(playernumber) + " is now at position " + colors.get(board.get(playerposition)[0]) + "#" + playerposition);

        /**
         * If the player is stuck
         */
        if(is_stuck[playernumber] && (!currentcard.color.equalsIgnoreCase(stuck_color[playernumber]))){
    /*LOG*/    Log.i("", names.get(playernumber) + " didn't get a " + colors.get(stuck_color[playernumber]) + " and is still stuck at ");
    /*LOG*/    Log.i("", colors.get(stuck_color[playernumber]) + "#" + playerposition);

            return playerposition;
        }

        /**
         * Look for the next space to go to
         */
        int n = playerposition + 1;
        if(n>132) return 1000;
//        System.out.println("Looking at " + board.get(n)[0] + "\t" + board.get(n)[1]);

        while(!(board.get(n)[0].equalsIgnoreCase(currentcard.color))){

            if(board.get(n)[0].length()>1){
                n++;
                continue;
            }
//            System.out.println(board.get(n)[0] + "=?=" + currentcard.color);
            n++;

            if(n>132){
                Log.i("", names.get(playernumber) + " moved " + (n - currentposition[playernumber]) + " spaces");
                Log.i("", names.get(playernumber) + " has passed the threshold!");
                return 1000;
            }
//            System.out.println("Looking at " + board.get(n)[0] + "\t" + board.get(n)[1]);
        }
//        System.out.println(board.get(n)[0] + "=?=" + currentcard.color);

        Log.i("", names.get(playernumber) + " moved " + (n - currentposition[playernumber]) + " spaces");

        currentposition[playernumber] = n;
        /*LOG*/    Log.i("", names.get(playernumber) + " is now at position " + colors.get(board.get(n)[0]) + "#" + currentposition[playernumber]);


        if(board.get(n).length > 2){
            /*LOG*/    Log.i("", names.get(playernumber) + " is now stuck ");
            is_stuck[playernumber] = true;
            stuck_color[playernumber] = (board.get(n)[0]);
        }
        if(n > 132) return 1000;
        return n;
    }

    private Card drawCard(){
        if(deck.isEmpty()) {
            Log.i("", "\nNo more cards, reshuffling");
            draw();
            shuffle();
        }
        return deck.remove(0);
    }

    /** UTILITY METHODS **/

    private void printDeck(){
        for(int i=0; i< deck.size(); i++){
            /*LOG*/    System.out.print(deck.get(i).size + deck.get(i).color + " ");
        }
    }
}
