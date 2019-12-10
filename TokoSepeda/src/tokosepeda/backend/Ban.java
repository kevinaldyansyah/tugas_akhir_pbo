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
public class Ban {
    private String merk;
    private String diameter;

    public Ban() {
    }

    public Ban(String merk, String diameter) {
        this.merk = merk;
        this.diameter = diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }
}
