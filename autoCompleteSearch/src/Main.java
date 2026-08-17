import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] sentences = {"hello world", "hello interview", "hello"};
        int[] frequencies = {5, 3, 2};
        char[] types = {'h', 'e', 'l', 'l', 'o', '#'};
        AutoCompleteSystem autoCompleteSystem =  new AutoCompleteSystem(sentences, frequencies);
        StringBuilder stringBuilder = new StringBuilder();
        List<String> search;
        for(char ch : types) {
            search = autoCompleteSystem.search(ch, stringBuilder);
            System.out.println(search);
        }
    }
}