package edu.cnm.deepdive.timedcalls;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.timedcalls.service.TimedCallsDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * The type Timed calls application.
 */
public class TimedCallsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TimedCallsDatabase.setContext(this);
    TimedCallsDatabase database = TimedCallsDatabase.getInstance();
    database.getHistoryDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }

}
