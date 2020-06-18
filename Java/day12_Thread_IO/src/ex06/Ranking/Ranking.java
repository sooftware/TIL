package ex06.Ranking;
import java.util.*;
import java.io.*;

public class Ranking {
	protected int rank;
	protected String ID;
	protected int time;
	Scanner sc = new Scanner(System.in);
	
	protected Ranking() throws FileNotFoundException{
		rank=1;
		ID="SooHwan";
		time=0;
		OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/¼öÈ¯/Workspace/day12_Thread,IO/Ranking.txt");
	}
	
	protected void input(OutputStream os){
		
	}
	
	/* SET GET */
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	/* SET GET */
}
