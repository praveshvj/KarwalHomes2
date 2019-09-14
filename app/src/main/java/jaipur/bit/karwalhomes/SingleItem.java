package jaipur.bit.karwalhomes;


import android.util.Log;

public class SingleItem {

    private String address;
    private int houserent;
    private int image;

    SingleItem() {

    }

    public int getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRent() {
        return houserent;
    }

    public void setRent(int houserent) {
        this.houserent = houserent;
    }

    SingleItem(int image, int houserent, String address) {
        this.address = address;
        this.image = image;
        this.houserent = houserent;
    }
}