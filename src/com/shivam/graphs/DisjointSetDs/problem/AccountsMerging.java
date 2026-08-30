package com.shivam.graphs.DisjointSetDs.problem;

import java.util.*;
/// Using Disjoint Set Data-Structure
public class AccountsMerging {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {

        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        /// step1: connecting nodes and making disjoint set & making ultimateParent

        // {mail, node}
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (!mapMailNode.containsKey(mail)) {
                    /// not contains mails
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionByRank(i, mapMailNode.get(mail)); /// (currentNode and mapMailNode) go ahead and connect your self.
                }
            }
        }

        /// step2: Merging the mails according to the disjoint set

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergeMail[i] = new ArrayList<String>();
        }

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergeMail[node].add(mail);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        /// step3: rearranging them inOrder to send merged with the names as the List of list
        for (int i = 0; i < n; i++) {
            if (mergeMail[i].isEmpty()) {
                continue;
            }
            Collections.sort(mergeMail[i]); // sort all merge mail at index = i.

            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            ///  go across mergeMAil[i]
            for (String it : mergeMail[i]) {
                temp.add(it); // add whatever is on this index list.
            }
            ans.add(temp); /// store ans
        }

        return ans;
    }
}


// Step 1
//Email → account mapping
//       ↓
//Same email found?
//       ↓
//Union the two accounts
//
//Step 2
//Find ultimate parent of each email
//       ↓
//Put email into mergeMail[parent]
//
//Step 3
//Sort emails
//       ↓
//Add account name
//       ↓
//Create final answer