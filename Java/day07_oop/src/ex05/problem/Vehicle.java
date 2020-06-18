package ex05.problem;

abstract public class Vehicle {
	String str = null;
	public abstract void start();
	public abstract void process();
	public abstract void end();
}


////////////////////
class Bus extends Vehicle{
	public Bus(){
		str = "BUS";
	}
	
	public void start(){
		System.out.println(str);
		System.out.println("정류장에서 출발합니다");
	}
	public void process(){
		System.out.println("빵빠아ㅃ아ㅃㅇ빠아ㅃㅇ");
	}
	
	public void end(){
		System.out.println("정류장에 도착하였습니다");
	}
}

////////////////////////
class Subway extends Vehicle{
	public Subway(){
		str="Subway";
	}
	
	public void start(){
		System.out.println(str);
		System.out.println("역에서 출발합니다");
	}
	public void process(){
		System.out.println("칙칙폭폭 칙칙폭폭");
	}
	
	public void end(){
		System.out.println("역에 도착하였습니다.");
	}
}

///////////////////
class Bicycle extends Vehicle{
	public Bicycle(){
		str="Bicycle";
	}
	public void start(){
		System.out.println(str);
		System.out.println("자전거로 출발합니다");
	}
	public void process(){
		System.out.println("따르릉 따르릉 비켜나세요");
	}
	
	public void end(){
		System.out.println("목적지에 도착하였습니다.");
	}
}


//////////////////////
class Plain extends Vehicle{
	public Plain(){
		str="Plain";
	}
	public void start(){
		System.out.println(str);
		System.out.println("공항에서 출발합니다");
	}
	
	public void process(){
		System.out.println("ㄼ둬ㅏㄱ듀허무갸햠주햐ㅣㅁ걓믾");
	}
	
	public void end(){
		System.out.println("공항에 도착하였습니다.");
	}
}