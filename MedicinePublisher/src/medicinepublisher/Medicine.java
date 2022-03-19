package medicinepublisher;

public class Medicine {
	private int id;
	private String name;
	private String brand;
	private String color;
	private String weight;
	
	
	public Medicine() {
		super();
	}

	public Medicine(int id, String name, String brand, String color, String weight) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}
