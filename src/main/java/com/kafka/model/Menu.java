package com.kafka.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kafka.producer.KafkaProducer;

public class Menu {
	
	private String itemName;
	private String itemDescription;
	private String itemPrice;
	private String itemQuantity;
	private String itemCategory;
	
	public Menu(JsonElement menuItem) {
		String in = menuItem.getAsJsonObject().get("itemName").toString();
		String id = menuItem.getAsJsonObject().get("itemDescription").toString();
		String ip = menuItem.getAsJsonObject().get("itemPrice").toString();
		String iq = menuItem.getAsJsonObject().get("itemQuantity").toString();
		String ic = menuItem.getAsJsonObject().get("itemCategory").toString();
		
		this.itemName = in.substring(1, in.length() - 1);
		this.itemDescription = id.substring(1, id.length() - 1);
		this.itemPrice = ip.substring(1, ip.length() - 1);
		this.itemQuantity = iq.substring(1, iq.length() - 1);
		this.itemCategory = ic.substring(1, ic.length() - 1);
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}
	public String getItemPrice() {
		return itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}
}
