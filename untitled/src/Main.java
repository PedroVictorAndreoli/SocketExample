import java.io.*;
import java.net.*;
import java.sql.SQLOutput;


public class Main {
    public static void main(String[] args) throws Exception {
        tcpServer tcp = new tcpServer();
        tcp.run();
    }
}

class tcpServer{
    public void run() throws Exception{
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor aguardando conexao ...");

        Socket socket = serverSocket.accept();
        System.out.println("Conexao recebida" + socket.getInetAddress().getHostName());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int k = in.readInt();
        String s = in.readUTF();

        System.out.println("Valor de Int: " + k);
        System.out.println("Valor de Str: " + s);

        out.writeInt(1);
        out.writeUTF("Ola");

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }

}