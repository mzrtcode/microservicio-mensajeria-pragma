package com.pragma.mensajeriamicroservicio.infrastructure.security.jwt;

import com.pragma.mensajeriamicroservicio.infrastructure.security.jwt.dto.UsuarioAutenticado;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public UsuarioAutenticado obtenerUsuarioSesionActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UsuarioAutenticado) {
            return (UsuarioAutenticado) authentication.getPrincipal();
        }

        return null;
    }
}
