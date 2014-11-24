package com.example.projectlearningenglish;

public class Exercise {

	private String Ma, cauHoi, A, B, C;	
	private int dapAn;
	public Exercise(String ma, String cauhoi, String a, String b, String c, int dapan) {
		this.Ma = ma;
		this.A = a;
		this.B = b;
		this.C = c;
		this.dapAn = dapan;	
	}
	
	public Exercise(){
		
	}
	
	public String getMa(){
		return Ma;
	}
	public void setMa(String ma){
		this.Ma = ma;
	}
	
	public String getCauHoi(){
		return cauHoi;		
	}
	
	public void setCauHoi(String cauhoi){
		this.cauHoi = cauhoi;
	}
	
	public String getA(){
		return A;
	}
	
	public void setA(String a){
		this.A = a;
	}
	
	public String getB(){
		return B;
	}
	
	public void setB(String b){
		this.B = b;
	}
	
	public String getC(){
		return C;
	}
	
	public void setC(String c){
		this.C = c;
	}
	
	public int getDapAn(){
		return dapAn;
	}
	
	public void setDapAn(int dapan){
		this.dapAn = dapan;
	}
}


