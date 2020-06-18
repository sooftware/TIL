package androidEx;

public class MainEntry{
	public static void main(String[] args) {
		Animal ani = new Animal();
		
		System.out.println("=====≥ª∫Œ≈¨∑°Ω∫ ø¨Ω¿=====\n");
		
        iAnimal animal =
                (new iAnimal(){
                    public void sound(){
                        System.out.println("æÓ»Ô");
                    }
                });
        animal.sound();

        animal=
                (new iAnimal(){
                    public void sound(){
                        System.out.println("∏€∏€");
                    }
                });

        animal.sound();
        
        /////////////
        
        System.out.println("\n=====¿¸∑´∆–≈œ ø¨Ω¿=====\n");
        
        ani.doSound();
        ani.setAnimal(new Dog());
        ani.doSound();
        ani.setAnimal(new Tiger());
        ani.doSound();
	}
}

class Dog implements iAnimal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("∏€∏€");
	}
}

class Tiger implements iAnimal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("æÓ»Ô");
	}
}

class Animal{
	private iAnimal animal;

	public void doSound(){
		if(animal==null){
			System.out.println("nothing");
		}else{
			animal.sound();
		}
	}
	
	/* SET  */

	public void setAnimal(iAnimal animal) {
		this.animal = animal;
	}
	
	/* SET */
}