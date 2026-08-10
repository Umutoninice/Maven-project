
package org.example;

public class Card implements printable{
    private  Suit suit;
    private  Rank rank;
    public Card( Suit suit, Rank rank){
        this.suit=suit;
        this.rank=rank;
    }

    public Card() {

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

    @Override
    public void printSummary() {
        System.out.println(rank + " of " + suit);
    }
}
