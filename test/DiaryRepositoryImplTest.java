import data.model.Diary;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DiaryRepositoryImplTest {
    private DiaryRepository diaryRepository;
    @BeforeEach
    public void startWithThis(){
        diaryRepository = new DiaryRepositoryImpl();
    }
    @Test
    public void testThatOneDiaryCanBeSaved(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());

    }
    @Test
    public void testThatOneDiaryCanBeSaved_AndFound(){
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());
    }
    @Test
    public void testThatOneDiaryCanBeSaved_AndUpdated() {
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());

        diary.setUsername("UpdatedUsername");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("UpdatedUsername", diaryRepository.findById(1).getUsername());
    }

    @Test
    public void testThatMoreThanOneDiaryCanBeSaved_AndFound(){
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Moyin");
        diary1.setPassword("1111");
        diaryRepository.save(diary1);

        assertEquals(2, diaryRepository.count());
        assertEquals("Moyin", diaryRepository.findById(2).getUsername());

        Diary diary2 = new Diary();
        diary2.setUsername("Bimbo");
        diary2.setPassword("1111");
        diaryRepository.save(diary2);


        assertEquals(3, diaryRepository.count());
        assertEquals("Bimbo", diaryRepository.findById(3).getUsername());
    }
    @Test
    public void testThatA_DiaryCanBeSaved_AndDeleted(){
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Moyin");
        diary1.setPassword("1111");
        diaryRepository.save(diary1);

        assertEquals(2, diaryRepository.count());
        assertEquals("Moyin", diaryRepository.findById(2).getUsername());

        Diary diary2 = new Diary();
        diary2.setUsername("Bimbo");
        diary2.setPassword("1111");
        diaryRepository.save(diary2);


        assertEquals(3, diaryRepository.count());
        assertEquals("Bimbo", diaryRepository.findById(3).getUsername());

        diaryRepository.delete(diary2);
        assertNull(diaryRepository.findById(3));
    }
    @Test
    public void testThatDiariesCanBeSaved_AndCanAllBePrinted(){
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Moyin");
        diary1.setPassword("1111");
        diaryRepository.save(diary1);

        assertEquals(2, diaryRepository.count());
        assertEquals("Moyin", diaryRepository.findById(2).getUsername());

        Diary diary2 = new Diary();
        diary2.setUsername("Bimbo");
        diary2.setPassword("1111");
        diaryRepository.save(diary2);


        assertEquals(3, diaryRepository.count());
        assertEquals("Bimbo", diaryRepository.findById(3).getUsername());

        Iterable<Diary> expectedList = List.of(new Diary[]{diary, diary1, diary2});
        assertEquals(expectedList, diaryRepository.findAll());
    }
    @Test
    public void testThatDiariesCanBeSaved_AndCanAllBeCleared(){
        Diary diary = new Diary();
        diary.setUsername("Ashley");
        diary.setPassword("1111");
        diaryRepository.save(diary);

        assertEquals(1, diaryRepository.count());
        assertEquals("Ashley", diaryRepository.findById(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Moyin");
        diary1.setPassword("1111");
        diaryRepository.save(diary1);

        assertEquals(2, diaryRepository.count());
        assertEquals("Moyin", diaryRepository.findById(2).getUsername());

        Diary diary2 = new Diary();
        diary2.setUsername("Bimbo");
        diary2.setPassword("1111");
        diaryRepository.save(diary2);


        assertEquals(3, diaryRepository.count());
        assertEquals("Bimbo", diaryRepository.findById(3).getUsername());

        diaryRepository.clear();
        assertNull(diaryRepository.findById(1));
        assertNull(diaryRepository.findById(2));
        assertNull(diaryRepository.findById(3));
        assertEquals(0, diaryRepository.count());
    }
}
