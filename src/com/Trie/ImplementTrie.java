package com.Trie;

/**
 * Created by Lindaliu on 2020-09-29.
 */
/*
* Notes: https://www.youtube.com/watch?v=giiaIofn31A&ab_channel=MichaelMuinos
* https://leetcode.com/problems/implement-trie-prefix-tree/solution/*/
class Trie {
    public Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i =0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new Node(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = findPrefix(word);
        return n!=null && n.isWord == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findPrefix(prefix)!=null;
    }

    private Node findPrefix(String word) {
        Node cur = root;
        for (int i =0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                return null;
            }
            cur = cur.children[c-'a'];
        }
        return cur;
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c){
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

}