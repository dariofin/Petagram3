package com.dariofinelli.petagram3.pojo;

public class Pet {

    private int id;
    private int petImage;
    private String petName;
    private int petRaiting;

    public Pet(int petImage, String petName, int petRaiting) {

        this.petImage = petImage;
        this.petName = petName;
        this.petRaiting = petRaiting;

    }

    public Pet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetImage() {
        return petImage;
    }

    public void setPetImage(int petImage) {
        this.petImage = petImage;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetRaiting() {
        return petRaiting;
    }

    public void setPetRaiting(int petRaiting) {
        this.petRaiting = petRaiting;
    }
}
