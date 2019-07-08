package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:51
 * To change this template use File | Settings | File Templates.
 */
public class Tester {

    public static void main(String[] args) {

        Ebook sade=new KindleTouch();

        sade.powerOn();
        sade.nextPage();
        sade.powerOff();

        System.out.println("\n------Kablosuz Özellik katalım------\n");

        Ebook withWifi= new WithWifi(sade);
        withWifi.powerOn();
        withWifi.nextPage();
        withWifi.powerOff();

        System.out.println("\n------Reklamlı Özellik katalım------\n");

        Ebook withWifiAndAds=new WithAds(withWifi);
        withWifiAndAds.powerOn();
        withWifiAndAds.nextPage();
        withWifiAndAds.nextPage();
        withWifiAndAds.powerOff();

        System.out.println("\n------Amazon yeni bir E-kitap üretmiş------\n");
        
        Ebook kindleDX=new KindleDX();
        kindleDX.powerOn();
        kindleDX.nextPage();
        kindleDX.powerOff();

        System.out.println("\n------2 Ay sonra Amazon Wifi özellikli KindleDX üretmiş------\n");

        Ebook kindleDxWithWifi=new WithWifi(kindleDX);
        kindleDxWithWifi.powerOn();
        kindleDxWithWifi.nextPage();
        kindleDxWithWifi.powerOff();
        



    }
}
