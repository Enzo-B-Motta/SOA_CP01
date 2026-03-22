package br.com.fiap.winery;

import java.net.URL;

import javax.xml.namespace.QName;

import br.com.fiap.winery.client.WineWarningService;
import jakarta.xml.ws.Service;

public class ApplicationClient2 {

    public static void main(String[] args) {
        try {
            URL url2 = new URL("http://localhost:8086/WineWarningService?wsdl");

            QName qName2 = new QName(
                    "http://winery.fiap.com.br/",
                    "WineWarningServiceImplementationService"
            );

            Service service2 = Service.create(url2, qName2);

            WineWarningService wineWarningService =
                    service2.getPort(WineWarningService.class);

            String warn = wineWarningService.sendWarn();
            System.out.println(warn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}