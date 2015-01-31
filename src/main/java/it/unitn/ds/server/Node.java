package it.unitn.ds.server;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class Node implements Serializable {

    private int id;

    private String host;

    private Map<Integer, Item> items = new TreeMap<>();

    private Map<Integer, String> nodes = new TreeMap<>();

    public Node(int id, String host) {
        this.id = id;
        this.host = host;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public Map<Integer, String> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Integer, String> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (o instanceof Node) {
            Node object = (Node) o;

            return Objects.equals(id, object.id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("host", host)
                .add("items", Arrays.toString(items.keySet().toArray()))
                .add("nodes", Arrays.toString(nodes.entrySet().toArray()))
                .toString();
    }
}
