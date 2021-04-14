package creational.builder;

public class LunchOrderBuilderDemo {

	public static void main(String args[]) {
		
		LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();
		
		builder.bread("Wheat").dressing("Mayo").meat("Turkey");
		
		LunchOrderBuilder lunchOrder = builder.build();
		
		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getDressing());
		System.out.println(lunchOrder.getMeat());	
	}
}
