package com.dariofinelli.petagram3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram3.R;
import com.dariofinelli.petagram3.db.BuilderPets;
import com.dariofinelli.petagram3.pojo.Pet;

import java.util.ArrayList;

public class AdapterPet extends RecyclerView.Adapter<AdapterPet.PetViewHolder> {

    ArrayList<Pet> pets;
    Context context;

    public AdapterPet(ArrayList<Pet> pets, Context context) {
        this.context = context;
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder petViewHolder, int position) {

        final Pet pet = pets.get(position);
        petViewHolder.ivpetImage.setImageResource(pet.getPetImage());
        petViewHolder.tvpetName.setText(pet.getPetName());
        petViewHolder.tvpetRaiting.setText(String.valueOf(pet.getPetRaiting()));
        petViewHolder.ibboneWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int raitingStart = 0;
                int raitingEnd = 0;
                int raitingNew = 0;
                BuilderPets builderPets = new BuilderPets(context);
                builderPets.raitingPet(pet);
                raitingStart = pet.getPetRaiting();
                raitingEnd = builderPets.numberRaitingPet(pet);
                raitingNew = raitingStart + raitingEnd;
                petViewHolder.tvpetRaiting.setText(String.valueOf(raitingNew));
                builderPets.updatePets(pet, raitingNew);
                builderPets.updateFavoritePets(pet);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivpetImage;
        private TextView tvpetName;
        private TextView tvpetRaiting;
        private ImageButton ibboneWhite;

        public PetViewHolder(@NonNull View itemView) {

            super(itemView);
            ivpetImage = (ImageView) itemView.findViewById(R.id.ivpetImage);
            tvpetName = (TextView) itemView.findViewById(R.id.tvpetName);
            tvpetRaiting = (TextView) itemView.findViewById(R.id.tvpetRaiting);
            ibboneWhite = (ImageButton) itemView.findViewById(R.id.ibboneWhite);

        }

    }

}
