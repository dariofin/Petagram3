package com.dariofinelli.petagram3.db;

import android.content.ContentValues;
import android.content.Context;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public class BuilderPets {

    private static final int raiting = 1;
    private Context context;

    public BuilderPets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> queryPets() {

        Database db = new Database(context);
        insertPets(db);
        return db.queryAllPets();
    }

    public ArrayList<Pet> queryFavoritePets() {
        Database db = new Database(context);
        return db.queryAllFavoritePets();
    }

    public void insertPets(Database db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Perrito uno");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.perro_1);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 5);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Gato uno");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.gato_1);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 6);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Perrito dos");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.perro_2);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 1);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Gato dos");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.gato_2);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 3);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Perrito tres");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.perro_3);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 0);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Gato tres");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.gato_3);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 4);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Perrito cuatro");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.perro_4);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 8);
        db.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_PETS_NAME, "Gato cuatro");
        contentValues.put(ConstantDatabase.TABLE_PETS_IMAGE, R.drawable.gato_4);
        contentValues.put(ConstantDatabase.TABLE_PETS_RAITING, 2);
        db.insertPet(contentValues);
    }

    public void raitingPet(Pet pet) {
        Database db = new Database(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_RAITING_PETS_ID_PETS, pet.getId());
        contentValues.put(ConstantDatabase.TABLE_RAITING_PETS_NUMBER_RAITING, raiting);
        db.insertRaitingPet(contentValues);
    }

    public int numberRaitingPet(Pet pet) {
        Database db = new Database(context);
        return db.numberRaitingPet(pet);
    }

    public void updatePets(Pet pet, int raiting) {
        Database db = new Database(context);
        db.updatePets(pet, raiting);
    }

    public void updateFavoritePets(Pet pet) {
        Database db = new Database(context);
        db.updateFavoritePets(pet);
    }

}
