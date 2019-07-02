package adapterpattern.charging.exp;

public class USTurkishPowerAdapter implements PowerSource {
	private USPowerSource usPowerSource;

	public USTurkishPowerAdapter(USPowerSource usPowerSource) {
		this.usPowerSource = usPowerSource;
		convert110To220(usPowerSource);
	}

	public void providePowerAt220V() {
		usPowerSource.providePowerAt110V();
	}

	@Override
	public void turnOn() {
		usPowerSource.pushSwitch();
	}

	@Override
	public void turnOff() {
		usPowerSource.pushSwitch();
	}

	private void convert110To220(USPowerSource usPowerSource) {
		System.out.println("USTurkishPowerAdapter: Converting from USPowerSource to provide 220V");
	}
}
