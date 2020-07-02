package edu.cnm.deepdive.timedcalls.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timedcalls.model.dao.HistoryDao;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import edu.cnm.deepdive.timedcalls.model.pojo.TimerWithHistory;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


public class TimerRepository {

  private final Context context;
  private final TimedCallsDatabase database;
  private final HistoryDao historyDao;
  private final TimerDao timerDao;

  public TimerRepository(Context context) {
    this.context = context;
    database = TimedCallsDatabase.getInstance();
    historyDao = database.getHistoryDao();
    timerDao = database.getTimerDao();

  }
  public LiveData<List<TimerWithHistory>> getAll() {
    return timerDao.selectAll();
  }

  public Single<TimerWithHistory> get(long id) {
    return timerDao.selectByID(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Timer timer) {
    if (timer.getId() ==0) {
      return Completable.fromSingle(timerDao.insert(timer))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(timerDao.update (timer))
          .subscribeOn(Schedulers.io());
    }
  }
  public Completable delete(Timer timer) {
    if (timer.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    }
  }

}
