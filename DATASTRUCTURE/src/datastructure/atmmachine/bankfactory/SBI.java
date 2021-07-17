package datastructure.atmmachine.bankfactory;

public class SBI implements Bank{  
    private final String BNAME;  
    public SBI(){  
              BNAME="SBI";  
      }  
     public String getBankName(){  
                return BNAME;  
     }  
}  