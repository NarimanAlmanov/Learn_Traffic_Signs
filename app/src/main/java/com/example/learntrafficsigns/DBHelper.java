package com.example.learntrafficsigns;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TrafficSigns.db";
    private static String DB_PATH;
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TrafficSigns";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_PICTURE = "picture";
    private Context myContext;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext=context;
        DB_PATH = context.getFilesDir().getPath() + DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Ничего не делаем здесь, так как ваша база данных уже создана
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ничего не делаем здесь, так как ваша база данных уже создана
    }

    void create_db(){

        File file = new File(DB_PATH);

            //получаем локальную бд как поток
            try(InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());
            }

    }


    // Метод для получения всех элементов из базы данных
    public List<TrafficSign> getAllItems() {
        List<TrafficSign> itemList = new ArrayList<>();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
            int nameColumnIndex = cursor.getColumnIndex(COLUMN_NAME);
            int categoryColumnIndex = cursor.getColumnIndex(COLUMN_CATEGORY);
            int pictureFileNameColumnIndex = cursor.getColumnIndex(COLUMN_PICTURE);

            do {
                if (idColumnIndex != -1 && nameColumnIndex != -1 && categoryColumnIndex != -1 && pictureFileNameColumnIndex != -1) {
                    int id = cursor.getInt(idColumnIndex);
                    String name = cursor.getString(nameColumnIndex);
                    String category = cursor.getString(categoryColumnIndex);
                    String pictureFileName = cursor.getString(pictureFileNameColumnIndex);
                    TrafficSign item = new TrafficSign(id, name, category, pictureFileName);
                    itemList.add(item);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return itemList;
    }

    public List<TrafficSign> getItemsByCategory(String category) {
        List<TrafficSign> itemList = new ArrayList<>();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_CATEGORY + "=?", new String[]{category}, null, null, null);
        if (cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
            int nameColumnIndex = cursor.getColumnIndex(COLUMN_NAME);
            int categoryColumnIndex = cursor.getColumnIndex(COLUMN_CATEGORY);
            int pictureFileNameColumnIndex = cursor.getColumnIndex(COLUMN_PICTURE);
            do {
                if (idColumnIndex != -1 && nameColumnIndex != -1 && categoryColumnIndex != -1 && pictureFileNameColumnIndex != -1) {
                    int id = cursor.getInt(idColumnIndex);
                    String name = cursor.getString(nameColumnIndex);
                    String category1 = cursor.getString(categoryColumnIndex);
                    String pictureFileName = cursor.getString(pictureFileNameColumnIndex);
                    TrafficSign item = new TrafficSign(id, name, category1, pictureFileName);
                    itemList.add(item);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return itemList;
    }
}

