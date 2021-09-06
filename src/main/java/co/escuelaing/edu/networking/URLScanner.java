package co.escuelaing.edu.networking;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Realizado en clase con el profesor
 */
public class URLScanner
{
    public static void main( String[] args ) throws MalformedURLException
    {
        URL personalSite = new URL("https://ldbn.escuelaing.edu.co:80/");
        System.out.println("Protocolo: "+personalSite.getProtocol());
        System.out.println("Authority: "+personalSite.getAuthority());
        System.out.println("Host: "+personalSite.getHost());
        System.out.println("Port: "+personalSite.getPort());
        System.out.println("Path: "+personalSite.getPath());
        System.out.println("Query: "+personalSite.getQuery());
        System.out.println("File: "+personalSite.getFile());
        System.out.println("Ref: "+personalSite.getRef());
    }
}
