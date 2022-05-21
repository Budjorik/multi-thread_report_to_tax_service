import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final String NAME;
    private final int MIN_NUMBER_OF_CASH_RECEIPT = 5;
    private final int MAX_NUMBER_OF_CASH_RECEIPT = 50;
    private final int MAX_SUM_OF_CASH_RECEIPT = 4_000;
    private List<Integer> cashReceipts = setCashReceipts();
    TaxService taxService;

    public Shop(TaxService taxService, String NAME) {
        this.taxService = taxService;
        this.NAME = NAME;
    }

    public String getNAME() {
        return this.NAME;
    }

    public List<Integer> setCashReceipts() {
        List<Integer> cashReceipts = new ArrayList<>();
        int numberOfCashReceipt = setThreshold(MIN_NUMBER_OF_CASH_RECEIPT, MAX_NUMBER_OF_CASH_RECEIPT);
        for (int i = 0 ; i < numberOfCashReceipt ; i++) {
            int newCashReceipt = setThreshold(0, MAX_SUM_OF_CASH_RECEIPT);
            cashReceipts.add(newCashReceipt);
        }
        return cashReceipts;
    }

    public void printCashReceipts() {
        System.out.println("Суммы чеков магазина '" + NAME + "' за день:");
        for (int i = 0 ; i < cashReceipts.size() ; i++) {
            System.out.print(cashReceipts.get(i));
            if (i < (cashReceipts.size() - 1)) {
                System.out.println(", ");
            } else {
                System.out.println(".\n");
            }
        }
    }

    public void printTotalSum() {
        int totalSum = 0;
        for (int i = 0 ; i < cashReceipts.size() ; i++) {
            totalSum += cashReceipts.get(i);
        }
        System.out.println("Общая сумма чеков магазина '" + NAME + "' за день = " + totalSum + " руб.");
    }

    public void sendReportToTaxService() {
        for (int i = 0 ; i < cashReceipts.size() ; i++) {
            taxService.addToTotalSum(cashReceipts.get(i));
        }
        System.out.println("Магазин '" + NAME + "' направил отчет в налоговую.");
    }

    private int setThreshold(int lowerThreshold, int upperThreshold) {
        upperThreshold -= lowerThreshold;
        int count = (int) (Math.random() * ++upperThreshold) + lowerThreshold;
        return count;
    }

}
