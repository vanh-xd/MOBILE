package com.example.k234112eapp.dals;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.k234112eapp.models.Category;

import java.util.ArrayList;

public class CategoryDAO {

    public static final String DATABASE_NAME = "K234112ESales.db";
    public static final String TABLE_NAME = "Category";
    public static SQLiteDatabase database = null;

    public static ArrayList<Category> getCategories(Context context)
    {
        ArrayList<Category> categories = new ArrayList<>();
        database = context.openOrCreateDatabase("Ecommerce",
                Context.MODE_PRIVATE, null);

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int songCode = cursor.getInt(1);
            String songName = cursor.getString(2);
            String singer = cursor.getString(3);
            int favourite = cursor.getInt(4);
//To do something ….
        }
        cursor.close();

        return categories;
    }
}
