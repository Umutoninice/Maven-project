package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(suit,rank));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card dealCard(){
        if (cards.isEmpty()){
            throw new IllegalStateException("Can not deal from an empty deck");
        }
        return cards.removeFirst();
    }
    public int getSize(){
        return cards.size();
    }
    public boolean isEmpty(){
        return cards.isEmpty();
    }
    public List<Card> getCards(){
        return new ArrayList<>(cards);
    }
    @Override
    public String toString(){
        return "Deck{" + "Size=" + cards.size() + ", cards=" + cards + '}';
    }
}
