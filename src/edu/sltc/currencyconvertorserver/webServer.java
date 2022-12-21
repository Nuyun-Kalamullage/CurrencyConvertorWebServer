package edu.sltc.currencyconvertorserver;
/**
 * @author Nuyun-Kalamullage
 * @date 21-12-2022
 * @file_name WebServer
 * @project_Name WebServer
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class webServer {
    @WebMethod
    public double convert(String sourceCurrency, String targetCurrency, double amountInSourceCurrency){ // this is the method that client resetting to the server.
        currencyRate tempRate = new currencyRate(sourceCurrency,targetCurrency);
        tempRate.updateRate();
        double result = 0.0;
        result = tempRate.getAmount(amountInSourceCurrency);
        tempRate.show();
        System.out.println("Sending calculated "+result+" amount to client.\n");

        return result; //return the calculated amount to user.
    }
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/SoapWebService", new webServer()); //Hosting the wsdl file in given url for communicating with the client.
        new currencyRate(); // make a new object to get the hashmap done.
        System.out.println("=============== Sever Started ===============");
    }
}
