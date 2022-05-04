package com.example.ssssksss_blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * PackageName : com.example.ssssksss_blog.config
 * FileName : MethodSecurity
 * Author : 이 수 경
 * Date : 2022-04-24
 * Description :
 */

//@Configuration
//@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true
//)
public class MethodSecurity extends GlobalMethodSecurityConfiguration {
//    @Override
//    protected AccessDecisionManager accessDecisionManager() {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
//        AffirmativeBased accessDecisionManager = (AffirmativeBased) super.accessDecisionManager();
//        accessDecisionManager.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));
//        return accessDecisionManager;
//    }
}
