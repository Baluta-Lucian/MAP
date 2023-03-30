package org.example.service;

import org.example.domain.Organizator;
import org.example.repository.OrganizatorDbRepository;

public class ServiceOrganizator {
    private OrganizatorDbRepository repoOrganizatori;

    public ServiceOrganizator(OrganizatorDbRepository repoOrganizatori) {
        this.repoOrganizatori = repoOrganizatori;
    }

    public Boolean isValid(Organizator organizator){
        if (repoOrganizatori.findOne(organizator) == null){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}
