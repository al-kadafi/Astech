package id.ac.ub.filkom.sekcv.astech.controller.main_sub_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import id.ac.ub.filkom.sekcv.appstroke.R;
import id.ac.ub.filkom.sekcv.astech.controller.main_app.MainActivity;

public class MainPage extends AppCompatActivity
{
    @BindView(R.id.appmedis_button_acupuncture_launcher)
    Button buttonAcupuncture;
    @BindView(R.id.appmedis_button_stroke_launcher)
    Button buttonStroke;
    @BindView(R.id.appmedis_button_heart_launcher)
    Button buttonHeart;
    @BindView(R.id.appmedis_textswitcher_application_description)
    TextSwitcher applicationShortDescriptionSwitcher;
    @BindView(R.id.appmedis_imageswitcher_application_logo)
    ImageSwitcher applicationLogoSwitcher;


    private Button[] buttonLauncherWrapper;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.appmedis_launcher_mainpage_container);
        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) super.findViewById(R.id.appmedis_mainpage_toolbar);
        super.setSupportActionBar(toolbar);
        final ActionBar actionBar = super.getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            toolbar.setContentInsetStartWithNavigation(4);
            toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.appmedis_toolbar_button_back));
            toolbar.setNavigationOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    MainPage.this.onBackButtonPressed();
                }
            });
        }

        this.buttonLauncherWrapper = new Button[]{this.buttonAcupuncture, this.buttonStroke, this.buttonHeart};

        this.setLogoDescriptionSwitcher();
        this.setLogoSwictcher();


    }

    private void setLogoDescriptionSwitcher()
    {
        this.applicationShortDescriptionSwitcher.setInAnimation(this, R.anim.fade_in);
        this.applicationShortDescriptionSwitcher.setOutAnimation(this, R.anim.fade_out);
        this.applicationShortDescriptionSwitcher.setFactory(new ViewSwitcher.ViewFactory()
        {

            public View makeView()
            {
                TextView myText = new TextView(MainPage.this);
                myText.setTextSize(18);
                return myText;
            }
        });

        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_short_description));
    }
    
    private void setLogoSwictcher()
    {
        this.applicationLogoSwitcher.setInAnimation(this, R.anim.fade_in);
        this.applicationLogoSwitcher.setOutAnimation(this, R.anim.fade_out);
        this.applicationLogoSwitcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            public View makeView()
            {
                ImageView myImage = new ImageView(MainPage.this);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(4, 16, 4, 4);
                lp.gravity = Gravity.CENTER_HORIZONTAL;
                myImage.setLayoutParams(lp);
                myImage.setContentDescription(MainPage.super.getResources().getString(R.string.appmedis_avatar_description));
                return myImage;
            }
        });

        this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_logo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.getMenuInflater().inflate(R.menu.appmedis_launcher_appbar_overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.appmedis_toolbar_menu_about_us:
            {
                this.onToolbarAboutUsMenuPressed();
            }
            break;
            case R.id.appmedis_toolbar_menu_help:
            {
                this.onToolbarHelpMenuPressed();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    //---------------------------------------------------------------------------------------------
    //----------------Listener Button Edit Below---------------------------------------------------
    //---------------------------------------------------------------------------------------------

    private void onBackButtonPressed()
    {
        this.onBackPressed();
    }

    @Override
    public void onBackPressed()
    {
        final Intent intent = new Intent(this, MainActivity.class);
        super.startActivity(intent);
    }

    public void onToolbarAboutUsMenuPressed()
    {
        final Intent intent = new Intent(this, AboutUsPage.class);
        super.startActivity(intent);
    }

    public void onToolbarHelpMenuPressed()
    {
        final Intent intent = new Intent(this, Helppage.class);
        super.startActivity(intent);
    }

    @OnClick({R.id.appmedis_button_acupuncture_launcher, R.id.appmedis_button_stroke_launcher, R.id.appmedis_button_heart_launcher})
    public void onApplicationLauncherChoose(Button pressedButton)
    {
        for (final Button guessedButton : this.buttonLauncherWrapper)
        {
            if (pressedButton == guessedButton)
            {
                pressedButton.setSelected(!pressedButton.isSelected());
                if (pressedButton.isSelected())
                {
                    if (pressedButton == this.buttonAcupuncture)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_acupuncture_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_acupuncture_logo);
                    }
                    else if (pressedButton == this.buttonStroke)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_stroke_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_stroke_logo);
                    }
                    else if (pressedButton == this.buttonHeart)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_heart_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_heart_logo);
                    }
                }
                else
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_logo);
                }
            }
            else
            {
                guessedButton.setSelected(false);
            }
        }
    }

    @OnLongClick({R.id.appmedis_button_acupuncture_launcher, R.id.appmedis_button_stroke_launcher, R.id.appmedis_button_heart_launcher})
    public boolean onApplicationLauncherPressed(Button pressedButton)
    {
        for (final Button guessedButton : this.buttonLauncherWrapper)
        {
            if (pressedButton == guessedButton)
            {
                pressedButton.setSelected(true);
                if (pressedButton == this.buttonAcupuncture)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_acupuncture_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_acupuncture_logo);
                    Toast.makeText(this, "Acupuncture Launch", Toast.LENGTH_SHORT).show();
                }
                else if (pressedButton == this.buttonStroke)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_stroke_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_stroke_logo);
                    //Toast.makeText(this, "Stroke Launch", Toast.LENGTH_SHORT).show();
//                    Intent intent = super.getPackageManager().getLaunchIntentForPackage("id.ac.ub.filkom.sekcv.astech.controller.main_sub_app");
//                    if(intent != null)
//                    {
//                        // We found the activity now start the activity
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        super.startActivity(intent);
//                        super.finish();
//                    }
//                    else
//                    {
//                        // Bring user to the market or let them choose an app?
//                        Toast.makeText(this, "Cannot find app", Toast.LENGTH_LONG).show();
//                    }
                    startActivity(new Intent(this, id.ac.ub.filkom.sekcv.astech.controller.MainPage.class));
                }
                else if (pressedButton == this.buttonHeart)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appmedis_heart_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.appmedis_heart_logo);
                    Toast.makeText(this, "Heart Launch", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                guessedButton.setSelected(false);
            }
        }
        return true;
    }
}
