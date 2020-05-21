package de.jonashackt.springbootvuejs.certificates.storage;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import java.io.*;
import java.security.cert.*;

public class CRLLoadSave {

    public static void saveCRL(X509CRL crl) throws IOException {
        String path = "crl"+ File.separator + "crllist.crl";
        StringWriter sw = new StringWriter();
        try (JcaPEMWriter pw = new JcaPEMWriter(sw)){
            pw.writeObject(crl);
        }
        FileWriter fw = new FileWriter(path);
        fw.write(sw.toString());
        fw.close();
    }

    public static X509CRL loadCRL() throws IOException, CertificateException, CRLException {
        String path = "crl"+ File.separator + "crllist.crl";
        try (InputStream inStream = new FileInputStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509CRL crl = (X509CRL)cf.generateCRL(inStream);
            inStream.close();
            return crl;
        }
    }
}
