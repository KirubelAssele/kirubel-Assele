import main.Reader_buffered;
import main.Reader_simple;
import main.Writer_buffered;
import main.Writer_simple;
import junit.framework.TestCase;


public class basic_tests extends TestCase {

	public static void test_simple(){
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer_simple w = new Writer_simple("newfile.data");
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader_simple r2 = new Reader_simple("newfile.data");
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}
	

	public static void test_buffered(){
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer_buffered w = new Writer_buffered("newfile.data");
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader_buffered r2 = new Reader_buffered("newfile.data");
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}

	public static void test_buffered_size_given(){
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		Writer_buffered w = new Writer_buffered("newfile.data", 8);
		w.write(16);
		w.write(128);
		w.write(-13);
		w.write(min);
		w.write(max);
		w.close();
		
		Reader_buffered r2 = new Reader_buffered("newfile.data", 4);
		assertTrue(r2.read()==16);
		assertTrue(r2.read()==128);
		assertTrue(r2.read()==-13);
		assertTrue(r2.read()==min);
		assertTrue(r2.read()==max);
		r2.close();
	}
	
}
