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
 * @author Dharma
 */
public class Pelanggan implements IGetResult {

    private int idPelanggan;
    private String nama;

    public Pelanggan() {
    }

    public Pelanggan(String nama) {
        this.nama = nama;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public Object getById(int id) {
        Pelanggan pelanggan = new Pelanggan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pelanggan WHERE id_pelanggan = '" + id + "'");

        try {
            while (rs.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(rs.getInt("id_pelanggan"));
                pelanggan.setNama(rs.getString("nama"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pelanggan;
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> ListPelanggan = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pelanggan");

        try {
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setIdPelanggan(rs.getInt("id_kategori"));
                p.setNama(rs.getString("nama"));

                ListPelanggan.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPelanggan;
    }

    @Override
    public ArrayList<Object> search(String keyword) {
        ArrayList<Object> listPelanggan = new ArrayList();

        String sql = "SELECT * FROM pelanggan WHERE "
                + "     nama LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setIdPelanggan(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama"));

                listPelanggan.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPelanggan;
    }

    @Override
    public void save() {

        if (getIdPelanggan() == 0) {
            String SQL = "INSERT INTO pelanggan (nama) VALUES("
                    + "     '" + getNama() + "' )";
            this.idPelanggan = DBHelper.insertQueryGetId(SQL);
            System.out.println("Pelanggan berhasil disimpan!");
            System.out.println("Id: " + getIdPelanggan());
            System.out.println("Nama: " + getNama());
        } else {
            String SQL = "UPDATE kategori SET "
                    + "     nama = '" + getNama() + "' "
                    + "     WHERE id_pelanggan = '" + getIdPelanggan() + "'";
            DBHelper.executeQuery(SQL);
            System.out.println("Pelanggan berhasil disimpan!");
            System.out.println("Id: " + getIdPelanggan());
            System.out.println("Nama: " + getNama());
        }

    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM pelanggan WHERE id_pelanggan = '" + this.idPelanggan + "'";
        DBHelper.executeQuery(SQL);
    }

}
