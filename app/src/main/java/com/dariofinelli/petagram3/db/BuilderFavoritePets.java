package com.dariofinelli.petagram3.db;

import android.content.Context;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public class BuilderFavoritePets {

    private Context context;

    public BuilderFavoritePets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> queryFavoritePets() {

        ArrayList<Pet> pets = new ArrayList<Pet>();

        pets.add(new Pet(R.drawable.perro_2, "Perrito dos", 2));
        pets.add(new Pet(R.drawable.gato_4, "Gato cuatro", 3));
        pets.add(new Pet(R.drawable.perro_3, "Perrito tres", 1));
        pets.add(new Pet(R.drawable.perro_1, "Perrito uno", 6));
        pets.add(new Pet(R.drawable.perro_4, "Perrito cuatro", 9));

        return pets;
    }
}
