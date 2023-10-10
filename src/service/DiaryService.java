package service;

import data.model.Diary;

public interface DiaryService {
    void register(String username, String password);

    Diary save(String username, String password);

    Iterable<Diary> findAll();

    long count();

    void delete();

    void clear();

    boolean isUsernameUnique(String username);
}