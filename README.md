# Server-Side of Currency Convertor project using SOAP Web-Service
>completed date: 20-12-2022

This package includes,
>* 3 Java Files  ( webSever class, currencyRate class and readJson class )
>* 2 JSON files  ( currencies.json & rates.json )

in this package,
you can select the amount, Base currency and Secondary currency and after clicking or enter the given fields you can get the result as a double data type in the website.

HOW TO RUN
===========
Here are the steps,
>* Run the server package (This package)
>* Run the client package 
>* check the port that website hosted on ( In here, it is 8080. you change it in "application.properties" in the client package. )
>* Open any web browser and simply type "localhost:8080" (I type here, "8080" because port number is 8080.)
>* eventually you will re-directed to the currency.html file.
>* If you enter wrong address after port number you will re-directed to 404.html file.

How to Compile
=============
If you are a developer you have to make changes in server package, and you have to generate the Stub folder to client package.
firstly, this server package runs with <b>java 1.8 jdk</b> because Soap web-services needed libraries on the java 1.8 version.
Further, If you are running on the IntelliJ idea you can simply download the jdk using project structure and select the "corretto-1.8".

><b>After running the server</b> package then you have to generate the stub folder using "wsimport.exe",
for this you have to find the jdk downloaded directory for the bin file then simply run this command in your CMD or your IDE terminal.

should be considered ( If your directory folder names have more than one word you have to run the command in CMD otherwise you can run it on your IDE(IntelliJ Idea) )

>[wsimport.exe directory] -keep -d [directory that you want to generate the codes] -p [package name] [url for wsdl file]
 
Here is the example:
><b>"C:\Users\HP\.jdks\corretto-1.8.0_352\bin\wsimport.exe" -keep -d ..\CurenncyConvertorClient\src\main\java\Stub -p stub http://localhost:8888/SoapWebService?wsdl



Thank you!
=============