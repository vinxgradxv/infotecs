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

    public ExitCommand() {
        description = "Завершение работы";
        serialNumber = 5;
    }

    @Override
    public String execute(List<Student> students) {
        return "Выполнение программы завершено";
    }
}
