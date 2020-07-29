package edu.cnm.deepdive.timedcalls.controller;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.model.entity.Timer;
import edu.cnm.deepdive.timedcalls.model.pojo.Contact;
import java.util.Locale;


/**
 * The type Call timer fragment is a fragment for the timer to set for the call.
 */
public class CallTimerFragment extends DialogFragment {

  private static final String URI_KEY = "uri";
  private Timer timer;
  private EditText editTextInput;
  private TextView textViewCountDown;
  private Button buttonSet;
  private Button buttonStartPause;
  private Button buttonReset;
  private CountDownTimer countDownTimer;
  private boolean timerRunning;
  private long startTimeInMillis;
  private long timeLeftInMillis;
  private long endTime;
  private View root;


  /**
   * Create instance call timer fragment.
   *
   * @param contact the contact
   * @return the call timer fragment
   */
  public static CallTimerFragment createInstance(Contact contact) {
    CallTimerFragment fragment = new CallTimerFragment();
    Bundle args = new Bundle();
    args.putParcelable(URI_KEY, contact.getUri());
    // TODO Store additional info of contacts
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      timer = getArguments().getParcelable(URI_KEY);
    }
    // TODO Get the nesary info to place the call is phone number contact info
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

     root = LayoutInflater.from(getContext())
        .inflate(R.layout.fragment_call_timer, null, false);
    editTextInput = root.findViewById(R.id.edit_text_input);
    textViewCountDown = root.findViewById(R.id.text_view_countdown);
    buttonSet = root.findViewById(R.id.button_set);
    buttonStartPause = root.findViewById(R.id.button_start_pause);
    buttonReset = root.findViewById(R.id.button_reset);

    buttonSet
        .setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String input = editTextInput.getText().toString();
        if (input.length() == 0) {
          Toast.makeText(getContext(), "Field can't be empty", Toast.LENGTH_SHORT).show();
          return;
        }
        long millisInput = Long.parseLong(input) * 60000;
        if (millisInput == 0) {
          Toast.makeText(getContext(), "Please enter a positive number", Toast.LENGTH_SHORT).show();
          return;
        }
        setTime(millisInput);
        editTextInput.setText("");
      }
    });
    buttonStartPause.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (timerRunning) {
          pauseTimer();
        } else {
          startTimer();
        }
      }
    });
    buttonReset.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        resetTimer();
      }
    });

    AlertDialog dialog = new AlertDialog.Builder(getContext())
        .setIcon(R.drawable.ic_timer_black_24dp)
        .setTitle("Set your Time")
        .setView(root)
//        .setPositiveButton(android.R.string.ok, (dlg, which) -> save())
        .setNegativeButton(android.R.string.cancel, (dlg, which) -> {
        })
        .create();
//   dialog.setOnShowListener((dlg) -> checkSubmitCondition());
   return dialog;
    // TODO Inflate view resource and use dialog builder to create and return alart dialog
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // TODO Return layout inflated in on create dialog
    return null; //FIXME
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TODO establish Connect to view model
  }

  private void setTime(long milliseconds) {
    startTimeInMillis = milliseconds;
    resetTimer();
    closeKeyboard(getActivity());
  }
  private void startTimer() {
    endTime = System.currentTimeMillis() + timeLeftInMillis;
    countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
      @Override
      public void onTick(long millisUntilFinished) {
        timeLeftInMillis = millisUntilFinished;
        updateCountDownText();
      }
      @Override
      public void onFinish() {
        timerRunning = false;
        updateWatchInterface();
      }
    }.start();
    timerRunning = true;
    updateWatchInterface();
  }
  private void pauseTimer() {
    countDownTimer.cancel();
    timerRunning = false;
    updateWatchInterface();
  }
  private void resetTimer() {
    timeLeftInMillis = startTimeInMillis;
    updateCountDownText();
    updateWatchInterface();
  }
  private void updateCountDownText() {
    int hours = (int) (timeLeftInMillis / 1000) / 3600;
    int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
    int seconds = (int) (timeLeftInMillis / 1000) % 60;
    String timeLeftFormatted;
    if (hours > 0) {
      timeLeftFormatted = String.format(Locale.getDefault(),
          "%d:%02d:%02d", hours, minutes, seconds);
    } else {
      timeLeftFormatted = String.format(Locale.getDefault(),
          "%02d:%02d", minutes, seconds);
    }
    textViewCountDown.setText(timeLeftFormatted);
  }
  private void updateWatchInterface() {
    if (timerRunning) {
      editTextInput.setVisibility(View.INVISIBLE);
      buttonSet.setVisibility(View.INVISIBLE);
      buttonReset.setVisibility(View.INVISIBLE);
      buttonStartPause.setText("Pause");
    } else {
      editTextInput.setVisibility(View.VISIBLE);
      buttonSet.setVisibility(View.VISIBLE);
      buttonStartPause.setText("Start");
      if (timeLeftInMillis < 1000) {
        buttonStartPause.setVisibility(View.INVISIBLE);
      } else {
        buttonStartPause.setVisibility(View.VISIBLE);
      }
      if (timeLeftInMillis < startTimeInMillis) {
        buttonReset.setVisibility(View.VISIBLE);
      } else {
        buttonReset.setVisibility(View.INVISIBLE);
      }
    }
  }

  // TODO find close keyboard for a fragment
  private void closeKeyboard(Activity activity) {
    View view = activity.getCurrentFocus();
    if (view != null) {
      InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
  }
  @Override
  public void onStop() {
    super.onStop();
    SharedPreferences prefs = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);
    Editor editor = prefs.edit();
    editor.putLong("startTimeInMillis", timeLeftInMillis);
    editor.putLong("millisLeft", timeLeftInMillis);
    editor.putBoolean("timerRunning", timerRunning);
    editor.putLong("endTime", endTime);
    editor.apply();
    if (countDownTimer != null) {
      countDownTimer.cancel();
    }
  }
  @Override
  public void onStart() {
    super.onStart();
    SharedPreferences prefs = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);
    startTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
    timeLeftInMillis = prefs.getLong("millisLeft", startTimeInMillis);
    timerRunning = prefs.getBoolean("timerRunning", false);
    updateCountDownText();
    updateWatchInterface();
    if (timerRunning) {
      endTime = prefs.getLong("endTime", 0);
      timeLeftInMillis = endTime - System.currentTimeMillis();
      if (timeLeftInMillis < 0) {
        timeLeftInMillis = 0;
        timerRunning = false;
        updateCountDownText();
        updateWatchInterface();
      } else {
        startTimer();
      }
    }
  }

}
