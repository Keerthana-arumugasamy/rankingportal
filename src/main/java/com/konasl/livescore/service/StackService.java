package com.konasl.livescore.service;

import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.entity.Stack;

import java.util.List;

public interface StackService {
      List<Stack> getAllStack();
      Stack saveStack(StackRequest stackRequest);
}

