package com.dariofinelli.petagram3.fragment;

import android.content.Context;

import com.dariofinelli.petagram3.adapter.AdapterPet;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewMainFragment {

    public default void generateLinearLayout() {

    }

    AdapterPet createAdapterPet(ArrayList<Pet> pets, Context context);

    void initializeAdapterRecyclerView(AdapterPet adapterPet);
}
