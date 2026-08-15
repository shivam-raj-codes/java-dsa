package com.shivam.graph.problems;
import java.util.*;
public class WordLadderII {
    public ArrayList<ArrayList<String>> findSequences(String[] wordList, String startWord,
                                                      String endWord) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, wordList); /// [] -> set

        /// Queue storing List of String.
        Queue<ArrayList<String >> q = new LinkedList<>();
        /// list
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.offer(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        /// ans List
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        /// Queue
        while (!q.isEmpty()) {
            ArrayList<String> seqList = q.peek();
            q.remove();
            /// erase all words that has been used in previous level to transform.
            if (seqList.size() > level) { ///  when we start of peeking will get initial guy => increase in size
                level++;

                for (String it : usedOnLevel) {
                    set.remove(it); /// whatever is used in this level please erased it for next level.
                }
            }
            String word = seqList.getLast();

            /// forming answer
            if (word.equals(endWord)) {

                /// the first seqList where we reached end
                if (ans.isEmpty()) {
                    ans.add(seqList);
                }

                ///  if it's not the 1st time I've one of sequence in Answer, I'll get that sequence length! is that length equals
                /// to the sequence I got now => I'll store same length guy again. As we need All possible sequences.
                else if (ans.get(0).size() == seqList.size()) {
                    ans.add(seqList);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                char[] original = word.toCharArray(); /// String -> char[]; fresh original copy for each outer-loop iteration
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    original[i] = ch;

                    String newWord = new String(original); /// char[] -> String . To check whether this new String Exist in Set or not

                    /// it exists in set
                    if (set.contains(newWord)) {
                        seqList.add(newWord); /// take it into seqList. -> include newWord into seqList & put into Queue for next occurrence need to take it out as well.

                        ArrayList<String> newSeq = new ArrayList<>(seqList); // make independent copy.

                        /// Hey, Q take this newSeqList that happens due to transformation of Char
                        q.offer(newSeq); // queue gets the copy

                        /// mark as visited for this level
                        usedOnLevel.add(newWord);

                        seqList.remove(seqList.size() - 1); // undo temporary addition
                    }
                }
            }
        }
        return ans;
    }
}
