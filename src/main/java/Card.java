public class Card{
  private CardValue mValue;
  private Suit mSuit;
  public Card(CardValue cardValue,Suit suit){
    mValue = cardValue;
    mSuit = suit;
  }
  public Suit getSuit(){
    return mSuit;
  }
  public CardValue getValue(){
    return mValue;
  }
}
