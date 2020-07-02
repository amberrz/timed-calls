package edu.cnm.deepdive.timedcalls.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.timedcalls.model.dao.HistoryDao;
import edu.cnm.deepdive.timedcalls.model.dao.TimerDao;
import edu.cnm.deepdive.timedcalls.model.entity.History;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import edu.cnm.deepdive.timedcalls.service.TimedCallsDatabase.Converters;
import java.util.Date;

@Database(
    entities = {History.class, Timer.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class TimedCallsDatabase extends RoomDatabase {

  private static final String DB_NAME = "timed_calls_database";


  private static Application context;

  public static void setContext(Application context) {
    TimedCallsDatabase.context = context;
  }

  public abstract HistoryDao getHistoryDao();

  public abstract TimerDao getTimerDao();

  public static TimedCallsDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final TimedCallsDatabase INSTANCE =
        Room.databaseBuilder(context, TimedCallsDatabase.class, DB_NAME)
            .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}
