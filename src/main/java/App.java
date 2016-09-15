import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;


public class App{
  public static void main(String[] args) {


    List<String> names = new ArrayList<String>();
    names.add("player1");
    names.add("Player2");
    Game game = new Game(names);
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
