package learn.woniuxy.enumdemo;

public enum EnumHomework {
	Lenovo("Lemovo","4999"),Apple("Apple","9999"),Asus("Asus","5999");
	private String name;
	private String price;
	
	private EnumHomework(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
}
