package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:47
 * To change this template use File | Settings | File Templates.
 */
public class WithWifi extends Decorator{

    protected WithWifi(Ebook eKitap) {
        super(eKitap);
    }

    @Override
    public void powerOn() {
        super.powerOn();
        System.out.println("WiFi taranıyor...");
    }
}
