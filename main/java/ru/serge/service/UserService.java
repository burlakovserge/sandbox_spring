package ru.serge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.serge.entity.User;
import ru.serge.enums.Role;
import ru.serge.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User setAdmin(Long userId) {
        User user = userRepository.findById(userId).get();
        user.getRoles().add(Role.ADMIN);
        return userRepository.save(user);
    }
}
