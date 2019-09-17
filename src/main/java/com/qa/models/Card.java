package com.qa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {

    @Id

    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private List<Card> cards = new ArrayList<>();

    String clan;
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

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDecklimit() {
        return decklimit;
    }

    public void setDecklimit(int decklimit) {
        this.decklimit = decklimit;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getFate() {
        return fate;
    }

    public void setFate(int fate) {
        this.fate = fate;
    }

    public int getGlory() {
        return glory;
    }

    public void setGlory(int glory) {
        this.glory = glory;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImglocation() {
        return imglocation;
    }

    public void setImglocation(String imglocation) {
        this.imglocation = imglocation;
    }

    public int getInfluencecost() {
        return influencecost;
    }

    public void setInfluencecost(int influencecost) {
        this.influencecost = influencecost;
    }

    public int getInfluencepool() {
        return influencepool;
    }

    public void setInfluencepool(int influencepool) {
        this.influencepool = influencepool;
    }

    public String getIsrestricted() {
        return isrestricted;
    }

    public void setIsrestricted(String isrestricted) {
        this.isrestricted = isrestricted;
    }

    public int getMilitary() {
        return military;
    }

    public void setMilitary(int military) {
        this.military = military;
    }

    public String getMilitarybonus() {
        return militarybonus;
    }

    public void setMilitarybonus(String militarybonus) {
        this.militarybonus = militarybonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPolitical() {
        return political;
    }

    public void setPolitical(int political) {
        this.political = political;
    }

    public String getPoliticalbonus() {
        return politicalbonus;
    }

    public void setPoliticalbonus(String politicalbonus) {
        this.politicalbonus = politicalbonus;
    }

    public String getRolerestriction() {
        return rolerestriction;
    }

    public void setRolerestriction(String rolerestriction) {
        this.rolerestriction = rolerestriction;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getStrengthbonus() {
        return strengthbonus;
    }

    public void setStrengthbonus(String strengthbonus) {
        this.strengthbonus = strengthbonus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTypeof() {
        return typeof;
    }

    public void setTypeof(String typeof) {
        this.typeof = typeof;
    }

    public String getUnicity() {
        return unicity;
    }

    public void setUnicity(String unicity) {
        this.unicity = unicity;
    }


}



