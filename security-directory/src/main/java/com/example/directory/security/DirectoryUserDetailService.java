package com.example.directory.security;

import com.example.directory.domain.Person;
import com.example.directory.repository.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DirectoryUserDetailService implements UserDetailsService {

    private PersonRepository repo;

    public DirectoryUserDetailService(PersonRepository repo) {
        this.repo=repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            final Person person = this.repo.findByEmailIgnoreCase(username);

            if(person!=null){
                PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
                String pasword=encoder.encode(person.getPassword());

                return User.withUsername(person.getEmail())
                        .accountLocked(!person.isEnabled())
                        .password(pasword)
                        .roles(person.getRole())
                        .build();
            }
//            else{
//                return User.withUsername("admin@example.com")
//                        .accountLocked(!person.isEnabled())
//                        .password("admin")
//                        .roles(person.getRole())
//                        .build();
//            }
        }catch (Exception ex){
            ex.printStackTrace();

        }
        throw new UsernameNotFoundException(username);
    }


}
