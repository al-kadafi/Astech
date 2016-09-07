package id.ac.ub.filkom.sekcv.astech.controller.main_sub_app;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import id.ac.ub.filkom.sekcv.appstroke.R;

public class Helppage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.appmedis_launcher_helppage_container);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appmedis_helppage_toolbar);
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
                    Helppage.this.onBackButtonPressed();
                }
            });
        }
    }

    //---------------------------------------------------------------------------------------------
    //----------------Listener Button Edit Below---------------------------------------------------
    //---------------------------------------------------------------------------------------------


    private void onBackButtonPressed()
    {
        super.onBackPressed();
    }

}
