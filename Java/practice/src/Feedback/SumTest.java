package Feedback;

public class SumTest {
	class MySum /* 1¹ø */extends Object{
		 int first;
		 int second;
		 
		 MySum(int first, int second){
		  this.first = first;
		  this.second = second;
		 }
		 
		 public String toString(){
		  /* 2¹ø */
		  String result = String.valueOf(10+20);
		  return result;
		 }
		 
		 
		 public boolean equals(Object obj){
		  
		  if(obj instanceof MySum){
		   
		   /* 3¹ø */
		   
		   return true;
		  }
		  else{
		   return false;
		  }
		 }
		 
		}
}
