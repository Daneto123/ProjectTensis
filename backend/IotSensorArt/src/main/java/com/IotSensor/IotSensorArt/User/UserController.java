package com.IotSensor.IotSensorArt.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
@RestController
public class UserController {
    protected Logger logger = Logger.getLogger(UserData.class.getName());

    /*@GetMapping("/users/{username}")
    public UserData findByUsername(@PathVariable("username") String username) {
        logger.info(String.format("UserData.findByUsername(%s)", username));
        return (UserData) repository.findByUsername(username);
    }

    @GetMapping("/users")
    public List<UserData> findAll() {
        logger.info(String.format("Person.findAll()"));
        return (List<UserData>) repository.findAll();
    }

    @PutMapping("/users/update")
    public UserData update(@RequestBody UserData user) {
        logger.info(String.format("Person.update(%s)", user.getUsername()));
        return repository.save(user);
    }

    @DeleteMapping("/users/remove/{id}")
    public void remove(@PathVariable("username") String username) {
        logger.info(String.format("Person.remove(%s)", username));
        repository.deleteByUsername(username);
    }

    @GetMapping("/newSensor/{namepi}")
    public UserData findByUsername(@PathVariable("username") String username) {
        logger.info(String.format("UserData.findByUsername(%s)", username));
        return (UserData) repository.findByUsername(username);
    }

    @GetMapping("/sensors/{namepi}")
    public UserData findByUsername(@PathVariable("username") String username) {
        logger.info(String.format("UserData.findByUsername(%s)", username));
        return (UserData) repository.findByUsername(username);
    }*/

}
