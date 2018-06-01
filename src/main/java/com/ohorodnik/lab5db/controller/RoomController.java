package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Room;
import com.ohorodnik.lab5db.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    //@Autowired
    //impls organizationService;

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/get")
    public List<Room> getRoom()  {
        //return organizationService.getRooms();
        return roomRepository.findAll();
    }

    @PostMapping("/insert")
    public Room insertRoom(@RequestBody Room organization){
        //return organizationService.insertRoom(organization);
        return roomRepository.save(organization);
    }
    @RequestMapping("/update")
    public Room updateRoom(@RequestBody Room organization,@RequestParam("id")int id)  {
        organization.setIdRoom(id);
        return roomRepository.save(organization);
        //return organizationService.updateRoom(organization);
    }

    @RequestMapping("/del")
    public void deleteRoom(@RequestParam("id")int id)  {
        //organizationService.deleteRoom(id);
        roomRepository.deleteById(id);
    }
}
