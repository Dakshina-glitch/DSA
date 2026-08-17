import java.util.*;

public class AutoCompleteSystem {
      TrieNode root = new TrieNode();
      Map<String, Integer> frequency = new HashMap<>();
      AutoCompleteSystem(String[] sentences, int[] times) {
          for (int i = 0; i < sentences.length; i++) {
              String str = sentences[i];
              frequency.put(str, times[i]);
              insert(str);
          }
      }

      private void insert(String s) {
          TrieNode node = root;
          for (char ch : s.toCharArray()) {
              if (!node.children.containsKey(ch)) {
                  node.children.put(ch, new TrieNode());
              }
              node = node.children.get(ch);
              node.sentences.add(s);
          }
      }

      public List<String> search(char ch, StringBuilder currentPrefix) {
          if (ch == '#') {
              if (!currentPrefix.isEmpty()) {
                  String sentence = currentPrefix.toString();
                  frequency.put(sentence, frequency.getOrDefault(sentence, 0) + 1);
                  insert(sentence);
              }
              return new ArrayList<>();
          }
          currentPrefix.append(ch);

          TrieNode node = root;
          for (char c : currentPrefix.toString().toCharArray()) {
              if (!node.children.containsKey(c)) {
                  return new ArrayList<>();
              }
              node = node.children.get(c);
          }
          List<String> res = new ArrayList<>(node.sentences.stream().toList());
          res.sort((a,b) -> {
              if (!Objects.equals(frequency.get(a), frequency.get(b))) {
                  return frequency.get(b) - frequency.get(b);
              }
              return a.compareTo(b);
          });
          return res.subList(0, Math.min(3, res.size()));
      }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Set<String> sentences = new HashSet<>();
}