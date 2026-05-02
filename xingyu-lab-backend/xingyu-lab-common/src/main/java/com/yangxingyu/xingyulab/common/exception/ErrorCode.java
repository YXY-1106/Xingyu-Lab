package com.yangxingyu.xingyulab.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未登录或登录已过期"),
    FORBIDDEN(403, "无权限访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_ERROR(500, "服务器内部错误"),

    // 用户相关 1001-1099
    USER_NOT_FOUND(1001, "用户不存在"),
    USER_PASSWORD_ERROR(1002, "密码错误"),
    USER_DISABLED(1003, "用户已被禁用"),
    USER_EXISTS(1004, "用户已存在"),

    // 文章相关 2001-2099
    ARTICLE_NOT_FOUND(2001, "文章不存在"),
    ARTICLE_ALREADY_PUBLISHED(2002, "文章已发布"),

    // 文件相关 3001-3099
    FILE_UPLOAD_FAIL(3001, "文件上传失败"),
    FILE_NOT_FOUND(3002, "文件不存在"),
    FILE_TYPE_NOT_ALLOWED(3003, "文件类型不允许"),
    FILE_SIZE_EXCEED(3004, "文件大小超出限制");

    private final int code;
    private final String message;
}
