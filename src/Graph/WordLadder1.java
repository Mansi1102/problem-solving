package Graph;

import java.util.*;

public class WordLadder1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> st = new HashSet<>(wordList); // Faster lookup
            if (!st.contains(endWord)) return 0; // If endWord not in wordList, no solution

            Queue<Qpair> q = new LinkedList<>();
            q.add(new Qpair(beginWord, 1));

            while (!q.isEmpty()) {
                Qpair p = q.poll();
                String word = p.first;
                int step = p.second;

                if (word.equals(endWord)) return step;

                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char originalChar = wordArray[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue; // skip same char

                        wordArray[i] = ch;
                        String newWord = new String(wordArray);

                        if (st.contains(newWord)) {
                            st.remove(newWord);
                            q.add(new Qpair(newWord, step + 1));
                        }
                    }
                    wordArray[i] = originalChar; // restore original char
                }
            }
            return 0;
        }
    }

    class Qpair {
        String first;
        int second;

        Qpair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
