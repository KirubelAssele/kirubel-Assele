import main.Writer;
import main.Writer_simple;

import java.io.EOFException;

import junit.framework.TestCase;


public class sorted_tests extends TestCase {

	public static void test_increasing() throws EOFException{
		Writer w = new Writer_simple("increasing_data.txt");
		for(int i=-64;i<64;i+=1){
			w.write(i);
		}
		w.close();
		
		
		assertTrue(true); //Here we will write the test that will check it
	}

	public static void test_not_increasing() throws EOFException{
		Writer w = new Writer_simple("not_increasing_data.txt");
		for(int i=-64;i<63;i+=1){
			w.write(i);
		}
		w.write(13);
		w.close();
		
		
		assertFalse(false); //Here we will write the test that will check it
	}
	
	public static void test_increasing_min() throws EOFException{
		int min = Integer.MIN_VALUE;
		Writer w = new Writer_simple("increasing_from_min.txt");
		for(int i=min;i<min+128;i+=1){
			w.write(i);
		}
		w.close();
		
		
		assertTrue(true); //Here we will write the test that will check it
	}

	public static void test_increasing_max() throws EOFException{
		int max = Integer.MAX_VALUE;
		Writer w = new Writer_simple("increasing_to_max.txt");
		for(int i=max-128;i<max;i+=1){
			w.write(i);
		}
		w.close();
		
		
		assertTrue(true); //Here we will write the test that will check it
	}
	
	
}
