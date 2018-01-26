package unittest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;

import hw1.DatabaseManager;
import hw1.DestObserver;
//import hw1.DestObserver;
//import hw1.LibraryBook;
//import hw1.SourceObserver;
import hw1.LibraryBook;
import hw1.SourceObserver;

//Typically test execution is arbitrary, this fixes the order
//to run Question1 -> 2 -> 3, which is needed to test the messages
//on singleton creation.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHW1Student {
	
	@Test
	public void Question1()
	{
		System.out.println("------------------------- Question 1 -------------------------");
		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		
		// Tracking your output starts here.
		DatabaseManager dm = DatabaseManager.TheDatabaseManager();
		DatabaseManager dm2 = DatabaseManager.TheDatabaseManager();
		
		//Tracking your output ends here.
		String output = new String(redirectedOut.toByteArray());
		System.setOut(old_out);
		System.out.println(output);

		
		//The objects should be the same instance.
		assertEquals(dm, dm2);
			
		//Make sure the lines output match those in the file.
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ1Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 1 -------------------------");

	}
	
	
	@Test
	public void Question2()
	{
		System.out.println("------------------------- Question 2 -------------------------");

		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		
		//Tracking your output starts here.
		LibraryBook b = new LibraryBook("The Signal and The Noise");
		
		b.returnBook();
		b.shelf();
		b.borrow();
		b.extend();
		b.extend();
		b.extend();
		b.returnBook();
		b.extend();
		b.borrow();
		b.shelf();
		b.extend();
		
		//Tracking your output ends here.
		
		String output = new String(redirectedOut.toByteArray());
		// Go back to standard out.
		System.setOut(old_out);
		System.out.println(output);
		
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ2Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		
		System.out.println(expected_lines.size());
		System.out.println(actual_lines.size());
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 2 -------------------------");
	}

	@Test
	public void Question3() {
		System.out.println("------------------------- Question 3 -------------------------");
		
		//Redirect output
		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		//Tracking your output starts here.
		
		LibraryBook b1 = new LibraryBook("The Signal And The Noise");
		LibraryBook b2 = new LibraryBook("Deep Learning");
		
		SourceObserver a = new SourceObserver("Alice");
		DestObserver b = new DestObserver("Bob");
		
		b1.detach(b);	// 
		b1.attach(a);	// Alice is now watching The Signal And The Noise
		b1.attach(b);	// Bob is now watching The Signal And The Noise
		b2.attach(b);	// Bob is now watching Deep Learning
				
		b1.borrow();		// Leaving State Shelved for State OnLoan
						// Alice OBSERVED The Signal And The Noise LEAVING STATE: UNOBSERVED
						// Bob OBSERVED The Signal And The Noise REACHING STATE: OnLoan
		b1.extend();		// Leaving State OnLoan for State OnLoan
		b1.detach(a);	// Alice is no longer watching The Signal And The Noise
		b1.extend();		// Leaving State OnLoan for State OnLoan
		b1.returnBook();	// Leaving State OnLoan for State Returned 
						// Bob OBSERVED The Signal And The Noise REACHING STATE: Returned
		b1.shelf();		// Leaving State Returned for State Shelved
						// Bob OBSERVED The Signal And The Noise REACHING STATE: Shelved
		b2.shelf();		// hw1.NotAllowedException: Can't use shelf in Shelved state
		b2.borrow();		// Leaving State Shelved for State OnLoan
						// Bob OBSERVED Deep Learning REACHING STATE: OnLoan ---
		b2.attach(a);	// Alice is now watching Deep Learning
		b2.returnBook();	// Leaving State OnLoan for State Returned
						// Bob OBSERVED Deep Learning Reaching STATE: Returned
						// Alice OBSERVED Deep LEarning LEAVING STATE: UNOBSERVED -- OUTPUT OnLoan
		b2.detach(b);	// Bob is no longer watching Deep Learning
		b2.shelf();		// Leaving State Returned for State Shelved
						// Alice OBSERVED Deep LEarning LEAVING STATE: Returned -- OUTPUT OnLoan
		b2.borrow();		// Leaving State Shelved for State OnLoan
						// Alice OBSERVED Deep Learning LEAVING STATE: Shelved -- NO OUTPUT
		
		//Tracking your output ends here.
		
		String output = new String(redirectedOut.toByteArray());
		// Go back to standard out.
		System.setOut(old_out);
		System.out.println(output);
		
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ3Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		
		System.out.println("------------------------- Question 3 -------------------------");

	}

}
