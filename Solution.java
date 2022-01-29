import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new FileReader(args[0]));
        String stringFromFile;
        ArrayList<String> arrayList = new ArrayList<>();
        while ((stringFromFile = bf.readLine()) != null) {
            arrayList.add(stringFromFile);
        }
        // считали путь файла 1-ым параметром и построчно записали файл в arrayList

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");

        for (String s : arrayList) {
            String[] stringToArray = s.split(" ");
            // разбили строку на блоки, из которых будем "строить" дату и имя
            
            String dateInString = String.format("%2s", stringToArray[stringToArray.length - 3])
                    + String.format("%2s", stringToArray[stringToArray.length - 2])
                    + String.format("%2s", stringToArray[stringToArray.length - 1]);
            Date date = simpleDateFormat.parse(dateInString);

            StringBuilder name = new StringBuilder(stringToArray[0]);
            for (int i = 1; i < stringToArray.length - 3; i++) {
                name.append(" ").append(stringToArray[i]);
            }
            PEOPLE.add(new Person(name.toString(), date));
        }

        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " : " + person.getBirthDate());
        }

        bf.close();
    }
}