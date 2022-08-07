package commands;

import data.Student;
import utils.FTPConnection;

import java.util.List;

public class GetStudentsCommand extends Command{

    public GetStudentsCommand(FTPConnection ftpConnection) {
        super(ftpConnection);
        description = "Получение списка студентов по имени";
        serialNumber = 1;
    }

    @Override
    public String execute(List<Student> students) {
        if (students.size() == 0) {
            return "В файле нет ни одного студента";
        }
        String res = "";
        for (Student student: students){
            res += student.toString() + "\n";
        }
        return res;
    }
}
