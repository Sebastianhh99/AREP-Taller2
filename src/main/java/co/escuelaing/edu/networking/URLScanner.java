package co.escuelaing.edu.networking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * URLScanner class
 */
public class URLScanner
{
    /**
     * main method
     * @param args args
     * @throws MalformedURLException exception
     */
    public static void main( String[] args ) throws MalformedURLException
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a URL: ");  
        String str= sc.nextLine();
        URL personalSite = new URL(str);
        System.out.println("Protocolo: "+personalSite.getProtocol());
        System.out.println("Authority: "+personalSite.getAuthority());
        System.out.println("Host: "+personalSite.getHost());
        System.out.println("Port: "+personalSite.getPort());
        System.out.println("Path: "+personalSite.getPath());
        System.out.println("Query: "+personalSite.getQuery());
        System.out.println("File: "+personalSite.getFile());
        System.out.println("Ref: "+personalSite.getRef());
        sc.close();
    }
}
