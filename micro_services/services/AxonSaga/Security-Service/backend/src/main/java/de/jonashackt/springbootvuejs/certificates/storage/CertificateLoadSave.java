package de.jonashackt.springbootvuejs.certificates.storage;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;

public class CertificateLoadSave {

    public static void saveCertificate(X509Certificate certificate) throws IOException {
        String fileName = certificate.getSubjectDN().getName().split(",")[0].split("=")[1].trim();
        fileName+=".cer";
        String path = "certificates"+ File.separator + fileName;
        StringWriter sw = new StringWriter();
        try (JcaPEMWriter pw = new JcaPEMWriter(sw)){
            pw.writeObject(certificate);
        }
        FileWriter fw = new FileWriter(path);
        fw.write(sw.toString());
        fw.close();
    }

    public static X509Certificate loadCertificate(String name){
        System.out.println(name.split(",")[1].split("=")[1].trim());
        System.out.println(name);
        String fileName = name.split(",")[0].split("=")[1].trim();
        fileName+=".cer";
        String path = "certificates"+ File.separator + fileName;
        try (InputStream inStream = new FileInputStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate crl = (X509Certificate)cf.generateCertificate(inStream);
            return crl;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }



}
