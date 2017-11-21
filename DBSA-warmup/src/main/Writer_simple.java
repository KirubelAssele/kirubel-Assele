package main;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer_simple implements Writer {
	public int MIN = Integer.MIN_VALUE;
	public int MAX = Integer.MAX_VALUE;
	private String filename;
	private FileOutputStream is = null;
	private DataOutputStream ds = null;

	public Writer_simple(){
		this.filename = "src/data.txt";
	}

	public Writer_simple(String filename){
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
	
	public void write(int value){
		if(ds == null){
			try {
				this.is = new FileOutputStream( new File(filename) );
				this.ds = new DataOutputStream(this.is);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				System.err.println("File not found! "+filename);
			e.printStackTrace();
			} 
		}
		try{
			ds.writeInt(value);
		}
		catch (IOException e) {
			System.err.println("Could not read integer from file! "+filename);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
