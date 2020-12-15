package it.esedra.persona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static Fragment fragmentLoaded;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            hideNavigationBar();

            fragmentManager = getSupportFragmentManager();

            /*fragmentLoaded = new FirstFragment();
            fragmentManager.beginTransaction().add(R.id.container_fragment, fragmentLoaded)
                    .commit();*/

            new AsyncLoadFragment(new FirstFragment(), Transitions.FADE).execute();
        }
    }

    private void hideNavigationBar(){
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        View decorView = getWindow().getDecorView();

        decorView.setSystemUiVisibility(flags);
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0){
                decorView.setSystemUiVisibility(flags);
            }
        });
    }


}