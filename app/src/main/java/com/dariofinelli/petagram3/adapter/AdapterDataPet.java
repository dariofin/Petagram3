package com.dariofinelli.petagram3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.pojo.DataPet;

import java.util.ArrayList;

public class AdapterDataPet extends RecyclerView.Adapter<AdapterDataPet.DataPetViewHolder> {

    ArrayList<DataPet> dataPet;

    public AdapterDataPet(ArrayList<DataPet> dataPet) {
        this.dataPet = dataPet;
    }

    @NonNull
    @Override
    public DataPetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_data_pet, parent, false);
        return new DataPetViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull DataPetViewHolder petViewHolder, int position) {

        DataPet pet = dataPet.get(position);
        petViewHolder.ivpetImage.setImageResource(pet.getPetImage());
        petViewHolder.tvpetRaiting.setText(pet.getPetRaiting());

    }

    @Override
    public int getItemCount() {
        return dataPet.size();
    }

    public static class DataPetViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivpetImage;
        private TextView tvpetRaiting;

        public DataPetViewHolder(@NonNull View itemView) {

            super(itemView);
            ivpetImage = (ImageView) itemView.findViewById(R.id.ivpetImage);
            tvpetRaiting = (TextView) itemView.findViewById(R.id.tvpetRaiting);

        }

    }
}
