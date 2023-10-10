package controller;
import data.model.Diary;
import data.repository.DiaryRepository;
import service.DiaryService;

public class DiaryController {
    private DiaryRepository diaryRepository;
    private DiaryService diaryService;

    public DiaryController(DiaryRepository diaryRepository, DiaryService diaryService) {
        this.diaryRepository = diaryRepository;
        this.diaryService = diaryService;
    }

    public Diary createDiary(String username, String password) {
        Diary diary = null;
        if (!diaryService.isUsernameUnique(username)) {

            diary = new Diary();
            diary.setUsername(username);
            diary.setPassword(password);
        }

        return diaryRepository.save(diary);
    }
}