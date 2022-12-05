package com.sltc.soa;
import com.sltc.soa.res.readJson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

public class currencyRate {
    private String baseCurrency;
    private String secondaryCurrency;
    private double baseCurrencyRate;
    private double secondaryCurrencyRate;
    public static HashMap<String,Double> rateList = new HashMap<>();

    public currencyRate(String baseCurrency, String secondaryCurrency) {
        this.baseCurrency = baseCurrency;
        this.secondaryCurrency = secondaryCurrency;
        String s = readJson.rateJson;
        Object obj = JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) obj;
        rateList = (HashMap<String, Double>) jsonObject.get("rates");
        System.out.println(rateList.toString());
        System.out.println(rateList.size());
    }

    public currencyRate() {
        String s = readJson.rateJson;
        Object obj = JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) obj;
        rateList = (HashMap<String, Double>) jsonObject.get("rates");
        System.out.println(rateList.toString());
        System.out.println(rateList.size());
    }

    public void show(){
        System.out.println(baseCurrency+" rate : "+baseCurrencyRate+"\n"+secondaryCurrency+" rate : "+secondaryCurrencyRate+"\n");
    }

    public void updateRate() {
        if (!baseCurrency.equals("USD"))
            baseCurrencyRate = rateList.get(baseCurrency);
        else
            baseCurrencyRate = 1;
        if (!secondaryCurrency.equals("USD"))
            secondaryCurrencyRate = rateList.get(secondaryCurrency);
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
