package data.repository;

import data.model.Diary;

public interface DiaryRepository {

        Diary findById(int id);
        Iterable<Diary> findAll();
        Diary save(Diary diary);
        void delete(Diary diary);
        long count();
        void clear();
}
