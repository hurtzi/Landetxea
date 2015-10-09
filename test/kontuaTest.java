
import junit.framework.TestCase;
import businessLogic.*;
import domain.RuralHouse;
import gui.StartWindow;
import gui.*;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;
import businessLogic.ApplicationFacadeInterface;
import dataAccess.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import domain.Owner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Urtzi * TELEFONOAREN-aren proba kasuak
 *
 */
public class kontuaTest extends TestCase {

    public static ApplicationFacadeInterface facade;
    Register register;

    public kontuaTest(String testSearch) {
        super(testSearch);
    }

    @Override
    //exekututauko den testa baino lehen nahi duzuna (hasieratu bista kasu honetan)
    protected void setUp() throws Exception {
        super.setUp();
        facade = new FacadeImplementation();

        //--register = new Register();
        // register.addWindowListener(new WindowCloseManager());
        // register.pack();
        //--register.setVisible(true);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /*
     * ondo daudenak--> true bueltatu
     */
    //(1) 
    public void testCreateGui1() throws InterruptedException {
        try {
            facade.setDataAccess(new DataAccessLocal());
            boolean buelta = facade.createOwner(123456789, "202149955487", "Owner", "Altuna", "owner", "000");
            facade.close();
            assertEquals(false, buelta);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /*
     * gaizki daudenak--> true bueltatu
     */
    //(2) 9 digitu baino gehiago
   
    
    
    
    
    /*
     * BESTE
     */
    private static void createGui(JPanel contents, String windowName) {
        JFrame frame = new JFrame(windowName);
        frame.getContentPane().add(contents);
        frame.addWindowListener(new WindowCloseManager());
        frame.pack();
        frame.setVisible(true);
    }

    private static class WindowCloseManager extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent evt) {
            System.exit(0);
        }
    }
}
