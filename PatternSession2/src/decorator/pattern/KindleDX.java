package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:52
 * To change this template use File | Settings | File Templates.
 */
public class KindleDX implements Ebook
{

    public void powerOn() {
        System.out.println(this.getClass().getName()+" açılıyor..");
    }

    public void powerOff() {
        System.out.println(this.getClass().getName()+" kapatılıyor..");
    }

    public void nextPage() {
        System.out.println(this.getClass().getName()+" sayfa değiştiriliyor..");
    }
}
