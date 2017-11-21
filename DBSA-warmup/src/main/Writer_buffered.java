package main;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer_buffered implements Writer {
	public int MIN = Integer.MIN_VALUE;
	public int MAX = Integer.MAX_VALUE;
	private FileOutputStream os = null;
	private BufferedOutputStream bos = null;
	private DataOutputStream ds = null;
	private String filename;
	private int buffersize = -1;

	public Writer_buffered(int B){
		this.buffersize = B;
		this.filename = "src/data.txt";
	}
	public Writer_buffered(String filename, int B){
		this.buffersize = B;
		this.filename = filename;
	}
	
	public Writer_buffered(){
		this.filename = "src/data.txt";
	}
	public Writer_buffered(String filename){
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
				this.os = new FileOutputStream( new File(this.filename) );
				if(this.buffersize==-1){
					this.bos = new BufferedOutputStream(this.os);
				}
				else{
					this.bos = new BufferedOutputStream(this.os, this.buffersize);
				}
				this.ds = new DataOutputStream(this.bos);
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
