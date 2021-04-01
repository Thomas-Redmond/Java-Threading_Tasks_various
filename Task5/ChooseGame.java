import java.io.*;
import java.util.*;

public class ChooseGame{
  // used for reading user input from console
  public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception{
    // asking whether to play card or dice game
    // adding new games by adding another else if
    System.out.print("Card (c) or Die (d) game? ");
    String ans=br.readLine();

    if (ans.equals("c")) {
      CardGame cards = new CardGame();
      cards.play();
    }

    else if (ans.equals("d")) {
      //i.playDieGame();
    }

    //else if (ans.equal("example")){
      // playexampleGame();
    //}

    else{
      // Response unacceptable loop back to start of main
      System.out.println("Input not understood");
      main(args);
    }
  }
}
