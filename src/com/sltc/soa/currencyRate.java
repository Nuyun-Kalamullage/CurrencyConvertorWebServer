package com.sltc.soa;
import com.sltc.soa.res.readJson;

import java.util.*;

public class currencyRate {
    private String baseCurrency;
    private String secondaryCurrency;
    private double baseCurrencyRate;
    private double secondaryCurrencyRate;
    public static HashMap<String,Double> rateList = new HashMap<>();
    public static HashMap<String,String> rateNames = new HashMap<>();

    public currencyRate(String baseCurrency, String secondaryCurrency) {

        this.baseCurrency = rateNames.get(baseCurrency);
        this.secondaryCurrency = rateNames.get(secondaryCurrency);
    }

    public currencyRate() {
        List<Double> rates = new ArrayList<Double>();
        List<String> temporary = new ArrayList<String>(Arrays.asList(readJson.rates.split(",")));
        for (String r :temporary) {
            rates.add(Double.parseDouble(r));
        }
        List<String> names = new ArrayList<String>(Arrays.asList(readJson.shortNames.split(",")));
        List<String> longNames = new ArrayList<String>(Arrays.asList(readJson.longNames.split(",")));
        for (int i =0 ;i<names.size();i++) {
            rateList.put(names.get(i), rates.get(i));
            rateNames.put(longNames.get(i),names.get(i));
        }
    }

    public void show(){
        System.out.println(baseCurrency+" rate : "+baseCurrencyRate+"\n"+secondaryCurrency+" rate : "+secondaryCurrencyRate+"\n");
    }

    public void updateRate() {
        if (!baseCurrency.equals("USD")) {
            Object base = rateList.get(baseCurrency);
            baseCurrencyRate = (double) base;
        }
        else
            baseCurrencyRate = 1;

        if (!secondaryCurrency.equals("USD")) {
            Object secondary = rateList.get(secondaryCurrency);
            secondaryCurrencyRate = (double) secondary;
        }
        else
            secondaryCurrencyRate = 1;
    }
    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    public double getBaseCurrencyRate() {
        return baseCurrencyRate;
    }

    public void setBaseCurrencyRate(double baseCurrencyRate) {
        this.baseCurrencyRate = baseCurrencyRate;
    }

    public double getSecondaryCurrencyRate() {
        return secondaryCurrencyRate;
    }

    public void setSecondaryCurrencyRate(double secondaryCurrencyRate) {
        this.secondaryCurrencyRate = secondaryCurrencyRate;
    }
}
