import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    public List<Student> fromJSONToStudentsList(String json) {
        String beautifulJSON = makeItBeautiful(json);
        String[] words = beautifulJSON.split("\"");
        List<Student> res = new ArrayList<>();
        if (words[0].equals("students")) {
            for (int i = 1; i < words.length; i += 4) {
                res.add(new Student(words[i + 1], Integer.parseInt(words[i + 3])));
            }
        }
        return res;
    }

    private String makeItBeautiful(String json) {
        String beautifulJSON = "";
        String pattern = "[\\d\\w\"]";
        boolean inBrackets = false;
        for (char c: json.toCharArray()){
            if (inBrackets) {
                if (c == '"') {
                    inBrackets = false;
                }
                beautifulJSON += c;
            }
            else {
                if (c == '"') {
                    inBrackets = true;
                }
                if (Pattern.matches(pattern, Character.toString(c))) {
                    beautifulJSON += c;
                }
            }
        }
        return beautifulJSON;
    }
}
