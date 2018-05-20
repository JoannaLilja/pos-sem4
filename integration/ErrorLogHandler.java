package integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ErrorLogHandler 
{
	private static final String LOG_FILE_NAME = "POSLog.txt";
	private PrintWriter logFile;
	
	public ErrorLogHandler() throws IOException 
	{ 
		logFile = new PrintWriter( new FileWriter(LOG_FILE_NAME), true);
	} 
	
	 /**
	  * Writes a log entry describing a thrown exception.
	  * 
	  * @param exception The exception that shall be logged. 
	  */
	public void logException(Exception exception) 
	{ 
		logFile.println(LocalDateTime.now() +
						", Exception was thrown: " + 
						exception.getMessage());
		exception.printStackTrace(logFile);
	}
	
	private String createTime()
	{ 
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter); 	
	}

	public boolean thisExists()
	{
		return true;
	}
}
