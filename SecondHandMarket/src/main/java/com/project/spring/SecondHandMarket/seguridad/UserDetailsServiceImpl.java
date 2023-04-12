package com.project.spring.SecondHandMarket.seguridad;

import com.project.spring.SecondHandMarket.modelo.Usuario;
import com.project.spring.SecondHandMarket.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorio.findFirstByEmail(username);
        if(usuario == null)
            throw new UsernameNotFoundException("Usuario no encontrado");

        User.UserBuilder builder;
        builder = User.withUsername(username);
        builder.disabled(false);
        builder.password(usuario.getPassword());
        builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));

        return builder.build();
    }
}
