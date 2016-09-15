import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {
  @Test
    public void checkHand_recoginizeMatch_TWO() {
    Player player = new Player("Tom");
    player.clearMatches();
    player.addCard(new Card(CardValue.FIVE, Suit.CLUBS));
    player.addCard(new Card(CardValue.KING, Suit.SPADES));
    player.addCard(new Card(CardValue.FIVE, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
    player.addCard(new Card(CardValue.FIVE, Suit.HEARTS));
    player.addCard(new Card(CardValue.QUEEN, Suit.SPADES));
    player.addCard(new Card(CardValue.FIVE, Suit.SPADES));
    assertEquals(CardValue.FIVE, player.checkHand());
 }
 @Test
   public void checkHand_recoginizeMatchwasAdded_true() {
   Player player = new Player("Tom");
   player.clearMatches();
   player.addCard(new Card(CardValue.FIVE, Suit.CLUBS));
   player.addCard(new Card(CardValue.KING, Suit.SPADES));
   player.addCard(new Card(CardValue.FIVE, Suit.DIAMONDS));
   player.addCard(new Card(CardValue.JACK, Suit.DIAMONDS));
   player.addCard(new Card(CardValue.FIVE, Suit.HEARTS));
   player.addCard(new Card(CardValue.QUEEN, Suit.SPADES));
   player.addCard(new Card(CardValue.FIVE, Suit.SPADES));
   player.checkHand();
   assertEquals(true, player.mMatches.contains(CardValue.FIVE));
}
}
