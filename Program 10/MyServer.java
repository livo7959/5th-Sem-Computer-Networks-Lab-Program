import java.net.*;
import java.io.*;
class MyServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(15000);
		byte buffer[] = new byte[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str2;
		do
		{
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			String str = new String(p.getData());
			System.out.println("Client says:"+str);
			System.out.print("Server says :");
			str2 = br.readLine();
			java.util.Arrays.fill(buffer, (byte)0);
			for(int i=0; i<str2.length(); i++)
				buffer[i] = (byte)str2.charAt(i);
			ds.send(new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 16000));
		}while(!str2.equals("bye"));
		System.out.println("Closing chat Application");
		ds.close();
	}
}

