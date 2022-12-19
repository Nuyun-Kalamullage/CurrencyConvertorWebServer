package edu.sltc.currencyconvertorserver;

import edu.sltc.currencyconvertorserver.res.readJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class currencyRate {
    private String baseCurrency; //make string to store base currency.
    private String secondaryCurrency; //make string to store secondary currency.
    private double baseCurrencyRate; //make double to store base currency rate.
    private double secondaryCurrencyRate; //make string to secondary base currency rate.
    private static final HashMap<String,Double> rateList = new HashMap<>(); //make HashMap to store currency-short_names vs currency-rates.
    private static final HashMap<String,String> rateNames = new HashMap<>(); //make HashMap to store currency-long_names vs currency-short_names.

    public currencyRate(String baseCurrency, String secondaryCurrency) { // make constructor to set the two variable.
        this.baseCurrency = rateNames.get(baseCurrency);
        this.secondaryCurrency = rateNames.get(secondaryCurrency);
    }

    public currencyRate() { // make constructor to load two hashmaps.

        List<String> rates = new ArrayList<>(Arrays.asList(readJson.getRates().split(","))); //Split the single String as a String-list of rates.
        List<String> names = new ArrayList<>(Arrays.asList(readJson.getShortNames().split(","))); //Split the single String as a String-list of short-names.
        List<String> longNames = new ArrayList<>(Arrays.asList(readJson.getLongNames().split(","))); //Split the single String as a String-list of long-names.
        try{ // Add a try-catch block for prevent unhandled exceptions.
            for (int i =0 ;i<names.size();i++) {
                rateList.put(names.get(i), Double.parseDouble(rates.get(i)));
                rateNames.put(longNames.get(i),names.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void show(){ // make function to display the user requested currency rates.
        System.out.println("Requested Currencies\n"+baseCurrency+" rate : "+baseCurrencyRate+"|\n"+secondaryCurrency+" rate : "+secondaryCurrencyRate+"|");
    }

    public void updateRate() { // update the currency-rates that user given.
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
    } // getters for base currency rate.

    public double getSecondaryCurrencyRate() {
        return secondaryCurrencyRate;
    } // getters for secondary currency rate.
}
