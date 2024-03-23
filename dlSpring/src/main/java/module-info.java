module dlSpring {
    requires spring.security.config;
    requires spring.context;
    requires spring.beans;
    requires spring.security.crypto;
    requires spring.security.web;
    requires spring.security.core;
    requires spring.web;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires spring.tx;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;
    requires static lombok;
    requires jakarta.annotation;
    requires com.fasterxml.jackson.annotation;
    requires org.hibernate.orm.core;
    requires java.base;
    requires spring.aop;

    opens com.example.dl_spring to spring.core;
    opens com.example.dl_spring.config to spring.core, spring.beans, spring.context;
    opens com.example.dl_spring.model to org.hibernate.orm.core, spring.core;
    opens com.example.dl_spring.service to spring.beans, spring.core;
    opens com.example.dl_spring.controller to spring.beans, spring.core, spring.web;

    exports com.example.dl_spring;
    exports com.example.dl_spring.model;
    exports com.example.dl_spring.controller;
    exports com.example.dl_spring.config;
    exports com.example.dl_spring.service;
    exports com.example.dl_spring.repository;
    exports com.example.dl_spring.dto;
    exports com.example.dl_spring.dto.main;
}