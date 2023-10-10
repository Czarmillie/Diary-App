package data.repository;

import data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {

    private List<Entry> entryList;
    private int nextId;

    public EntryRepositoryImpl() {
        this.entryList = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entryList) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public List<Entry> findAll() {
        return new ArrayList<>(entryList);
    }

    @Override
    public void save(Entry entry) {
        entry.setId(nextId);
        entryList.add(entry);
        nextId++;
    }

    @Override
    public void update(Entry entry) {
        int index = findEntryIndex(entry.getId());
        if (index != -1) {
            entryList.set(index, entry);
        }
    }

    @Override
    public void delete(int id) {
        int index = findEntryIndex(id);
        if (index != -1) {
            entryList.remove(index);
        }
    }

    private int findEntryIndex(int id) {
        for (int i = 0; i < entryList.size(); i++) {
            Entry entry = entryList.get(i);
            if (entry.getId() == id) {
                return i;
            }
        }
        return -1;
    }
}