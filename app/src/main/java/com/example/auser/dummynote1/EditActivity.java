package com.example.auser.dummynote1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText ed3, ed4;
    long id;
    DB mDbHelper;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        Intent it = getIntent();
        id = it.getLongExtra("id", -1);
        Log.d("DATA", "id:" + id);

        mDbHelper=new DB(this).open();
        c = mDbHelper.getAll();

//        SQLiteDatabase db = SQLiteDatabase.openDatabase(DBInfo.DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
//        Cursor c = db.query("phone", new String[] {"id", "username", "tel"}, "id=?", new String[] {String.valueOf(id)}, null, null, null);
        if (c.moveToFirst())
        {
            ed3.setText(c.getString(1));
            ed4.setText(c.getString(2));
        }
    }

//    public static final String KEY_ROWID="_id";
//    public static final String KEY_NOTE="note";
//    public static final String KEY_CREATED="created";
    public void clickUpdate(View v)
    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(DBInfo.DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);

//        ContentValues cv = new ContentValues();
//        cv.put("note", ed3.getText().toString());
//        cv.put("created", ed4.getText().toString());
//        mDbHelper.update(id);

        boolean b=mDbHelper.update(id,ed3.getText().toString());
        Log.d("id=",id+"");
        Log.d("boolean",b+"");
        mDbHelper.close();
        finish();
    }
    public void clickBack(View v)
    {
        finish();
    }

}

