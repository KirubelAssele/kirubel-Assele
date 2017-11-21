package main;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader_buffered implements Reader {
	public int MIN = Integer.MIN_VALUE;
	public int MAX = Integer.MAX_VALUE;
	private FileInputStream is = null;
	private BufferedInputStream bis = null;
	private DataInputStream ds = null;
	private String filename;
	private int buffersize = -1;
	

	public Reader_buffered(int B){
		this.buffersize = B;
		this.filename = "src/data.txt";
	}
	

	public Reader_buffered(String filename, int B){
		this.buffersize = B;
		this.filename = filename;
	}
	
	public Reader_buffered(){
		this.filename = "src/data.txt";
	}
	public Reader_buffered(String filename){
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
				this.is = new FileInputStream( new File(this.filename) );
				if(this.buffersize==-1){
					this.bis = new BufferedInputStream(this.is);}
				else{
					this.bis = new BufferedInputStream(this.is,this.buffersize);
				}
				this.ds = new DataInputStream(this.bis);
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
