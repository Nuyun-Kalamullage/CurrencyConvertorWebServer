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
        tempRate.show();
        System.out.println("Sending calculated "+result+" amount to client.\n");

        return result;
    }
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/SoapWebService", new webServer());
        new currencyRate();
    }
}
