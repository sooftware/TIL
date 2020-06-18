package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class Test{
   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      LinkedList number= new LinkedList();
      int finalNum=0;
      Scanner sc = new Scanner(System.in);
      
      System.out.print("INPUT : ");
      String input = sc.next();
      
      for(int i=0;i<input.length();i++){
         list.add(input.charAt(i));
      }
      
      for(int i = 0; i<list.size(); i++){
         String buffer=list.get(i).toString();
         char buf = buffer.charAt(0);
         if(buf>='0' && buf<='9'){
            number.add(buf);
         }else if(buf=='+' || buf=='-' || buf=='*' || buf=='/'){
            String numstr1=number.get(number.size()-1).toString();
            int num1=Integer.parseInt(numstr1);
            String numstr2=number.get(number.size()-2).toString();
            int num2=Integer.parseInt(numstr2);
            if(buf=='+'){
               finalNum=(num1+num2);
               number.removeLast();
               number.removeLast();
               number.add(finalNum);
            }else if(buf=='-'){
               finalNum=(num2-num1);
               number.removeLast();
               number.removeLast();
               number.add(finalNum);
            }else if(buf=='*'){
               finalNum=(num1*num2);
               number.removeLast();
               number.removeLast();
               number.add(finalNum);
            }else if(buf=='/'){
               finalNum=(num2/num1);
               number.removeLast();
               number.removeLast();
               number.add(finalNum);
            }
         }
      }
      System.out.println("Á¤´ä : " +number);
      
   }
}