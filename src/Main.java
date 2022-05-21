public class Main {

    public static void main(String[] args) throws InterruptedException {
        TaxService taxService = new TaxService();

        Shop shopOne = new Shop(taxService, "Продукты");
        Shop shopTwo = new Shop(taxService, "Косметика");
        Shop shopThree = new Shop(taxService, "Спортивные товары");

        Thread threadOne = new Thread(null, shopOne::sendReportToTaxService, shopOne.getNAME());
        Thread threadTwo = new Thread(null, shopTwo::sendReportToTaxService, shopTwo.getNAME());
        Thread threadThree = new Thread(null, shopThree::sendReportToTaxService, shopThree.getNAME());

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        while (threadOne.isInterrupted() && threadTwo.isInterrupted() && threadThree.isInterrupted());

        taxService.printTotalSum();

        shopOne.printTotalSum();
        shopTwo.printTotalSum();
        shopThree.printTotalSum();

    }

}
