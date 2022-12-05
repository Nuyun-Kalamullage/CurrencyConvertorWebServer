package com.sltc.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class webServer {
    @WebMethod
    public double getAmount(String baseCurrency, String secondaryCurrency, double baseAmount){
        currencyRate tempRate = new currencyRate(baseCurrency,secondaryCurrency);
        tempRate.updateRate();
        double result = 0.0;
        result = baseAmount * tempRate.getSecondaryCurrencyRate() / tempRate.getBaseCurrencyRate();
        System.out.println(result);
        return result;
    }
    @WebMethod
    public String getKeyList(){
        String list="";
        Set<String> listCurr = new HashSet<>();
        listCurr = new currencyRate().rateList.keySet();
        for (String s: listCurr) {
            list = list+s+"_";
        }
        //new currencyRate().rateList.keySet()
        System.out.println(list);
        return list;
    }

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/DemoWebService", new webServer());
        new webServer().getKeyList();
    }
}
