package com.nextcoach.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.nextcoach.domain.Profile;
import com.nextcoach.domain.User;
import com.nextcoach.domain.visitor.AdminVisitor;
import com.nextcoach.domain.visitor.ClubVisitor;
import com.nextcoach.domain.visitor.CoachVisitor;
import com.nextcoach.repository.UserRepository;
import com.nextcoach.utils.HashUtils;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userRepository.findByUsername(username);

		if (HashUtils.hash(password).equals(user.getPass())) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();

			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

			if (user.isVerified()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_VERIFIED"));
			}

			Profile profile = user.getProfile();
			if (profile != null) {
				if (profile.accepts(new ClubVisitor())) {
					authorities.add(new SimpleGrantedAuthority("ROLE_CLUB"));
				}
				if (profile.accepts(new CoachVisitor())) {
					authorities.add(new SimpleGrantedAuthority("ROLE_COACH"));
				}
				if (profile.accepts(new AdminVisitor())) {
					authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
					authorities.add(new SimpleGrantedAuthority("ROLE_COACH"));
					authorities.add(new SimpleGrantedAuthority("ROLE_CLUB"));
				}
			}
			return new UsernamePasswordAuthenticationToken(user, password, authorities);
		}
		throw new BadCredentialsException("Failed to authenticate user");
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
