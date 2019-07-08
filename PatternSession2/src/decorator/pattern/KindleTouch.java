package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:52
 * To change this template use File | Settings | File Templates.
 */
public class KindleTouch implements Ebook {

    public void powerOn() {
        System.out.println("com.usta.kompozisyon.KindleTouch açılıyor..");
    }

    public void powerOff() {
        System.out.println("com.usta.kompozisyon.KindleTouch kapatılıyor..");
    }

    public void nextPage() {
        System.out.println("com.usta.kompozisyon.KindleTouch sayfa değiştiriliyor..");
    }
}
