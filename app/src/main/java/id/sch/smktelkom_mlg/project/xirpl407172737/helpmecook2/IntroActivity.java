package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by SAVIOUR-2 on 30/11/2016.
 */

public class IntroActivity extends AppIntro {
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        addSlide(SampleSlide.newInstance(R.layout.slide_1));
       addSlide(SampleSlide.newInstance(R.layout.slide_2));
        addSlide(SampleSlide.newInstance(R.layout.slide_3));
        addSlide(AppIntroFragment.newInstance("Juudul","Isiiiiiiiiiiiiiiii", R.drawable.akun , getColor(R.color.colorAccent)));
        addSlide(AppIntroFragment.newInstance("Juudul2","Isiiiiiiiiiiiiiiii", R.drawable.akun , getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Juudul3","Isiiiiiiiiiiiiiiii", R.drawable.akun , getColor(R.color.colorAccent)));

        showStatusBar(true);
        setFadeAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

}
