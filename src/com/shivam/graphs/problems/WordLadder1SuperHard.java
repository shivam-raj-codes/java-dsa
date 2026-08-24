package com.shivam.graphs.problems;

import java.util.*;


public class WordLadder1SuperHard {
    static class Pair {
        String first;
        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, ArrayList<String> wordList) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(startWord, 1));

        HashSet<String> set = new HashSet<>(); /// wordlist into Set
        for (String word : wordList) {
            set.add(word);
        }

        set.remove(startWord); /// what we push into Queue remove that from Set.

        /// bfs

        /// Time: Q will run for N - times -> No. of words in give WordList
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            /// every time getting WORD on poll(). check is this the target Word, if yes => return steps;
            if (word.equals(targetWord)) {
                return steps;
            }

            ///  word = hit

            /// Time : word.length() * 26
            for (int i = 0; i < word.length(); i++) {
                char[] original = word.toCharArray(); /// String -> char[]; fresh original copy for each outer-loop iteration
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    original[i] = ch;

                    String newWord = new String(original); /// char[] -> String . To check whether this new String Exist in Set or not

                    /// it exists in set
                    if (set.contains(newWord)) {
                        set.remove(newWord); /// remove from set
                        q.offer(new Pair(newWord, steps + 1)); /// add in Queue with increasing steps
                    }
                }
            }
        }

        /// in case we did not find endWord.
        return 0;
    }
}

// HashSet works in -> O(1)

/// Time: O(N * word.length() * 26).
/// Space: O(N) -> to store in Set.