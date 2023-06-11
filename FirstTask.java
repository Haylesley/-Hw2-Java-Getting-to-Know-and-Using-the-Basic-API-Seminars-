// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".

import java.util.Scanner;

public class FirstTask {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите данные для запроса:");
    String request = sc.nextLine();

    String[] reqsplit = request.split(",");

    StringBuilder result = new StringBuilder("select * from students where ");
    for (int i = 0; i < reqsplit.length; i++) {
        String str = reqsplit[i].replaceAll("\"", "");
        String[] value = str.split(":");
        if ( value[1].equals("null") == false) {
            if (i != 0){
                result.append(" AND");
                result.append(value[0] + " = " + value[1]);
            }
            else {
                result.append(value[0] + " = " + value[1]);
            }
        }
    }
    System.out.println(result);

    sc.close();
    }
}
    