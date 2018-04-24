/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.connector.desktopapp.connectors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author senura
 */
public class HttpRequestsCon {
   
   
    //working
    public String sendGET(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      System.out.println("Res Code GET - "+conn.getResponseCode());
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }
    
    
    
      public void sendHttpPUT(String passedUrl, String content) throws Exception{
        URL url = new URL(passedUrl);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(content);
        out.close();
        httpCon.getInputStream();
        System.out.println("Res Code PUT - "+httpCon.getResponseCode());
        System.out.println("Res Message PUT - "+httpCon.getResponseMessage());
    }
      
    
     //working
    //para - "api/tasks/1/2/06-26-2018"
    public void sendHTTPDelete(String passedUrl) throws Exception{
        URL url = new URL(passedUrl);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty(
            "Content-Type", "application/json" );
        httpCon.setRequestMethod("DELETE");
        httpCon.connect();
        System.out.println("Res Code DELETE - "+httpCon.getResponseCode());
    }
    
    
    public void sendPOST(String passedUrl, String content) throws Exception{
        byte[] out = content.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        
         URL url = new URL(passedUrl);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.setDoOutput(true);
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
         os.write(out);
        
        
            // Do something with http.getInputStream()
            
      BufferedReader rd = new BufferedReader(new InputStreamReader(http.getInputStream()));
            
      System.out.println("Res Code GET - "+http.getResponseCode());
      System.out.println("New Developer Location is - "+http.getHeaderField("location"));
            
//      String line;
//      StringBuilder result = new StringBuilder();
//      while ((line = rd.readLine()) != null) {
//         result.append(line);
//      }
//      rd.close();
//            System.out.println("res is - "+result);
        }
            
            
    }


    
    
 
    
    
    
}
