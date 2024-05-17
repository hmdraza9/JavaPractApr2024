package test.interfaces.java8;

public class SimulatorClass implements Inter_One, Inter_Two {

	@Override
	public void defMethod() {
		Inter_One.super.defMethod();
		Inter_Two.super.defMethod();
	}

	
	
}
