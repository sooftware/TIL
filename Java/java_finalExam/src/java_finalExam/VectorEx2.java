package java_finalExam;

import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();
		
		v.add(new Point(1,2));
		v.add(new Point(3,4));
		printVector(v);
	}
	
	public static void printVector(Vector<Point> v){
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
	}
}

class Point{
	int x,y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return "("+x+") , ("+y+")";
	}
}
