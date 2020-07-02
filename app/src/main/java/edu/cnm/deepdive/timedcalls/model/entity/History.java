package edu.cnm.deepdive.timedcalls.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = @ForeignKey(
        entity = Timer.class,
        parentColumns = "timer_id",
        childColumns = "timer_id",
        onDelete = ForeignKey.SET_NULL

    )

)
public class History {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "history_id")
  private long id;

  private int duration;

  @ColumnInfo(index = true)
  private Date date;

  @ColumnInfo(name = "timer_id", index = true)
  private long timerId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getTimerId() {
    return timerId;
  }

  public void setTimerId(long timerId) {
    this.timerId = timerId;
  }
}
