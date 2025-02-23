package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.config.PrivateURLConstants;
import com.m0wn1la.app2.dto.EndPointDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.mapper.EndPointMapper;
import com.m0wn1la.app2.request.EndPointPostRequest;
import com.m0wn1la.app2.service.EndPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PrivateURLConstants.ENDPOINTS)
public class EndPointController {
    private final EndPointService endPointService;
    private final EndPointMapper endPointMapper;

    @RequestMapping(method = RequestMethod.POST)
    public EndPointDTO createEndPoint(@RequestBody EndPointPostRequest request) throws ResourceNotFoundException {
        return endPointService.createEndPoint(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<EndPointDTO> index(@RequestParam(name = "page",required = false,defaultValue = "0") int pageNumber,
                                              @RequestParam(name = "size",required = false,defaultValue = "2") int pageSize) {
        return endPointService.findAllEndPoints(pageNumber,pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public EndPointDTO getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return endPointMapper.endPointToEndPointDTO(endPointService.getEndPointById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public EndPointDTO updateEndPointById(@PathVariable("id") Long endPointId, @RequestBody EndPointPostRequest request) throws ResourceNotFoundException {
        return endPointService.updateEndPoint(endPointId, request);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteEndPointById(@PathVariable("id") Long endPointId) throws ResourceNotFoundException {
        endPointService.deleteEndPoint(endPointId);
    }


}
