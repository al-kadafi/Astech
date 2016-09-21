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
        addSlide(AppIntroFragment.newInstance("Memilih aplikasi", "Pilih aplikasi dari berbagai jenis aplikasi yang tersedia, klik 1 kali untuk melihat definisi kategori aplikasi dan klik dan tahan selama 2 detik untuk menjalankan aplikasi", R.drawable.sub_main_app, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Mengoperasikan kategori aplikasi", "Setelah Anda masuk kategori aplikasi, Anda dapat mengoperasikannya dengan menggeser kekanan atau kekiri dari layar perangkat Anda", R.drawable.home_sub_app, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Screen home", "Pada screen home anda dapat mengetahui penjelasan umum tentang kategori aplikasi yang Anda pilih, pada screen ini juga disertakan link untuk sumber penjelasan yang diberikan", R.drawable.home_sub_app, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Screen diagnosis", "Pada screen ini dapat anda dapat menginputkan data-data terkait kategori aplikasi yang Anda pilih, dan Anda dapat mengetahui hasil diagnosis dari data-data yang telah Anda inputkan", R.drawable.diagnosa, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Hasil diagnosis", "Hasil diagnosis dari data-data yang telah Anda inputkan akan muncul ketika Anda menekan tombol calculate, dan Anda dapat mengetahui treatment dari hasil diagnosis dengan menekan tombol Go to treatment pada pojok kanan bawah", R.drawable.diagnosa, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Screen Rekam medis", "Hasil data yang telah Anda inputkan ketika proses diagnosis akan disimpan dan ditampilkan pada screen rekam medis, sehingga Anda dapat memantau kondisi kesehatan Anda pada screen rekam medis ini", R.drawable.diagnosa, R.color.amber));
        addSlide(AppIntroFragment.newInstance("Screen tratment", "Screen tretment akan menampilkan berbagai macam informasi dari hasil diagnosis yang dapat Anda jadikan referensi dalam melakukan tindakan selanjutnya terkait hasil diagnosis", R.drawable.diagnosa, R.color.amber));
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
