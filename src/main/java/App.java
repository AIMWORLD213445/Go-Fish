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
    Player player = new Player("Tom");
    player.addCard(new Card(CardValue.TWO, Suit.CLUBS));
    player.addCard(new Card(CardValue.KING, Suit.SPADES));
    player.addCard(new Card(CardValue.TWO, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.TWO, Suit.HEARTS));
    player.addCard(new Card(CardValue.QUEEN, Suit.SPADES));
    player.addCard(new Card(CardValue.TWO, Suit.SPADES));
    System.out.println(player.checkHand());

    List<String> names = new ArrayList<String>();
    names.add("tom");
    names.add("jerry");
    Game game = new Game(names);
    String string = Suit.CLUBS.toString();
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
