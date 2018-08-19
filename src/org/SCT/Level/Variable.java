package org.SCT.Level;

public class Variable {

    boolean MyPet = false;
    static long timer = 10L;//自己改awa
    public void setMypetExists(Boolean exists){
        MyPet = exists;
    }
    public boolean getMypetExists() {
        return MyPet;
    }

}
