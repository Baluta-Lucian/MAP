import model.ComputerRepairRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    @Test
    @DisplayName("First Test")
    public void testExample(){
        System.out.println("Test 1 start...");
        ComputerRepairRequest crr = new ComputerRepairRequest();
        assertEquals("", crr.getOwnerName());
        assertEquals("", crr.getOwnerAddress());
        System.out.println("Test 1 done!");
    }

    @Test
    @DisplayName("Test Exemplu")
    public void testExample2(){
        System.out.println("Test 2 start...");
        assertEquals(2,2, "Numerele ar trebui sa fie egale");
        ComputerRepairRequest crr2 = new ComputerRepairRequest(2, "Baluta", "Pasteur 65", "0763683309", "TUF Gaming", "6/3/2023", "Supra-incalzire");
        assertEquals(2, crr2.getID());
        assertEquals("Baluta", crr2.getOwnerName());
        assertEquals("Pasteur 65", crr2.getOwnerAddress());
        assertEquals("0763683309", crr2.getPhoneNumber());
        assertEquals("TUF Gaming", crr2.getModel());
        assertEquals("6/3/2023", crr2.getDate());
        assertEquals("Supra-incalzire", crr2.getProblemDescription());
        System.out.println("Test 2 done!");

    }
      
}
