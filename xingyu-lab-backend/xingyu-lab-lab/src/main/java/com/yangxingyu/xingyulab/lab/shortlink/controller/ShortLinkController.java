package com.yangxingyu.xingyulab.lab.shortlink.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.lab.shortlink.service.ShortLinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Tag(name = "短链服务")
@RestController
@RequestMapping("/api/lab/shortlink")
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    @Operation(summary = "生成短链")
    @PostMapping
    public R<String> create(@RequestParam String url) {
        return R.ok(shortLinkService.createShortLink(url));
    }

    @Operation(summary = "短链跳转")
    @GetMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        String url = shortLinkService.resolve(code);
        if (url != null) {
            response.sendRedirect(url);
        } else {
            response.sendError(404, "短链不存在");
        }
    }
}
