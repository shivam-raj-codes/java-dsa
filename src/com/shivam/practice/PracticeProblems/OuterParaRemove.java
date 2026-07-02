package com.shivam.practice.PracticeProblems;



public class OuterParaRemove {
    public static void main(String[] args) {
        String s = "(()())(())";
        String primitiveS = removeOuter(s);
        System.out.println(primitiveS);
    }
    public static String removeOuter(String s) {
        StringBuilder st = new StringBuilder();

        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ( ch == '(' ) {
                if (depth > 0) {
                  st.append(ch);
                }
                depth += 1;
            }
            else {
                depth -= 1;
                if (depth > 0) {
                    st.append(ch);
                }
            }
        }
        return st.toString();
    }

}
