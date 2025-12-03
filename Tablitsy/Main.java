import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = "CACABABABCCCAABAC";

        System.out.println(hasRepeats(source, 4)); // true, тк ABAB встречается два раза, хоть эти куски и пересекаются
        System.out.println(hasRepeats(source, 5)); // false
    }
//    Наивное решение
//    public static boolean hasRepeats(String source, int size) {
//        List<String> slices = new ArrayList<>(); // список всех подстрок длины size
//        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
//            String slice = source.substring(i, i + size); // вырезание подстроки
//            slices.add(slice); // сохраняем подстроку
//        }
//        for (int i = 0; i < slices.size(); i++) { // перебираем все пары подстрок для проверки совпадения
//            for (int j = i + 1; j < slices.size(); j++) {
//                String slice1 = slices.get(i);
//                String slice2 = slices.get(j);
//                if (slice1.equals(slice2)) {
//                    return true;
//                }
//            }
//        }
//        return false; // если бы нашли, то вышли бы по return true, а значит повторов нет
//    }

//     Решение на хешах
//    public static boolean hasRepeats(String source, int size) {
//        Set<String> slices = new HashSet<>(); // множество всех подстрок длины size
//        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
//            String slice = source.substring(i, i + size); // вырезание подстроки
//            if (slices.contains(slice)) { // проверка на наличие повтора этой подстроки
//                return true; // если уже встречали, значит повторы нет
//            } else {
//                slices.add(slice);  // иначе запоминаем подстроку и перебираем дальше
//            }
//        }
//        return false; // если бы нашли, то вышли бы по return true, а значит повторов нет
//    }

    public static boolean hasRepeats(String source, int size) {
        Set<LazyString> slices = new HashSet<>(); // множество всех подстрок длины size
        LazyString prev = null; // переменная для сохранения предыдущей подстроки
        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
            LazyString slice; // вырезание подстроки
            if (prev == null) {
                // первую подстроку создаём конструктором за линейную асимптотику
                slice = new LazyString(source, 0, size);// ВАШ КОД
            } else {
                // все остальные через сдвиг вправо от предыдущей подстроки, за O(1)
                slice = prev.shiftRight();
            }
            if (slices.contains(slice)) { // проверка на наличие повтора этой подстроки
                return true; // если уже встречали, значит повторы нет
            } else {
                slices.add(slice);  // иначе запоминаем подстроку и перебираем дальше
            }
            prev = slice; // не забываем обновить переменную для предыдущей подстроки для следующей итерации цикла
        }
        return false; // если бы нашли, то вышли бы по return true, а значит повторов нет
    }
}
