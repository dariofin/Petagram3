package com.dariofinelli.petagram3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.adapter.AdapterDataPet;
import com.dariofinelli.petagram3.pojo.DataPet;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PetData extends Fragment {

    ArrayList<DataPet> dataPet;
    private RecyclerView listDataPet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vFragmentPetData = inflater.inflate(R.layout.fragment_pet_data, container, false);

        CircularImageView circularImageView = vFragmentPetData.findViewById(R.id.cImagePet);
        circularImageView.setCircleColor(R.color.circuler_color);
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(R.color.circuler_boder);
        circularImageView.setShadowEnable(true);

        listDataPet = vFragmentPetData.findViewById(R.id.rvPetData);

        GridLayoutManager gLayoutDataPet = new GridLayoutManager(getContext(), 3);

        listDataPet.setLayoutManager(gLayoutDataPet);
        initializeListDataPet();
        initializaAdapterDataPet();

        return vFragmentPetData;
    }

    public void initializaAdapterDataPet() {
        AdapterDataPet adapterDataPet = new AdapterDataPet(dataPet);
        listDataPet.setAdapter(adapterDataPet);
    }

    public void initializeListDataPet() {

        dataPet = new ArrayList<>();

        dataPet.add(new DataPet(R.drawable.perro_1_1, "4"));
        dataPet.add(new DataPet(R.drawable.perro_1_2, "8"));
        dataPet.add(new DataPet(R.drawable.perro_1_3, "9"));
        dataPet.add(new DataPet(R.drawable.perro_1_4, "5"));
        dataPet.add(new DataPet(R.drawable.perro_1_5, "6"));
        dataPet.add(new DataPet(R.drawable.perro_1_6, "3"));
        dataPet.add(new DataPet(R.drawable.perro_1_7, "10"));
        dataPet.add(new DataPet(R.drawable.perro_1_8, "7"));
        dataPet.add(new DataPet(R.drawable.perro_1_9, "4"));
    }

}
