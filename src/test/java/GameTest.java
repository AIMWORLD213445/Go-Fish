import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class GameTest {
 @Test
    public void checkHand_recoginizeMatch_TWO() {
      List<String> names = new ArrayList<String>();
      names.add("tom");
      Game game = new Game(names);
      String string = Suit.CLUBS.toString();
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.CLUBS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.KING, Suit.SPADES));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.DIAMONDS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.HEARTS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.QUEEN, Suit.SPADES));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.SPADES));
      game.turn();
      assertEquals(false, game.mValuesNotMatched.contains(CardValue.FIVE));
 }

}
