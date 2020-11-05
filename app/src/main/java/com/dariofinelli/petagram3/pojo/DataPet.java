package com.dariofinelli.petagram3.pojo;

public class DataPet {

    private int petImage;
    private String petRaiting;

    public DataPet(int petImage, String petRaiting) {

        this.petImage = petImage;
        this.petRaiting = petRaiting;

    }

    public int getPetImage() {
        return petImage;
    }

    public void setPetImage(int petImage) {
        this.petImage = petImage;
    }

    public String getPetRaiting() {
        return petRaiting;
    }

    public void setPetRaiting(String petRaiting) {
        this.petRaiting = petRaiting;
    }
}
