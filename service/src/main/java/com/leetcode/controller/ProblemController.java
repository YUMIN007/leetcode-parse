package com.leetcode.controller;

import com.leetcode.model.response.APIResponse;
import com.leetcode.service.ProblemService;
import com.leetcode.service.impl.ProblemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProblemController {

    private final ProblemServiceImpl problemService;

    @Autowired
    public ProblemController(ProblemServiceImpl problemService) {
        this.problemService = problemService;
    }

    @RequestMapping(path = "/problems/detail", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> getProblem(String titleSlug) {
        APIResponse res = problemService.getProblem(titleSlug);
        return ResponseEntity.status(res.getCode()).body(res);
    }

    @RequestMapping(path = "/problems", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> getAllProblems() {
        APIResponse res = problemService.getAllProblems();
        return ResponseEntity.status(res.getCode()).body(res);
    }

    @RequestMapping(path = "/problems/top100", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> getTopLikedProblems() {
        APIResponse res = problemService.getTopLikedProblems();
        return ResponseEntity.status(res.getCode()).body(res);
    }

    @RequestMapping(path = "/problems/interview", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> getInterviewProblems() {
        APIResponse res = problemService.getInterviewProblems();
        return ResponseEntity.status(res.getCode()).body(res);
    }

    @RequestMapping(path = "/tags", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> getTags() {
        APIResponse res = problemService.getTags();
        return ResponseEntity.status(res.getCode()).body(res);
    }

    @RequestMapping(value = "/problems/filtration/{key}", method = RequestMethod.GET)
    public ResponseEntity<APIResponse> filterProblems(@PathVariable("key") String key) {
        APIResponse res = problemService.filterProblems(key);
        return ResponseEntity.status(res.getCode()).body(res);
    }

}
