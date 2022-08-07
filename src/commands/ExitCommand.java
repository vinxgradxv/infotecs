package commands;

import data.Student;
import main.Main;
import sun.net.ftp.FtpProtocolException;
import utils.FTPConnection;
import utils.Parser;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExitCommand extends Command{

    public ExitCommand(FTPConnection ftpConnection) {
        super(ftpConnection);
        description = "Завершение работы";
        serialNumber = 5;
    }

    @Override
    public String execute(List<Student> students) {
        String output = new Parser().fromStudentsListToJSON(students);
        try {
            File file = File.createTempFile("students", ".json");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(output.getBytes(StandardCharsets.UTF_8));
            FileInputStream fis = new FileInputStream(file);
            ftpConnection.establishConnection();
            ftpConnection.getFTPClient().putFile("/htdocs/students.json", fis);
        } catch (FtpProtocolException | IOException e) {
            return "Не удалось сохранить изменения";
        }
        return "Все данные успешно сохранены, выполнение программы завершено";
    }
}
