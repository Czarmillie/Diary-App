import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import data.model.Entry;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryRepositoryTest {
    private EntryRepository entryRepository;

    @BeforeEach
    public void setUp() {
        entryRepository = new EntryRepositoryImpl();
    }

    @Test
    public void testSaveAndFindById() {
        Entry entry = new Entry();
        entry.setTitle("Test Entry");
        entry.setBody("This is a test entry.");
        entry.setLocalDateTime(LocalDateTime.now());

        entryRepository.save(entry);

        Entry savedEntry = entryRepository.findById(entry.getId());

        assertNotNull(savedEntry);
        assertEquals(entry.getId(), savedEntry.getId());
        assertEquals(entry.getTitle(), savedEntry.getTitle());
        assertEquals(entry.getBody(), savedEntry.getBody());
        assertEquals(entry.getLocalDateTime(), savedEntry.getLocalDateTime());
    }

    @Test
    public void testFindAll() {
        Entry entry1 = new Entry();
        entry1.setTitle("Entry 1");
        entry1.setBody("This is entry 1.");
        entry1.setLocalDateTime(LocalDateTime.now());

        Entry entry2 = new Entry();
        entry2.setTitle("Entry 2");
        entry2.setBody("This is entry 2.");
        entry2.setLocalDateTime(LocalDateTime.now());

        entryRepository.save(entry1);
        entryRepository.save(entry2);
        List<Entry> entries = entryRepository.findAll();
        assertEquals(2, entries.size());
    }

    @Test
    public void testUpdate() {
        Entry entry = new Entry();
        entry.setTitle("Original Title");
        entry.setBody("Original Body");
        entry.setLocalDateTime(LocalDateTime.now());

        entryRepository.save(entry);

        entry.setTitle("Updated Title");
        entry.setBody("Updated Body");
        entryRepository.update(entry);

        Entry updatedEntry = entryRepository.findById(entry.getId());
        assertEquals("Updated Title", updatedEntry.getTitle());
        assertEquals("Updated Body", updatedEntry.getBody());
    }

    @Test
    public void testDelete() {
        Entry entry = new Entry();
        entry.setTitle("To be deleted");
        entry.setBody("Will be deleted soon");
        entry.setLocalDateTime(LocalDateTime.now());

        entryRepository.save(entry);
        int entryId = entry.getId();

        entryRepository.delete(entryId);
        Entry deletedEntry = entryRepository.findById(entryId);
        assertNull(deletedEntry);
    }
}