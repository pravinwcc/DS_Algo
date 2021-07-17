package datastrucure.vendingmachine;

public class VendingMachineFactory {      
    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }
}



