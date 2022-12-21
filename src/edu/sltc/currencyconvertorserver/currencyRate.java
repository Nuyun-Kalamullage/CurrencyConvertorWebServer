package edu.sltc.currencyconvertorserver;
/**
 * @author Nuyun-Kalamullage
 * @date 21-12-2022
 * @file_name currencyRate
 * @project_Name WebServer
 */

import edu.sltc.currencyconvertorserver.res.currenciesData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class currencyRate {
    private String sourceCurrency; //make string to store base currency.
    private String targetCurrency; //make string to store secondary currency.
    private double sourceCurrencyRate; //make double to store base currency rate.
    private double targetCurrencyRate; //make string to secondary base currency rate.
    private static final HashMap<String,Double> rateList = new HashMap<>(); //make HashMap to store currency-short_names vs currency-rates.
    private static final HashMap<String,String> rateNames = new HashMap<>(); //make HashMap to store currency-long_names vs currency-short_names.

    public currencyRate(String sourceCurrency, String targetCurrency) { // make constructor to set the two variable.
        this.sourceCurrency = rateNames.get(sourceCurrency);
        this.targetCurrency = rateNames.get(targetCurrency);
    }

    public currencyRate() { // make constructor to load two hashmaps.

        List<String> rates = new ArrayList<>(Arrays.asList(currenciesData.getRates().split(","))); //Split the single String as a String-list of rates.
        List<String> names = new ArrayList<>(Arrays.asList(currenciesData.getShortNames().split(","))); //Split the single String as a String-list of short-names.
        List<String> longNames = new ArrayList<>(Arrays.asList(currenciesData.getLongNames().split(","))); //Split the single String as a String-list of long-names.
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
        System.out.println("Requested Currencies\n"+ sourceCurrency +" rate : "+ sourceCurrencyRate +"|\n"+ targetCurrency +" rate : "+ targetCurrencyRate +"|");
    }

    public void updateRate() { // update the currency-rates that user given.
        if (!sourceCurrency.equals("USD")) {
            Object base = rateList.get(sourceCurrency);
            sourceCurrencyRate = (double) base;
        }
        else
            sourceCurrencyRate = 1;

        if (!targetCurrency.equals("USD")) {
            Object secondary = rateList.get(targetCurrency);
            targetCurrencyRate = (double) secondary;
        }
        else
            targetCurrencyRate = 1;
    }
    public Double getAmount(double sourceAmount){
        return sourceAmount * targetCurrencyRate / sourceCurrencyRate;
    }

    public double getSourceCurrencyRate() {
        return sourceCurrencyRate;
    } // getters for base currency rate.

    public double getTargetCurrencyRate() {
        return targetCurrencyRate;
    } // getters for secondary currency rate.
}
