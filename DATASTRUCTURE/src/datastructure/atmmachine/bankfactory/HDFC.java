package datastructure.atmmachine.bankfactory;

public class HDFC implements Bank{  
    private final String BNAME;  
    public HDFC(){  
           BNAME="HDFC";  
   }  
   public String getBankName() {  
             return BNAME;  
   }  
} 