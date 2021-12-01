import java.util.HashMap;
import java.util.Map;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/11/30 18:33
 */
public class Question1Solution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("ap"));
    }

    static class Trie {
        private boolean wordEnding;
        private final Map<Character, Trie> children;

        public Trie() {
            this.wordEnding = false;
            this.children = new HashMap<>();
        }

        // n is the length of the input word
        // Time: O(n)
        // Space: O(n)
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Trie curTrie = this;
            for (int i = 0; i < word.length(); i++) {
                char curCharacter = word.charAt(i);
                curTrie.children.putIfAbsent(curCharacter, new Trie());
                curTrie = curTrie.children.get(curCharacter);
            }
            curTrie.wordEnding = true;
        }

        // n is the length of the input word
        // Time: O(n)
        // Space: O(1)
        public boolean search(String word) {
            Trie trie = searchHelper(word);
            return trie != null && trie.wordEnding;
        }

        // n is the length of the input word
        // Time: O(n)
        // Space: O(1)
        public boolean startsWith(String prefix) {
            return searchHelper(prefix) != null;
        }

        private Trie searchHelper(String word) {
            Trie curTrie = this;
            for (int i = 0; i < word.length(); i++) {
                char curCharacter = word.charAt(i);
                curTrie = curTrie.children.get(curCharacter);
                if (curTrie == null) {
                    return null;
                }
            }
            return curTrie;
        }
    }
}
