package com.example.productback.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.security.access.AccessDeniedException;

@Aspect
@Component
public class AdminOnlyAspect {
    private static final String ADMIN_EMAIL = "admin@admin.com";

    @Around("@annotation(com.example.productback.security.AdminOnly)")
    public Object checkAdminAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
            throw new AccessDeniedException("authentication is null");

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        if (userDetails.getEmail().equals(ADMIN_EMAIL)) {
            return joinPoint.proceed();
        } else {
            throw new AccessDeniedException("Seul l'administrateur peut effectuer cette opération");
        }

    }
}
