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
public class TestBackend {
    public static void main(String[] args) {
        
        Sepeda sepeda = new Sepeda("Wimcycle", null, null, 2500000);
        
        Suspensi suspensi = new Suspensi("Hardtail", "Suspensi Depan");
        SepedaGunung sepedaGunung = new SepedaGunung("Puma", "Sepeda Gunung", suspensi, 3500000);
        
        Ban ban = new Ban("Tubular", "8,5 cm");
        SepedaFixie sepedaFixie = new SepedaFixie("Polygon", "Sepeda Fixie" , ban, 4000000);
        
        Aki aki = new Aki("Motobatt", "25 volt");
        SepedaListrik sepedaListrik = new SepedaListrik("Tesla", "Sepeda Listrik", aki, 5000000);
        
        sepeda.save();
        
        sepedaGunung.save();
        
        sepedaFixie.save();
        
        sepedaListrik.save();
    }
}
