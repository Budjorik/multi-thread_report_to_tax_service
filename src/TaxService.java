import java.util.concurrent.atomic.LongAdder;

public class TaxService {
    private LongAdder totalSum = new LongAdder();

    public void addToTotalSum(int sum) {
        this.totalSum.add(sum);
    }

    public void printTotalSum() {
        System.out.println("Налоговая: общая выручка всех магазинов = " + totalSum + " руб.");
    }

}
