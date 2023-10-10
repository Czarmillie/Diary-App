package data.repository;

import data.model.Entry;

import java.util.List;

public interface EntryRepository {
    Entry findById(int id);
    List<Entry> findAll();
    void save(Entry entry);
    void update(Entry entry);
    void delete(int id);

    long count();

    Entry findByUsername(String ownerName, String title);
}
