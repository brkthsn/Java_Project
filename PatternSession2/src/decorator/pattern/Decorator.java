package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:44
 * To change this template use File | Settings | File Templates.
 */
public abstract class Decorator implements Ebook {

    Ebook ebook;

    protected Decorator(Ebook ebook) {
        this.ebook = ebook;
    }

    public void powerOn() {
        ebook.powerOn();
    }

    public void powerOff() {
        ebook.powerOff();
    }

    public void nextPage() {
       ebook.nextPage();
    }
}
