package de.jonashackt.springbootvuejs.certificates.creator;

import de.jonashackt.springbootvuejs.model.CertificateDetail;
import de.jonashackt.springbootvuejs.model.CertificateWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.operator.OperatorCreationException;

import java.security.cert.CertificateException;
import java.text.ParseException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateCreatorContext {

    private ICertificateCreator certificateCreator;

    public CertificateWrapper createCertificate(CertificateDetail issuerEmailDomain, CertificateDetail subjectEmailDomain) throws CertificateException, OperatorCreationException, ParseException, CertIOException {
        return this.certificateCreator.createCertificate(issuerEmailDomain,subjectEmailDomain);
    }

}
