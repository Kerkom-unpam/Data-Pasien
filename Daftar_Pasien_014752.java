package com.mycompany.patientlistproject_project_kelompok_5;
/**
 * @author Reza
 */
import java.util.Scanner;

public class Daftar_Pasien {                      
    static Pasien[] daftarpasien = new Pasien[30];     
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {                       
        int pilih_menu;         
        do{
            System.out.println("-----------------------MENU-----------------------");
            System.out.println("1. Tampilkan Seluruh Data Pasien");
            System.out.println("2. Buat Data Pasien Baru");
            System.out.println("3. Tampilkan Pasien Berdasarkan kode");
            System.out.println("4. Hapus Data Pasien");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu : ");
            pilih_menu = input.nextInt();               
            input.nextLine();              
            switch(pilih_menu){
                case 1:
                TampilkanSeluruhData();
                input.nextLine();
                System.out.flush();
                break;
                case 2:
                BuatDataPasienBaru();
                input.nextLine();
                System.out.flush();
                break;
                case 3:
                TampilkanDataPasien();
                input.nextLine();
                System.out.flush();
                break;
                case 4:
                HapusDataPasien();
                input.nextLine();
                System.out.flush();
                break;
                case 5:
                System.out.println("Program Keluar");
            }       
            System.out.flush();
        } while(pilih_menu != 5);        
    }
    
    public static void TampilkanSeluruhData(){        
        if (daftarpasien[0] != null){
            System.out.println("=================Daftar Seluruh Pasien=================");
            for(int i = 0; i < daftarpasien.length;i++){
                if (daftarpasien[i] == null){
                    break;
                }
                daftarpasien[i].TampilkanData();                 
            }
        }else{
            System.out.println("Belum Ada Pasien yang Terdaftar");
        }
        System.out.println("Tekan Enter Untuk Melanjutkan...");
    }

    public static void BuatDataPasienBaru(){
        for(int i = 0; i < daftarpasien.length;i++){
            if(daftarpasien[i] == null){
                try {
                    daftarpasien[i] = new Pasien();                
                    System.out.print("\nMasukkan Nama Pasien   : ");
                    daftarpasien[i].nama = input.nextLine();
                    System.out.print("Masukkan Umur Pasien   : ");
                    daftarpasien[i].umur = input.nextInt();
                    while(true){
                        int skip = 0;
                        System.out.print("Masukkan Kode Pasien   : ");
                        daftarpasien[i].kode_pasien = input.nextInt();
                        if(daftarpasien[i].kode_pasien < 0){
                            System.out.println("Kode Pasien Invalid, Coba Lagi");
                        }
                        else if(i > 0){
                            for(int j = 0; j < daftarpasien.length; j++){                            
                                if(daftarpasien[i].kode_pasien == daftarpasien[j].kode_pasien){
                                    System.out.println("Kode Pasien Sudah Ada, Coba Lagi");
                                    break;
                                }else if(j == i - 1){
                                    skip = 1;
                                    break;                                    
                                }
                            }                            
                            if(skip == 1){
                                break;
                            }
                        }else{
                            break;
                        }                                          
                    }                    
                    System.out.print("Masukkan Diagnosa Pasien : ");
                    daftarpasien[i].penyakit = input.nextLine();
                    daftarpasien[i].penyakit = input.nextLine();
                    System.out.println("Tekan Enter Untuk Melanjutkan...");
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input, Try Again");
                    daftarpasien[i] = null;
                    break;
                }
                
            }else if (daftarpasien[i] != null && i == daftarpasien.length-1){
                System.out.println("Ruang Sudah Penuh!");
            }
        }        
    }
    
    public static void TampilkanDataPasien(){
        System.out.print("Masukkan Kode Pasien : ");
        int search_code = input.nextInt();              
        if (daftarpasien[0] != null){
            for(int i = 0; i < daftarpasien.length; i++){      
                if(daftarpasien[i] == null){
                    System.out.println("Data Pasien Tidak Ditemukan");                
                    break;
                }
                else if(search_code == daftarpasien[i].kode_pasien){
                    System.out.println("==========Data Pasien==========");
                    daftarpasien[i].TampilkanData();
                    break;
                }else if(search_code != daftarpasien[i].kode_pasien && i == daftarpasien.length-1){
                    System.out.println("Data Pasien Tidak Ditemukan");                
                }                    
            }
        }else{
            System.out.println("Belum ada pasien yang terdaftar");
        }
        System.out.println("Tekan Enter Untuk Melanjutkan...");
        input.nextLine();
        System.out.flush();
    }
    
    public static void HapusDataPasien(){
        System.out.println("Masukkan kode pasien yang ingin dihapus : ");
        int search_code = input.nextInt();
        if(daftarpasien[0] != null){
            for(int i = 0; i < daftarpasien.length; i++){
                if(search_code == daftarpasien[i].kode_pasien){
                    System.out.println("=========Data Pasien yang Akan Dihapus=======");
                    daftarpasien[i].TampilkanData();
                    System.out.println("Menghapus Data Pasien...");
                    daftarpasien[i] = null;
                    try {
                        daftarpasien[i+1] = daftarpasien[i];daftarpasien[i+1] = daftarpasien[i];
                    } catch (Exception e) {
                        break;
                    }                    
                    break;
                }else if(search_code != daftarpasien[i].kode_pasien && i == daftarpasien.length-1){
                    System.out.println("Kode Pasien Tidak Ditemukan");                
                }            
            }
            System.out.println("Data Telah Terhapus");
        }
    }
}
