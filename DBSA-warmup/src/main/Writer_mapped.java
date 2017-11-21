package main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Writer_mapped implements Writer {
	public int MIN = Integer.MIN_VALUE;
	public int MAX = Integer.MAX_VALUE;
	private String filename;
	int buffersize=8000;
	private MappedByteBuffer mbb = null;
	RandomAccessFile ra = null;

	public Writer_mapped(String filename, int buffer){
		this.filename = filename;
		this.buffersize = buffer;
	}
	
	public Writer_mapped(String filename){
		this.filename = filename;
		
	}
	
	public Writer_mapped(){
		this.filename = "src/data.txt";
	}

	public void write(int i) throws BufferOverflowException {
		if(this.mbb == null){
			try {
				this.ra = new RandomAccessFile(filename, "rw");
				this.mbb = ra.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, this.buffersize);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("File not found! "+filename);
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("IO error when mapping "+filename);
				e.printStackTrace();
			}
		}
		try{
			mbb.putInt(i);
		} catch (BufferOverflowException e){
			throw e;
		}
		
		// TODO Auto-generated method stub

	}

	public void close() {
		try {
			ra.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Could not close "+filename);
			e.printStackTrace();
		}
	}

}
