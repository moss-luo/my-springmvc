package com.isoftstone.agiledev.hrdemo.person.app.vo;

public class Card {
	private int id;
	private int personId;
	private String cardNum;
	private String card_issuing_institution;
	private String cardName;
	
	public Card() {
		super();
	}
	public Card(int id, int personId, String cardNum,
			String card_issuing_institution, String cardName) {
		super();
		this.id = id;
		this.personId = personId;
		this.cardNum = cardNum;
		this.card_issuing_institution = card_issuing_institution;
		this.cardName = cardName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCard_issuing_institution() {
		return card_issuing_institution;
	}
	public void setCard_issuing_institution(String card_issuing_institution) {
		this.card_issuing_institution = card_issuing_institution;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	

}
