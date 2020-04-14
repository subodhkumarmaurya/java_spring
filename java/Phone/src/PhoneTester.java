
public class PhoneTester {

	public static void main(String[] args) {
		iPhone i = new iPhone("X", 100, "Verizon", "Yoyo it's iPhone pickup");
		Galaxy g = new Galaxy("S1000", 100, "ATT", "HI IT'S ME GALAXY");
		
		i.displayInfo();
		i.ring();
		i.unlock();
		
		g.displayInfo();
		g.ring();
		g.unlock();
	}

}
