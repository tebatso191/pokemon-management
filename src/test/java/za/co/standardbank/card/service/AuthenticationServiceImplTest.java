package za.co.standardbank.card.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.standardbank.card.dto.request.AuthenticationDTO;
import za.co.standardbank.card.dto.response.AuthenticatedDTO;
import za.co.standardbank.card.model.User;
import za.co.standardbank.card.repository.UserRepository;
import za.co.standardbank.card.util.JwtUtil;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {
    @Mock
    private JwtUtil jwtUtil;
    @Mock
    private UserRepository repository;
    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Test
    void authenticateUserTest_whenUserIsAuthenticated_returnsToken() throws Exception {
        AuthenticationDTO authenticationDTO = new AuthenticationDTO("user", "password");
        when(jwtUtil.generateToken(any(String.class))).thenReturn("some-token");
        AuthenticatedDTO authenticatedDTO = authenticationService.authenticateUser(authenticationDTO);
        assertEquals("some-token", authenticatedDTO.getToken());
    }

    @Test
    void authenticateUserTest_whenUserIsNotAuthenticated_throwsException() throws Exception {
        AuthenticationDTO authenticationDTO = new AuthenticationDTO("user", "password");
        when(jwtUtil.generateToken(any(String.class))).thenReturn(null);
        Exception exception = assertThrows(Exception.class, () -> {
            authenticationService.authenticateUser(authenticationDTO);
        });

        assertEquals("Error Occurred. Could Not Authenticate the user", exception.getMessage());
    }

    @Test
    void testLoadUserByUsername_Success() {
        // given
        User user = User.builder()
                .userName("username")
                .password("password")
                .build();
        when(repository.findByUserName("username")).thenReturn(user);
        // when
        Object actual = authenticationService.loadUserByUsername("username");
        // then
        assertNotNull(actual);
        assertEquals("username", ((org.springframework.security.core.userdetails.User) actual).getUsername());
    }
}
