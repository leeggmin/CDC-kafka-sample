package winitech.practice.system.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import winitech.practice.system.domain.user.dto.UserReq;
import winitech.practice.system.domain.user.service.UserService;
import winitech.practice.system.global.response.Response;
import winitech.practice.system.global.response.ResponseData;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Response generate(@RequestBody @Valid UserReq userReq) {
        userService.generate(userReq);
        return Response.of(HttpStatus.OK, "유저 등록 성공");
    }

    @PatchMapping("/{id}")
    public Response update(@PathVariable long id, @RequestBody UserReq userReq) {
        userService.update(id, userReq);
        return ResponseData.of(HttpStatus.OK, "유저 정보 수정 성공");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseData.of(HttpStatus.OK, "유저 삭제 성공");
    }
}
