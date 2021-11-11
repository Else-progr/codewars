package Currency;

import java.math.*;

public class Currency {

    BigDecimal priceHamburgers;
    BigDecimal priceMilkshakes;

    static BigDecimal hamburgers(BigDecimal n){
        BigDecimal costs = new BigDecimal("5.50");
        return n.multiply(costs);
    }

    static BigDecimal milkshakes(BigDecimal n){
        BigDecimal costs = new BigDecimal("2.86");
        return n.multiply(costs);
    }

    static BigDecimal totalBeforeTaxes(BigDecimal countHamburgers, BigDecimal countMilkshakes){
        return hamburgers(countHamburgers).add(milkshakes(countMilkshakes));
    }


    public static void main(String[] args) {

        BigDecimal countHamburgers = new BigDecimal("4000000000000000");
        BigDecimal countMilkshakes = new BigDecimal("2");
        BigDecimal taxes = new BigDecimal("0.0765");

        BigDecimal priceBeforeTaxes = hamburgers(countHamburgers).add(milkshakes(countMilkshakes));
        BigDecimal tax = priceBeforeTaxes.multiply(taxes);
        BigDecimal totalWithTaxes = priceBeforeTaxes.add(tax);

        var round = RoundingMode.HALF_UP;

//        System.out.println(new BigDecimal("0.0015").setScale(3,round));
        System.out.println("total price before tax: " + priceBeforeTaxes.setScale(2,round));
        System.out.println("tax: " + tax.setScale(2,round));
        System.out.println("total with tax: " + totalWithTaxes.setScale(2,round));
    }

}
