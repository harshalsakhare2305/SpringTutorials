package org.springboottutorials.service.classes;

import org.springboottutorials.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class IServicesImpl implements IService {

    private LocalTime time;

    @Autowired
    public void setTime(LocalTime time) {
        this.time = time;
    }


    @Override
    public String getProperGreeting() {
        int t = time.getHour();

        if(t<12)return "Good Morning";
        else if(t<17) return "Good Afternoon";
        else  if(t<21) return "Good Evening";
        else return "Good Night";
    }
}
