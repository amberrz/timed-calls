package edu.cnm.deepdive.timedcalls.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timedcalls.model.dao.HistoryDao;
import edu.cnm.deepdive.timedcalls.model.entity.History;
import java.util.List;

public class HistoryRepository {

  private final Context context;
  private final HistoryDao historyDao;
  private final TimedCallsDatabase database;

  public HistoryRepository(Context context) {
    this.contex = context;
    database = TimedCallsDatabase.getInstance();
    historyDao = database.getHistoryDao();
  }
  public LiveData<List<History>> getAll

}
