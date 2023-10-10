package data.repository;

import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();
    private long counter;
    public DiaryRepositoryImpl(){
        this.counter = 0;
    }
    @Override
    public Diary findById(int id) {
        for (Diary diary:diaries) {
            if (diary.getId() == id) return diary;
        }
        return null;
    }

    @Override
    public Iterable<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary save(Diary diary) {
        boolean diaryDoesNotExist = diary.getId() == 0;
        if (diaryDoesNotExist) saveNew(diary);
        else update(diary);
        return null;
    }

    private void update(Diary diary) {
        Diary updatedDiary = findById(diary.getId());
        updatedDiary.setUsername(diary.getUsername());
    }

    private void saveNew(Diary diary) {
        diary.setId(generateId());
        diaries.add(diary);
        this.counter++;
    }

    private int generateId() {
        return (int) (counter + 1);
    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);
    }

    @Override
    public long count() {
        return this.counter;
    }

    @Override
    public void clear() {
        counter -= diaries.size();
        diaries.clear();
    }
}