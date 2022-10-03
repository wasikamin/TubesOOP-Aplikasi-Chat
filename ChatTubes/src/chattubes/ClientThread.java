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
public class ClientThread extends Server implements Runnable{

   
    
    private Socket s; 
    private BufferedReader in;
    private PrintWriter out;
      
  
    // Constructor 
    public ClientThread(Socket s)  
    { 
        this.s = s; 
        
    } 
  
    @Override
    public void run()  
    { 
        try {
            out = new PrintWriter(s.getOutputStream(),true);
            in = new BufferedReader (new InputStreamReader(s.getInputStream()));
            while(!s.isClosed()){
                String input = in.readLine();
                if(input != null){
                    for(ClientThread client:clients){
                        client.getWriter().write(input);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } 
    
    public PrintWriter getWriter(){
        return out;
    }
} 

