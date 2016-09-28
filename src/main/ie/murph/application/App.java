package main.ie.murph.application;

import java.util.Scanner;
import java.util.logging.Logger;

import main.ie.murph.view.RunUserInteraction;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final RunUserInteraction runUserInteraction = new RunUserInteraction();
	
	public static void main(String[] args)
	{
		LOGGER.info("+main()");
		
		//Execute the application
		runUserInteraction.run();
		//thread(new RunUserInteraction(), false);
		
		//Ask user to Run the search application again ?
		askToContinue();
		
		System.exit(0);
	}
	
	public static void thread(Runnable runnable, boolean daemon)
	{
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}
	
	// Method to ask the user if they want to try the application again.
	private static void askToContinue()
	{
		//System.out.println("Do you want to run it again: (y/n)");
		String s_continue = SCANNER.nextLine();
		if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
		{
			// Reseting main thread and Starting again..
			main(new String[0]);
		}
		else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
		{
			System.out.println("");
			LOGGER.info("Good bye!");
			System.exit(0);
		}
		else
			System.out.println("");
			LOGGER.info("Do you want to run it again: (y/n)");
			askToContinue();
			
	}
	
}
