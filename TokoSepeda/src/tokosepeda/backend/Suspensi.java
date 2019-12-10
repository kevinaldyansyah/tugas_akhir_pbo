/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

/**
 *
 * @author Dharma
 */
public class Suspensi {
    private String merk;
    private String keterangan;

    public Suspensi() {
    }

    public Suspensi(String merk, String keterangan) {
        this.merk = merk;
        this.keterangan = keterangan;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
