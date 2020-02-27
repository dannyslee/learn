package com.woniuxy.homework;

public enum CarEnum {
	BMW, JEEP, LINCOLN, LAMBORGHINI, MERCEDESBENZ;
	public static double checkPrice(CarEnum car) {
		double price = 0.0;
		switch (car) {
		case BMW:
			price=300000;
			break;
		case JEEP:
			price=200000;
			break;
		case LINCOLN:
			price=2000000;
			break;
		case LAMBORGHINI:
			price=3500000;
			break;
		case MERCEDESBENZ:
			price=300000;
			break;
		}
		return price;
	}
	public static void main(String[] args) {
		System.out.println(checkPrice(CarEnum.LAMBORGHINI));
	}
}
