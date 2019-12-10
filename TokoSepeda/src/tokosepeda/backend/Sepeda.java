/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alwy
 */
public class Sepeda implements IGetResult {

    private int idSepeda;
    private String merk;
    private String jenis;
    private String keterangan;
    private int totalHarga;

    public Sepeda() {
    }

    public Sepeda(String merk, String jenis, String keterangan, int totalHarga) {
        this.merk = merk;
        if (jenis != null) {
            this.jenis = jenis;
        }else {
            this.jenis = "";
        }
        
        if (keterangan != null) {
            this.keterangan = keterangan;
        }else {
            this.keterangan = "";
        }
        this.totalHarga = totalHarga;
    }

    public void setIdSepeda(int idSepeda) {
        this.idSepeda = idSepeda;
    }

    public int getIdSepeda() {
        return idSepeda;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
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

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    @Override
    public Object getById(int id) {
        Sepeda sepeda = new Sepeda();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM sepeda WHERE id_sepeda = '" + id + "'");

        try {
            while (rs.next()) {
                sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_sepeda"));
                sepeda.setMerk(rs.getString("merk"));
                sepeda.setJenis(rs.getString("jenis"));
                sepeda.setKeterangan(rs.getString("keterangan"));
                sepeda.setTotalHarga(rs.getInt("harga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sepeda;
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> listSepeda = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM sepeda");

        try {
            while (rs.next()) {
                Sepeda sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_sepeda"));
                sepeda.setMerk(rs.getString("merk"));
                sepeda.setJenis(rs.getString("jenis"));
                sepeda.setKeterangan(rs.getString("keterangan"));
                sepeda.setTotalHarga(rs.getInt("harga"));

                listSepeda.add(sepeda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSepeda;
    }

    @Override
    public ArrayList<Object> search(String keyword) {
        ArrayList<Object> listSepeda = new ArrayList();

        String sql = "SELECT * FROM sepeda WHERE "
                    + "     merk LIKE '%" + keyword + "%' "
                    + "     OR jenis LIKE '%" + keyword + "%' "
                    + "     OR keterangan LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Sepeda sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_sepeda"));
                sepeda.setMerk(rs.getString("merk"));
                sepeda.setJenis(rs.getString("jenis"));
                sepeda.setKeterangan(rs.getString("keterangan"));
                sepeda.setTotalHarga(rs.getInt("harga"));

                listSepeda.add(sepeda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSepeda;
    }

    @Override
    public void save() {
        
        if (getIdSepeda() == 0) {
            String SQL = "INSERT INTO sepeda (merk, jenis, keterangan, harga) VALUES("
                    + "     '" + getMerk() + "', "
                    + "     '" + getJenis() + "', "
                    + "     '" + getKeterangan() + "', "
                    + "     '" + getTotalHarga()+ "' "
                    + ")";
            this.idSepeda = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE sepeda SET "
                    + "     merk = '" + getMerk() + "', "
                    + "     jenis = '" + getMerk() + "', "
                    + "     keterangan = '" + getKeterangan() + "', "
                    + "     harga = '" + getTotalHarga()+ "' "
                    + "     WHERE id_sepeda = '" + getIdSepeda() + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM sepeda WHERE id_sepeda = '" + this.idSepeda + "'";
        DBHelper.executeQuery(SQL);
    }

    public ArrayList<Object> getByMerkJenisKeteranganAndHarga(String merk, String jenis, String keterangan, int harga) {
        ArrayList<Object> ListSepeda = new ArrayList();
        ResultSet rs;

        if ((merk.trim().length() > 0) && (jenis.trim().length() > 0) && (keterangan.trim().length() > 0)) {
            rs = DBHelper.selectQuery("SELECT * FROM sepeda Where merk = '"
                    + merk + "' and jenis = '" + jenis + "' and keterangan = '" + keterangan + "'");
        } else if ((merk.trim().length() > 0) && (jenis.trim().length() > 0) && (keterangan.trim().length() == 0)) {
            rs = DBHelper.selectQuery("SELECT * FROM sepeda Where merk = '"
                    + merk + "' and jenis = '" + jenis + "'");
        } else if ((merk.trim().length() > 0) && (jenis.trim().length() == 0) && (keterangan.trim().length() > 0)) {
            rs = DBHelper.selectQuery("SELECT * FROM sepeda Where merk = '"
                    + merk + "' and keterangan = '" + keterangan + "'");
        }else {
            rs = DBHelper.selectQuery("SELECT * FROM sepeda WHERE jenis "
                    + " = '"+jenis+"' and keterangan = '" + keterangan + "'");
        }

        try {
            while (rs.next()) {
                Sepeda kat = new Sepeda();
                kat.setIdSepeda(rs.getInt("id_sepeda"));
                kat.setMerk(rs.getString("merk"));
                kat.setJenis(rs.getString("jenis"));
                kat.setKeterangan(rs.getString("keterangan"));
                kat.setTotalHarga(rs.getInt("harga"));
                ListSepeda.add(kat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListSepeda;
    }
    
}
