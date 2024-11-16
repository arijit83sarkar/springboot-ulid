package com.raven.springboot_ulid.common.model;

public record AppApiResponse<T>(
        String code,
        T data,
        String message
) {
}
