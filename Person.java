package workshopW1;

public class Person {
	
	protected String name;
	protected String adress;
	
	public Person(String name, String adress) {
		this.name = name;
		this.adress = adress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String toString() {
		return "Name: " + this.name + " Adress: " + this.adress;
	}
	
}

