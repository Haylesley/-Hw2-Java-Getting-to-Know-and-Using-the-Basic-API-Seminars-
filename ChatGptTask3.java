// Этот код написала нейросеть смотреть его не надо


import java.util.ArrayList;

public class ChatGptTask3 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        
        try {
            ArrayList<Student> students = parseJson(jsonString);
            StringBuilder stringBuilder = new StringBuilder();
            
            for (Student student : students) {
                stringBuilder.append("Студент ")
                             .append(student.getФамилия())
                             .append(" получил ")
                             .append(student.getОценка())
                             .append(" по предмету ")
                             .append(student.getПредмет())
                             .append(".\n");
            }
            
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Student> parseJson(String jsonString) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        
        jsonString = jsonString.replaceAll("\\[|\\]", "");  // удаление символов [ и ]
        String[] entries = jsonString.split(",(?=\\{)");  // разбиение на отдельные записи
        
        for (String entry : entries) {
            String[] keyValuePairs = entry.split(",");  // разбиение на пары ключ-значение
            Student student = new Student();
            
            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");  // разбиение на ключ и значение
                
                String key = keyValue[0].replaceAll("\"", "").replaceAll("\\{", "").trim();  // удаление кавычек и символа "{", а затем пробелов
                String value = keyValue[1].replaceAll("\"", "").replaceAll("\\}", "").trim();  // удаление кавычек и символа "}", а затем пробелов
                
                switch (key) {
                    case "фамилия":
                        student.setФамилия(value);
                        break;
                    case "оценка":
                        student.setОценка(value);
                        break;
                    case "предмет":
                        student.setПредмет(value);
                        break;
                    default:
                        throw new Exception("Некорректный ключ: " + key);
                }
            }
            
            students.add(student);
        }
        
        return students;
    }
}

class Student {
    private String фамилия;
    private String оценка;
    private String предмет;
    
    public String getФамилия() {
        return фамилия;
    }
    
    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }
    
    public String getОценка() {
        return оценка;
    }
    
    public void setОценка(String оценка) {
        this.оценка = оценка;
    }
    
    public String getПредмет() {
        return предмет;
    }
    
    public void setПредмет(String предмет) {
        this.предмет = предмет;
    }
}
