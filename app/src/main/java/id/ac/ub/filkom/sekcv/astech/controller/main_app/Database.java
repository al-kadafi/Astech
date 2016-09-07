package id.ac.ub.filkom.sekcv.astech.controller.main_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by k-dafi on 8/19/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static final String userTableName = "user";
    public static final String logTableName = "appMedis_jantung";
    private static final String db_name = "astech.db";
    private static final int db_version = 1;
    private Context contex = null;

    public Database(Context context) {

        super(context, db_name, null, db_version);
        contex = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String user_table = "create table IF NOT EXISTS " + userTableName + " (id_user integer not null primary key autoincrement, " +
                "tanggal date not null," +
                "nama varchar(50) not null, " +
                "password varchar(10) not null, " +
                "email varchar(50) not null, " +
                "status varchar(20) not null);";

        String appMedis_jantung = "create table IF NOT EXISTS " + logTableName + " (id_log integer not null primary key autoincrement, " +
                "id_user integer not null, " +
                "usia integer not null, " +
                "kolestrol varchar(30) not null, " +
                "HDL varchar(30) not null, " +
                "LDL varchar(30) not null, " +
                "Trgliserida varchar(30) not null, " +
                "tanggal varchar(30) not null, " +
                "hasil varchar(30) not null);";

        try {
            db.execSQL(user_table);
            db.execSQL(appMedis_jantung);


        } catch (Exception e) {
            Toast.makeText(contex, "create eror : " + e.toString(), Toast.LENGTH_LONG).show();
            Log.d("eror", e.toString() + "");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//        Message.message(context,"onCreate dipanggil");
    }
}
