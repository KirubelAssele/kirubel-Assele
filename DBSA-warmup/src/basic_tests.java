import main.Reader;
import main.Reader_buffered;
import main.Reader_mapped;
import main.Reader_simple;
import main.Writer;
import main.Writer_buffered;
import main.Writer_mapped;
import main.Writer_simple;

import java.io.EOFException;

import junit.framework.TestCase;


public class basic_tests extends TestCase {

	public static void test_simple() throws EOFException{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer w = new Writer_simple("newfile1.txt");
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader r2 = new Reader_simple("newfile1.txt");
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}
	

	public static void test_buffered() throws EOFException{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer w = new Writer_buffered("newfile2.data");
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader r2 = new Reader_buffered("newfile2.data");
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}

	public static void test_buffered_size_given() throws EOFException{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer w = new Writer_buffered("newfile3.data", 8);
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader_buffered r2 = new Reader_buffered("newfile3.data", 4);
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}
	

	public static void test_mapped() throws EOFException{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer w = new Writer_mapped("newfile4.data");
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader r2 = new Reader_mapped("newfile4.data");
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}
	
	
	
	public static void test_data() throws EOFException{
		read_this("increasing_data.txt");
		read_this("not_increasing_data.txt");
		read_this("increasing_from_min.txt");
		read_this("increasing_to_max.txt");
		
	}
	
	private static void read_this(String filename){
		Reader r2 = new Reader_simple(filename);
		try{
			while(true){
				int new_int = r2.read();
				System.out.println(new_int);
				//your code here
			}
		}
		catch (EOFException e){
			System.out.println("End of file!");
			//end of file exception	
		}
		
		r2.close();
	}	

}
