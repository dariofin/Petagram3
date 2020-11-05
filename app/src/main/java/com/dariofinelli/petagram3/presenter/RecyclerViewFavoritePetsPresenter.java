package com.dariofinelli.petagram3.presenter;

import android.content.Context;

import com.dariofinelli.petagram3.db.BuilderPets;
import com.dariofinelli.petagram3.fragment.IRecyclerViewMainFragment;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFavoritePetsPresenter implements IRecyclerViewMainFragmentPresenter {

    private IRecyclerViewMainFragment iRecyclerViewMainFragment;
    private Context context;
    private BuilderPets builderFavoritePets;
    private ArrayList<Pet> pets;

    public RecyclerViewFavoritePetsPresenter(IRecyclerViewMainFragment iRecyclerViewMainFragment, Context context) {
        this.iRecyclerViewMainFragment = iRecyclerViewMainFragment;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        builderFavoritePets = new BuilderPets(context);
        pets = builderFavoritePets.queryFavoritePets();
        mostrarMascotas();

    }

    @Override
    public void mostrarMascotas() {
        iRecyclerViewMainFragment.initializeAdapterRecyclerView(iRecyclerViewMainFragment.createAdapterPet(pets, context));
        iRecyclerViewMainFragment.generateLinearLayout();

    }
}
