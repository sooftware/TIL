package test;

import java.util.LinkedList;

public class Overlap {
	public void plus(LinkedList component){
		for(int i=0;i<component.size();i+=3){
			for(int j=0;j<component.size();j+=3){
				if(component.get(i).equals(component.get(j))){
					String str1=component.get(i+1).toString();
					int num1=Integer.parseInt(str1);
					String str2=component.get(j+1).toString();
					int num2=Integer.parseInt(str2);
					component.set(i+1, num1+num2);
					
					for(int k=0;k<3;k++){
						component.remove(j);
					}
				}
			}
		}
	}
}
