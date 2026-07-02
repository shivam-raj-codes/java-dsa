package com.shivam.hashmaps;

public class MapUsingHash {

    // internally it's an Array
    private Entity[] entities;

    public MapUsingHash() {
        entities = new Entity[100];
    }

    private class Entity {
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /// put - Method

    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); /// overriding
    }

    public String get(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);

        if (entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }

        return null;
    }

    public void remove(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);

        if (entities[hash] != null && entities[hash].key.equals(key)) {
            entities[hash] = null; /// remove that found key
        }
    }

    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();

        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "My fav fruit");

        System.out.println(map.get("Apple"));
    }
}
