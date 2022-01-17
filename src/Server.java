
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private ServerSocket serverSocket;

    private Server() {
        try {
            serverSocket = new ServerSocket(Constraints.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("[Server] Listening...");
        Socket connection;
        do {
            try {
                connection = serverSocket.accept();
                new SClient(connection).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    class SClient extends Thread {
        private Socket connection;

        SClient(Socket socket) {
            this.connection = socket;
        }

        @Override
        public void run() {
            System.out.println("[Server] -> " + connection.toString() + " accepted");
            do {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(connection.getInputStream());
                    try {
                        Packet packet = (Packet) inputStream.readObject();
                        long time = System.nanoTime();
                        double result = Helper.calculate(packet);
                        time = System.nanoTime() - time;
                        Packet resultPacket = new Packet(result, time);
                        ObjectOutputStream outputStream = new ObjectOutputStream(connection.getOutputStream());
                        outputStream.writeObject(resultPacket);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.err.println("Client Close Socket");
                    this.stop();
                }

            } while (true);
        }
    }

}