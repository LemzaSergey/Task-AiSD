package ru.vsu.cs.util;

import ru.vsu.cs.util.DefaultBSTreeMap;

/**
 * Реализация словаря на базе простого (наивного) дерева поиска
 *
 * @param <K>
 * @param <V>
 */
public class SimpleBSTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = new SimpleBSTree<>();

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}

