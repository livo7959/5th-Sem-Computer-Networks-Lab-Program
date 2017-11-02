import java.io.*;
import java.net.*;
import java.util.Scanner;
public class FCLIENT
{
public static void main(String[] args) throws Exception
{
Socket sock =new Socket("127.0.1",3002);
Scanner scanner=new Scanner(System.in);
PrintWriter pwrite=new PrintWriter(sock.getOutputStream(),true);
InputStream is=sock.getInputStream();
byte[]contents=new byte[10000];
System.out.println("which file do you need?");
String fileName;
fileName=scanner.nextLine();

System.out.println("where do you want to store this file?");
String fileNameToStore;
fileNameToStore=scanner.nextLine();
pwrite.println(fileName);
FileOutputStream fos=new FileOutputStream(fileNameToStore);
BufferedOutputStream bos=new BufferedOutputStream(fos);
int bytesRead=0;
while((bytesRead=is.read(contents))!=-1)
bos.write(contents,0,bytesRead);
bos.flush();
sock.close();
System.out.println("File saved successfully!");
bos.close();
}
}
