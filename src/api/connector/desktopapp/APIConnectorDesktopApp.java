/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.connector.desktopapp;

import api.connector.desktopapp.connectors.HttpRequestsCon;
import java.net.ConnectException;


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
        
            callGET(httpCon);
            //callPOST(httpCon);
        
        
        
    }
    
    
    
    private static void callGET(HttpRequestsCon httpCon){
    try {
            String res=httpCon.getHTML("http://localhost:5000/api/developers/31"); //httpCon.getFromGET("http://localhost:5000/api/developers/1");
            System.out.println("response is - "+res);
        } 
        catch (ConnectException ex) {
            System.out.println("Database Connection Not Available Refused");
        }catch(Exception ex){
            System.out.println("Error Occurred - "+ex.getMessage());
        }
    }
    
     private static void callPOST(HttpRequestsCon httpCon){
    try {
            httpCon.sendPost("senuradissanayake.com", "");
        } 
        catch (ConnectException ex) {
            System.out.println("Database Connection Not Available Refused");
        }catch(Exception ex){
            System.out.println("Error Occurred - "+ex.getMessage());
        }
    }
}
