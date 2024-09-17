package cl.negenko.Proyecto.Ventas.configure;

import cl.negenko.Proyecto.Ventas.model.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UserDetailsService userDetailsService;
    private final JwtFilterRequest jwtFilterRequest;

    public SecurityConfig(UserDetailsService userDetailsService, JwtFilterRequest jwtFilterRequest) {
        this.userDetailsService = userDetailsService;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/js/**", "/css/**", "/auth", "/login").permitAll()
                        // Permisos para el rol USER
                        .requestMatchers(HttpMethod.GET, "/clientes", "/clientes/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/api/propiedades", "/api/propiedades/{id}").hasAnyRole("ADMIN", "USER")
                        // Permisos para el rol ADMIN
                        .requestMatchers(HttpMethod.GET, "/clientes/new", "/clientes/{id}/del").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/clientes").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/clientes").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/clientes/{id}/del").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .permitAll()
        ).logout((logout) -> logout
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll())
                .httpBasic(withDefaults());

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}


