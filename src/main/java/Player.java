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
  public List<Card> getHand(){
    return mHand;
  }
  public void addCard(Card card){
    mHand.add(card);
  }
  public String getName(){
    return mName;
  }
  public void clearMatches(){
      mMatches.clear();
  }
  public CardValue checkHand(){
    boolean found = false;
    Integer currentCount = 0;
    CardValue foundValue = null;
    Map<String, Object> mMap = new HashMap<String, Object>();
    for (CardValue value : CardValue.values()){
      currentCount = 0;
      mMap.put(value.toString(),currentCount);
      for(Card card : mHand){
        if (value == card.getValue()){
          currentCount++;
          mMap.put(value.toString(),currentCount);
          if(currentCount == 4){
            mMatches.add(value);
            for(Suit suit : Suit.values()){
              mHand.remove(new Card(value,suit));
            }
            foundValue = value;
            return foundValue;
          }
        }
      }
    }
    return foundValue;
  }
}
