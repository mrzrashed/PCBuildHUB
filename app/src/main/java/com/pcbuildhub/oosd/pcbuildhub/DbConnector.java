package com.pcbuildhub.oosd.pcbuildhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbConnector extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "UserData.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_TYPE = "user_type";

    //configuration table
    private static final String TABLE_CONFIGURATION = "configurations";

    //user log table
    private static final String TABLE_USER_LOG = "userlog";

    //userlog table Columns names
    private static final String USERLOG_ITEM_ID = "item_id";
    private static final String USERLOG_MONITOR_NAME = "monitor_name";
    private static final String USERLOG_MONITOR_PRICE = "monitor_price";
    private static final String USERLOG_PROCESSOR_NAME = "processor_name";
    private static final String USERLOG_PROCESSOR_PRICE = "processor_price";
    private static final String USERLOG_MOTHERBOARD_NAME = "motherboard_name";
    private static final String USERLOG_MOTHERBOARD_PRICE = "motherboard_price";
    private static final String USERLOG_GPU_NAME = "gpu_name";
    private static final String USERLOG_GPU_PRICE = "gpu_price";
    private static final String USERLOG_HDD_NAME = "hdd_name";
    private static final String USERLOG_HDD_PRICE = "hdd_price";
    private static final String USERLOG_RAM_NAME = "ram_name";
    private static final String USERLOG_RAM_PRICE = "ram_price";
    private static final String USERLOG_TOTAL_PRICE = "total_price";

    //configuration Columns names
    private static final String CONFIGURATION_ITEM_ID = "item_id";
    private static final String CONFIGURATION_MONITOR_NAME = "monitor_name";
    private static final String CONFIGURATION_MONITOR_PRICE = "monitor_price";
    private static final String CONFIGURATION_PROCESSOR_NAME = "processor_name";
    private static final String CONFIGURATION_PROCESSOR_PRICE = "processor_price";
    private static final String CONFIGURATION_MOTHERBOARD_NAME = "motherboard_name";
    private static final String CONFIGURATION_MOTHERBOARD_PRICE = "motherboard_price";
    private static final String CONFIGURATION_GPU_NAME = "gpu_name";
    private static final String CONFIGURATION_GPU_PRICE = "gpu_price";
    private static final String CONFIGURATION_HDD_NAME = "hdd_name";
    private static final String CONFIGURATION_HDD_PRICE = "hdd_price";
    private static final String CONFIGURATION_RAM_NAME = "ram_name";
    private static final String CONFIGURATION_RAM_PRICE = "ram_price";
    private static final String CONFIGURATION_TOTAL_PRICE = "total_price";

    // create table sql query

    //for user table
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_NAME + " TEXT PRIMARY KEY," + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_TYPE + " TEXT" + ")";

    //for configuration table
    private String CREATE_CONFIGURATION_TABLE = "CREATE TABLE " + TABLE_CONFIGURATION + "("
            + CONFIGURATION_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + CONFIGURATION_MONITOR_NAME + " TEXT,"
            + CONFIGURATION_MONITOR_PRICE + " INTEGER,"
            + CONFIGURATION_PROCESSOR_NAME + " TEXT,"
            + CONFIGURATION_PROCESSOR_PRICE + " INTEGER,"
            + CONFIGURATION_MOTHERBOARD_NAME + " TEXT,"
            + CONFIGURATION_MOTHERBOARD_PRICE + " INTEGER,"
            + CONFIGURATION_GPU_NAME + " TEXT,"
            + CONFIGURATION_GPU_PRICE + " INTEGER,"
            + CONFIGURATION_HDD_NAME + " TEXT,"
            + CONFIGURATION_HDD_PRICE + " INTEGER,"
            + CONFIGURATION_RAM_NAME + " TEXT,"
            + CONFIGURATION_RAM_PRICE + " INTEGER,"
            + CONFIGURATION_TOTAL_PRICE + " INTEGER"
            + ")";
    //query for creating userlog table
    private String CREATE_USERLOG_TABLE = "CREATE TABLE " + TABLE_USER_LOG + "("
            + USERLOG_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + USERLOG_MONITOR_NAME + " TEXT,"
            + USERLOG_MONITOR_PRICE + " INTEGER,"
            + USERLOG_PROCESSOR_NAME + " TEXT,"
            + USERLOG_PROCESSOR_PRICE + " INTEGER,"
            + USERLOG_MOTHERBOARD_NAME + " TEXT,"
            + USERLOG_MOTHERBOARD_PRICE + " INTEGER,"
            + USERLOG_GPU_NAME + " TEXT,"
            + USERLOG_GPU_PRICE + " INTEGER,"
            + USERLOG_HDD_NAME + " TEXT,"
            + USERLOG_HDD_PRICE + " INTEGER,"
            + USERLOG_RAM_NAME + " TEXT,"
            + USERLOG_RAM_PRICE + " INTEGER,"
            + USERLOG_TOTAL_PRICE + " INTEGER"
            + ")";


    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_CONFIGURATION_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONFIGURATION;
    private String DROP_USERLOG_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_LOG;

    public DbConnector(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_USER_TABLE);
        database.execSQL(CREATE_CONFIGURATION_TABLE);
        database.execSQL(CREATE_USERLOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL(DROP_USER_TABLE);
        database.execSQL(DROP_CONFIGURATION_TABLE);
        database.execSQL(DROP_USERLOG_TABLE);
        //create tables again
        onCreate(database);
    }

    //this is for user registration
    public void insertData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_TYPE,user.getUserType());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    //for inserting demo configurations
    public void insertConfiguration() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONFIGURATION_MONITOR_NAME, "HP ELITEDISPLAY E223 21.5-INCH MONITOR");
        values.put(CONFIGURATION_MONITOR_PRICE, 12000);
        values.put(CONFIGURATION_PROCESSOR_NAME, "Intel Coffee Lake Core i3 8100 3.60GHz, 4 Core, 6MB Cache LGA1151 8th Gen");
        values.put(CONFIGURATION_PROCESSOR_PRICE, 10400);
        values.put(CONFIGURATION_MOTHERBOARD_NAME, "Gigabyte Z370 AORUS Gaming 5 DDR4 8th Gen Intel LGA 1151 Socket Mainboard");
        values.put(CONFIGURATION_MOTHERBOARD_PRICE, 19700);
        values.put(CONFIGURATION_GPU_NAME, "Asus ROG STRIX Z370-H GAMING DDR4 8th Gen Intel LGA1151 Socket Mainboard");
        values.put(CONFIGURATION_GPU_PRICE, 18000);
        values.put(CONFIGURATION_HDD_NAME, "Toshiba 1tera-byte");
        values.put(CONFIGURATION_HDD_PRICE, 4000);
        values.put(CONFIGURATION_RAM_NAME, "8GB");
        values.put(CONFIGURATION_RAM_PRICE, 6900);
        values.put(CONFIGURATION_TOTAL_PRICE, 60000);

        db.insert(TABLE_CONFIGURATION,null,values);
        db.close();
    }

    //for inserting data into userlog table
    public boolean addaDataIntoUserlogTable(String moniName,int moniPrice,String procsName,int procsPrice,String mothName,int mothPrice,String hddName,int hddPrice,String gpuName,int gpuPrice,String ramName
                                        ,int ramPrice,int totalPrice) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERLOG_MONITOR_NAME, moniName);
        values.put(USERLOG_MONITOR_PRICE, moniPrice);
        values.put(USERLOG_PROCESSOR_NAME,procsName);
        values.put(USERLOG_PROCESSOR_PRICE, procsPrice);
        values.put(USERLOG_MOTHERBOARD_NAME, mothName);
        values.put(USERLOG_MOTHERBOARD_PRICE, mothPrice);
        values.put(USERLOG_GPU_NAME, gpuName);
        values.put(USERLOG_GPU_PRICE, gpuPrice);
        values.put(USERLOG_HDD_NAME, hddName);
        values.put(USERLOG_HDD_PRICE, hddPrice);
        values.put(USERLOG_RAM_NAME, ramName);
        values.put(USERLOG_RAM_PRICE, ramPrice);
        values.put(USERLOG_TOTAL_PRICE, totalPrice);

        db.insert(TABLE_USER_LOG,null,values);
        db.close();
        return  true;
    }



    //for inserting new configurations by admin
    public boolean addNewConfiguration(String monitorN,int monitorP,String processorN,int processorP,String motherboardN,int motherboardP,String gpuN, int gpuP,String hddN,int hddP,String ramN,int ramP,int totalPrice) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(CONFIGURATION_MONITOR_NAME, monitorN);
        values.put(CONFIGURATION_MONITOR_PRICE, monitorP);
        values.put(CONFIGURATION_PROCESSOR_NAME, processorN);
        values.put(CONFIGURATION_PROCESSOR_PRICE, processorP);
        values.put(CONFIGURATION_MOTHERBOARD_NAME, motherboardN);
        values.put(CONFIGURATION_MOTHERBOARD_PRICE, motherboardP);
        values.put(CONFIGURATION_GPU_NAME, gpuN);
        values.put(CONFIGURATION_GPU_PRICE, gpuP);
        values.put(CONFIGURATION_HDD_NAME, hddN);
        values.put(CONFIGURATION_HDD_PRICE, hddP);
        values.put(CONFIGURATION_RAM_NAME, ramN);
        values.put(CONFIGURATION_RAM_PRICE, ramP);
        values.put(CONFIGURATION_TOTAL_PRICE, totalPrice);

        db.insert(TABLE_CONFIGURATION,null,values);
        db.close();
        return true;
    }

    //for updating configurations by admin
    public boolean updateConfiguration(int id,String monitorN,int monitorP,String processorN,int processorP,String motherboardN,int motherboardP,String gpuN, int gpuP,String hddN,int hddP,String ramN,int ramP,int totalPrice)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(CONFIGURATION_MONITOR_NAME, monitorN);
        values.put(CONFIGURATION_MONITOR_PRICE, monitorP);
        values.put(CONFIGURATION_PROCESSOR_NAME, processorN);
        values.put(CONFIGURATION_PROCESSOR_PRICE, processorP);
        values.put(CONFIGURATION_MOTHERBOARD_NAME, motherboardN);
        values.put(CONFIGURATION_MOTHERBOARD_PRICE, motherboardP);
        values.put(CONFIGURATION_GPU_NAME, gpuN);
        values.put(CONFIGURATION_GPU_PRICE, gpuP);
        values.put(CONFIGURATION_HDD_NAME, hddN);
        values.put(CONFIGURATION_HDD_PRICE, hddP);
        values.put(CONFIGURATION_RAM_NAME, ramN);
        values.put(CONFIGURATION_RAM_PRICE, ramP);
        values.put(CONFIGURATION_TOTAL_PRICE, totalPrice);

        db.update(TABLE_CONFIGURATION,values,"item_id = ?",new String[]{String.valueOf(id)});
        db.close();
        return true;
    }

    /**
     * This method to check user exist or not
     * @paramsone email
     * @paramtwo password
     * @return true/false
     */
    public boolean checkwithdatabase(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }else{
            return false;
        }
    }
    public boolean checkUser(String email){

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }else{
            return false;
        }
    }


    //get recommendation from db
    public List<Configurations> recommendation() {
        List<Configurations>configurations = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CONFIGURATION,null,null,null,null,null,null);

        if(cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{
                    int itemId = cursor.getInt(cursor.getColumnIndex(CONFIGURATION_ITEM_ID));
                    String monitorName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_MONITOR_NAME));
                    int monitorPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_MONITOR_PRICE));
                    String processorName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_PROCESSOR_NAME));
                    int processorPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_PROCESSOR_PRICE));
                    String motherboardName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_MOTHERBOARD_NAME));
                    int motherboardPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_MOTHERBOARD_PRICE));
                    String gpuName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_GPU_NAME));
                    int gpuPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_GPU_PRICE));
                    String hddName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_HDD_NAME));
                    int hddPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_HDD_PRICE));
                    String ramName= cursor.getString(cursor.getColumnIndex(CONFIGURATION_RAM_NAME));
                    int ramPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_RAM_PRICE));
                    int totalPrice= cursor.getInt(cursor.getColumnIndex(CONFIGURATION_TOTAL_PRICE));

                    Configurations configs = new Configurations(itemId,monitorName,monitorPrice,processorName,processorPrice,motherboardName,motherboardPrice,gpuName,gpuPrice,hddName,hddPrice,ramName,ramPrice,totalPrice);
                    configurations.add(configs);
                }while (cursor.moveToNext());
        }
        cursor.close();
        return  configurations;

    }


}
