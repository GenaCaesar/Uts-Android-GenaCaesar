package com.example.drakorsyn.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Drakor implements Parcelable {

    private String nama;
    private String genre;
    private String foto;
    private String deskripsi;
    private String pemeran;

    public String getPemeran() {
        return pemeran;
    }

    public void setPemeran(String pemeran) {
        this.pemeran = pemeran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Drakor() {
    }

    protected Drakor(Parcel in) {
        nama = in.readString();
        genre = in.readString();
        foto = in.readString();
        deskripsi = in.readString();
        pemeran = in.readString();
    }

    public static final Creator<Drakor> CREATOR = new Creator<Drakor>() {
        @Override
        public Drakor createFromParcel(Parcel in) {
            return new Drakor(in);
        }

        @Override
        public Drakor[] newArray(int size) {
            return new Drakor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(genre);
        parcel.writeString(foto);
        parcel.writeString(deskripsi);
        parcel.writeString(pemeran);
    }
}
