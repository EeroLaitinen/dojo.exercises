package dojo.dependency;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GamerTest {
	
	@Test
	public void gamerTest1() {
		
		// Writes "something" to the standard input
		ByteArrayInputStream inputStream = new ByteArrayInputStream("1,5".getBytes());
		System.setIn(inputStream);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream, true));
		
		new Gamer().play();
		
		String temp = outputStream.toString();
		assertEquals(temp, "fizz buzz: \r\n1 2 Fizz 4 Buzz ");

	}
	
	@Test
	public void gamerTest2() {
		
		// Writes "something" to the standard input
		ByteArrayInputStream inputStream = new ByteArrayInputStream("1,16".getBytes());
		System.setIn(inputStream);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream, true));
		
		new Gamer().play();
		
		String temp = outputStream.toString();
		assertEquals(temp, "fizz buzz: \r\n1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 ");

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void gamerTest3() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("0,1".getBytes());
		System.setIn(inputStream);
		
		new Gamer().play();
	}

}
