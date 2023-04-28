import java.util.*;
import java.io.*;
public class InputTest {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Треба два параметри виклику: ім'я файлу та рядок для пошуку");
            return;
        }
        String thisLine;
        ArrayList list = new ArrayList();
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0])));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("==Введена строка:" + thisLine);
                list.add(thisLine);
            }
            Collections.sort(list);
            System.out.println("Відсортований список строк:");
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                String str = (String)iter.next();
                System.out.println(str);
            }
            // Пошук рядка у списку
            String searchStr = args[1];
            int index = Collections.binarySearch(list, searchStr);// — це метод класу java.util.Collections,
            // який повертає позицію об’єкта у відсортованому списку.
            if (index >= 0) {
                System.out.println("Рядок '" + searchStr + "' знайдено на позиції " + index);
            } else {
                System.out.println("Рядок '" + searchStr + "' не знайдено у списку");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Помилка вводу/виводу. Файл " + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if (fin != null)
                try {
                    fin.close(); // !!! Закрити файл
                } catch (IOException ex) {
                    System.out.println("Помилка закриття файлу " + args[0]);
                    System.out.println("Error: " + ex);
                }
            fin = null;
        }
    }
}