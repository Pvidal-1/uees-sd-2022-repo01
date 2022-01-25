import java.io.*;   import java.net.ServerSocket;   import java.net.Socket;

public class TCPServer {
  public static final void main(final String[] args) {
    ServerSocket server;           InputStream  is;
    Socket       client;          

    try {
      server = new ServerSocket(9999);
      
      for (int j = 20; (--j) >= 0;) {  //process only j clients
        client = server.accept(); 
        System.out.println("New connection from " + client.getRemoteSocketAddress());
        
        is     = client.getInputStream(); 
        int num = is.read();
        
        System.out.println("");
        
        for (int i=0;i<num;i++){
        System.out.print("X");
        }
        
        System.out.println("\n");
             
        client.close(); //close connection to client
      }
      server.close();   //(*@\serverBox{5)}@*)
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
