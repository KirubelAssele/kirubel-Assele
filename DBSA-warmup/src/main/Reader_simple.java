package main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader_simple {
	public int MIN = Integer.MIN_VALUE;
	public int MAX = Integer.MAX_VALUE;
	private FileInputStream is = null;
	private DataInputStream ds = null;
	private String filename;

	public Reader_simple(){
		this.filename = "src/data.txt";
	}
	public Reader_simple(String filename){
		this.filename = filename;
	}
	
	public void close(){
		try {
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int read(){
		int value = 0;
		if(ds == null){
			try {
				this.is = new FileInputStream( new File(filename) );
				this.ds = new DataInputStream(this.is);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				System.err.println("File not found! "+filename);
			e.printStackTrace();
			} 
		}
		try{
			value = ds.readInt();
		}
		catch (IOException e) {
			System.err.println("Could not read integer from file! "+filename);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
