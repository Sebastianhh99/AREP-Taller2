package co.escuelaing.edu.networking;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * URL reader class
 */
public class URLReader {
    
    /**
     * main method
     * @param args args
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a URL: ");  
        String str= sc.nextLine();
        URL google = new URL(str);
        try (BufferedReader reader= new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            File file = new File("./static/resultado.html");
            if(file.createNewFile()){
                file.delete();
                file.createNewFile();
            }
            FileWriter writer = new FileWriter("./static/resultado.html");
            while ((inputLine = reader.readLine()) != null) {
                writer.write(inputLine);
            }
            writer.close();
        } catch (IOException x) {
            System.err.println(x);
        }
        sc.close();
    }
}
