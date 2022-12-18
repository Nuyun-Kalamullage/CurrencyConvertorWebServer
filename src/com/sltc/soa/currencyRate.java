package com.sltc.soa;

import com.sltc.soa.res.readJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class currencyRate {
    private String baseCurrency;
    private String secondaryCurrency;
    private double baseCurrencyRate;
    private double secondaryCurrencyRate;
    private static final HashMap<String,Double> rateList = new HashMap<>();
    private static final HashMap<String,String> rateNames = new HashMap<>();

    public currencyRate(String baseCurrency, String secondaryCurrency) {
        this.baseCurrency = rateNames.get(baseCurrency);
        this.secondaryCurrency = rateNames.get(secondaryCurrency);
    }

    public currencyRate() {

        List<String> rates = new ArrayList<>(Arrays.asList(readJson.getRates().split(",")));
        List<String> names = new ArrayList<>(Arrays.asList(readJson.getShortNames().split(",")));
        List<String> longNames = new ArrayList<>(Arrays.asList(readJson.getLongNames().split(",")));
        try{
            for (int i =0 ;i<names.size();i++) {
                rateList.put(names.get(i), Double.parseDouble(rates.get(i)));
                rateNames.put(longNames.get(i),names.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void show(){
        System.out.println("Requested Currencies\n"+baseCurrency+" rate : "+baseCurrencyRate+"|\n"+secondaryCurrency+" rate : "+secondaryCurrencyRate+"|");
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

    public double getBaseCurrencyRate() {
        return baseCurrencyRate;
    }

    public double getSecondaryCurrencyRate() {
        return secondaryCurrencyRate;
    }
}
