/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.connector.desktopapp.connectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senura
 */
public class HttpRequestsCon {
    
    //private static String API_URL="";
        
    
    public void sendPost(String url,String content) throws Exception{
        String rawData = content;
        String type = "application/json";
         
        String encodedData = URLEncoder.encode( rawData, "UTF-8" ); 
        URL u;
        u = new URL(url);
         
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty( "Content-Type", type );
        conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
        OutputStream os = conn.getOutputStream();
        os.write(encodedData.getBytes());
        int k= conn.getResponseCode();
        System.out.println("Res code for POST is -"+k);
        
    } 
    
    
    
//    public String getFromGET(String urlToGET) throws Exception{
//        
//        URL url = new URL(urlToGET);
//        HttpURLConnection conn =(HttpURLConnection) url.openConnection();
//        InputStream is = conn.getInputStream();
//        
//        return null;
//    }
    
    
    
    public String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      System.out.println("res code is - "+conn.getResponseCode());
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }

    
    
 
    
    
    
}
