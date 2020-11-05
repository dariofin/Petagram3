package com.dariofinelli.petagram3.presenter;

import android.content.Context;

import com.dariofinelli.petagram3.db.BuilderPets;
import com.dariofinelli.petagram3.fragment.IRecyclerViewMainFragment;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;


public class RecyclerViewMainFragmentPresenter implements IRecyclerViewMainFragmentPresenter {

    private IRecyclerViewMainFragment iRecyclerViewMainFragment;
    private Context context;
    private BuilderPets builderPets;
    private ArrayList<Pet> pets;

    public RecyclerViewMainFragmentPresenter(IRecyclerViewMainFragment iRecyclerViewMainFragment, Context context) {
        this.iRecyclerViewMainFragment = iRecyclerViewMainFragment;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {

        builderPets = new BuilderPets(context);
        pets = builderPets.queryPets();
        mostrarMascotas();

    }

    @Override
    public void mostrarMascotas() {

        iRecyclerViewMainFragment.initializeAdapterRecyclerView(iRecyclerViewMainFragment.createAdapterPet(pets, context));
        iRecyclerViewMainFragment.generateLinearLayout();
    }
}
