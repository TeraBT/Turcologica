package com.turcologica.security;

import com.turcologica.users.turcologica.TurcologicaUser;
import com.turcologica.users.turcologica.TurcologicaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    private final TurcologicaUserRepository turcologicaUserRepository;

    public SpringSecurityConfiguration(TurcologicaUserRepository turcologicaUserRepository) {
        this.turcologicaUserRepository = turcologicaUserRepository;
    }

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails chris = createUser("chris", "vic", "Christopher", "Baumgartner-Trösch","DEV");
        UserDetails aycan = createUser("aycan", "abc", "Aycan", "Yumrukçal", "ADMIN");
        UserDetails student = createUser("student", "abc", "Student 1","Lastname","STUDENT");
        UserDetails lecturer = createUser("lecturer", "abc", "Lecturer 1", "Lastname", "LECTURER");
        return new InMemoryUserDetailsManager(chris, aycan, student, lecturer);
    }

    private UserDetails createUser(String username, String password, String firstname, String lastname, String... roles) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles(roles)
                .build();

        turcologicaUserRepository.save(new TurcologicaUser(userDetails, firstname, lastname));
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }
}
