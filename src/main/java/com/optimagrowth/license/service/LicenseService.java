package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    private final MessageSource messages;

    @Autowired
    public LicenseService(MessageSource messages) {
        this.messages = messages;
    }

    //GET
    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return license;
    }

    //PUT
    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(
                    messages.getMessage(
                            "license.update.message", null, null
                    ), license.toString());
        }
        return responseMessage;
    }

    //POST
    public String createLicense(
            License license,
            String organizationId,
            Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(
                    messages.getMessage(
                            "license.create.message", null, locale
                    ), license.toString());
        }
        return responseMessage;
    }

    //DELETE
    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format(
                "Deleting license with id %s for the organization %s",
                licenseId, organizationId
        );
        return responseMessage;
    }
}
