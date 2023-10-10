import data.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.EntryService;
import data.repository.*;
import service.EntryServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

public class EntryServiceImplTest {

    private EntryRepository entryRepository;
    private EntryService entryService;

    @BeforeEach
    public void setUp() {
        entryRepository = new EntryRepositoryImpl();
        entryService = new EntryServiceImpl(entryRepository);
    }

    @Test
    public void testAddEntry() {
        String ownerName = "John Doe";
        String title = "Test Entry";
        String body = "This is a test entry body";

        Entry addedEntry = entryService.addEntry(ownerName, title, body);

        assertNotNull(addedEntry);
        assertEquals(ownerName, addedEntry.getOwnerName());
        assertEquals(title, addedEntry.getTitle());
        assertEquals(body, addedEntry.getBody());
    }

    @Test
    public void testCount() {
        long initialCount = entryService.count();

        String ownerName = "John Doe";
        String title = "Test Entry";
        String body = "This is a test entry body";

        entryService.addEntry(ownerName, title, body);

        assertEquals(initialCount + 1, entryService.count());
    }

    @Test
    public void testDelete() {
        String ownerName = "John Doe";
        String title = "Test Entry";
        String body = "This is a test entry body";
        Entry addedEntry = entryService.addEntry(ownerName, title, body);
        entryService.delete(ownerName, title);
        try {
            entryService.findEntry(ownerName, title);
            fail("Expected IllegalArgumentException, but found the entry");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindEntryNotFound() {
        entryService.findEntry("Nonexistent", "Nonexistent");
    }
}
