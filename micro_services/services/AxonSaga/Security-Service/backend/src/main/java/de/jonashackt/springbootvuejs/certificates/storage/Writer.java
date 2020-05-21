package de.jonashackt.springbootvuejs.certificates.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class Writer {

    private KeyStore keyStore;

    public Writer(){
        try {
            keyStore = KeyStore.getInstance("JKS", "SUN");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public void loadKeyStore(String fileName, char[] password) {
        try {
            if(fileName != null) {
                keyStore.load( new FileInputStream(fileName), password);
            } else {
                keyStore.load(null, password);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveKeyStore(String fileName, char[] password) {
        try {
            keyStore.store(new FileOutputStream(fileName), password);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //entry pass je od konkretnog serta
    //password je od keystore file
    public void write(String alias, PrivateKey privateKey, String password, Certificate certificate, String fileName, String entryPass) {
        try{
            this.loadKeyStore(fileName, password.toCharArray());
        }catch (Exception e){
            this.loadKeyStore(null,password.toCharArray());
        }
        try {
            if(!keyStore.containsAlias(alias)) {
                keyStore.setKeyEntry(alias, privateKey, entryPass.toCharArray(), new Certificate[]{certificate});
                this.saveKeyStore(fileName,password.toCharArray());
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

}
