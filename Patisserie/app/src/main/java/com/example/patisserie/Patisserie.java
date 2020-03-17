package com.example.patisserie;

import android.graphics.drawable.Drawable;

import java.lang.String;

public class Patisserie {

    // Comporte une image, un nom et une description
    private String patisserieName;
    private String patisserieDesc;
    private int patisserieImage;

    // Les accesseurs et mutateurs de la classe Patisserie

    public String getPatisserieName()
    {
        return patisserieName;
    }

    public void setPatisserieName(String patisserieName)
    {
        this.patisserieName = patisserieName;
    }

    public String getPatisserieDesc()
    {
        return patisserieDesc;
    }

    public void setPatisserieDesc(String patisserieDesc)
    {
        this.patisserieDesc = patisserieDesc;
    }

    public int getPatisserieImage()
    {
        return patisserieImage;
    }

    public void setPatisserieImage(int patisserieImage)
    {

        this.patisserieImage = patisserieImage;
    }


}