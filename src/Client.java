
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    private Socket clientSocket;

    private Client() {
        try {
            clientSocket = new Socket(Constraints.SERVER_ADDRESS, Constraints.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendPacketToServer(Packet packet) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(packet);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        do {
            System.out.print("[Client] -> ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine().toUpperCase();
            String[] userInputArray = userInput.split(" ");
            if (userInputArray.length == 3) {
                Packet packet = new Packet(userInputArray[0], Double.valueOf(userInputArray[1]), Double.valueOf(userInputArray[2]));
                sendPacketToServer(packet);
            } else if (userInputArray.length == 2) {
                Packet packet = new Packet(userInputArray[0], Double.valueOf(userInputArray[1]));
                sendPacketToServer(packet);
            } else {
                System.err.println("Input command not valid please enter command again: ");
                continue;
            }
            try {
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                Packet resultPacket = (Packet) inputStream.readObject();
                System.out.println(resultPacket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }


}
