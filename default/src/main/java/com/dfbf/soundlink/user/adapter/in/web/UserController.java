package com.dfbf.soundlink.user.adapter.in.web;

import com.dfbf.soundlink.user.adapter.in.web.dto.request.UserSignReqDto;
import com.dfbf.soundlink.user.application.port.in.CreateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "User API", description = "유저 관련 API")
@RequestMapping("/api/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "일반회원은 Type이 NONE, 나머지는 알맞게 작성해주세요. (대문자로)")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserSignReqDto dto) {
        var response = createUserUseCase.createUser(dto.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
