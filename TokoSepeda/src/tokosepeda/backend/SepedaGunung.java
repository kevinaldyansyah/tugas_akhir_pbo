/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

/**
 *
 * @author Kevin
 */
public class SepedaGunung extends Sepeda{
    private Suspensi suspensi;

    public SepedaGunung() {
    }

    public SepedaGunung(String merk, String jenis, Suspensi suspensi, int harga) {
        super(merk, jenis, suspensi.getMerk() + " - " + suspensi.getKeterangan(), harga);
    }

    public void setSuspensi(Suspensi suspensi) {
        this.suspensi = suspensi;
    }

    public Suspensi getSuspensi() {
        return suspensi;
    }
    
    
}
