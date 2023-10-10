package controller;


import data.model.Entry;
import data.repository.EntryRepository;

import java.util.List;

public class EntryController {
    private EntryRepository entryRepository;

    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(String title, String body) {
        Entry entry = new Entry();
        entry.setTitle(title);
        entry.setBody(body);

        entryRepository.save(entry);
        return entry;
    }
}