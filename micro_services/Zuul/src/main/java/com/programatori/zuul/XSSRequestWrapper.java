package com.programatori.zuul;

import com.programatori.zuul.xss.XSSCleaner;
import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = XSSCleaner.clearXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value != null) {
            value = XSSCleaner.clearXSS(value);
        }
        return value;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value != null) {
            value = XSSCleaner.clearXSS(value);
        }
        return value;
    }

    private String stripXSS(String value) {
        if (value != null)
            System.out.println("escapeHTML work successfully and escapeHTML value is : " + StringEscapeUtils.escapeHtml(value));
        return StringEscapeUtils.escapeHtml(value);
    }

}
