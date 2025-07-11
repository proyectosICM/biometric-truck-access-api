package com.icm.biometric_truck_access_api.services;

import com.icm.biometric_truck_access_api.dto.UserDTO;
import com.icm.biometric_truck_access_api.models.UserModel;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    List<UserModel> syncUsers(List<UserDTO> users);
    UserModel createUser(UserDTO userDTO);
    UserModel updateUser(Long id, UserDTO updatedUser);
    void deleteUser(Long id);

    // Extra (opcional): exportar formato compatible con dispositivo
    // SetUserInfoRequestDTO exportAllUsersForDevice();
}
