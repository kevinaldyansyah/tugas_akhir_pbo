/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

/**
 *
 * @author Alwy
 */
public class Aki {
    private String merk;
    private String tegangan;

    public Aki() {
    }

    public Aki(String merk, String tegangan) {
        this.merk = merk;
        this.tegangan = tegangan;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setTegangan(String tegangan) {
        this.tegangan = tegangan;
    }

    public String getTegangan() {
        return tegangan;
    }
}
