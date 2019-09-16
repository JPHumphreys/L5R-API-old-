package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //String clan;
    int cost;
    int decklimit;
    String element;
    int fate;
    int glory;
    int honor;
    String id;
    String imglocation;
    int influencecost;
    int influencepool;
    String isrestricted;
    int military;
    String militarybonus;
    String name;
    int political;
    String politicalbonus;
    String rolerestriction;
    String side;
    int strength;
    String strengthbonus;
    String text;
    String typeof;
    String unicity;



