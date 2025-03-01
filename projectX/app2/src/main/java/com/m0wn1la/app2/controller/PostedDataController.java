package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.config.PrivateURLConstants;
import com.m0wn1la.app2.dto.EndPointDTO;
import com.m0wn1la.app2.dto.PostedDataDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.exception.TheUpdaterException;
import com.m0wn1la.app2.mapper.PostDataMapper;
import com.m0wn1la.app2.request.EndPointPostRequest;
import com.m0wn1la.app2.request.PostDataRequest;
import com.m0wn1la.app2.service.PostedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PrivateURLConstants.POST_DATA)
public class PostedDataController {
    private final PostedService postedService;
    private final PostDataMapper postDataMapper;
    @RequestMapping(method = RequestMethod.POST)
    public PostedDataDTO createPost(@RequestBody PostDataRequest request) throws TheUpdaterException {
        return postedService.createPost(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<PostedDataDTO> index(@RequestParam(name = "page",required = false,defaultValue = "0") int pageNumber,
                                   @RequestParam(name = "size",required = false,defaultValue = "2") int pageSize) {
        return postedService.findAllPostedData(pageNumber,pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public PostedDataDTO getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return postDataMapper.postDataToPostedDataDTO(postedService.getPostDataById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public PostedDataDTO updatePostedDataById(@PathVariable("id") Long endPointId, @RequestBody PostDataRequest request) throws ResourceNotFoundException {
        return postedService.updatePostedData(endPointId, request);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deletePostById(@PathVariable("id") Long postId) throws ResourceNotFoundException {
        postedService.deletePostById(postId);
    }

}
