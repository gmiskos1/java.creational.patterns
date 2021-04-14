package creational.singleton;

public class SingletonEverydayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime singletonRuntime = Runtime.getRuntime();
		
		singletonRuntime.gc();
		
		System.out.println(singletonRuntime);
		
		Runtime anotherInstance = Runtime.getRuntime();
		
		System.out.println(anotherInstance);
		
		if(singletonRuntime == anotherInstance) {
			System.out.println("they are the same instance");
		}

	}

}
