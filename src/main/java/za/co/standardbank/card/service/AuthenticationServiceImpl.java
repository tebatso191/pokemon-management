package za.co.standardbank.card.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import za.co.standardbank.card.dto.request.AuthenticationDTO;
import za.co.standardbank.card.dto.response.AuthenticatedDTO;
import za.co.standardbank.card.model.User;
import za.co.standardbank.card.repository.UserRepository;
import za.co.standardbank.card.util.JwtUtil;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository repository;

    @Override
    public AuthenticatedDTO authenticateUser(AuthenticationDTO authenticationDTO) throws Exception {
        new UsernamePasswordAuthenticationToken(authenticationDTO.getUserName(), authenticationDTO.getPassword());
        String generateToken = jwtUtil.generateToken(authenticationDTO.getUserName());
        if (StringUtils.hasText(generateToken)) {
            return AuthenticatedDTO.builder()
                    .token(generateToken)
                    .build();
        } else {
            log.warn("Error Occurred.Could Not Validate The Token.");
            throw new Exception("Error Occurred. Could Not Authenticate the user");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUserName(username);
        if (Objects.nonNull(user)) {
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Username : ".concat(username).concat("Not Found In Our Database."));
        }
    }
}
