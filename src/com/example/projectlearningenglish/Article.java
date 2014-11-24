package com.example.projectlearningenglish;

public class Article {
	int articleID;
	
	String articleName, articleUrl;
	public Article(int articleID, String articleUrl, String articleName){
		this.articleID=articleID;
		this.articleName=articleName;
		this.articleUrl=articleUrl;
	}
	
	public Article(){
		
	}
	
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public int getarticleID() {
		return articleID;
	}
	public void setarticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getarticleUrl() {
		return articleUrl;
	}
	public void setarticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	
	
}
