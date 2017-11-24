package com.algorithms.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {

    private Entry root = new Entry(' ');

    private class Entry {
        private char value;
        private boolean isLast;
        private Map<Character, Entry> letters;

        Entry(char value) {
            this.value = value;
            this.letters = new HashMap<>();
        }

        Entry addLetter(char c) {
            return letters.computeIfAbsent(c, Entry::new);
        }
    }

    public void addWord(String word) {
        Entry entry = this.root;
        for (char c: word.toCharArray()) entry = entry.addLetter(c);
        entry.isLast = true;
    }

    public boolean exists(String word) {
        Entry entry = prefix(word);
        return entry != null && entry.isLast;
    }

    public String[] findWords(String prefix) {
        Entry entry = prefix(prefix);
        StringBuilder sb = new StringBuilder(prefix.substring(0, prefix.length() - 1));
        Stack<String> s = new Stack<>();
        findWords(entry, sb, s);

        String[] result = new String[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            result[i] = s.pop();
            i += 1;
        }
        return result;
    }

    private void findWords(Entry entry, StringBuilder sb, Stack<String> s) {
        sb.append(entry.value);
        if (entry.isLast) s.push(sb.toString());
        for (Map.Entry<Character, Entry> e: entry.letters.entrySet()) {
            findWords(e.getValue(), sb, s);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    private Entry prefix(String word) {
        Entry entry = this.root;
        for (char c: word.toCharArray()) {
            entry = entry.letters.get(c);
            if (entry == null) break;
        }
        return entry;
    }
}
