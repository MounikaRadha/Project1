package com.m0wn1la.app2.service;

import com.m0wn1la.app2.dto.EndPointDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.mapper.EndPointMapper;
import com.m0wn1la.app2.model.EndPoint;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.EndPointRepository;
import com.m0wn1la.app2.request.EndPointPostRequest;
import com.m0wn1la.app2.specification.EndPointSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EndPointService {
    private final EndPointRepository endPointRepository;
    private final EndPointMapper endPointMapper;
    private final UserService userService;

    public EndPointDTO createEndPoint(EndPointPostRequest request) throws ResourceNotFoundException {
        User owner = userService.getUserById(request.getUserId());
        EndPoint endPoint = new EndPoint();
        endPoint.setEndPoint(request.getEndPoint());
        endPoint.setOwnedBy(owner);
        endPoint = endPointRepository.save(endPoint);
        return endPointMapper.endPointToEndPointDTO(endPoint);
    }

    public Page<EndPointDTO> findAllEndPoints(int pageNumber, int pageSize) {
        log.info("thread name is in service " + Thread.currentThread().getName());
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<EndPoint> endPoints = endPointRepository.findAll(pageable);
        Page<EndPointDTO> endPointDTOS = endPoints.map(endPoint -> endPointMapper.endPointToEndPointDTO(endPoint));
        return endPointDTOS;
    }


    public User findOwner(Long endPointId) throws ResourceNotFoundException {
        EndPoint endPoint = endPointRepository.findById(endPointId).orElseThrow(() -> new ResourceNotFoundException("can t find endpoint with that id " + endPointId));
        return endPoint.getOwnedBy();
    }

    public EndPoint getEndPointById(Long id) throws ResourceNotFoundException {

        return endPointRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find end point resource with id:" + id));
    }

    public EndPoint getEndPointByName(String name) throws ResourceNotFoundException {
        return endPointRepository.findOne(EndPointSpecification.findByName(name)).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find endpoint with name:" + name));
    }

    public EndPointDTO updateEndPoint(Long endPointId, EndPointPostRequest request) throws ResourceNotFoundException {
        EndPoint endPoint = endPointRepository.findById(endPointId).orElseThrow(
                () -> new ResourceNotFoundException("Could not find end point with id: " + endPointId)
        );
        endPointMapper.mergeEndPointPostRequestToEndPoint(request, endPoint);
        endPointRepository.save(endPoint);
        return endPointMapper.endPointToEndPointDTO(endPoint);
    }

    public void deleteEndPoint(Long endPointId) {
        endPointRepository.deleteById(endPointId);
    }
}
