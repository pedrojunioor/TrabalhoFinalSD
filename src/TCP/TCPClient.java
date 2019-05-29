package TCP;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TCPClient {
	public static void main (String args[]) {
		Socket s = null;
		Scanner ler = new Scanner(System.in);
		try{
			String ip = "localhost";
			int serverPort = 7000;
			s = new Socket(ip, serverPort);    

			System.out.println("Digite a mensagem a ser enviada! ");
			String data = ler.nextLine();
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(data);			
			dos.flush();
			dos.close();			
		
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}