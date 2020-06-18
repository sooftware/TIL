package ex02.runnable;

public class UserRunnable implements Runnable{
	String name;
	
	
	public UserRunnable(String name){
		this.name = name;
	}
	
	public void run(){
			for(int i=1;i<=10;i++){
				if(i==7){
					try{
						Thread.sleep(500);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println(name);
				}
				System.out.println();
			}	
	}
}