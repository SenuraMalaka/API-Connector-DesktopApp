/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.connector.desktopapp;

import api.connector.desktopapp.connectors.APISettings;
import api.connector.desktopapp.connectors.HttpRequestsCon;
import java.net.ConnectException;
import language.InfoMessages;



/**
 *
 * @author senura
 */
public class APIConnectorDesktopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        HttpRequestsCon httpCon=new HttpRequestsCon();
        
            //callGET(httpCon, "api/developers/31");
            //callPOST(httpCon, "developers","{\"name\":\"SampleDev\"}");
            //callDelete(httpCon, "tasks/1/1/044-24-2018");
            
            String putContent="{\"did\":1,\"pid\":1,\"date\":\"04/22/2018\",\"hours\":5,\"description\":\"worked 5 hours\"}";
            callPUT(httpCon, "tasks", putContent);
        
            
        
        
    }
    
    
    
    
    private static void callGET(HttpRequestsCon httpCon, String passedURI){
    try {
            String res=httpCon.sendGET(APISettings.API_URL+passedURI); //httpCon.getFromGET("http://localhost:5000/api/developers/1");
            System.out.println("response is - "+res);
        } catch (ConnectException ex) {
            System.out.println(InfoMessages.ApiIsOffline);
        }catch(java.io.IOException ex){
            System.out.println(InfoMessages.DBIsOffline);
        }catch(Exception ex){
            System.out.println(InfoMessages.errorMSGView+ex.toString());
        }
    }
    
     private static void callPOST(HttpRequestsCon httpCon,String passedURI, String content){
      try {
         httpCon.sendPOST(APISettings.API_URL+passedURI, content);
        } catch (ConnectException ex) {
            System.out.println(InfoMessages.ApiIsOffline);
        }catch(java.io.IOException ex){
            System.out.println(InfoMessages.DBIsOffline);
        }catch(Exception ex){
            System.out.println(InfoMessages.errorMSGView+ex.toString());
        }

    }
     
     
     
     private static void callPUT(HttpRequestsCon httpCon, String passedURI,String content){
    try {
            httpCon.sendHttpPUT(APISettings.API_URL+passedURI, content);

        } catch (ConnectException ex) {
            System.out.println(InfoMessages.ApiIsOffline);
        }catch(java.io.IOException ex){
            System.out.println(InfoMessages.DBIsOffline+ex.toString());
        }catch(Exception ex){
            System.out.println(InfoMessages.errorMSGView+ex.toString());
        }
    }
     
     
     private static void callDelete(HttpRequestsCon httpCon,String psdURI){
         
        try {
            httpCon.sendHTTPDelete(APISettings.API_URL+psdURI);
        }catch (ConnectException ex) {
            System.out.println(InfoMessages.ApiIsOffline);
        }catch(java.io.IOException ex){
            System.out.println(InfoMessages.DBIsOffline);
        }catch(Exception ex){
            System.out.println(InfoMessages.errorMSGView+ex.toString());
        }
        
     }
}
