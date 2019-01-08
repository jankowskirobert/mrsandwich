package com.jvmless.mrsandwich.location.api;

import com.jvmless.mrsandwich.location.LocationFacade;
import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
class LocationHttpApi {

    @Autowired
    private LocationFacade locationFacade;

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public void modifyClientLocation(@RequestBody CurrentClientLocation currentClientLocation) {
        locationFacade.updateClientLocation(currentClientLocation);
    }
}
