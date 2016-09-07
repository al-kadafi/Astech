package id.ac.ub.filkom.sekcv.astech.controller.main_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import id.ac.ub.filkom.sekcv.appstroke.R;

public class Help extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarhelp);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.astech);
        toolbar.setLogoDescription("Astech");
        toolbar.setTitle("Astech");

        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[]{
                "Mulai aplikasi",
                "Memilih aplikasi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);
                if(itemPosition == 1){

                }
                switch (itemPosition){
                    case 0:
                        Intent intent = new Intent(Help.this, HelpLogin.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent penggunaan = new Intent(Help.this, HelpPenggunaan.class);
                        startActivity(penggunaan);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                }

            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Help.this, MainActivity.class);
        startActivity(intent);
    }
}
