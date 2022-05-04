package ru.kuzmina.lesson8;

import java.util.ArrayList;
import java.util.List;

public class ListHashTable <K, V> implements HashTable<K, V>{
    private final List<Item<K, V>>[] data;
    private final Item<K, V> emptyItem;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }

    public ListHashTable(int initialCapacity) {
        this.data = new ArrayList[initialCapacity];
        emptyItem = new Item<>(null, null);
    }

    public ListHashTable() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int indexFromHashFunc = hashFunc(key);
        int li;
        if (data[indexFromHashFunc] != null && !data[indexFromHashFunc].isEmpty() && (li = listFindKey(data[indexFromHashFunc], key)) != -1) {
            data[indexFromHashFunc].get(li).setValue(value);
            return true;
        }

        if (data[indexFromHashFunc] == null) {
            data[indexFromHashFunc] = new ArrayList<>();
            size++;
        }
        data[indexFromHashFunc].add(new Item<>(key, value));

        return true;
    }

    private int listFindKey(List<Item<K, V>> dataItem, K key) {
        for (int i = 0; i < dataItem.size(); i++) {
            if (isKeysEquals(dataItem.get(i), key)) {
                return i;
            }
        }
        return -1;
    }

//    private int getDoubleHash(K key) {
//        int n = data.length / 2;
//        return n - (key.hashCode() % n);
//    }
//
//    private int getStepQuadratic(int i) {
//        return (int) Math.pow(i, 2);
//    }
//
//    private int getStepLinear() {
//        return 1;
//    }
//
    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOfList(key);
        if (index == -1 || data[index] == null || data[index].isEmpty()) {
            return null;
        }
        int keyIndex = listFindKey(data[index], key);
        return keyIndex == -1 ? null : data[index].get(keyIndex).getValue();
    }

    private int indexOfList(K key) {
        int indexFromHashFunc = hashFunc(key);

        int count = 0;
        while (count++ < data.length) {
            if (data[indexFromHashFunc].isEmpty()) {
                break;
            }
            if (listFindKey(data[indexFromHashFunc], key) != -1) {
                return indexFromHashFunc;
            }
        }

        return -1;
    }



    @Override
    public V remove(K key) {
        int index = indexOfList(key);
        if (index == -1 || data[index].isEmpty() || data[index] == null) {
            return null;
        }
        int keyIndex = listFindKey(data[index], key);
        if (keyIndex == -1) {
            return null;
        }

        Item<K, V> removed = data[index].get(keyIndex);
        data[index].remove(keyIndex);
        return removed.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}

