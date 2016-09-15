import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class GameTest {
 @Test
    public void endOfCorrectGuess_checingThatCardWasRemovedFromGameValues_false() {
      List<String> names = new ArrayList<String>();
      names.add("tom");
      Game game = new Game(names);
      String string = Suit.CLUBS.toString();
      game.getPlayerList().get(0).clearHand();
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.CLUBS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.KING, Suit.SPADES));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.DIAMONDS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.HEARTS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.QUEEN, Suit.SPADES));
      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.SPADES));
      game.endOfCorrectGuess();
      assertEquals(false, game.getValuesNotMatched().contains(CardValue.FIVE));
 }
 @Test
    public void guess_checingThatCardWasRemovedFromGameValues_true() {
      List<String> names = new ArrayList<String>();
      names.add("tom");
      names.add("jerry");
      Game game = new Game(names);

      game.getPlayerList().get(0).clearHand();
      game.getPlayerList().get(1).clearHand();

      game.getPlayerList().get(0).addCard(new Card(CardValue.FIVE, Suit.CLUBS));
      game.getPlayerList().get(0).addCard(new Card(CardValue.KING, Suit.SPADES));

      game.getPlayerList().get(1).addCard(new Card(CardValue.QUEEN, Suit.SPADES));
      game.getPlayerList().get(1).addCard(new Card(CardValue.FIVE, Suit.SPADES));

      assertEquals(true, game.guess(1, CardValue.FIVE));
    }
}
