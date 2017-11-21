package main;

import java.io.EOFException;

public interface Reader {

	public int read() throws EOFException;

	public void close();

}
