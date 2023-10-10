import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.DiaryService;
import service.DiaryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplTest {
    private DiaryService diaryService;

    @BeforeEach
    public void startWith(){
        diaryService = new DiaryServiceImpl();
    }

    @Test
    public void testToRegister() {
        diaryService.register("Daniel", "password");
        assertEquals(1,diaryService.count());
    }

    @Test
    public void testForUniqueUsername(){
        diaryService.register("Daniel", "password");

        assertThrows(IllegalArgumentException.class,
                ()->{diaryService.register("Daniel", "password");});
        assertEquals(1,diaryService.count());
    }
}