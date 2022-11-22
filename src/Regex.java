import java.util.regex.Pattern;

public class Regex {





    public static void main(String[] args) {
        System.out.println("TASK 1");
        //1.Słowo może zaczynać się z wielkich liter A, B, C, kończy się „apa”.
        Pattern pattern1 = Pattern.compile("[ABC][a-z]*apa");
        System.out.println("should be true");
        System.out.println(pattern1.matcher("Bapa").matches());
        System.out.println(pattern1.matcher("Cabcdefghijklapa").matches());
        System.out.println("should be false");
        System.out.println(pattern1.matcher("Dapa").matches());
        System.out.println(pattern1.matcher("bapa").matches());
        System.out.println(pattern1.matcher("B_apa").matches());
        System.out.println(pattern1.matcher("BAPA").matches());
        System.out.println(pattern1.matcher("Bapaz").matches());
        System.out.println(pattern1.matcher("").matches());

        System.out.println();
        System.out.println("TASK 2");
        //2.Słowo zaczyna się od wielkiej litery z wyjątkiem A, następnie występują minimalnie 4 małe litery ale nie więcej niż 7, kończy się dwoma cyframi z zakresu 0-5.
        Pattern pattern2 = Pattern.compile("[B-Z][a-z]{4,7}[0-5]{2}");
        System.out.println("should be true");
        System.out.println(pattern2.matcher("Baabb01").matches());
        System.out.println(pattern2.matcher("Zaabbccd55").matches());
        System.out.println("should be false");
        System.out.println(pattern2.matcher("baabb01").matches());
        System.out.println(pattern2.matcher("Aaabb01").matches());
        System.out.println(pattern2.matcher("Baab01").matches());
        System.out.println(pattern2.matcher("Baabbccdd01").matches());
        System.out.println(pattern2.matcher("Baabb011").matches());
        System.out.println(pattern2.matcher("Baabb06").matches());

        System.out.println();
        System.out.println("TASK 3");
        //3.Sprawdź czy użytkownik podał poprawne imię.
        Pattern pattern3 = Pattern.compile("[A-Z][a-z]+");
        System.out.println("should be true");
        System.out.println(pattern3.matcher("Bob").matches());
        System.out.println(pattern3.matcher("Jakub").matches());
        System.out.println(pattern3.matcher("Dorothy").matches());
        System.out.println("should be false");
        System.out.println(pattern3.matcher("kubus").matches());
        System.out.println(pattern3.matcher("r2d2").matches());
        System.out.println(pattern3.matcher("Grzegorz Brzeczyszczykiewicz").matches());


        System.out.println();
        System.out.println("TASK 4");
        //4.Sprawdź czy użytkownik podał poprawnie adres e-mail.
        // czy to jest zadanie na googlowanie?
        Pattern pattern4 = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        System.out.println("should be true");
        System.out.println(pattern4.matcher("address@gmail.com").matches());
        System.out.println("should be false");
        System.out.println(pattern4.matcher("Addres@gmail.com").matches());
        System.out.println(pattern4.matcher("address@@mail.com").matches());
        System.out.println(pattern4.matcher("address.gmail.com").matches());

        System.out.println();
        System.out.println("TASK 5");
        //5.Sprawdź czy format daty podany przez użytkownika jest prawidłowy: zakładam format DD:MM:YYYY, nie sprawdzam lat przestępnych :/

        Pattern pattern5 = Pattern.compile("((0[1-9]|[1-2][0-9]|3[01]):(01|03|05|07|08|10|12):[0-9]{4})|((0[1-9]|[1-2][0-9]|30):(04|06|09|11):[0-9]{4})|((0[1-9]|[1-2][0-9]):02:[0-9]{4})");
        System.out.println("should be true");
        System.out.println(pattern5.matcher("31:01:2025").matches());
        System.out.println(pattern5.matcher("30:04:2025").matches());
        System.out.println(pattern5.matcher("29:02:2025").matches());
        System.out.println(pattern5.matcher("32:01:2025").matches());
        System.out.println(pattern5.matcher("30:02:2025").matches());
        System.out.println(pattern5.matcher("31:04:2025").matches());
        System.out.println("should be false");
        System.out.println(pattern5.matcher("29:13:2025").matches());
        System.out.println(pattern5.matcher("29:00:2025").matches());
        System.out.println(pattern5.matcher("00:01:2025").matches());

        System.out.println();
        System.out.println("TASK 6");
        //6.Sprawdź czy liczba zmiennoprzecinkowa podana przez użytkownika ma poprawny format.
        Pattern pattern6 = Pattern.compile("-?(0|(-?[1-9][0-9]*))\\.[0-9]+");
        System.out.println("should be true");
        System.out.println(pattern6.matcher("0.0").matches());
        System.out.println(pattern6.matcher("-0.1").matches());
        System.out.println(pattern6.matcher("12.0").matches());
        System.out.println("should be false");
        System.out.println(pattern6.matcher("00.12").matches());
        System.out.println(pattern6.matcher("0,12").matches());
        System.out.println(pattern6.matcher("0:12").matches());

        System.out.println();
        System.out.println("TASK 7");
        //7.Sprawdź czy numer domu jest w formacie numer\numer. Poprawnym numerem jest 12, 415, 123\2A, 24B\3 czy 12\5, ale numerem nie jest abc lub 12\A.
        Pattern pattern7 = Pattern.compile("[1-9][0-9]*[A-Z]?(\\\\[1-9][0-9]*[A-Z]?)?");

        System.out.println("should be true");

        System.out.println(pattern7.matcher("12").matches());
        System.out.println(pattern7.matcher("415").matches());
        System.out.println(pattern7.matcher("123\\2A").matches());
        System.out.println(pattern7.matcher("24B\\3").matches());
        System.out.println(pattern7.matcher("12\\15").matches());
        System.out.println("should be false");
        System.out.println(pattern7.matcher("abc").matches());
        System.out.println(pattern7.matcher("12\\A").matches());

        System.out.println();

        System.out.println();
        System.out.println("TASK 8");
        //8.*Sprawdź czy liczba jest mniejsza bądź równa 31, ale większa niż zero.
        // wersja zmiennoprzecinkowa:
        Pattern pattern8 = Pattern.compile("(0\\.[0-9]*[1-9][0-9]*)|([1-9](\\.[0-9]+)?)|([12][0-9](\\.[0-9]+)?)|(30(\\.[0-9]+)?)|31");

        //wersja dla liczb całkowitych:
        //Pattern pattern8 = Pattern.compile("([1-9])|([12][0-9])|(3[01])");
        System.out.println("should be true");
        System.out.println(pattern8.matcher("0.002").matches());
        System.out.println(pattern8.matcher("1.002").matches());
        System.out.println(pattern8.matcher("29.002").matches());
        System.out.println(pattern8.matcher("29").matches());
        System.out.println(pattern8.matcher("30.90").matches());
        System.out.println(pattern8.matcher("31").matches());
        System.out.println("should be false");
        System.out.println(pattern8.matcher("31.1").matches());
        System.out.println(pattern8.matcher("0").matches());
        System.out.println(pattern8.matcher("32").matches());


        System.out.println();
        System.out.println("TASK 9");
        //9.*Sprawdź czy liczba jest mniejsza bądź równa 118, ale nie może mieć cyfry 3 na pozycji dziesiętnych
        // oraz nie może mieć cyfry 5 na pozycji jedności, i nie równa się 59.
        // *dła ułatwietnia rozważam tylko liczby całkowite

        Pattern pattern9 = Pattern.compile("11[0-46-8]|10[0-46-9]|[1246-9][0-46-9]|5[0-46-8]|[0-46-9]|-[1-46-9]|-[124-9][0-46-9]|-[1-9][0-9]*[0-24-9][0-46-9]");

        System.out.println("should be true");

        System.out.println(pattern9.matcher("118").matches());
        System.out.println(pattern9.matcher("108").matches());
        System.out.println(pattern9.matcher("41").matches());
        System.out.println(pattern9.matcher("66").matches());
        System.out.println(pattern9.matcher("3").matches());
        System.out.println(pattern9.matcher("-3").matches());
        System.out.println(pattern9.matcher("-66").matches());
        System.out.println(pattern9.matcher("-118").matches());
        System.out.println(pattern9.matcher("-120").matches());
        System.out.println(pattern9.matcher("-1124320").matches());

        System.out.println("should be false");

        System.out.println(pattern9.matcher("119").matches());
        System.out.println(pattern9.matcher("115").matches());
        System.out.println(pattern9.matcher("105").matches());
        System.out.println(pattern9.matcher("31").matches());
        System.out.println(pattern9.matcher("65").matches());
        System.out.println(pattern9.matcher("59").matches());
        System.out.println(pattern9.matcher("5").matches());
        System.out.println(pattern9.matcher("-5").matches());
        System.out.println(pattern9.matcher("-30").matches());
        System.out.println(pattern9.matcher("-25").matches());
        System.out.println(pattern9.matcher("-1212130").matches());
        System.out.println(pattern9.matcher("-11115").matches());

    }
}
