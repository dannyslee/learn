package learn.woniuxy.enumdemo;

public enum CarEnum {
	//创建一个Car的枚举，值可以取BMW Jeep、Lincoln、Lamborghini、MercedesBenz,并创建一个方法判断不同的车，输出该车的价格。
	BMW,Jeep,Lincoln,Lamborghini,MercedesBenz;
	public static void main(String[] args) {
		System.out.println(findCar(Jeep));
	}
	
	public static double findCar(CarEnum car) {
		double price=0d;
		switch(car) {
		case BMW:
			price = 4000000d;
			break;
		case Jeep:
			price = 5000000d;
			break;
		case Lincoln:
			price = 6000000d;
			break;
		case Lamborghini:
			price = 7000000d;
			break;
		case MercedesBenz:
			price = 8000000d;
			break;
		default:
			break;
		}
		return price;
	}
}
