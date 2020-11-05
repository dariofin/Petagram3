package com.dariofinelli.petagram3.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.adapter.AdapterPet;
import com.dariofinelli.petagram3.pojo.Pet;
import com.dariofinelli.petagram3.presenter.IRecyclerViewMainFragmentPresenter;
import com.dariofinelli.petagram3.presenter.RecyclerViewMainFragmentPresenter;

import java.util.ArrayList;

public class MainFragment extends Fragment implements IRecyclerViewMainFragment {

    ArrayList<Pet> pets;
    private RecyclerView listPets;
    private IRecyclerViewMainFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vFragment = inflater.inflate(R.layout.fragment_main, container, false);

        listPets = (RecyclerView) vFragment.findViewById(R.id.rvPets);
        presenter = new RecyclerViewMainFragmentPresenter(this, getContext());

        return vFragment;
    }

    @Override
    public void generateLinearLayout() {
        LinearLayoutManager linearLManager = new LinearLayoutManager(getActivity());
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
