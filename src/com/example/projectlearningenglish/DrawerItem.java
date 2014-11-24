package com.example.projectlearningenglish;

public class DrawerItem {

	String ItemName;
	int imgResID, itemId;
	
public DrawerItem(int itemId, String itemName, int imgResID) {
	
		this.itemId = itemId;
		this.ItemName = itemName;
		this.imgResID = imgResID;
	}
	
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getImgResID() {
		return imgResID;
	}
	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}
	
	public int getItemId(){
		return itemId;
	}
	
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	
}
