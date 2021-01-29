package com.example.mutant.config;

import com.example.mutant.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        final Revision revision= (Revision) revisionEntity;
    }
}