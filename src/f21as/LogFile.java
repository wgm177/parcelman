package f21as;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LogFile {
	private static LogFile instance = null;
	private ArrayList<String> logList = new ArrayList<String>();
	private String fileName = "logfile.txt";
	protected LogFile(){
		
	
	}
	
	public static LogFile getInstance(){
		if(instance == null){
			instance = new LogFile();
			
		}
		return instance;
	}
	
	public void addLog(String log) 
	{
		
		this.logList.add(log);
		
	}
	
	public void saveLogList()
	{
		StringBuilder sb = new StringBuilder();
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new BufferedWriter( new FileWriter(fileName, true)));
			for(String s: this.logList)
			{
				sb = sb.append(s + "\n");
			}
			
			pw.write(sb.toString());
		}
		catch (IOException e){
			System.out.println("Error in writing to logfile");
		}
		finally{
			pw.close();
		}
	}
	

}