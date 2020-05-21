package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.certificates.creator.CertificateCreatorContext;
import de.jonashackt.springbootvuejs.certificates.creator.EndEntityCertificateCreator;
import de.jonashackt.springbootvuejs.certificates.creator.IntermediateCertificateCreator;
import de.jonashackt.springbootvuejs.certificates.creator.SelfSignedCertificateCreator;
import de.jonashackt.springbootvuejs.certificates.crl.X509CRLUtil;
import de.jonashackt.springbootvuejs.certificates.storage.CertificateLoadSave;
import de.jonashackt.springbootvuejs.certificates.storage.Reader;
import de.jonashackt.springbootvuejs.certificates.storage.Writer;
import de.jonashackt.springbootvuejs.model.CertificateDetail;
import de.jonashackt.springbootvuejs.model.CertificateWrapper;
import de.jonashackt.springbootvuejs.repository.CertificateDetailRepository;
import org.bouncycastle.operator.OperatorCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.cert.*;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    CertificateDetailRepository certificateDetailRepository;

    @Override
    public CertificateDetail issue(String email_issuer, String  email_subject) throws CertificateException, OperatorCreationException, ParseException, IOException {
        CertificateDetail issuer = certificateDetailRepository.findOneByEmail(email_issuer);
        CertificateDetail subject = certificateDetailRepository.findOneByEmail(email_subject);
        CertificateCreatorContext creator = new CertificateCreatorContext();
        creator.setCertificateCreator(new SelfSignedCertificateCreator());
        CertificateWrapper certificateWrapper = creator.createCertificate(issuer,subject);
        Writer writer = new Writer();
        writer.write(email_subject,certificateWrapper.getPrivateKey(),"password",certificateWrapper.getCertificate(),"keystore/root.jks", "milutin");
        CertificateLoadSave.saveCertificate(certificateWrapper.getCertificate());
        return subject;
    }

    @Override
    public CertificateDetail issueIntermediate(String emailIssuer, String emailSubject) throws CertificateException, OperatorCreationException, ParseException, IOException {
        CertificateDetail issuer = certificateDetailRepository.findOneByEmail(emailIssuer);
        CertificateDetail subject = certificateDetailRepository.findOneByEmail(emailSubject);
        CertificateCreatorContext creator = new CertificateCreatorContext();
        creator.setCertificateCreator(new IntermediateCertificateCreator());
        CertificateWrapper certificateWrapper = creator.createCertificate(issuer,subject);
        Writer writer = new Writer();
        writer.write(emailSubject,certificateWrapper.getPrivateKey(),"password",certificateWrapper.getCertificate(),"keystore/intermediate.jks", "milutin");
        CertificateLoadSave.saveCertificate(certificateWrapper.getCertificate());
        return subject;
    }

    @Override
    public CertificateDetail issueEE(String emailIssuer, String emailSubject) throws CertificateException, OperatorCreationException, ParseException, IOException {
        CertificateDetail issuer = certificateDetailRepository.findOneByEmail(emailIssuer);
        CertificateDetail subject = certificateDetailRepository.findOneByEmail(emailSubject);
        CertificateCreatorContext creator = new CertificateCreatorContext();
        creator.setCertificateCreator(new EndEntityCertificateCreator());
        CertificateWrapper certificateWrapper = creator.createCertificate(issuer,subject);
        Writer writer = new Writer();
        writer.write(emailSubject,certificateWrapper.getPrivateKey(),"password",certificateWrapper.getCertificate(),"keystore/endentity.jks", "milutin");
        CertificateLoadSave.saveCertificate(certificateWrapper.getCertificate());
        return subject;
    }

    @Override
    public String revokeX509Certificate(String issuerEmail, String certificateAlias) throws IOException, OperatorCreationException, CertificateException, CRLException {
        X509CRLUtil util = X509CRLUtil.getInstance();
        Reader reader = new Reader();
        X509Certificate x509Certificate = (X509Certificate) reader.readX509Certificate("keystore/intermediate.jks","password",certificateAlias);
        util.createUpdate(null, issuerEmail);
        X509CRL crl = util.revokeCertificate(x509Certificate);
        Set<? extends X509CRLEntry> set = crl.getRevokedCertificates();
        Iterator<X509CRLEntry> iterator = (Iterator<X509CRLEntry>) set.iterator();
        while (iterator.hasNext()) {
            X509CRLEntry entry = iterator.next();
        }
        return crl.toString();
    }


}
