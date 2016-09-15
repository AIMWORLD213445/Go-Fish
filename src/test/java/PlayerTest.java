import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {
  @Test
    public void checkHand_recoginizeMatch_TWO() {
    Player player = new Player("Tom");

    player.clearHand();

    player.addCard(new Card(CardValue.JACK, Suit.SPADES));
    player.addCard(new Card(CardValue.QUEEN, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.TWO, Suit.HEARTS));
    player.addCard(new Card(CardValue.NINE, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.NINE, Suit.SPADES));
    player.addCard(new Card(CardValue.TWO, Suit.CLUBS));
    player.addCard(new Card(CardValue.EIGHT, Suit.CLUBS));
    player.addCard(new Card(CardValue.TWO, Suit.SPADES));
    player.addCard(new Card(CardValue.TWO, Suit.DIAMONDS));
    player.checkHand();
    assertEquals(true, player.getHand().contains(new Card(CardValue.TWO, Suit.DIAMONDS)));
 }
 @Test
   public void checkHand_recoginizeMatchwasAdded_true() {
   Player player = new Player("Tom");

   player.addCard(new Card(CardValue.FIVE, Suit.CLUBS));
   player.addCard(new Card(CardValue.KING, Suit.SPADES));
   player.addCard(new Card(CardValue.FIVE, Suit.DIAMONDS));
   player.addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
   player.addCard(new Card(CardValue.FIVE, Suit.HEARTS));
   player.addCard(new Card(CardValue.QUEEN, Suit.SPADES));
   player.addCard(new Card(CardValue.FIVE, Suit.SPADES));
   player.checkHand();
   assertEquals(true, player.getMatches().contains(CardValue.FIVE));
}
}
