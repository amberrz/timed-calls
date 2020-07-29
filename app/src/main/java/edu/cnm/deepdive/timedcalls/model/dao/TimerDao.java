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

/**
 * The interface Timer dao is an insert single.
 */
@Dao
public interface TimerDao {

  /**
   * Insert single is a long for timer.
   *
   * @param timer t
   * @return the single long
   */
  @Insert
  Single<Long> insert(Timer timer);

  /**
   * Insert single list and a long .
   *
   * @param timers
   * @return
   */
  @Insert
  Single<List<Long>> insert(Timer... timers);

  /**
   * Insert single list long and collection of timer.
   *
   * @param timers
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<Timer> timers);

  /**
   * Update single is an integer.
   *
   * @param timers
   * @return
   */
  @Update
  Single<Integer> update(Timer... timers);

  /**
   * Delete single is a integer to the timer .
   *
   * @param timers
   * @return
   */
  @Delete
  Single<Integer> delete(Timer timers);

  /**
   * Select all live data get the contact uri.
   *
   * @return
   */
  @Query("SELECT * FROM Timer ORDER BY contact_uri")
  LiveData<List<Timer>> selectAll();

  /**
   * the quert Select all with history live data from timer to history.
   *
   * @return
   */
  @Transaction
  @Query("SELECT * FROM Timer ORDER BY contact_uri")
  LiveData<List<TimerWithHistory>> selectAllWithHistory();

  /**
   * Select by id single.
   *
   * @param timerId
   * @return
   */
  @Transaction
  @Query("SELECT * FROM Timer WHERE timer_id = :timerId")
  Single<TimerWithHistory> selectById(long timerId);

}
