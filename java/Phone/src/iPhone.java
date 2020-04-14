
public class iPhone extends Phone implements Ringable {
	public iPhone(String versionNumber, int batteryPercentage,String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		System.out.println("iPhone "+this.getVersionNumber()+" says "+this.getRingTone());
		return null;
	}

	@Override
	public String unlock() {
		System.out.println("Unlocking via facial recognition");
		return null;
	}

	@Override
	public void displayInfo() {
		System.out.println("iPhone "+this.getVersionNumber()+" from "+this.getCarrier());
		
	}

}
