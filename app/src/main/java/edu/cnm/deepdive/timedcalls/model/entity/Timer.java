package edu.cnm.deepdive.timedcalls.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "contact_url", unique = true)
)
public class Timer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "timer_id")
  private long id;

  private int limit;

  @NonNull
  @ColumnInfo(name = "contact_url")
  private String contactUrl;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  @NonNull
  public String getContactUrl() {
    return contactUrl;
  }

  public void setContactUrl(@NonNull String contactUrl) {
    this.contactUrl = contactUrl;
  }




}
