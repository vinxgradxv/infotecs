import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;



public class Main {
    private static Parser jsonParser = new Parser();
    private static final Integer PORT = 21;
    private static List<Student> students;
    public static void main(String[] args) {
        /*Scanner console = new Scanner(System.in);
        System.out.println("Введите имя хоста:");
        String hostName = console.next();
        System.out.println("Введите логин:");
        String login = console.next();
        System.out.println("Введите пароль:");
        String password = console.next();
        */
        String hostName = "ftpupload.net";
        String login = "epiz_32313951";
        String password = "zi6b5YuiJgk";
        SocketAddress addr = new InetSocketAddress(hostName, PORT);
        FtpClient ftp = FtpClient.create();

        try {
            ftp.connect(addr);
            ftp.login(login, password.toCharArray());
        } catch (FtpProtocolException | IOException e) {
            System.err.println("Нет подключения к серверу");
        }

        OutputStream outputStream = new ByteArrayOutputStream();


        try {
            InputStream is = ftp.getFileStream("/htdocs/students.json");
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            String res = new String("");
            while (true) {
                int b = inputStreamReader.read();
                if (b != -1){
                    res += (char) b;
                }
                else {
                    break;
                }
            }

            students = jsonParser.fromJSONToStudentsList(res);
        } catch (FtpProtocolException | IOException e) {
            System.err.println("Файл students.json не найден на сервере");
        }


    }




}
