package com.leetcode.service;

import com.leetcode.model.response.APIResponse;

public interface LoginService {
    APIResponse login(String username, String pwd);
}
