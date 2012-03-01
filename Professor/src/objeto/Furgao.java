package objeto;

public class Furgao extends Utilitario {
	private double volume;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return super.toString() + " Volume:" + volume;
	}
	
}
