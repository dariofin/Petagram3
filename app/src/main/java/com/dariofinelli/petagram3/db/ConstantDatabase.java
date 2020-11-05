package com.dariofinelli.petagram3.db;

public final class ConstantDatabase {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS = "mascota";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NAME = "name";
    public static final String TABLE_PETS_IMAGE = "image";
    public static final String TABLE_PETS_RAITING = "raiting";

    public static final String TABLE_RAITING_PETS = "mascotas_raiting";
    public static final String TABLE_RAITING_PETS_ID = "id";
    public static final String TABLE_RAITING_PETS_ID_PETS = "id_mascota";
    public static final String TABLE_RAITING_PETS_NUMBER_RAITING = "numero_raiting";

    public static final String TABLE_FAVORITE_PETS = "mascotas_favoritas";
    public static final String TABLE_FAVORITE_PETS_ID = "id";
    public static final String TABLE_FAVORITE_PETS_ID_PETS = "id_mascota";
    public static final String TABLE_FAVORITE_PETS_NAME = "name";
    public static final String TABLE_FAVORITE_PETS_IMAGE = "image";
    public static final String TABLE_FAVORITE_PETS_RAITING = "raiting";
}
