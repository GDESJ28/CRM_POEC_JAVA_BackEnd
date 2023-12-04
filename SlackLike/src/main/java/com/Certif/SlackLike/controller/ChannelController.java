package com.Certif.SlackLike.controller;


import com.Certif.SlackLike.model.Channel;
import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("channels")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @GetMapping
    public ResponseEntity<?> getAllChannels() {
        if (channelService.getAllChannels().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(channelService.getAllChannels());
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getChannelById(@PathVariable("id") Integer id){
        for(Channel c : channelService.getAllChannels()){
            if(c.getId().equals(id))
                return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(404).body("Channel with ID " + id + " not found");
    }



    @PostMapping
    public ResponseEntity<Channel> addChannel(@RequestBody Channel newChannel){
        channelService.createChannel(newChannel);
        return ResponseEntity.ok(newChannel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChannel(@PathVariable("id") Integer id){
        if(channelService.getChannelById(id).isEmpty()){
            return ResponseEntity.status(404).body("Channel with 'ID " + id + " not found");
        }else{
            channelService.deleteChannel(id);
            return ResponseEntity.ok("ok");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateChannel(@RequestBody Channel channel, @PathVariable("id") Integer id){
        if (channel.getId() == null){
            return ResponseEntity.badRequest().body("Request Error : Missing Channel identifier");
        }
        if (!channel.getId().equals(id)){
            return ResponseEntity.badRequest().body("Identifier values are different");
        }
        return ResponseEntity.ok(channelService.updateChannel( channel));

    }




}