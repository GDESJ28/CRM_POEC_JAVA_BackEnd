package com.Certif.SlackLike.repository;

import com.Certif.SlackLike.model.Channel;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {


}
