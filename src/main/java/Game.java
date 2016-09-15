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
    mTurn = 0;
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
  public int getTurn(){
    return mTurn;
  }
  public boolean guess(int player,CardValue value){
    boolean guess = false;
    List<Card> foundCards = new ArrayList<Card>();
    for(Card card : mPlayerList.get(player).getHand()){
      if (value == card.getValue()) {
        mPlayerList.get(mTurn).addCard(card);
        foundCards.add(card);
        guess = true;
      }
    }
    for(Card card : foundCards){
      mPlayerList.get(player).removeCard(card);
    }
    if(guess){
      endOfCorrectGuess();
    }
    else{
      endOfIncorrectGuess();
    }
    return guess;
  }
  public void endOfCorrectGuess(){
    List<Card> foundCards = getPlayerList().get(mTurn).checkHand();
    for(Card cardCheck : foundCards){
      System.out.println(cardCheck.getValue() + " of " + cardCheck.getSuit());
    }
    System.out.println("we found");
    for(Card card:foundCards){
      mPlayerList.get(mTurn).removeCard(card);
    }
    //mValuesNotMatched.remove(value);
  }
  public void endOfIncorrectGuess(){
    if(mDeck.size()!= 0){
      mPlayerList.get(mTurn).addCard(mDeck.remove(0));
    }
    changeTurn();
  }
  private void changeTurn(){
    if(mTurn + 1 < mPlayerList.size()){
      mTurn++;
    }
    else{
      mTurn = 0;
    }
  }
  private void deal(){
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
    for (Suit suit : Suit.values()){
      for(CardValue cardValue : CardValue.values()){
        mDeck.add(new Card(cardValue,suit));
      }
    }
    Collections.shuffle(mDeck);
  }
}
