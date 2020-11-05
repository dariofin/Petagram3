package com.dariofinelli.petagram3;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram3.adapter.AdapterPet;
import com.dariofinelli.petagram3.fragment.IRecyclerViewMainFragment;
import com.dariofinelli.petagram3.pojo.Pet;
import com.dariofinelli.petagram3.presenter.IRecyclerViewMainFragmentPresenter;
import com.dariofinelli.petagram3.presenter.RecyclerViewFavoritePetsPresenter;

import java.util.ArrayList;

public class FavoritePets extends AppCompatActivity implements IRecyclerViewMainFragment {

    ArrayList<Pet> pets;
    private RecyclerView listPets;
    private IRecyclerViewMainFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_pets);

        Toolbar actionBarFavoritePets = (Toolbar) findViewById(R.id.actionBarFavoritePets);
        setSupportActionBar(actionBarFavoritePets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listPets = (RecyclerView) findViewById(R.id.rvPets);
        presenter = new RecyclerViewFavoritePetsPresenter(this, this);

    }

    @Override
    public void generateLinearLayout() {

        LinearLayoutManager linearLManager = new LinearLayoutManager(this);
        linearLManager.setOrientation(LinearLayoutManager.VERTICAL);
        listPets.setLayoutManager(linearLManager);

    }

    @Override
    public AdapterPet createAdapterPet(ArrayList<Pet> pets, Context context) {
        AdapterPet adapterPet = new AdapterPet(pets, context);
        return adapterPet;
    }

    @Override
    public void initializeAdapterRecyclerView(AdapterPet adapterPet) {

        listPets.setAdapter(adapterPet);

    }
}
