package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            MusicCollection mc = new MusicCollection();
        while (true) {
            String command;
            String searchedAddress;
            Scanner sc = new Scanner(System.in);
            System.out.print("What do you want to do ? (search,add,delete,favorite) :");
            command = sc.nextLine();
            if (Objects.equals(command, "search")) {
                System.out.print("please enter address: ");
                searchedAddress = sc.nextLine();
                mc.getmusic(searchedAddress);
            }
            if (Objects.equals(command, "add")) {
                Music m = new Music();
                mc.addmusic(m);
            }
            if (Objects.equals(command, "delete")) {
                Music m = new Music();
                mc.deletemusic(m);

            }
            if (Objects.equals(command, "favorite")) {
                Music m = new Music();
                mc.addfavorite(m);
            }
        }
    }
}

class Music {
    String address;
    String category;
    String name;
    String year;

    public Music() {
        getmusic();
    }

    public void getmusic() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Music Address : ");
        this.address = sc.nextLine();
        System.out.print("Please Enter Music Category : ");
        this.category = sc.nextLine();
        System.out.print("Please Enter Music Singer Name : ");
        this.name = sc.nextLine();
        System.out.print("Please Enter Music Year : ");
        this.year = sc.nextLine();
    }
}

class MusicCollection {
    ArrayList<Music> Collection;
    ArrayList<Music> Favorite;

    public MusicCollection() {
        Collection = new ArrayList<Music>();
        Favorite = new ArrayList<Music>();
    }

    public void addmusic(Music music) {
        Collection.add(music);

    }

    public void addfavorite(Music music) {
        Favorite.add(music);
    }

    public void deletemusic(Music music) {
        Collection.remove(music);
    }

    public void getmusic(String address) {
        for (Music m : Collection) {
            if (m.address != null && m.address.equals(address)) {
                System.out.println("address: " + m.address + "category: " + m.category +
                        "singer name: " + m.name + "year: " + m.year);
            } else {
                System.out.println("Music Not Found.");
            }
        }
    }
}