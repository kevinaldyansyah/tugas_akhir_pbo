/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest.database;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tokosepeda.backend.Sepeda;
import static org.junit.Assert.*;

/**
 *
 * @author abdullah helmy
 */
public class SepedaTest extends TestCase{
    
    Sepeda instance;
    
    public SepedaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Sepeda("Polygon", "", "", 3000000);
        System.out.format("Start Testing : %s \n", this.getName());
    }
    
    @After
    public void tearDown() {
        System.out.format("Finish Test %s \n", this.getName());
    }

    @Test
    public void testSearch() {
        System.out.println("search test");
        String keyword = "Polygon";
        ArrayList<Object> expResult = instance.getByMerkJenisKeteranganAndHarga(keyword, "", "", 3000000);
        ArrayList<Object> result = instance.search(keyword);
        assertEquals(expResult.size(), result.size());
    }

    @Test
    public void testSave() {
        System.out.println("save test");
        this.instance.save();
        ArrayList<Object> expResult = instance.getByMerkJenisKeteranganAndHarga(instance.getMerk(), instance.getJenis(), instance.getKeterangan(), instance.getTotalHarga());
        assertTrue(expResult.size() > 0);
    }    
}
