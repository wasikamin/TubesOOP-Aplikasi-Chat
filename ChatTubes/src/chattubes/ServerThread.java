/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattubes;

import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

/**
 *
 * @author ASUS
 */
public class ServerThread implements Runnable {
    private static Socket socket;
    private String name;
    private BufferedReader serverin;
    private BufferedReader userin;
    private PrintWriter out;
    
    public ServerThread(Socket socket,String name){
        this.socket = socket;
    }
    
    
    @Override
    public void run(){
        try {
           out = new PrintWriter(socket.getOutputStream(),true);
           serverin = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
           userin = new BufferedReader(new InputStreamReader(System.in));
           while(!socket.isClosed()){
               if(serverin.ready()){
                   String input = serverin.readLine();
                   if(input!=null){
                       System.out.println(input);
                   }
                   if(userin.ready()){
                       out.println(input);
                   }
               }
           }
        } catch (Exception e) {
        }
        
        
    }
    
//    public static void main(String[] args) {
//        socket = null;
//        System.out.println("Please input username: ");
//        Scanner scan = new Scanner(System.in);
//        String name = scan.nextLine();
//        scan.close();
//        int portNumber = 4444;
//    }
}
