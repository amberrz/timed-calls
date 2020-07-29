/*this work is copyright2020, Ambar Rodriguez. All right reserved.
 */

package edu.cnm.deepdive.timedcalls.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.timedcalls.R;
import edu.cnm.deepdive.timedcalls.viewmodel.TimerViewModel;

/**
 * The Timer fragment has the view model of how the fragment is going to appear on the emulator.
 */
public class TimerFragment extends Fragment {

    private TimerViewModel timerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        timerViewModel =
               new ViewModelProvider(this).get(TimerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_timer, container, false);
        return root;
    }
}
