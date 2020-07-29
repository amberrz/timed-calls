/*This work is copyright 2020, Ambar Rodriguez. All right reserved.
 */
package edu.cnm.deepdive.timedcalls.controller;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.timedcalls.R;
import java.util.LinkedList;
import java.util.List;

/**
 * Main user interface for accessing  contact list, checking for permission, to display the
 * contacts.
 */
public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_CODE = 20000;

    /**
     * Initializes and checks permission for the contact list.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_contacts, R.id.navigation_timer, R.id.navigation_history)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        checkPermissions();
    }

    private void checkPermissions() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),
                PackageManager.GET_META_DATA | PackageManager.GET_PERMISSIONS);
            String[] permissions = info.requestedPermissions;
            List<String> permissionsToRequest = new LinkedList<>();
            List<String> permissionsToExplain = new LinkedList<>();
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                    permissionsToRequest.add(permission);
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                        permissionsToExplain.add(permission);
                    }
                } else {
//                    viewModel.grantPermission(permission);
                }
            }
            if (!permissionsToExplain.isEmpty()) {
//                explainPermissions(
//                    permissionsToExplain.toArray(new String[0]),
//                    permissionsToRequest.toArray(new String[0]));
            } else if (!permissionsToRequest.isEmpty()) {
//                onAcknowledge(permissionsToRequest.toArray(new String[0]));
                ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[0]), PERMISSIONS_REQUEST_CODE);
            }
        } catch (NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if permission was granted and shuts down app if permission was denied.
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int result = grantResults[i];
                if (result == PackageManager.PERMISSION_GRANTED) {
//                    viewModel.grantPermission(permission);
                } else {
//                    viewModel.revokePermission(permission);
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
