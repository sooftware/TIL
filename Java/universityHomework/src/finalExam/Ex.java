package finalExam;

public class Ex {
	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;	// thread1과 thread2의 sharedArea 변수를 똑같은 객체로
		thread2.sharedArea = obj;	// set해줌으로써 둘이 같은 메모리를 공유하게 한다.
		thread1.start();
		thread2.start();
	}
}

class SharedArea{
	double result;
	boolean isReady;
}

class CalcThread extends Thread{
	SharedArea sharedArea;	// 여기의 sharedArea 는 결국 main의 obj
	public void run(){
		double total = 0.0;
		for(int cnt=1;cnt<100000000;cnt+=2){
			if(cnt / 2 % 2 ==0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		}
		sharedArea.result = total + 4;
		sharedArea.isReady=true; // 계산이 끝났음을 알려주는 부분
		synchronized(sharedArea){
			sharedArea.notify();
		}
	}
}

/* 
하나의 객체에 wait와 notify가 있다면 순서는 wait -> notify가 되어야 한다.

if(sharedArea.isReady != true)이 없는 경우를 생각해보면,
만약에 thread2에서 순간적으로 버퍼링이 걸려서 thread1이 모든 계산을 끝내고
notify()마저 실행을 한 뒤에,  thread2가 실행이 되서 wait()가 실행이 된다면,
프로그램은 '무한대기' 상태에 빠지게된다.
이를 방지하기 위해, 만약 계산이 끝나지 않았다면, if(sharedArea.isReady != true)
이라는 조건을 줘서 wait()하게 한 것일 듯,,

그렇다면 왜 wait()와 notify()는 항상 synchronized 블록안에 있어야 하는가??

wait()를 따로 동기화 블록안에 넣지 않았다고 생각해보면, wait()를 한 뒤, notify()를 해야
하는데, 두 순서가 꼬일 가능성이 있다. 그렇기 때문에, wait() -> notify() 의 순서가 항상
성립하게 하기 위해 synchronized 블록안에 넣는것을 필수조건으로 하여, 
중간에 꼬이는 일을 방지한다. 하지만 이렇게 동기화 블록안에 넣더라도, 모든 경우의 
wait()와 notify()의 순서가 꼬이는 것을 방지할수는 없기 때문에 위의 if문처럼 
개발자가 꼬일 수 있는 상황에 대한 처리를 해주어야한다.

라는 이상 김수환 의견
 */

class PrintThread extends Thread{
	SharedArea sharedArea;// 여기의 sharedArea 는 결국 main의 obj
	public void run(){
		if(sharedArea.isReady != true){
			try{
				synchronized(sharedArea){
					sharedArea.wait();
				}
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println(sharedArea.result);
	}
}