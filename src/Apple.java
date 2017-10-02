
public class Apple {
	
	private String colour;
	private Double weight;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Apple(String colour, Double weight) {
		super();
		this.colour = colour;
		this.weight = weight;
	}
	
	public Apple(String colour,  Double weight, String name) {
		super();
		this.colour = colour;
		this.weight = weight;
		this.name = name;
	}

	public Apple(String name) {
		this.name = name;
	}

	public Apple() {
		super();
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [colour=" + colour + ", weight=" + weight + ", name=" + name + "]";
	}

	public int compareTo(Apple appleTwo) {
		
		
		return 1;
		
	}
	
}
