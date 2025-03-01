package com.m0wn1la.app2.service;

import com.m0wn1la.app2.dto.PostedDataDTO;
import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.exception.InvalidDetailsByUserException;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.exception.TheUpdaterException;
import com.m0wn1la.app2.mapper.PostDataMapper;
import com.m0wn1la.app2.model.EndPoint;
import com.m0wn1la.app2.model.PostedData;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.PostedDataRepository;
import com.m0wn1la.app2.request.PostDataRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PostedService {
    private final PostedDataRepository postedDataRepository;
    private final EndPointService endPointService;
    private final UserService userService;
    private final PostDataMapper postDataMapper;

    public PostedDataDTO createPost(PostDataRequest request) throws TheUpdaterException {
        try {
            EndPoint endPoint = endPointService.getEndPointByName(request.getEndpoint());
            User user = userService.getUserById(request.getUserId());
            PostedData postedData = new PostedData();
            postedData.setPostedBy(user);
            postedData.setPostData(request.getPostData());
            postedData.setTags(request.getTags());
            postedData.setEndPoint(endPoint);
            postedData = postedDataRepository.save(postedData);
            return postDataMapper.postDataToPostedDataDTO(postedData);
        } catch (ResourceNotFoundException e) {
            throw new InvalidDetailsByUserException("The provided endPoint does not exist please check once" + e.getCause());
        }
    }

    public Page<PostedDataDTO> findAllPostedData(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<PostedData> allPostedData = postedDataRepository.findAll(pageable);
        return allPostedData.map(postDataMapper::postDataToPostedDataDTO);

    }

    public PostedData getPostDataById(Long id) {
        return postedDataRepository.getById(id);
    }

    public PostedDataDTO updatePostedData(Long endPointId, PostDataRequest request) {
        PostedData postedData = postedDataRepository.getById(endPointId);
        postedData.setPostData(request.getPostData());
        postedData.setTags(request.getTags());
        postedData = postedDataRepository.save(postedData);
       return postDataMapper.postDataToPostedDataDTO(postedData);
    }

    public void deletePostById(Long postId) {
        postedDataRepository.deleteById(postId);
    }
}
