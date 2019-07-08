package decorator.pattern;

/**
 * Created by IntelliJ IDEA.
 * User: usta
 * Date: 22.04.2012
 * Time: 03:47
 * To change this template use File | Settings | File Templates.
 */
public class WithAds extends Decorator{

    protected WithAds(Ebook eKitap) {
        super(eKitap);

    }

    @Override
    public void nextPage() {
        super.nextPage();
        System.out.println("En güzel e-kitaplar sadece 1$");
    }
}
