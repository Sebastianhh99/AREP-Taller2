package co.escuelaing.edu.networking.squareservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {

    public static void main(String[] args) throws IOException{
        ServerSocket server = null;
        try {
            server= new ServerSocket(35001);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }
        Socket client = null;
        try{
            client = server.accept();
        }catch(IOException e){
            System.out.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String inputLine,outputLine;
        while((inputLine = in.readLine()) != null){
            try{
                outputLine = "Cuadrado: "+ Math.pow(Double.parseDouble(inputLine),2);
                out.println(outputLine);
            }catch(NumberFormatException e){
                out.println("Ingrese un numero");
            }
        }
        out.close();
        in.close();
        client.close();
        server.close();

    }
    

}
