package edu.cnm.deepdive.timedcalls.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import edu.cnm.deepdive.timedcalls.model.pojo.TimerWithHistory;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface TimerDao {

  @Insert
  Single<Long> insert(Timer timer);

  @Insert
  Single<List<Long>> insert(Timer... timers);

  @Insert
  Single<List<Long>> insert(Collection<Timer> timers);

  @Update
  Single<Integer> update(Timer... timers);

  @Delete
  Single<Integer> delete(Timer timers);

  @Query("SELECT * FROM Timer ORDER BY contact_uri")
  LiveData<List<Timer>> selectAll();

  @Transaction
  @Query("SELECT * FROM Timer ORDER BY contact_uri")
  LiveData<List<TimerWithHistory>> selectAllWithHistory();

  @Transaction
  @Query("SELECT * FROM Timer WHERE timer_id = :timerId")
  Single<TimerWithHistory> selectById(long timerId);

}
