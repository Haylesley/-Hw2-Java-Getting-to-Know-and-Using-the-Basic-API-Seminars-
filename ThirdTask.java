// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder,
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ThirdTask {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("t3.txt"));
        String[] arrayStr = new String[CountLineFile("t3.txt")];
        StringBuilder stringbuilder = new StringBuilder();

        String str;
        int i = 0;
        
        while ((str = br.readLine()) != null) {
            arrayStr[i] = str;
            i += 1;
        }
        

        //PrintResult(str);
        br.close();
        
    }
    public static void PrintResult(String str) {
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace("\"", "");
        

        System.out.println(str);
    }
    public static int CountLineFile(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int size = 0;
        String str;

        while ((str = br.readLine()) != null) {
            size++;
        }
        br.close();
        return size;
    }
}
