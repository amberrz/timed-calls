package edu.cnm.deepdive.timedcalls.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "contact_uri", unique = true)
)
public class Timer {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "timer_id")
  private long id;

  private int limit;

  @NonNull
  @ColumnInfo(name = "contact_uri")
  private String contactUri;

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
  public String getContactUri() {
    return contactUri;
  }

  public void setContactUri(@NonNull String contactUri) {
    this.contactUri = contactUri;
  }




}
