package webstore.service;

import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import webstore.domain.Worker;

public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private WorkerService workerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 * User data to compare from databases
		 */
		Worker user = workerService.selectOne(username);

		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
			builder.roles(user.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}
