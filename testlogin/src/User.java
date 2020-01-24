/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharti
 */
class User {
    private String roomno,noofbeds;
    public User(String r,String nob)
    {
        roomno=r;
        noofbeds=nob;
    }
    public String getroomno()
    {
        return roomno;
    }
    public String getnoofbeds()
    {
        return noofbeds;
    }
    
}
