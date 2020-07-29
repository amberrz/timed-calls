package edu.cnm.deepdive.timedcalls.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * the history entity has a foreign key.
 */
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

  /**
   * the history Gets id from the.
   *
   * @return than returns the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id is public void.
   *
   * @param id the id is gotten from the contact permision
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets duration.
   *
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Sets duration.
   *
   * @param duration the duration
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * Gets date.
   *
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * Sets date.
   *
   * @param date the date
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Gets timer id.
   *
   * @return the timer id
   */
  public long getTimerId() {
    return timerId;
  }

  /**
   * Sets timer id.
   *
   * @param timerId the timer id
   */
  public void setTimerId(long timerId) {
    this.timerId = timerId;
  }
}
