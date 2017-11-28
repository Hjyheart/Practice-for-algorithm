package src;

import java.util.*;

/**
 * Created by I332329 on 11/28/2017.
 * Tag: Heap
 * Solution:
 * 最大堆 就是字符串还要有顺序坑了一点
 */
public class TopKFrequentWords_692 {

    public static void heapUp(List<Word> words, int index) {
        if (index > 1) {
            int parent = index / 2;

            int parentValue = words.get(parent).count;
            int indexValue =  words.get(index).count;
            if (parentValue < indexValue) {
                Collections.swap(words, parent, index);
                heapUp(words, parent);
            }
        }
    }

    public static void heapDown(List<Word> words, int index) {
        int n = words.size() - 2;

        int child = -1;

        if (2 * index > n) {
            return;
        }
        else if (2 * index < n) {

            child = 2 * index;
            if (words.get(child).count < words.get(child + 1).count) {
                child++;
            }

        }
        else if (2 * index == n) {
            child = 2 * index;
        }

        if (words.get(child).count > words.get(index).count) {
            Collections.swap(words, child, index);
            heapDown(words, child);
        }
    }

    public static void insert(List<Word> words, Word newWord) {
        if (words.size() == 0) {
            words.add(null);
        }
        words.add(newWord);
        heapUp(words, words.size() - 1);
    }

    public static void delete(List<Word> words, int index) {
        words.set(index, words.get(words.size() - 1));
        heapDown(words, index);
        words.remove(words.size() - 1);
    }

    public static Word pop(List<Word> words) {
        if (words.size() > 1) {
            Word word = words.get(1);
            delete(words, 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word peek(List<Word> words) {
        if (words.size() > 1) {
            Word word = words.get(1);
            return word;
        } else {
            return null;
        }
    }

    static class Word {
        String word;
        int count;
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static class compare implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Word wo1 = (Word) o1;
            Word wo2 = (Word) o2;

            if (wo1.count == wo2.count) {
                return wo1.word.compareTo(wo2.word);
            } else {
                return wo2.count - wo1.count;
            }
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Word> wordArrayList = new ArrayList<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        wordArrayList.add(null);
        ArrayList<Word> res = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> entryKeyIterator = map.entrySet().iterator();
        while (entryKeyIterator.hasNext() && k > 0) {
            Map.Entry<String, Integer> e = entryKeyIterator.next();
            insert(wordArrayList, new Word(e.getKey(), e.getValue()));
        }

        int count = 0;
        while (count < k) {
            if (peek(wordArrayList) != null) {
                Word tmp = pop(wordArrayList);
                res.add(tmp);
                if (peek(wordArrayList) == null) {
                    break;
                }
                while(peek(wordArrayList).count == tmp.count) {
                    res.add(pop(wordArrayList));
                    if (peek(wordArrayList) == null) {
                        break;
                    }
                }
            } else {
                break;
            }
            count++;
        }
        res.sort(new compare());
        ArrayList<String> finalRes = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            finalRes.add(res.get(i).word);
        }
        return finalRes;
    }

    public static void main(String[] args) {
        topKFrequent(new String[]{"a","aa","aaa"}, 2);
    }
}
