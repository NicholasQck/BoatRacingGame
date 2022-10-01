
public class RiverObject {
	//attributes
	private int position;
	private int effect;
	
	
	//constructors
	public RiverObject() {
		position = 0;
		effect = 0;
	}
	
	//setters/getters
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getEffect() {
		return effect;
	}
	
	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	//print symbol on river
	public void printSymbol() {
		System.out.print("River object");
	}
	
}
