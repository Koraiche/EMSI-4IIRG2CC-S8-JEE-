package ma.emsi.tp_jpa.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Cette methode par defaut elle utilise un utilisateur user avec un mdp généré automatiquement
		//super.configure(auth);
		PasswordEncoder passwordEncoder = passwordEncoder();
		//auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");//c'est une strategie de stockage des user en memoire 
		//auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
		//auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
		//auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");
	
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credentials, active from users where username=? ")
		.authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
		.passwordEncoder(passwordEncoder).rolePrefix("ROLE_");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin().loginPage("/login");
		http.formLogin().loginPage("/login");
		//http.httpBasic();// formulaire dans un pop up
		http.authorizeRequests().antMatchers("/admin**/**","/save**/**","/delete**/**","/edit**/**","/form**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/patients**/**").hasRole("USER");
		
		http.authorizeRequests().antMatchers("/user**/**","/login","/webjars/**").permitAll(); // je laisse tout
		http.authorizeRequests().anyRequest().authenticated(); // authoriser toutes les requete si auth
		//http.csrf();//activer le mecanisme cross site nb -> il est activé par default mais on peut le desactiver avec http.csrf().desabled();
		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}
	
	
}
