package id.ac.ub.filkom.sekcv.astech.controller.main_sub_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

import id.ac.ub.filkom.sekcv.appstroke.R;

/**
 * Created by Daneswara Jauhari on 30/08/2016.
 */
public class Help extends AppIntro2{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add your slide's fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
//        addSlide(first_fragment);
//        addSlide(second_fragment);
//        addSlide(third_fragment);
//        addSlide(fourth_fragment);
        ImageView a = new ImageView(this);
        a.setBackgroundColor(getResources().getColor(R.color.primary));
        setBackgroundView(a);
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Memilih aplikasi", "Pilih aplikasi dari berbagai jenis aplikasi yang tersedia, klik 1 kali untuk melihat definisi kategori aplikasi dan klik dan tahan selama 2 detik untuk menjalankan aplikasi", R.drawable.home_sub_app, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Mengoperasikan aplikasi", "Anda dapat ", R.drawable.daftar, R.color.amber));
        // OPTIONAL METHODS
        // Override bar/separator color.
//        setBarColor(Color.parseColor("#3F51B5"));
//        setSeparatorColor(Color.parseColor("#2196F3"));
//
//        // Hide Skip/Done button.
//        showSkipButton(true);

        setProgressButtonEnabled(true);
        setFadeAnimation();

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = new Intent(Help.this, id.ac.ub.filkom.sekcv.astech.controller.main_app.Help.class);
        startActivity(intent);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(Help.this, id.ac.ub.filkom.sekcv.astech.controller.main_app.Help.class);
        startActivity(intent);
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
