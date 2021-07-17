package datastructure.customehashset;

import java.util.HashMap;

class HashSetCustom<E>{
    
    
    private HashMap<E, Object> hashMapCustom;
    private static final Object PRESENT = new Object();
 
    public HashSetCustom(){
        hashMapCustom=new HashMap<>();
    }
    
    /**
     * add objects in SetCustom.
     */
    public void add(E value){
           hashMapCustom.put(value, PRESENT);
    }
 
    /**
     * Method returns true if set contains the object.
     * @param key
     */
    public boolean contains(E obj){
           return hashMapCustom.containsKey(obj) ==true ? true :false;
    }
    
    /**
     * Method displays all objects in setCustom.
     * insertion order is not guaranteed, for maintaining insertion order refer LinkedHashSet.
     */
   
    /**
     * Method removes object from setCustom.
     * @param obj
     */
    public Object remove(E obj){
       return hashMapCustom.remove(obj);
    } 
   
}
