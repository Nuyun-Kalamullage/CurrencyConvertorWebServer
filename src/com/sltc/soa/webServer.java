package com.sltc.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

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

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/DemoWebService", new webServer());
//        currencyRate tempRate = new currencyRate("Sri Lankan Rupee","Barbadian Dollar");
//        tempRate.show();
//        Double rate = tempRate.rateList.get("BBD");
//        System.out.println(rate);

    }
}
