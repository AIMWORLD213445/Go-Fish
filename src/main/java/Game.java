import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game{
  private List<Card> mDeck = new ArrayList<Card>();
  private List<Player> mPlayerList = new ArrayList<Player>();
  private int mNumberOfPlayers;
  private List<String> mNames = new ArrayList<String>();
  private List<CardValue> mValuesNotMatched = new ArrayList<CardValue>();
  private int mTurn;
  public Game(List<String> names){
    mTurn = 1;
    for (String name : names){
      mPlayerList.add(new Player(name));
    }
    makeDeck();
    deal();
  }
  public List<Card> getDeck(){
    return mDeck;
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
    CardValue value = getPlayerList().get(turn).checkHand();
    mValuesNotMatched.remove(value);
  }
  private void changeTurn(){
    if(turn < mPlayerList.size()){
      turn++;
    }
    else{
      turn = 1;
    }
  }
  private void deal(){
    System.out.println(mPlayerList.size());
    for(Player player : mPlayerList ) {
      for (int j=0 ;j < 7 ; j++) {
        player.addCard(mDeck.remove(0));
      }
    }
  }
  private void makeDeck(){
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
  }
}
