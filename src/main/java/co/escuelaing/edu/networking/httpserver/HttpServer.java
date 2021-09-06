package co.escuelaing.edu.networking.httpserver;

import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Server http
 */
public class HttpServer {

    private static HttpServer _instance = new HttpServer();

    /**
     * Constructor
     */
    private HttpServer(){}

    /**
     * get instance for http server
     * @return HttpServer instance
     */
    private static HttpServer getInstance(){
        return _instance;
    }

    /**
     * Gets port of the app
     * @return int port
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000; //returns default port if heroku-port isn't set
    }

    /**
     * Returns the response for the path
     * @param path path
     * @return String response
     */
    public String createTextResponse(String path){
        String type = "text/html";
        if(path.endsWith(".css")){
            type = "text/css";
        }else if(path.endsWith(".js")){
            type = "text/javascript";
        }else if(path.endsWith(".jpg") || path.endsWith(".jpeg")){
            type = "image/jpeg";
        }else if(path.endsWith(".png")){
            type = "image/png";
        }
        Path file = Paths.get("./static"+path);
        Charset charset = Charset.forName("ISO-8859-1");
        String outmsg = "";
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                outmsg = outmsg + "\r\n" + line;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            //x.printStackTrace();
            if(path.equals("/")){
                return createTextResponse("/index.html");
            }
            return createTextResponse("/404.html");
        }
        //System.out.println(type);
        return "HTTP/1.1 200 OK\r\n"
        + "Content-Type: "+type+"\r\n"
        + "\r\n"+outmsg;
    }

    /**
     * Procces the response with the socker
     * @param clientSocket socket
     * @throws IOException exception
     */
    public void processResponse(Socket clientSocket) throws IOException{
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String method="";
        String path="";
        String version="";
        List<String> headers = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {
            if(method.isEmpty()){
                String[] requestString = inputLine.split(" ");
                method= requestString[0];
                path = requestString[1];
                version = requestString[2];
                System.out.println("Request: "+ method + " "+path+" "+version);
            }else{
                System.out.println("Header: "+inputLine);
                headers.add(inputLine);
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        String responseMessage= createTextResponse(path);
        
        out.println(responseMessage);

        out.close();
    
        in.close();
        
    }

    /**
     * Init the server
     * @param args args
     * @throws IOException exception
     */
    public void startServer(String[] args) throws IOException {
        int port = getPort();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+port);
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean running = true;
        while(running){
            try {
                System.out.println("Listo para recibir en puerto: "+port);
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
    
            processResponse(clientSocket);
    
            clientSocket.close();    
        }
        serverSocket.close();
    }

    /**
     * main method
     * @param args args
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        HttpServer.getInstance().startServer(args);
    }
}
