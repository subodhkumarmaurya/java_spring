
public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ring() {
		System.out.println("Galaxy "+this.getVersionNumber()+" says "+this.getRingTone());
		return null;
	}

	@Override
	public String unlock() {
		System.out.println("Unlocking via fingerprint");
		return null;
	}

	@Override
	public void displayInfo() {
		System.out.println("Galaxy "+this.getVersionNumber()+" from "+this.getCarrier());
		
	}

}
