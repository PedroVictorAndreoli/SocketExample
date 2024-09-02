import java.io.*;
import java.net.*;
import java.sql.SQLOutput;


public class Client{
    public static void main(String[] args) throws Exception {
        tcpClient tcp = new tcpClient();
        tcp.run();
    }
}

class tcpClient{
    public void run() throws Exception{

        Socket socket = new Socket("127.0.0.1",5000);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeInt(2);
        out.writeUTF("Ola");
        int k = in.readInt();
        String s = in.readUTF();

        System.out.println("Valor de Int: " + k);
        System.out.println("Valor de Str: " + s);

        in.close();
        out.close();
        socket.close();
    }

}