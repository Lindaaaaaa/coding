package com.company.Trie;

/**
 * Created by Lindaliu on 2020-10-28.
 */
public class DesignAddandSearchWordsDataStructure {
    class WordDictionary {
        /** Initialize your data structure here. */
        Node root;

        public WordDictionary() {
            root = new Node('/');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node currentNode = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode.children[c-'a'] == null) {
                    currentNode.children[c-'a'] = new Node(c);
                }
                currentNode = currentNode.children[c-'a'];
            }
            currentNode.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return helper(word,0, root);
        }

        public boolean helper(String word, int index, Node treeNode) {
            if (index == word.length()) {
                return treeNode.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (Node child: treeNode.children) {
                    if (child != null && helper(word,index+1, child)) {
                        return true;
                    }
                }
            } else {
                return treeNode.children[c-'a'] != null && helper(word, index+1, treeNode.children[c-'a']);
            }
            return false;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    class Node {
        public char c;
        public Node[] children = new Node[26];
        public boolean isWord = false;

        public Node(char c) {
            this.c = c;
        }
    }
}
