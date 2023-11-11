package kz.demo.halykoiy.utils;

import kz.demo.halykoiy.entities.Role;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Alisher
 * @since 11/11/2023
 */
public class SecurityUtils {
    public static String getUserPhoneNumber() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static Boolean hasAuthority(Role role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(role);
    }
}
