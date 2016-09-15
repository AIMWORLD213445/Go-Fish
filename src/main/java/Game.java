import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game{
  private List<Card> mDeck = new ArrayList<Card>();
  private List<Player> mPlayerList = new ArrayList<Player>();
  private int mNumberOfPlayers;
  private List<String> mNames = new ArrayList<String>();
  public List<CardValue> mValuesNotMatched = new ArrayList<CardValue>();
  public Game(List<String> names){
    for (String name : names){
      mPlayerList.add(new Player(name));
    }
    mNumberOfPlayers = mPlayerList.size();
    for(CardValue value : CardValue.values()){
      mValuesNotMatched.add(value);
    }
    System.out.println(mValuesNotMatched);
    for (Suit suit : Suit.values()){
      for(CardValue cardValue : CardValue.values()){
        mDeck.add(new Card(cardValue,suit));
      }
    }
    Collections.shuffle(mDeck);
    deal();
  }
  public List<Card> getDeck(){
    return mDeck;
  }
  private void deal(){
    System.out.println(mPlayerList.size());
    for(Player player : mPlayerList ) {
      for (int j=0 ;j < 7 ; j++) {
        player.addCard(mDeck.remove(0));
      }
    }
  }
  public List<Player> getPlayerList(){
    return mPlayerList;
  }
  public List<CardValue> getValuesNotMatched(){
    return mValuesNotMatched;
  }
  public void removeValuesNotMatched(CardValue value){
    mValuesNotMatched.remove(value);
  }
  public void turn(){
    CardValue value = getPlayerList().get(0).checkHand();
    mValuesNotMatched.remove(value);
  }
}
