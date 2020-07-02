package edu.cnm.deepdive.timedcalls.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.timedcalls.model.entity.History;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface HistoryDao {
  @Insert
  Single<Long> insert(History history);

  @Insert
  Single<List<Long>> insert(Collection<History> histories);

  @Update
  Single<Integer> update(History... histories);

  @Delete
  Single<Integer> delete(History... histories);

  @Query("SELECT * FROM History ORDER BY date")
  LiveData<List<History>> selectAll();

  @Query("SELECT * FROM History WHERE history_id = :historyId")
  Single<List<History>>  selectById(long historyId );

  @Transaction
  @Query("SELECT * FROM History WHERE timer_id = :timerId")
  LiveData<List<History>> selectByTimerId(long timerId);


}
