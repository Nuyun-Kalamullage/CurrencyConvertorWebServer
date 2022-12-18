package com.sltc.soa;
import com.sltc.soa.res.readJson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class currencyRate {
    private String baseCurrency;
    private String secondaryCurrency;
    private double baseCurrencyRate;
    private double secondaryCurrencyRate;
    public static HashMap<String,Double> rateList = new HashMap<>();
    public static HashMap<String,String> rateNames = new HashMap<>();
    public static HashMap<String,String> temp = new HashMap<>();


    public currencyRate(String baseCurrency, String secondaryCurrency) {
        String s1 = readJson.ratesJson;
        Object obj1 = JSONValue.parse(s1);
        JSONObject jsonObject1 = (JSONObject) obj1;
        rateList = (HashMap<String, Double>) jsonObject1.get("rates");
        String s2 = readJson.currenciesJson;
        Object obj2 = JSONValue.parse(s2);
        JSONObject jsonObject2 = (JSONObject) obj2;
        temp = (HashMap<String, String>) jsonObject2.get("names");
        Set<String> values = temp.keySet();
        Collection<String> keys =  temp.values();
        int i=0;
        for (String a :values) {
            rateNames.put(keys.stream().collect(Collectors.toList()).get(i),a);
            i++;
        }
        this.baseCurrency = rateNames.get(baseCurrency);
        this.secondaryCurrency = rateNames.get(secondaryCurrency);

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
