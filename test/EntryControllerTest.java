//import controller.EntryController;
//import data.model.Entry;
//import data.repository.EntryRepository;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class EntryControllerTest {
//
//    @Test
//    void createEntry_shouldCreateEntry() {
//        EntryRepository entryRepository = mock(EntryRepository.class);
//        EntryController entryController = new EntryController(entryRepository);
//
//        Entry createdEntry = entryController.createEntry("Test Title", "Test Body");
//
//        assertNotNull(createdEntry);
//        assertEquals("Test Title", createdEntry.getTitle());
//        assertEquals("Test Body", createdEntry.getBody());
//    }
//}
