package commands;

import data.Student;
import utils.FTPConnection;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private FTPConnection ftpConnection;
    private List<Command> commandList = new ArrayList<>();

    public CommandManager(FTPConnection ftpConnection) {
        this.ftpConnection = ftpConnection;
        commandList.add(new GetStudentsCommand(ftpConnection));
        commandList.add(new FindByIdCommand(ftpConnection));
        commandList.add(new AddStudentCommand(ftpConnection));
        commandList.add(new RemoveStudentCommand(ftpConnection));
        commandList.add(new ExitCommand(ftpConnection));
    }

    public void execute(Command command, List<Student> students) {
        if (command != null) {
            System.out.println(command.execute(students));
        }
        else {
            /*System.out.println("Такой команды не существует, введите номер от 1 до 5"); */
            throw new NumberFormatException();
        }
    }

    public List<Command> getCommandList(){
        return commandList;
    }

}
