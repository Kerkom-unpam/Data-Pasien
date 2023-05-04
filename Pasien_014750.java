package com.mycompany.patientlistproject_project_kelompok_5;

//@author Reza
 
public class Pasien{
    String nama;
    int kode_pasien;
    int umur;
    String penyakit;
    
    public void TampilkanData(){
        System.out.println("Nama     : " + nama);
        System.out.println("Umur     : " + umur);
        System.out.println("Kode     : " + kode_pasien);
        System.out.println("Diagnosa : " + penyakit + "\n");

    }
}
