package za.co.standardbank.card.service;

import za.co.standardbank.card.dto.request.AuthenticationDTO;
import za.co.standardbank.card.dto.response.AuthenticatedDTO;
import za.co.standardbank.card.exception.CustomException;

public interface AuthenticationService {
    AuthenticatedDTO authenticateUser(AuthenticationDTO authenticationDTO) throws CustomException;
}
