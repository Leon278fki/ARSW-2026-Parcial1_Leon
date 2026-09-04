package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostValidator extends Thread {
    
    private int head;
    private int tail;
    private String ipaddress;
    private HostBlacklistsDataSourceFacade hbldsf;
    private int HostValidator;


    public HostValidator (int head, int tail, String ipaddress, HostBlacklistsDataSourceFacade hbldsf){
        this.head = head;
        this.tail = tail;
        this.ipaddress = ipaddress ;
        this.hbldsf = hbldsf;
        this.HostValidator = 0;
        this.ipaddress = ipaddress;

    }

    @Override 
    public void run(){
        for(int i = head; i < tail; i++)
            if (hbldsf.isInBlackListServer(i, ipaddress)){
                HostValidator++;
            }
         
    }



    
}
