import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args) {


    List<String> names = new ArrayList<String>();
    names.add("Player1");
    names.add("Player2");
    Console myConsole = System.console();
    Game game = new Game(names);
    while(true){
      boolean turnOver = true;
      while(turnOver){
        turnOver = false;
        System.out.println("Player " + (game.getTurn()+1) + " your cards are");
        for(Card card : game.getPlayerList().get(game.getTurn()).getHand()){
          System.out.println(card.getValue() + " of " + card.getSuit());
        }
        System.out.println("Player " + (game.getTurn()+1) + " enter your player");
        int player = Integer.parseInt(myConsole.readLine()) - 1;
        System.out.println("Player " + (game.getTurn()+1) + " enter your value");
        CardValue value = CardValue.valueOf(myConsole.readLine().toUpperCase());
        turnOver = game.guess(player,value);
      }
    }
    // for(Card card : game.getPlayerList().get(0).getHand()){
    //   System.out.println(card.getValue() + " of " + card.getSuit());
    // }
    // System.out.print("\n\n");
    // for(Card card : game.getDeck()){
    //   System.out.println(card.getValue() + " of " + card.getSuit());
    // }
    // System.out.println(game.getDeck().get(0).getValue() == CardValue.TWO);


    // String layout = "templates/layout.vtl";
    //
    //    get("/", (request, response) -> {
    //      Map<String, Object> model = new HashMap<String, Object>();
    //      model.put("template", "templates/form.vtl");
    //      return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());

  }
}
