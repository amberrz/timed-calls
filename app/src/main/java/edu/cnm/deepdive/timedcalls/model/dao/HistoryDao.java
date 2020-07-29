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

/**
 * The History dao is interface .
 */
@Dao
public interface HistoryDao {

  /**
   * The Insert is single.
   *
   * @param history  is for the history list
   * @return is single
   */
  @Insert
  Single<Long> insert(History history);

  /**
   * Insert single is for the phone number saved in history.
   *
   * @param histories the is histories of the phone numbers saved
   * @return statement is single
   */
  @Insert
  Single<List<Long>> insert(Collection<History> histories);

  /**
   * The integer single and it updates history .
   *
   * @param histories
   * @return statement is single
   */
  @Update
  Single<Integer> update(History... histories);

  /**
   * Single is integer and History is able to Delete .
   *
   * @param histories the histories
   * @return the single is the return statement to delete.
   */
  @Delete
  Single<Integer> delete(History... histories);

  /**
   * Select all live data from the history .
   *
   * @return statement live data.
   */
  @Query("SELECT * FROM History ORDER BY date")
  LiveData<List<History>> selectAll();

  /**
   * Select from the history by id single.
   *
   * @param historyId is a long.
   * @return statement is the single.
   */
  @Query("SELECT * FROM History WHERE history_id = :historyId")
  Single<History>  selectById(long historyId );

  /**
   * Select by timer id live data get the id from the time to show in the history.
   *
   * @param timerId the timer id appears in the history.
   * @return the live data is the return statement.
   */
  @Transaction
  @Query("SELECT * FROM History WHERE timer_id = :timerId")
  LiveData<List<History>> selectByTimerId(long timerId);


}
