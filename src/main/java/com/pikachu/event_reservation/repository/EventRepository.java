package com.pikachu.event_reservation.repository;

import com.pikachu.event_reservation.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
                                                                    //검색 기능을 사용하기 위해 추가

}
