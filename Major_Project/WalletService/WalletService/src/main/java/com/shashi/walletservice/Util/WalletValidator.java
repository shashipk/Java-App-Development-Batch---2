package com.shashi.walletservice.Util;

import com.shashi.walletservice.Model.Wallet;

public class WalletValidator {
    public boolean validateWalletRequest(Wallet wallet){
        /*
        Write your logic to implement validation
         */
        if(wallet.getUser_id()==null || wallet.getUser_id()=="" )
            return false;
        return true;
    }
}
