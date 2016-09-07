package id.ac.ub.filkom.sekcv.astech.controller.main_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by k-dafi on 8/19/2016.
 */
public class DataChecker extends AppCompatActivity {

    Database dbcenter=null;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbcenter = new Database(this);
        SQLiteDatabase db = dbcenter.getReadableDatabase();

        Log.d("db",db.isOpen()+"");
        cursor = db.rawQuery("SELECT * FROM user",null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String status = cursor.getString(4).toString();
            Log.d("status", status + "");
            if(status.equalsIgnoreCase("true")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }
}
