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
public class SepedaFixie extends Sepeda{
    private Ban ban;

    public SepedaFixie() {
    }

    public SepedaFixie(String merk, String jenis, Ban ban, int harga) {
        super(merk, jenis, ban.getMerk() + " - " + ban.getDiameter(), harga);
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public Ban getBan() {
        return ban;
    }
    
    
}
