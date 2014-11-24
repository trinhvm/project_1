package com.example.projectlearningenglish;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandle extends SQLiteOpenHelper{

	private static String DB_PATH = "/data/data/com.example.projectlearningenglish/databases/";
	private static String DB_NAME = "EnglishExecise";
	
	private SQLiteDatabase myDatabase;
	
	private final Context myContext;

	public DatabaseHandle(Context context) {
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}


	
//	creates a empty databse onthe system and rewrites it with your own databse
	public void createDataBase() throws IOException{
		boolean dbExist = checkDataBase();
		
		if(dbExist){
			// do nothing - databse already exists
		}else{
			
//			by calling this method and empty database will be created into the default system path
//			of you application so we are gona be alble to overwirte that database with our database
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying databse");
			}
			
		}
	}
	
	private boolean checkDataBase(){
		
		SQLiteDatabase checkDB = null;
		
		try {
			String myPath = DB_PATH + DB_NAME;
			
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
			
		} catch (SQLiteException e) {
			
			//database doesn't exists yet
			
		}
		
		if(checkDB != null){
			
			checkDB.close();
			
		}
		
		return checkDB !=null ? true:false;
	}
	
	private void copyDataBase() throws IOException{
	
		//open you local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);
		
		//path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;
		
		
		//open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);
		
		//transfer bytes from the inputfile to the outputfile 
		byte[] buffer = new byte[1024];
		int length;
		
		while((length = myInput.read(buffer))>0){
			myOutput.write(buffer,0,length);
		}
		
		//close the streams
		
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException{
		//open the databse
		
		String myPath = DB_PATH + DB_NAME;
		 myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		 
	}
	
	@Override
	public synchronized void close(){
		if(myDatabase != null){
			myDatabase.close();
			super.close();
		}
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
	}
	
	
	public ArrayList<Exercise> getContentExcercise(String ma){
		openDataBase();
		ArrayList<Exercise> list = new ArrayList<Exercise>();
		Cursor c = myDatabase.query("exercise", new String[]{"MA","CAUHOI","A","B","C","DAPAN"}, "MA=?", new String[]{ma}, null, null, null);
		if(c.moveToFirst()){
			do{
				Exercise bt = new Exercise();
				bt.setMa(c.getString(0));
				bt.setCauHoi(c.getString(1));
				bt.setA(c.getString(2));
				bt.setB(c.getString(3));
				bt.setC(c.getString(4));
				bt.setDapAn(c.getInt(5));
								
				Log.d("========","MA: "+bt.getMa());
				Log.d("========","CAU HOI: "+bt.getCauHoi());
				Log.d("========","A: "+bt.getA());
				Log.d("========","B: "+bt.getB());
				Log.d("========","C: "+bt.getC());
				Log.d("========","DAP AN: "+bt.getDapAn());
				
				list.add(bt);			
			}while(c.moveToNext());
			c.close();			
		}
		return list;
	}

}
