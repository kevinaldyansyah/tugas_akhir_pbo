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
public class SepedaListrik extends Sepeda{
    private Aki aki;

    public SepedaListrik() {
    }

    public SepedaListrik(String merk, String jenis, Aki aki, int harga) {
        super(merk, jenis, aki.getMerk() + " - " + aki.getTegangan(), harga);
    }

    public void setAki(Aki aki) {
        this.aki = aki;
    }

    public Aki getAki() {
        return aki;
    }
    
}
