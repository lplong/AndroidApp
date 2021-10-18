package vn.edu.usth.pj.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import vn.edu.usth.pj.Save_Page;

@Dao
public interface SaveDAO {
    @Query("SELECT * FROM Saved")
    List<Save_Page> getAll();

    @Query("SELECT * FROM Saved WHERE id IN (:Saved_int)")
    List<Save_Page> loadAllByIds(int[] Saved_int);

    @Insert
    void insertAll(Save_Page save_page);

    @Delete
    void delete(Save_Page save_page);

    @Query("DELETE FROM Saved")
    void deleteAll();

}
