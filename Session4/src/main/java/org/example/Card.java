package org.example;

public class Card {
    private final Suit suit;
    private final Rank rank;
    public Card( Suit suit, Rank rank){
        this.suit=suit;
        this.rank=rank;
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj== null || getClass() != obj.getClass()) return false;

        Card other= (Card) obj;
        return suit == other.suit && rank== other.rank;
    }
    @Override
    public int hashCode(){
        return 31 * suit.hashCode() + rank.hashCode();
    }
}
