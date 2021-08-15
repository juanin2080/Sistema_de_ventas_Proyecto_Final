/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author juana
 */
public class Aci_Servicio_Web {

    private Gson gson = new Gson();

    public static void consumir() throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("https://test.oppwa.com/v1/checkouts");
        URLConnection urlConecction = url.openConnection();
        urlConecction.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible:MSIE 6.0: Windows NT 5.1)");
        InputStream input = new BufferedInputStream(urlConecction.getInputStream());
    }

    private String llenarCeros(String valor) {
        String aux = "";
        boolean band = false;
        for (int i = 0; i < valor.length(); i++) {
            if (band) {
                aux += valor.charAt(i);
            }
            if (valor.charAt(i) == '.') {
                band = true;
            }
        }
        if (aux.length() < 2) {
            valor = valor + "0";
        }
        return valor;
    }

    private HashMap request(Double pago, String tipo) throws IOException {
        URL url = new URL("https://test.oppwa.com/v1/checkouts");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer OGE4Mjk0MTc1ZDYwMjM2OTAxNWQ3M2JmMDBlNTE4MGN8ZE1xNU1hVEQ1cg==");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        pago = (Math.round(pago * 100.00) / 100.00);

        String data = ""
                + "entityId=8a8294175d602369015d73bf009f1808"
                + "&amount=" + llenarCeros(String.valueOf(pago))
                + "&currency=USD"
                + "&paymentType=" + tipo;

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();
        int responseCode = conn.getResponseCode();
        InputStream is;

        if (responseCode >= 400) {
            is = conn.getErrorStream();
        } else {
            is = conn.getInputStream();
        }
        String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        HashMap mapa = gson.fromJson(result, HashMap.class);
        System.out.println(responseCode);
        if (responseCode == 200) {
            String html = "<html><head>" + "<script src=\"https://test.oppwa.com/v1/paymentWidgets.js?checkoutId=" + mapa.get("id") + "\"></script></head><body>";
            html += "<form action=\"http://localhost/pago/result.html\"class=\"paymentWidgets\" data-brands=\"MASTER VISA\"></form>";
            html += "</body><html>";
            FileWriter htmlPago = new FileWriter("C:\\xampp\\htdocs\\pago\\pago.html");
            htmlPago.write(html);
            htmlPago.close();

        }

        return mapa;
    }

    private HashMap checkPago(String id) throws IOException {
        URL url = new URL("https://test.oppwa.com/v1/checkouts/" + id + "/payment?" + "entityId=8a8294175d602369015d73bf009f1808");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer OGE4Mjk0MTc1ZDYwMjM2OTAxNWQ3M2JmMDBlNTE4MGN8ZE1xNU1hVEQ1cg==");
        int responseCode = conn.getResponseCode();
        InputStream is;

        if (responseCode >= 400) {
            is = conn.getErrorStream();
        } else {
            is = conn.getInputStream();
        }
        String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        HashMap mapa = gson.fromJson(result, HashMap.class);
        return mapa;
    }

    public String facturar(Double total) {
        Aci_Servicio_Web aci = new Aci_Servicio_Web();
        String id = "";
        try {
            HashMap mapa = aci.request(total, "CD");
            System.out.println(mapa.toString());
            id = mapa.toString();
            try {
                java.awt.Desktop.getDesktop().browse(new URI("http://localhost/pago/pago.html"));
            } catch (Exception e) {
                System.out.println("Excepciones " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Excepciones " + e.getMessage());
        }
        return id;
    }

    public String verificarPago(String id) throws IOException {
        Aci_Servicio_Web aci = new Aci_Servicio_Web();
        String aux = "";
        try {
            HashMap res = aci.checkPago(id);
            System.out.println(res.toString());
            aux = res.toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }

}
