package com.dariofinelli.petagram3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private Context context;

    public Database(@Nullable Context context) {
        super(context, ConstantDatabase.DATABASE_NAME, null, ConstantDatabase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantDatabase.TABLE_PETS + "(" +
                ConstantDatabase.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDatabase.TABLE_PETS_NAME + " TEXT, " +
                ConstantDatabase.TABLE_PETS_IMAGE + " INTEGER, " +
                ConstantDatabase.TABLE_PETS_RAITING + " INTEGER" +
                ")";

        String queryCrearTablaMascotasRaiting = "CREATE TABLE " + ConstantDatabase.TABLE_RAITING_PETS + "(" +
                ConstantDatabase.TABLE_RAITING_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDatabase.TABLE_RAITING_PETS_ID_PETS + " INTEGER, " +
                ConstantDatabase.TABLE_RAITING_PETS_NUMBER_RAITING + " INTEGER, " +
                "FOREIGN KEY (" + ConstantDatabase.TABLE_RAITING_PETS_ID_PETS + ") " +
                "REFERENCES " + ConstantDatabase.TABLE_PETS + "(" + ConstantDatabase.TABLE_PETS_ID + ")" +
                ")";

        String queryCrearTablaMascotasFavoritas = "CREATE TABLE " + ConstantDatabase.TABLE_FAVORITE_PETS + "(" +
                ConstantDatabase.TABLE_FAVORITE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDatabase.TABLE_FAVORITE_PETS_ID_PETS + " INTEGER, " +
                ConstantDatabase.TABLE_FAVORITE_PETS_NAME + " TEXT, " +
                ConstantDatabase.TABLE_FAVORITE_PETS_IMAGE + " INTEGER, " +
                ConstantDatabase.TABLE_FAVORITE_PETS_RAITING + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaMascotasRaiting);
        db.execSQL(queryCrearTablaMascotasFavoritas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDatabase.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDatabase.TABLE_RAITING_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDatabase.TABLE_FAVORITE_PETS);
        onCreate(db);
    }

    public ArrayList<Pet> queryAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantDatabase.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(0));
            petActual.setPetName(registros.getString(1));
            petActual.setPetImage(registros.getInt(2));
            petActual.setPetRaiting(registros.getInt(3));

            pets.add(petActual);

        }

        db.close();

        return pets;
    }

    public Pet queryPet(Pet pet) {

        Pet updatePet = new Pet();

        String query = "SELECT * FROM " + ConstantDatabase.TABLE_PETS + " WHERE " + ConstantDatabase.TABLE_PETS_ID +
                " = " + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataPet = db.rawQuery(query, null);

        while (dataPet.moveToNext()) {
            updatePet.setId(dataPet.getInt(0));
            updatePet.setPetName(dataPet.getString(1));
            updatePet.setPetImage(dataPet.getInt(2));
            updatePet.setPetRaiting(dataPet.getInt(3));

        }

        db.close();

        return updatePet;

    }

    public void insertPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDatabase.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertRaitingPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDatabase.TABLE_RAITING_PETS, null, contentValues);
        db.close();
    }

    public int numberRaitingPet(Pet pet) {
        int raiting = 0;

        String query = "SELECT COUNT (" + ConstantDatabase.TABLE_RAITING_PETS_NUMBER_RAITING + ") FROM " + ConstantDatabase.TABLE_RAITING_PETS +
                " WHERE " + ConstantDatabase.TABLE_RAITING_PETS_ID_PETS + " = " + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registroRaiting = db.rawQuery(query, null);

        if (registroRaiting.moveToNext()) {
            raiting = registroRaiting.getInt(0);
        }

        db.close();

        return raiting;
    }

    public void updatePets(Pet pet, int raiting) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, raiting);

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantDatabase.TABLE_PETS, contentValues, ConstantDatabase.TABLE_PETS_ID + " = " + pet.getId(), null);
        db.close();

    }

    public void updateFavoritePets(Pet pet) {

        Pet updatePet = queryPet(pet);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_FAVORITE_PETS_ID_PETS, updatePet.getId());
        contentValues.put(ConstantDatabase.TABLE_FAVORITE_PETS_NAME, updatePet.getPetName());
        contentValues.put(ConstantDatabase.TABLE_FAVORITE_PETS_IMAGE, updatePet.getPetImage());
        contentValues.put(ConstantDatabase.TABLE_FAVORITE_PETS_RAITING, updatePet.getPetRaiting());

        String query = "SELECT * FROM " + ConstantDatabase.TABLE_FAVORITE_PETS +
                " WHERE " + ConstantDatabase.TABLE_FAVORITE_PETS_ID_PETS + " = " + updatePet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registroFavorite = db.rawQuery(query, null);

        if (registroFavorite.moveToFirst()) {
            updateDataFavorite(contentValues);
        } else {
            insertDataFavorite(contentValues);
        }
    }

    public void updateDataFavorite(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantDatabase.TABLE_FAVORITE_PETS, contentValues, ConstantDatabase.TABLE_FAVORITE_PETS_ID_PETS + " = " + contentValues.get(ConstantDatabase.TABLE_FAVORITE_PETS_ID_PETS), null);
        db.close();
    }

    public void insertDataFavorite(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDatabase.TABLE_FAVORITE_PETS, null, contentValues);
        db.close();
    }

    public ArrayList<Pet> queryAllFavoritePets() {

        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantDatabase.TABLE_FAVORITE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(1));
            petActual.setPetName(registros.getString(2));
            petActual.setPetImage(registros.getInt(3));
            petActual.setPetRaiting(registros.getInt(4));

            pets.add(petActual);

        }

        db.close();
        return pets;
    }

}
