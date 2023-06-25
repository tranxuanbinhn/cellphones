package com.cellphones.api.admin;

import com.cellphones.api.output.Output;
import com.cellphones.dto.UserDTO;
import com.cellphones.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class UserAPI {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/api-user")
    public Output<UserDTO> showviews(@RequestParam("page") int page,
                                     @RequestParam("limit") int limit)
    {
        Output<UserDTO> userDTOOutput = new Output<>();
        Pageable pageable = PageRequest.of(page-1,limit);
        userDTOOutput.setListResult(userService.findAll(pageable));
        userDTOOutput.setTotalPage((int) Math.ceil(userService.countPage()/limit));
        userDTOOutput.setPage(page);

    return userDTOOutput;
    }
   @PutMapping(value = "/api-user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") long id)
    {
        userDTO.setId(id);
        return userService.save(userDTO);
    }
    @DeleteMapping(value = "/api-user")
    public void DeleteUser(@RequestBody List<Long> ids)
    {
        userService.Delete(ids);
    }
    @PostMapping(value = "/api/auth/add-user")
    public UserDTO addUser(@RequestBody UserDTO userDTO)
    {
        return userService.save(userDTO);
    }

}
