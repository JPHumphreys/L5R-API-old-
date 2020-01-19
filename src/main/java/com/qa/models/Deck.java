package com.qa.models;

import javax.persistence.*;

@Entity
//@Table(name = "decks")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private String deckname;

    private String cardid;

    private int quantity;

    public Deck(){}


    public Deck(String userid, String deckname, String cardid, int quantity){
        this.userid = userid;
        this.deckname = deckname;
        this.cardid = cardid;
        this.quantity = quantity;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quanitity) {
        this.quantity = quanitity;
    }

}
