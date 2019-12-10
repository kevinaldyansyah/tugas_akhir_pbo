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
 * @author Kevin
 */
public class Transaksi implements IGetResult {

    private int idTransaksi;
    private Pelanggan pelanggan;
    private Sepeda sepeda;
    private int jumlah;
    private int totalHarga;
    private String tanggal;

    public Transaksi() {
    }

    public Transaksi(Pelanggan pelanggan, Sepeda sepeda, int jumlah, int totalHarga, String tanggal) {
        this.pelanggan = pelanggan;
        this.sepeda = sepeda;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setSepeda(Sepeda sepeda) {
        this.sepeda = sepeda;
    }

    public Sepeda getSepeda() {
        return sepeda;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    @Override
    public Object getById(int id) {
        Transaksi transaksi = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " t.id_transaksi, "
                + " t.total_harga, "
                + " t.jumlah, "
                + " t.tanggal, "
                + " p.id_pelanggan, "
                + " p.nama, "
                + " s.id_sepeda, "
                + " s.merk, "
                + " s.jenis, "
                + " s.keterangan "
                + " FROM transaksi t "
                + " LEFT JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                + " LEFT JOIN sepeda s ON t.id_sepeda = s.id_sepeda "
                + " WHERE t.id_transaksi = '" + id + "'");

        try {
            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.getPelanggan().setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.getPelanggan().setNama(rs.getString("nama"));
                transaksi.getSepeda().setIdSepeda(rs.getInt("id_sepeda"));
                transaksi.getSepeda().setMerk(rs.getString("merk"));
                transaksi.getSepeda().setJenis(rs.getString("jenis"));
                transaksi.getSepeda().setKeterangan(rs.getString("keterangan"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setTotalHarga(rs.getInt("total_harga"));
                transaksi.setTanggal(rs.getString("tanggal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaksi;
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> listTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " t.id_transaksi, "
                + " t.jumlah, "
                + " t.total_harga, "
                + " t.tanggal, "
                + " p.id_pelanggan, "
                + " p.nama, "
                + " s.id_sepeda, "
                + " s.merk, "
                + " s.jenis, "
                + " s.keterangan "
                + " FROM transaksi t "
                + " LEFT JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                + " LEFT JOIN sepeda s ON t.id_sepeda = s.id_sepeda");

        try {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.getPelanggan().setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.getPelanggan().setNama(rs.getString("nama"));
                transaksi.getSepeda().setIdSepeda(rs.getInt("id_sepeda"));
                transaksi.getSepeda().setMerk(rs.getString("merk"));
                transaksi.getSepeda().setJenis(rs.getString("jenis"));
                transaksi.getSepeda().setKeterangan(rs.getString("keterangan"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setTotalHarga(rs.getInt("total_harga"));
                transaksi.setTanggal(rs.getString("tanggal"));

                listTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }

    @Override
    public ArrayList<Object> search(String keyword) {
        ArrayList<Object> listPelanggan = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " t.id_transaksi, "
                + " t.jumlah, "
                + " t.total_harga, "
                + " t.tanggal, "
                + " p.id_pelanggan, "
                + " p.nama, "
                + " s.id_sepeda, "
                + " s.merk, "
                + " s.jenis, "
                + " s.keterangan "
                + " FROM transaksi t "
                + " LEFT JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                + " LEFT JOIN sepeda s ON t.id_sepeda = s.id_sepeda "
                + " WHERE t.id_transaksi LIKE '%" + keyword + "%' "
                + " OR p.id_pelanggan LIKE '%" + keyword + "%' "
                + " OR s.id_sepeda LIKE '%" + keyword + "%' ");

        try {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.getPelanggan().setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.getPelanggan().setNama(rs.getString("nama"));
                transaksi.getSepeda().setIdSepeda(rs.getInt("id_sepeda"));
                transaksi.getSepeda().setMerk(rs.getString("merk"));
                transaksi.getSepeda().setJenis(rs.getString("jenis"));
                transaksi.getSepeda().setKeterangan(rs.getString("keterangan"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setTotalHarga(rs.getInt("total_harga"));
                transaksi.setTanggal(rs.getString("tanggal"));

                listPelanggan.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPelanggan;
    }

    @Override
    public void save() {
        if (getIdTransaksi() == 0) {
            String SQL = "INSERT INTO transaksi (id_pelanggan, id_sepeda,jumlah, total_harga, tanggal) VALUES("
                    + "     '" + getPelanggan().getIdPelanggan() + "', "
                    + "     '" + getSepeda().getIdSepeda() + "', "
                    + "     '" + getJumlah() + "', "
                    + "     '" + getTotalHarga() + "', "
                    + "     '" + getTanggal() + "' "
                    + "     )";
            this.idTransaksi = DBHelper.insertQueryGetId(SQL);
            System.out.println("Transaksi berhasil disimpan!");
            System.out.println("Id Transaksi: " + getIdTransaksi());
            System.out.println("Id Pelanggan : " + getPelanggan().getIdPelanggan());
            System.out.println("Id Sepeda: " + getSepeda().getIdSepeda());
            System.out.println("Jumlah: " + getJumlah());
            System.out.println("Total Harga: " + getTotalHarga());
            System.out.println("Tanggal: " + getTanggal());
        } else {
            String SQL = "UPDATE kategori SET "
                    + "     id_pelanggan = '" + this.getPelanggan().getIdPelanggan() + "', "
                    + "     id_sepeda = '" + this.getSepeda().getIdSepeda() + "', "
                    + "     jumlah = '" + this.getJumlah() + "', "
                    + "     total_harga = '" + this.getTotalHarga() + "', "
                    + "     tanggal = '" + this.getTanggal() + "' "
                    + "     WHERE id_transaksi = '" + this.getIdTransaksi() + "'";
            DBHelper.executeQuery(SQL);
            System.out.println("Transaksi berhasil disimpan!");
            System.out.println("Id Transaksi: " + getIdTransaksi());
            System.out.println("Id Pelanggan : " + getPelanggan().getIdPelanggan());
            System.out.println("Id Sepeda: " + getSepeda().getIdSepeda());
            System.out.println("Jumlah: " + getJumlah());
            System.out.println("Total Harga: " + getTotalHarga());
            System.out.println("Tanggal: " + getTanggal());
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM pelanggan WHERE id_transaksi = '" + this.getIdTransaksi() + "'";
        DBHelper.executeQuery(SQL);
    }
}
