package com.shashi.walletservice.Controller;

import com.shashi.walletservice.Model.*;
import com.shashi.walletservice.Repository.TransactionRepository;
import com.shashi.walletservice.Repository.WalletRepository;
import com.shashi.walletservice.Util.TransactionValidator;
import com.shashi.walletservice.Util.WalletValidator;
import com.shashi.walletservice.exception.TransactionBadRequest;
import com.shashi.walletservice.service.EmailService;
import com.shashi.walletservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class TransactionResource {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionRepository trepository;

    @Autowired
    private UserService userService;

    WalletValidator walletValidator = new WalletValidator();
    TransactionValidator validator = new TransactionValidator();
    private static final String TOPIC = "test";
    private static final Logger logger = LoggerFactory.getLogger(WalletResource.class);


    @PostMapping("/sendMoney")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Transaction sendMoney(@RequestBody Transaction transaction) throws Exception {

        if(!validator.validateRequest(transaction)){
            throw new TransactionBadRequest();
        }
        transaction.setDate(new Date(Calendar.getInstance().getTime().getTime()));
        User sender = userService.getAUser(String.valueOf(transaction.getSid()));
        User receiver = userService.getAUser(String.valueOf(transaction.getRid()));
        if(sender==null || receiver==null){
            logger.info("No wallet for sender or receiver");
            throw new TransactionBadRequest();
        }

        Wallet senderWallet = walletRepository.findWalletByUserId(sender.getId());
        Wallet receiverWallet = walletRepository.findWalletByUserId(receiver.getId());

        int amt = transaction.getAmount();

        if (senderWallet.getBalance() < amt) {
            throw new Exception("Not Sufficient Balance");
        }
        senderWallet.setBalance(senderWallet.getBalance()-amt);

        receiverWallet.setBalance(receiverWallet.getBalance()+amt);

        transaction.setStatus("SUCCESS");
        logger.info(String.format("$$ -> Producing Transaction --> %s", transaction));
        walletRepository.save(receiverWallet);
        walletRepository.save(senderWallet);
        return trepository.save(transaction);
    }

    @GetMapping("/getBal/{id}")
    int getBal(@PathVariable int id) throws Exception {

            Wallet wallet = walletRepository.findWalletByUserId(id);

            if(wallet==null) throw new Exception("Wallet Not Found");
            else {
                return wallet.getBalance();
            }
    }
    @PostMapping("/addBalance")
    AddBalanceDetails addBalance(@RequestBody AddBalanceDetails request){

        logger.info(request.toString());
        Wallet wallet = walletRepository.findWalletByUserId(request.getUid());

        wallet.setBalance(request.getAmount()+wallet.getBalance());
        walletRepository.save(wallet);
        return request;
    }

    @GetMapping("/txnHistory/{id}")
    String getTransactionHistory(@PathVariable int id) {
        logger.info(String.format("$$ -> Producing Transaction --> %s", id));
        sendTxnHistory(String.valueOf(id));
        return "You will get the file on your email";
    }

    private void sendTxnHistory(String id) {
        int id1 = Integer.parseInt(id);
        ArrayList<Transaction> list =
                (ArrayList<Transaction>) trepository.findBysidAndrid(id1);

        User user1 = userService.getAUser(String.valueOf(id1));
        String filename ="test.csv";
        try {
            FileWriter fw = new FileWriter(filename);

            for(int i=0;i<list.size();i++) {
                fw.append(list.get(i).getStatus());
                fw.append(',');
                int amt = list.get(i).getAmount();
                Integer obj = amt;
                fw.append(obj.toString());
                fw.append(',');
                fw.append(list.get(i).getDate().toString());
                fw.append(',');
                int id2 = list.get(i).getId();
                Integer obj2 = id2;
                fw.append(obj2.toString());
                fw.append(',');
                int rid = list.get(i).getRid();
                obj = rid;
                fw.append(obj.toString());
                fw.append(',');
                int sid = list.get(i).getSid();
                obj = sid;
                fw.append(obj.toString());
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            logger.info("CSV File is created successfully.");
            EmailService.sendEmailWithAttachments("","",user1.getEmail(),"","to@gmail.com","","",filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
