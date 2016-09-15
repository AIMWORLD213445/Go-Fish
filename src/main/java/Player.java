import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Player{
  private List<Card> mHand = new ArrayList<Card>();

  private String mName;
  public List<CardValue> mMatches = new ArrayList<CardValue>();

  public Player(String name){
    mName = name;
  }
  public List<CardValue> getMatches(){
    return mMatches;
  }
  public List<Card> getHand(){
    return mHand;
  }
  public void addCard(Card card){
    mHand.add(card);
  }
  public void removeCard(Card card){
    mHand.remove(card);
  }
  public String getName(){
    return mName;
  }
  public void clearMatches(){
    mMatches.clear();
  }
  public void clearHand(){
    mHand.clear();
  }
  public List<Card> checkHand(){
    boolean found = false;
    Integer currentCount = 0;
    CardValue foundValue = null;
    List<Card> foundCards = new ArrayList<Card>();
    Map<String, Object> mMap = new HashMap<String, Object>();
    for (CardValue value : CardValue.values()){
      currentCount = 0;
      mMap.put(value.toString(),currentCount);
      for(Card card : mHand){
        if (value == card.getValue()){
          currentCount++;
          System.out.println(currentCount);
          mMap.put(value.toString(),currentCount);
          if(currentCount == 2){
            mMatches.add(value);
            for(Suit suit : Suit.values()){
              foundCards.add(new Card(value,suit));
              System.out.println("we got a pair");
            }
            foundValue = value;
          }
        }
      }
    }
    return foundCards;
  }
}
