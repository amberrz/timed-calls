package edu.cnm.deepdive.timedcalls.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timedcalls.model.dao.HistoryDao;
import edu.cnm.deepdive.timedcalls.model.entity.History;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HistoryRepository {

  private final Context context;
  private final HistoryDao historyDao;
  private final TimedCallsDatabase database;

  public HistoryRepository(Context context) {
    this.context = context;
    database = TimedCallsDatabase.getInstance();
    historyDao = database.getHistoryDao();
  }

  public LiveData<List<History>> getAll() {
    return historyDao.selectAll();
  }

  public LiveData<List<History>> getForTimer(long id) {
    return historyDao.selectByTimerId(id);
  }

  public Single<History> get(long id) {
    return historyDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(History history) {
    if (history.getId() ==0) {
      return Completable.fromSingle(historyDao.insert(history))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(historyDao.update (history))
          .subscribeOn(Schedulers.io());
    }
  }
  public Completable delete(History history) {
    if (history.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(historyDao.delete(history))
          .subscribeOn(Schedulers.io());
    }
  }
}
