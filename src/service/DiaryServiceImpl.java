package service;

import data.model.Diary;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryServiceImpl implements DiaryService {
    DiaryRepository diaryRepository = new DiaryRepositoryImpl();

    @Override
    public void register(String username, String password) {
        checkUsername(username);
        Diary diary = new Diary();
        diary.setUsername(username);
        diary.setPassword(password);
        diaryRepository.save(diary);
    }

    @Override
    public Diary save(String username, String password) {
        return null;
    }

    @Override
    public Iterable<Diary> findAll() {
        return null;
    }


    @Override
    public long count() {
        return diaryRepository.count();
    }

    @Override
    public void delete() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isUsernameUnique(String username) {
        return false;
    }

    private void checkUsername(String username) {
        for (Diary diary: diaryRepository.findAll()){
            if(Objects.equals(diary.getUsername(), username)){
                throw new IllegalArgumentException("Kindly input a Unique Username");
            }

        }
    }
}