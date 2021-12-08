package com.simplemoment.common.util;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Slf4j
public class FutureUtil {

    public static List mergeFutureResult(List<Future> futures) {
        return (List)
                futures.stream()
                        .flatMap(
                                future -> {
                                    try {
                                        return ((List) future.get()).stream();
                                    } catch (Exception e) {
                                        log.error("Future execute error", e);
                                        return null;
                                    }
                                })
                        .collect(Collectors.toList());
    }
}