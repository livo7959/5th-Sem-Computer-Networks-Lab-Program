import java.io.*;
import java.net.*;
public class FSERVER {
public static void main(String[] args) throws Exception {
while(true) {
ServerSocket sersock=new ServerSocket(3002);
System.out.println("Server ready to serve files");
Socket sock=sersock.accept();
BufferedReader receiveRead=new BufferedReader(new InputStreamReader(sock.getInputStream()));
String receiveMessage;
if((receiveMessage = receiveRead.readLine()) != null)
{
System.out.println(receiveMessage);
File file=new File(receiveMessage);
FileInputStream fis=new FileInputStream(file);
BufferedInputStream bis=new BufferedInputStream(fis);
OutputStream os=sock.getOutputStream();
byte[] contents;
long fileLength=file.length();
long current=0;
while(current!=fileLength)
{
int size =10000;
if(fileLength - current >=size)
current+=size;
else
{
size =(int)(fileLength-current);
current=fileLength;
}
contents=new byte[size];
bis.read(contents,0,size);
os.write(contents);
System.out.print("sending file"+(current*100)/fileLength +"% complete!");
}
os.flush();
System.out.println("File sent succesfully!");
bis.close();
}
sock.close();
sersock.close();
}
}
}
