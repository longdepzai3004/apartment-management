package vn.io.nghlong3004.apartment_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import vn.io.nghlong3004.apartment_management.model.dto.UserDto;
import vn.io.nghlong3004.apartment_management.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto getProfile(@Min(1) @PathVariable Long id) {
		return userService.getUser(id);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateProfile(@Min(1) @PathVariable Long id, @Valid @RequestBody UserDto userDto) {
		userService.updateUser(id, userDto);
	}
    @DeleteMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@Min(1) @PathVariable Long id) {
        userService.delete(id);
    }


}
