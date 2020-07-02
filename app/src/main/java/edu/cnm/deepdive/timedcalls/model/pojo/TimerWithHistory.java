package edu.cnm.deepdive.timedcalls.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.timedcalls.model.entity.History;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import java.util.List;

public class TimerWithHistory extends Timer {

  @Relation(entity = History.class, entityColumn = "timer_id", parentColumn = "timer_id")
  private List<History> events;

  public List<History> getEvents() {
    return events;
  }

  public void setEvents(List<History> events) {
    this.events = events;
  }
}
