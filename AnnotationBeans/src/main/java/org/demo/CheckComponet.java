package org.demo;

import org.springframework.stereotype.Component;

@Component
public class CheckComponet {


    public CheckComponet() {   // This bean is not create because in applicationconfig.xml we we gave ref path fro org.springTurials
        System.out.println("This is the CheckComponent Bean");
    }
}
